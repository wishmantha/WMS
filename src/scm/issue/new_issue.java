package scm.issue;

import java.awt.Cursor;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
import scm.fas.new_fas;
import scm.grn.new_grn;
import scm.stock.stock_details;

public final class new_issue extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
    Date today = new Date();

    public new_issue() {
        try {
            initComponents();
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(SwingConstants.CENTER);
            //tblStockLoad.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            // For the drop down effect of stock codes instead of using the combo box
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);
            tblEquipLoad.setVisible(false);
            jScrollPane6.setVisible(false);
            tblAccountLoad.setVisible(false);
            jScrollPane8.setVisible(false);
            // Auto Increment of issue_No//
            newIssue();
            //////////////////////////////////////////////////////////////////
            jTextField1.setText("Expense");
            String text = jTextField1.getText();
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE type ='" + text + "' ORDER BY account_code ASC");
            while (rs1.next()) {
                DefaultTableModel dtm111 = (DefaultTableModel) tblAccountLoad.getModel();
                dtm111.setRowCount(0);
                while (rs1.next()) {
                    Vector v211 = new Vector();
                    v211.add(rs1.getString("account_code"));
                    v211.add(rs1.getString("description"));
                    dtm111.addRow(v211);
                }
            }

            //////////////////////////////////////////////////////////////////
            ResultSet rs22 = DBControl.getResultFromLocalDB("SELECT * from fas_details ORDER BY equipment_no");

            DefaultTableModel dtm2 = (DefaultTableModel) tblEquipLoad.getModel();
            while (rs22.next()) {
                Vector v22 = new Vector();
                v22.add(rs22.getString("equipment_no"));
                v22.add(rs22.getString("class_vehicle"));
                dtm2.addRow(v22);
            }
            /////////////////////////////////////////

            //////////////////////////////////////////////////////////////////
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            sdf.format(today);
            txtIssue_date.setDate(today);
            ///////////////////////////////////////////////////////////////////

        } catch (Exception ex) {
            Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane8 = new javax.swing.JScrollPane();
        tblAccountLoad = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblEquipLoad = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblStockLoad = new javax.swing.JTable();
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
        tblIssueList = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtStockCode = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEquipmentClass_Vehicle = new javax.swing.JTextField();
        txtIssue_date = new com.toedter.calendar.JDateChooser();
        txtEquipmentNo = new javax.swing.JTextField();
        bClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bClear2 = new javax.swing.JButton();
        txtAccountCode = new javax.swing.JTextField();
        bClear3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtStockDescription = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtStockPartNo = new javax.swing.JTextPane();

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sub Total");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setPreferredSize(new java.awt.Dimension(0, 25));

        txtSubTotal.setEditable(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(0, 25));

        jTextField1.setText("jTextField1");

        setTitle("New Issue Note");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GRN.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane8.setBackground(new java.awt.Color(249, 249, 249));
        jScrollPane8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblAccountLoad.setBackground(new java.awt.Color(240, 240, 240));
        tblAccountLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAccountLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Code", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccountLoad.setRowHeight(20);
        tblAccountLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccountLoadMouseClicked(evt);
            }
        });
        tblAccountLoad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblAccountLoadFocusLost(evt);
            }
        });
        jScrollPane8.setViewportView(tblAccountLoad);
        tblAccountLoad.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblAccountLoad.getColumnModel().getColumn(1).setPreferredWidth(200);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 95, 360, 250));

        jScrollPane6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblEquipLoad.setBackground(new java.awt.Color(240, 240, 240));
        tblEquipLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblEquipLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Class"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEquipLoad.setRowHeight(20);
        tblEquipLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquipLoadMouseClicked(evt);
            }
        });
        tblEquipLoad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblEquipLoadFocusLost(evt);
            }
        });
        jScrollPane6.setViewportView(tblEquipLoad);
        tblEquipLoad.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblEquipLoad.getColumnModel().getColumn(1).setPreferredWidth(150);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 125, 360, 240));

        jScrollPane5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblStockLoad.setBackground(new java.awt.Color(240, 240, 240));
        tblStockLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblStockLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Description", "PartNo Size", "QOH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStockLoad.setRowHeight(20);
        tblStockLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockLoadMouseClicked(evt);
            }
        });
        tblStockLoad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblStockLoadFocusLost(evt);
            }
        });
        jScrollPane5.setViewportView(tblStockLoad);
        tblStockLoad.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblStockLoad.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblStockLoad.getColumnModel().getColumn(3).setPreferredWidth(20);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 175, 520, 280));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(509, 61));
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
        bSave.setText("Save");
        bSave.setFocusable(false);
        bSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSave.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSaveMouseEntered(evt);
            }
        });
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
        jLabel14.setText("New Issue");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setIconTextGap(10);
        jLabel14.setMaximumSize(new java.awt.Dimension(600, 37));
        jLabel14.setPreferredSize(new java.awt.Dimension(600, 37));
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
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 70, 25));

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

        txtIssue_no.setEditable(false);
        txtIssue_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIssue_no.setNextFocusableComponent(txtIssue_date);
        txtIssue_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtIssue_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIssue_noFocusLost(evt);
            }
        });
        getContentPane().add(txtIssue_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 130, 25));

        txtQty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQty.setNextFocusableComponent(txtIssue_date);
        txtQty.setPreferredSize(new java.awt.Dimension(0, 25));
        txtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtyFocusLost(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtyKeyPressed(evt);
            }
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
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 210, 25));

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

        tblIssueList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Quantity", "Unit Price", "Description", "Sub-Total"
            }
        ));
        tblIssueList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblIssueList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIssueListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIssueList);
        tblIssueList.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblIssueList.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblIssueList.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblIssueList.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblIssueList.getColumnModel().getColumn(4).setPreferredWidth(50);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 730, 280));

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

        txtDescription.setEditable(false);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescription.setNextFocusableComponent(txtStockCode);
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 25));

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Stock Code");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel12.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 25));

        txtStockCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockCode.setNextFocusableComponent(txtQty);
        txtStockCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStockCodeMouseClicked(evt);
            }
        });
        txtStockCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockCodeFocusLost(evt);
            }
        });
        txtStockCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockCodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockCodeKeyTyped(evt);
            }
        });
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 120, 25));

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Description");
        jLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 90, 25));

        txtEquipmentClass_Vehicle.setEditable(false);
        txtEquipmentClass_Vehicle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEquipmentClass_Vehicle.setNextFocusableComponent(txtStockCode);
        getContentPane().add(txtEquipmentClass_Vehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 280, 25));

        txtIssue_date.setDateFormatString("dd/MM/yy");
        txtIssue_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtIssue_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, 25));

        txtEquipmentNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEquipmentNo.setToolTipText("Enter your search item");
        txtEquipmentNo.setName(""); // NOI18N
        txtEquipmentNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEquipmentNoMouseClicked(evt);
            }
        });
        txtEquipmentNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEquipmentNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEquipmentNoKeyTyped(evt);
            }
        });
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

        bClear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        bClear2.setBorderPainted(false);
        bClear2.setContentAreaFilled(false);
        bClear2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        bClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClear2ActionPerformed(evt);
            }
        });
        getContentPane().add(bClear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 30, -1));

        txtAccountCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAccountCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAccountCodeMouseClicked(evt);
            }
        });
        txtAccountCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAccountCodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccountCodeKeyTyped(evt);
            }
        });
        getContentPane().add(txtAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 190, 25));

        bClear3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        bClear3.setBorderPainted(false);
        bClear3.setContentAreaFilled(false);
        bClear3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        bClear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClear3ActionPerformed(evt);
            }
        });
        getContentPane().add(bClear3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 30, -1));

        jLabel15.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Equipment No.");
        jLabel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 120, 25));

        txtStockDescription.setEditable(false);
        txtStockDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(txtStockDescription);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 490, 25));

        txtStockPartNo.setEditable(false);
        txtStockPartNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(txtStockPartNo);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 230, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addtolistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtolistActionPerformed
        addtolist();
    }//GEN-LAST:event_addtolistActionPerformed

    private void removeselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeselectedActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
        int arr[] = tblIssueList.getSelectedRows();
        for (int i = 0; i < arr.length; i++) {
            Double d3 = Double.parseDouble(txtTotal.getText());
            int j = tblIssueList.getSelectedRow();
            String s1 = dtm.getValueAt(j, 4).toString();
            double d4 = Double.parseDouble(s1);
            d3 = d3 - d4;
            txtTotal.setText("" + d3);
            dtm.removeRow(tblIssueList.getSelectedRow());
        }
}//GEN-LAST:event_removeselectedActionPerformed

    private void removeallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
        dtm.setRowCount(0);
        txtTotal.setText("");

}//GEN-LAST:event_removeallActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        increaseIssue();
        if (txtIssue_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue Number", "Error", JOptionPane.ERROR_MESSAGE);
            txtIssue_no.grabFocus();
        } else if (txtDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an ACCOUNT CODE", "Error", JOptionPane.ERROR_MESSAGE);
            txtAccountCode.grabFocus();
//        } else if (txtEquipmentClass_Vehicle.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please select an Equipment Number", "Error", JOptionPane.ERROR_MESSAGE);
//            txtEquipmentNo.grabFocus();
        } else if (txtIssue_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please enter the Issue Date", "Error", JOptionPane.ERROR_MESSAGE);
            txtIssue_date.grabFocus();
        } else if (tblIssueList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please add items to the Issue Note", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
        } else {
            saveIssue();
        }
}//GEN-LAST:event_bSaveActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            newIssue();
            txtDescription.setText("");
            txtAccountCode.setText("");
            txtEquipmentNo.setText("");
            txtEquipmentClass_Vehicle.setText("");
            txtIssue_date.setDate(null);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            sdf.format(today);
            txtIssue_date.setDate(today);
            txtQty.setText("");
            txtStockCode.setText("");
            txtSubTotal.setText("");
            txtTotal.setText("");
            txtUnitPrice.setText("");
            bPDF.setEnabled(false);
            bPreview.setEnabled(false);
            bSave.setEnabled(true);
            txtIssue_no.setEditable(true);
            DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
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

    private void txtQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusLost
