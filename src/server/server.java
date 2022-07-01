/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BSE193044
 */
public class server {
    
   static String n,d;
   static int p;

    public server(String n, String d, int p) {
        this.n = n;
        this.d = d;
        this.p = p;
    }
    
    
    
    
     public static void main(String[] args) {
        try {
           DBhandler a=new SqlHandler(n,d,p);
           DBhandler stub =  (DBhandler) UnicastRemoteObject.exportObject(a,0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("add", stub);

          
            
            System.out.println(" Server ready");
           
            
        } catch (RemoteException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
