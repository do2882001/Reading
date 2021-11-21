/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserDTO implements Serializable{
    private int Id;
    private String Username;
    private String Password;
    private String Name;
    private String PhoneNumber;
    private Date Birthdate;
    private String Gender;
    private String Address;
    private byte[] AvatarUrl;
    private int roleId;

    
    public UserDTO(){
    }

    public UserDTO(int Id, String Username, String Password, String Name, String PhoneNumber, Date Birthdate, String Gender, String Address, byte[] AvatarUrl, int roleId) {
        this.Id = Id;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Birthdate = Birthdate;
        this.Gender = Gender;
        this.Address = Address;
        this.AvatarUrl = AvatarUrl;
        this.roleId = roleId;
    }

    public int getId() {
        return Id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public byte[] getAvatarUrl() {
        return AvatarUrl;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setBirthdate(Date Birthdate) {
        this.Birthdate = Birthdate;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setAvatarUrl(byte[] AvatarUrl) {
        this.AvatarUrl = AvatarUrl;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
}
