package scm.stock;

import scm.utils.Editable;
import scm.database.DBControl;
import scm.utils.LabelColor;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scm.*;

public class stock_details extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    /**
     * Creates new form new_stock
     */
    public stock_details() {
        initComponents();
        try {
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.CENTER);
            //  tblStockLoad.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            tblGRN.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            tblGRN.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            tblGRN.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            tblGRNReturn.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            tblGRNReturn.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            tblGRNReturn.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            tblIssue.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            tblIssue.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            tblIssue.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            tblIssueReturn.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            tblIssueReturn.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            tblIssueReturn.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(6).setCellRenderer(dtcr);
            // For the drop down effect of stock codes instead of using the combo box
            tblStockLoadInVisible();
            tblAccountLoadInVisible();
///////////////////Loading category////////////////////////////////////////
            ResultSet rs6 = DBControl.getResultFromLocalDB("SELECT category FROM new_stock_category ORDER BY category");
            Vector v6 = new Vector();
            v6.add("");
            while (rs6.next()) {
                v6.add(rs6.getString("category"));
            }
            txtType.setModel(new DefaultComboBoxModel(v6));
///////////////////////// Loading Plant//////////////////////////
            ResultSet rs7 = DBControl.getResultFromLocalDB("SELECT plant FROM new_stock_plant ORDER BY plant");
            Vector v7 = new Vector();
            v7.add("");
            while (rs7.next()) {
                v7.add(rs7.getString("plant"));
            }
            txtPlant.setModel(new DefaultComboBoxModel(v7));
///////////////////Loading UOM////////////////////////////////////////
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT uom FROM new_uom");
            Vector v2 = new Vector();
            v2.add("");
            while (rs1.next()) {
                v2.add(rs1.getString("uom"));
            }
            comboUOM.setModel(new DefaultComboBoxModel(v2));
////////////////////Loading Stock codes///////////////////////////////
            loadStockTable();
////////////////////Loading account codes/////////////////////////////
            loadAccountTable();
////////////////////////////////////////////////////////////            
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bUpdate = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblStockLoad = new javax.swing.JTable();
        lblUOM = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBinLocation = new javax.swing.JTextField();
        txtPartNoSize = new javax.swing.JTextField();
        txtStockType = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblAccountLoad = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        comboUOM = new javax.swing.JComboBox();
        lblUnitPrice = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        lblQoh = new javax.swing.JLabel();
        txtQOH = new javax.swing.JTextField();
        rbStock = new javax.swing.JRadioButton();
        rbNonStock = new javax.swing.JRadioButton();
        txtStockCode = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        clearStockCode = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGRN = new javax.swing.JTable();
        bPreview = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        Day1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        Day2 = new com.toedter.calendar.JDateChooser();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGRNReturn = new javax.swing.JTable();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIssue = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblIssueReturn = new javax.swing.JTable();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPO = new javax.swing.JTable();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        txtAccountCode = new javax.swing.JTextField();
        clearAccountCode = new javax.swing.JButton();
        txtType = new javax.swing.JComboBox();
        txtAcntDescription = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblCategory1 = new javax.swing.JLabel();
        txtPlant = new javax.swing.JComboBox();

        setResizable(true);
        setTitle("Stock Details");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Stock.png"))); // NOI18N
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
        jToolBar1.add(jSeparator1);

        bUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        bUpdate.setText("Update");
        bUpdate.setFocusable(false);
        bUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bUpdate.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bUpdateMouseEntered(evt);
            }
        });
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });
        jToolBar1.add(bUpdate);
        jToolBar1.add(jSeparator2);

        bDelete.setForeground(new java.awt.Color(204, 0, 0));
        bDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDelete.setText("Delete");
        bDelete.setFocusable(false);
        bDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bDelete.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(bDelete);
        jToolBar1.add(jSeparator3);

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Stock Details");
        jLabel13.setIconTextGap(10);
        jLabel13.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar1.add(jLabel13);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jScrollPane4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblStockLoad.setBackground(new java.awt.Color(240, 240, 240));
        tblStockLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblStockLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Description", "PartNo Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

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
        jScrollPane4.setViewportView(tblStockLoad);
        tblStockLoad.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblStockLoad.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblStockLoad.getColumnModel().getColumn(2).setPreferredWidth(100);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, 500, 260));

        lblUOM.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblUOM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUOM.setText("UOM");
        lblUOM.setToolTipText("Add new Unit of Measure");
        lblUOM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblUOM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUOM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUOMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUOMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUOMMouseExited(evt);
            }
        });
        getContentPane().add(lblUOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 50, 25));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Stock Code");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 25));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Stock Type");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 80, 25));

        lblCategory.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory.setText("Category");
        lblCategory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCategoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCategoryMouseExited(evt);
            }
        });
        getContentPane().add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 90, 25));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Part No/Size");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 25));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Description");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 40));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Bin Location");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 100, 25));

        txtBinLocation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtBinLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 200, 25));

        txtPartNoSize.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtPartNoSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 190, 25));

        txtStockType.setEditable(false);
        txtStockType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtStockType, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 90, 25));

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

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 225, 360, 240));

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(txtDescription);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 560, 40));

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Account Code");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 25));

        comboUOM.setEditable(true);
        comboUOM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(comboUOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 100, 25));

        lblUnitPrice.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblUnitPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUnitPrice.setText("Unit Price");
        lblUnitPrice.setToolTipText("Click here to edit Unit Price");
        lblUnitPrice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblUnitPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUnitPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUnitPriceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUnitPriceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUnitPriceMouseExited(evt);
            }
        });
        getContentPane().add(lblUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 80, 25));

        txtUnitPrice.setEditable(false);
        txtUnitPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 160, 25));

        lblQoh.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblQoh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQoh.setText("QOH");
        lblQoh.setToolTipText("Click here to edit QOH");
        lblQoh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblQoh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQoh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQohMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQohMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQohMouseExited(evt);
            }
        });
        getContentPane().add(lblQoh, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 50, 25));

        txtQOH.setEditable(false);
        txtQOH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtQOH, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 120, 25));

        buttonGroup1.add(rbStock);
        rbStock.setText("Stock");
        rbStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStockActionPerformed(evt);
            }
        });
        getContentPane().add(rbStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, -1, 25));

        buttonGroup1.add(rbNonStock);
        rbNonStock.setText("Non-Stock");
        rbNonStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNonStockActionPerformed(evt);
            }
        });
        getContentPane().add(rbNonStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, -1, 25));

        txtStockCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStockCodeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtStockCodeMouseEntered(evt);
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
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 190, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Rs.");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, -1, 20));

        clearStockCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        clearStockCode.setBorderPainted(false);
        clearStockCode.setContentAreaFilled(false);
        clearStockCode.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        clearStockCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStockCodeActionPerformed(evt);
            }
        });
        getContentPane().add(clearStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 20, 25));
        getContentPane().add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        jTabbedPane7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tblGRN.setAutoCreateRowSorter(true);
        tblGRN.setBackground(new java.awt.Color(245, 242, 242));
        tblGRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblGRN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN No", "GRN Date", "PO No", "Qty", "Unit Price", "SubTotal", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGRN.setRowHeight(20);
        tblGRN.getTableHeader().setReorderingAllowed(false);
        tblGRN.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(tblGRN);
        tblGRN.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblGRN.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblGRN.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblGRN.getColumnModel().getColumn(4).setPreferredWidth(70);
        tblGRN.getColumnModel().getColumn(5).setPreferredWidth(120);
        tblGRN.getColumnModel().getColumn(6).setPreferredWidth(70);

        jScrollPane3.setBounds(0, 0, 570, 210);
        jLayeredPane2.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        bPreview.setBounds(590, 130, 80, 70);
        jLayeredPane2.add(bPreview, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel48.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Date Range");
        jLabel48.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel48.setBounds(580, 10, 110, 23);
        jLayeredPane2.add(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Day1.setDateFormatString("dd/MM/yy");
        Day1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Day1.setBounds(580, 50, 110, 20);
        jLayeredPane2.add(Day1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("AND");
        jLabel12.setBounds(580, 80, 110, 15);
        jLayeredPane2.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Day2.setDateFormatString("dd/MM/yy");
        Day2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Day2.setBounds(580, 100, 110, 20);
        jLayeredPane2.add(Day2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane7.addTab("GRN Details", jLayeredPane2);

        tblGRNReturn.setAutoCreateRowSorter(true);
        tblGRNReturn.setBackground(new java.awt.Color(245, 242, 242));
        tblGRNReturn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblGRNReturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN No", "Return Date", "Qty", "Unit Price", "SubTotal", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
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
        tblGRNReturn.setRowHeight(20);
        tblGRNReturn.getTableHeader().setReorderingAllowed(false);
        tblGRNReturn.setVerifyInputWhenFocusTarget(false);
        jScrollPane5.setViewportView(tblGRNReturn);
        tblGRNReturn.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblGRNReturn.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblGRNReturn.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblGRNReturn.getColumnModel().getColumn(3).setPreferredWidth(70);
        tblGRNReturn.getColumnModel().getColumn(4).setPreferredWidth(120);
        tblGRNReturn.getColumnModel().getColumn(5).setPreferredWidth(50);

        jScrollPane5.setBounds(0, 0, 570, 210);
        jLayeredPane3.add(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane7.addTab("GRN Returns", jLayeredPane3);

        tblIssue.setAutoCreateRowSorter(true);
        tblIssue.setBackground(new java.awt.Color(245, 242, 242));
        tblIssue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblIssue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue Date", "Issue No", "Equipment No", "Account Code", "Qty", "Unit Price", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIssue.setEnabled(false);
        tblIssue.setRowHeight(20);
        tblIssue.getTableHeader().setReorderingAllowed(false);
        tblIssue.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tblIssue);
        tblIssue.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblIssue.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblIssue.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblIssue.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblIssue.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblIssue.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblIssue.getColumnModel().getColumn(6).setPreferredWidth(80);

        jScrollPane2.setBounds(0, 0, 570, 210);
        jLayeredPane4.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane7.addTab("Issue Details", jLayeredPane4);

        tblIssueReturn.setAutoCreateRowSorter(true);
        tblIssueReturn.setBackground(new java.awt.Color(245, 242, 242));
        tblIssueReturn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblIssueReturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue No", "Return Date", "Qty", "Unit Price", "SubTotal", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
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
        tblIssueReturn.setRowHeight(20);
        tblIssueReturn.getTableHeader().setReorderingAllowed(false);
        tblIssueReturn.setVerifyInputWhenFocusTarget(false);
        jScrollPane6.setViewportView(tblIssueReturn);
        tblIssueReturn.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblIssueReturn.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblIssueReturn.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblIssueReturn.getColumnModel().getColumn(3).setPreferredWidth(70);
        tblIssueReturn.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblIssueReturn.getColumnModel().getColumn(5).setPreferredWidth(50);

        jScrollPane6.setBounds(0, 0, 570, 210);
        jLayeredPane1.add(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane7.addTab("Issue Returns", jLayeredPane1);

        tblPO.setAutoCreateRowSorter(true);
        tblPO.setBackground(new java.awt.Color(245, 242, 242));
        tblPO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblPO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PO No", "PO Date", "Qty", "Unit Price", "Discount", "SubTotal", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPO.setEnabled(false);
        tblPO.setRowHeight(20);
        tblPO.getTableHeader().setReorderingAllowed(false);
        tblPO.setVerifyInputWhenFocusTarget(false);
        jScrollPane7.setViewportView(tblPO);
        tblPO.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblPO.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblPO.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblPO.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblPO.getColumnModel().getColumn(4).setPreferredWidth(40);
        tblPO.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblPO.getColumnModel().getColumn(6).setPreferredWidth(50);

        jScrollPane7.setBounds(0, 0, 570, 210);
        jLayeredPane5.add(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane7.addTab("Purchase Orders", jLayeredPane5);

        getContentPane().add(jTabbedPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 730, 240));
        getContentPane().add(jLayeredPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, -1));

        txtAccountCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAccountCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAccountCodeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAccountCodeMouseEntered(evt);
            }
        });
        txtAccountCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccountCodeFocusLost(evt);
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
        getContentPane().add(txtAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 190, 25));

        clearAccountCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        clearAccountCode.setBorderPainted(false);
        clearAccountCode.setContentAreaFilled(false);
        clearAccountCode.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        clearAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAccountCodeActionPerformed(evt);
            }
        });
        getContentPane().add(clearAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 20, 25));

        txtType.setEditable(true);
        txtType.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 250, 25));

        txtAcntDescription.setEditable(false);
        txtAcntDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtAcntDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 250, 25));

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Description");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 90, 25));

        lblCategory1.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblCategory1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory1.setText("Plant");
        lblCategory1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblCategory1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCategory1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCategory1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCategory1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCategory1MouseExited(evt);
            }
        });
        getContentPane().add(lblCategory1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 80, 25));

        txtPlant.setEditable(true);
        txtPlant.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtPlant, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 220, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            Main.ns.setVisible(true);
            this.setVisible(false);
        } else if (i == 1) {
            JOptionPane.showMessageDialog(null, "Please UPDATE the changes", "UPDATE", WIDTH, null);
        }

    }//GEN-LAST:event_bNewActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        deleteStock.deleteStock(txtStockCode);
        clear();
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        try {
            ResultSet rss = DBControl.getResultFromLocalDB("SELECT stock_code FROM stock_details WHERE stock_code='" + txtStockCode.getText() + "'");
            if (rss.next()) {
                if (txtStockCode.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a STOCK CODE", "Error", JOptionPane.ERROR_MESSAGE);
                    txtStockCode.grabFocus();
                } else if (txtDescription.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a STOCK DESCRIPTION", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDescription.grabFocus();
                } else if (txtAccountCode.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the ACCOUNT CODE", "Error", JOptionPane.ERROR_MESSAGE);
                    txtAccountCode.grabFocus();
                } else if (txtStockType.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a STOCK TYPE", "Error", JOptionPane.ERROR_MESSAGE);
                    txtStockCode.grabFocus();
                } else {
                    try {
                        String stock_code = (String) txtStockCode.getText();
                        String account_code = txtAccountCode.getText();
                        String stock_type = txtStockType.getText();
                        String description = txtDescription.getText();
                        String PartNoSize = txtPartNoSize.getText();
                        String UOM = comboUOM.getSelectedItem().toString();
                        String Type = txtType.getSelectedItem().toString();
                        String Plant = txtPlant.getSelectedItem().toString();
                        String BinLocation = txtBinLocation.getText();
                        String qoh = txtQOH.getText();
                        String unit_price = txtUnitPrice.getText();
                        db.setResult("UPDATE stock_details SET account_code='" + account_code + "', stock_type='" + stock_type + "',"
                                + " description ='" + description + "', partno_size ='" + PartNoSize + "', uom ='" + UOM + "',"
                                + " type ='" + Type + "',  plant = '" + Plant + "',bin_location ='" + BinLocation + "', unit_price ='" + unit_price + "', qoh ='" + qoh + "' "
                                + "WHERE stock_code='" + stock_code + "'");

                        JOptionPane.showMessageDialog(null, "Successfully Updated", title, WIDTH);
                    } catch (Exception ex) {
                        Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "\n" + ex, "Error! Stock failed to update !", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Stock code not found.", "Error! Stock failed to update !", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
        txtQOH.setEditable(false);
        txtUnitPrice.setEditable(false);
}//GEN-LAST:event_bCloseActionPerformed

    private void lblUOMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUOMMouseClicked
        Main.newuom.setVisible(true);
    }//GEN-LAST:event_lblUOMMouseClicked

    private void rbStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStockActionPerformed
        txtStockType.setText("Stock");
        txtBinLocation.setText("");
        txtBinLocation.setEnabled(true);
}//GEN-LAST:event_rbStockActionPerformed

    private void rbNonStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNonStockActionPerformed
        txtStockType.setText("Non-Stock");
        txtBinLocation.setText("Non-Stock");
        txtBinLocation.setEnabled(false);
}//GEN-LAST:event_rbNonStockActionPerformed

    private void txtStockCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyReleased
        try {
            String Search = txtStockCode.getText();
            String s2 = Search.toUpperCase();
            txtStockCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details "
                    + "WHERE stock_code LIKE '" + Search + '%' + "' "
                    + "OR description LIKE '" + Search + '%' + "' "
                    + "ORDER BY stock_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblStockLoad.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("description"));
                v.add(rs.getString("partno_size"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtStockCodeKeyReleased

private void txtStockCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyTyped
    tblStockLoadVisible();

}//GEN-LAST:event_txtStockCodeKeyTyped

    private void clearStockCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStockCodeActionPerformed
        clear();
        tblStockLoadInVisible();
    }//GEN-LAST:event_clearStockCodeActionPerformed

    private void tblStockLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblStockLoadFocusLost
        tblStockLoadInVisible();
    }//GEN-LAST:event_tblStockLoadFocusLost

    private void tblStockLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockLoadMouseClicked
        loadStockCodeDetails();
        tblStockLoadInVisible();
    }//GEN-LAST:event_tblStockLoadMouseClicked

    private void txtAccountCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAccountCodeFocusLost
    }//GEN-LAST:event_txtAccountCodeFocusLost

    private void txtAccountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyReleased
        try {
            String Search = txtAccountCode.getText();
            String s2 = Search.toUpperCase();
            txtAccountCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center "
                    + "WHERE account_code LIKE '" + Search + '%' + "'"
                    + "OR description LIKE '" + Search + '%' + "' "
                    + "ORDER BY account_code ASC");
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
        tblAccountLoadVisible();
    }//GEN-LAST:event_txtAccountCodeKeyTyped

    private void clearAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAccountCodeActionPerformed
        txtAccountCode.setText("");
        txtAcntDescription.setText("");
        tblAccountLoadInVisible();
    }//GEN-LAST:event_clearAccountCodeActionPerformed

    private void txtStockCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockCodeMouseClicked
        if (tblStockLoad.isVisible()) {
            tblStockLoadInVisible();
            loadStockTable();
        } else {
            tblStockLoadVisible();
        }
    }//GEN-LAST:event_txtStockCodeMouseClicked

    private void txtAccountCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccountCodeMouseClicked
        if (tblAccountLoad.isVisible()) {
            tblAccountLoadInVisible();
            loadAccountTable();
        } else {
            tblAccountLoadVisible();

        }
    }//GEN-LAST:event_txtAccountCodeMouseClicked

    private void bUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bUpdateMouseEntered
        if (!txtUnitPrice.isEditable() && !txtQOH.isEditable()) {
            updateQohPrice();
        }
    }//GEN-LAST:event_bUpdateMouseEntered

    private void lblQohMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQohMouseClicked
        Editable.Edit(txtQOH);
    }//GEN-LAST:event_lblQohMouseClicked

    private void lblUnitPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnitPriceMouseClicked
        Editable.Edit(txtUnitPrice);
    }//GEN-LAST:event_lblUnitPriceMouseClicked

    private void lblUnitPriceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnitPriceMouseEntered
        LabelColor.lblMouseEntered(evt, lblUnitPrice);
    }//GEN-LAST:event_lblUnitPriceMouseEntered

    private void lblUnitPriceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnitPriceMouseExited
        LabelColor.lblMouseExited(evt, lblUnitPrice);
    }//GEN-LAST:event_lblUnitPriceMouseExited

    private void lblQohMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQohMouseEntered
        LabelColor.lblMouseEntered(evt, lblQoh);
    }//GEN-LAST:event_lblQohMouseEntered

    private void lblQohMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQohMouseExited
        LabelColor.lblMouseExited(evt, lblQoh);
    }//GEN-LAST:event_lblQohMouseExited

    private void lblUOMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUOMMouseEntered
        LabelColor.lblMouseEntered(evt, lblUOM);
    }//GEN-LAST:event_lblUOMMouseEntered

    private void lblUOMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUOMMouseExited
        LabelColor.lblMouseExited(evt, lblUOM);
    }//GEN-LAST:event_lblUOMMouseExited

    private void txtStockCodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockCodeMouseEntered
        if (txtStockCode.getText().isEmpty()) {
            loadStockTable();
        }
    }//GEN-LAST:event_txtStockCodeMouseEntered

    private void txtAccountCodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccountCodeMouseEntered
        loadAccountTable();
    }//GEN-LAST:event_txtAccountCodeMouseEntered

    private void lblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoryMouseClicked
        Main.nsc.setVisible(true);
    }//GEN-LAST:event_lblCategoryMouseClicked

    private void lblCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoryMouseEntered
        LabelColor.lblMouseEntered(evt, lblCategory);
    }//GEN-LAST:event_lblCategoryMouseEntered

    private void lblCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoryMouseExited
        LabelColor.lblMouseExited(evt, lblCategory);
    }//GEN-LAST:event_lblCategoryMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        scm.utils.HideLoadTable.TwoTables(tblStockLoad, jScrollPane5, tblAccountLoad, jScrollPane8);
    }//GEN-LAST:event_formMouseClicked

    private void tblAccountLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblAccountLoad.getModel();
        int i = tblAccountLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtAccountCode.setText(s1);
        txtAcntDescription.setText(s2);
        txtAccountCode.grabFocus();
        tblAccountLoad.setVisible(false);
        jScrollPane8.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadMouseClicked

    private void tblAccountLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblAccountLoadFocusLost
        tblAccountLoad.setVisible(false);
        jScrollPane8.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadFocusLost

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        scm.utils.HideLoadTable.TwoTables(tblStockLoad, jScrollPane4, tblAccountLoad, jScrollPane8);
    }//GEN-LAST:event_formMouseMoved

    private void lblCategory1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategory1MouseClicked
        Main.nsc.setVisible(true);
    }//GEN-LAST:event_lblCategory1MouseClicked

    private void lblCategory1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategory1MouseEntered
        LabelColor.lblMouseEntered(evt, lblCategory);
    }//GEN-LAST:event_lblCategory1MouseEntered

    private void lblCategory1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategory1MouseExited
        LabelColor.lblMouseExited(evt, lblCategory);
    }//GEN-LAST:event_lblCategory1MouseExited

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
        if (Day1.getDate() == null || Day2.getDate() == null || txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter required data !", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(tblGRN.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "No Records found!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            stock.previewGRN(txtStockCode.getText(), Day1, Day2);
        }
    }//GEN-LAST:event_bPreviewActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Day1;
    private com.toedter.calendar.JDateChooser Day2;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearAccountCode;
    private javax.swing.JButton clearStockCode;
    public static javax.swing.JComboBox comboUOM;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategory1;
    private javax.swing.JLabel lblQoh;
    private javax.swing.JLabel lblUOM;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JRadioButton rbNonStock;
    private javax.swing.JRadioButton rbStock;
    private javax.swing.JTable tblAccountLoad;
    public static javax.swing.JTable tblGRN;
    public static javax.swing.JTable tblGRNReturn;
    public static javax.swing.JTable tblIssue;
    public static javax.swing.JTable tblIssueReturn;
    public static javax.swing.JTable tblPO;
    private javax.swing.JTable tblStockLoad;
    public static javax.swing.JTextField txtAccountCode;
    public static javax.swing.JTextField txtAcntDescription;
    public static javax.swing.JTextField txtBinLocation;
    public static javax.swing.JTextPane txtDescription;
    public static javax.swing.JTextField txtPartNoSize;
    public static javax.swing.JComboBox txtPlant;
    public static javax.swing.JTextField txtQOH;
    public static javax.swing.JTextField txtStockCode;
    public static javax.swing.JTextField txtStockType;
    public static javax.swing.JComboBox txtType;
    public static javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables

    void loadStockCodeDetails() {
        try {
            rbNonStock.setSelected(false);
            rbStock.setSelected(false);
            DefaultTableModel dtmm = (DefaultTableModel) tblStockLoad.getModel();
            int i = tblStockLoad.getSelectedRow();
            String s1 = dtmm.getValueAt(i, 0).toString();
            // String s1 = (String) jList1.getSelectedValue();
            txtStockCode.setText(s1);
            String stock_code = txtStockCode.getText();
            ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code = '" + stock_code + "'");
            while (rs2.next()) {
                txtStockCode.setText(rs2.getString("stock_code"));
                txtAccountCode.setText(rs2.getString("account_code"));
                ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code='" + txtAccountCode.getText() + "'");
                while (rs1.next()) {
                    txtAcntDescription.setText(rs1.getString("description"));
                }
                rs1.close();
                txtStockType.setText(rs2.getString("stock_type"));
                txtDescription.setText(rs2.getString("description"));
                txtPartNoSize.setText(rs2.getString("partno_size"));
                comboUOM.setSelectedItem(rs2.getString("uom"));
                txtType.setSelectedItem(rs2.getString("type"));
                txtPlant.setSelectedItem(rs2.getString("plant"));
                txtBinLocation.setText(rs2.getString("bin_location"));
                txtUnitPrice.setText(rs2.getString("unit_price"));
                txtQOH.setText(rs2.getString("qoh"));
            }
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM grn_details gd, grn g WHERE gd.stock_code = '" + stock_code + "' "
                    + "AND gd.grn_no = g.grn_no ORDER BY g.grn_date DESC ");
            DefaultTableModel dtm = (DefaultTableModel) tblGRN.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("g.grn_no"));
                v.add(rs.getString("g.grn_date"));
                v.add(rs.getString("g.po_no"));
                v.add(rs.getDouble("gd.quantity"));
                v.add(rs.getDouble("gd.unit_price"));
                v.add(rs.getDouble("gd.sub_total"));
                v.add(rs.getString("g.user"));
                dtm.addRow(v);
            }
            ResultSet rs3 = DBControl.getResultFromLocalDB("SELECT * FROM grn_return WHERE stock_code = '" + stock_code + "'ORDER BY grn_no DESC ");
            DefaultTableModel dtm2 = (DefaultTableModel) tblGRNReturn.getModel();
            dtm2.setRowCount(0);
            while (rs3.next()) {
                Vector v = new Vector();
                v.add(rs3.getInt("grn_no"));
                v.add(rs3.getString("time"));
                v.add(rs3.getDouble("quantity"));
                v.add(rs3.getDouble("unit_price"));
                v.add(rs3.getDouble("sub_total"));
                v.add(rs3.getString("user"));
                dtm2.addRow(v);
            }
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM issue_details id, issue i WHERE id.stock_code = '" + stock_code + "'"
                    + "AND id.issue_no = i.issue_no ORDER BY i.issue_date DESC ");
            DefaultTableModel dtm1 = (DefaultTableModel) tblIssue.getModel();
            dtm1.setRowCount(0);
            while (rs1.next()) {
                Vector v = new Vector();
                v.add(rs1.getString("i.issue_date"));
                v.add(rs1.getInt("i.issue_no"));
                v.add(rs1.getString("i.equipment_no"));
                v.add(rs1.getString("i.account_code"));
                v.add(rs1.getDouble("id.quantity"));
                v.add(rs1.getDouble("id.unit_price"));
                v.add(rs1.getDouble("id.sub_total"));
                v.add(rs1.getString("i.user"));
                dtm1.addRow(v);
            }
            ResultSet rs5 = DBControl.getResultFromLocalDB("SELECT * FROM issue_return WHERE stock_code = '" + stock_code + "'ORDER BY issue_no DESC ");
            DefaultTableModel dtm5 = (DefaultTableModel) tblIssueReturn.getModel();
            dtm5.setRowCount(0);
            while (rs5.next()) {
                Vector v = new Vector();
                v.add(rs5.getInt("issue_no"));
                v.add(rs5.getString("time"));
                v.add(rs5.getDouble("quantity"));
                v.add(rs5.getDouble("unit_price"));
                v.add(rs5.getDouble("sub_total"));
                v.add(rs5.getString("user"));
                dtm5.addRow(v);
            }

            ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT * FROM po_details pd, po p WHERE pd.stock_code = '" + stock_code + "'"
                    + "AND pd.po_no = p.po_no ORDER BY p.po_date DESC ");
            DefaultTableModel dtm3 = (DefaultTableModel) tblPO.getModel();
            dtm3.setRowCount(0);
            while (rs4.next()) {
                Vector v = new Vector();
                v.add(rs4.getInt("p.po_no"));
                v.add(rs4.getString("p.po_date"));
                v.add(rs4.getDouble("pd.quantity"));
                v.add(rs4.getDouble("pd.unit_price"));
                v.add(rs4.getBigDecimal("pd.discount"));
                v.add(rs4.getDouble("pd.sub_total"));
                v.add(rs4.getString("p.user"));
                dtm3.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR " + ex);
        }
    }

    public static void clear() {
        txtStockCode.setText("");
        txtAccountCode.setText("");
        txtAcntDescription.setText("");
        txtStockType.setText("");
        txtDescription.setText("");
        txtPartNoSize.setText("");
        txtUnitPrice.setText("");
        txtQOH.setText("");
        comboUOM.setSelectedItem("");
        txtType.setSelectedItem("");
        txtPlant.setSelectedItem("");
        txtBinLocation.setText("");
        DefaultTableModel dtm = (DefaultTableModel) tblIssue.getModel();
        DefaultTableModel dtm1 = (DefaultTableModel) tblGRN.getModel();
        DefaultTableModel dtm2 = (DefaultTableModel) tblGRNReturn.getModel();
        DefaultTableModel dtm3 = (DefaultTableModel) tblIssueReturn.getModel();
        DefaultTableModel dtm4 = (DefaultTableModel) tblPO.getModel();
        dtm.setRowCount(0);
        dtm1.setRowCount(0);
        dtm2.setRowCount(0);
        dtm3.setRowCount(0);
        dtm4.setRowCount(0);
    }

    private void updateQohPrice() {
        try {
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT qoh,unit_price FROM stock_details WHERE stock_code ='" + txtStockCode.getText() + "'");
            while (rs1.next()) {
                String qoh = rs1.getString("qoh");
                String unit_price = rs1.getString("unit_price");
                txtQOH.setText(qoh);
                txtUnitPrice.setText(unit_price);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tblStockLoadVisible() {
        tblStockLoad.setVisible(true);
        jScrollPane4.setVisible(true);
    }

    private void tblStockLoadInVisible() {

        tblStockLoad.setVisible(false);
        jScrollPane4.setVisible(false);
    }

    private void tblAccountLoadInVisible() {
        tblAccountLoad.setVisible(false);
        jScrollPane8.setVisible(false);
    }

    private void tblAccountLoadVisible() {
        tblAccountLoad.setVisible(true);
        jScrollPane8.setVisible(true);
    }

    public void loadStockTable() {
        try {
            ResultSet rs11 = DBControl.getResultFromLocalDB("SELECT * FROM stock_details ORDER by stock_code");
            DefaultTableModel dtm11 = (DefaultTableModel) tblStockLoad.getModel();
            dtm11.setRowCount(0);
            while (rs11.next()) {
                Vector v21 = new Vector();
                v21.add(rs11.getString("stock_code"));
                v21.add(rs11.getString("description"));
                v21.add(rs11.getString("partno_size"));
                dtm11.addRow(v21);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadAccountTable() {
        try {
            ResultSet rs111 = DBControl.getResultFromLocalDB("SELECT * FROM account_center ORDER by account_code");
            DefaultTableModel dtm111 = (DefaultTableModel) tblAccountLoad.getModel();
            dtm111.setRowCount(0);
            while (rs111.next()) {
                Vector v211 = new Vector();
                v211.add(rs111.getString("account_code"));
                v211.add(rs111.getString("description"));
                dtm111.addRow(v211);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
