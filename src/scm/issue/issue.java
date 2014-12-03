package scm.issue;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.Main;
import scm.fas.new_fas;
import scm.help.settings;

public class issue {

    public static void previewIssue(String issue) {
        if (!issue.isEmpty()) {
            try {
                int issue_no = Integer.parseInt(issue);
                String reportSource = settings.filepath + "Issue_Report.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("issue", issue_no);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("Issue Report [ " + issue_no + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                Main.errorDisplay(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Issue number to Preview !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void createPDF(String issue) {
        if (!issue.isEmpty()) {
            try {
                int issue_no = Integer.parseInt(issue);
                String reportSource = settings.filepath + "Issue_Report.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("issue", issue_no);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "Issue Reports\\" + "Issue_Report_" + issue_no + ".pdf";
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
                Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                Main.errorDisplay(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Issue number to generate PDF !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