//        addtolist();
    }//GEN-LAST:event_txtQtyFocusLost

    private void txtStockCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockCodeFocusLost
        try {
            String stock_code = txtStockCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
            while (rs.next()) {
                txtUnitPrice.setText(rs.getString("unit_price"));
            }
        } catch (Exception ex) {
            Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
        DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
        String stock_code = txtStockCode.getText();
        int z = dtm.getRowCount();
        for (int i1 = 0; i1 < z; i1++) {
            String check_stock_code = dtm.getValueAt(i1, 0).toString();
            if (stock_code.equals(check_stock_code)) {
                JOptionPane.showMessageDialog(null, stock_code + " is already in your Issue item list !  ", "Unable to Add Stock", JOptionPane.ERROR_MESSAGE);
                txtStockCode.setText("");
                txtUnitPrice.setText("");
                txtStockCode.grabFocus();
            }
        }
    }//GEN-LAST:event_txtStockCodeFocusLost

    private void txtStockCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyReleased
        try {
            String Search = txtStockCode.getText();
            String s2 = Search.toUpperCase();
            txtStockCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details "
                    + "WHERE qoh > 0 "
                    + "AND (stock_code LIKE '" + Search + '%' + "' OR description LIKE '" + Search + '%' + "') ORDER BY stock_code ASC");
            //  ResultSet rs = DBControl.getResult("SELECT * FROM stock_details WHERE stock_code LIKE '" + Search + '%' + "' AND qoh > 0 ORDER BY stock_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblStockLoad.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("description"));
                v.add(rs.getString("partno_size"));
                v.add(rs.getDouble("qoh"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtStockCodeKeyReleased

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the stock code first ");
            txtStockCode.grabFocus();
            txtQty.setText("");
        }
    }//GEN-LAST:event_txtQtyKeyReleased

    private void txtQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusGained
    }//GEN-LAST:event_txtQtyFocusGained

    private void txtIssue_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIssue_noFocusLost
        increaseIssue();
    }//GEN-LAST:event_txtIssue_noFocusLost

