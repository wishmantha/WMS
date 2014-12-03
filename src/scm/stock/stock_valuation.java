package scm.stock;

import java.awt.Cursor;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.help.settings;

public final class stock_valuation extends javax.swing.JInternalFrame {

    Date dated = new Date();
    SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd hh-mm");
    String d = sdff.format(dated);

    public stock_valuation() {
        try {
            initComponents();

            //////////////////////////////
            listAccount.setVisible(false);
            jScrollPane7.setVisible(false);
            listStock.setVisible(false);
            jScrollPane8.setVisible(false);
            String text = "Expense";
            String text1 = "Asset";
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE type ='" + text + "' ORDER BY account_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblExpAccntLoad.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("account_code"));
                v.add(rs.getString("description"));
                dtm.addRow(v);
            }
            ResultSet rs12 = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE type ='" + text1 + "' ORDER BY account_code ASC");
            DefaultTableModel dtm12 = (DefaultTableModel) tblAstAccntLoad.getModel();
            dtm12.setRowCount(0);
            while (rs12.next()) {
                Vector v = new Vector();
                v.add(rs12.getString("account_code"));
                v.add(rs12.getString("description"));
                dtm12.addRow(v);
            }
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM fas_details ORDER BY equipment_no ASC ");
            DefaultTableModel dtm1 = (DefaultTableModel) tblEquipLoad.getModel();
            dtm1.setRowCount(0);
            while (rs1.next()) {
                Vector v1 = new Vector();
                v1.add(rs1.getString("equipment_no"));
                v1.add(rs1.getString("class_vehicle"));
                dtm1.addRow(v1);
            }
            ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT * FROM stock_details ORDER BY stock_code ASC");
            DefaultTableModel dtm2 = (DefaultTableModel) tblStockLoadIssue.getModel();
            dtm2.setRowCount(0);
            while (rs2.next()) {
                Vector v2 = new Vector();
                v2.add(rs2.getString("stock_code"));
                v2.add(rs2.getString("description"));
                dtm2.addRow(v2);
            }

            tblExpAccntLoad.setVisible(false);
            tblExpAccntLoadPane.setVisible(false);
            tblAstAccntLoad.setVisible(false);
            tblAstAccntLoadPane.setVisible(false);
            tblEquipLoad.setVisible(false);
            tblEquipLoadPane.setVisible(false);

            tblStockLoadInVisible();
            /////////////////// JTABLE RIGHT Alignment///////////////
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(SwingConstants.CENTER);
            tblAccount.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
            tblAccount.getColumnModel().getColumn(3).setCellRenderer(dtcr);
            tblAccount.getColumnModel().getColumn(4).setCellRenderer(dtcr);
            tblAccount.getColumnModel().getColumn(5).setCellRenderer(dtcr);

            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(SwingConstants.CENTER);
            tblStock_List.getColumnModel().getColumn(0).setCellRenderer(dtcr2);
            /////////////////////////////////////////////////////////////
//            totalVal();
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblequipment = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listAccount = new javax.swing.JList();
        jToolBar2 = new javax.swing.JToolBar();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bPDF = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        printBASIC = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        previewBASIC = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bClose1 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jLabel27 = new javax.swing.JLabel();
        txtAccountCode = new javax.swing.JTextField();
        txtAccountDescription = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        bLoadAccount = new javax.swing.JButton();
        txtTotalAccount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLayeredPane11 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listStock = new javax.swing.JList();
        jToolBar5 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bPDF1 = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        printBASIC1 = new javax.swing.JButton();
        jSeparator22 = new javax.swing.JToolBar.Separator();
        previewBASIC1 = new javax.swing.JButton();
        jSeparator23 = new javax.swing.JToolBar.Separator();
        bClose2 = new javax.swing.JButton();
        jSeparator24 = new javax.swing.JToolBar.Separator();
        jLabel28 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStockCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bLoadStock = new javax.swing.JButton();
        txtTotalStock = new javax.swing.JTextField();
        txtStockDescription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtStockPrice = new javax.swing.JTextField();
        txtStockQty = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLayeredPane13 = new javax.swing.JLayeredPane();
        jPanel5 = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        jSeparator31 = new javax.swing.JToolBar.Separator();
        bPDF2 = new javax.swing.JButton();
        jSeparator32 = new javax.swing.JToolBar.Separator();
        printBASIC2 = new javax.swing.JButton();
        jSeparator34 = new javax.swing.JToolBar.Separator();
        previewBASIC2 = new javax.swing.JButton();
        jSeparator35 = new javax.swing.JToolBar.Separator();
        bClose3 = new javax.swing.JButton();
        jSeparator36 = new javax.swing.JToolBar.Separator();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStock_List = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtTotalValutation = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jLayeredPane16 = new javax.swing.JLayeredPane();
        jPanel8 = new javax.swing.JPanel();
        tblExpAccntLoadPane = new javax.swing.JScrollPane();
        tblExpAccntLoad = new javax.swing.JTable();
        jToolBar4 = new javax.swing.JToolBar();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        bPDF6ExpAccnt = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        printExpAccnt = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        previewExpAccnt = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        bCloseExpAccnt = new javax.swing.JButton();
        jSeparator30 = new javax.swing.JToolBar.Separator();
        jLabel30 = new javax.swing.JLabel();
        txtExpAccntDes = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        bLoadAccount2 = new javax.swing.JButton();
        tblExpDay1 = new com.toedter.calendar.JDateChooser();
        tblExpDay2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtExpAccntCode = new javax.swing.JTextField();
        jLayeredPane20 = new javax.swing.JLayeredPane();
        jPanel12 = new javax.swing.JPanel();
        tblAstAccntLoadPane = new javax.swing.JScrollPane();
        tblAstAccntLoad = new javax.swing.JTable();
        jToolBar8 = new javax.swing.JToolBar();
        jSeparator27 = new javax.swing.JToolBar.Separator();
        bPDFAstAccnt = new javax.swing.JButton();
        jSeparator28 = new javax.swing.JToolBar.Separator();
        printAstAccnt = new javax.swing.JButton();
        jSeparator29 = new javax.swing.JToolBar.Separator();
        previewAstAccnt = new javax.swing.JButton();
        jSeparator37 = new javax.swing.JToolBar.Separator();
        bCloseAstAccnt = new javax.swing.JButton();
        jSeparator38 = new javax.swing.JToolBar.Separator();
        jLabel52 = new javax.swing.JLabel();
        txtAstAccntDes = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        bLoadAccount3 = new javax.swing.JButton();
        tblAstDay1 = new com.toedter.calendar.JDateChooser();
        tblAstDay2 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtAstAccntCode = new javax.swing.JTextField();
        jLayeredPane19 = new javax.swing.JLayeredPane();
        jPanel11 = new javax.swing.JPanel();
        tblEquipLoadPane = new javax.swing.JScrollPane();
        tblEquipLoad = new javax.swing.JTable();
        jToolBar6 = new javax.swing.JToolBar();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        bPDFEquipment = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        printEquipment = new javax.swing.JButton();
        jSeparator25 = new javax.swing.JToolBar.Separator();
        previewEquipment = new javax.swing.JButton();
        jSeparator26 = new javax.swing.JToolBar.Separator();
        bCloseEquipment = new javax.swing.JButton();
        jSeparator33 = new javax.swing.JToolBar.Separator();
        jLabel43 = new javax.swing.JLabel();
        txtEquipmentClass = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        bLoadEquipment = new javax.swing.JButton();
        tblEquipDay1 = new com.toedter.calendar.JDateChooser();
        tblEquipDay2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtEquipmentNo = new javax.swing.JTextField();
        jLayeredPane17 = new javax.swing.JLayeredPane();
        jPanel9 = new javax.swing.JPanel();
        tblStockLoadIssuePane = new javax.swing.JScrollPane();
        tblStockLoadIssue = new javax.swing.JTable();
        jToolBar9 = new javax.swing.JToolBar();
        jSeparator43 = new javax.swing.JToolBar.Separator();
        bPDF7 = new javax.swing.JButton();
        jSeparator44 = new javax.swing.JToolBar.Separator();
        printBASIC7 = new javax.swing.JButton();
        jSeparator46 = new javax.swing.JToolBar.Separator();
        previewBASIC7 = new javax.swing.JButton();
        jSeparator47 = new javax.swing.JToolBar.Separator();
        bClose8 = new javax.swing.JButton();
        jSeparator48 = new javax.swing.JToolBar.Separator();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        bLoadStock2 = new javax.swing.JButton();
        txtStockCodeIssueDesc = new javax.swing.JTextField();
        tblStockDay1 = new com.toedter.calendar.JDateChooser();
        tblStockDay2 = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStockCodeIssue = new javax.swing.JTextField();
        jLayeredPane18 = new javax.swing.JLayeredPane();
        jPanel10 = new javax.swing.JPanel();
        jToolBar10 = new javax.swing.JToolBar();
        jSeparator49 = new javax.swing.JToolBar.Separator();
        bPDF8 = new javax.swing.JButton();
        jSeparator50 = new javax.swing.JToolBar.Separator();
        printBASIC8 = new javax.swing.JButton();
        jSeparator52 = new javax.swing.JToolBar.Separator();
        previewBASIC8 = new javax.swing.JButton();
        jSeparator53 = new javax.swing.JToolBar.Separator();
        bClose9 = new javax.swing.JButton();
        jSeparator54 = new javax.swing.JToolBar.Separator();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTotalStockIssued = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        txtTotalIssue = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        refreshTotalStockIssued = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "subtotal", "Qty issued"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "subtotal", "Qty issued"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jScrollPane9.setPreferredSize(new java.awt.Dimension(452, 400));

