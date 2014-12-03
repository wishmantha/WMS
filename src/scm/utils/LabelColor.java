
package scm.utils;

import java.awt.Color;
import javax.swing.JLabel;

public class LabelColor {
    public static void colorRed(JLabel lbl) {
        lbl.setForeground(Color.red);
    }
    public static void colorBlack(JLabel lbl) {
        lbl.setForeground(Color.black);
    }
    
    public static void lblMouseEntered(java.awt.event.MouseEvent evt, JLabel lbl) {                                      
        colorRed(lbl);
    }   
    public static void lblMouseExited(java.awt.event.MouseEvent evt, JLabel lbl) {                                      
        colorBlack(lbl);
    } 
}
