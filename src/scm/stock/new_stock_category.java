package scm.stock;

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

public class new_stock_category extends javax.swing.JFrame {

    static DBControl db = new DBControl();

    public new_stock_category() {
        initComponents();
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCategory = new javax.swing.JTextField();
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
        setTitle("New Stock Category");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/uom.png")));
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("New Stock Category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 150, 30);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 150, 300, 190);

        txtCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryKeyReleased(evt);
            }
        });
        getContentPane().add(txtCategory);
        txtCategory.setBounds(20, 110, 300, 30);

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
        bShowAll.setBounds(20, 350, 80, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-339)/2, (screenSize.height-450)/2, 339, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryKeyReleased
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM new_stock_category WHERE category LIKE '" + txtCategory.getText() + "%'");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("category"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_stock_category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCategoryKeyReleased

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if (txtCategory.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter a new Category to save", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                db.setResult("INSERT INTO new_stock_category VALUES('" + txtCategory.getText() + "')");
                JOptionPane.showMessageDialog(null, "Successfully Saved");
                load();
                loadCombo();
            } catch (Exception ex) {
                Logger.getLogger(new_stock_category.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_bSaveActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if (txtCategory.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a Category to delete !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    db.setResult("DELETE From new_stock_category  WHERE category='" + txtCategory.getText() + "'");
                    txtCategory.setText("");
                    loadCombo();
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                } else if (i == 1) {
                }
                load();
            } catch (Exception ex) {
                Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Connection Failed !", "Error", JOptionPane.ERROR_MESSAGE);
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
        txtCategory.setText(t1);
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new new_stock_category().setVisible(true);
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
    private javax.swing.JTextField txtCategory;
    // End of variables declaration//GEN-END:variables

    private void load() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM new_stock_category");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("category"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_stock_category.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR " + ex);
        }
    }

    private void loadCombo() {
        try {
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT category FROM new_stock_category");
            Vector v2 = new Vector();
            while (rs1.next()) {
                v2.add(rs1.getString("category"));
            }
            new_stock.txtType.setModel(new DefaultComboBoxModel(v2));
            stock_details.txtType.setModel(new DefaultComboBoxModel(v2));
        } catch (Exception ex) {
            Logger.getLogger(new_stock_category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
