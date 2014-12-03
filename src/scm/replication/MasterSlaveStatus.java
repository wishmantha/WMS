/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.replication;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.configuration.PropertiesConfiguration;
import scm.Main;
import scm.theme;

/**
 *
 * @author Anuradha
 */
public class MasterSlaveStatus {

    //Properties
    static PropertiesConfiguration propConfig;
    static OutputStream output = null;
    //Checks on Master
    //static String Binlog_Do = "Binlog_Do_DB: rr,local_rr"; // check replication in MASTER
    static String File = "File: mysql-bin"; // File in Show Master
    static Replication_Methods replication = new Replication_Methods();
    static Replication_Master_Methods ReplicationMaster = new Replication_Master_Methods();
    Replication_Slave_Methods ReplicationSlave = new Replication_Slave_Methods();

    public MasterSlaveStatus() {
        System.out.println(">@--MasterSlaveStatus Constructor");
        //methods to be called at initialization

        if (replication.readLines().isEmpty()) {
            System.out.println("\n--No Replication");
            int i = JOptionPane.showConfirmDialog(null, "NO REPLICATION ON SERVER DETECTED. Do you still want to continue? "
                    + "\nYou may not have configured MySQL Replication in your computer. Refer the document - Setup MySQL Replication - Anuradha.docx", "Replication Failed", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                theme.GoodToGO = true;
            } else {
                System.exit(0);
            }
        } else {
            System.out.println(">--Are we at SLAVE or MASTER ?");
            if (replication.isMaster()) {
                System.out.println("\n*************************** @MASTER ***************************");
                checkMasterStatus();
            } else {
                System.out.println("\n*************************** @SLAVE ***************************");
                checkSlaveStatus();
            }

        }

    }

    public static void main(String[] args) {
        //    Methods to run for testing
        //   setMasterFileProperty(getMasterFileFromMySQL_CMD());
    }

    private void checkMasterStatus() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("\n%%% THREAD 3 : MASTER STATUS %%%");
                    try {
                        System.out.println(">@--Checking Master status");
                        System.out.println(">--Getting Master File and Postion from MySQL Command Line Client");
                        String MasterFileFromMySQL_CMD = Replication_Master_Methods.getMasterFileFromMySQL_CMD();
                        String MasterPositionFromMySQL_CMD = Replication_Master_Methods.getMasterPositionFromMySQL_CMD();
                        System.out.println(">--Setting Master File and Postion Properties: " + MasterFileFromMySQL_CMD + " AND " + MasterPositionFromMySQL_CMD);
                        Replication_Master_Methods.setMasterFileAndPositionProperty(MasterFileFromMySQL_CMD, MasterPositionFromMySQL_CMD);
                        Replication_Master_Methods.executeCommandsAtMaster();
                        theme.GoodToGO = true;
                        //   executeCommandsAtMaster();
                        Thread.sleep(20000); //Milliseconds 
                        this.run();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    private void checkSlaveStatus() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (theme.serverConnection) {
                    //     while (true) {
                    try {
                        System.out.println("\n%%% THREAD 2 : SLAVE STATUS %%%");
                        System.out.println(">@--Checking Slave status");
                        //Replication OK - GOOD TO GO
                        ReplicationSlave.secondsBehindMasterZERO();
                        //Slave not accepted by Master
                        ReplicationSlave.slaveNotAcceptedByMaster();
                        //Seconds behind Master is NULL, probably File and Position not in SYNC
                        ReplicationSlave.secondsBehindMasterNULL();
                        theme.GoodToGO = true;
                        Thread.sleep(10000); //Milliseconds 
                        this.run();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MasterSlaveStatus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }).start();

    }
}
