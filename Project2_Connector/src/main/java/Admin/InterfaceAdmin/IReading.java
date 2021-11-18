/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.InterfaceAdmin;


import Model.DTO.UserDTO;
import Model.DTO.BookDTO;
import Model.DTO.FeedbackDTO;
import java.awt.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Do_Do
 */
public interface IReading extends Remote {

    int tinhTong(int a, int b) throws RemoteException;

    UserDTO login(String username, String pass) throws RemoteException;
    boolean signup(UserDTO userDTO)throws RemoteException;
    boolean forgotPassWord_Change(String username , String phonenumber, String newpassword )throws RemoteException;
    void changeInfo(UserDTO udto)throws RemoteException;
    
    void sendFeedBack(int UserId, String Content)throws RemoteException;
    void reComment(String username , String content)throws RemoteException;
    
    BookDTO addNewbook(BookDTO dTO) throws RemoteException;
    void addBookToListFavorite()throws RemoteException;
    void removeBookFromListFavorite()throws RemoteException;
    java.util.List loadListFavorite(int userId)throws RemoteException;
}
