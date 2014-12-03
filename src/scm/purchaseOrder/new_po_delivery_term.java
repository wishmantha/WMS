package scm.purchaseOrder;

import scm.stock.new_stock;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;
import scm.Main;

public class new_po_delivery_term extends javax.swing.JFrame {

    static DBControl db = new DBControl();

    public new_po_delivery_term() {
        initComponents();
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtDeliveryTerm = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        bShowAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Delivery Term");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/uom.png")));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("New Delivery Term");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 140, 30);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Delivery Term"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 150, 300, 210);

        txtDeliveryTerm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDeliveryTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDeliveryTermKeyReleased(evt);
            }
        });
        getContentPane().add(txtDeliveryTerm);
        txtDeliveryTerm.setBounds(20, 110, 300, 30);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator6);

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        bSave.setText("Save");
        bSave.setFocusable(false);
        bSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSave.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(bSave);
        jToolBar1.add(jSeparator1);

        bDelete.setForeground(new java.awt.Color(204, 0, 0));
        bDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDelete.setText("Delete");
        bDelete.setFocusable(false);
        bDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bDelete.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(bDelete);
        jToolBar1.add(jSeparator3);

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

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 360, 70);

        bShowAll.setText("Show All");
        bShowAll.setFocusable(false);
        bShowAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowAllActionPerformed(evt);
            }
        });
        getContentPane().add(bShowAll);
        bShowAll.setBounds(20, 370, 80, 30);

        setSize(new java.awt.Dimension(355, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDeliveryTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeliveryTermKeyReleased
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM new_po_delivery_term WHERE delivery_term LIKE '" + txtDeliveryTerm.getText() + "%'");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("delivery_term"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_po_delivery_term.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtDeliveryTermKeyReleased

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if (txtDeliveryTerm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter a new Term to save", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                ResultSet rss = DBControl.getResultFromLocalDB("SELECT delivery_term FROM new_po_delivery_term WHERE delivery_term='" + txtDeliveryTerm.getText() + "'");
                if (rss.next()) {
                    update();
                } else {
                    try {
                        db.setResult("INSERT INTO new_po_delivery_term VALUES('" + txtDeliveryTerm.getText() + "')");
                        load();
                        loadCombo();
                    } catch (Exception ex) {
                        Logger.getLogger(new_po_delivery_term.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(new_po_delivery_term.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_bSaveActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if (txtDeliveryTerm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a Term to delete !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    db.setResult("DELETE From new_po_delivery_term  WHERE delivery_term='" + txtDeliveryTerm.getText() + "'");
                    txtDeliveryTerm.setText("");
                    loadCombo();
                } else if (i == 1) {
                }
                load();
            } catch (Exception ex) {
                Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_bDeleteActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_bCloseActionPerformed

    private void bShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowAllActionPerformed
        load();
}//GEN-LAST:event_bShowAllActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int i = jTable1.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        txtDeliveryTerm.setText(t1);
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new new_po_delivery_term().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bShowAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtDeliveryTerm;
    // End of variables declaration//GEN-END:variables

    private void load() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM new_po_delivery_term");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("delivery_term"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_po_delivery_term.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCombo() {
        try {
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT delivery_term FROM new_po_delivery_term");
            Vector v2 = new Vector();
            while (rs1.next()) {
                v2.add(rs1.getString("delivery_term"));
            }
            new_po.comboDeliveryTerm.setModel(new DefaultComboBoxModel(v2));
        } catch (Exception ex) {
            Logger.getLogger(new_po_delivery_term.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void update() {
        try {
            db.setResult("UPDATE new_po_delivery_term SET delivery_term = '" + txtDeliveryTerm.getText() + "' WHERE delivery_term = '" + txtDeliveryTerm.getText() + "'");
            load();
            loadCombo();
        } catch (Exception ex) {
            Logger.getLogger(new_po_deliver_to.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
