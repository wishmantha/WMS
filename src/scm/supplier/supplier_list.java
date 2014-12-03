package scm.supplier;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import scm.database.DBControl;
import scm.utils.Delete;
import scm.Main;
import scm.utils.loadList;

public class supplier_list extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    public supplier_list() {

        initComponents();
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        bShowALL = new javax.swing.JButton();
        txtSupplierName = new javax.swing.JFormattedTextField();
        bLoadSupplierNo = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSupplierNo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSupplierList = new javax.swing.JTable();

        setTitle("Supplier List");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Supplier Name");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 120, 25));

        bShowALL.setText("Show All");
        bShowALL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bShowALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowALLActionPerformed(evt);
            }
        });
        getContentPane().add(bShowALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 90, 30));

        txtSupplierName.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM/dd/yyyy"))));
        txtSupplierName.setToolTipText("MM/dd/yyyy");
        txtSupplierName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSupplierNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 200, 25));

        bLoadSupplierNo.setText("Load");
        bLoadSupplierNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadSupplierNoActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadSupplierNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, 25));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator6);

        bNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        bNew.setText("New");
        bNew.setFocusable(false);
        bNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNew.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });
        jToolBar1.add(bNew);
        jToolBar1.add(jSeparator4);

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Supplier List");
        jLabel12.setIconTextGap(10);
        jLabel12.setPreferredSize(new java.awt.Dimension(850, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Supplier No");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 25));

        txtSupplierNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSupplierNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSupplierNoKeyReleased(evt);
            }
        });
        getContentPane().add(txtSupplierNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, 25));

        tblSupplierList.setAutoCreateRowSorter(true);
        tblSupplierList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSupplierList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo", "Supplier Name", "Address", "Country", "Contact Name", "Tel 1", "Tel 2", "Fax", "E-mail", "Website"
            }
        ));
        tblSupplierList.setRowHeight(22);
        tblSupplierList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSupplierList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSupplierList);
        tblSupplierList.getColumnModel().getColumn(0).setPreferredWidth(25);
        tblSupplierList.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblSupplierList.getColumnModel().getColumn(5).setPreferredWidth(80);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 970, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bShowALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowALLActionPerformed
        load();
}//GEN-LAST:event_bShowALLActionPerformed

    private void bLoadSupplierNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadSupplierNoActionPerformed
        String supplier_no = txtSupplierNo.getText();
        String sql = "SELECT * FROM supplier_details WHERE supplier_no LIKE '" + supplier_no + "%'ORDER BY supplier_no ASC";
        loadSupplierList.loadSupplierList(sql, tblSupplierList);
    }//GEN-LAST:event_bLoadSupplierNoActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        Main.newsup.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bNewActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        String sup = txtSupplierNo.getText();
        if (sup.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a STOCK CODE to Delete !", "Error", JOptionPane.ERROR_MESSAGE);
            txtSupplierNo.grabFocus();
        } else {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete [ " + sup + " ] ?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    String sql = "DELETE From supplier_details  WHERE supplier_no ='" + txtSupplierNo.getText() + "'";
                    Delete.Delete(sql);
                    txtSupplierNo.setText("");
                    txtSupplierName.setText("");
                    txtSupplierNo.grabFocus();
                }
                load();
            } catch (Exception ex) {
                Logger.getLogger(new_supplier.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Supplier was NOT deleted !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void tblSupplierListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierListMouseClicked
        JTable dtm = (JTable) evt.getSource();
        int i = tblSupplierList.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        txtSupplierNo.setText(t1);
    }//GEN-LAST:event_tblSupplierListMouseClicked

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void txtSupplierNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierNoKeyReleased
        String supplier_no = txtSupplierNo.getText();
        String sql = "SELECT * FROM supplier_details "
                + "WHERE supplier_no LIKE '" + supplier_no + "%'"
                + "ORDER BY supplier_no ASC ";
        loadSupplierList.loadSupplierList(sql, tblSupplierList);
    }//GEN-LAST:event_txtSupplierNoKeyReleased

    private void txtSupplierNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierNameKeyReleased
        String supplier_name = txtSupplierName.getText();
        String sql = "SELECT * FROM supplier_details "
                + "WHERE supplier_name LIKE '" + supplier_name + "%' "
                + "ORDER BY supplier_no ASC ";
        loadSupplierList.loadSupplierList(sql, tblSupplierList);
    }//GEN-LAST:event_txtSupplierNameKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bLoadSupplierNo;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bShowALL;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblSupplierList;
    private javax.swing.JFormattedTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierNo;
    // End of variables declaration//GEN-END:variables

    private void load() {
         String sql = "SELECT * FROM supplier_details ORDER BY supplier_no ASC";
        //loadList.loadSupplierList(sql,tblSupplier);
        loadList.loadTableColumns(tblSupplierList,sql);
    }
}
