/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiWay.pojo;

/**
 *
 * @author Sameer
 */
public class ChatLogPojo {
    String username;
    String msg;
    String msgTime;

    public ChatLogPojo(String username, String msg, String msgTime) {
        this.username = username;
        this.msg = msg;
        this.msgTime = msgTime;
    }

    public ChatLogPojo() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public String getUsername() {
        return username;
    }

    public String getMsg() {
        return msg;
    }

    public String getMsgTime() {
        return msgTime;
    }

    @Override
    public String toString() {
        return "ChatLogPojo{" + "username=" + username + ", msg=" + msg + ", msgTime=" + msgTime + '}';
    }
    
}
