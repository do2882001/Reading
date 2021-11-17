/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import SQL.FeedbackJpaController;
import SQL.JPA.Feedback;
import SQL.JPA.User;
import SQL.UserJpaController;
import SQL.exceptions.NonexistentEntityException;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author Do_Do
 */
public class TestJPA {
    User ModelUsre(){
        LocalDate lDate ;
        lDate = java.time.LocalDate.now();
        java.util.Date date = java.sql.Date.valueOf(lDate);
        User user = new User();
        user.setUserName("addUserJPA");
        user.setPassWord("12345678");
        user.setRoleId(1);
        user.setAddress("JPA");
        user.setBirthdate(date);
        user.setGender("Male");
        user.setPhoneNumber("123456789");
        return user;
    }
    public static void main(String[] args) throws Exception {
//         //Test SignUp  
//         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
//         EntityManager em = emf.createEntityManager();
//        LocalDate lDate ;
//        lDate = java.time.LocalDate.now();
//        java.util.Date date = java.sql.Date.valueOf(lDate);
//        User user = new User();
//        user.setName("JPA");
//        user.setUserName("addUserJPA1");
//        user.setPassWord("12345678");
//        user.setRoleId(1);
//        user.setAddress("JPA");
//        user.setBirthdate(date);
//        user.setGender("Male");
//        user.setPhoneNumber("123456789");
//        em.getTransaction().begin();
//        em.persist(user);// persirt == insert into , merge = update , remove == delete
//        em.getTransaction().commit();
//        em.close();

        
        
        // update password
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName and u.passWord = :passWord");
//        query.setParameter("passWord", "123456789");
//        query.setParameter("userName", "do123456");
//        User user = (User) query.getSingleResult();
//        user.setPassWord("123123123");
//        try {
//            em.getTransaction().begin();
//            user = em.merge(user);
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
        
        
        
        
        
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName and u.passWord = :passWord");
//        query.setParameter("passWord", "123456789");
//        query.setParameter("userName", "do123456");
//        
//        User u = (User) query.getSingleResult();
//        u.setPassWord("123123123");
//        
//        UserJpaController ujc = new UserJpaController();
//        ujc.edit(u);
        
       
        
//        ujc.changePassWord("123456789", "do123456");
        
//        MappingDTOtoEntity mappingDTOtoEntity =new MappingDTOtoEntity();
//        User u = MappingDTOtoEntity.userDTOtoUser(udto);
//        System.out.println(u.getPassWord());
//        UserJpaController ucs = new UserJpaController();
//        ucs.edit(u);
//        em.close();

        //         //Test SignUp  
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
         EntityManager em = emf.createEntityManager();
         
        Feedback fbFeedback = new Feedback();
        
        fbFeedback.setContent("Alo bro");
        fbFeedback.setUserId(22);
        
        em.getTransaction().begin();
        em.persist(fbFeedback);// persirt == insert into , merge = update , remove == delete
        em.getTransaction().commit();
        em.close();
    }
}



















