/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.DTO.*;


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
import Model.SQL.BookControllerSQL;
import SQL.BookJpaController;
import SQL.FeedbackJpaController;
import SQL.JPA.Author;
import SQL.JPA.Book;
import SQL.JPA.Feedback;
import SQL.JPA.Listfavorite;
import SQL.JPA.User;
import SQL.ListfavoriteJpaController;
import com.sun.org.apache.bcel.internal.generic.FALOAD;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
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

    public boolean addNewbook(BookDTO dTO) throws RemoteException// add thanh cong tra ve bookdto, that bai tra ve null
    {   
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.bookName = :bookName");
        query.setParameter("bookName", dTO.getBookName());
        List l = query.getResultList();
        if (l.size()<1) {
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            Book book = mappingDTOtoEntity.bookDTOtoEntity(dTO);

            BookJpaController bjc = new BookJpaController(emf);
            System.out.println("Name : " +  book.getBookName());
            bjc.create(book);
       
        return true;
        }else return false;
    }

    public BookDTO editbook(BookDTO dTO) throws RemoteException// add thanh cong tra ve bookdto, that bai tra ve null
    {
//        try {
//            BookJpaController bjc = new BookJpaController(emf);
//            Book book = MappingDTOtoEntity.bookDTOtoEntity(dTO);
//            Book b = bjc.edit(book);
//            BookDTO bdto = MappingDTOtoEntity.bookEnitytoDTO(b);
//            //gọi JPA
//            return bdto;
//        } catch (Exception ex) {
//            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
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
        query.setParameter("userName", userDTO.getUsername());
        System.out.println(userDTO.getUsername());
        MappingDTOtoEntity mde = new MappingDTOtoEntity();
        User u = mde.userDTOtoUser(userDTO);
        
        if (query.getResultList().size() == 0) {
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
       
    }

    @Override
    public boolean addBookToListFavorite(BookDTO bdto, int userId) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT l FROM Listfavorite l WHERE l.bookId = :bookId");
        query.setParameter("bookId", bdto.getBookId());
        java.util.List<Listfavorite> favorites = query.getResultList();
        boolean flag = false;
        for (Listfavorite l : favorites) {
            if (l== null || l.getUserId() != userId) {
                Listfavorite listfavorite = new Listfavorite();
                listfavorite.setBookId(bdto.getBookId());
                listfavorite.setUserId(userId);
                ListfavoriteJpaController ljc = new ListfavoriteJpaController(emf);
                ljc.create(listfavorite);
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void removeBookFromListFavorite() throws RemoteException {
        
    }

    @Override
    public void changeInfo(UserDTO udto) throws RemoteException {
        System.out.println("Id : "+udto.getId());
        UserJpaController ujc = new UserJpaController(emf);
        MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
        User u = mappingDTOtoEntity.userDTOtoUser(udto);
        
        try {
            ujc.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendFeedBack(int UserId, String Content , LocalDate localDate) throws RemoteException {
         EntityManager em = emf.createEntityManager();
         
        Feedback fbFeedback = new Feedback();
        Date date = java.util.Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        fbFeedback.setContent(Content);
        fbFeedback.setUserId(UserId);
        fbFeedback.setFeedBackDate(date);
        em.getTransaction().begin();
        em.persist(fbFeedback);// persirt == insert into , merge = update , remove == delete
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List historyFeedback(int userId) throws RemoteException {
        EntityManager em = emf.createEntityManager();
         
        Query query = em.createQuery("SELECT f FROM Feedback f WHERE f.userId = :userId");
        query.setParameter("userId", userId);
        
        java.util.List<Feedback> listhistoryFeedback = query.getResultList();
        
        java.util.List<FeedbackDTO> list = new ArrayList();
        for (Feedback entity : listhistoryFeedback) {
            FeedbackDTO fbDTO= new FeedbackDTO();
            fbDTO.setFeedBackDate(entity.getFeedBackDate());
            fbDTO.setDescription(entity.getDescription());
            fbDTO.setContent(entity.getContent());
            fbDTO.setUserId(entity.getUserId());
            fbDTO.setFeedBackId(entity.getFeedBackId());
            list.add(fbDTO);
        }
        return list;
    }

    @Override
    public java.util.List loadListFavorite(int userId) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT l FROM Listfavorite l WHERE l.userId = :userId");
        query.setParameter("userId", userId);
        java.util.List<Listfavorite> favorites = query.getResultList();
        java.util.List<BookDTO> list = new ArrayList();
        for (Listfavorite l : favorites) {
            System.out.println("Liss" + l.getBookId());
            
            Query query1 = em.createQuery("SELECT b FROM Book b WHERE b.bookId = :BookId");
            query1.setParameter("BookId", l.getBookId());
            Book b = (Book) query1.getSingleResult();
            
            Query query2 = em.createQuery("SELECT a FROM Author a WHERE a.authorId = :authorId");
            query2.setParameter("authorId", b.getAuthorId());
            Author a = (Author) query2.getSingleResult();
            
            BookDTO bdto = new BookDTO();
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            bdto = mappingDTOtoEntity.bookEnitytoDTO(b);
            bdto.setAuthorName(a.getAuthorName());
            
            
            list.add(bdto);
            System.out.println("Name "+bdto.getBookName());
        }
        
        return list;
    }

    @Override
    public BookDTO searchBookDTO(String bookName) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.bookName = :bookName");
        query.setParameter("bookName", bookName);
        List l = query.getResultList();
        if (l.size() == 1 ) {
            Book b = new Book();
            b = (Book) query.getSingleResult();
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            BookDTO bookdto = mappingDTOtoEntity.bookEnitytoDTO(b);
            return bookdto;
        }else return null;
    }

    @Override
    public void changePassWord(int UserId, String PassWord) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userId = :UserId");
        query.setParameter("UserId",UserId);
        User u = (User) query.getSingleResult();
        u.setPassWord(PassWord);
        System.out.println("NewPass: "+ u.getPassWord() + "Id: "+u.getUserId());
        
        UserJpaController ujc = new UserJpaController(emf);
        try {
            ujc.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
