/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Admin.InterfaceAdmin.IReading;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Do_Do
 */
public class TestJPA_RMI {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        IReading adminrIReadingeading = (IReading) Naming.lookup("rmi://localhost:7898/reading");
        
        
        
        
        if (adminrIReadingeading.login("do28082001", "12345678")==true) {
            System.out.println("Dnag nhap thanh cong");
        }else{
            System.out.println("Dang nhap that bai");
        }
    }
}



















