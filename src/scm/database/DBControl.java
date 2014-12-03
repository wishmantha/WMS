package scm.database;

import java.awt.TrayIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scm.Main;
import scm.utils.CreateProperties;

public class DBControl {

    private static DBControl con;
    private static String severIp = null;
    private static String severPort = null;
    private static String userName = null;
    private static String password = null;
    private static Connection remote_connection;
    private static Connection local_connection;
    private static int rowsUpdated;
    static boolean a;
    private static final String database_name = CreateProperties.getPropertyValue("SERVER.DB");

    private static Connection getLocalDB_Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            local_connection = DriverManager.getConnection("jdbc:mysql://localhost:" + getSeverPort() + "/" + database_name + "", getUserName(), getPassword());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return local_connection;
    }

    public static Connection getServerDB_Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            remote_connection = DriverManager.getConnection("jdbc:mysql://" + getSeverIp() + ":" + getSeverPort() + "/" + database_name + "", getUserName(), getPassword());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return remote_connection;
    }

    public static ResultSet getResultFromServerDB(String url) throws Exception {
        ResultSet rs = null;
        try {
            if (remote_connection == null || remote_connection.isClosed()) {
                getServerDB_Connection();
            }
            rs = remote_connection.createStatement().executeQuery(url);
        } catch (Exception e) {
            Logger.getLogger(DBControl.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Connection Failed. Please Try Again !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public static ResultSet getResultFromLocalDB(String url) throws Exception {
        ResultSet rs = null;
        try {
            if (local_connection == null || local_connection.isClosed()) {
                getLocalDB_Connection();
            }
            rs = local_connection.createStatement().executeQuery(url);
        } catch (Exception e) {
            Logger.getLogger(DBControl.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Connection Failed. Please Try Again !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public void setResult(String url) throws Exception {
//        while (theme.serverConnection == false) {
//            System.out.println("STUCK IN WHILE LOOP!! OFFLINE");
//            //theme.serverConnection = true;
//            theme.keepChecking();
//            Thread.sleep(2000);
//        }
        //   if (theme.serverConnection == true) {
        try {
            if (remote_connection == null || remote_connection.isClosed()) {
                System.out.println("CONNECTION IS NULL OR CLOSED");
                getServerDB_Connection();
            }
            rowsUpdated = remote_connection.createStatement().executeUpdate(url);
            // remote_connection.commit();
            a = false;
            isSaved();
            rowsUpdated = 0;
            remote_connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Connection Failed. Please Try Again !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // } else {
        // JOptionPane.showMessageDialog(null, "Server is Offline OR Your Internet Connection is too slow ! \nPlease contact Administrator to Switch on the Server OR Please TRY AGAIN.\n\tPlease do NOT update data when the server is Offline!", "Please Try Again", JOptionPane.ERROR_MESSAGE);
        //  throw new InvalidException("Server is Offline OR Your Internet Connection is too slow!! Manual Exception Throwed at DBControl.setResult method");
        // }
    }

    public static boolean isSaved() {
        if (rowsUpdated > 0) {
            //   JOptionPane.showMessageDialog(null, "Successfully Updated");
            Main.SystemTray.getTrayicon().displayMessage("Successfully Saved", "Data save successful!", TrayIcon.MessageType.INFO);
            System.out.println("An existing record was updated successfully!");
            a = true;
        }
        return a;
    }

    public class InvalidException extends Exception {

        public InvalidException(String message) {
            super(message);
        }
    }

    public static synchronized DBControl getInstance() {
        if (con == null) {
            con = new DBControl();
        }
        return con;
    }

    public static String getSeverIp() {
        return severIp;
    }

    public static String getSeverPort() {
        return severPort;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public void setSeverIp(String Ip) {
        severIp = Ip;
    }

    public void setSeverPort(String Port) {
        severPort = Port;
    }

    public void SetUserName(String Name) {
        userName = Name;
    }

    public void setPassword(String passWord) {
        password = passWord;
    }
}