        tblequipment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblequipment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Total"
            }
        ));
        tblequipment.setRowHeight(20);
        jScrollPane9.setViewportView(tblequipment);
        tblequipment.getColumnModel().getColumn(0).setPreferredWidth(40);

        setTitle("Stock Report");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basic_report.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 102));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N

        jTabbedPane2.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane2.setAutoscrolls(true);
        jTabbedPane2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jScrollPane7MouseExited(evt);
            }
        });

        listAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAccountMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(listAccount);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 105, 180, 260));

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.add(jSeparator4);

        bPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDF.setText("PDF");
        bPDF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDF.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFActionPerformed(evt);
            }
        });
        jToolBar2.add(bPDF);
        jToolBar2.add(jSeparator1);

        printBASIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printBASIC.setText("PRINT");
        printBASIC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printBASIC.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printBASIC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBASICActionPerformed(evt);
            }
        });
        jToolBar2.add(printBASIC);
        jToolBar2.add(jSeparator3);

        previewBASIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewBASIC.setText("Preview");
        previewBASIC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewBASIC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewBASIC.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewBASIC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewBASICActionPerformed(evt);
            }
        });
        jToolBar2.add(previewBASIC);
        jToolBar2.add(jSeparator5);

        bClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose1.setText("Close");
        bClose1.setFocusable(false);
        bClose1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClose1ActionPerformed(evt);
            }
        });
        jToolBar2.add(bClose1);
        jToolBar2.add(jSeparator8);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Stock in Hand");
        jLabel27.setIconTextGap(10);
        jLabel27.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar2.add(jLabel27);

        jPanel2.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        txtAccountCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountCodeActionPerformed(evt);
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
        jPanel2.add(txtAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 180, 25));

        txtAccountDescription.setEditable(false);
        txtAccountDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtAccountDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 570, 25));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Category");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel8.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 80, 25));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Account Code");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 25));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 400));

        tblAccount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Description", "PartNo Size", "QOH", "Unit Price", "Value"
            }
        ));
        tblAccount.setRowHeight(20);
        jScrollPane1.setViewportView(tblAccount);
        tblAccount.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblAccount.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblAccount.getColumnModel().getColumn(1).setHeaderValue("Description");
        tblAccount.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblAccount.getColumnModel().getColumn(2).setHeaderValue("PartNo Size");
        tblAccount.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblAccount.getColumnModel().getColumn(3).setHeaderValue("QOH");
        tblAccount.getColumnModel().getColumn(4).setPreferredWidth(60);
        tblAccount.getColumnModel().getColumn(4).setHeaderValue("Unit Price");
        tblAccount.getColumnModel().getColumn(5).setPreferredWidth(80);
        tblAccount.getColumnModel().getColumn(5).setHeaderValue("Value");

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 970, 280));

        bLoadAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadAccount.setBorderPainted(false);
        bLoadAccount.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadAccountActionPerformed(evt);
            }
        });
        jPanel2.add(bLoadAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 30, 25));

        txtTotalAccount.setEditable(false);
        txtTotalAccount.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTotalAccount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtTotalAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 190, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Rs.");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, -1, 30));

        jLabel15.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total");
        jLabel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel15.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 70, 30));

        jPanel2.setBounds(0, 0, 1040, 450);
        jLayeredPane10.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("By Account Code", jLayeredPane10);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listStock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listStockMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(listStock);

        jPanel3.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 103, 180, 240));

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);
        jToolBar5.add(jSeparator6);

        bPDF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDF1.setText("PDF");
        bPDF1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDF1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDF1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDF1ActionPerformed(evt);
            }
        });
        jToolBar5.add(bPDF1);
        jToolBar5.add(jSeparator20);

        printBASIC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printBASIC1.setText("PRINT");
        printBASIC1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printBASIC1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printBASIC1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printBASIC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBASIC1ActionPerformed(evt);
            }
        });
        jToolBar5.add(printBASIC1);
        jToolBar5.add(jSeparator22);

        previewBASIC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewBASIC1.setText("Preview");
        previewBASIC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewBASIC1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewBASIC1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewBASIC1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewBASIC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewBASIC1ActionPerformed(evt);
            }
        });
        jToolBar5.add(previewBASIC1);
        jToolBar5.add(jSeparator23);

        bClose2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose2.setText("Close");
        bClose2.setFocusable(false);
        bClose2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose2.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClose2ActionPerformed(evt);
            }
        });
        jToolBar5.add(bClose2);
        jToolBar5.add(jSeparator24);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Stock in Hand");
        jLabel28.setIconTextGap(10);
        jLabel28.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar5.add(jLabel28);

        jPanel3.add(jToolBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Stock Code");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 25));

        txtStockCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockCodeActionPerformed(evt);
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
        jPanel3.add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 180, 25));

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Description");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 25));

        bLoadStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadStock.setBorderPainted(false);
        bLoadStock.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadStockActionPerformed(evt);
            }
        });
        jPanel3.add(bLoadStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 30, 25));

        txtTotalStock.setEditable(false);
        txtTotalStock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtTotalStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(txtTotalStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 170, 25));

        txtStockDescription.setEditable(false);
        jPanel3.add(txtStockDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, 25));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Rs.");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 30, 25));

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Quantity On Hand");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 25));

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total");
        jLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel13.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 25));

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Average Unit Price");
        jLabel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel14.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, 25));

        txtStockPrice.setEditable(false);
        txtStockPrice.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtStockPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(txtStockPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 170, 25));

        txtStockQty.setEditable(false);
        txtStockQty.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtStockQty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(txtStockQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 170, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Rs.");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 30, 25));

        jLabel5.setText("Stock Valuation");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 160, -1));

        jPanel3.setBounds(0, 0, 1030, 450);
        jLayeredPane11.add(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("By Stock Code", jLayeredPane11);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar7.setFloatable(false);
        jToolBar7.setRollover(true);
        jToolBar7.add(jSeparator31);

        bPDF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDF2.setText("PDF");
        bPDF2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDF2.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDF2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDF2ActionPerformed(evt);
            }
        });
        jToolBar7.add(bPDF2);
        jToolBar7.add(jSeparator32);

        printBASIC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printBASIC2.setText("PRINT");
        printBASIC2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printBASIC2.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printBASIC2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printBASIC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBASIC2ActionPerformed(evt);
            }
        });
        jToolBar7.add(printBASIC2);
        jToolBar7.add(jSeparator34);

        previewBASIC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewBASIC2.setText("Preview");
        previewBASIC2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewBASIC2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewBASIC2.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewBASIC2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewBASIC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewBASIC2ActionPerformed(evt);
            }
        });
        jToolBar7.add(previewBASIC2);
        jToolBar7.add(jSeparator35);

        bClose3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose3.setText("Close");
        bClose3.setFocusable(false);
        bClose3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose3.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClose3ActionPerformed(evt);
            }
        });
        jToolBar7.add(bClose3);
        jToolBar7.add(jSeparator36);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Stock in Hand");
        jLabel29.setIconTextGap(10);
        jLabel29.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar7.add(jLabel29);

        jPanel5.add(jToolBar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        tblStock_List.setAutoCreateRowSorter(true);
        tblStock_List.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblStock_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Description", "Part No/Size", "Unit Price", "QOH", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStock_List.setRowHeight(20);
        tblStock_List.getTableHeader().setReorderingAllowed(false);
        tblStock_List.setVerifyInputWhenFocusTarget(false);
        tblStock_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStock_ListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblStock_List);
        tblStock_List.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblStock_List.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblStock_List.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblStock_List.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblStock_List.getColumnModel().getColumn(4).setPreferredWidth(10);
        tblStock_List.getColumnModel().getColumn(5).setPreferredWidth(60);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 970, 310));

        jLabel25.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Total");
        jLabel25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel25.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 70, 30));

        txtTotalValutation.setEditable(false);
        txtTotalValutation.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTotalValutation.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel5.add(txtTotalValutation, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 190, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel26.setText("Rs.");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, -1, 30));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, 30));

        jPanel5.setBounds(0, 0, 1150, 440);
        jLayeredPane13.add(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("Total Valuation", jLayeredPane13);

        jTabbedPane2.setBounds(0, 0, 1010, 470);
        jLayeredPane1.add(jTabbedPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("                              Stock in Hand                              ", new javax.swing.ImageIcon(getClass().getResource("/images/valuation_total.png")), jLayeredPane1); // NOI18N

        jLayeredPane2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N

        jTabbedPane4.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane4.setAutoscrolls(true);
        jTabbedPane4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel8MouseMoved(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblExpAccntLoadPane.setBackground(new java.awt.Color(249, 249, 249));
        tblExpAccntLoadPane.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblExpAccntLoad.setBackground(new java.awt.Color(240, 240, 240));
        tblExpAccntLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblExpAccntLoad.setModel(new javax.swing.table.DefaultTableModel(
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
        tblExpAccntLoad.setRowHeight(20);
        tblExpAccntLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExpAccntLoadMouseClicked(evt);
            }
        });
        tblExpAccntLoad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblExpAccntLoadFocusLost(evt);
            }
        });
        tblExpAccntLoadPane.setViewportView(tblExpAccntLoad);
        tblExpAccntLoad.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblExpAccntLoad.getColumnModel().getColumn(1).setPreferredWidth(200);

        jPanel8.add(tblExpAccntLoadPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 155, 360, 260));

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);
        jToolBar4.add(jSeparator15);

        bPDF6ExpAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDF6ExpAccnt.setText("PDF");
        bPDF6ExpAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDF6ExpAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDF6ExpAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDF6ExpAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDF6ExpAccntActionPerformed(evt);
            }
        });
        jToolBar4.add(bPDF6ExpAccnt);
        jToolBar4.add(jSeparator17);

        printExpAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printExpAccnt.setText("PRINT");
        printExpAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printExpAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printExpAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printExpAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printExpAccntActionPerformed(evt);
            }
        });
        jToolBar4.add(printExpAccnt);
        jToolBar4.add(jSeparator18);

        previewExpAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewExpAccnt.setText("Preview");
        previewExpAccnt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewExpAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewExpAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewExpAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewExpAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewExpAccntActionPerformed(evt);
            }
        });
        jToolBar4.add(previewExpAccnt);
        jToolBar4.add(jSeparator19);

        bCloseExpAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseExpAccnt.setText("Close");
        bCloseExpAccnt.setFocusable(false);
        bCloseExpAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseExpAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseExpAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseExpAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseExpAccntActionPerformed(evt);
            }
        });
        jToolBar4.add(bCloseExpAccnt);
        jToolBar4.add(jSeparator30);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Stock Issued - Expense Account");
        jLabel30.setIconTextGap(10);
        jLabel30.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar4.add(jLabel30);

        jPanel8.add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        txtExpAccntDes.setEditable(false);
        txtExpAccntDes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel8.add(txtExpAccntDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 550, 25));

        jLabel31.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Description");
        jLabel31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel31.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 90, 25));

        jLabel32.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Date Range");
        jLabel32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 25));

        bLoadAccount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadAccount2.setBorderPainted(false);
        bLoadAccount2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bLoadAccount2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadAccount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadAccount2ActionPerformed(evt);
            }
        });
        jPanel8.add(bLoadAccount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 30, 25));

        tblExpDay1.setDateFormatString("dd/MM/yy");
        tblExpDay1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel8.add(tblExpDay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 25));

        tblExpDay2.setDateFormatString("dd/MM/yy");
        tblExpDay2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel8.add(tblExpDay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 130, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("AND");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 30, 25));

        jLabel38.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Account Code");
        jLabel38.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 25));

        txtExpAccntCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtExpAccntCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExpAccntCodeMouseClicked(evt);
            }
        });
        txtExpAccntCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpAccntCodeActionPerformed(evt);
            }
        });
        txtExpAccntCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExpAccntCodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExpAccntCodeKeyTyped(evt);
            }
        });
        jPanel8.add(txtExpAccntCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, 25));

        jPanel8.setBounds(0, 0, 1040, 450);
        jLayeredPane16.add(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane4.addTab("By Expense Account Code", jLayeredPane16);

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));
        jPanel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel12MouseMoved(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAstAccntLoadPane.setBackground(new java.awt.Color(249, 249, 249));
        tblAstAccntLoadPane.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblAstAccntLoad.setBackground(new java.awt.Color(240, 240, 240));
        tblAstAccntLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAstAccntLoad.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAstAccntLoad.setOpaque(false);
        tblAstAccntLoad.setRowHeight(20);
        tblAstAccntLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAstAccntLoadMouseClicked(evt);
            }
        });
        tblAstAccntLoad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblAstAccntLoadFocusLost(evt);
            }
        });
        tblAstAccntLoadPane.setViewportView(tblAstAccntLoad);
        tblAstAccntLoad.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblAstAccntLoad.getColumnModel().getColumn(1).setPreferredWidth(200);

        jPanel12.add(tblAstAccntLoadPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 155, 360, 260));

        jToolBar8.setFloatable(false);
        jToolBar8.setRollover(true);
        jToolBar8.add(jSeparator27);

        bPDFAstAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFAstAccnt.setText("PDF");
        bPDFAstAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFAstAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFAstAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFAstAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFAstAccntActionPerformed(evt);
            }
        });
        jToolBar8.add(bPDFAstAccnt);
        jToolBar8.add(jSeparator28);

        printAstAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printAstAccnt.setText("PRINT");
        printAstAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printAstAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printAstAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printAstAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printAstAccntActionPerformed(evt);
            }
        });
        jToolBar8.add(printAstAccnt);
        jToolBar8.add(jSeparator29);

        previewAstAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewAstAccnt.setText("Preview");
        previewAstAccnt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewAstAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewAstAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewAstAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewAstAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewAstAccntActionPerformed(evt);
            }
        });
        jToolBar8.add(previewAstAccnt);
        jToolBar8.add(jSeparator37);

        bCloseAstAccnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseAstAccnt.setText("Close");
        bCloseAstAccnt.setFocusable(false);
        bCloseAstAccnt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseAstAccnt.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseAstAccnt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseAstAccnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseAstAccntActionPerformed(evt);
            }
        });
        jToolBar8.add(bCloseAstAccnt);
        jToolBar8.add(jSeparator38);

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Stock Issued - Asset Account");
        jLabel52.setIconTextGap(10);
        jLabel52.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar8.add(jLabel52);

        jPanel12.add(jToolBar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        txtAstAccntDes.setEditable(false);
        txtAstAccntDes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel12.add(txtAstAccntDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 550, 25));

        jLabel53.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Description");
        jLabel53.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel53.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel12.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 90, 25));

        jLabel54.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Date Range");
        jLabel54.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel12.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 25));

        bLoadAccount3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadAccount3.setBorderPainted(false);
        bLoadAccount3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bLoadAccount3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadAccount3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadAccount3ActionPerformed(evt);
            }
        });
        jPanel12.add(bLoadAccount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 30, 25));

        tblAstDay1.setDateFormatString("dd/MM/yy");
        tblAstDay1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel12.add(tblAstDay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 25));

        tblAstDay2.setDateFormatString("dd/MM/yy");
        tblAstDay2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel12.add(tblAstDay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 130, 25));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("AND");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 30, 25));

        jLabel57.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Account Code");
        jLabel57.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel12.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 25));

        txtAstAccntCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAstAccntCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAstAccntCodeMouseClicked(evt);
            }
        });
        txtAstAccntCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAstAccntCodeActionPerformed(evt);
            }
        });
        txtAstAccntCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAstAccntCodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAstAccntCodeKeyTyped(evt);
            }
        });
        jPanel12.add(txtAstAccntCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, 25));

        jPanel12.setBounds(0, 0, 1040, 450);
        jLayeredPane20.add(jPanel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane4.addTab("By Asset Account Code", jLayeredPane20);

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));
        jPanel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel11MouseMoved(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEquipLoadPane.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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
        tblEquipLoadPane.setViewportView(tblEquipLoad);
        tblEquipLoad.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblEquipLoad.getColumnModel().getColumn(1).setPreferredWidth(200);

        jPanel11.add(tblEquipLoadPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 155, 360, 260));

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);
        jToolBar6.add(jSeparator16);

        bPDFEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFEquipment.setText("PDF");
        bPDFEquipment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFEquipment.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFEquipment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFEquipmentActionPerformed(evt);
            }
        });
        jToolBar6.add(bPDFEquipment);
        jToolBar6.add(jSeparator21);

        printEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printEquipment.setText("PRINT");
        printEquipment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printEquipment.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printEquipment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printEquipmentActionPerformed(evt);
            }
        });
        jToolBar6.add(printEquipment);
        jToolBar6.add(jSeparator25);

        previewEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewEquipment.setText("Preview");
        previewEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewEquipment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewEquipment.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewEquipment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewEquipmentActionPerformed(evt);
            }
        });
        jToolBar6.add(previewEquipment);
        jToolBar6.add(jSeparator26);

        bCloseEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseEquipment.setText("Close");
        bCloseEquipment.setFocusable(false);
        bCloseEquipment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseEquipment.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseEquipment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseEquipmentActionPerformed(evt);
            }
        });
        jToolBar6.add(bCloseEquipment);
        jToolBar6.add(jSeparator33);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Stock Issued - Equipment");
        jLabel43.setIconTextGap(10);
        jLabel43.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar6.add(jLabel43);

        jPanel11.add(jToolBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        txtEquipmentClass.setEditable(false);
        txtEquipmentClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel11.add(txtEquipmentClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 550, 25));

        jLabel47.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Class");
        jLabel47.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel47.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 90, 25));

        jLabel48.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Date Range");
        jLabel48.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel11.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 25));

        bLoadEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadEquipment.setBorderPainted(false);
        bLoadEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bLoadEquipment.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadEquipmentActionPerformed(evt);
            }
        });
        jPanel11.add(bLoadEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 30, 25));

        tblEquipDay1.setDateFormatString("dd/MM/yy");
        tblEquipDay1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel11.add(tblEquipDay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 25));

        tblEquipDay2.setDateFormatString("dd/MM/yy");
        tblEquipDay2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel11.add(tblEquipDay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 130, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("AND");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 30, 25));

        jLabel51.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Equipment No");
        jLabel51.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel11.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 25));

        txtEquipmentNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEquipmentNo.setToolTipText("Enter your search item");
        txtEquipmentNo.setName(""); // NOI18N
        txtEquipmentNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEquipmentNoMouseClicked(evt);
            }
        });
        txtEquipmentNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentNoActionPerformed(evt);
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
        jPanel11.add(txtEquipmentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, 25));

        jPanel11.setBounds(0, 0, 1040, 450);
        jLayeredPane19.add(jPanel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane4.addTab("By Equipment No", jLayeredPane19);

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
        jPanel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel9MouseMoved(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStockLoadIssuePane.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblStockLoadIssue.setBackground(new java.awt.Color(240, 240, 240));
        tblStockLoadIssue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblStockLoadIssue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStockLoadIssue.setRowHeight(20);
        tblStockLoadIssue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockLoadIssueMouseClicked(evt);
            }
        });
        tblStockLoadIssue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblStockLoadIssueFocusLost(evt);
            }
        });
        tblStockLoadIssuePane.setViewportView(tblStockLoadIssue);
        tblStockLoadIssue.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblStockLoadIssue.getColumnModel().getColumn(1).setPreferredWidth(200);

        jPanel9.add(tblStockLoadIssuePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 155, 360, 260));

        jToolBar9.setFloatable(false);
        jToolBar9.setRollover(true);
        jToolBar9.add(jSeparator43);

        bPDF7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDF7.setText("PDF");
        bPDF7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDF7.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDF7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDF7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDF7ActionPerformed(evt);
            }
        });
        jToolBar9.add(bPDF7);
        jToolBar9.add(jSeparator44);

        printBASIC7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printBASIC7.setText("PRINT");
        printBASIC7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printBASIC7.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printBASIC7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printBASIC7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBASIC7ActionPerformed(evt);
            }
        });
        jToolBar9.add(printBASIC7);
        jToolBar9.add(jSeparator46);

        previewBASIC7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewBASIC7.setText("Preview");
        previewBASIC7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewBASIC7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewBASIC7.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewBASIC7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewBASIC7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewBASIC7ActionPerformed(evt);
            }
        });
        jToolBar9.add(previewBASIC7);
        jToolBar9.add(jSeparator47);

        bClose8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose8.setText("Close");
        bClose8.setFocusable(false);
        bClose8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose8.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClose8ActionPerformed(evt);
            }
        });
        jToolBar9.add(bClose8);
        jToolBar9.add(jSeparator48);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Stock Issued - Stock Code");
        jLabel35.setIconTextGap(10);
        jLabel35.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar9.add(jLabel35);

        jPanel9.add(jToolBar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        jLabel36.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Stock Code");
        jLabel36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 25));

        jLabel37.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Description");
        jLabel37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel37.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel9.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 90, 25));

        bLoadStock2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadStock2.setBorderPainted(false);
        bLoadStock2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadStock2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadStock2ActionPerformed(evt);
            }
        });
        jPanel9.add(bLoadStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 30, 25));

        txtStockCodeIssueDesc.setEditable(false);
        jPanel9.add(txtStockCodeIssueDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 550, 25));

        tblStockDay1.setDateFormatString("dd/MM/yy");
        tblStockDay1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel9.add(tblStockDay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 25));

        tblStockDay2.setDateFormatString("dd/MM/yy");
        tblStockDay2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel9.add(tblStockDay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 130, 25));

        jLabel41.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Date Range");
        jLabel41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel9.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("AND");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 30, 25));

        txtStockCodeIssue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockCodeIssue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStockCodeIssueMouseClicked(evt);
            }
        });
        txtStockCodeIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockCodeIssueActionPerformed(evt);
            }
        });
        txtStockCodeIssue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockCodeIssueKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockCodeIssueKeyTyped(evt);
            }
        });
        jPanel9.add(txtStockCodeIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, 25));

        jPanel9.setBounds(0, 0, 1030, 450);
        jLayeredPane17.add(jPanel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane4.addTab("By Stock Code", jLayeredPane17);

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar10.setFloatable(false);
        jToolBar10.setRollover(true);
        jToolBar10.add(jSeparator49);

        bPDF8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDF8.setText("PDF");
        bPDF8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDF8.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDF8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDF8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDF8ActionPerformed(evt);
            }
        });
        jToolBar10.add(bPDF8);
        jToolBar10.add(jSeparator50);

        printBASIC8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printBASIC8.setText("PRINT");
        printBASIC8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printBASIC8.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printBASIC8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printBASIC8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBASIC8ActionPerformed(evt);
            }
        });
        jToolBar10.add(printBASIC8);
        jToolBar10.add(jSeparator52);

        previewBASIC8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewBASIC8.setText("Preview");
        previewBASIC8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewBASIC8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewBASIC8.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewBASIC8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewBASIC8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewBASIC8ActionPerformed(evt);
            }
        });
        jToolBar10.add(previewBASIC8);
        jToolBar10.add(jSeparator53);

        bClose9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose9.setText("Close");
        bClose9.setFocusable(false);
        bClose9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose9.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClose9ActionPerformed(evt);
            }
        });
        jToolBar10.add(bClose9);
        jToolBar10.add(jSeparator54);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Stock Issued");
        jLabel44.setIconTextGap(10);
        jLabel44.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar10.add(jLabel44);

        jPanel10.add(jToolBar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        tblTotalStockIssued.setAutoCreateRowSorter(true);
        tblTotalStockIssued.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblTotalStockIssued.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Description", "Part No/Size", "Unit Price", "QOH", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTotalStockIssued.setRowHeight(20);
        tblTotalStockIssued.getTableHeader().setReorderingAllowed(false);
        tblTotalStockIssued.setVerifyInputWhenFocusTarget(false);
        tblTotalStockIssued.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTotalStockIssuedMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblTotalStockIssued);
        tblTotalStockIssued.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblTotalStockIssued.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblTotalStockIssued.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblTotalStockIssued.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblTotalStockIssued.getColumnModel().getColumn(4).setPreferredWidth(10);
        tblTotalStockIssued.getColumnModel().getColumn(5).setPreferredWidth(60);

        jPanel10.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 970, 310));

        jLabel45.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 0, 0));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Total");
        jLabel45.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel45.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel10.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 70, 30));

        txtTotalIssue.setEditable(false);
        txtTotalIssue.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTotalIssue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel10.add(txtTotalIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 190, 30));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel46.setText("Rs.");
        jPanel10.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, -1, 30));

        refreshTotalStockIssued.setText("Refresh");
        refreshTotalStockIssued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTotalStockIssuedActionPerformed(evt);
            }
        });
        jPanel10.add(refreshTotalStockIssued, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, 30));

        jPanel10.setBounds(0, 0, 1150, 440);
        jLayeredPane18.add(jPanel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane4.addTab("Total Valuation", jLayeredPane18);

        jTabbedPane4.setBounds(0, 0, 1010, 470);
        jLayeredPane2.add(jTabbedPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTabbedPane4.getAccessibleContext().setAccessibleName("By Equipment No");

        jTabbedPane1.addTab("                              Stock Issued                              ", new javax.swing.ImageIcon(getClass().getResource("/images/valuation_stock.png")), jLayeredPane2); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 510));
        jTabbedPane1.getAccessibleContext().setAccessibleName("Stock in Hand");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClose1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bClose1ActionPerformed

    private void bClose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClose2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bClose2ActionPerformed

    private void bClose3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClose3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bClose3ActionPerformed

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
//        try {
//            TableModel model = (TableModel) tblAccount.getModel();
//            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
//            String reportSource = "C:\\SCM Files\\Reports\\rr.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/Reports/basic.pdf");
//        } catch (JRException jRException) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException);
//        }
    }//GEN-LAST:event_bPDFActionPerformed

    private void printBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBASICActionPerformed
