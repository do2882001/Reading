/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Model.DTO.UserDTO;
import java.util.Date;

/**
 *
 * @author Do_Do
 */
public class AccountInfo {
     int UserId;
     String Username;
     String Password;
     String Name;
     String PhoneNumber;
     Date Birthdate;
     String Gender;
     String Address;
     byte[] AvatarUrl;

//    private ArrayList<FeedbackDTO> FeedbackList;
    
    public AccountInfo() {
    }

    public AccountInfo(int Id, String Username, String Password, String Name, String PhoneNumber, Date Birthdate, String Gender, String Address, byte[] AvatarUrl, int roleId) {
        this.UserId = Id;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Birthdate = Birthdate;
        this.Gender = Gender;
        this.Address = Address;
        this.AvatarUrl = AvatarUrl;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
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

    public void setInfo(UserDTO entity) {
        this.Address = entity.getAddress();
        this.Birthdate = entity.getBirthdate();
        this.Gender = entity.getGender();
        this.Name = entity.getName();
        this.Username = entity.getUsername();
        this.PhoneNumber = entity.getPhoneNumber();
        this.AvatarUrl = entity.getAvatarUrl();
    }
}
