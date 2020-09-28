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
public class ChatClientPojo {
    String username;
    String password;

    public ChatClientPojo() {
    }

    public ChatClientPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ChatClientPojo{" + "username=" + username + ", password=" + password + '}';
    }
    
}
