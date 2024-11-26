/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

import code_and_db.Account;
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginside = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        username_Field = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        loginbutton = new javax.swing.JButton();
        libary_icon = new javax.swing.JLabel();
        password_Field = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginside.setBackground(new java.awt.Color(255, 255, 255));

        welcome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Welcome");

        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username.setText("Username");

        username_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                username_FieldKeyPressed(evt);
            }
        });

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setText("Password");

        loginbutton.setBackground(new java.awt.Color(102, 0, 0));
        loginbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginbutton.setForeground(new java.awt.Color(255, 255, 255));
        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        loginbutton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginbuttonKeyPressed(evt);
            }
        });

        password_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_FieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout loginsideLayout = new javax.swing.GroupLayout(loginside);
        loginside.setLayout(loginsideLayout);
        loginsideLayout.setHorizontalGroup(
            loginsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginsideLayout.createSequentialGroup()
                .addGroup(loginsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginsideLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(loginsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(password)
                            .addComponent(username)
                            .addComponent(loginbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(password_Field)))
                    .addGroup(loginsideLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(loginsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(libary_icon))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        loginsideLayout.setVerticalGroup(
            loginsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginsideLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(libary_icon)
                .addGap(24, 24, 24)
                .addComponent(username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginbutton)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getContentPane().add(loginside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 330));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 400, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                if (Account.checklogin(username_Field.getText(), new String(password_Field.getPassword()))){
                    java.util.Arrays.fill(password_Field.getPassword(),' ');
                    new menu().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!","Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
                catch (Exception e){
                e.printStackTrace();
            }
            }
        });
    }//GEN-LAST:event_loginbuttonActionPerformed

    
    private void loginbuttonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginbuttonKeyPressed
   
    }//GEN-LAST:event_loginbuttonKeyPressed

    private void username_FieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_FieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            try{
                if (Account.checklogin(username_Field.getText(), new String(password_Field.getPassword()))){
                    new menu().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!","Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } 
    }//GEN-LAST:event_username_FieldKeyPressed

    private void password_FieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_FieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            try{
                if (Account.checklogin(username_Field.getText(), new String(password_Field.getPassword()))){
                    new menu().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!","Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } 
    }//GEN-LAST:event_password_FieldKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel libary_icon;
    private javax.swing.JButton loginbutton;
    private javax.swing.JPanel loginside;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField password_Field;
    private javax.swing.JLabel username;
    private javax.swing.JTextField username_Field;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
