/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Do_Do
 */
public class Cookies {
    String UserName;
    String Password;

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }
    public void setInfo(String un , String pw) {
        UserName = un;
        Password = pw;
    }
}
