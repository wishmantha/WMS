package scm.issue;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
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
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.Main;
import scm.fas.new_fas;
import scm.grn.grn_list;
import scm.help.settings;

public class issue_list extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    public issue_list() {

        initComponents();
        load();
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        tblIssueList.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        tblIssueList.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        tblIssueList.getColumnModel().getColumn(2).setCellRenderer(dtcr);
        tblIssueList.getColumnModel().getColumn(3).setCellRenderer(dtcr);
        tblIssueList.getColumnModel().getColumn(5).setCellRenderer(dtcr);
        JTableHeader header = tblIssueList.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        TableCellRenderer renderer = header.getDefaultRenderer();
        JLabel label = (JLabel) renderer;
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bPrint = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bPreview = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bPDF = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel27 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIssue_no = new javax.swing.JTextField();
        bShowALL = new javax.swing.JButton();
        removeall = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssueList = new javax.swing.JTable();
        bLoadDate = new javax.swing.JButton();
        bLoadGrnNo = new javax.swing.JButton();
        txtIssue_date = new com.toedter.calendar.JDateChooser();

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sub Total");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setPreferredSize(new java.awt.Dimension(0, 25));

        txtSubTotal.setEditable(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(0, 25));

        setTitle("Issue List");
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
        jToolBar1.add(jSeparator5);

        bPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDF.setText("PDF");
        bPDF.setFocusable(false);
        bPDF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDF.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFActionPerformed(evt);
            }
        });
        jToolBar1.add(bPDF);
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
        jToolBar1.add(jSeparator7);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Issue List");
        jLabel27.setIconTextGap(10);
        jLabel27.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar1.add(jLabel27);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Issue No");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 25));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Issue Date");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, 25));

        txtIssue_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIssue_no.setNextFocusableComponent(txtIssue_date);
        txtIssue_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtIssue_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIssue_noKeyReleased(evt);
            }
        });
        getContentPane().add(txtIssue_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 120, 25));

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

        tblIssueList.setAutoCreateRowSorter(true);
        tblIssueList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblIssueList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue No", "Date", "Account Code  ", "Equipment No", "Total", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblIssueList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblIssueList.setRowHeight(20);
        tblIssueList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIssueListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIssueList);
        tblIssueList.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblIssueList.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblIssueList.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblIssueList.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblIssueList.getColumnModel().getColumn(4).setPreferredWidth(70);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 960, 360));

        bLoadDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadDate.setBorderPainted(false);
        bLoadDate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadDateActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 30, 25));

        bLoadGrnNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadGrnNo.setBorderPainted(false);
        bLoadGrnNo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadGrnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadGrnNoActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadGrnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 30, 25));

        txtIssue_date.setDateFormatString("dd/MM/yy");
        txtIssue_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtIssue_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 130, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
        dtm.setRowCount(0);
}//GEN-LAST:event_removeallActionPerformed

    private void bPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrintActionPerformed
        if (txtIssue_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue number to print !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Connection c = DBControl.getServerDB_Connection();
                String reportSource = settings.filepath + "Issue_Report.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperPrintManager.printReport(jasperPrint, true);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_bPrintActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        Main.ni.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bNewActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
       issue.previewIssue(txtIssue_no.getText());
    }//GEN-LAST:event_bPreviewActionPerformed

    private void bShowALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowALLActionPerformed
        load();
}//GEN-LAST:event_bShowALLActionPerformed

    private void txtIssue_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIssue_noKeyReleased
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM issue WHERE issue_no LIKE '" + txtIssue_no.getText() + "%' ORDER BY issue_no ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("issue_no"));
                v.add(rs.getString("issue_date"));
                v.add(rs.getString("account_code"));
                v.add(rs.getString("equipment_no"));
                v.add(rs.getBigDecimal("total"));
                v.add(rs.getString("user"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(issue_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtIssue_noKeyReleased

    private void bLoadDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadDateActionPerformed
        if (txtIssue_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue Date to search for !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                String valDate = ((JTextField) txtIssue_date.getDateEditor().getUiComponent()).getText();
                String issue_date = null;
                if (!valDate.isEmpty()) {
                    issue_date = date.format(txtIssue_date.getDate());
                }
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM issue WHERE issue_date = '" + issue_date + "'ORDER BY issue_no DESC");
                DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
                dtm.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getString("issue_no"));
                    v.add(rs.getString("issue_date"));
                    v.add(rs.getString("account_code"));
                    v.add(rs.getString("equipment_no"));
                    v.add(rs.getBigDecimal("total"));
                    v.add(rs.getString("user"));
                    dtm.addRow(v);
                }
            } catch (Exception ex) {
                Logger.getLogger(issue_list.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bLoadDateActionPerformed

    private void bLoadGrnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadGrnNoActionPerformed
        if (txtIssue_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue Number to search for !", "Error", JOptionPane.ERROR_MESSAGE);
            txtIssue_no.grabFocus();
        } else {
            load();
        }
    }//GEN-LAST:event_bLoadGrnNoActionPerformed

    private void tblIssueListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssueListMouseClicked
        JTable dtm = (JTable) evt.getSource();
        int i = tblIssueList.getSelectedRow();
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
                txtIssue_date.setDate(date);
            } catch (ParseException ex) {
            }
        } else {
        }
        txtIssue_no.setText(t1);
        txtIssue_date.setDate(date);
    }//GEN-LAST:event_tblIssueListMouseClicked

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
              issue.createPDF(txtIssue_no.getText());
    }//GEN-LAST:event_bPDFActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bLoadDate;
    private javax.swing.JButton bLoadGrnNo;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bPrint;
    private javax.swing.JButton bShowALL;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton removeall;
    private javax.swing.JTable tblIssueList;
    private com.toedter.calendar.JDateChooser txtIssue_date;
    private javax.swing.JTextField txtIssue_no;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables

    public void load() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM issue ORDER BY issue_no ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("issue_no"));
                v.add(rs.getString("issue_date"));
                v.add(rs.getString("account_code"));
                v.add(rs.getString("equipment_no"));
                v.add(rs.getBigDecimal("total"));
                v.add(rs.getString("user"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(issue_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
