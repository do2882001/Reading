/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SQL.INTF;

import Model.DTO.AuthorDTO;



/**
 *
 * @author ADMIN
 */
public interface IAuthorControllerSQL {
    void addAuthor(AuthorDTO a);
    AuthorDTO selectAuthor();
    void deleteAuthor();
}
