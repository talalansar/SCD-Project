/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.DBhandler;
import server.SqlHandler;
import server.product;
import server.server;

/**
 *
 * @author BSE193044
 */
public class client {
    
    static String n,d;
    static int p;

    public client(String n, String d, int p) {
        this.n = n;
        this.d = d;
        this.p = p;
    }
    
    void abc()
    {
        try {
            
              Registry registry = LocateRegistry.getRegistry(1099);
            DBhandler stub = (DBhandler) registry.lookup("add");
            
           product pr=new product(n,d,p);
         stub.add(pr);
          
          
          
          } catch (NotBoundException ex) {
              Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
          }catch (RemoteException ex) {
              Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
     public static void main(String[] args) {
               
          try {
            
              Registry registry = LocateRegistry.getRegistry(1099);
            DBhandler stub = (DBhandler) registry.lookup("add");
            
           product pr=new product(n,d,p);
         stub.add(pr);
          
          
          
          } catch (NotBoundException ex) {
              Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
          }catch (RemoteException ex) {
              Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
          }
}
}
