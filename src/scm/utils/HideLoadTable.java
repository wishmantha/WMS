package scm.utils;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HideLoadTable {

    public static void OneTable(JTable tbl, JScrollPane p1) {
        if (tbl.isVisible()) {
            tbl.setVisible(false);
            p1.setVisible(false);
        }
    }

    public static void TwoTables(JTable tbl, JScrollPane p1, JTable tbl2, JScrollPane p2) {
        if (tbl.isVisible()) {
            tbl.setVisible(false);
            p1.setVisible(false);
        }
        if (tbl2.isVisible()) {
            tbl2.setVisible(false);
            p2.setVisible(false);
        }

    }

    public static void ThreeTables(JTable tbl, JScrollPane p1, JTable tbl2, JScrollPane p2, JTable tbl3, JScrollPane p3) {
        if (tbl.isVisible()) {
            tbl.setVisible(false);
            p1.setVisible(false);
        }
        if (tbl2.isVisible()) {
            tbl2.setVisible(false);
            p2.setVisible(false);
        }
        if (tbl3.isVisible()) {
            tbl3.setVisible(false);
            p3.setVisible(false);
        }
    }
}
