/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.MappingDTOtoEntity;
import Model.DTO.*;


import Controller.UserJpaController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Admin.InterfaceAdmin.IReading;
import Model.DTO.UserDTO;
import Controller.BookJpaController;
import Controller.BookJpaController;
import Controller.FeedbackJpaController;
import Controller.FeedbackJpaController;
import Model.Author;
import Model.Book;
import Model.Feedback;
import Model.Listfavorite;
import Model.User;
import Controller.ListfavoriteJpaController;
import Controller.ListfavoriteJpaController;
import Controller.UserJpaController;
import SQL.exceptions.NonexistentEntityException;
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

    public BookDTO editbook(BookDTO dTO) throws RemoteException{
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
        boolean flag = true;
        for (Listfavorite l : favorites) {
            if (l.getBookId()==bdto.getBookId()) {
                flag = false;
                break;
            }
        }
        if (flag==true) {
            Listfavorite listfavorite = new Listfavorite();
            listfavorite.setBookId(bdto.getBookId());
            listfavorite.setUserId(userId);
            ListfavoriteJpaController ljc = new ListfavoriteJpaController(emf);
            ljc.create(listfavorite); 
        }
        return flag;
    }

    @Override
    public void removeBookFromListFavorite(int bookId , int userId) throws RemoteException {
        EntityManager em = emf.createEntityManager();
         
        Query query = em.createQuery("SELECT l FROM Listfavorite l WHERE l.userId = :userId AND l.bookId = :bookid");
        query.setParameter("userId", userId);
        query.setParameter("bookid", bookId);
        
        Listfavorite listfavorite = (Listfavorite) query.getSingleResult();
        ListfavoriteJpaController listfavoriteJpaController = new ListfavoriteJpaController(emf);
        try {
            listfavoriteJpaController.destroy(listfavorite.getDescription());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            
            Query query1 = em.createQuery("SELECT b FROM Book b WHERE b.bookId = :BookId ");
            query1.setParameter("BookId", l.getBookId());
            Book b = (Book) query1.getSingleResult();
            
            Query query2 = em.createQuery("SELECT a FROM Author a WHERE a.authorId = :authorId");
            query2.setParameter("authorId", b.getAuthorId());
            Author a = (Author) query2.getSingleResult();
            
            BookDTO bdto = new BookDTO();
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            bdto = mappingDTOtoEntity.bookEnitytoDTO(b);
            bdto.setAuthorName(a.getAuthorName());
            System.out.println(bdto.getAuthorName());
            
            
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
            
            Query query2 = em.createQuery("SELECT a FROM Author a WHERE a.authorId = :authorId");
            query2.setParameter("authorId", b.getAuthorId());
            Author a = (Author) query2.getSingleResult();
            bookdto.setAuthorName(a.getAuthorName());
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

    @Override
    public List<FeedbackDTO> LoadAlreadyreplied() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT f FROM Feedback f WHERE f.description IS NOT NULL");
        java.util.List<Feedback> listhistoryFeedback = query.getResultList();
        
        java.util.List<FeedbackDTO> listReplied = new ArrayList();
        
        for (Feedback entity : listhistoryFeedback) {
            FeedbackDTO fbDTO= new FeedbackDTO();
            fbDTO.setFeedBackDate(entity.getFeedBackDate());
            fbDTO.setDescription(entity.getDescription());
            fbDTO.setContent(entity.getContent());
            fbDTO.setUserId(entity.getUserId());
            fbDTO.setFeedBackId(entity.getFeedBackId());
            listReplied.add(fbDTO);
        }
        return listReplied;
    }

    @Override
    public List<FeedbackDTO> LoadReplyList() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT f FROM Feedback f WHERE f.description IS NULL");
        java.util.List<Feedback> listhistoryFeedback = query.getResultList();
        
        java.util.List<FeedbackDTO> listReplied = new ArrayList();
        
        for (Feedback entity : listhistoryFeedback) {
            FeedbackDTO fbDTO= new FeedbackDTO();
            fbDTO.setFeedBackDate(entity.getFeedBackDate());
            fbDTO.setDescription(entity.getDescription());
            fbDTO.setContent(entity.getContent());
            fbDTO.setUserId(entity.getUserId());
            fbDTO.setFeedBackId(entity.getFeedBackId());
            listReplied.add(fbDTO);
        }
        return listReplied;
    }

    @Override
    public void replyFeedback(FeedbackDTO fdto) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
        Feedback feedback = mappingDTOtoEntity.feedbackDTOtoFeedback(fdto);
        FeedbackJpaController pController = new FeedbackJpaController(emf);
        try {
            System.out.println("Rep "+feedback.getDescription());
            pController.edit(feedback);
        } catch (Exception ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public List loadListBook() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT b FROM Book b");
        List<Book> sqlBookList = query.getResultList();
        List<BookDTO> dtoBookList = new ArrayList<>();
        for (Book b : sqlBookList) {
           BookDTO bdto = new BookDTO();
           MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
           bdto = mappingDTOtoEntity.bookEnitytoDTO(b);
           dtoBookList.add(bdto);
        }
        return dtoBookList;
    }

    @Override
    public boolean updateBook(BookDTO bdto) throws RemoteException {
        try {
            BookJpaController bjc = new BookJpaController(emf);
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            Book b = mappingDTOtoEntity.bookDTOtoEntity(bdto);
            
            bjc.edit(b);
            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteBook(BookDTO bdto) throws RemoteException {
        try {
            BookJpaController bjc = new BookJpaController(emf);
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            Book b = mappingDTOtoEntity.bookDTOtoEntity(bdto);
            
            bjc.destroy(b.getBookId());
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(API_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List findCategory(int categoryName) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.categoryId = :categoryId");
        query.setParameter("categoryId", categoryName);
        List<Book> list = query.getResultList();
        List<BookDTO> resultList = new ArrayList();
        for (Book b : list) {
            MappingDTOtoEntity mappingDTOtoEntity = new MappingDTOtoEntity();
            BookDTO bdto = mappingDTOtoEntity.bookEnitytoDTO(b);
            resultList.add(bdto);
        }
        return resultList;
    }
}
