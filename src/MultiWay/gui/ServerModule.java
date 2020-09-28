/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiWay.gui;

import MultiWay.dao.ChatClientDao;
import MultiWay.dao.ChatLogDao;
import MultiWay.pojo.ChatClientPojo;
import MultiWay.pojo.ChatLogPojo;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sameer
 */
public class ServerModule extends javax.swing.JFrame {

    /**
     * Creates new form ServerModule
     */
    ServerSocket svc=null;
    Random rand;
    ArrayList<String> userName=new ArrayList<>();
    ArrayList <PrintWriter> printWriters=new ArrayList<>();
    PrintWriter pwf=null;
    FileWriter fw=null;
    SimpleDateFormat sdf=null;
    
    public ServerModule() {
        initComponents();
        this.setLocationRelativeTo(null);
        sdf=new SimpleDateFormat("HH:mm:ss,dd-MMM-yyyy");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChatArea = new javax.swing.JTextArea();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtChatArea.setColumns(20);
        txtChatArea.setRows(5);
        jScrollPane1.setViewportView(txtChatArea);

        btnStart.setText("Start Server");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop Server");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 24)); // NOI18N
        jLabel1.setText("Server Module");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStop))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        txtChatArea.setText("Waiting for Client");
        try 
        {
            fw=new FileWriter("D:\\Sameer\\Java\\Chat App Logs\\chatlogs.txt");
            pwf=new PrintWriter(fw);
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        WaitForConnectionThread obj=new WaitForConnectionThread();
        obj.start();
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        fileClose();
    }//GEN-LAST:event_btnStopActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fileClose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtChatArea;
    // End of variables declaration//GEN-END:variables
class ChatThread extends Thread
{
    Socket s;
    PrintWriter pw;
    Scanner sc;
    String username,pass;
    //boolean flag=true;
    int flag=0; 
    SimpleDateFormat sdf;
    Date d1,d2;
    public ChatThread(Socket s)
    {
        this.s=s;
        sdf=new SimpleDateFormat("HH:mm:ss, dd-MMM-yyyy");
    }
    public void run()
    {
        boolean result=true;
        try{
            sc=new Scanner(s.getInputStream());
            pw=new PrintWriter(s.getOutputStream(),true);
            int count=0;
            while(true)
            {
                
                username=sc.nextLine();
                pass=sc.nextLine();
                flag=Integer.parseInt(sc.nextLine());
                if(flag==0)
                {
                    boolean isPresent=ChatClientDao.findClient(username,pass);
                    if(isPresent)
                    {
                        userName.add(username);
                        break;
                    }
                    else
                    {
                       pw.println("Username/Password Incorrect");
                    }
                }
                else if(flag==1)
                {
                    boolean isPresent=ChatClientDao.findClientUsername(username);
                    if(isPresent)
                    {
                        pw.println("User Already Exists");
                    }
                    else
                    {
                       //pw.println("Accepted");
                       userName.add(username);
                       ChatClientPojo obj=new ChatClientPojo(username,pass);
                       result=ChatClientDao.addClient(obj);
                       if(!result)
                           JOptionPane.showMessageDialog(null, "Cannot add user !");
                        break;
                    }
                }
//                if(count>0)
//                    pw.println("User already exists");
//                else
//                    pw.println("Name Required");
//                str=sc.nextLine();
//                boolean isPresent=ChatClientDao.findClient(str);
//                if(!isPresent)
//                {
//                    userName.add(str);
//                    break;
//                }
//                count++;
            }
            pw.println("Name Accepted");
            if(userName.size()==1)
            {
                txtChatArea.append("Connected to clients : ...\n");
            }
            txtChatArea.append(username+" from "+s.getInetAddress()+"\n");
            printWriters.add(pw);
            
//            String ip=s.getInetAddress().toString();
//            ChatClientPojo cp=new ChatClientPojo(username,ip);
//            result=ChatClientDao.addClient(cp);
//            if(result)
//            {
//                JOptionPane.showMessageDialog(null, "User Added successfully !");
//                
//            }
//            else
//                JOptionPane.showMessageDialog(null, "Cannot add user !");
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(result)
        {
        String msg;
        Date d=null;
        String timeStamp;
        boolean r;
        while(true)
        {
            msg=sc.nextLine();
            //int index=printWriters.indexOf(pw);
            if(msg.equals("STOPPED"))
                break;
            for(PrintWriter p:printWriters)
            {
                if(!p.equals(pw))
                {
                    p.println(username+" "+msg);
                }
            }
            
            synchronized(pwf)
            {
                pwf.println(sdf.format(new Date())+"\t "+username+" : "+msg);
                try
                {
                    timeStamp=sdf.format(new Date());
                    ChatLogPojo obj=new ChatLogPojo(username,msg,timeStamp);
                    r=ChatLogDao.addChatLog(obj);
                } 
                catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
            }
        }
        synchronized(pwf)
        {
            pwf.println(sdf.format(new Date())+"\t "+username+" : "+"Disconnected");
            try
                {
                    timeStamp=sdf.format(new Date());
                    ChatLogPojo obj=new ChatLogPojo(username," : Disconnected",timeStamp);
                    r=ChatLogDao.addChatLog(obj);
                } 
                catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
        }    
        for(PrintWriter p:printWriters)
        {
            if(!p.equals(pw))
                p.println(username+": Disconnected");
        }
        d2=new Date();
        sdf=new SimpleDateFormat("HH:mm:ss");
        pw.println();
        System.out.println("Disconnected from client");
        }
    }
    }
class WaitForConnectionThread extends Thread
{
    Socket s;
    public void run()
    {
        try
        {
            svc=new ServerSocket(4697);
            while(true)
            {
                s=svc.accept();
                txtChatArea.append("\nRequest Recieved from :"+s+"\n");
                ChatThread obj=new ChatThread(s);
                obj.start();
            }
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
private void fileClose()
{
    try {
            pwf.close();
            fw.close();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    JOptionPane.showMessageDialog(null, "Chat Logged Successfully");
}

}