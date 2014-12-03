/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.replication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import scm.utils.CreateProperties;
import scm.theme;
import scm.utils.SystemTime;

/**
 *
 * @author Anuradha
 */
public class Replication_Master_Methods {

    static Replication_Methods replication = new Replication_Methods();
    static String File = "File: mysql-bin"; // File in Show Master
    static String Position = "Position:";

    public static void main(String[] args) {
        System.out.println(getMasterPositionFromMySQL_CMD());
    }

    public static String getMasterFileProperty() {
        return CreateProperties.getPropertyValue("SERVER.FILE");
    }

    public static String getMasterPositionProperty() {
        return CreateProperties.getPropertyValue("SERVER.POSITION");
    }

    public static String getMasterFileFromMySQL_CMD() {
        System.out.println(">@--Getting Master FILE from MySQL_CMD");
        String logFile = null;
        if (replication.readLines().toString().contains(File)) {
            logFile = replication.readLines().toString();
            ArrayList<String> newArray = replication.readLines();
            String[] log = newArray.toArray(new String[newArray.size()]);
            for (int i = 0; i < log.length; i++) {
                if (log[i].contains("File")) {
                    logFile = log[1].trim();
                    String[] SplitLogFileColon = logFile.split(":");
                    logFile = SplitLogFileColon[1].trim();
                    String[] SplitLogFileFullStop = logFile.split("n.");
                    logFile = SplitLogFileFullStop[1].trim();
                    break;
                }
            }
        }
        System.out.println(">--Master File from MySQL_CMD is :" + logFile);
        return logFile;
    }

    public static void setMasterFileAndPositionProperty(final String binLog, final String position) {
        if (!getMasterFileProperty().equalsIgnoreCase(binLog) || !getMasterPositionProperty().equalsIgnoreCase(position)) {
            CreateProperties.newProperty("SERVER.FILE", binLog);
            CreateProperties.newProperty("SERVER.POSITION", position);
            CreateProperties.newProperty("SERVER.LASTUPDATE", SystemTime.getCurrentDateTime());

            System.out.println(">--Master File Property SET TO :" + getMasterFileProperty());
            System.out.println(">--Master Position Property SET TO :" + getMasterPositionProperty());
        }
    }

    public static String getMasterPositionFromMySQL_CMD() {
        String position = null;
        if (replication.readLines().toString().contains(Position)) {
            position = replication.readLines().toString();
            System.out.println(position);
            ArrayList<String> newArray = replication.readLines();
            String[] log = newArray.toArray(new String[newArray.size()]);
            for (int i = 0; i < log.length; i++) {
                if (log[i].contains("Position")) {
                    position = log[i].trim();
                    String[] SplitLogFileColon = position.split(":");
                    position = SplitLogFileColon[1].trim();
                    break;
                }
            }
        }
        System.out.println(">--Master Position from MySQL_CMD is :" + position);
        return position;
    }

    public static void executeCommandsAtMaster() {
        // new Thread(new Runnable() {
        //       @Override
        //       public void run() {
        //         System.out.println("%%%%%%%%%%%%%%%% THREAD 2 : Execute Commands at Master %%%%%%%%%%%%%%%%%%%%%");
        while (CreateProperties.getPropertyValue("SERVER.EXECUTE").equals("TRUE")) {
            System.out.println("\n------------ SERVER.EXECUTE IS TRUE ++++++++++++++");
            String[] cmdExecute = null;
            String cmd = "SERVER.EXECUTECOMMAND";
            try {
                PropertiesConfiguration config = new PropertiesConfiguration(theme.PropertyFileName);
                if (config.containsKey(cmd)) {
                    System.out.println(">--" + cmd + " property exists at Property File");
                    cmdExecute = config.getStringArray(cmd);
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < cmdExecute.length; i++) {
                        result.append(cmdExecute[i]);
                    }
                    String mynewstring = result.toString();
                    System.out.println(">--Property Value of " + cmd + " is " + mynewstring);
                    Runtime run = Runtime.getRuntime();
                    try {
                        Process pp = run.exec(cmdExecute);
                    } catch (IOException ex) {
                        Logger.getLogger(MasterSlaveStatus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    CreateProperties.newProperty("SERVER.EXECUTE", "FALSE");
                    CreateProperties.newProperty("SERVER.EXECUTECOMMAND", "");
                    CreateProperties.newProperty("SERVER.LASTEXECUTE_BYSERVER", SystemTime.getCurrentDateTime());
                }
            } catch (ConfigurationException ex) {
                Logger.getLogger(CreateProperties.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error at Execute Commands at Master " + ex, "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
    //  }).start();
    //}
}
