/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;



import Model.DTO.FeedbackDTO;
import SQL.BookJpaController;
import SQL.JPA.Book;
import SQL.JPA.Feedback;
import SQL.JPA.Listfavorite;
import SQL.JPA.User;
import SQL.UserJpaController;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReadingJPA");
        EntityManager em = emf.createEntityManager();

        Path p = Paths.get("E:\\do123.png");
        byte[] poster = Files.readAllBytes(p);
       
        
        Path pdfPath = Paths.get("E:\\do.pdf");
        byte[] bookurl = Files.readAllBytes(pdfPath);
        
        
        
        Book b = new Book();
        b.setBookName("Sasuke");
        b.setAuthorId(1);
        b.setType("Comic");
        b.setCategoryId(1);
        b.setReleaseDate("1999");
        b.setDescription("null");
        b.setCountry("VietNam");
        b.setPosterUrl( poster);
        b.setBookUrl( bookurl);

        BookJpaController ujc = new BookJpaController(emf);
        ujc.create(b);
    }
}



