//        try {
//            TableModel model = (TableModel) tblAccount.getModel();
//            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
//            String reportSource = "C:\\SCM Files\\Reports\\rr.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
//            JasperPrintManager.printReport(jasperPrint, true);
//        } catch (Exception exception) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + exception);
//        }
    }//GEN-LAST:event_printBASICActionPerformed

    private void previewBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBASICActionPerformed
//        try {
//            TableModel model = (TableModel) tblAccount.getModel();
//            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
//            // String reportSource =System.getProperty("user.dir") + "\\rr.jrxml";
//            String reportSource = "C:\\SCM Files\\Reports\\rr.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (JRException jRException) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException);
//        }
    }//GEN-LAST:event_previewBASICActionPerformed

    private void bPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDF1ActionPerformed
//        try {
//
//            String reportSource = "C:\\SCM Files\\Reports\\rr_2.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/Reports/filter.pdf");
//        } catch (JRException jRException) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException);
//        }
    }//GEN-LAST:event_bPDF1ActionPerformed

    private void printBASIC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBASIC1ActionPerformed
//        try {
//
//            String reportSource = "C:\\SCM Files\\Reports\\rr_2.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);
//            JasperPrintManager.printReport(jasperPrint, true);
//        } catch (Exception exception) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + exception);
//        }
    }//GEN-LAST:event_printBASIC1ActionPerformed

    private void previewBASIC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBASIC1ActionPerformed
