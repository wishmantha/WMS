package scm.grn;

import java.awt.Cursor;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.*;
import scm.database.DBControl;
import scm.Main;
import scm.help.settings;

public class grn_list extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    public grn_list() {

        initComponents();
        load();
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        tblGRN_List.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        tblGRN_List.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        tblGRN_List.getColumnModel().getColumn(3).setCellRenderer(dtcr);
        tblGRN_List.getColumnModel().getColumn(6).setCellRenderer(dtcr);
        JTableHeader header = tblGRN_List.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        TableCellRenderer renderer = header.getDefaultRenderer();
        JLabel label = (JLabel) renderer;
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bPrint = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bPreview = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        bPDFBASIC = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGRN_no = new javax.swing.JTextField();
        bShowALL = new javax.swing.JButton();
        removeall = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGRN_List = new javax.swing.JTable();
        bLoadGRN_no = new javax.swing.JButton();
        bLoadDate = new javax.swing.JButton();
        txtGRN_date = new com.toedter.calendar.JDateChooser();

        setTitle("GRN List");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GRN.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator6);

        bNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        bNew.setText("New");
        bNew.setFocusable(false);
        bNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNew.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });
        jToolBar1.add(bNew);
        jToolBar1.add(jSeparator4);

        bPrint.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        bPrint.setText("Print");
        bPrint.setFocusable(false);
        bPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPrint.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(bPrint);
        jToolBar1.add(jSeparator2);

        bPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        bPreview.setText("Preview");
        bPreview.setFocusable(false);
        bPreview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPreview.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPreview.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreviewActionPerformed(evt);
            }
        });
        jToolBar1.add(bPreview);
        jToolBar1.add(jSeparator7);

        bPDFBASIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFBASIC.setText("PDF");
        bPDFBASIC.setFocusable(false);
        bPDFBASIC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFBASIC.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFBASIC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFBASICActionPerformed(evt);
            }
        });
        jToolBar1.add(bPDFBASIC);
        jToolBar1.add(jSeparator8);

        bClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose.setText("Close");
        bClose.setFocusable(false);
        bClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(bClose);
        jToolBar1.add(jSeparator5);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GRN List");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(600, 37));
        jLabel12.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("GRN No");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 25));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GRN Date");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 80, 25));

        txtGRN_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtGRN_no.setNextFocusableComponent(txtGRN_date);
        txtGRN_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtGRN_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGRN_noActionPerformed(evt);
            }
        });
        txtGRN_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGRN_noKeyReleased(evt);
            }
        });
        getContentPane().add(txtGRN_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 25));

        bShowALL.setText("Show ALL");
        bShowALL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bShowALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowALLActionPerformed(evt);
            }
        });
        getContentPane().add(bShowALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, 30));

        removeall.setText("Clear Table");
        removeall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallActionPerformed(evt);
            }
        });
        getContentPane().add(removeall, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 90, 30));

        tblGRN_List.setAutoCreateRowSorter(true);
        tblGRN_List.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblGRN_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN No", "Date", "Invoice", "Supplier No", "Supplier Name", "Total", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGRN_List.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblGRN_List.setRowHeight(20);
        tblGRN_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGRN_ListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGRN_List);
        tblGRN_List.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblGRN_List.getColumnModel().getColumn(1).setPreferredWidth(15);
        tblGRN_List.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblGRN_List.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblGRN_List.getColumnModel().getColumn(4).setPreferredWidth(180);
        tblGRN_List.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblGRN_List.getColumnModel().getColumn(6).setPreferredWidth(30);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 960, 360));

        bLoadGRN_no.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadGRN_no.setBorderPainted(false);
        bLoadGRN_no.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadGRN_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadGRN_noActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadGRN_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 30, 25));

        bLoadDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadDate.setBorderPainted(false);
        bLoadDate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadDateActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 30, 25));

        txtGRN_date.setDateFormatString("dd/MM/yy");
        txtGRN_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtGRN_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 130, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblGRN_List.getModel();
        dtm.setRowCount(0);
}//GEN-LAST:event_removeallActionPerformed

    private void bShowALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowALLActionPerformed
        load();
}//GEN-LAST:event_bShowALLActionPerformed

    private void txtGRN_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGRN_noKeyReleased
        try {
            String grn_no = txtGRN_no.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM grn g, supplier_details sd WHERE g.supplier_no = sd.supplier_no AND g.grn_no LIKE '" + grn_no + "%' ORDER BY grn_no ASC");

            DefaultTableModel dtm = (DefaultTableModel) tblGRN_List.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("grn_no"));
                v.add(rs.getString("grn_date"));
                v.add(rs.getString("invoice"));
                v.add(rs.getString("supplier_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getBigDecimal("total"));
                v.add(rs.getString("user"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(grn_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtGRN_noKeyReleased

    private void bLoadGRN_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadGRN_noActionPerformed
        loadGRNNo();
    }//GEN-LAST:event_bLoadGRN_noActionPerformed

    private void bLoadDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadDateActionPerformed
        if (txtGRN_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please enter a GRN Date to search for !", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_date.grabFocus();
        } else {
            try {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                String valDate = ((JTextField) txtGRN_date.getDateEditor().getUiComponent()).getText();
                String grn_date = null;
                if (!valDate.isEmpty()) {
                    grn_date = date.format(txtGRN_date.getDate());
                }
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM grn g, supplier_details sd WHERE g.supplier_no = sd.supplier_no AND g.grn_date = '" + grn_date + "' ORDER BY grn_no ASC ");
                DefaultTableModel dtm = (DefaultTableModel) tblGRN_List.getModel();
                dtm.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getInt("grn_no"));
                    v.add(rs.getString("grn_date"));
                    v.add(rs.getString("invoice"));
                    v.add(rs.getString("supplier_no"));
                    v.add(rs.getString("supplier_name"));
                    v.add(rs.getBigDecimal("total"));
                    v.add(rs.getString("user"));
                    dtm.addRow(v);
                }
            } catch (Exception ex) {
                Logger.getLogger(grn_list.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
            }
        }
    }//GEN-LAST:event_bLoadDateActionPerformed

    private void tblGRN_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGRN_ListMouseClicked
        JTable dtm = (JTable) evt.getSource();
        int i = tblGRN_List.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();
        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        if (!t2.isEmpty()) {
            try {
                date = (Date) formatter.parse(t2);
                format.format(date);
                txtGRN_date.setDate(date);
            } catch (ParseException ex) {
            }
        } else {
        }
        txtGRN_no.setText(t1);
        txtGRN_date.setDate(date);
    }//GEN-LAST:event_tblGRN_ListMouseClicked

    private void txtGRN_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGRN_noActionPerformed
        loadGRNNo();
    }//GEN-LAST:event_txtGRN_noActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
        grn.previewGRN(txtGRN_no.getText());
    }//GEN-LAST:event_bPreviewActionPerformed

    private void bPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrintActionPerformed
        if (txtGRN_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue number to print !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Connection c = DBControl.getServerDB_Connection();
                String reportSource = settings.filepath + "RR_GRN1.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperPrintManager.printReport(jasperPrint, true);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(grn_list.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }//GEN-LAST:event_bPrintActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        Main.ng.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bNewActionPerformed

    private void bPDFBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFBASICActionPerformed
       grn.createPDF(txtGRN_no.getText());
    }//GEN-LAST:event_bPDFBASICActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bLoadDate;
    private javax.swing.JButton bLoadGRN_no;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDFBASIC;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bPrint;
    private javax.swing.JButton bShowALL;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton removeall;
    private javax.swing.JTable tblGRN_List;
    private com.toedter.calendar.JDateChooser txtGRN_date;
    private javax.swing.JTextField txtGRN_no;
    // End of variables declaration//GEN-END:variables

    public void load() {
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM grn g, supplier_details sd WHERE g.supplier_no = sd.supplier_no ORDER BY grn_no ASC ");
            DefaultTableModel dtm = (DefaultTableModel) tblGRN_List.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("grn_no"));
                v.add(rs.getString("grn_date"));
                v.add(rs.getString("invoice"));
                v.add(rs.getString("supplier_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getBigDecimal("total"));
                v.add(rs.getString("user"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            Logger.getLogger(grn_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);

        }
        setCursor(Cursor.getDefaultCursor());
    }

    private void loadGRNNo() {
        if (txtGRN_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Number to search for !", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_no.grabFocus();
        } else {
            try {
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM grn g, supplier_details sd "
                        + "WHERE g.grn_no = '" + txtGRN_no.getText() + "' AND g.supplier_no = sd.supplier_no ORDER BY grn_no ASC ");
                DefaultTableModel dtm = (DefaultTableModel) tblGRN_List.getModel();
                dtm.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getInt("grn_no"));
                    v.add(rs.getString("grn_date"));
                    v.add(rs.getString("invoice"));
                    v.add(rs.getString("supplier_no"));
                    v.add(rs.getString("supplier_name"));
                    v.add(rs.getBigDecimal("total"));
                    v.add(rs.getString("user"));
                    dtm.addRow(v);
                }
            } catch (Exception ex) {
                Logger.getLogger(grn_list.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
            }
        }
    }
}
