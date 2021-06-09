/*
 * Created by JFormDesigner on Wed Jun 09 11:55:55 ICT 2021
 */

package client.gui;

import client.service.Manager;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author vuonhau
 */
public class AccountForm extends JFrame {
    public AccountForm() {
        initComponents();
    }

    private ChatForm child;

    public static boolean isStringOnlyAlphabet(String str) {
        return ((str != null)
                && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

    boolean checkValidation() {
        if (isStringOnlyAlphabet(tfUsername.getText()) || isStringOnlyAlphabet(tfPassword.getText()))
            return true;
        JOptionPane.showMessageDialog(this, "Username and password are only alphabet");
        return false;
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        if (!checkValidation()) return;

        if(!Manager.getInstance().login(tfUsername.getText(),tfPassword.getText())){
            JOptionPane.showMessageDialog(this,"Username or password is wrong");
            return;
        }

        setVisible(false);
        if (child != null) {
            child.dispose();
        }
        child = new ChatForm(this);
        child.setVisible(true);
    }

    private void btnRegisterActionPerformed(ActionEvent e) {
        if (!checkValidation()) return;

        Manager.getInstance().register(tfUsername.getText(),tfPassword.getText());
        JOptionPane.showMessageDialog(this,"Register successfully");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - vuonhau
        label1 = new JLabel();
        tfUsername = new JTextField();
        tfPassword = new JTextField();
        label2 = new JLabel();
        btnRegister = new JButton();
        btnLogin = new JButton();

        //======== this ========
        setTitle("User configuration");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Username");

        //---- label2 ----
        label2.setText("Password");

        //---- btnRegister ----
        btnRegister.setText("Register");
        btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));

        //---- btnLogin ----
        btnLogin.setText("Login");
        btnLogin.addActionListener(e -> btnLoginActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(tfPassword, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                                        .addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegister)
                                        .addComponent(btnLogin))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - vuonhau
    private JLabel label1;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JLabel label2;
    private JButton btnRegister;
    private JButton btnLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
