/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DTO;

import java.io.Serializable;
import java.util.Date;


public class AuthorDTO implements Serializable{
    private int id;
    private String Name;
    private Date Birthdate;
    private String Country;
    private String Description;
    
    public AuthorDTO(int id, String Name, Date Birthdate, String Country, String Description) {
        this.id = id;
        this.Name = Name;
        this.Birthdate = Birthdate;
        this.Country = Country;
        this.Description = Description;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return id;
    }
    
    public Date getbirthdate() {
        return Birthdate;
    }

    public String getCountry() {
        return Country;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setBirthdate(Date Birthdate) {
        this.Birthdate = Birthdate;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
