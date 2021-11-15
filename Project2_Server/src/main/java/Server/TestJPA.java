/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import SQL.JPA.User;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


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
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
        EntityManager em = emf.createEntityManager();
         //Test SignUp  
        LocalDate lDate ;
        lDate = java.time.LocalDate.now();
        java.util.Date date = java.sql.Date.valueOf(lDate);
        User user = new User();
        user.setName("JPA");
        user.setUserName("addUserJPA1");
        user.setPassWord("12345678");
        user.setRoleId(1);
        user.setAddress("JPA");
        user.setBirthdate(date);
        user.setGender("Male");
        user.setPhoneNumber("123456789");
        em.getTransaction().begin();
        em.persist(user);// persirt == insert into , merge = update , remove == delete
        em.getTransaction().commit();
        em.close();
        System.out.println(user.getBirthdate());



//        List l = nq.getResultList();
//        System.out.println("List size: " + l.size());
    }
}



















