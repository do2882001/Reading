/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.TestServer;

import InterfaceRMI.ReadingInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



/**
 *
 * @author Tudt
 */
public class ThucHienTinhToan extends UnicastRemoteObject implements ReadingInterface {

    ThucHienTinhToan() throws RemoteException {
    }

    @Override
    public int tinhTong(int a, int b) throws RemoteException {

        System.out.println("goi ham tinh tong");
        return a + b;
    }

   

}
