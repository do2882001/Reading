/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import Model.DTO.BookDTO;
import Model.DTO.FeedbackDTO;
import Model.DTO.UserDTO;
import SQL.JPA.Book;
import SQL.JPA.Feedback;
import SQL.JPA.User;

/**
 *
 * @author Tudt
 */
public class MappingDTOtoEntity {

    public static Book bookDTOtoEntity(BookDTO dTO) {

        if (dTO == null) {
            return null;
        }
        Book book = new Book();
        book.setAuthorId(dTO.getAuthorId());
        book.setBookName(dTO.getBookName());
//        book.setBookUrl(dTO.getBookUrl());//convert sang mang byte
        book.setCategoryId(dTO.getCategoryId());
        ///vv.v..v
        return book;
    }

    public static BookDTO bookEnitytoDTO(Book entity) {

        if (entity == null) {
            return null;
        }
        BookDTO book = new BookDTO();
//        book.setAuthor(entity.getAuthorId());//tu Author ID goij jPA laay ve  Author xong tryen vao day
        book.setBookName(entity.getBookName());
//        book.setBookUrl(dTO.getBookUrl());//convert sang mang byte
        book.setCategoryId(entity.getCategoryId());
        ///vv.v..v
        return book;
    }
     public static UserDTO userEnitytoDTO(User entity) {

        if (entity == null) {
            return null;
        }
        UserDTO udto = new UserDTO();
        udto.setAddress(entity.getAddress());
        udto.setBirthdate(entity.getBirthdate());
        udto.setGender(entity.getGender());
        udto.setName(entity.getName());
        udto.setUsername(entity.getUserName());
        udto.setPhoneNumber(entity.getPhoneNumber());
        udto.setRoleId(entity.getRoleId());
        udto.setAvatarUrl(entity.getAvatarUrl());
        udto.setId(entity.getRoleId());
        return udto;
    }
     public static User userDTOtoUser(UserDTO entity) {

        if (entity == null) {
            return null;
        }
        User u = new User();
        u.setAddress(entity.getAddress());
        u.setBirthdate(entity.getBirthdate());
        u.setGender(entity.getGender());
        u.setName(entity.getName());
        u.setUsername(entity.getUsername());
        u.setPhoneNumber(entity.getPhoneNumber());
        u.setRoleId(entity.getRoleId());
        u.setAvatarUrl(entity.getAvatarUrl());
        return u;
    }
     
     public static Feedback feedbackDTOtoFeedback(FeedbackDTO entity) {

        if (entity == null) {
            return null;
        }
        Feedback fb = new Feedback();
        //u.setAddress(entity.getAddress());
        fb.setUserId(entity.getUserId());
        fb.setContent(entity.getContent());
        fb.setDescription(entity.getDescription());
        return fb;
    }
}
