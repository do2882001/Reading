/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Model.DTO.UserDTO;
import SQL.JPA.User;
import SQL.exceptions.NonexistentEntityException;
import Server.MappingDTOtoEntity;
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
 * @author Tudt
 */
public class UserJpaController implements Serializable {

    public UserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public UserJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(User user) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(User user) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            user = em.merge(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = user.getUserId();
                if (findUser(id) == null) {
                    throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
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
            User user;
            try {
                user = em.getReference(User.class, id);
                user.getUserId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> findUserEntities() {
        return findUserEntities(true, -1, -1);
    }

    public List<User> findUserEntities(int maxResults, int firstResult) {
        return findUserEntities(false, maxResults, firstResult);
    }

    private List<User> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(User.class));
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

    public User findUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<User> rt = cq.from(User.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public UserDTO login(String username, String pass) {
        EntityManager em = getEntityManager();
//        Query query = em.createNamedQuery("User.login");
        
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName and u.passWord = :passWord");
        query.setParameter("userName", username);
        query.setParameter("passWord", pass);
        List result = query.getResultList();
        
        System.out.println("So phan tu tim dc"+result.size());
        if (result.size()==1) {
            User u = new User();
            u = (User) query.getSingleResult();
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            UserDTO udto = new UserDTO();
            udto = mappingDTOtoEntity.userEnitytoDTO(u);
            return udto;
        }else return null;
    }
    public boolean checkInfoUser(String username, String phonenumber) {
        EntityManager em = getEntityManager();
//        Query query = em.createNamedQuery("User.login");
        
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName and u.phoneNumber = :phoneNumber");
//        ResultSet rs1 = query.executeQuery();
        query.setParameter("userName", username);
        query.setParameter("phoneNumber", phonenumber);
//        query.getResultList();
        List result = query.getResultList();
        System.out.println("So phan tu tim dc"+result.size());
        return result.size()==1;
    }
    public void changePassWord(String username, String phonenumber, String newpassword) throws NonexistentEntityException, Exception {
        
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName and u.phoneNumber = :phoneNumber");
        query.setParameter("phoneNumber",phonenumber );
        query.setParameter("userName", username);
        User user = (User) query.getSingleResult();
        user.setPassWord(newpassword);
        try {
            em.getTransaction().begin();
            user = em.merge(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//    public  UserDTO getInfoUserDTO(String user){
//        
//    }
}
