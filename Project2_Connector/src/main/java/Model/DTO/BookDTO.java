/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DTO;


import java.io.Serializable;



/**
 *
 * @author Do_Do
 */
public class BookDTO implements Serializable {

    private int BookId;
    private String BookName;
    private String Type;
    private String ReleaseDate;
    private byte [] PosterUrl;
    private byte [] BookUrl;
    private int CategoryId;
    private int AuthorId;
    private String Country;
    private String Description;
     String AuthorName;

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public BookDTO() {
    }

    public BookDTO(int BookId, String BookName, String Type, String ReleaseDate, byte [] PosterUrl, byte [] BookUrl, int CategoryId, int AuthorId,String Country) {
        this.BookId = BookId;
        this.BookName = BookName;
        this.Type = Type;
        this.ReleaseDate = ReleaseDate;
        this.PosterUrl = PosterUrl;
        this.BookUrl = BookUrl;
        this.CategoryId = CategoryId;
        this.AuthorId = AuthorId;
        this.Country = Country;
    }

    public int getBookId() {
        return BookId;
    }

    public String getBookName() {
        return BookName;
    }

    public String getType() {
        return Type;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public byte [] getPosterUrl() {
        return PosterUrl;
    }

    public byte [] getBookUrl() {
        return BookUrl;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public void setPosterUrl(byte [] PosterUrl) {
        this.PosterUrl = PosterUrl;
    }

    public void setBookUrl(byte [] BookUrl) {
        this.BookUrl = BookUrl;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public void setAuthorId(int AuthorId) {
        this.AuthorId = AuthorId;
    }
    
}
