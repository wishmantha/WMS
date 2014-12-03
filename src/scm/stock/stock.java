package scm.stock;

import com.toedter.calendar.JDateChooser;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.Main;
import scm.help.settings;

public class stock {

    public static void createPDF(String stock, JDateChooser Day1, JDateChooser Day2) {
        if (!stock.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = Day1.getDate();
                sdf.format(d1);
                Date d2 = Day2.getDate();
                sdf.format(d2);
                int stock_no = Integer.parseInt(stock);
                String reportSource = settings.filepath + "StockReport_GRNDetails.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("stock_code", stock_no);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "GRN Reports\\" + "GRN_Stock_" + stock_no + ".pdf";
                JasperExportManager.exportReportToPdfFile(jasperPrint, path);
                JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
                File file = new File(path);
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }
                try {
                    desktop.open(file);
                } catch (IOException e) {
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
                Main.errorDisplay(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a stock code to generate PDF !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void previewGRN(String stock, JDateChooser Day1, JDateChooser Day2) {
        if (!stock.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = Day1.getDate();
                sdf.format(d1);
                Date d2 = Day2.getDate();
                sdf.format(d2);
                int stock_code = Integer.parseInt(stock);
                String reportSource = settings.filepath + "StockReport_GRNDetails.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("stock_code", stock_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("GRN Stock Report [ " + stock + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
                Main.errorDisplay(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a stock code to Preview !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
