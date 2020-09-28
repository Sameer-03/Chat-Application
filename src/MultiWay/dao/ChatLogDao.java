/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiWay.dao;

import MultiWay.dbutil.DBConnection;
import MultiWay.pojo.ChatLogPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sameer
 */
public class ChatLogDao {
    public static boolean addChatLog(ChatLogPojo obj) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into chatlogs values(?,?,?)");
        ps.setString(1, obj.getUsername());
        ps.setString(2, obj.getMsg());
        ps.setString(3, obj.getMsgTime());
        return (ps.executeUpdate())!=0;
    }
    
}