//        try {
//
//            String reportSource = "C:\\SCM Files\\Reports\\rr_2.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (JRException jRException) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException);
//        }
    }//GEN-LAST:event_previewBASIC1ActionPerformed

    private void bPDF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDF2ActionPerformed
//        try {
//            TableModel model = (TableModel) tblTotal.getModel();
//            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
//            String reportSource = "C:\\SCM Files\\Reports\\rr_3.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/Reports/filter.pdf");
//        } catch (JRException jRException) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException);
//        }
    }//GEN-LAST:event_bPDF2ActionPerformed

    private void printBASIC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBASIC2ActionPerformed
//        try {
//            TableModel model = (TableModel) tblTotal.getModel();
//            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
//            String reportSource = "C:\\SCM Files\\Reports\\rr_3.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
//            JasperPrintManager.printReport(jasperPrint, true);
//        } catch (Exception exception) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + exception);
//        }
    }//GEN-LAST:event_printBASIC2ActionPerformed

    private void previewBASIC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBASIC2ActionPerformed
//        try {
//            TableModel model = (TableModel) tblTotal.getModel();
//            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
//            String reportSource = "C:\\SCM Files\\Reports\\rr_3.jrxml";
//            Map<String, Object> params = new HashMap<String, Object>();
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (JRException jRException) {
//            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException);
//        }
    }//GEN-LAST:event_previewBASIC2ActionPerformed

    private void txtAccountCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyTyped
        listAccount.setVisible(true);
        jScrollPane7.setVisible(true);
    }//GEN-LAST:event_txtAccountCodeKeyTyped

    private void txtAccountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyReleased
        try {
            String SID = (String) txtAccountCode.getText();
            String s2 = SID.toUpperCase();
            txtAccountCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code LIKE '" + SID + '%' + "' ORDER BY account_code ASC ");
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("account_code"));
            }
            listAccount.setListData(v);
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtAccountCodeKeyReleased

    private void listAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAccountMouseClicked
        String s11 = (String) listAccount.getSelectedValue();
        txtAccountCode.setText(s11);
        try {
            String SID = (String) txtAccountCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code = '" + SID + "'");
            while (rs.next()) {
                txtAccountDescription.setText(rs.getString("description"));
            }
            listAccount.setVisible(false);
            jScrollPane7.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
        load();
    }//GEN-LAST:event_listAccountMouseClicked

    private void txtAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountCodeActionPerformed
        try {
            String SID = (String) txtAccountCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code='" + SID + "'");
            while (rs.next()) {
                txtAccountDescription.setText(rs.getString("description"));
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtAccountCodeActionPerformed

    private void bLoadAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadAccountActionPerformed
        load();
    }//GEN-LAST:event_bLoadAccountActionPerformed

private void txtStockCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockCodeActionPerformed
    try {
        String SID = (String) txtStockCode.getText();
        ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + SID + "'");
        while (rs.next()) {
            txtStockDescription.setText(rs.getString("description"));
            txtStockPrice.setText(rs.getString("unit_price"));
            txtStockQty.setText(rs.getString("qoh"));
        }
    } catch (Exception ex) {
        Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
    }
}//GEN-LAST:event_txtStockCodeActionPerformed

