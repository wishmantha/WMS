/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.utils;

import scm.database.DBControl;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anuradha
 */
public class loadList {

    public static void searchToolbar(JTable table, String sql, String ListType) {
        if ("Supplier".equals(ListType)) {
            loadList.loadTableColumns(table, sql);
        } else if ("PO".equals(ListType)) {
            loadList.loadPOList(table, sql);
        }
    }

    public static void clearSearchBar(JTextField searchBar, JComboBox searchBarCombo, JTable tbl) {
        searchBar.setText("");
        searchBarCombo.setSelectedIndex(0);
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        dtm.setRowCount(0);
    }

    public static void loadSearchBarComboAllFields(String tableName, JComboBox comboBox) {
        try {
            ResultSet rs3 = DBControl.getResultFromLocalDB("SELECT * FROM " + tableName);
            ResultSetMetaData rsmd = rs3.getMetaData();
            Integer columncount = rsmd.getColumnCount();
            int count = 1;
            Vector v3 = new Vector();
            while (count <= columncount) {
                String columnName = rsmd.getColumnName(count);
                v3.add(columnName);
                count++;
            }
            comboBox.setModel(new DefaultComboBoxModel(v3));
        } catch (Exception ex) {
            Logger.getLogger(loadList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadSearchBarComboCustomFields(String tableName, String customFields, JComboBox comboBox) {
        try {
            String field = "SELECT " + customFields + " FROM " + tableName;
            System.out.println(field);
            ResultSet rs3 = DBControl.getResultFromLocalDB("SELECT " + customFields + " FROM " + tableName);
            ResultSetMetaData rsmd = rs3.getMetaData();
            Integer columncount = rsmd.getColumnCount();
            int count = 1;
            Vector v3 = new Vector();
            while (count <= columncount) {
                String columnName = rsmd.getColumnName(count);
                v3.add(columnName);
                count++;
            }
            comboBox.setModel(new DefaultComboBoxModel(v3));
        } catch (Exception ex) {
            Logger.getLogger(loadList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadSearchBarComboSQL(String SQL, JComboBox comboBox) {
        try {
            ResultSet rs3 = DBControl.getResultFromLocalDB(SQL);
            ResultSetMetaData rsmd = rs3.getMetaData();
            Integer columncount = rsmd.getColumnCount();
            int count = 1;
            Vector v3 = new Vector();
            while (count <= columncount) {
                String columnName = rsmd.getColumnName(count);
                v3.add(columnName);
                count++;
            }
            comboBox.setModel(new DefaultComboBoxModel(v3));
        } catch (Exception ex) {
            Logger.getLogger(loadList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableColumns(JTable tbl, String sql) {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB(sql);
            //   System.out.println(" AT DB CONTROL :::::::");
            ResultSetMetaData rsmd = rs.getMetaData();
            Integer totalColumns = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                int count = 1;
                Vector v = new Vector();
                String columnName = "";
                while (count <= (totalColumns)) {
                    columnName = rsmd.getColumnName(count);
                    String columnType = rsmd.getColumnTypeName(count);
                    if (columnType.equals("int")) {
                        // System.out.println("YES INT ::::::::::::");
                        v.add(rs.getInt(columnName));
                    } else if (!columnType.equalsIgnoreCase("timestamp")) { //rs.getString is not compatible with Timestamp column type
                        //System.out.println("YES STRING :::::::::::");
                        v.add(rs.getString(columnName));
                    }
                    count++;
                }
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(loadList.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }

    public static void loadPOList(JTable tbl, String sql) {
        try {

            ResultSet rs = DBControl.getResultFromLocalDB(sql);
            DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("po_no"));
                v.add(rs.getString("po_date"));
                v.add(rs.getString("supplier_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("project_details"));
                v.add(rs.getString("remarks"));
                v.add(rs.getBigDecimal("total"));
                v.add(rs.getString("user"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(loadList.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }
}
