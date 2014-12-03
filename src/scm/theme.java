package scm;

import scm.utils.CreateProperties;
import scm.utils.HamachiIP;
import scm.database.DBLocal;
import scm.replication.MasterSlaveStatus;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import scm.utils.FileUtil;

public class theme {

// <editor-fold defaultstate="collapsed" desc="Public Variables">
    public static String serverIP;
    static String serverIPFile;
    public static boolean serverConnection;
    public static Boolean GoodToGO = false;
    public static String PropertyFileName = "C:\\SCM Files\\Dropbox\\WMS Files\\config.properties";
    //static Replication_Methods replication = new Replication_Methods();
    public static String HamachiUsername = HamachiIP.getHamachiUsername();
    public static String users_Log_FilePath = CreateProperties.getPropertyValue("USERS.LOGS_LOC");
    //  public static PrintStream orig = System.out;
    //  public static PrintStream ps;;

// </editor-fold>
    public static void main(String[] args) throws FileNotFoundException {

        try {
            // ps = new PrintStream("C:\\SCM Files\\Dropbox\\WMS Files\\WMS New Version\\fileOutput " + System.currentTimeMillis() + ".txt");
            //   System.setOut(ps);
            System.out.println("\nTHEME: 1.Welcome to WMS! System Started");

            System.out.println("\nTHEME: 2.Property File");
            FileUtil.createFileIfNeeded(PropertyFileName, "File");

            System.out.println("\nTHEME: 3.Log File Setup");
            setupLOG();

            System.out.println("\nTHEME: 4.Dropbox");
            startDropbox();

            System.out.println("\nTHEME: 5.Hamachi");
            startHamachi();

            System.out.println("\nTHEME: 6.Theme Set");

            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

            System.out.println("\nTHEME: 7.Ping Server");
            readIP();
            pingServer();

         //   startSystem();
            System.out.println("\nTHEME: 8.Server Connection");
              keepChecking();

            Thread.sleep(10000); // To let Serverconnection variable to be ONLINE, or else Replication will use it as NULL. 

            System.out.println("\nTHEME: 9.Database Replication");
            System.out.println("\nTHEME:  --GOOD TO GO BEFORE MasterSlave Status:" + GoodToGO);
            System.out.println("THEME: 10.Checking MasterSlave Status");
            //if (theme.serverConnection != null && theme.serverConnection) {
            if (theme.serverConnection) {
                MasterSlaveStatus MasterSlave = new MasterSlaveStatus();
            }
            System.out.println("THEME:  --TO GO AFTER MasterSlave Status:" + GoodToGO);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//            |||
//            |||
//            |||
//         \\\|||///
//          \\|||//
//            \|/

    private static void startDropbox() throws FileNotFoundException {
        try {
            Runtime runn = Runtime.getRuntime();
            String cmd = "C:\\SCM Files\\Dropbox\\WMS Files\\Dropbox.exe";
            Process pp = runn.exec(cmd);
            System.out.println("\n--Starting Dropbox");
        } catch (IOException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//            |||
//            |||
//            |||
//         \\\|||///
//          \\|||//
//            \|/

    private static void startHamachiUI() throws FileNotFoundException {
        try {
            Runtime run = Runtime.getRuntime();
            String cmd = "C:\\SCM Files\\Dropbox\\WMS Files\\hamachi-2-ui";
            Process pp = run.exec(cmd);
            System.out.println("\n--Starting Hamachi UI");
        } catch (IOException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//            |||
//            |||
//            |||
//         \\\|||///
//          \\|||//
//            \|/

    private static void startHamachi() throws FileNotFoundException {
        try {
            Runtime run = Runtime.getRuntime();
            String cmd = "C:\\SCM Files\\Dropbox\\WMS Files\\hamachi-2";
            Process pp = run.exec(cmd);
            System.out.println("\n--Starting Hamachi");
            startHamachiUI();
            System.out.println("\n--Retrieving Hamachi IP Address");
            HamachiIP.getHamachiIPAddress();
            System.out.println("\n--Hamachi IP is " + HamachiIP.HamachiIPAddress);
        } catch (IOException ex) {
            Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//            |||
//            |||
//            |||
//         \\\|||///
//          \\|||//
//            \|/

    private static void readIP() {
        serverIP = CreateProperties.getPropertyValue("SERVER");
    }

    public static void pingServer() throws UnknownHostException, IOException {
        InetAddress address = InetAddress.getByName(serverIP);
        System.out.println("\n--Server IP from Text file is :" + serverIP);
        boolean reachable = address.isReachable(5000); // timeout Period
        System.out.println(reachable);
        if (reachable) {
            System.out.println("Reachable-----------------------------");
        }
        if (!reachable) {
            int i = JOptionPane.showConfirmDialog(null, "Server is Offline ! Server IP: " + serverIP + " "
                    + "\nPlease contact Administrator to Switch on the Server."
                    + "\nOr RESTART WMS again!"
                    + "\n\tPlease do NOT update data when the server is Offline. "
                    + "You may just view previous data!"
                    + "\n\t\t Click YES to continue"
                    + "\n\t\t Click No to EXIT ",
                    "Error connecting to Server", JOptionPane.ERROR_MESSAGE);
            if (i == 0) {
                startSystem();
            } else {
                System.exit(0);
            }
        } else {
            startSystem();
        }
    }

//            |||
//            |||
//            |||
//         \\\|||///
//          \\|||//
//            \|/
    public static void startSystem() {
        System.out.println("\n***************************Starting System***************************");
        GoodToGO = true;
        System.out.println("\n--GOOD TO GO :" + GoodToGO);
        startGUI();
        //  new login().setVisible(true);
    }
//            |||
//            |||
//            |||
//         \\\|||///
//          \\|||//
//            \|/

    private static void startGUI() {
        System.out.println("\n--Starting GUI");
        if (GoodToGO) {
            try {
                ResultSet r = DBLocal.Search("SELECT * FROM theme");
                while (r.next()) {
                    String s = r.getString("theme");
                    System.out.println("\n--Theme detected from Local Database :" + s);
                    new login().setVisible(true);
                }
            } catch (Exception e) {
                Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "Database Connection to local Server (local_rr) failed ! Contact Administrator ! (anuradha_wishmantha@yahoo.com) " + "Error Details : " + e, "WMS Failed to start !", JOptionPane.ERROR_MESSAGE);
                //  JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "System CANNOT PROCEED! - Database Replication has failed \nError Code: 'GoodToGo: FALSE' \nContact Administrator. WMS will now exit. ", "Replication Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }
//            |||
//            |||
//            |||
//         \\\|||///
//          \\|||//
//            \|/

    public static void keepChecking() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //  System.out.println("%%% THREAD 1 : Keep Checking %%%");
                    try {
                        InetAddress address = InetAddress.getByName(theme.serverIP);
                        boolean reachable = address.isReachable(8000);
                        while (reachable) {
                            serverConnection = true;
                            //     System.out.print("\n%%%--<SERVER: ONLINE - CONNECTION: " + theme.serverConnection + "\n");
                            Thread.sleep(400);
                            this.run();
                        }
                        while (!reachable) {
                            serverConnection = false;
                            System.out.print("\n%%%--<SERVER: OFFLINE - CONNECTION: " + theme.serverConnection + "\n");
                            Thread.sleep(400);
                            this.run();
                        }
                    } catch (InterruptedException | IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    private static void setupLOG() {

        File user_log_file_directory = new File(users_Log_FilePath);
        if (user_log_file_directory.exists()) {
            try {
                Handler handler = new FileHandler(users_Log_FilePath + HamachiUsername, 100, 6);
                Logger.getLogger("").addHandler(handler);
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
