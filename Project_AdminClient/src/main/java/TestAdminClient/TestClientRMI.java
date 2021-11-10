/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAdminClient;

import InterfaceRMI.ReadingInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Do_Do
 */
public class TestClientRMI {
    public static void main(String[] args) {

        try {
            ReadingInterface ri = (ReadingInterface) Naming.lookup("rmi://localhost:7898/tinhtong");

            int tong = ri.tinhTong(344, 444);
            System.out.println("ket qua: " + tong);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(TestClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
