/*
 * Created by JFormDesigner on Wed Jun 09 12:31:34 ICT 2021
 */

package client.gui;

import client.gui.listener.IMessageReceiverListener;
import client.service.Manager;
import client.utils.DateTime;
import entity.Message;
import entity.MessageType;
import entity.message.TextMessage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * @author vuonhau
 */
public class ChatForm extends JFrame {
    public ChatForm() {
        initComponents();
    }

    private AccountForm parent;
    private static final String[] fileColumns = new String[]{"Time", "Author", "File name", "File size", "%", ""};

    class MessageReciever implements IMessageReceiverListener {

        @Override
        public void process(Message message) {
            switch (message.getType()) {
                case FILE:
                    addFileMessage(message);
                    break;
                case TEXT:
                    addTextMessage(message);
                    break;
            }
        }
    }

    class FileTableModel extends DefaultTableModel {

        public FileTableModel(Object[] column) {
            super(null, column);
        }

        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 5:
                    return Boolean.class;
                default:
                    return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int i, int i1) {
            if (i1 == 4) {
                return true;
            }
            return false;
        }
    }

    public ChatForm(AccountForm parent, String username) {
        this();
        initTable();
        tfUsername.setText(username);
        setTitle("Hello " + username);
        this.parent = parent;

        var mng = Manager.getInstance();
        mng.setListener(new MessageReciever());
        mng.startListen();
    }

    void initTable() {
        var centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jtListFile.setDefaultRenderer(Object.class, centerRenderer);

        var model = new FileTableModel(fileColumns);

        model.addRow(new Object[]{"1", "2", "3", "4", "-", false});

        jtListFile.setModel(model);
    }


    public void addColoredText(JTextPane pane, String text, Color color) {
        StyledDocument doc = tpListMessage.getStyledDocument();

        Style style = pane.addStyle("Color Style", null);
        StyleConstants.setForeground(style, color);
        try {
            doc.insertString(doc.getLength(), text, style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    void scrollToBottom() {
        tpListMessage.selectAll();
        int x = tpListMessage.getSelectionEnd();
        tpListMessage.select(x, 0);
    }

    void addTextMessage(Message message) {
        SwingUtilities.invokeLater(() -> {
            addColoredText(tpListMessage, "[" + DateTime.getDMHMS() + "]", Color.LIGHT_GRAY);
            addColoredText(tpListMessage, "[" + message.getAuthor() + "]", Color.CYAN);
            var text = (TextMessage) message.getData();
            addColoredText(tpListMessage, " " + text.getContent() + "\n", Color.BLACK);
            scrollToBottom();
        });
    }

    void addFileMessage(Message message) {
        SwingUtilities.invokeLater(() -> {

        });
    }

    private void btnLogoutActionPerformed(ActionEvent e) {
        setVisible(false);
        Manager.getInstance().setListener(null);
        parent.logout();
    }

    private void emojiBtnActionPerformed(ActionEvent e) {
        var btn = (JButton) e.getSource();
        tfMessage.setText(tfMessage.getText() + btn.getText());
    }

    private void btnSendActionPerformed(ActionEvent e) {
        var mess = tfMessage.getText();
        if (mess.length() == 0) return;
        tfMessage.setText("");

        addColoredText(tpListMessage, "[" + DateTime.getDMHMS() + "]", Color.LIGHT_GRAY);
        addColoredText(tpListMessage, "You", Color.GREEN);
        addColoredText(tpListMessage, " " + mess + "\n", Color.BLACK);
        scrollToBottom();

        Manager.getInstance().sendTextMessage(mess);
    }

    private void btnUploadActionPerformed(ActionEvent e) {
        var fc = new JFileChooser();
        var ret = fc.showOpenDialog(this);
        if (ret != JFileChooser.APPROVE_OPTION)
            return;
        btnSend.setEnabled(false);

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
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        button14 = new JButton();
        button15 = new JButton();
        button16 = new JButton();
        panel8 = new JPanel();
        scrollPane1 = new JScrollPane();
        jtListFile = new JTable();
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
                panel7.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
                EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
                . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
                java. awt. Color. red) ,panel7. getBorder( )) ); panel7. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
                { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
                throw new RuntimeException( ); }} );

                //======== scrollPane2 ========
                {

                    //---- tpListMessage ----
                    tpListMessage.setEditable(false);
                    scrollPane2.setViewportView(tpListMessage);
                }

                //---- btnSend ----
                btnSend.setText("Send");
                btnSend.addActionListener(e -> btnSendActionPerformed(e));

                //---- button1 ----
                button1.setText("\ud83d\ude00");
                button1.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button1.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button2 ----
                button2.setText("\ud83d\ude04");
                button2.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button2.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button3 ----
                button3.setText("\ud83d\ude06");
                button3.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button3.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button4 ----
                button4.setText("\ud83d\ude01");
                button4.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button4.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button5 ----
                button5.setText("\ud83e\udd23");
                button5.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button5.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button6 ----
                button6.setText("\ud83d\ude05");
                button6.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button6.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button7 ----
                button7.setText("\ud83d\ude42");
                button7.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button7.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button8 ----
                button8.setText("\ud83d\ude02");
                button8.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button8.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button9 ----
                button9.setText("\ud83d\ude09");
                button9.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button9.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button10 ----
                button10.setText("\ud83d\ude43");
                button10.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button10.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button11 ----
                button11.setText("\ud83d\ude07");
                button11.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button11.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button12 ----
                button12.setText("\ud83d\ude0a");
                button12.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button12.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button13 ----
                button13.setText("\ud83d\ude17");
                button13.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button13.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button14 ----
                button14.setText("\ud83d\ude18");
                button14.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button14.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button15 ----
                button15.setText("\ud83d\ude0b");
                button15.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button15.addActionListener(e -> emojiBtnActionPerformed(e));

                //---- button16 ----
                button16.setText("\ud83d\ude19");
                button16.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
                button16.addActionListener(e -> emojiBtnActionPerformed(e));

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel7Layout.createParallelGroup()
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(tfMessage, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(button1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button4, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)
                                    .addComponent(button3, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button6, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)
                                    .addComponent(button5, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button8, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)
                                    .addComponent(button7, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button10, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)
                                    .addComponent(button9, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button12, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)
                                    .addComponent(button11, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button14, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)
                                    .addComponent(button13, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button16, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)
                                    .addComponent(button15, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addGap(3, 3, 3)))
                            .addContainerGap())
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSend)
                                .addComponent(tfMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button1)
                                    .addComponent(button2))
                                .addComponent(button4)
                                .addComponent(button3)
                                .addComponent(button6)
                                .addComponent(button5)
                                .addComponent(button8)
                                .addComponent(button7)
                                .addComponent(button10)
                                .addComponent(button9)
                                .addComponent(button12)
                                .addComponent(button11)
                                .addComponent(button14)
                                .addComponent(button13)
                                .addComponent(button16)
                                .addComponent(button15))
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Room", panel7);

            //======== panel8 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(jtListFile);
                }

                //---- btnDownload ----
                btnDownload.setText("Download");

                //---- label2 ----
                label2.setText("File will be save at Download folder ");

                //---- btnUpload ----
                btnUpload.setText("Upload");
                btnUpload.addActionListener(e -> btnUploadActionPerformed(e));

                GroupLayout panel8Layout = new GroupLayout(panel8);
                panel8.setLayout(panel8Layout);
                panel8Layout.setHorizontalGroup(
                    panel8Layout.createParallelGroup()
                        .addGroup(panel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel8Layout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                                .addGroup(panel8Layout.createSequentialGroup()
                                    .addComponent(btnDownload, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
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
                            .addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JPanel panel8;
    private JScrollPane scrollPane1;
    private JTable jtListFile;
    private JButton btnDownload;
    private JLabel label2;
    private JButton btnUpload;
    private JPanel panel9;
    private JLabel label1;
    private JTextField tfUsername;
    private JButton btnLogout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