private void txtStockCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyReleased
    try {
        String SID = (String) txtStockCode.getText();
        String s2 = SID.toUpperCase();
        txtStockCode.setText(s2);
        ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code LIKE '" + SID + '%' + "'ORDER BY stock_code ASC ");
        Vector v = new Vector();
        while (rs.next()) {
            v.add(rs.getString("stock_code"));
        }
        listStock.setListData(v);
    } catch (Exception ex) {
        Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
    }
}//GEN-LAST:event_txtStockCodeKeyReleased

private void txtStockCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyTyped
    listStock.setVisible(true);
    jScrollPane8.setVisible(true);
}//GEN-LAST:event_txtStockCodeKeyTyped

private void listStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listStockMouseClicked
    String s1 = (String) listStock.getSelectedValue();
    txtStockCode.setText(s1);
    try {
        String SID = (String) txtStockCode.getText();
        ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code  = '" + SID + "'");
        while (rs.next()) {
            txtStockDescription.setText(rs.getString("description"));
            txtStockPrice.setText(rs.getString("unit_price"));
            txtStockQty.setText(rs.getString("qoh"));
        }
        listStock.setVisible(false);
        jScrollPane8.setVisible(false);
    } catch (Exception ex) {
        Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
    }
    BigDecimal price = new BigDecimal(txtStockPrice.getText());
    BigDecimal qty = new BigDecimal(txtStockQty.getText());
    BigDecimal value = price.multiply(qty).setScale(2, BigDecimal.ROUND_DOWN);
    txtTotalStock.setText("" + value);

}//GEN-LAST:event_listStockMouseClicked

