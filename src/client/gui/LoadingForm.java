package client.gui;

public class LoadingForm extends javax.swing.JDialog {
    public LoadingForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private javax.swing.JProgressBar jProgressBar1;

    private void initComponents() {
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jProgressBar1.setIndeterminate(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
