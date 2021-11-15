/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.DTO.*;

import SQL.BookJpaController;
import SQL.JPA.Book;
import SQL.UserJpaController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Admin.InterfaceAdmin.IReading;
import Model.DTO.UserDTO;
import javax.persistence.Query;

/**
 *
 * @author Do_Do
 */
public class API_Controller extends UnicastRemoteObject implements IReading {

    EntityManagerFactory emf;

    API_Controller() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("ReadingJPA");
    }

    @Override
    public int tinhTong(int a, int b) throws RemoteException {
        System.out.println("goi ham tinh tong");
        return a + b;
    }

    public boolean login(String username, String pass) throws RemoteException {
        UserJpaController ujc = new UserJpaController(emf);
        System.out.println("dang login");
        return ujc.login(username, pass);
    }

    public BookDTO addNewbook(BookDTO dTO) throws RemoteException// add thanh cong tra ve bookdto, that bai tra ve null
    {
        BookJpaController bjc = new BookJpaController(emf);
        Book book = MappingDTOtoEntity.bookDTOtoEntity(dTO);
        Book b = bjc.create(book);
        BookDTO bdto = MappingDTOtoEntity.bookEnitytoDTO(b);
        //gọi JPA
        return bdto;
    }

    public BookDTO editbook(BookDTO dTO) throws RemoteException// add thanh cong tra ve bookdto, that bai tra ve null
    {
        try {
            BookJpaController bjc = new BookJpaController(emf);
            Book book = MappingDTOtoEntity.bookDTOtoEntity(dTO);
            Book b = bjc.edit(book);
            BookDTO bdto = MappingDTOtoEntity.bookEnitytoDTO(b);
            //gọi JPA
            return bdto;
        } catch (Exception ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Project2_Server_jar_1.0PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean signup(UserDTO userDTO) throws RemoteException {
        System.out.println("Heloo");
        UserJpaController ujc = new UserJpaController(emf);
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName");
        query.setParameter("userName", userDTO.getName());
        
        if (query.getResultList().isEmpty()) {
            return false;
        }else{
            em.getTransaction().begin();
            em.persist(userDTO);// persirt == insert into , merge = update , remove == delete
            em.getTransaction().commit();
            em.close();
            return true;
        }
        
        
        
        
//        em.getTransaction().begin();
//        em.persist(userDTO);// persirt == insert into , merge = update , remove == delete
//        em.getTransaction().commit();
//        em.close();
    }

    @Override
    public boolean forgotPassWord_Change(String username, String phonenumber, String newpassword) throws RemoteException {
        UserJpaController ujc = new UserJpaController(emf);
        EntityManager em = emf.createEntityManager();
        if (ujc.checkInfoUser(username, phonenumber)) {
            System.out.println("Dang doi mat khau");
            try {
                ujc.changePassWord(username, phonenumber, newpassword);
            } catch (Exception ex) {
                Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }else return false;
    }
}
