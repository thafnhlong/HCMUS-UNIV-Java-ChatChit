/*
 * Created by JFormDesigner on Wed Jun 09 12:31:34 ICT 2021
 */

package client.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author vuonhau
 */
public class ChatForm extends JFrame {
    public ChatForm() {
        initComponents();
    }

    private AccountForm parent;

    public ChatForm(AccountForm parent, String username) {
        this();
        tfUsername.setText(username);
        this.parent = parent;
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        setVisible(false);
        parent.logout();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - vuonhau
        tabbedPane1 = new JTabbedPane();
        panel7 = new JPanel();
        scrollPane2 = new JScrollPane();
        tpListMessage = new JTextPane();
        tfMessage = new JTextField();
        btnSend = new JButton();
        panel8 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btnDownload = new JButton();
        label2 = new JLabel();
        btnUpload = new JButton();
        panel9 = new JPanel();
        label1 = new JLabel();
        tfUsername = new JTextField();
        btnLogout = new JButton();

        //======== this ========
        setTitle("Chat room");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel7 ========
            {
                panel7.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
                .EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax
                .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,
                12),java.awt.Color.red),panel7. getBorder()));panel7. addPropertyChangeListener(new java.beans
                .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.
                getPropertyName()))throw new RuntimeException();}});

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(tpListMessage);
                }

                //---- btnSend ----
                btnSend.setText("Send");

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(tfMessage, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSend)
                                .addComponent(tfMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Room", panel7);

            //======== panel8 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }

                //---- btnDownload ----
                btnDownload.setText("Download");

                //---- label2 ----
                label2.setText("File will be save at Download folder ");

                //---- btnUpload ----
                btnUpload.setText("Upload");

                GroupLayout panel8Layout = new GroupLayout(panel8);
                panel8.setLayout(panel8Layout);
                panel8Layout.setHorizontalGroup(
                    panel8Layout.createParallelGroup()
                        .addGroup(panel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel8Layout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                                .addGroup(panel8Layout.createSequentialGroup()
                                    .addComponent(btnDownload, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                    .addComponent(btnUpload, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())))
                );
                panel8Layout.setVerticalGroup(
                    panel8Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDownload, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2)
                                .addComponent(btnUpload, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Attachment", panel8);

            //======== panel9 ========
            {

                //---- label1 ----
                label1.setText("Username");

                //---- tfUsername ----
                tfUsername.setEditable(false);

                //---- btnLogout ----
                btnLogout.setText("Logout");
                btnLogout.addActionListener(e -> btnLogoutActionPerformed(e));

                GroupLayout panel9Layout = new GroupLayout(panel9);
                panel9.setLayout(panel9Layout);
                panel9Layout.setHorizontalGroup(
                    panel9Layout.createParallelGroup()
                        .addGroup(panel9Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52))
                );
                panel9Layout.setVerticalGroup(
                    panel9Layout.createParallelGroup()
                        .addGroup(panel9Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLogout)
                                .addComponent(tfUsername))
                            .addGap(340, 340, 340))
                );
            }
            tabbedPane1.addTab("User", panel9);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1)
                    .addGap(0, 0, 0))
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - vuonhau
    private JTabbedPane tabbedPane1;
    private JPanel panel7;
    private JScrollPane scrollPane2;
    private JTextPane tpListMessage;
    private JTextField tfMessage;
    private JButton btnSend;
    private JPanel panel8;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btnDownload;
    private JLabel label2;
    private JButton btnUpload;
    private JPanel panel9;
    private JLabel label1;
    private JTextField tfUsername;
    private JButton btnLogout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
