/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Do_Do
 */
@Entity
@Table(name = "listfavorite")
@NamedQueries({
    @NamedQuery(name = "Listfavorite.findAll", query = "SELECT l FROM Listfavorite l"),
    @NamedQuery(name = "Listfavorite.findByUserId", query = "SELECT l FROM Listfavorite l WHERE l.userId = :userId"),
    @NamedQuery(name = "Listfavorite.findByBookId", query = "SELECT l FROM Listfavorite l WHERE l.bookId = :bookId"),
    @NamedQuery(name = "Listfavorite.findByDescription", query = "SELECT l FROM Listfavorite l WHERE l.description = :description")})
public class Listfavorite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "UserId")
    private int userId;
    @Basic(optional = false)
    @Column(name = "BookId")
    private int bookId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Description")
    private Integer description;

    public Listfavorite() {
    }

    public Listfavorite(Integer description) {
        this.description = description;
    }

    public Listfavorite(Integer description, int userId, int bookId) {
        this.description = description;
        this.userId = userId;
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (description != null ? description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listfavorite)) {
            return false;
        }
        Listfavorite other = (Listfavorite) object;
        if ((this.description == null && other.description != null) || (this.description != null && !this.description.equals(other.description))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SQL.JPA.Listfavorite[ description=" + description + " ]";
    }
    
}