private void bLoadStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadStockActionPerformed
    if (txtStockPrice.getText().isEmpty() && txtStockQty.getText().isEmpty()) {
    } else {
        BigDecimal price = new BigDecimal(txtStockPrice.getText());
        BigDecimal qty = new BigDecimal(txtStockQty.getText());
        BigDecimal value = price.multiply(qty).setScale(2, BigDecimal.ROUND_DOWN);
        txtTotalStock.setText("" + value);
    }
}//GEN-LAST:event_bLoadStockActionPerformed

    private void tblStock_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStock_ListMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) tblStock_List.getModel();
        int i = tblStock_List.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();

        txtStockCode.setText(t1);
        txtAccountCode.setText(t2);
    }//GEN-LAST:event_tblStock_ListMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        totalVal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bPDF6ExpAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDF6ExpAccntActionPerformed
        if (tblExpDay1.getDate() == null || tblExpDay2.getDate() == null || txtExpAccntCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String account_code = txtExpAccntCode.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblExpDay1.getDate();
                sdf.format(d1);
                Date d2 = tblExpDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("account_code", account_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "Stock Reports\\" + "Stock_Issued_AccountCode_( " + d + " )" + ".pdf";
                JasperExportManager.exportReportToPdfFile(jasperPrint, path);
                JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder");

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);
            }
        }

    }//GEN-LAST:event_bPDF6ExpAccntActionPerformed
    private void printExpAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printExpAccntActionPerformed
        if (tblExpDay1.getDate() == null || tblExpDay2.getDate() == null || txtExpAccntCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String account_code = txtExpAccntCode.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblExpDay1.getDate();
                sdf.format(d1);
                Date d2 = tblExpDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("account_code", account_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperPrintManager.printReport(jasperPrint, true);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);

            }
        }
    }//GEN-LAST:event_printExpAccntActionPerformed

    private void previewExpAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewExpAccntActionPerformed
        if (tblExpDay1.getDate() == null || tblExpDay2.getDate() == null || txtExpAccntCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String account_code = txtExpAccntCode.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblExpDay1.getDate();
                sdf.format(d1);
                Date d2 = tblExpDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("account_code", account_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("Stock Issue Report [ " + account_code + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_previewExpAccntActionPerformed

    private void bCloseExpAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseExpAccntActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseExpAccntActionPerformed

    private void bLoadAccount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadAccount2ActionPerformed
        load2();
    }//GEN-LAST:event_bLoadAccount2ActionPerformed

    private void bPDF7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDF7ActionPerformed
        if (tblStockDay1.getDate() == null || tblStockDay2.getDate() == null || txtStockCodeIssue.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String stock_code = txtStockCodeIssue.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblStockDay1.getDate();
                sdf.format(d1);
                Date d2 = tblStockDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_stock.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("stock_code", stock_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "Stock Reports\\" + "Stock_Issued_StockCode_( " + d + " )" + ".pdf";
                JasperExportManager.exportReportToPdfFile(jasperPrint, path);
                JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }//GEN-LAST:event_bPDF7ActionPerformed

    private void printBASIC7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBASIC7ActionPerformed
        if (tblStockDay1.getDate() == null || tblStockDay2.getDate() == null || txtStockCodeIssue.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String stock_code = txtStockCodeIssue.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblStockDay1.getDate();
                sdf.format(d1);
                Date d2 = tblStockDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_stock.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("stock_code", stock_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperPrintManager.printReport(jasperPrint, true);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }//GEN-LAST:event_printBASIC7ActionPerformed

    private void previewBASIC7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBASIC7ActionPerformed
        if (tblStockDay1.getDate() == null || tblStockDay2.getDate() == null || txtStockCodeIssue.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String stock_code = txtStockCodeIssue.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblStockDay1.getDate();
                sdf.format(d1);
                Date d2 = tblStockDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_stock.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("stock_code", stock_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("Stock Issue Report [ " + stock_code + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_previewBASIC7ActionPerformed

    private void bClose8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClose8ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bClose8ActionPerformed

    private void bLoadStock2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadStock2ActionPerformed
        loadStockCodeIssue();
    }//GEN-LAST:event_bLoadStock2ActionPerformed

    private void bPDF8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDF8ActionPerformed
    }//GEN-LAST:event_bPDF8ActionPerformed

    private void printBASIC8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBASIC8ActionPerformed
    }//GEN-LAST:event_printBASIC8ActionPerformed

    private void previewBASIC8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBASIC8ActionPerformed
    }//GEN-LAST:event_previewBASIC8ActionPerformed

    private void bClose9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClose9ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bClose9ActionPerformed

    private void tblTotalStockIssuedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTotalStockIssuedMouseClicked
    }//GEN-LAST:event_tblTotalStockIssuedMouseClicked

    private void refreshTotalStockIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTotalStockIssuedActionPerformed
    }//GEN-LAST:event_refreshTotalStockIssuedActionPerformed

    private void bPDFEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFEquipmentActionPerformed
        if (tblEquipDay1.getDate() == null || tblEquipDay2.getDate() == null || txtEquipmentNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String equipment_no = txtEquipmentNo.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblEquipDay1.getDate();
                sdf.format(d1);
                Date d2 = tblEquipDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_equipment.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("equipment_no", equipment_no);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "Stock Reports\\" + "Stock_Issued_Equipment_( " + d + " )" + ".pdf";
                JasperExportManager.exportReportToPdfFile(jasperPrint, path);
                JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder");

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }//GEN-LAST:event_bPDFEquipmentActionPerformed

    private void printEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printEquipmentActionPerformed
        if (tblEquipDay1.getDate() == null || tblEquipDay2.getDate() == null || txtEquipmentNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String equipment_no = txtEquipmentNo.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblEquipDay1.getDate();
                sdf.format(d1);
                Date d2 = tblEquipDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_equipment.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("equipment_no", equipment_no);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperPrintManager.printReport(jasperPrint, true);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }//GEN-LAST:event_printEquipmentActionPerformed

    private void previewEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewEquipmentActionPerformed
        if (tblEquipDay1.getDate() == null || tblEquipDay2.getDate() == null || txtEquipmentNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String equipment_no = txtEquipmentNo.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblEquipDay1.getDate();
                sdf.format(d1);
                Date d2 = tblEquipDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_equipment.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("equipment_no", equipment_no);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("Stock Issue Report [ " + equipment_no + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_previewEquipmentActionPerformed

    private void bCloseEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseEquipmentActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseEquipmentActionPerformed

    private void bLoadEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadEquipmentActionPerformed
        loadEquipment();
    }//GEN-LAST:event_bLoadEquipmentActionPerformed

    private void tblExpAccntLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExpAccntLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblExpAccntLoad.getModel();
        int i = tblExpAccntLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtExpAccntCode.setText(s1);
        txtExpAccntDes.setText(s2);
        txtExpAccntCode.grabFocus();
        try {
            String SID = (String) txtExpAccntCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code = '" + SID + "'");
            while (rs.next()) {
                txtExpAccntDes.setText(rs.getString("description"));
            }
            tblExpAccntLoad.setVisible(false);
            tblExpAccntLoadPane.setVisible(false);


        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
        //load2();
    }//GEN-LAST:event_tblExpAccntLoadMouseClicked

    private void tblExpAccntLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblExpAccntLoadFocusLost
        tblExpAccntLoad.setVisible(false);
        tblExpAccntLoadPane.setVisible(false);
    }//GEN-LAST:event_tblExpAccntLoadFocusLost

    private void txtExpAccntCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExpAccntCodeMouseClicked
        if (tblExpAccntLoad.isVisible()) {
            tblExpAccntLoad.setVisible(false);
            tblExpAccntLoadPane.setVisible(false);
        } else {
            tblExpAccntLoad.setVisible(true);
            tblExpAccntLoadPane.setVisible(true);
        }
    }//GEN-LAST:event_txtExpAccntCodeMouseClicked

    private void txtExpAccntCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpAccntCodeKeyReleased
        try {
            String Search = txtExpAccntCode.getText();
            String s2 = Search.toUpperCase();
            txtExpAccntCode.setText(s2);
            String text = "Expense";
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center "
                    + "WHERE type ='" + text + "' "
                    + "AND (account_code LIKE '" + Search + '%' + "' OR description LIKE '" + Search + '%' + "') ORDER BY account_code ASC");

            DefaultTableModel dtm = (DefaultTableModel) tblExpAccntLoad.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("account_code"));
                v.add(rs.getString("description"));
                dtm.addRow(v);


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtExpAccntCodeKeyReleased

    private void txtExpAccntCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpAccntCodeKeyTyped
        tblExpAccntLoad.setVisible(true);
        tblExpAccntLoadPane.setVisible(true);
    }//GEN-LAST:event_txtExpAccntCodeKeyTyped

    private void txtExpAccntCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpAccntCodeActionPerformed
        try {
            String SID = (String) txtExpAccntCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code='" + SID + "'");
            while (rs.next()) {
                txtExpAccntDes.setText(rs.getString("description"));


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtExpAccntCodeActionPerformed

    private void txtEquipmentNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEquipmentNoMouseClicked
        if (tblEquipLoad.isVisible()) {
            tblEquipLoad.setVisible(false);
            tblEquipLoadPane.setVisible(false);
        } else {
            tblEquipLoad.setVisible(true);
            tblEquipLoadPane.setVisible(true);
        }
    }//GEN-LAST:event_txtEquipmentNoMouseClicked

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
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_txtEquipmentNoKeyReleased

    private void txtEquipmentNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquipmentNoKeyTyped
        tblEquipLoad.setVisible(true);
        jScrollPane6.setVisible(true);
    }//GEN-LAST:event_txtEquipmentNoKeyTyped

    private void tblEquipLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblEquipLoad.getModel();
        int i = tblEquipLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtEquipmentNo.setText(s1);
        txtEquipmentClass.setText(s2);
        try {
            String SID = (String) txtEquipmentNo.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no  = '" + SID + "'");
            while (rs.next()) {
                txtEquipmentClass.setText(rs.getString("class_vehicle"));
                tblEquipLoad.setVisible(false);
                tblEquipLoadPane.setVisible(false);
                txtEquipmentNo.grabFocus();


            }

        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
        loadEquipment();
    }//GEN-LAST:event_tblEquipLoadMouseClicked

    private void tblEquipLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblEquipLoadFocusLost
        tblEquipLoad.setVisible(false);
        tblEquipLoadPane.setVisible(false);
    }//GEN-LAST:event_tblEquipLoadFocusLost

    private void txtEquipmentNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentNoActionPerformed
        try {
            String SID = (String) txtEquipmentNo.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no  = '" + SID + "'");
            while (rs.next()) {
                txtEquipmentClass.setText(rs.getString("class_vehicle"));


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
        loadEquipment();
    }//GEN-LAST:event_txtEquipmentNoActionPerformed

    private void txtStockCodeIssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockCodeIssueMouseClicked
        if (tblStockLoadIssue.isVisible()) {
            tblStockLoadInVisible();
        } else {
            tblStockLoadVisible();
        }
    }//GEN-LAST:event_txtStockCodeIssueMouseClicked

    private void txtStockCodeIssueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeIssueKeyReleased

        try {
            String Search = txtStockCode.getText();
            String s2 = Search.toUpperCase();
            txtStockCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details "
                    + "WHERE stock_code LIKE '" + Search + '%' + "' "
                    + "OR description LIKE '" + Search + '%' + "' "
                    + "ORDER BY stock_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblStockLoadIssue.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("description"));
                dtm.addRow(v);


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtStockCodeIssueKeyReleased

    private void txtStockCodeIssueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeIssueKeyTyped
        tblStockLoadVisible();
    }//GEN-LAST:event_txtStockCodeIssueKeyTyped

    private void tblStockLoadIssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockLoadIssueMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblStockLoadIssue.getModel();
        int i = tblStockLoadIssue.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtStockCodeIssue.setText(s1);
        txtStockCodeIssueDesc.setText(s2);
        tblStockLoadInVisible();
        txtStockCodeIssue.grabFocus();
        loadStockCodeIssue();
    }//GEN-LAST:event_tblStockLoadIssueMouseClicked

    private void tblStockLoadIssueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblStockLoadIssueFocusLost
        tblStockLoadInVisible();
    }//GEN-LAST:event_tblStockLoadIssueFocusLost

    private void txtStockCodeIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockCodeIssueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockCodeIssueActionPerformed

    private void tblAstAccntLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAstAccntLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblAstAccntLoad.getModel();
        int i = tblAstAccntLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtAstAccntCode.setText(s1);
        txtAstAccntDes.setText(s2);
        txtAstAccntCode.grabFocus();
        try {
            String SID = (String) txtAstAccntCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code = '" + SID + "'");
            while (rs.next()) {
                txtAstAccntDes.setText(rs.getString("description"));
            }
            tblAstAccntLoad.setVisible(false);
            tblAstAccntLoadPane.setVisible(false);


        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
        //   load3();
    }//GEN-LAST:event_tblAstAccntLoadMouseClicked

    private void tblAstAccntLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblAstAccntLoadFocusLost
        if (tblAstAccntLoad.isVisible()) {
            tblAstAccntLoad.setVisible(false);
            tblAstAccntLoadPane.setVisible(false);
        } else {
            tblAstAccntLoad.setVisible(true);
            tblAstAccntLoadPane.setVisible(true);
        }
    }//GEN-LAST:event_tblAstAccntLoadFocusLost

    private void bPDFAstAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFAstAccntActionPerformed
        if (tblAstDay1.getDate() == null || tblAstDay2.getDate() == null || txtAstAccntCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String account_code = txtAstAccntCode.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblAstDay1.getDate();
                sdf.format(d1);
                Date d2 = tblAstDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_stock_account.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("account_code", account_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "Stock Reports\\" + "Stock_Issued_AssetCode_( " + d + " )" + ".pdf";
                JasperExportManager.exportReportToPdfFile(jasperPrint, path);
                JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }//GEN-LAST:event_bPDFAstAccntActionPerformed

    private void printAstAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printAstAccntActionPerformed
        if (tblAstDay1.getDate() == null || tblAstDay2.getDate() == null || txtAstAccntCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String account_code = txtAstAccntCode.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblAstDay1.getDate();
                sdf.format(d1);
                Date d2 = tblAstDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_stock_account.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("account_code", account_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperPrintManager.printReport(jasperPrint, true);

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }//GEN-LAST:event_printAstAccntActionPerformed

    private void previewAstAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewAstAccntActionPerformed
        if (tblAstDay1.getDate() == null || tblAstDay2.getDate() == null || txtAstAccntCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String account_code = txtAstAccntCode.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = tblAstDay1.getDate();
                sdf.format(d1);
                Date d2 = tblAstDay2.getDate();
                sdf.format(d2);
                String reportSource = settings.filepath + "stock_issue_stock_account.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("account_code", account_code);
                params.put("day1", d1);
                params.put("day2", d2);
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("Stock Issue Report [ " + account_code + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_previewAstAccntActionPerformed

    private void bCloseAstAccntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseAstAccntActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseAstAccntActionPerformed

    private void bLoadAccount3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadAccount3ActionPerformed
//        load3();
    }//GEN-LAST:event_bLoadAccount3ActionPerformed

    private void txtAstAccntCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAstAccntCodeMouseClicked
        if (tblAstAccntLoad.isVisible()) {
            tblAstAccntLoad.setVisible(false);
            tblAstAccntLoadPane.setVisible(false);
        } else {
            tblAstAccntLoad.setVisible(true);
            tblAstAccntLoadPane.setVisible(true);
        }
    }//GEN-LAST:event_txtAstAccntCodeMouseClicked

    private void txtAstAccntCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAstAccntCodeActionPerformed
        try {
            String SID = (String) txtAstAccntCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code='" + SID + "'");
            while (rs.next()) {
                txtAstAccntDes.setText(rs.getString("description"));


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtAstAccntCodeActionPerformed

    private void txtAstAccntCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAstAccntCodeKeyReleased
        try {
            String Search = txtAstAccntCode.getText();
            String s2 = Search.toUpperCase();
            txtAstAccntCode.setText(s2);
            String text = "Asset";
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center "
                    + "WHERE type ='" + text + "' "
                    + "AND (account_code LIKE '" + Search + '%' + "' OR description LIKE '" + Search + '%' + "') ORDER BY account_code ASC");

            DefaultTableModel dtm = (DefaultTableModel) tblAstAccntLoad.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("account_code"));
                v.add(rs.getString("description"));
                dtm.addRow(v);


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtAstAccntCodeKeyReleased

    private void txtAstAccntCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAstAccntCodeKeyTyped
        tblAstAccntLoad.setVisible(true);
        tblAstAccntLoadPane.setVisible(true);
    }//GEN-LAST:event_txtAstAccntCodeKeyTyped

    private void jPanel8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseMoved
       scm.utils.HideLoadTable.OneTable(tblExpAccntLoad, tblExpAccntLoadPane);
    }//GEN-LAST:event_jPanel8MouseMoved

    private void jPanel12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseMoved
        scm.utils.HideLoadTable.OneTable(tblAstAccntLoad, tblAstAccntLoadPane);
    }//GEN-LAST:event_jPanel12MouseMoved

    private void jPanel11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseMoved
        scm.utils.HideLoadTable.OneTable(tblEquipLoad, tblEquipLoadPane);
    }//GEN-LAST:event_jPanel11MouseMoved

    private void jPanel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseMoved
        scm.utils.HideLoadTable.OneTable(tblStockLoadIssue, tblStockLoadIssuePane);
    }//GEN-LAST:event_jPanel9MouseMoved

    private void jScrollPane7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane7MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose1;
    private javax.swing.JButton bClose2;
    private javax.swing.JButton bClose3;
    private javax.swing.JButton bClose8;
    private javax.swing.JButton bClose9;
    private javax.swing.JButton bCloseAstAccnt;
    private javax.swing.JButton bCloseEquipment;
    private javax.swing.JButton bCloseExpAccnt;
    private javax.swing.JButton bLoadAccount;
    private javax.swing.JButton bLoadAccount2;
    private javax.swing.JButton bLoadAccount3;
    private javax.swing.JButton bLoadEquipment;
    private javax.swing.JButton bLoadStock;
    private javax.swing.JButton bLoadStock2;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPDF1;
    private javax.swing.JButton bPDF2;
    private javax.swing.JButton bPDF6ExpAccnt;
    private javax.swing.JButton bPDF7;
    private javax.swing.JButton bPDF8;
    private javax.swing.JButton bPDFAstAccnt;
    private javax.swing.JButton bPDFEquipment;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane11;
    private javax.swing.JLayeredPane jLayeredPane13;
    private javax.swing.JLayeredPane jLayeredPane16;
    private javax.swing.JLayeredPane jLayeredPane17;
    private javax.swing.JLayeredPane jLayeredPane18;
    private javax.swing.JLayeredPane jLayeredPane19;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane20;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator21;
    private javax.swing.JToolBar.Separator jSeparator22;
    private javax.swing.JToolBar.Separator jSeparator23;
    private javax.swing.JToolBar.Separator jSeparator24;
    private javax.swing.JToolBar.Separator jSeparator25;
    private javax.swing.JToolBar.Separator jSeparator26;
    private javax.swing.JToolBar.Separator jSeparator27;
    private javax.swing.JToolBar.Separator jSeparator28;
    private javax.swing.JToolBar.Separator jSeparator29;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator30;
    private javax.swing.JToolBar.Separator jSeparator31;
    private javax.swing.JToolBar.Separator jSeparator32;
    private javax.swing.JToolBar.Separator jSeparator33;
    private javax.swing.JToolBar.Separator jSeparator34;
    private javax.swing.JToolBar.Separator jSeparator35;
    private javax.swing.JToolBar.Separator jSeparator36;
    private javax.swing.JToolBar.Separator jSeparator37;
    private javax.swing.JToolBar.Separator jSeparator38;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator43;
    private javax.swing.JToolBar.Separator jSeparator44;
    private javax.swing.JToolBar.Separator jSeparator46;
    private javax.swing.JToolBar.Separator jSeparator47;
    private javax.swing.JToolBar.Separator jSeparator48;
    private javax.swing.JToolBar.Separator jSeparator49;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator50;
    private javax.swing.JToolBar.Separator jSeparator52;
    private javax.swing.JToolBar.Separator jSeparator53;
    private javax.swing.JToolBar.Separator jSeparator54;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar10;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JToolBar jToolBar9;
    private javax.swing.JList listAccount;
    private javax.swing.JList listStock;
    private javax.swing.JButton previewAstAccnt;
    private javax.swing.JButton previewBASIC;
    private javax.swing.JButton previewBASIC1;
    private javax.swing.JButton previewBASIC2;
    private javax.swing.JButton previewBASIC7;
    private javax.swing.JButton previewBASIC8;
    private javax.swing.JButton previewEquipment;
    private javax.swing.JButton previewExpAccnt;
    private javax.swing.JButton printAstAccnt;
    private javax.swing.JButton printBASIC;
    private javax.swing.JButton printBASIC1;
    private javax.swing.JButton printBASIC2;
    private javax.swing.JButton printBASIC7;
    private javax.swing.JButton printBASIC8;
    private javax.swing.JButton printEquipment;
    private javax.swing.JButton printExpAccnt;
    private javax.swing.JButton refreshTotalStockIssued;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTable tblAstAccntLoad;
    private javax.swing.JScrollPane tblAstAccntLoadPane;
    private com.toedter.calendar.JDateChooser tblAstDay1;
    private com.toedter.calendar.JDateChooser tblAstDay2;
    private com.toedter.calendar.JDateChooser tblEquipDay1;
    private com.toedter.calendar.JDateChooser tblEquipDay2;
    private javax.swing.JTable tblEquipLoad;
    private javax.swing.JScrollPane tblEquipLoadPane;
    private javax.swing.JTable tblExpAccntLoad;
    private javax.swing.JScrollPane tblExpAccntLoadPane;
    private com.toedter.calendar.JDateChooser tblExpDay1;
    private com.toedter.calendar.JDateChooser tblExpDay2;
    private com.toedter.calendar.JDateChooser tblStockDay1;
    private com.toedter.calendar.JDateChooser tblStockDay2;
    private javax.swing.JTable tblStockLoadIssue;
    private javax.swing.JScrollPane tblStockLoadIssuePane;
    private javax.swing.JTable tblStock_List;
    private javax.swing.JTable tblTotalStockIssued;
    private javax.swing.JTable tblequipment;
    private javax.swing.JTextField txtAccountCode;
    private javax.swing.JTextField txtAccountDescription;
    public static javax.swing.JTextField txtAstAccntCode;
    private javax.swing.JTextField txtAstAccntDes;
    private javax.swing.JTextField txtEquipmentClass;
    private javax.swing.JTextField txtEquipmentNo;
    public static javax.swing.JTextField txtExpAccntCode;
    private javax.swing.JTextField txtExpAccntDes;
    private javax.swing.JTextField txtStockCode;
    public static javax.swing.JTextField txtStockCodeIssue;
    private javax.swing.JTextField txtStockCodeIssueDesc;
    private javax.swing.JTextField txtStockDescription;
    private javax.swing.JTextField txtStockPrice;
    private javax.swing.JTextField txtStockQty;
    private javax.swing.JTextField txtTotalAccount;
    private javax.swing.JTextField txtTotalIssue;
    private javax.swing.JTextField txtTotalStock;
    private javax.swing.JTextField txtTotalValutation;
    // End of variables declaration//GEN-END:variables

    void load() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tblAccount.getModel();
            String account_code = (String) txtAccountCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE account_code = '" + account_code + "' AND qoh > 0 ORDER BY stock_code ASC");
            dtm.setRowCount(0);
            while (rs.next()) {
                BigDecimal d1 = new BigDecimal(rs.getString("qoh"));
                BigDecimal d2 = new BigDecimal(rs.getString("unit_price"));
                d2 = d2.setScale(2, BigDecimal.ROUND_DOWN);
                BigDecimal value = d1.multiply(d2);
                value = value.setScale(2, BigDecimal.ROUND_DOWN);
                String subtotal = String.valueOf(value);
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("description"));
                v.add(rs.getString("partno_size"));
                v.add(rs.getString("qoh"));
                v.add(rs.getString("unit_price"));
                v.add(subtotal);
                dtm.addRow(v);
            }
            BigDecimal d3 = new BigDecimal("0");
            int x = dtm.getRowCount();
            for (int i2 = 0; i2 < x; i2++) {
                String s1 = dtm.getValueAt(i2, 5).toString();
                BigDecimal d4 = new BigDecimal(s1);
                d3 = d3.add(d4).setScale(2, BigDecimal.ROUND_DOWN);
                txtTotalAccount.setText("" + d3);


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, " ERROR " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void totalVal() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE qoh > 0 ORDER BY stock_code ASC ");
            DefaultTableModel dtm = (DefaultTableModel) tblStock_List.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                BigDecimal d1 = new BigDecimal(rs.getString("qoh"));
                BigDecimal d2 = new BigDecimal(rs.getString("unit_price"));
                d2 = d2.setScale(2, BigDecimal.ROUND_DOWN);
                BigDecimal value = d1.multiply(d2);
                value = value.setScale(2, BigDecimal.ROUND_DOWN);
                String subtotal = String.valueOf(value);
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("description"));
                v.add(rs.getString("partno_size"));
                v.add(rs.getBigDecimal("unit_price"));
                v.add(rs.getLong("qoh"));
                v.add(subtotal);
                dtm.addRow(v);
            }

            BigDecimal d3 = new BigDecimal("0");
            int x = dtm.getRowCount();
            for (int i2 = 0; i2 < x; i2++) {
                String s1 = dtm.getValueAt(i2, 5).toString();
                BigDecimal d4 = new BigDecimal(s1);
                d3 = d3.add(d4).setScale(2, BigDecimal.ROUND_DOWN);
                txtTotalValutation.setText("" + d3);


            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void load2() {
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String valDate = ((JTextField) tblExpDay1.getDateEditor().getUiComponent()).getText();
            String day11 = null;
            if (!valDate.isEmpty()) {
                day11 = date.format(tblExpDay1.getDate());
            }
            String valDate1 = ((JTextField) tblExpDay2.getDateEditor().getUiComponent()).getText();
            String day22 = null;
            if (!valDate1.isEmpty()) {
                day22 = date.format(tblExpDay2.getDate());
            }
            if (valDate.isEmpty() && valDate1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please define the date range !", "Date range missing !", JOptionPane.ERROR_MESSAGE);
            } else {
                String account_code = (String) txtExpAccntCode.getText();
                BigDecimal returnTotal = new BigDecimal("0");
                BigDecimal issueTotal = new BigDecimal("0");
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT SUM(total) FROM issue WHERE account_code = '" + account_code + "' "
                        + "AND issue_date BETWEEN '" + day11 + "' AND '" + day22 + "' ORDER BY account_code ASC");
                ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT SUM(total) FROM issue_direct_return WHERE account_code = '" + account_code + "' "
                        + "AND issue_date BETWEEN '" + day11 + "' AND '" + day22 + "' ORDER BY account_code ASC");
                while (rs2.next()) {
                    BigDecimal rt = new BigDecimal(rs2.getInt(1));
                    returnTotal = returnTotal.add(rt);
                }
                //DefaultTableModel dtm = (DefaultTableModel) tblAccount2.getModel();
                //  dtm.setRowCount(0);
                while (rs.next()) {
                    BigDecimal it = new BigDecimal(rs.getInt(1));
                    issueTotal = issueTotal.add(it);
//                    Vector v = new Vector();
//                    v.add(rs.getString("total"));
//                    dtm.addRow(v);


                }
//                if (dtm.getRowCount() != 0) {
//                    BigDecimal d3 = new BigDecimal("0");
//                    int x = dtm.getRowCount();
//                    for (int i2 = 0; i2 < x; i2++) {
//                        String s1 = dtm.getValueAt(i2, 0).toString();
//                        BigDecimal d4 = new BigDecimal(s1);
//                        d3 = d3.add(d4).setScale(2, BigDecimal.ROUND_DOWN);
/////////                txtExpAccntTotal.setText("" + issueTotal.subtract(returnTotal));
//                    }
//                }
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, " ERROR " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadEquipment() {
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String valDate = ((JTextField) tblEquipDay1.getDateEditor().getUiComponent()).getText();
            String day11 = null;
            if (!valDate.isEmpty()) {
                day11 = date.format(tblEquipDay1.getDate());
            }
            String valDate1 = ((JTextField) tblEquipDay2.getDateEditor().getUiComponent()).getText();
            String day22 = null;
            if (!valDate1.isEmpty()) {
                day22 = date.format(tblEquipDay2.getDate());
            }
            if (valDate.isEmpty() && valDate1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please define the date range !", "Date range missing !", JOptionPane.ERROR_MESSAGE);
            } else {
                String equipment_no = (String) txtEquipmentNo.getText();
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM issue WHERE equipment_no = '" + equipment_no + "' "
                        + "AND issue_date BETWEEN '" + day11 + "' AND '" + day22 + "' ORDER BY equipment_no ASC");
                DefaultTableModel dtm = (DefaultTableModel) tblequipment.getModel();
                dtm.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getString("total"));
                    dtm.addRow(v);
                }
                if (dtm.getRowCount() != 0) {
                    BigDecimal d3 = new BigDecimal("0");
                    int x = dtm.getRowCount();
                    for (int i2 = 0; i2 < x; i2++) {
                        String s1 = dtm.getValueAt(i2, 0).toString();
                        BigDecimal d4 = new BigDecimal(s1);
                        d3 = d3.add(d4).setScale(2, BigDecimal.ROUND_DOWN);
                        /// txtTotalEquipment.setText("" + d3);


                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, " ERROR " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tblStockLoadVisible() {
        tblStockLoadIssue.setVisible(true);
        tblStockLoadIssuePane.setVisible(true);
    }

    private void tblStockLoadInVisible() {

        tblStockLoadIssue.setVisible(false);
        tblStockLoadIssuePane.setVisible(false);
    }

    private void loadStockCodeIssue() {
        try {
            String SID = (String) txtStockCodeIssue.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM issue_details WHERE stock_code  = '" + SID + "'");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("sub_total"));
                v.add(rs.getString("quantity"));
                dtm.addRow(v);
            }
            BigDecimal zero = new BigDecimal("0");
            BigDecimal zero1 = new BigDecimal("0");
            int x = dtm.getRowCount();
            for (int i2 = 0; i2 < x; i2++) {
                String subtotal = dtm.getValueAt(i2, 0).toString();
                BigDecimal sub = new BigDecimal(subtotal);
                zero = zero.add(sub).setScale(2, BigDecimal.ROUND_DOWN);
                String totQty = dtm.getValueAt(i2, 1).toString();
                BigDecimal qty = new BigDecimal(totQty);
                zero1 = zero1.add(qty).setScale(2, BigDecimal.ROUND_DOWN);
            }
            ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT * FROM issue_return WHERE stock_code  = '" + SID + "'");
            DefaultTableModel dtm1 = (DefaultTableModel) jTable2.getModel();
            dtm1.setRowCount(0);
            while (rs4.next()) {
                Vector v = new Vector();
                v.add(rs4.getString("sub_total"));
                v.add(rs4.getString("quantity"));
                dtm1.addRow(v);
            }
            BigDecimal zero2 = new BigDecimal("0");
            BigDecimal zero21 = new BigDecimal("0");
            int xx = dtm1.getRowCount();
            for (int i2 = 0; i2 < xx; i2++) {
                String subtotal = dtm1.getValueAt(i2, 0).toString();
                BigDecimal sub = new BigDecimal(subtotal);
                zero2 = zero2.add(sub).setScale(2, BigDecimal.ROUND_DOWN);
                String totQty = dtm1.getValueAt(i2, 1).toString();
                BigDecimal qty = new BigDecimal(totQty);
                zero21 = zero21.add(qty).setScale(2, BigDecimal.ROUND_DOWN);
            }
            BigDecimal finalqty = zero1.subtract(zero21);
            BigDecimal finalsub = zero.subtract(zero2);
            //     txtStockQtyIssue.setText(String.valueOf(finalqty));
            //    txtTotalStockIssue.setText(String.valueOf(finalsub));


        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void load3() {
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String valDate = ((JTextField) tblAstDay1.getDateEditor().getUiComponent()).getText();
            String day11 = null;
            if (!valDate.isEmpty()) {
                day11 = date.format(tblAstDay1.getDate());
            }
            String valDate1 = ((JTextField) tblAstDay2.getDateEditor().getUiComponent()).getText();
            String day22 = null;
            if (!valDate1.isEmpty()) {
                day22 = date.format(tblAstDay2.getDate());
            }
            if (valDate.isEmpty() && valDate1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please define the date range !", "Date range missing !", JOptionPane.ERROR_MESSAGE);
            } else {
                String account_code = (String) txtAstAccntCode.getText();
                BigDecimal returnTotal = new BigDecimal("0");
                BigDecimal issueTotal = new BigDecimal("0");
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT SUM(total) FROM issue WHERE account_code = '" + account_code + "' "
                        + "AND issue_date BETWEEN '" + day11 + "' AND '" + day22 + "' ORDER BY account_code ASC");
                ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT SUM(total) FROM issue_direct_return WHERE account_code = '" + account_code + "' "
                        + "AND issue_date BETWEEN '" + day11 + "' AND '" + day22 + "' ORDER BY account_code ASC");
                while (rs2.next()) {
                    BigDecimal rt = new BigDecimal(rs2.getInt(1));
                    returnTotal = returnTotal.add(rt);
                }
                while (rs.next()) {
                    BigDecimal it = new BigDecimal(rs.getInt(1));
                    issueTotal = issueTotal.add(it);


                }
                //      txtAstAccntTotal.setText("" + issueTotal.subtract(returnTotal));
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_valuation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, " ERROR " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
