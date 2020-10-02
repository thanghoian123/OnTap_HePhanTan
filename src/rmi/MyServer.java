/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class myServer {
    public static void main(String[] args) {
        try {
            ThaoTac tt = new ThaoTac();
            LocateRegistry.createRegistry(1099);
            
            Naming.bind("rmi://127.0.0.1/ThaoTac", tt);
            System.out.println("dang doi yeu cau!!!");
        } catch (Exception ex) {
            Logger.getLogger(myServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
