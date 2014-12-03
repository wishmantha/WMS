package scm;

import scm.utils.CreateProperties;
import scm.database.DBControl;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class load extends javax.swing.JFrame {

    DBControl db = new DBControl();
    String Server_IP = CreateProperties.getPropertyValue("SERVER");
    String Server_DB_Port = CreateProperties.getPropertyValue("SERVER.DBPORT");
    String Server_DB_User_Name = CreateProperties.getPropertyValue("SERVER.DBUSERNAME");
    String Server_DB_Password = CreateProperties.getPropertyValue("SERVER.DBPASSWORD");

    public load() {
        try {
            initComponents();
            txtIP.setText(Server_IP);
            txtPassword.setText(Server_DB_Password);
            txtPort.setText(Server_DB_Port);
            txtUsername.setText(Server_DB_User_Name);
        } catch (Exception ex) {
            Logger.getLogger(load.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        bTestConnection = new javax.swing.JButton();
        bLocalhost = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Connectivity Diagnosis");
        setIconImage(Toolkit.getDefaultToolkit().getImage(load.class.getResource("/images/backup_location.png")));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword);
        txtPassword.setBounds(110, 160, 220, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 160, 80, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Username");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 120, 80, 30);

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(51, 51, 51));
        txtUsername.setBorder(null);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername);
        txtUsername.setBounds(110, 120, 220, 30);

        txtPort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPort.setForeground(new java.awt.Color(51, 51, 51));
        txtPort.setBorder(null);
        jPanel1.add(txtPort);
        txtPort.setBounds(110, 80, 220, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Port No.");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 80, 80, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Server IP");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 40, 80, 30);

        txtIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIP.setForeground(new java.awt.Color(51, 51, 51));
        txtIP.setBorder(null);
        jPanel1.add(txtIP);
        txtIP.setBounds(110, 40, 220, 30);

        bTestConnection.setText("Update DB Connection");
        bTestConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTestConnectionActionPerformed(evt);
            }
        });
        jPanel1.add(bTestConnection);
        bTestConnection.setBounds(110, 220, 220, 40);

        bLocalhost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bLocalhost.setForeground(new java.awt.Color(0, 102, 0));
        bLocalhost.setText("Local Database");
        bLocalhost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLocalhostActionPerformed(evt);
            }
        });
        jPanel1.add(bLocalhost);
        bLocalhost.setBounds(300, 280, 130, 25);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 280, 80, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/load_Background.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-6, -6, 510, 350);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 350);

        setSize(new java.awt.Dimension(497, 340));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void bTestConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTestConnectionActionPerformed
    updateDBControl_Parameters();
}//GEN-LAST:event_bTestConnectionActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    System.exit(0);
}//GEN-LAST:event_jButton1ActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void bLocalhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLocalhostActionPerformed
        txtIP.setText("localhost");
        txtPassword.setText("123");
        txtPort.setText("3306");
        txtUsername.setText("root");
        testDBLocal();
    }//GEN-LAST:event_bLocalhostActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new load().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLocalhost;
    private javax.swing.JButton bTestConnection;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public void setupDBControl_Parameters() {
        db.setSeverIp(Server_IP);
        db.setSeverPort(Server_DB_Port);
        db.SetUserName(Server_DB_User_Name);
        db.setPassword(Server_DB_Password);
    }

    void updateDBControl_Parameters() {
        try {
            String userName = txtUsername.getText();
            String pass = txtPassword.getText();
            String serverIP = txtIP.getText();
            String serverPort = txtPort.getText();

            db.SetUserName(userName);
            db.setPassword(pass);
            db.setSeverIp(serverIP);
            db.setSeverPort(serverPort);

            CreateProperties.newProperty("SERVER", serverIP);
            CreateProperties.newProperty("SERVER.DBPORT", serverPort);
            CreateProperties.newProperty("SERVER.DBUSERNAME", userName);
            CreateProperties.newProperty("SERVER.DBPASSWORD", pass);

//            ResultSet rs = DBControl.getResult("SELECT * FROM fas_details");
//            if (rs.next()) {
//                db.setResult("UPDATE db  set username= '" + userName + "',password = '" + pass + "',host = '" + serverIP + "',port = '" + serverPort + "' WHERE id = '1'");
//                new login().setVisible(true);
//                this.dispose();
//            }
            new login().setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(load.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Database Connection Failed. Please Try Again !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void testDBLocal() {
    }
}
