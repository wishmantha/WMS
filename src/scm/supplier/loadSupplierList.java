package scm.supplier;

import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;
import scm.stock.stock_list;

public class loadSupplierList {

    public static void loadSupplierList(String sql, JTable tbl) {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB(sql);
            DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("address"));
                v.add(rs.getString("country"));
                v.add(rs.getString("contact_name"));
                v.add(rs.getString("tel_no1"));
                v.add(rs.getString("tel_no2"));
                v.add(rs.getString("fax_no"));
                v.add(rs.getString("email_add"));
                v.add(rs.getString("web_add"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }
}