private void txtStockCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyTyped
    tblStockLoad.setVisible(true);
    jScrollPane5.setVisible(true);
}//GEN-LAST:event_txtStockCodeKeyTyped

    private void txtEquipmentNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquipmentNoKeyReleased
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String Search = txtEquipmentNo.getText();
            String s2 = Search.toUpperCase();
            txtEquipmentNo.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details "
                    + "WHERE equipment_no LIKE '" + Search + '%' + "' "
                    + "OR class_vehicle LIKE '" + Search + '%' + "' "
                    + "ORDER BY equipment_no ASC ");
            DefaultTableModel dtm = (DefaultTableModel) tblEquipLoad.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_txtEquipmentNoKeyReleased

    private void txtEquipmentNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquipmentNoKeyTyped
        tblEquipLoad.setVisible(true);
        jScrollPane6.setVisible(true);

    }//GEN-LAST:event_txtEquipmentNoKeyTyped

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        txtStockCode.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        txtStockDescription.setText("");
        txtStockPartNo.setText("");
        tblStockLoad.setVisible(false);
        jScrollPane5.setVisible(false);
    }//GEN-LAST:event_bClearActionPerformed

    private void tblStockLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockLoadMouseClicked
        try {
            DefaultTableModel dtm = (DefaultTableModel) tblStockLoad.getModel();
            int i = tblStockLoad.getSelectedRow();
            String stock_code = dtm.getValueAt(i, 0).toString();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code = '" + stock_code + "'");
            while (rs.next()) {
                BigDecimal zero = new BigDecimal("0");
                BigDecimal q = rs.getBigDecimal("qoh");
                if (q.equals(zero)) {
                    JOptionPane.showMessageDialog(null, stock_code + " quantity on hand is zero !", "Unable to Add Stock", JOptionPane.ERROR_MESSAGE);
                } else {
                    txtStockCode.setText(stock_code);
                    ResultSet rs2 = DBControl.getResultFromLocalDB("Select * from stock_details WHERE stock_code = '" + stock_code + "'");
                    while (rs2.next()) {
                        String desc = rs2.getString("description");
                        String partNo = rs2.getString("partno_size");

                        String ac = rs2.getString("account_code");
                        String description = "Description: \n" + desc;
                        String partNoSize = "PartNo: \n" + partNo;
                        String acnt = "Account Code: \n" + ac;
                        txtStockDescription.setText(desc);
                        txtStockPartNo.setText(partNo);
                        //   txtStockDetails.setText(description + "\n" + partNoSize + "\n" + acnt);
                    }
                }
            }
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);
            txtStockCode.grabFocus();
        } catch (Exception ex) {
            Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblStockLoadMouseClicked

    private void tblStockLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblStockLoadFocusLost

        tblStockLoad.setVisible(false);
        jScrollPane5.setVisible(false);
    }//GEN-LAST:event_tblStockLoadFocusLost

    private void bClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClear2ActionPerformed
        txtAccountCode.setText("");
        txtDescription.setText("");
        tblAccountLoad.setVisible(false);
        jScrollPane8.setVisible(false);
    }//GEN-LAST:event_bClear2ActionPerformed

    private void tblEquipLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblEquipLoadFocusLost
        tblEquipLoad.setVisible(false);
        jScrollPane6.setVisible(false);
    }//GEN-LAST:event_tblEquipLoadFocusLost

    private void tblEquipLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblEquipLoad.getModel();
        int i = tblEquipLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtEquipmentNo.setText(s1);
        txtEquipmentClass_Vehicle.setText(s2);
        tblEquipLoad.setVisible(false);
        jScrollPane6.setVisible(false);
        txtEquipmentNo.grabFocus();
    }//GEN-LAST:event_tblEquipLoadMouseClicked

    private void txtQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyPressed
