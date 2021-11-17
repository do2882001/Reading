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
import SQL.FeedbackJpaController;
import SQL.JPA.Feedback;
import SQL.JPA.User;
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

    @Override
    public UserDTO login(String username, String pass) throws RemoteException {
        UserJpaController ujc = new UserJpaController(emf);
        UserDTO udto = new UserDTO();
        udto = ujc.login(username, pass);
        if (udto != null) {
            return udto;
        }else return null;
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
        UserJpaController ujc = new UserJpaController(emf);
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName");
        query.setParameter("userName", userDTO.getName());

        MappingDTOtoEntity mde = new MappingDTOtoEntity();
        User u = mde.userDTOtoUser(userDTO);
        System.out.println(u.getPassWord()+" Pass");
        if (query.getResultList().isEmpty()) {
            System.out.println("Heloo");
            em.getTransaction().begin();
            em.persist(u);// persirt == insert into , merge = update , remove == delete
            em.getTransaction().commit();
            em.close();
            return true;
        } else {
            return false;
        }
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
        } else {
            return false;
        }
    }

    @Override
    public void reComment(String username, String content) throws RemoteException {
        FeedbackJpaController fjc = new FeedbackJpaController();
        
        //fjc.edit(feedback);
    }

    @Override
    public void addBookToListFavorite() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeBookFromListFavorite() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeInfo(UserDTO udto) throws RemoteException {
        System.out.println(udto.getPhoneNumber());
        UserJpaController ujc = new UserJpaController();
        MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
        User u = mappingDTOtoEntity.userDTOtoUser(udto);
        System.out.println(u.getPhoneNumber()+"Sdt");
        try {
            ujc.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendFeedBack(int UserId, String Content) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
         EntityManager em = emf.createEntityManager();
         
        Feedback fbFeedback = new Feedback();
        
        fbFeedback.setContent(Content);
        fbFeedback.setUserId(UserId);
        
        em.getTransaction().begin();
        em.persist(fbFeedback);// persirt == insert into , merge = update , remove == delete
        em.getTransaction().commit();
        em.close();
    }
}
