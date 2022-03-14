/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Listfavorite;
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
public class ListfavoriteJpaController implements Serializable {

    public ListfavoriteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Listfavorite listfavorite) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(listfavorite);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Listfavorite listfavorite) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            listfavorite = em.merge(listfavorite);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = listfavorite.getDescription();
                if (findListfavorite(id) == null) {
                    throw new NonexistentEntityException("The listfavorite with id " + id + " no longer exists.");
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
            Listfavorite listfavorite;
            try {
                listfavorite = em.getReference(Listfavorite.class, id);
                listfavorite.getDescription();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listfavorite with id " + id + " no longer exists.", enfe);
            }
            em.remove(listfavorite);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Listfavorite> findListfavoriteEntities() {
        return findListfavoriteEntities(true, -1, -1);
    }

    public List<Listfavorite> findListfavoriteEntities(int maxResults, int firstResult) {
        return findListfavoriteEntities(false, maxResults, firstResult);
    }

    private List<Listfavorite> findListfavoriteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Listfavorite.class));
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

    public Listfavorite findListfavorite(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Listfavorite.class, id);
        } finally {
            em.close();
        }
    }

    public int getListfavoriteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Listfavorite> rt = cq.from(Listfavorite.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
