/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.replication;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scm.utils.CreateProperties;
import scm.utils.HamachiIP;
import scm.theme;
import scm.utils.FileUtil;

/**
 *
 * @author Anuradha
 */
public class Replication_Methods {

    String users_Log_FilePath = CreateProperties.getPropertyValue("USERS.LOGS_LOC");
//******************** Replication Common Methods *********************

    public Boolean isMaster() {
        Boolean result = false;
        if (HamachiIP.getHamachiIPAddress().equals(CreateProperties.getPropertyValue("SERVER"))) {
            result = true;
        }
        return result;
    }

//    public static void main(String[] args) {
//        readLines();
//    }

    public static ArrayList<String> readLines() {

        ArrayList<String> StringArray = new ArrayList<String>();
        try {
            String[] cmd = new String[]{"C:\\SCM Files\\Dropbox\\WMS Files\\mysql", "-uroot", "-p123", "-e", "show master status\\G;", "-e", "show slave status\\G;"};
            Runtime run = Runtime.getRuntime();
            Process pp = run.exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(pp.getInputStream()));
            for (String line; (line = in.readLine()) != null;) {
                StringArray.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(MasterSlaveStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        writeToFile(StringArray); //Writing output to a File to monitor ReplicationStatus remotely without logging into the machine 
        return StringArray;

    }

    public static void writeToFile(ArrayList<String> StringArray) {
     
        try {
            String folderName = theme.users_Log_FilePath + "\\" + theme.HamachiUsername + "\\";
            String fileName = theme.HamachiUsername + "_ReplicationStatus.txt";
            FileUtil.createFileIfNeeded(folderName, "Folder");
            FileUtil.createFileIfNeeded(folderName+fileName, "File");

            //Reading Already created Replication File
            Path path = Paths.get(folderName + fileName);
            List<String> lines = Files.readAllLines(path, Charset.defaultCharset());

            if (!new HashSet(lines).equals(new HashSet(StringArray))) {
                System.out.println("\n--MySQL Replication Details are NOT SAME as User Replication File. Writing new replication file");
                FileWriter fw = new FileWriter(folderName + fileName);
                for (String str : StringArray) {
                    fw.write(str + "\n");
                }
                fw.close();
            } else {
                System.out.println("\n--MySQL Replication Details are same as User Replication Text file");
            }

        } catch (IOException ex) {
            Logger.getLogger(Replication_Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
