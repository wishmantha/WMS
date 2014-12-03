/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.replication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import scm.utils.CreateProperties;
import scm.utils.HamachiIP;
import scm.theme;
import static scm.replication.MasterSlaveStatus.replication;
import scm.utils.SystemTime;

/**
 *
 * @author Anuradha
 */
public class Replication_Slave_Methods {

    //Checks on Slave
    String SQL_Running = "Slave_SQL_Running: Yes";// Slave working on condition
    String SQL_Running_NO = "Slave_SQL_Running: No";// Slave not running
    String Slave_IO_Running = "Slave_IO_Running: Yes";
    String Slave_IO_Running_No = "Slave_IO_Running: No";
    String Master_Log_File = "Master_Log_File";
    String Seconds_Behind_Master_NULL = "Seconds_Behind_Master: NULL";// Slave not connected to master
    String Seconds_Behind_Master_ZERO = "Seconds_Behind_Master: 0";// Slave not connected to master
    String Slave_IO_State_Connecting = "Connecting to master";//Slave not accepted by Master, GRANT REPLICATION TO SLAVE by MASTER
    //
    String StartSlave = "START SLAVE;";
    String StopSlave = "STOP SLAVE;";

    public void slaveNotAcceptedByMaster() {
        if (replication.readLines().toString().contains(Slave_IO_State_Connecting)) {
            // JOptionPane.showMessageDialog(null, "Slave not accepted by Master. Press OK to continue");
            System.out.println(">--Slave not accepted by Master");
            String MyIP = HamachiIP.getHamachiIPAddress();
            String MySQLCommand = "GRANT REPLICATION SLAVE ON *.* TO 'slave_user'@" + MyIP + " IDENTIFIED BY '123';";
            String[] cmd = new String[]{"C:\\SCM Files\\Dropbox\\WMS Files\\mysql", "-uroot", "-p123", "-e", MySQLCommand};

            CreateProperties.newProperty("SERVER.EXECUTE", "TRUE");
            CreateProperties.newProperty("SERVER.EXECUTECOMMAND", cmd);
            CreateProperties.newProperty("SERVER.LASTEXECUTEDCOMMAND", cmd);
            CreateProperties.newProperty("SERVER.LASTEXECUTE_BYUSER", theme.HamachiUsername + " at " + SystemTime.getCurrentDateTime());

            System.out.println(">--Slave created Properties in Property config");
        }
    }

    public void secondsBehindMasterNULL() {
        if (replication.readLines().toString().contains(Seconds_Behind_Master_NULL)) {
            //   JOptionPane.showMessageDialog(null, "Seconds_Behind_Master = NULL ");
            System.out.println(">--Seconds_Behind_Master = NULL ");
            String MySQLCommand = StopSlave + "CHANGE MASTER TO MASTER_HOST='" + CreateProperties.getPropertyValue("SERVER") + "',"
                    + "MASTER_USER='slave_user',MASTER_PASSWORD='123',MASTER_PORT=3306,"
                    + "MASTER_LOG_FILE='mysql-bin." + Replication_Master_Methods.getMasterFileProperty() + "',"
                    + "MASTER_LOG_POS=" + Replication_Master_Methods.getMasterPositionProperty() + ","
                    + "MASTER_CONNECT_RETRY=10;" + StartSlave;
            System.out.println(MySQLCommand);
            String[] CommandToExecute = new String[]{"C:\\SCM Files\\Dropbox\\WMS Files\\mysql", "-uroot", "-p123", "-e", MySQLCommand};
            Runtime run = Runtime.getRuntime();
            try {
                Process pp = run.exec(CommandToExecute);
                System.out.println("\n %%%%%%%%% EXECUTED COMMAND AT SERVER : " + MySQLCommand);
            } catch (IOException ex) {
                Logger.getLogger(MasterSlaveStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void secondsBehindMasterZERO() {
        if (replication.readLines().toString().contains(Seconds_Behind_Master_ZERO)) {
            theme.GoodToGO = true;
            System.out.println(">--%%%%%% SLAVE GOOD TO GO %%%%%%");
        }
    }

    private static void ErrorReplicate() {
        try {
            String[] cmd = new String[]{"C:\\SCM Files\\Dropbox\\WMS Files\\mysql", "-uroot", "-p123", "-e", "STOP SLAVE; CHANGE MASTER TO MASTER_HOST='25.144.201.136',MASTER_USER='slave_user',MASTER_PASSWORD='123',"
                + "MASTER_PORT=3306,MASTER_LOG_FILE='mysql-bin.000011',MASTER_LOG_POS=79,MASTER_CONNECT_RETRY=10; START SLAVE;"};
            Runtime run = Runtime.getRuntime();
            Process pp = run.exec(cmd);
        } catch (IOException ex) {
            Logger.getLogger(Replication_Slave_Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        //    ErrorReplicate();
    }
}
