package scm;

import scm.utils.CreateProperties;
import scm.utils.systemTray;
import scm.database.DBControl;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Anuradha
 */
public class login extends javax.swing.JFrame {

    boolean clicked = false;
    public static String Username;
    static DBControl db = new DBControl();
    String Server_IP = CreateProperties.getPropertyValue("SERVER");
    String Server_DB_Port = CreateProperties.getPropertyValue("SERVER.DBPORT");
    String Server_DB_User_Name = CreateProperties.getPropertyValue("SERVER.DBUSERNAME");
    String Server_DB_Password = CreateProperties.getPropertyValue("SERVER.DBPASSWORD");

    public login() {
        initComponents();
        load l = new load();
        l.setupDBControl_Parameters();
        jProgressBar1.setVisible(false);
        if (Server_IP.equals("localhost")) {
            lblServer_IP.setText("Local Database");
        } else {
            lblServer_IP.setText(Server_IP);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        loginAdmin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        txtPW = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtUN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bSetupDB = new javax.swing.JButton();
        lblServer_IP = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        loginJustin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login to Warehouse Management System");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/images/User.png")));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginAdmin.setToolTipText("");
        loginAdmin.setBorderPainted(false);
        loginAdmin.setContentAreaFilled(false);
        loginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAdminActionPerformed(evt);
            }
        });
        jPanel1.add(loginAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login cons.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 310, 310));

        bLogin.setBackground(new java.awt.Color(255, 255, 255));
        bLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bLogin.setForeground(new java.awt.Color(255, 102, 0));
        bLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginbutton.png"))); // NOI18N
        bLogin.setText("L  O  G  I  N");
        bLogin.setToolTipText("");
        bLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bLogin.setIconTextGap(20);
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        jPanel1.add(bLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 280, 40));

        txtPW.setBackground(new java.awt.Color(247, 246, 246));
        txtPW.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPWActionPerformed(evt);
            }
        });
        jPanel1.add(txtPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 180, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Username :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 100, 25));

        txtUN.setBackground(new java.awt.Color(247, 246, 246));
        txtUN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUN.setNextFocusableComponent(txtPW);
        txtUN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUNFocusLost(evt);
            }
        });
        jPanel1.add(txtUN, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 180, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Password :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 100, 25));

        bSetupDB.setForeground(new java.awt.Color(51, 51, 51));
        bSetupDB.setText("Setup Database Connection");
        bSetupDB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSetupDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSetupDBActionPerformed(evt);
            }
        });
        jPanel1.add(bSetupDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 280, 25));

        lblServer_IP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblServer_IP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(lblServer_IP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 130, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Connected to :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 90, 20));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 90, 20));

        jProgressBar1.setForeground(new java.awt.Color(102, 102, 0));
        jProgressBar1.setMaximum(30);
        jProgressBar1.setToolTipText("Loading....");
        jProgressBar1.setPreferredSize(new java.awt.Dimension(146, 6));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 280, 40));

        loginJustin.setToolTipText("");
        loginJustin.setBorderPainted(false);
        loginJustin.setContentAreaFilled(false);
        loginJustin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJustinActionPerformed(evt);
            }
        });
        jPanel1.add(loginJustin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 30, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Abstract Background.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-680, -300, 1290, 650));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 610, 610));

        setSize(new java.awt.Dimension(577, 313));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
    login();
   // System.setOut(orig);
   // ps.close();
}//GEN-LAST:event_bLoginActionPerformed

private void txtPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPWActionPerformed
    loginWithConnection();
}//GEN-LAST:event_txtPWActionPerformed

    private void txtUNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUNFocusLost
    }//GEN-LAST:event_txtUNFocusLost

    private void bSetupDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSetupDBActionPerformed
        new load().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bSetupDBActionPerformed

    private void loginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAdminActionPerformed
        if (clicked == false) {
            txtUN.setText("Admin");
            txtPW.setText("vihanga");
            loginWithConnection();
        }
    }//GEN-LAST:event_loginAdminActionPerformed

    private void loginJustinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJustinActionPerformed
        if (clicked == false) {
            txtUN.setText("Justin");
            txtPW.setText("anu");
            loginWithConnection();
        }
    }//GEN-LAST:event_loginJustinActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                    new login().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bSetupDB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblServer_IP;
    private javax.swing.JButton loginAdmin;
    private javax.swing.JButton loginJustin;
    private javax.swing.JPasswordField txtPW;
    public static javax.swing.JTextField txtUN;
    // End of variables declaration//GEN-END:variables

    void login() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String getusername = txtUN.getText();
        String getpassword = new String(txtPW.getPassword());
        String UN = "";
        String PW = "";
        if ((getusername.isEmpty()) && (getpassword.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Username and Password", "Error", JOptionPane.ERROR_MESSAGE);
            txtUN.grabFocus();
        } else if (getusername.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Username", "Error", JOptionPane.ERROR_MESSAGE);
            txtUN.setText("");
            txtPW.setText("");
            txtUN.grabFocus();
        } else if (getpassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Password", "Error", JOptionPane.ERROR_MESSAGE);
            txtPW.setText("");
            txtPW.grabFocus();
        } else {
            try {
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM login WHERE user_name= '" + getusername + "' and password='" + getpassword + "'");
                while (rs.next()) {
                    UN = rs.getString("user_name");
                    PW = rs.getString("password");
                }
                if ((getusername.equals(UN)) && (getpassword.equals(PW))) {
                    clicked = true;
                    Username = getusername;
                    new systemTray().setJframe(this);
                    systemTray tr = new systemTray();
                    tr.getTrayicon().displayMessage("Please wait !", "Loading Data from Server. This may take a few seconds! ", TrayIcon.MessageType.INFO);
                    jProgressBar1.setVisible(true);
                    bLogin.setVisible(false);
                    bSetupDB.setVisible(false);


                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                for (int i = 0; i < 104; i++) {
                                    try {
                                        Thread.sleep(50);
                                        jProgressBar1.setValue(i);
                                    } catch (InterruptedException ex) {
                                    }
                                }
                                dispose();
                                new scm.Main().setVisible(true);

                            } catch (UnknownHostException ex) {
                                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }).start();

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username/password combination! ", "Error", JOptionPane.ERROR_MESSAGE);
                    txtUN.setText("");
                    txtPW.setText("");
                    txtUN.grabFocus();
                }
                setCursor(Cursor.getDefaultCursor());
            } catch (Exception ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Login Unsuccessful. Please try again !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loginWithConnection() {
        String getusername = txtUN.getText();
        try {
            new scm.Main().setVisible(true);
            Username = getusername;
            this.dispose();
        } catch (UnknownHostException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
