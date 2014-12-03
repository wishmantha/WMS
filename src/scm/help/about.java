package scm.help;

import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class about extends javax.swing.JInternalFrame {

    public about() {
        try {
            initComponents();
           
        } catch (Exception ex) {
            Logger.getLogger(about.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();

        setTitle("About");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("DokChampa", 0, 16)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTextPane1.setText("This software is an attempt to develop a fully functional Warehouse Management System (WMS) for RR Constructions (PVT) Ltd. to efficiently control the movement of materials within the warehouse, replacing their current manual file-based system. This will automate all of its Warehouse’s manual processes such as,\n•\tproducing GRNs and Issue notes\n•\tmanaging vehicle and equipment details\n•\tmanaging stock and supplier details\n\nThis current system is designed for the organization to obtain above services without manual intervention. It has the ability to categorize equipment, vehicles and stock intelligently by assigning different patterns of unique codes to each of them, thus enabling centralized management of tasks such as tracking inventory levels and stock locations. It also has the ability to generate Good Received Notes (GRN), Issue Notes and other necessary reports required quickly without any delays. One of the main and new functions of the system is the option to analyse the history of all equipment and items in the warehouse and generate stock valuations. These strategic level reports can then be used by the Management in decision making.\n\nThe new system will be implemented on several networked computers, with a centralized database. All warehouses are capable of real-time processing since they are all connected with the accounts department. A local copy of the database will also be held at every warehouse, in case of communication error. New system will be developed using modern programming techniques like Design Patterns, Object Oriented Programming etc. Developed system uses Java as its main language and MySQL as the database. Reports will be generated using Jasper Reporting technology.\n");
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 440));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator6);

        bClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose.setText("Close");
        bClose.setFocusable(false);
        bClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(bClose);
        jToolBar1.add(jSeparator7);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
    this.dispose();

}//GEN-LAST:event_bCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
