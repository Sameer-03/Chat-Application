/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiWay.dao;

import MultiWay.dbutil.DBConnection;
import MultiWay.pojo.ChatClientPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sameer
 */
public class ChatClientDao {
    public static boolean findClient(String user, String pass) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select username from chatclients where username=? and password=?");
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static boolean findClientUsername(String user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select username from chatclients where username=?");
        ps.setString(1, user);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static boolean addClient(ChatClientPojo obj) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into chatclients values(?,?)");
        ps.setString(1,obj.getUsername());
        ps.setString(2, obj.getPassword());
        int x=ps.executeUpdate();
        return x!=0;
    }
}
