package scm.utils;

import scm.database.DBControl;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Permission {

    static DBControl db = new DBControl();
    public static boolean allow = false;

    public static void getPermission() {
        JPasswordField pwd = new JPasswordField();
        Font font = new Font("Verdana", Font.BOLD, 16);
        pwd.setFont(font);
        pwd.requestFocusInWindow();
        pwd.grabFocus();
        int action = JOptionPane.showConfirmDialog(null, pwd, "Enter Admin Password :", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (action == 0) {
            try {
                String pw = new String(pwd.getPassword());
                String Admin = "Admin";
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM login WHERE user_name= '" + Admin + "' and password='" + pw + "'");
                if (rs.next()) {
                    allow = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please note that, only the Administrator has permission. Please try again !\nOr contact the Admin for assistance \nanuradha_wishmantha@yahoo.com", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(Permission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
