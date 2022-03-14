/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Model.DTO.BookDTO;
import Model.DTO.FeedbackDTO;
import Model.DTO.UserDTO;
import Model.Book;
import Model.Feedback;
import Model.User;

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
        book.setBookId(dTO.getBookId());
        book.setAuthorId(dTO.getAuthorId());
        book.setBookName(dTO.getBookName());
        book.setBookUrl(dTO.getBookUrl());
        book.setCategoryId(dTO.getCategoryId());
        book.setPosterUrl(dTO.getPosterUrl());
        book.setReleaseDate(dTO.getReleaseDate());
        book.setType(dTO.getType());
        book.setCountry(dTO.getCountry());
        book.setDescription(dTO.getDescription());
        return book;
    }

    public static BookDTO bookEnitytoDTO(Book entity) {

        if (entity == null) {
            return null;
        }
        BookDTO book = new BookDTO();
        book.setBookId(entity.getBookId());
        book.setAuthorId(entity.getAuthorId());
        book.setBookName(entity.getBookName());
        book.setBookUrl(entity.getBookUrl());
        book.setCategoryId(entity.getCategoryId());
        book.setPosterUrl(entity.getPosterUrl());
        book.setReleaseDate(entity.getReleaseDate());
        book.setType(entity.getType());
        book.setCountry(entity.getCountry());
        book.setDescription(entity.getDescription());
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
        udto.setId(entity.getUserId());
        udto.setPassword(entity.getPassWord());
        return udto;
    }
     public static User userDTOtoUser(UserDTO entity) {

        if (entity == null) {
            return null;
        }
        User u = new User();
        u.setUserId(entity.getId());
        u.setPassWord(entity.getPassword());
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
        fb.setFeedBackId(entity.getFeedBackId());
        fb.setUserId(entity.getUserId());
        fb.setContent(entity.getContent());
        fb.setDescription(entity.getDescription());
        fb.setFeedBackDate(entity.getFeedBackDate());
        return fb;
    }
     
     public static FeedbackDTO feedbacktoFeedbackDto(Feedback entity) {

        if (entity == null) {
            return null;
        }
        
        FeedbackDTO fbDTO = new FeedbackDTO();
        //java.util.Date utilDate = new java.util.Date(entity.getFeedBackDate().getTime());
        fbDTO.setFeedBackDate(null);
        fbDTO.setDescription(entity.getDescription());
        fbDTO.setContent(entity.getContent());
        fbDTO.setUserId(entity.getUserId());
        fbDTO.setFeedBackId(entity.getFeedBackId());
        return fbDTO;
    }
}
