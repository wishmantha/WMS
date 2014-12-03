/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import scm.theme;

/**
 *
 * @author Anuradha
 */
public class CreateProperties {

    public static void newProperty(String PropertyName, String Value) {
        boolean isFileUnlocked = false;
        File PropFile = new File(theme.PropertyFileName);
        try {
            FileUtils.touch(PropFile);
            isFileUnlocked = true;
        } catch (IOException e) {
            isFileUnlocked = false;
            System.out.println(">--Error at File Lock/Unlock Check " + e);
        }
        if (!isFileUnlocked) {
            System.out.println(">--###### FILE IS LOCKED ");
        }

        if (isFileUnlocked) {
            //      System.out.println(">--%%%%%% FILE IS UNLOCKED ");
            try {
                PropertiesConfiguration config = new PropertiesConfiguration(theme.PropertyFileName);
                config.setProperty(PropertyName, Value);
                config.save();
            } catch (ConfigurationException ex) {
                Logger.getLogger(CreateProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println(">--PROPERTY FILE IS LOCKED MATE!! ");
            JOptionPane.showMessageDialog(null, "Error ! File is Locked");
        }

    }

    public static void newProperty(String PropertyName, String[] Value) {
        boolean isFileUnlocked = false;
        File PropFile = new File(theme.PropertyFileName);
        try {
            FileUtils.touch(PropFile);
            isFileUnlocked = true;
        } catch (IOException e) {
            isFileUnlocked = false;
            System.out.println(">--Error at File Lock/Unlock Check " + e);
        }
        if (!isFileUnlocked) {
            System.out.println(">--###### FILE IS LOCKED ");
        }

        if (isFileUnlocked) {
            try {
                PropertiesConfiguration config = new PropertiesConfiguration(theme.PropertyFileName);
                config.setProperty(PropertyName, Value);
                config.save();
            } catch (ConfigurationException ex) {
                Logger.getLogger(CreateProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println(">--PROPERTY FILE IS LOCKED MATE!! ");
            JOptionPane.showMessageDialog(null, "Error ! File is Locked");
        }
    }

    public static String getPropertyValue(String PropertyName) {
        String PropertyValue = null;
        try {
            PropertiesConfiguration config = new PropertiesConfiguration(theme.PropertyFileName);
            if (config.containsKey(PropertyName)) {
                PropertyValue = config.getString(PropertyName);
            } else {
                System.out.println("\n--Property " + PropertyName + " not found in property file");
            }
        } catch (ConfigurationException ex) {
            Logger.getLogger(CreateProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PropertyValue;
    }
}
