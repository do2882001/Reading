/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.InterfaceAdmin;


import Model.DTO.UserDTO;
import Model.DTO.BookDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Do_Do
 */
public interface IReading extends Remote {

    int tinhTong(int a, int b) throws RemoteException;

    boolean login(String username, String pass) throws RemoteException;
    
    boolean signup(UserDTO userDTO)throws RemoteException;
    BookDTO addNewbook(BookDTO dTO) throws RemoteException;// add thanh cong tra ve bookdto, that bai tra ve null
    boolean forgotPassWord_Change(String username , String phonenumber, String newpassword )throws RemoteException;
}
