package scm.supplier;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import scm.database.DBControl;
import scm.utils.Delete;
import scm.Main;
import scm.utils.loadList;

public final class new_supplier extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    public new_supplier() {
        initComponents();
        loadList.loadSearchBarComboAllFields("supplier_details", searchBarCombo);
        try {
            load();
            // Auto Increment of Supplier_No//
//            ResultSet rs1 = DBControl.getResult("SELECT max(supplier_no) AS '99999' FROM supplier_details");
//            while (rs1.next()) {
//                int r = rs1.getInt("99999");
//                txtSupplierNo.setText("" + (r + 1));
//            }
            ////////////////////////////////////
        } catch (Exception ex) {
            Logger.getLogger(new_supplier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTel1 = new javax.swing.JTextField();
        txtContactName = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtSupplierName = new javax.swing.JTextField();
        txtSupplierNo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        txtTel2 = new javax.swing.JTextField();
        SearchOrderToolbar = new javax.swing.JToolBar();
        jLabel13 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        searchBarCombo = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bClearAccountCode = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bShowAll = new javax.swing.JButton();

        setTitle("New Supplier");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier.png"))); // NOI18N
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Suppliers");
        jLabel12.setIconTextGap(10);
        jLabel12.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Contact Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("No");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 40, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 40, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Telephone 1");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 60, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("E-mail ");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 60, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Country");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Address");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Website");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 60, 20));

        txtWeb.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtWeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 230, 20));

        txtEmail.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 230, 20));

        txtTel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 150, 20));

        txtContactName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtContactName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 220, 20));

        txtCountry.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 220, 20));

        txtSupplierName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 220, 20));

        txtSupplierNo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSupplierNo.setPreferredSize(new java.awt.Dimension(6, 15));
        txtSupplierNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSupplierNoKeyReleased(evt);
            }
        });
        getContentPane().add(txtSupplierNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 70, 20));

        txtAddress.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(txtAddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 220, 80));

        tblSupplier.setAutoCreateRowSorter(true);
        tblSupplier.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier No", "Supplier Name", "Address", "Country", "Contact Name", "Tel 1", "Tel 2", "Fax", "E-mail", "Website"
            }
        ));
        tblSupplier.setRowHeight(20);
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSupplier);
        tblSupplier.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSupplier.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblSupplier.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblSupplier.getColumnModel().getColumn(3).setPreferredWidth(15);
        tblSupplier.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblSupplier.getColumnModel().getColumn(5).setPreferredWidth(15);
        tblSupplier.getColumnModel().getColumn(6).setPreferredWidth(15);
        tblSupplier.getColumnModel().getColumn(7).setPreferredWidth(15);
        tblSupplier.getColumnModel().getColumn(8).setPreferredWidth(20);
        tblSupplier.getColumnModel().getColumn(9).setPreferredWidth(10);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 960, 230));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Telephone 2");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 60, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Fax No");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 60, 20));

        txtFax.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtFax, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 150, 20));

        txtTel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(txtTel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 150, 20));

        SearchOrderToolbar.setFloatable(false);
        SearchOrderToolbar.setRollover(true);

        jLabel13.setText("Search Table  ");
        SearchOrderToolbar.add(jLabel13);

        searchBar.setMaximumSize(new java.awt.Dimension(150, 20));
        searchBar.setPreferredSize(new java.awt.Dimension(30, 20));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });
        SearchOrderToolbar.add(searchBar);
        SearchOrderToolbar.add(jSeparator5);

        jLabel1.setText("  Sort By ");
        SearchOrderToolbar.add(jLabel1);

        searchBarCombo.setMaximumSize(new java.awt.Dimension(150, 20));
        searchBarCombo.setPreferredSize(new java.awt.Dimension(28, 15));
        SearchOrderToolbar.add(searchBarCombo);
        SearchOrderToolbar.add(jSeparator2);

        bClearAccountCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        bClearAccountCode.setBorderPainted(false);
        bClearAccountCode.setContentAreaFilled(false);
        bClearAccountCode.setFocusable(false);
        bClearAccountCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClearAccountCode.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        bClearAccountCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClearAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearAccountCodeActionPerformed(evt);
            }
        });
        SearchOrderToolbar.add(bClearAccountCode);
        SearchOrderToolbar.add(jSeparator8);

        bShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh bw.gif"))); // NOI18N
        bShowAll.setFocusable(false);
        bShowAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowAll.setIconTextGap(1);
        bShowAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowAllActionPerformed(evt);
            }
        });
        SearchOrderToolbar.add(bShowAll);

        getContentPane().add(SearchOrderToolbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 960, 30));

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
        Date today = new Date();
        long time = today.getTime();
        Timestamp ts = new Timestamp(time);
        String timestamp = ts.toString();
        String supplier_no = txtSupplierNo.getText();
        String supplier_name = txtSupplierName.getText();
        String address = txtAddress.getText();
        String country = txtCountry.getText();
        String contact_name = txtContactName.getText();
        String tel1 = txtTel1.getText();
        String tel2 = txtTel2.getText();
        String fax = txtFax.getText();
        String email = txtEmail.getText();
        String website = txtWeb.getText();
        String updated_by = Main.lblUser.getText();
        if (supplier_no.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the SUPPLIER Number", "Unable to Save", JOptionPane.ERROR_MESSAGE);
            txtSupplierNo.grabFocus();
        } else if (supplier_name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the SUPPLIER NAME", "Unable to Save", JOptionPane.ERROR_MESSAGE);
            txtSupplierName.grabFocus();
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the SUPPLIER ADDRESS", "Unable to Save", JOptionPane.ERROR_MESSAGE);
            txtAddress.grabFocus();
        } else {
            try {
                ResultSet rss = DBControl.getResultFromLocalDB("SELECT * From supplier_details WHERE supplier_no='" + txtSupplierNo.getText() + "'");
                if (rss.next()) {
                    String sup_name = rss.getString("supplier_name");
                    String sup_address = rss.getString("address");
                    int i = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to update existing supplier [ " + supplier_no + " ] with following details ? \n"
                            + "<------Current details------>\n• Name: " + sup_name + "\n• Address: " + sup_address + "\n\n"
                            + "<------New details------>\n• Name: " + supplier_name + "\n• Address: " + address + "\n",
                            "Confirm", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        update();
                    }
                } else {
                    db.setResult("INSERT INTO supplier_details(supplier_no,supplier_name,address,"
                            + "country,contact_name,tel_no1,tel_no2,fax_no,email_add,web_add,user,time) "
                            + "VALUES('" + supplier_no + "','" + supplier_name + "','" + address + "',"
                            + "'" + country + "','" + contact_name + "','" + tel1 + "','" + tel2 + "',"
                            + "'" + fax + "','" + email + "','" + website + "','" + updated_by + "','" + timestamp + "')");
                //    JOptionPane.showMessageDialog(null, "Successfully Saved");
                    load();
                }
            } catch (Exception ex) {
                Logger.getLogger(new_supplier.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Supplier was not saved ! \n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if (txtSupplierNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Supplier Number to DELETE !", "Error", JOptionPane.ERROR_MESSAGE);
            txtSupplierNo.grabFocus();
        } else {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    String sql = "DELETE From supplier_details  WHERE supplier_no ='" + txtSupplierNo.getText() + "'";
                    Delete.Delete(sql);
                    clear();
                    txtSupplierNo.grabFocus();
                }
                load();
            } catch (Exception ex) {
                Logger.getLogger(new_supplier.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Supplier was NOT deleted \n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void txtSupplierNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierNoKeyReleased
        String stock_code = txtSupplierNo.getText();
        String sql = "SELECT * FROM supplier_details WHERE supplier_no LIKE '" + stock_code + "%'";
        loadSupplierList.loadSupplierList(sql, tblSupplier);
        clearWithoutSupNo();
    }//GEN-LAST:event_txtSupplierNoKeyReleased

    private void bShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowAllActionPerformed
        load();
    }//GEN-LAST:event_bShowAllActionPerformed

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
        int i = tblSupplier.getSelectedRow();
        JTable dtm = (JTable) evt.getSource();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();
        String t3 = dtm.getValueAt(i, 2).toString();
        String t4 = dtm.getValueAt(i, 3).toString();
        String t5 = dtm.getValueAt(i, 4).toString();
        String t6 = dtm.getValueAt(i, 5).toString();
        String t7 = dtm.getValueAt(i, 6).toString();
        String t8 = dtm.getValueAt(i, 7).toString();
        String t9 = dtm.getValueAt(i, 8).toString();
        String t10 = dtm.getValueAt(i, 9).toString();

        txtSupplierNo.setText(t1);
        txtSupplierName.setText(t2);
        txtAddress.setText(t3);
        txtCountry.setText(t4);
        txtContactName.setText(t5);
        txtTel1.setText(t6);
        txtTel2.setText(t7);
        txtFax.setText(t8);
        txtEmail.setText(t9);
        txtWeb.setText(t10);
    }//GEN-LAST:event_tblSupplierMouseClicked

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_bCloseActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        String comboText = searchBarCombo.getSelectedItem().toString();
        System.out.println(comboText);
        String sql = "SELECT * FROM supplier_details "
                + "WHERE  " + comboText + " LIKE '" + searchBar.getText() + "%' "
                + "ORDER BY supplier_no ASC ";
        loadList.searchToolbar(tblSupplier, sql, "Supplier");
    }//GEN-LAST:event_searchBarKeyReleased

    private void bClearAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearAccountCodeActionPerformed

        loadList.clearSearchBar(searchBar, searchBarCombo, tblSupplier);

    }//GEN-LAST:event_bClearAccountCodeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar SearchOrderToolbar;
    private javax.swing.JButton bClearAccountCode;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bShowAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField searchBar;
    private javax.swing.JComboBox searchBarCombo;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextPane txtAddress;
    private javax.swing.JTextField txtContactName;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierNo;
    private javax.swing.JTextField txtTel1;
    private javax.swing.JTextField txtTel2;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables

    void load() {
        String sql = "SELECT * FROM supplier_details ORDER BY supplier_no ASC";
        //loadList.loadSupplierList(sql,tblSupplier);
        loadList.loadTableColumns(tblSupplier, sql);
    }

    private void update() {
        if (txtSupplierNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Supplier Number to Update !", "Error", JOptionPane.ERROR_MESSAGE);
            txtSupplierNo.grabFocus();
        } else {
            try {
                Date today = new Date();
                long time = today.getTime();
                Timestamp ts = new Timestamp(time);
                String timestamp = ts.toString();
                String supplier_no = txtSupplierNo.getText();
                String supplier_name = txtSupplierName.getText();
                String address = txtAddress.getText();
                String country = txtCountry.getText();
                String contact_name = txtContactName.getText();
                String tel1 = txtTel1.getText();
                String tel2 = txtTel2.getText();
                String fax = txtFax.getText();
                String email = txtEmail.getText();
                String website = txtWeb.getText();
                String updated_by = Main.lblUser.getText();
                db.setResult("UPDATE supplier_details SET supplier_name='" + supplier_name + "', "
                        + "address ='" + address + "', country ='" + country + "', "
                        + "contact_name ='" + contact_name + "', tel_no1 ='" + tel1 + "', "
                        + "tel_no2 ='" + tel2 + "', fax_no ='" + fax + "', email_add ='" + email + "', "
                        + "web_add ='" + website + "',user ='" + updated_by + "',time = '" + timestamp + "' WHERE supplier_no='" + supplier_no + "'");
                
               // JOptionPane.showMessageDialog(null, "Successfully Updated", title, WIDTH);
                String sql = "SELECT * FROM supplier_details WHERE supplier_no ='" + supplier_no + "'";
                loadSupplierList.loadSupplierList(sql, tblSupplier);
            } catch (Exception ex) {
                Logger.getLogger(new_supplier.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Supplier was not saved ! \n" + ex, "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void clear() {
        txtSupplierNo.setText("");
        txtSupplierName.setText("");
        txtAddress.setText("");
        txtCountry.setText("");
        txtContactName.setText("");
        txtTel1.setText("");
        txtTel2.setText("");
        txtFax.setText("");
        txtEmail.setText("");
        txtWeb.setText("");
    }

    public void clearWithoutSupNo() {
        txtSupplierName.setText("");
        txtAddress.setText("");
        txtCountry.setText("");
        txtContactName.setText("");
        txtTel1.setText("");
        txtTel2.setText("");
        txtFax.setText("");
        txtEmail.setText("");
        txtWeb.setText("");
    }
}
