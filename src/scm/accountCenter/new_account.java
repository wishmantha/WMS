package scm.accountCenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import scm.database.DBControl;
import scm.utils.Delete;
import scm.utils.loadList;

public class new_account extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    public new_account() {
        initComponents();
        load();
        JTableHeader header = tblAccount.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        Font tableHeader = new Font("Tahoma", Font.BOLD, 13);
        header.setFont(tableHeader);
        header.setForeground(Color.BLACK);
        TableCellRenderer renderer = header.getDefaultRenderer();
        JLabel label = (JLabel) renderer;
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bSave = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAccountCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAccountDescription = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        bShowAllAccount = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rbExpense = new javax.swing.JRadioButton();
        rbAsset = new javax.swing.JRadioButton();
        txtType = new javax.swing.JTextField();

        setTitle("Account Center");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new cost_center.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jToolBar1.add(jSeparator2);

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
        jLabel12.setText("Account Center");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(600, 37));
        jLabel12.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Account Type");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 30));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Description");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 30));

        txtAccountCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAccountCode.setNextFocusableComponent(txtAccountDescription);
        txtAccountCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAccountCodeKeyReleased(evt);
            }
        });
        getContentPane().add(txtAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 230, 30));

        txtAccountDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(txtAccountDescription);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 230, 50));

        tblAccount.setAutoCreateRowSorter(true);
        tblAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Code", "Description", "Type"
            }
        ));
        tblAccount.setRowHeight(22);
        tblAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccountMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAccount);
        tblAccount.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblAccount.getColumnModel().getColumn(1).setPreferredWidth(250);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 490, 390));

        bShowAllAccount.setText("Show All");
        bShowAllAccount.setFocusable(false);
        bShowAllAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowAllAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bShowAllAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowAllAccountActionPerformed(evt);
            }
        });
        getContentPane().add(bShowAllAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 80, 30));

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Account Code");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        buttonGroup1.add(rbExpense);
        rbExpense.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rbExpense.setText("Expense");
        rbExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbExpenseActionPerformed(evt);
            }
        });
        getContentPane().add(rbExpense, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        buttonGroup1.add(rbAsset);
        rbAsset.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rbAsset.setText("Asset");
        rbAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAssetActionPerformed(evt);
            }
        });
        getContentPane().add(rbAsset, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        txtType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            clear();
        } else if (i == 1) {
            JOptionPane.showMessageDialog(null, "Please Save the changes", "UPDATE", WIDTH, null);
        }
    }//GEN-LAST:event_bNewActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if (txtAccountCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Account Code", "Error", JOptionPane.ERROR_MESSAGE);
            txtAccountDescription.grabFocus();
        } else if (txtAccountDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Account description", "Error", JOptionPane.ERROR_MESSAGE);
            txtAccountDescription.grabFocus();
        } else if (txtType.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an Account Type", "Error", JOptionPane.ERROR_MESSAGE);
            txtType.grabFocus();
        } else {
            try {
                ResultSet rss = DBControl.getResultFromLocalDB("SELECT account_code FROM account_center WHERE account_code='" + txtAccountCode.getText() + "'");
                if (rss.next()) {
                    update();
                } else {
                    try {
                        String account_code = txtAccountCode.getText();
                        String description = txtAccountDescription.getText();
                        String type = txtType.getText();
                        db.setResult("INSERT INTO account_center  VALUES('" + account_code + "','" + description + "','" + type + "')");
                        load();
                    } catch (Exception ex) {
                        Logger.getLogger(new_account.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(new_account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if (txtAccountCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Account Code to Delete", "Error", JOptionPane.ERROR_MESSAGE);
            txtAccountCode.grabFocus();
        } else {
            try {
                String account_code = txtAccountCode.getText();
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    String sql = "DELETE From account_center  WHERE account_code='" + account_code + "'";
                    Delete.Delete(sql);
                    clear();
                }
                load();
            } catch (Exception ex) {
                Logger.getLogger(new_account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void txtAccountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyReleased
        try {
            String account_code = txtAccountCode.getText();
            String s2 = account_code.toUpperCase();
            txtAccountCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code LIKE '" + account_code + "%' ORDER BY account_code");
            DefaultTableModel dtm = (DefaultTableModel) tblAccount.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("account_code"));
                v.add(rs.getString("description"));
                v.add(rs.getString("type"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_account.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtAccountCodeKeyReleased

    private void bShowAllAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowAllAccountActionPerformed
        load();
    }//GEN-LAST:event_bShowAllAccountActionPerformed

    private void tblAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountMouseClicked
        int i = tblAccount.getSelectedRow();
        JTable m = (JTable) evt.getSource();
        String t1 = m.getValueAt(i, 0).toString();
        String t2 = m.getValueAt(i, 1).toString();
        String t3 = m.getValueAt(i, 2).toString();
        txtAccountCode.setText(t1);
        txtAccountDescription.setText(t2);
        txtType.setText(t3);
        rbAsset.setSelected(false);
        rbExpense.setSelected(false);
        if (txtType.getText().equals(rbAsset.getText())) {
            rbAsset.setSelected(true);
        } else {
            rbExpense.setSelected(true);
        }
    }//GEN-LAST:event_tblAccountMouseClicked

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_bCloseActionPerformed

private void rbExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExpenseActionPerformed
    txtType.setText(rbExpense.getText());
}//GEN-LAST:event_rbExpenseActionPerformed

private void rbAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAssetActionPerformed
    txtType.setText(rbAsset.getText());
}//GEN-LAST:event_rbAssetActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bShowAllAccount;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton rbAsset;
    private javax.swing.JRadioButton rbExpense;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTextField txtAccountCode;
    private javax.swing.JTextPane txtAccountDescription;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

    private void update() {
        if (txtAccountCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Account Code to Update ", "Error", JOptionPane.ERROR_MESSAGE);
            txtAccountDescription.grabFocus();
        } else {
            try {
                String account_code = txtAccountCode.getText();
                String description = txtAccountDescription.getText();
                String type = txtType.getText();
                db.setResult("UPDATE account_center SET description='" + description + "', type='" + type + "' WHERE account_code='" + account_code + "'");
                // JOptionPane.showMessageDialog(null, "Successfully Updated", title, WIDTH);
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code ='" + account_code + "'");
                DefaultTableModel dtm = (DefaultTableModel) tblAccount.getModel();
                dtm.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getString("account_code"));
                    v.add(rs.getString("description"));
                    v.add(rs.getString("type"));
                    dtm.addRow(v);
                }
            } catch (Exception ex) {
                Logger.getLogger(new_account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void load() {
        loadList.loadTableColumns(tblAccount, "SELECT * FROM account_center ORDER BY account_code ");
    }

    private void clear() {
        txtAccountCode.setText("");
        txtAccountDescription.setText("");
        txtType.setText("");
        txtAccountCode.grabFocus();
    }
}
