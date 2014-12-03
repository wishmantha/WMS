/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scm.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import scm.theme;

/**
 *
 * @author anuwlk
 */
public class FileUtil {

    public static void createFileIfNeeded(String fileName, String type) {
        File file = new File(fileName);
        boolean exists = file.exists();
        if (!exists) {
            try {
                if (type.equals("File")) {
                    file.createNewFile();
                } else if (type.equals("Folder")) {
                    file.mkdir();
                }
                System.out.println("\nCreateProperties:--File DOESN'T EXISTS, therefore created " + file);
            } catch (IOException ex) {
                Logger.getLogger(theme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
         //   System.out.println("\nCreateProperties:--File EXISTS " + file);
        }
    }
    
}
