package scm.purchaseOrder;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.Main;
import scm.fas.new_fas;
import scm.help.settings;

public class po {

    public static void preloadComboPO(JComboBox del_term, JComboBox pay_term, JComboBox project, JComboBox del_to, JComboBox bill_to, JComboBox vat_no) {
        try {
            String blank = "";
            ResultSet rs3 = DBControl.getResultFromLocalDB("SELECT delivery_term FROM new_po_delivery_term");
            Vector v3 = new Vector();
            v3.add(blank);
            while (rs3.next()) {
                v3.add(rs3.getString("delivery_term"));
            }
            del_term.setModel(new DefaultComboBoxModel(v3));
            //
            ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT payment_term FROM new_po_payment_term");
            Vector v4 = new Vector();
            v4.add(blank);
            while (rs4.next()) {
                v4.add(rs4.getString("payment_term"));
            }
            pay_term.setModel(new DefaultComboBoxModel(v4));
            //
            ResultSet rs5 = DBControl.getResultFromLocalDB("SELECT project_detail FROM new_po_project_detail");
            Vector v5 = new Vector();
            v5.add(blank);
            while (rs5.next()) {
                v5.add(rs5.getString("project_detail"));
            }
            project.setModel(new DefaultComboBoxModel(v5));
            //
            ResultSet rs6 = DBControl.getResultFromLocalDB("SELECT name FROM new_po_deliver_to");
            Vector v6 = new Vector();
            v6.add(blank);
            while (rs6.next()) {
                v6.add(rs6.getString("name"));
            }
            del_to.setModel(new DefaultComboBoxModel(v6));
            //
            ResultSet rs7 = DBControl.getResultFromLocalDB("SELECT bill_to FROM new_po_bill_to");
            Vector v7 = new Vector();
            while (rs7.next()) {
                v7.add(rs7.getString("bill_to"));
            }
            bill_to.setModel(new DefaultComboBoxModel(v7));
            //
            ResultSet rs8 = DBControl.getResultFromLocalDB("SELECT name FROM new_po_vat_no");
            Vector v8 = new Vector();
            while (rs8.next()) {
                v8.add(rs8.getString("name"));
            }
            vat_no.setModel(new DefaultComboBoxModel(v8));
            vat_no.setSelectedIndex(1);
        } catch (Exception ex) {
            Logger.getLogger(po.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadSup(JTable tbl) {
        try {
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM supplier_details ORDER by supplier_no");
            DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
            dtm.setRowCount(0);
            while (rs1.next()) {
                Vector v2 = new Vector();
                v2.add(rs1.getString("supplier_no"));
                v2.add(rs1.getString("supplier_name"));
                dtm.addRow(v2);
            }
        } catch (Exception ex) {
            Logger.getLogger(po.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void loadStock(JTable tblStockLoad) {
        try {
            ResultSet rs11 = DBControl.getResultFromLocalDB("SELECT * FROM stock_details ORDER by stock_code");
            DefaultTableModel dtm11 = (DefaultTableModel) tblStockLoad.getModel();
            dtm11.setRowCount(0);
            while (rs11.next()) {
                Vector v21 = new Vector();
                v21.add(rs11.getString("stock_code"));
                v21.add(rs11.getString("description"));
                v21.add(rs11.getString("partno_size"));
                v21.add(rs11.getString("uom"));
                dtm11.addRow(v21);
            }
        } catch (Exception ex) {
            Logger.getLogger(po.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void previewPO(String po) {
        if (!po.isEmpty()) {
            try {
                String reportSource = settings.filepath + "RR_PO1.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("po", po);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("Purchase Order Report [ " + po + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(po.class.getName()).log(Level.SEVERE, null, ex);
                Main.errorDisplay(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a PO number to Preview !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void createPDF(String po) {
        if (!po.isEmpty()) {
            try {
                Date dated = new Date();
                SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd hh-mm");
                String d = sdff.format(dated);
                String reportSource = settings.filepath + "RR_PO1.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("po", po);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "PO Reports\\" + "Purchase_Order_" + po + "( " + d + " )" + ".pdf";
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
                Main.errorDisplay(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a PO number to generate PDF !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
