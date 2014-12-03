package scm.help;

import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;

public class user_accounts extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    public user_accounts() {
        initComponents();
        load();
        try {
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM login_details");
            DefaultTableModel dtm = (DefaultTableModel) tblUserHistory.getModel();
            dtm.setRowCount(0);
            while (rs1.next()) {
                Vector v = new Vector();
                v.add(rs1.getString("login_id"));
                v.add(rs1.getString("user_name"));
                v.add(rs1.getString("time"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(user_accounts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        bUpdate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bDelete = new javax.swing.JButton();
        bShowAll = new javax.swing.JButton();
        bAddUser = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUserHistory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setResizable(true);
        setTitle("User Accounts");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change_password.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator6);

        bNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        bNew.setText("New User");
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

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit User ( ADMIN RIGHTS )", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(0, 0, 102))); // NOI18N
        jPanel3.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Username :");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(30, 40, 110, 19);

        txtPW.setBackground(new java.awt.Color(247, 246, 246));
        txtPW.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtPW);
        txtPW.setBounds(140, 80, 180, 23);

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(bUpdate);
        bUpdate.setBounds(140, 120, 80, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Password :");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 80, 110, 19);

        txtUN.setBackground(new java.awt.Color(247, 246, 246));
        txtUN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtUN);
        txtUN.setBounds(140, 40, 180, 23);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(80, 170, 220, 170);

        bDelete.setText("Delete User");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(bDelete);
        bDelete.setBounds(240, 120, 90, 30);

        bShowAll.setText("Show All");
        bShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowAllActionPerformed(evt);
            }
        });
        jPanel3.add(bShowAll);
        bShowAll.setBounds(223, 350, 80, 30);

        bAddUser.setText("Add User");
        bAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddUserActionPerformed(evt);
            }
        });
        jPanel3.add(bAddUser);
        bAddUser.setBounds(40, 120, 80, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 360, 390));

        tblUserHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Login ID", "User ", "Time"
            }
        ));
        jScrollPane2.setViewportView(tblUserHistory);
        tblUserHistory.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblUserHistory.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblUserHistory.getColumnModel().getColumn(2).setPreferredWidth(140);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 340, 370));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Login History");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 140, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        txtUN.grabFocus();
        txtUN.setText("");
        txtPW.setText("");
    }//GEN-LAST:event_bNewActionPerformed

    private void bAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddUserActionPerformed
        String getusername = txtUN.getText();
        String getpassword = new String(txtPW.getPassword());
        if ((getusername.isEmpty()) && (getpassword.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please enter a new Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (getusername.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a new  Username", "Error", JOptionPane.ERROR_MESSAGE);
            txtUN.setText("");
            txtPW.setText("");
            txtUN.grabFocus();
        } else if (getpassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a new  Password", "Error", JOptionPane.ERROR_MESSAGE);
            txtPW.setText("");
            txtPW.grabFocus();
        } else {
            try {
                db.setResult("INSERT INTO login VALUES ('" + getusername + "', '" + getpassword + "')");
                JOptionPane.showMessageDialog(null, "New User Added to the System! ", title, WIDTH);
                load();
            } catch (Exception ex) {
                Logger.getLogger(user_accounts.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Connection Failed !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bAddUserActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        if (txtUN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a User to update !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String getusername = txtUN.getText();
            String getpassword = new String(txtPW.getPassword());
            try {
                db.setResult("UPDATE login SET password='" + getpassword + "' WHERE user_name='" + getusername + "'");
                JOptionPane.showMessageDialog(null, "Password Changed! ", title, WIDTH);
                load();
            } catch (Exception ex) {
                Logger.getLogger(user_accounts.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Connection Failed !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bUpdateActionPerformed
    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if (txtUN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a User to delete !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    db.setResult("DELETE FROM login WHERE user_name ='" + txtUN.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                }
                txtUN.setText("");
                txtPW.setText("");
                load();


            } catch (Exception ex) {
                Logger.getLogger(user_accounts.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                        null, "Connection Failed !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         JTable dtm = (JTable) evt.getSource();
        int i = jTable1.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();
        txtUN.setText(t1);
        txtPW.setText(t2);
    }//GEN-LAST:event_jTable1MouseClicked

    private void bShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowAllActionPerformed
        load();
    }//GEN-LAST:event_bShowAllActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddUser;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bShowAll;
    private javax.swing.JButton bUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblUserHistory;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JTextField txtUN;
    // End of variables declaration//GEN-END:variables

    private void load() {
        try {
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM login");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs1.next()) {
                Vector v = new Vector();
                v.add(rs1.getString("user_name"));
                v.add(rs1.getString("password"));
                dtm.addRow(v);


            }
        } catch (Exception ex) {
            Logger.getLogger(user_accounts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
    }
}
