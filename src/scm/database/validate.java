/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.database;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anuradha
 */
public class validate {
    public static void isSaved(String id, String table, String field){
        try {
           ResultSet rs = DBControl.getResultFromLocalDB("SELECT "+field+" FROM "+table+" WHERE "+field+" ='"+id+"'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, id+" was saved successfully!");
            }
        } catch (Exception ex) {
            Logger.getLogger(validate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
