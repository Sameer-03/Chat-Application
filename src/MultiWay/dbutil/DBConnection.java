/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiWay.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sameer
 */
public class DBConnection {
    private static Connection conn=null;
    static 
    {    
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-18RE0OG:1521/xe","Test", "abc");
            } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }    
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection Closed successfully !");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }   
    }
}