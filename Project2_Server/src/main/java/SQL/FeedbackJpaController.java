/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import SQL.JPA.Feedback;
import SQL.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Do_Do
 */
public class FeedbackJpaController implements Serializable {

    public FeedbackJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public FeedbackJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Feedback feedback) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(feedback);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Feedback feedback) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            feedback = em.merge(feedback);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = feedback.getFeedBackId();
                if (findFeedback(id) == null) {
                    throw new NonexistentEntityException("The feedback with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Feedback feedback;
            try {
                feedback = em.getReference(Feedback.class, id);
                feedback.getFeedBackId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The feedback with id " + id + " no longer exists.", enfe);
            }
            em.remove(feedback);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Feedback> findFeedbackEntities() {
        return findFeedbackEntities(true, -1, -1);
    }

    public List<Feedback> findFeedbackEntities(int maxResults, int firstResult) {
        return findFeedbackEntities(false, maxResults, firstResult);
    }

    private List<Feedback> findFeedbackEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Feedback.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Feedback findFeedback(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Feedback.class, id);
        } finally {
            em.close();
        }
    }

    public int getFeedbackCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Feedback> rt = cq.from(Feedback.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