//        if (evt.getKeyChar() <= '0') {
//            Toolkit.getDefaultToolkit().beep();
//            txtQty.setText("");
//            // evt.consume();
//        }
    }//GEN-LAST:event_txtQtyKeyPressed

    private void txtStockCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockCodeMouseClicked
        if (tblStockLoad.isVisible()) {
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);
        } else {
            try {
                tblStockLoad.setVisible(true);
                jScrollPane5.setVisible(true);
                ResultSet rs11 = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE qoh > 0 ORDER BY stock_code ASC");
                DefaultTableModel dtm11 = (DefaultTableModel) tblStockLoad.getModel();
                dtm11.setRowCount(0);
                while (rs11.next()) {
                    Vector v21 = new Vector();
                    v21.add(rs11.getString("stock_code"));
                    v21.add(rs11.getString("description"));
                    v21.add(rs11.getString("partno_size"));
                    v21.add(rs11.getDouble("qoh"));
                    dtm11.addRow(v21);
                }
            } catch (Exception ex) {
                Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtStockCodeMouseClicked

    private void txtEquipmentNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEquipmentNoMouseClicked
        if (tblEquipLoad.isVisible()) {
            tblEquipLoad.setVisible(false);
            jScrollPane6.setVisible(false);
        } else {
            tblEquipLoad.setVisible(true);
            jScrollPane6.setVisible(true);
        }
    }//GEN-LAST:event_txtEquipmentNoMouseClicked

    private void bSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bSaveMouseClicked

    private void bSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSaveMouseEntered
        if (bSave.isEnabled()) {
            increaseIssue();
        }
    }//GEN-LAST:event_bSaveMouseEntered

    private void tblAccountLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblAccountLoad.getModel();
        int i = tblAccountLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtAccountCode.setText(s1);
        txtDescription.setText(s2);
        txtAccountCode.grabFocus();
        tblAccountLoad.setVisible(false);
        jScrollPane8.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadMouseClicked

    private void tblAccountLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblAccountLoadFocusLost
        tblAccountLoad.setVisible(false);
        jScrollPane8.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadFocusLost

    private void txtAccountCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccountCodeMouseClicked
        if (tblAccountLoad.isVisible()) {
            tblAccountLoad.setVisible(false);
            jScrollPane8.setVisible(false);
        } else {
            tblAccountLoad.setVisible(true);
            jScrollPane8.setVisible(true);
        }
    }//GEN-LAST:event_txtAccountCodeMouseClicked

    private void txtAccountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyReleased
        try {
            String Search = txtAccountCode.getText();
            String s2 = Search.toUpperCase();
            txtAccountCode.setText(s2);
            jTextField1.setText("Expense");
            String text = jTextField1.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center "
                    + "WHERE type ='" + text + "' "
                    + "AND (account_code LIKE '" + Search + '%' + "' OR description LIKE '" + Search + '%' + "') ORDER BY account_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblAccountLoad.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("account_code"));
                v.add(rs.getString("description"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtAccountCodeKeyReleased

    private void txtAccountCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyTyped
        tblAccountLoad.setVisible(true);
        jScrollPane8.setVisible(true);
    }//GEN-LAST:event_txtAccountCodeKeyTyped

    private void bClear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClear3ActionPerformed
        txtEquipmentNo.setText("");
        txtEquipmentClass_Vehicle.setText("");
        tblEquipLoad.setVisible(false);
        jScrollPane6.setVisible(false);
    }//GEN-LAST:event_bClear3ActionPerformed

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        issue.createPDF(txtIssue_no.getText());
    }//GEN-LAST:event_bPDFActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        scm.utils.HideLoadTable.ThreeTables(tblStockLoad, jScrollPane5, tblEquipLoad, jScrollPane6, tblAccountLoad, jScrollPane8);
    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        scm.utils.HideLoadTable.ThreeTables(tblStockLoad, jScrollPane5, tblEquipLoad, jScrollPane6, tblAccountLoad, jScrollPane8);
    }//GEN-LAST:event_formMouseMoved

    private void tblIssueListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssueListMouseClicked
        try {
            int i = tblIssueList.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
            String stock_code = dtm.getValueAt(i, 0).toString();
            ResultSet rs = DBControl.getResultFromLocalDB("Select * from stock_details WHERE stock_code = '" + stock_code + "'");
            while (rs.next()) {
                String des = rs.getString("description");
                String partNo = rs.getString("partno_size");
                txtStockDescription.setText(des);
                txtStockPartNo.setText(partNo);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblIssueListMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtolist;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bClear2;
    private javax.swing.JButton bClear3;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton removeall;
    private javax.swing.JButton removeselected;
    private javax.swing.JTable tblAccountLoad;
    private javax.swing.JTable tblEquipLoad;
    private javax.swing.JTable tblIssueList;
    private javax.swing.JTable tblStockLoad;
    public static javax.swing.JTextField txtAccountCode;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEquipmentClass_Vehicle;
    private javax.swing.JTextField txtEquipmentNo;
    private com.toedter.calendar.JDateChooser txtIssue_date;
    private javax.swing.JTextField txtIssue_no;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtStockCode;
    private javax.swing.JTextPane txtStockDescription;
    private javax.swing.JTextPane txtStockPartNo;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables

    void newIssue() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT max(issue_no) AS '99999' FROM issue");
            while (rs.next()) {
                int r = rs.getInt("99999");
                txtIssue_no.setText("" + (r + 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addtolist() {
        int decimals = 2;
        if (!txtQty.getText().isEmpty()) {
            double qty1 = Double.parseDouble(txtQty.getText());
            if (qty1 <= 0) {
                JOptionPane.showMessageDialog(null, "Make sure quantity is greater than zero (0) ! ", "Unable to Add Stock", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    BigDecimal qty = new BigDecimal(txtQty.getText());
                    BigDecimal unit_price = new BigDecimal(txtUnitPrice.getText());
                    BigDecimal value = qty.multiply(unit_price).setScale(decimals, BigDecimal.ROUND_DOWN);
                    txtSubTotal.setText(String.valueOf(value));
                    String stock_code = txtStockCode.getText();
                    String pid = txtStockCode.getText();
                    ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT * FROM stock_details where stock_code = '" + pid + "'");
                    while (rs2.next()) {
                        String current_qty = rs2.getString("qoh");
                      //  String minimum_qty = rs2.getString("minimum_quantity");
                        Double cq = Double.parseDouble(current_qty);
                      //  Double mq = Double.parseDouble(minimum_qty);
                        Double new_qty = Double.parseDouble(txtQty.getText());
                        Double minCheck = cq - new_qty;
                        if (new_qty > cq) {
                            JOptionPane.showMessageDialog(this, "New quantity is greater than quantity u have in stock");
                        //} else if (minCheck<mq) {
                        //JOptionPane.showMessageDialog(this, "Minimum quantity is "+mq +" \n PLease make sure new value is greater than minimum qty.");
                        }

                    }
                    ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
                    DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
                    while (rs.next()) {
                        /// Adding to Table
                        BigDecimal zero = new BigDecimal("0");
                        String q = rs.getString("qoh");
                        String new_q = txtQty.getText();
                        BigDecimal qoh = new BigDecimal(q);
                        BigDecimal newQty = new BigDecimal(new_q);
                        if (newQty.compareTo(qoh) > 0 && newQty.compareTo(zero) > 0) {
                            JOptionPane.showMessageDialog(null, stock_code + " quantity on hand is " + q + ". Make sure the New Quantity is less than " + q + " !",
                                    "Unable to Add Stock", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Vector v = new Vector();
                            v.add(txtStockCode.getText());
                            v.add(txtQty.getText());
                            v.add(txtUnitPrice.getText());
                            v.add(rs.getString("description"));
                            v.add(txtSubTotal.getText());
                            dtm.addRow(v);
                            // Total
                            BigDecimal b111 = new BigDecimal("0");
                            int x = dtm.getRowCount();
                            for (int i = 0; i < x; i++) {
                                String s1 = dtm.getValueAt(i, 4).toString();
                                BigDecimal b222 = new BigDecimal(s1);
                                b111 = b111.add(b222);
                                b111 = b111.setScale(decimals, BigDecimal.ROUND_DOWN);
                                txtTotal.setText("" + b111);
                            }
                            txtStockCode.setText("");
                            txtQty.setText("");
                            txtUnitPrice.setText("");
                            txtStockDescription.setText("");
                            txtStockPartNo.setText("");
                            txtStockCode.grabFocus();
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            //   JOptionPane.showMessageDialog(null, "Please enter the Quantity ! ", "Unable to Add Stock", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void increaseIssue() {
        try {
//            int rowCount = 0;
//            int newCount = 0;
//            String Issue_no = txtIssue_no.getText();
//            ResultSet rs1 = DBControl.getResult("SELECT COUNT(*) FROM issue WHERE issue_no = '" + Issue_no + "'");
//            rs1.next();
//            rowCount = rs1.getInt(1);
//            if (rowCount != newCount) {
//                int issue = Integer.parseInt(txtIssue_no.getText());
//                int new_issue = issue + 1;
//                txtIssue_no.setText(String.valueOf(new_issue));
//            }
            ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT issue_no FROM issue ORDER BY issue_no DESC LIMIT 1");
            while (rs2.next()) {
                String Issue_no = rs2.getString("issue_no");
                int issue = Integer.parseInt(Issue_no);
                int new_issue = issue + 1;
                txtIssue_no.setText(String.valueOf(new_issue));
            }
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveIssue() {
        try {
            long time = today.getTime();
            Timestamp ts = new Timestamp(time);
            String timestamp = ts.toString();
            int decimals = 2;
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String valDate = ((JTextField) txtIssue_date.getDateEditor().getUiComponent()).getText();
            String issue_date = null;
            if (!valDate.isEmpty()) {
                issue_date = date.format(txtIssue_date.getDate());
            }
            String issue_no = txtIssue_no.getText();
            String account_code = txtAccountCode.getText();
            String equipment_no = txtEquipmentNo.getText();
            String updated_by = Main.lblUser.getText();
            String total = txtTotal.getText();
            BigDecimal tott = new BigDecimal(total).setScale(decimals, BigDecimal.ROUND_DOWN);
            DefaultTableModel dtm = (DefaultTableModel) tblIssueList.getModel();
            for (int i = 0; i < tblIssueList.getRowCount(); i++) {
                String stock_code = dtm.getValueAt(i, 0).toString();
                String quantity = dtm.getValueAt(i, 1).toString();
                String unit_price = dtm.getValueAt(i, 2).toString();
                String sub_total = dtm.getValueAt(i, 4).toString();
                db.setResult("INSERT INTO issue_details(issue_no,stock_code,quantity,unit_price,sub_total) VALUES('" + issue_no + "','" + stock_code + "','" + quantity + "',"
                        + "'" + unit_price + "','" + sub_total + "')");

                db.setResult("UPDATE stock_details SET qoh = qoh -'" + quantity + "' WHERE stock_code = '" + stock_code + "' ");

                ResultSet rss = DBControl.getResultFromLocalDB("SELECT stock_code FROM issue_qty "
                        + "WHERE stock_code='" + stock_code + "' AND issue_no ='" + issue_no + "'");
                if (rss.next()) {
                    db.setResult("UPDATE issue_qty SET quantity =quantity + '" + quantity + "' "
                            + "WHERE issue_no = '" + issue_no + "'AND stock_code = '" + stock_code + "'");
                } else {
                    db.setResult("INSERT INTO issue_qty (issue_no,stock_code,quantity) "
                            + "VALUES('" + issue_no + "','" + stock_code + "','" + quantity + "')");
                }
            }
            db.setResult("INSERT INTO issue(issue_no,issue_date,account_code,equipment_no,total,user,time) "
                    + "VALUES('" + issue_no + "','" + issue_date + "','" + account_code + "','" + equipment_no + "',"
                    + "'" + tott + "','" + updated_by + "','" + timestamp + "')");
            JOptionPane.showMessageDialog(null, "Successfully Saved");
            bPDF.setEnabled(true);
            bPreview.setEnabled(true);
            bSave.setEnabled(false);
            txtIssue_no.setEditable(false);
        } catch (Exception ex) {
            Logger.getLogger(new_issue.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "If the problem continues, please restart WMS \n" + ex, "Error ! Issue was not saved !", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }
}
