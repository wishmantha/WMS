package scm.help;

import scm.utils.systemTray;
import scm.utils.SendMail;
import scm.database.DBControl;
import scm.database.DBLocal;
import java.awt.TrayIcon;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class settings extends javax.swing.JInternalFrame {

    public static String filepath;
    public static String pdfpath;
    public static String backuppath;
    public static String fromEmail;
    public static String toEmail;
    public static String password;
    static DBControl db = new DBControl();

    // private int processComplete;
    /**
     * Creates new form new_stock
     */
    public settings() {

        initComponents();
        String unn = DBControl.getUserName();
        String pww = DBControl.getPassword();
        String ipp = DBControl.getSeverIp();
        String portt = DBControl.getSeverPort();

        txtIP1.setText(ipp);
        txtPassword1.setText(pww);
        txtUsername1.setText(unn);
        txtPort1.setText(portt);
        getFilepath();
        getPDFpath();
        getEmailSettings();
        loadIP();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        txtPassword1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JTextField();
        txtPort1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIP1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserIP = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        bUpdateFilePath = new javax.swing.JButton();
        txtFilePath = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPDFPath = new javax.swing.JTextField();
        bUpdatePDFPath = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel19 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        bSaveEmail = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setResizable(true);
        setTitle("Settings");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jTabbedPane1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtPassword1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPassword1.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPassword1.setBounds(110, 150, 220, 30);
        jLayeredPane3.add(txtPassword1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton7.setText("Update Connection");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.setBounds(90, 210, 140, 40);
        jLayeredPane3.add(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Password");
        jLabel9.setBounds(30, 150, 80, 30);
        jLayeredPane3.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Username");
        jLabel10.setBounds(30, 110, 80, 30);
        jLayeredPane3.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtUsername1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsername1.setForeground(new java.awt.Color(51, 51, 51));
        txtUsername1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtUsername1.setBounds(110, 110, 220, 30);
        jLayeredPane3.add(txtUsername1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtPort1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPort1.setForeground(new java.awt.Color(51, 51, 51));
        txtPort1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPort1.setBounds(110, 70, 220, 30);
        jLayeredPane3.add(txtPort1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Port No.");
        jLabel11.setBounds(30, 70, 80, 30);
        jLayeredPane3.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Users and their IP addresses");
        jLabel12.setBounds(430, 20, 210, 30);
        jLayeredPane3.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtIP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIP1.setForeground(new java.awt.Color(51, 51, 51));
        txtIP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtIP1.setBounds(110, 30, 220, 30);
        jLayeredPane3.add(txtIP1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblUserIP.setAutoCreateRowSorter(true);
        tblUserIP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblUserIP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "IP Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUserIP);
        tblUserIP.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblUserIP.getColumnModel().getColumn(1).setPreferredWidth(100);

        jScrollPane1.setBounds(430, 50, 320, 270);
        jLayeredPane3.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Server IP");
        jLabel14.setBounds(30, 30, 80, 30);
        jLayeredPane3.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Database Connectivity", new javax.swing.ImageIcon(getClass().getResource("/images/dbconnectivity.png")), jLayeredPane3); // NOI18N

        bUpdateFilePath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        bUpdateFilePath.setText("Update File Path");
        bUpdateFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateFilePathActionPerformed(evt);
            }
        });
        bUpdateFilePath.setBounds(250, 80, 170, 40);
        jLayeredPane4.add(bUpdateFilePath, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFilePath.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFilePath.setForeground(new java.awt.Color(51, 51, 51));
        txtFilePath.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFilePath.setBounds(110, 30, 590, 30);
        jLayeredPane4.add(txtFilePath, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("File Path :");
        jLabel17.setBounds(30, 30, 80, 30);
        jLayeredPane4.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtPDFPath.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPDFPath.setForeground(new java.awt.Color(51, 51, 51));
        txtPDFPath.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPDFPath.setBounds(110, 140, 590, 30);
        jLayeredPane4.add(txtPDFPath, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bUpdatePDFPath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bUpdatePDFPath.setText("Update PDF Path");
        bUpdatePDFPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdatePDFPathActionPerformed(evt);
            }
        });
        bUpdatePDFPath.setBounds(250, 190, 170, 40);
        jLayeredPane4.add(bUpdatePDFPath, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Example: C:\\\\Dropbox\\\\SCM Files\\\\Reports\\\\JRXML\\\\");
            jLabel3.setBounds(110, 60, 290, 20);
            jLayeredPane4.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel18.setText("PDF Path :");
            jLabel18.setBounds(30, 140, 80, 30);
            jLayeredPane4.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

            jLabel7.setText("Example: C:\\\\Dropbox\\\\SCM Files\\\\Reports\\\\PDF\\\\");
                jLabel7.setBounds(110, 170, 290, 20);
                jLayeredPane4.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

                jTabbedPane1.addTab("Set File Path", new javax.swing.ImageIcon(getClass().getResource("/images/file.png")), jLayeredPane4); // NOI18N

                jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                jLabel19.setText("Password :");
                jLabel19.setBounds(20, 60, 80, 30);
                jLayeredPane5.add(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

                txtFrom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                txtFrom.setForeground(new java.awt.Color(51, 51, 51));
                txtFrom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
                txtFrom.setBounds(100, 20, 380, 30);
                jLayeredPane5.add(txtFrom, javax.swing.JLayeredPane.DEFAULT_LAYER);

                jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                jLabel20.setText("From :");
                jLabel20.setBounds(20, 20, 80, 30);
                jLayeredPane5.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);

                txtTo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                txtTo.setForeground(new java.awt.Color(51, 51, 51));
                txtTo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
                txtTo.setBounds(100, 100, 380, 30);
                jLayeredPane5.add(txtTo, javax.swing.JLayeredPane.DEFAULT_LAYER);

                jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                jLabel22.setText("To :");
                jLabel22.setBounds(20, 100, 80, 30);
                jLayeredPane5.add(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);

                txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                txtPassword.setBounds(100, 60, 230, 30);
                jLayeredPane5.add(txtPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

                bSaveEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
                bSaveEmail.setText("Save");
                bSaveEmail.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bSaveEmailActionPerformed(evt);
                    }
                });
                bSaveEmail.setBounds(120, 150, 100, 40);
                jLayeredPane5.add(bSaveEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);

                jButton2.setText("Test Email");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton2ActionPerformed(evt);
                    }
                });
                jButton2.setBounds(240, 150, 81, 40);
                jLayeredPane5.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

                jTabbedPane1.addTab("Email Settings", new javax.swing.ImageIcon(getClass().getResource("/images/email.png")), jLayeredPane5); // NOI18N

                getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1020, 450));

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    try {
        String userName = txtUsername1.getText();
        db.SetUserName(userName);
        String uu = DBControl.getUserName();
        System.out.println("Username is  " + uu);

        String pass = txtPassword1.getText();
        db.setPassword(pass);
        String pp = DBControl.getPassword();
        System.out.println("Password is  " + pp);

        String serverIP = txtIP1.getText();
        db.setSeverIp(serverIP);
        String ii = DBControl.getSeverIp();
        System.out.println("IP is  " + ii);

        String serverPort = txtPort1.getText();
        db.setSeverPort(serverPort);
        String po = DBControl.getSeverPort();
        System.out.println("Port is  " + po);

        DBLocal.InsertEditDelete("UPDATE db  set username= '" + userName + "',password = '" + pass + "',ip = '" + serverIP + "',port = '" + serverPort + "' WHERE id = '1'");
        db.setResult("UPDATE db  set username= '" + userName + "',password = '" + pass + "',host = '" + serverIP + "',port = '" + serverPort + "' WHERE id = '1'");
        JOptionPane.showMessageDialog(null, "Update Connection Successful");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Database Connection Update Failed. Please Try Again !", "Error", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton7ActionPerformed

    private void bUpdateFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateFilePathActionPerformed
        filepath = txtFilePath.getText();
        System.out.println(filepath);
        try {
            db.setResult("UPDATE file_path set file_path= '" + filepath + "' WHERE id= '1' ");
            JOptionPane.showMessageDialog(null, "File path updated Successful");
        } catch (Exception ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }



    }//GEN-LAST:event_bUpdateFilePathActionPerformed

    private void bUpdatePDFPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdatePDFPathActionPerformed
        pdfpath = txtPDFPath.getText();
        try {
            db.setResult("UPDATE file_path set file_path= '" + pdfpath + "' WHERE id= '2' ");
            JOptionPane.showMessageDialog(null, "PDF path updated Successful");
        } catch (Exception ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bUpdatePDFPathActionPerformed

    private void bSaveEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveEmailActionPerformed
        try {
            String from = txtFrom.getText();
            String to = txtTo.getText();
            String pass = new String(txtPassword.getPassword());
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT efrom from email WHERE efrom = '" + from + "'");
            if (rs.next()) {
                db.setResult("UPDATE email SET epassword='" + pass + "',eto ='" + to + "' WHERE efrom = '" + from + "'");
                JOptionPane.showMessageDialog(null, "Email Settings Updated", "Email Settings Updated", JOptionPane.INFORMATION_MESSAGE);
            } else {
                db.setResult("INSERT INTO email VALUES('" + from + "','" + pass + "','" + to + "')");
                JOptionPane.showMessageDialog(null, "Email Settings Added", "New Email Settings", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        getEmailSettings();

    }//GEN-LAST:event_bSaveEmailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SendMail sm = new SendMail();
        sm.sendMail("Test Email from WMS", "This is test email generated from Settings Tab in WMS - Warehouse Management System");
        new systemTray().getTrayicon().displayMessage("Test Email Sent ", "Please check " + toEmail + " for the Test Email sent from " + fromEmail, TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bSaveEmail;
    private javax.swing.JButton bUpdateFilePath;
    private javax.swing.JButton bUpdatePDFPath;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblUserIP;
    public static javax.swing.JTextField txtFilePath;
    public static javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtIP1;
    public static javax.swing.JTextField txtPDFPath;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPassword1;
    private javax.swing.JTextField txtPort1;
    public static javax.swing.JTextField txtTo;
    private javax.swing.JTextField txtUsername1;
    // End of variables declaration//GEN-END:variables

    public void getFilepath() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("Select file_path from file_path WHERE id = '1'");
            while (rs.next()) {
                String fpath = rs.getString("file_path");
                txtFilePath.setText(fpath);
            }
        } catch (Exception ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPDFpath() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("Select file_path from file_path WHERE id = '2'");
            while (rs.next()) {
                String fpath = rs.getString("file_path");
                txtPDFPath.setText(fpath);
            }
        } catch (Exception ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void loadIP() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM ip ORDER BY user_name");
            while (rs.next()) {
                DefaultTableModel dtm = (DefaultTableModel) tblUserIP.getModel();
                Vector v = new Vector();
                v.add(rs.getString("user_name"));
                v.add(rs.getString("ip_address"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEmailSettings() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("Select * FROM email");
            while (rs.next()) {
                String f = rs.getString("efrom");
                String p = rs.getString("epassword");
                String t = rs.getString("eto");
                txtFrom.setText(f);
                txtPassword.setText(p);
                txtTo.setText(t);
                System.out.println(f + p);
                fromEmail = txtFrom.getText();
                toEmail = txtTo.getText();
                password = new String(txtPassword.getPassword());
            }

        } catch (Exception ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
