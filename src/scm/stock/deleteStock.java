package scm.stock;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import scm.database.DBControl;
import scm.Main;
import scm.utils.Permission;
import scm.utils.SendMail;

public class deleteStock {

    static DBControl db = new DBControl();
    static Date today = new Date();
    static long time = today.getTime();
    static Timestamp ts = new Timestamp(time);
    static String timestamp = ts.toString();

    public static void deleteStock(JTextField txt) {
        String stock_code = txt.getText();
        if (stock_code.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a STOCK CODE to Delete !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            txt.grabFocus();
        } else {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want"
                        + " to delete [" + stock_code + "] ? \nDeleting a stock code will result in deleting of all associated :              "
                        + "\n    Purchased Orders "
                        + "\n    GRNs "
                        + "\n    Issue Notes.", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    Permission.getPermission();
                    Boolean del = Permission.allow;
                    if (del.equals(true)) {
                        try {
                            String values = "(stock_code,account_code,stock_type,description,partno_size,"
                                    + "uom,type,bin_location,unit_price,qoh,deleted_by)";
                            String valuesWithoutBrackets = "stock_code,account_code,stock_type,description,"
                                    + "partno_size,uom,type,bin_location,unit_price,qoh,";
                            db.setResult("INSERT INTO stock_details_del" + values + " "
                                    + "SELECT " + valuesWithoutBrackets + "'" + Main.lblUser.getText() + "'"
                                    + "FROM stock_details fd WHERE stock_code='" + stock_code + "'");

                            ResultSet rs = DBControl.getResultFromLocalDB("Select * from stock_details WHERE stock_code='" + stock_code + "'");
                            while (rs.next()) {
                                String account_code = (rs.getString("account_code"));
                                String StockType = (rs.getString("stock_type"));
                                String Description = (rs.getString("description"));
                                String PartNoSize = (rs.getString("partno_size"));
                                String UOM = (rs.getString("uom"));
                                String Type = (rs.getString("type"));
                                String Plant = (rs.getString("plant"));
                                String BinLocation = (rs.getString("bin_location"));
                                String UnitPrice = (rs.getString("unit_price"));
                                String QOH = (rs.getString("qoh"));
                                SendMail sm = new SendMail();
                                sm.sendMail("Stock Code Deleted [" + stock_code + "] by " + Main.lblUser.getText(),
                                        "Stock Deleted at " + timestamp + " by " + Main.lblUser.getText() + ""
                                        + "\n\n<|-----Stock Details-----|>\n\t*Stock Code: " + stock_code + "\n\t*Account Code: " + account_code + "\n\t*Stock Type: " + StockType + ""
                                        + "\n\t*Description: " + Description + "\n\t*PartNo Size: " + PartNoSize + "\n\t*UOM: " + UOM + "\n\t*Category: " + Type + ""
                                        + "\n\t*Plant: " + Plant + "\n\t*Bin Location: " + BinLocation + "\n\t*Unit Price: " + UnitPrice + "\n\t*Quantity on Hand: " + QOH);
                            }
                            String sql = "DELETE From stock_details  WHERE stock_code='" + stock_code + "'";
                            db.setResult(sql);
                            txt.grabFocus();
                            JOptionPane.showMessageDialog(null, "Successfully Deleted");
                            Permission.allow = false;
                        } catch (Exception ex) {
                            Logger.getLogger(deleteStock.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(stock_list.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "\n" + ex, "Error ! Stock code was NOT deleted !", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
