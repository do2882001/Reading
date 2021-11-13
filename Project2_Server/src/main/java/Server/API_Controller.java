/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.DTO.BookDTO;

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
        //gọi JPA

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
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    

}
