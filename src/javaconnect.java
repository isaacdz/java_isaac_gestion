/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */

import java.sql.*;
import javax.swing.*;



public class javaconnect {
    
    
    Connection conn = null ; 
    
     public static Connection  ConnectDb(){
     
     try {
     
     Class.forName("com.mysql.jdbc.Driver");
     Connection  conn;
     
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/entreprise","root", "password");
     
     return conn ;
     }catch (ClassNotFoundException | SQLException e){
     // akhdem b zoudj 
     JOptionPane.showMessageDialog(null,e);
     return null ; 
     
     }
     
     }
    
}
