/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BSE193044
 */
public class SqlHandler implements DBhandler{

Connection con;
    public SqlHandler(String n,String d,int p) {
       
        
        
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
            
           System.out.println("connection established");
                
        } catch (SQLException ex) {
            Logger.getLogger(DBhandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void add(product pr) {
        
    try {
        String query="Insert into product(name,description,price) values "+"('"+pr.getName()+"','"+pr.getDescription()+"','"+pr.getPrice()+"')";
        Statement st=con.createStatement();
        int a=st.executeUpdate(query);
        
        JOptionPane.showMessageDialog(null,"Record addded!");
    } catch (SQLException ex) {
        Logger.getLogger(SqlHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
    
}
