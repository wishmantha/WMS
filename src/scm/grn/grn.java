package scm.grn;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.Main;
import scm.help.settings;

public class grn {

    public static void createPDF(String grn) {
        if (!grn.isEmpty()) {
            try {
                int grn_no = Integer.parseInt(grn);
                String reportSource = settings.filepath + "RR_GRN1.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("grn", grn_no);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "GRN Reports\\" + "GRN_Report_" + grn_no + ".pdf";
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
            JOptionPane.showMessageDialog(null, "Please select a GRN number to generate PDF !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void previewGRN(String grn) {
        if (!grn.isEmpty()) {
            try {
                int grn_no = Integer.parseInt(grn);
                String reportSource = settings.filepath + "RR_GRN1.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("grn", grn_no);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("GRN Report [ " + grn + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
                Main.errorDisplay(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a GRN number to Preview !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
