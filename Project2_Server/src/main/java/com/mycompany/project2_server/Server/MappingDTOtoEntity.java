/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project2_server.Server;

import User.Model.BookDTO;
import com.mycompany.project2_server.SQL.JPA.Book;

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
        book.setAuthorId(dTO.getAuthor().getAuthorId());
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
}
