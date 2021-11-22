/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.InterfaceAdmin;


import Model.DTO.UserDTO;
import Model.DTO.BookDTO;
import Model.DTO.FeedbackDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

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
    
    void sendFeedBack(int UserId, String Content, LocalDate localDate)throws RemoteException;
    void reComment(String username , String content)throws RemoteException;
    
    boolean addNewbook(BookDTO dTO) throws RemoteException;
    boolean addBookToListFavorite(BookDTO bdto, int userId)throws RemoteException;
    
    void removeBookFromListFavorite()throws RemoteException;
    java.util.List loadListFavorite(int userId)throws RemoteException;
    
    List<FeedbackDTO> historyFeedback(int user)throws RemoteException;
    BookDTO searchBookDTO(String bookName)throws RemoteException;
    
    void changePassWord(int UserId, String PassWord)throws RemoteException;
    
    List<FeedbackDTO> LoadAlreadyreplied()throws RemoteException;
    List<FeedbackDTO> LoadReplyList()throws RemoteException;

    public void replyFeedback(FeedbackDTO fdto)throws RemoteException;
    List loadListBook() throws RemoteException;
    boolean deleteBook(BookDTO bdto) throws RemoteException;
    boolean updateBook(BookDTO bdto) throws RemoteException;
}
