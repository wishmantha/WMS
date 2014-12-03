package scm.issue;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import scm.grn.new_grn_return;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;
import scm.Main;

public final class new_issue_return extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
    Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String return_issue_date = sdf.format(today);
    long time = today.getTime();
    Timestamp ts = new Timestamp(time);
    String timestamp = ts.toString();
    public static String return_issue_no;

    public new_issue_return() {
        try {
            initComponents();
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(SwingConstants.CENTER);

            //////////////////////////////////////////////////////////////////
        } catch (Exception ex) {
            Logger.getLogger(new_issue_return.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bSave = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bPreview = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bPDF = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIssue_no = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        addtolist = new javax.swing.JButton();
        removeselected = new javax.swing.JButton();
        removeall = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssue = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAccntDescription = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtStockCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEquipmentClass_Vehicle = new javax.swing.JTextField();
        txtIssue_date = new com.toedter.calendar.JDateChooser();
        txtEquipmentNo = new javax.swing.JTextField();
        bClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loadGRN = new javax.swing.JButton();
        txtAccountCode = new javax.swing.JTextField();
        bChangeDate = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sub Total");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setPreferredSize(new java.awt.Dimension(0, 25));

        txtSubTotal.setEditable(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(0, 25));

        jTextField1.setText("jTextField1");

        setTitle("New Issue Return");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return_issue.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(509, 63));
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

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        bSave.setText("Return");
        bSave.setFocusable(false);
        bSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSave.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(bSave);
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

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("New Issue Return");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setIconTextGap(10);
        jLabel14.setMaximumSize(new java.awt.Dimension(600, 37));
        jLabel14.setPreferredSize(new java.awt.Dimension(200, 37));
        jToolBar1.add(jLabel14);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Issue No");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 25));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Issue Date");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 25));

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel6.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 70, 25));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Description");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel8.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 90, 25));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Account Code");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 120, 25));

        txtIssue_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIssue_no.setNextFocusableComponent(txtIssue_date);
        txtIssue_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtIssue_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIssue_noActionPerformed(evt);
            }
        });
        getContentPane().add(txtIssue_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 100, 25));

        txtQty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQty.setNextFocusableComponent(txtIssue_date);
        txtQty.setPreferredSize(new java.awt.Dimension(0, 25));
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
        });
        getContentPane().add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 120, 25));

        txtUnitPrice.setEditable(false);
        txtUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUnitPrice.setNextFocusableComponent(txtStockCode);
        txtUnitPrice.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 120, 25));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 220, 25));

        addtolist.setText("Add");
        addtolist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtolist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtolistActionPerformed(evt);
            }
        });
        getContentPane().add(addtolist, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 90, 30));

        removeselected.setText("Remove  ");
        removeselected.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeselectedActionPerformed(evt);
            }
        });
        getContentPane().add(removeselected, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 90, 30));

        removeall.setText("Clear Table");
        removeall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallActionPerformed(evt);
            }
        });
        getContentPane().add(removeall, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 90, 30));

        tblIssue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblIssue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Quantity", "Unit Price", "Description", "Sub-Total"
            }
        ));
        tblIssue.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblIssue.setRowHeight(20);
        tblIssue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIssueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIssue);
        tblIssue.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblIssue.getColumnModel().getColumn(1).setPreferredWidth(5);
        tblIssue.getColumnModel().getColumn(2).setPreferredWidth(5);
        tblIssue.getColumnModel().getColumn(3).setPreferredWidth(60);
        tblIssue.getColumnModel().getColumn(4).setPreferredWidth(40);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 730, 320));

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Unit Price");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel7.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, 25));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Quantity");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 25));

        txtAccntDescription.setEditable(false);
        txtAccntDescription.setNextFocusableComponent(txtStockCode);
        getContentPane().add(txtAccntDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 25));

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Stock Code");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel12.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 25));

        txtStockCode.setEditable(false);
        txtStockCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockCode.setNextFocusableComponent(txtQty);
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 120, 25));

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Equipment No.");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 120, 25));

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Description");
        jLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 90, 25));

        txtEquipmentClass_Vehicle.setEditable(false);
        txtEquipmentClass_Vehicle.setNextFocusableComponent(txtStockCode);
        getContentPane().add(txtEquipmentClass_Vehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 280, 25));

        txtIssue_date.setDateFormatString("dd/MM/yy");
        txtIssue_date.setEnabled(false);
        txtIssue_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtIssue_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, 25));

        txtEquipmentNo.setEditable(false);
        txtEquipmentNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEquipmentNo.setToolTipText("Enter your search item");
        txtEquipmentNo.setName(""); // NOI18N
        getContentPane().add(txtEquipmentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 190, 25));

        bClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        bClear.setBorderPainted(false);
        bClear.setContentAreaFilled(false);
        bClear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });
        getContentPane().add(bClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 20, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Rs.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, -1, 25));

        loadGRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        loadGRN.setContentAreaFilled(false);
        loadGRN.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        loadGRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGRNActionPerformed(evt);
            }
        });
        getContentPane().add(loadGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 30, 25));

        txtAccountCode.setEditable(false);
        txtAccountCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAccountCode.setToolTipText("Enter your search item");
        txtAccountCode.setName(""); // NOI18N
        getContentPane().add(txtAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 190, 25));

        bChangeDate.setText("Edit Date");
        bChangeDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChangeDateActionPerformed(evt);
            }
        });
        getContentPane().add(bChangeDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 127, 110, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addtolistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtolistActionPerformed
        addtolist();
    }//GEN-LAST:event_addtolistActionPerformed

    private void removeselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeselectedActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
        int arr[] = tblIssue.getSelectedRows();
        for (int i = 0; i < arr.length; i++) {
            BigDecimal d3 = new BigDecimal(txtTotal.getText());
            int j = tblIssue.getSelectedRow();
            String s1 = dtm.getValueAt(j, 4).toString();
            BigDecimal d4 = new BigDecimal(s1);
            d3 = d3.subtract(d4);
            txtTotal.setText("" + d3);
            dtm.removeRow(tblIssue.getSelectedRow());
        }
        txtStockCode.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
}//GEN-LAST:event_removeselectedActionPerformed

    private void removeallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
        dtm.setRowCount(0);
        txtTotal.setText("");

}//GEN-LAST:event_removeallActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        int decimals = 2;
        if (txtIssue_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue Number to Return", "Error", JOptionPane.ERROR_MESSAGE);
            txtIssue_no.grabFocus();
        } else if (txtAccntDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an ACCOUNT CODE", "Error", JOptionPane.ERROR_MESSAGE);
            txtAccountCode.grabFocus();
        } else if (txtEquipmentClass_Vehicle.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an Equipment Number", "Error", JOptionPane.ERROR_MESSAGE);
            txtEquipmentNo.grabFocus();
        } else if (txtIssue_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue Date", "Error", JOptionPane.ERROR_MESSAGE);
            txtIssue_date.grabFocus();
        } else if (tblIssue.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No items found to return", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
        } else {
            try {
                String issue_no = txtIssue_no.getText();
                String updated_by = Main.lblUser.getText();
                String total = txtTotal.getText();
                BigDecimal tott = new BigDecimal(total).setScale(decimals, BigDecimal.ROUND_DOWN);
                DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
                for (int i = 0; i < tblIssue.getRowCount(); i++) {
                    String stock_code = dtm.getValueAt(i, 0).toString();
                    String quantity = dtm.getValueAt(i, 1).toString();
                    String unit_price = dtm.getValueAt(i, 2).toString();
                    String sub_total = dtm.getValueAt(i, 4).toString();
                    db.setResult("INSERT INTO issue_return(issue_no,stock_code,quantity,unit_price,sub_total,user,time)"
                            + "  VALUES('" + issue_no + "','" + stock_code + "','" + quantity + "','" + unit_price + "',"
                            + "'" + sub_total + "','" + updated_by + "','" + timestamp + "')");
                    db.setResult("UPDATE stock_details SET qoh = qoh +'" + quantity + "' WHERE stock_code = '" + stock_code + "' ");

//                     ResultSet rss = DBControl.getResult("SELECT stock_code FROM issue_qty WHERE stock_code='" + stock_code + "' AND issue_no ='"+issue_no+"'");
//                    if (rss.next()) {
//                        db.setResult("UPDATE issue_qty SET quantity =quantity + '" + quantity + "' WHERE issue_no = '" + issue_no + "'AND stock_code = '" + stock_code + "'");
//                    } else {
//                        db.setResult("INSERT INTO issue_qty (issue_no,stock_code,quantity) VALUES('" + issue_no + "','" + stock_code + "','" + quantity + "')");
//                    }
                    db.setResult("UPDATE issue_qty SET quantity = quantity - '" + quantity + "' WHERE issue_no = '" + issue_no + "' AND stock_code = '" + stock_code + "'");

                }
                db.setResult("UPDATE issue SET total = total -'" + tott + "' WHERE issue_no ='" + issue_no + "'");
                JOptionPane.showMessageDialog(null, "Successfully Returned and Stock Adjusted");
                bPDF.setEnabled(true);
                bPreview.setEnabled(true);
                bSave.setEnabled(false);
                txtIssue_no.setEditable(false);
            } catch (Exception ex) {
                Logger.getLogger(new_issue_return.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Issue was not saved !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_bSaveActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            txtAccountCode.setText("");
            txtEquipmentNo.setText("");
            txtAccntDescription.setText("");
            txtEquipmentClass_Vehicle.setText("");
            txtIssue_no.setText("");
            txtIssue_date.setDate(null);
            txtQty.setText("");
            txtStockCode.setText("");
            txtSubTotal.setText("");
            txtTotal.setText("");
            txtUnitPrice.setText("");
            bPDF.setEnabled(false);
            bPreview.setEnabled(false);
            bSave.setEnabled(true);
            txtIssue_no.setEditable(true);
            DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
            dtm.setRowCount(0);

        } else if (i == 1) {
            JOptionPane.showMessageDialog(null, "Please save the changes", "SAVE", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bNewActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
        issue.previewIssue(txtIssue_no.getText());
    }//GEN-LAST:event_bPreviewActionPerformed

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select an Item first ", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
            txtQty.setText("");
        }
    }//GEN-LAST:event_txtQtyKeyReleased

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        txtStockCode.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
    }//GEN-LAST:event_bClearActionPerformed

    private void loadGRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGRNActionPerformed
        loadIssue();
    }//GEN-LAST:event_loadGRNActionPerformed

    private void txtIssue_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIssue_noActionPerformed
        loadIssue();
    }//GEN-LAST:event_txtIssue_noActionPerformed

    private void tblIssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssueMouseClicked
        int i = tblIssue.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
        String stock_code = dtm.getValueAt(i, 0).toString();
        String qty = dtm.getValueAt(i, 1).toString();
        String unit_price = dtm.getValueAt(i, 2).toString();
        txtStockCode.setText(stock_code);
        txtQty.setText(qty);
        txtUnitPrice.setText(unit_price);
    }//GEN-LAST:event_tblIssueMouseClicked

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        issue.createPDF(txtIssue_no.getText());
    }//GEN-LAST:event_bPDFActionPerformed

    private void bChangeDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChangeDateActionPerformed
        Font font = new Font("Verdana", Font.BOLD, 16);
        JDateChooser jd = new JDateChooser(today);
        jd.setFont(font);
        int action = JOptionPane.showConfirmDialog(null, jd, "Enter a new Date :", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (action == 0) {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String valDate = ((JTextField) jd.getDateEditor().getUiComponent()).getText();
            String grn_date = null;
            if (!valDate.isEmpty()) {
                try {
                    grn_date = date.format(jd.getDate());
                    db.setResult("UPDATE issue SET issue_date = '" + grn_date + "' WHERE issue_no = '" + txtIssue_no.getText() + "'");
                    loadIssue();
                    JOptionPane.showMessageDialog(null, "Date was successfully changed !", "Date", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(new_issue_return.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bChangeDateActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtolist;
    private javax.swing.JButton bChangeDate;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton loadGRN;
    private javax.swing.JButton removeall;
    private javax.swing.JButton removeselected;
    private javax.swing.JTable tblIssue;
    private javax.swing.JTextField txtAccntDescription;
    private javax.swing.JTextField txtAccountCode;
    private javax.swing.JTextField txtEquipmentClass_Vehicle;
    private javax.swing.JTextField txtEquipmentNo;
    private com.toedter.calendar.JDateChooser txtIssue_date;
    private javax.swing.JTextField txtIssue_no;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtStockCode;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables

    private void loadIssue() {
        int decimals = 2;
        DefaultTableModel dtm1 = (DefaultTableModel) tblIssue.getModel();
        dtm1.setRowCount(0);
        txtIssue_date.setDate(null);
        txtStockCode.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        txtSubTotal.setText("");
        txtTotal.setText("");
        txtEquipmentClass_Vehicle.setText("");
        txtEquipmentNo.setText("");
        txtAccountCode.setText("");
        txtAccntDescription.setText("");

        if (txtIssue_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue Number to search for !", "Error", JOptionPane.ERROR_MESSAGE);
            txtIssue_no.grabFocus();
        } else {
            try {
                ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT * FROM issue_details WHERE issue_no = '" + txtIssue_no.getText() + "'");
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM issue WHERE issue_no = '" + txtIssue_no.getText() + "'");
                while (rs.next()) {
                    /// Load Account Center and Equipment No
                    txtAccountCode.setText(rs.getString("account_code"));
                    ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code='" + txtAccountCode.getText() + "'");
                    while (rs1.next()) {
                        txtAccntDescription.setText(rs1.getString("description"));
                    }
                    rs1.close();
                    txtEquipmentNo.setText(rs.getString("equipment_no"));
                    ResultSet rs11 = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no='" + txtEquipmentNo.getText() + "'");
                    while (rs11.next()) {
                        txtEquipmentClass_Vehicle.setText(rs11.getString("class_vehicle"));
                    }
                    rs11.close();
                    // Issue Date
                    DateFormat formatter;
                    Date date = null;
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                    String dd = rs.getString("issue_date");
                    if (!dd.isEmpty()) {
                        try {
                            date = (Date) formatter.parse(dd);
                            format.format(date);
                            txtIssue_date.setDate(date);
                        } catch (ParseException ex) {
                        }
                    }
                    /// Issue Items
                    DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
                    while (rs4.next()) {
                        Vector v = new Vector();
                        String stock_code = rs4.getString("stock_code");
                        ResultSet rs3 = DBControl.getResultFromLocalDB("SELECT quantity FROM issue_qty WHERE issue_no = '" + txtIssue_no.getText() + "' AND stock_code = '" + stock_code + "'");
                        while (rs3.next()) {
                            String qty = rs3.getString("quantity");
                            String unit_price = rs4.getString("unit_price");
                            BigDecimal qty1 = new BigDecimal(qty);
                            BigDecimal zero = new BigDecimal("0.00");
                            if (!qty1.equals(zero)) {
                                v.add(stock_code);
                                v.add(qty);
                                v.add(unit_price);
                                ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
                                while (rs2.next()) {
                                    v.add(rs2.getString("description"));
                                }
                                BigDecimal up = new BigDecimal(unit_price);
                                BigDecimal subt = up.multiply(qty1).setScale(decimals, BigDecimal.ROUND_DOWN);
                                v.add(subt);
                                dtm.addRow(v);
                            }
                        }
                    }
                    // GRN Total
                    txtTotal.setText(rs.getString("total"));
                }
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(new_grn_return.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void addtolist() {
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a stock code from the table to return ", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
            txtUnitPrice.setText("");
        } else if (txtQty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the quantity to return ", "Error", JOptionPane.ERROR_MESSAGE);
            txtQty.grabFocus();
        } else if (Double.parseDouble(txtQty.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Quantity cannot be zero (0). Please remove the stock code, if you dont have to return ! ", "Error", JOptionPane.ERROR_MESSAGE);
            txtQty.grabFocus();
        } else if (txtUnitPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the unit price ", "Error", JOptionPane.ERROR_MESSAGE);
            txtUnitPrice.grabFocus();
        } else {
            try {
                int decimals = 2;
                BigDecimal d22 = new BigDecimal(txtQty.getText());
                BigDecimal d33 = new BigDecimal(txtUnitPrice.getText());
                d33 = d33.setScale(decimals, BigDecimal.ROUND_DOWN);
                BigDecimal d44 = d22.multiply(d33);
                d44 = d44.setScale(decimals, BigDecimal.ROUND_DOWN);
                txtSubTotal.setText(String.valueOf(d44));
                String stock_code = txtStockCode.getText();
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
                ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT quantity FROM issue_details WHERE issue_no='" + txtIssue_no.getText() + "' AND stock_code='" + stock_code + "'");
                DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
                while (rs.next()) {
                    while (rs2.next()) {
                        double current_qty = Double.parseDouble(rs2.getString("quantity"));
                        double new_qty = Double.parseDouble(txtQty.getText());
                        if (new_qty > current_qty) {
                            JOptionPane.showMessageDialog(null, "New quantity " + new_qty + " is greater than original quantity " + current_qty, "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Vector v = new Vector();
                            v.add(txtStockCode.getText());
                            v.add(txtQty.getText());
                            v.add(txtUnitPrice.getText());
                            v.add(rs.getString("description"));
                            v.add(txtSubTotal.getText());
                            if (tblIssue.getRowCount() == 0) {
                                JOptionPane.showMessageDialog(null, "Please reload the Issue ", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                dtm.removeRow(tblIssue.getSelectedRow());
                            }
                            System.out.println("PRINT ONE");
                            dtm.addRow(v);
                            BigDecimal b111 = new BigDecimal("0");
                            int x = dtm.getRowCount();
                            for (int i = 0; i < x; i++) {
                                String s1 = dtm.getValueAt(i, 4).toString();
                                BigDecimal b222 = new BigDecimal(s1);
                                b111 = b111.add(b222);
                                b111 = b111.setScale(decimals, BigDecimal.ROUND_DOWN);
                                txtTotal.setText("" + b111);
                            }
                            System.out.println("PRINT TWO");
                        }
                    }System.out.println("PRINT 3");
                }
                txtStockCode.setText("");
                txtQty.setText("");
                txtUnitPrice.setText("");
                txtStockCode.grabFocus();
            } catch (Exception ex) {
                Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
            }
        }
    }
}
