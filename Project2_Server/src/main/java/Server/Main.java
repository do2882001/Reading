/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Do_Do
 */
public class Main {
    public static void main(String[] args)  {
        try {
            API reading = new API();
            LocateRegistry.createRegistry(7898);
            Naming.rebind("rmi://localhost:7898/reading", reading);
            System.out.println("da chay rmi tinh toan");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
