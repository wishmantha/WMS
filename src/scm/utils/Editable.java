package scm.utils;

import scm.utils.Permission;
import javax.swing.JTextField;

public class Editable {

    public static void Edit(JTextField txt) {
        Permission.getPermission();
        Boolean b = Permission.allow;
        if (b.equals(true) && !txt.isEditable()) {
            txt.setEditable(true);
            txt.grabFocus();
            Permission.allow = false;
        }
    }
}
