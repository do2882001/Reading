/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;



import Model.DTO.FeedbackDTO;
import SQL.JPA.Feedback;
import SQL.JPA.Listfavorite;
import SQL.JPA.User;
import SQL.UserJpaController;
import java.awt.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
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
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName and u.passWord = :passWord");
//        query.setParameter("passWord", "12345678");
//        query.setParameter("userName", "do123456");
//        
//        User u = (User) query.getSingleResult();
//        u.setPassWord("123123123");
//        
//        UserJpaController ujc = new UserJpaController(emf);
//        ujc.edit(u);
        
       
        
//        ujc.changePassWord("123456789", "do123456");
        
//        MappingDTOtoEntity mappingDTOtoEntity =new MappingDTOtoEntity();
//        User u = MappingDTOtoEntity.userDTOtoUser(udto);
//        System.out.println(u.getPassWord());
//        UserJpaController ucs = new UserJpaController();
//        ucs.edit(u);
//        em.close();

//        //         //Test SignUp  
//         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
//         EntityManager em = emf.createEntityManager();
//         
//        Feedback fbFeedback = new Feedback();
//        
//        fbFeedback.setContent("Alo bro");
//        fbFeedback.setUserId(22);
//        
//        em.getTransaction().begin();
//        em.persist(fbFeedback);// persirt == insert into , merge = update , remove == delete
//        em.getTransaction().commit();
//        em.close();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
//         EntityManager em = emf.createEntityManager();
//         Query query = em.createQuery("SELECT l FROM Listfavorite l  WHERE l.userId = :userId");
//         query.setParameter("userId", 22);
//         java.util.List l = query.getResultList();
//        Listfavorite category = (Listfavorite) l.get(1);
//        System.out.println(category.getBookId());
        


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("SELECT l FROM Listfavorite l  WHERE l.userId = :userId");
//        query.setParameter("userId", 22);
//        java.util.List l = query.getResultList();
//        //Listfavorite category = (Listfavorite) l.get(1);
//       
//        for (int i = 0; i < l.size(); i++) {
//            Listfavorite listfavorite = (Listfavorite) l.get(i);
//           
//            System.out.println(listfavorite.getBookId());
//        }

       
        
//        
//        Feedback listhistoryFeedback = (Feedback) query.getResultList();
//        List listFbDTOs = new List();
//        
//        
//        for (Feedback fb : listhistoryFeedback) {
//            FeedbackDTO feedbackDTO = mappingDTOtoEntity.feedbacktoFeedbackDto(fb);
//            listFbDTOs.add(feedbackDTO);
//            System.out.println("Feedback userId = 0 :" + feedbackDTO.getContent());
//        }
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
//        EntityManager em = emf.createEntityManager();
//         
//        Query query = em.createQuery("SELECT f FROM Feedback f WHERE f.userId = :userId");
//        query.setParameter("userId", 1);
//        
//        java.util.List<Feedback> listhistoryFeedback = query.getResultList();
//        
//        java.util.List<FeedbackDTO> list = new ArrayList();
//        for (Feedback entity : listhistoryFeedback) {
//            FeedbackDTO fbDTO= new FeedbackDTO();
//            fbDTO.setFeedBackDate(entity.getFeedBackDate());
//            fbDTO.setDescription(entity.getDescription());
//            fbDTO.setContent(entity.getContent());
//            fbDTO.setUserId(entity.getUserId());
//            fbDTO.setFeedBackId(entity.getFeedBackId());
//            boolean add = list.add(fbDTO);
//        }
//        for (FeedbackDTO fb : list) {
//            System.out.println("Content: " + fb.getContent() );
//        }
    }
}



















