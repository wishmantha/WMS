package scm.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scm.database.DBControl;
import scm.utils.Permission;

public class Delete {

    static DBControl db = new DBControl();

    public static void Delete(String sql) {
        Permission.getPermission();
        Boolean del = Permission.allow;
        if (del.equals(true)) {
            try {
                db.setResult(sql);
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                Permission.allow = false;
            } catch (Exception ex) {
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
