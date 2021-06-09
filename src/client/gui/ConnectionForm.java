/*
 * Created by JFormDesigner on Wed Jun 09 11:47:16 ICT 2021
 */

package client.gui;

import client.service.Manager;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author vuonhau
 */
public class ConnectionForm extends JFrame {
    public ConnectionForm() {
        initComponents();
    }


    private void portIsNotValid(){
        JOptionPane.showMessageDialog(this,"Port is not valid","Error",JOptionPane.ERROR_MESSAGE);
    }

    private boolean checkValidation(){
        if(tfPort.getText().length() == 0 || tfIP.getText().length() == 0){
            JOptionPane.showMessageDialog(this,"Missing connection config","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            var port = Integer.valueOf(tfPort.getText());
            if(port < 0 && port > 65536){
                portIsNotValid();
                return false;
            }
        } catch (NumberFormatException e){
            portIsNotValid();
            return false;
        }

        return true;
    }

    private void btnConnectActionPerformed(ActionEvent e) {
        if (!checkValidation()){
            return;
        }

        var hostname = tfIP.getText();
        var port = Integer.valueOf(tfPort.getText());

        if (!Manager.getInstance().connect(hostname,port)){
            JOptionPane.showMessageDialog(this,"Can not connect to Server","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }

        setVisible(false);
        new AccountForm().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - vuonhau
        label1 = new JLabel();
        tfIP = new JTextField();
        label2 = new JLabel();
        tfPort = new JTextField();
        btnConnect = new JButton();

        //======== this ========
        setTitle("Connect to server");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Server Name");

        //---- tfIP ----
        tfIP.setText("localhost");

        //---- label2 ----
        label2.setText("Port");

        //---- tfPort ----
        tfPort.setText("12021");

        //---- btnConnect ----
        btnConnect.setText("Connect");
        btnConnect.addActionListener(e -> btnConnectActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfIP, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfPort, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(btnConnect, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(tfIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(label2))
                                .addComponent(tfPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(btnConnect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - vuonhau
    private JLabel label1;
    private JTextField tfIP;
    private JLabel label2;
    private JTextField tfPort;
    private JButton btnConnect;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
