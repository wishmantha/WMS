package scm.purchaseOrder;

import java.awt.Color;
import scm.stock.stock_details;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;
import scm.Main;

public final class edit_po extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
    Date today = new Date();
    long time = today.getTime();
    Timestamp ts = new Timestamp(time);
    String timestamp = ts.toString();

    public edit_po() {
        try {
            initComponents();
            txtPO_date.grabFocus();
            bPDF.setEnabled(false);
            bPreview.setEnabled(false);
            ////////
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(SwingConstants.CENTER);
            tblStockLoad.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            // For the drop down effect of stock codes instead of using the combo box
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);

            tblSupLoad.setVisible(false);
            jScrollPane6.setVisible(false);
            //Supplier IDs loaded
            po.loadSup(tblSupLoad);
            ////////////////////Loading Stock codes/////////////////////////////
            po.loadStock(tblStockLoad);
            /////////////Loading Delivery Term, Payment Term, Project Details, Deliver To Details/////////////////////
       //     po.preloadComboPO(comboDeliveryTerm, comboPaymentTerm, comboProject, comboDeliverTo);

            /////////////////// JTABLE RIGHT Alignment///////////////
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
            tblPO.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(4).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            ////////////////////////////

//            clear();
        } catch (Exception ex) {
            Logger.getLogger(edit_po.class.getName()).log(Level.SEVERE, null, ex);
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
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bPreview = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bPDF = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSupLoad = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblStockLoad = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bLoadSupplierDetails = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSAdd = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSName = new javax.swing.JTextPane();
        txtStelephone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        addtolist = new javax.swing.JButton();
        removeselected = new javax.swing.JButton();
        removeall = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPO = new javax.swing.JTable();
        lblVATType = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtStockCode = new javax.swing.JTextField();
        txtPO_date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblProject = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDelivery_date = new com.toedter.calendar.JDateChooser();
        txtSupRef = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblPaymentTerm = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtOurRef = new javax.swing.JTextField();
        lblDeliveryTerm = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtPOBy = new javax.swing.JTextPane();
        comboDiscount = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtAttention = new javax.swing.JTextPane();
        jLabel26 = new javax.swing.JLabel();
        txtVATTotal = new javax.swing.JTextField();
        comboDeliveryTerm = new javax.swing.JComboBox();
        comboPaymentTerm = new javax.swing.JComboBox();
        comboProject = new javax.swing.JComboBox();
        txtSupplierNo = new javax.swing.JTextField();
        loadGRN = new javax.swing.JButton();
        txtPO_no = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtRemarks = new javax.swing.JTextPane();
        comboDeliverTo = new javax.swing.JComboBox();
        lblDeliverTo = new javax.swing.JLabel();
        bEdit = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtRequestedBy = new javax.swing.JTextPane();
        lblLatestEdit = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        comboCurrency = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        comboVAT = new javax.swing.JComboBox();
        lblVATPercentage = new javax.swing.JLabel();
        comboVATType = new javax.swing.JComboBox();

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sub Total");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setPreferredSize(new java.awt.Dimension(0, 25));

        txtSubTotal.setEditable(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(0, 25));

        setTitle("Edit Purchase Order");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
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
        bNew.setText("Edit New");
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
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(bSave);
        jToolBar1.add(jSeparator1);

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Edit Purchase Order");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(600, 37));
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jScrollPane6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblSupLoad.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblSupLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier No", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSupLoad.setRowHeight(20);
        tblSupLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupLoadMouseClicked(evt);
            }
        });
        tblSupLoad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblSupLoadFocusLost(evt);
            }
        });
        jScrollPane6.setViewportView(tblSupLoad);
        if (tblSupLoad.getColumnModel().getColumnCount() > 0) {
            tblSupLoad.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblSupLoad.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 95, 330, 50));

        jScrollPane5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblStockLoad.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblStockLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Description", "PartNo Size", "UOM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        if (tblStockLoad.getColumnModel().getColumnCount() > 0) {
            tblStockLoad.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblStockLoad.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStockLoad.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblStockLoad.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 305, 580, 100));

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("E-Mail");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel2.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 70, 25));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PO No");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 25));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Date");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, 25));

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel6.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 60, 25));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Our Ref No");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel8.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 80, 25));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Supplier No");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 100, 25));

        bLoadSupplierDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadSupplierDetails.setBorderPainted(false);
        bLoadSupplierDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bLoadSupplierDetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadSupplierDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadSupplierDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadSupplierDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 30, 25));

        txtSAdd.setEditable(false);
        txtSAdd.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane2.setViewportView(txtSAdd);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 170, 55));

        txtSName.setEditable(false);
        txtSName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSName.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane4.setViewportView(txtSName);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 240, 25));

        txtStelephone.setEditable(false);
        txtStelephone.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtStelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 140, 25));

        txtEmail.setEditable(false);
        txtEmail.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 140, 25));

        txtQty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQty.setNextFocusableComponent(txtUnitPrice);
        txtQty.setPreferredSize(new java.awt.Dimension(0, 25));
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
        });
        getContentPane().add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 120, 25));

        txtUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUnitPrice.setNextFocusableComponent(comboDiscount);
        txtUnitPrice.setPreferredSize(new java.awt.Dimension(0, 25));
        txtUnitPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnitPriceKeyReleased(evt);
            }
        });
        getContentPane().add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 120, 25));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 190, 25));

        addtolist.setText("Add");
        addtolist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtolist.setNextFocusableComponent(txtStockCode);
        addtolist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtolistActionPerformed(evt);
            }
        });
        getContentPane().add(addtolist, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 60, 30));

        removeselected.setText("Remove  ");
        removeselected.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeselectedActionPerformed(evt);
            }
        });
        getContentPane().add(removeselected, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 80, 30));

        removeall.setText("Clear Table");
        removeall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallActionPerformed(evt);
            }
        });
        getContentPane().add(removeall, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 100, 30));

        tblPO.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblPO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Quantity", "Unit Price", "Description", "Discount", "Sub-Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPO.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPO.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPOMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPO);
        if (tblPO.getColumnModel().getColumnCount() > 0) {
            tblPO.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblPO.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblPO.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblPO.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblPO.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblPO.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 740, 180));

        lblVATType.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblVATType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVATType.setText("VAT");
        lblVATType.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblVATType.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(lblVATType, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 60, 25));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Quantity");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 80, 25));

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Stock Code");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 25));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 25));

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Tel.");
        jLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel13.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 70, 25));

        jLabel19.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Address");
        jLabel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel19.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 80, 25));

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
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, 25));

        txtPO_date.setDateFormatString("dd/MM/yy");
        txtPO_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPO_date.setNextFocusableComponent(txtSupplierNo);
        getContentPane().add(txtPO_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, 25));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 20, 20));

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(" Name");
        jLabel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel14.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 100, 25));

        lblProject.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblProject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProject.setText("Project");
        lblProject.setToolTipText("Click to Add new Project");
        lblProject.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProject.setPreferredSize(new java.awt.Dimension(0, 25));
        lblProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProjectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProjectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblProjectMouseExited(evt);
            }
        });
        getContentPane().add(lblProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 100, 25));

        jLabel16.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Attn :");
        jLabel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel16.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 40, 25));

        txtDelivery_date.setDateFormatString("dd/MM/yy");
        txtDelivery_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDelivery_date.setNextFocusableComponent(comboPaymentTerm);
        getContentPane().add(txtDelivery_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 130, 25));

        txtSupRef.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSupRef.setNextFocusableComponent(txtAttention);
        txtSupRef.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtSupRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, 90, 25));

        jLabel17.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Delivery Date");
        jLabel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel17.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 100, 25));

        lblPaymentTerm.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblPaymentTerm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaymentTerm.setText("Payment Term");
        lblPaymentTerm.setToolTipText("Click to Add new Payment Term");
        lblPaymentTerm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblPaymentTerm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPaymentTerm.setPreferredSize(new java.awt.Dimension(0, 25));
        lblPaymentTerm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPaymentTermMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPaymentTermMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPaymentTermMouseExited(evt);
            }
        });
        getContentPane().add(lblPaymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 100, 25));

        jLabel20.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Sup. Ref No");
        jLabel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel20.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 90, 25));

        txtOurRef.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOurRef.setNextFocusableComponent(txtSupRef);
        txtOurRef.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtOurRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 90, 25));

        lblDeliveryTerm.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblDeliveryTerm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeliveryTerm.setText("Delivery Term");
        lblDeliveryTerm.setToolTipText("Click to Add new Delivery Term");
        lblDeliveryTerm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblDeliveryTerm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDeliveryTerm.setPreferredSize(new java.awt.Dimension(0, 25));
        lblDeliveryTerm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeliveryTermMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDeliveryTermMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDeliveryTermMouseExited(evt);
            }
        });
        getContentPane().add(lblDeliveryTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 100, 25));

        txtPOBy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPOBy.setText("B.M.L.C Balasooriya\nManager, Purchasing");
        txtPOBy.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane7.setViewportView(txtPOBy);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 270, 25));

        comboDiscount.setEditable(true);
        comboDiscount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboDiscount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "2.5", "5", "7.5", "10", "12.5", "15", "20" }));
        comboDiscount.setNextFocusableComponent(addtolist);
        getContentPane().add(comboDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 120, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("%");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, 20));

        jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Unit Price");
        jLabel24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel24.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 80, 25));

        jLabel22.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Discount");
        jLabel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel22.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 80, 25));

        txtAttention.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAttention.setNextFocusableComponent(txtStockCode);
        txtAttention.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane8.setViewportView(txtAttention);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 170, 25));

        jLabel26.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("PO By");
        jLabel26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel26.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 25));

        txtVATTotal.setEditable(false);
        txtVATTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtVATTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtVATTotal.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtVATTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 150, 25));

        comboDeliveryTerm.setEditable(true);
        comboDeliveryTerm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboDeliveryTerm.setNextFocusableComponent(txtDelivery_date);
        getContentPane().add(comboDeliveryTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 160, 25));

        comboPaymentTerm.setEditable(true);
        comboPaymentTerm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboPaymentTerm.setNextFocusableComponent(txtOurRef);
        getContentPane().add(comboPaymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 130, 25));

        comboProject.setEditable(true);
        comboProject.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboProject.setNextFocusableComponent(comboDeliveryTerm);
        getContentPane().add(comboProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 640, 25));

        txtSupplierNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSupplierNo.setNextFocusableComponent(txtQty);
        txtSupplierNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSupplierNoMouseClicked(evt);
            }
        });
        txtSupplierNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSupplierNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSupplierNoKeyTyped(evt);
            }
        });
        getContentPane().add(txtSupplierNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 130, 25));

        loadGRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        loadGRN.setContentAreaFilled(false);
        loadGRN.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        loadGRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGRNActionPerformed(evt);
            }
        });
        getContentPane().add(loadGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 30, 25));

        txtPO_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPO_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtPO_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPO_noActionPerformed(evt);
            }
        });
        getContentPane().add(txtPO_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 25));

        jLabel27.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Remarks");
        jLabel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel27.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 100, 25));

        txtRemarks.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtRemarks.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane9.setViewportView(txtRemarks);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 640, 40));

        comboDeliverTo.setEditable(true);
        comboDeliverTo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(comboDeliverTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 170, 25));

        lblDeliverTo.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblDeliverTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeliverTo.setText("Deliver To");
        lblDeliverTo.setToolTipText("Click to Add new Delivery Term");
        lblDeliverTo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblDeliverTo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDeliverTo.setPreferredSize(new java.awt.Dimension(0, 25));
        lblDeliverTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeliverToMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDeliverToMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDeliverToMouseExited(evt);
            }
        });
        getContentPane().add(lblDeliverTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 100, 25));

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });
        getContentPane().add(bEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 60, 30));

        jLabel18.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Req. By");
        jLabel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel18.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 60, 25));

        txtRequestedBy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRequestedBy.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane10.setViewportView(txtRequestedBy);

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 180, 25));
        getContentPane().add(lblLatestEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 160, 20));

        jLabel21.setText("Latest Edit :");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 60, 20));

        comboCurrency.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboCurrency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LKR", "USD", "GBP", "SGD,", " " }));
        getContentPane().add(comboCurrency, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, 50, 25));

        jLabel15.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("VAT Details");
        jLabel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel15.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, 25));

        comboVAT.setEditable(true);
        comboVAT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboVAT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12", "0" }));
        getContentPane().add(comboVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 100, 25));

        lblVATPercentage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVATPercentage.setText("%");
        getContentPane().add(lblVATPercentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, 20));

        comboVATType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboVATType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SVAT", "VAT", "No VAT" }));
        comboVATType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVATTypeActionPerformed(evt);
            }
        });
        getContentPane().add(comboVATType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 80, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addtolistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtolistActionPerformed
        addtolist();
    }//GEN-LAST:event_addtolistActionPerformed

    private void removeselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeselectedActionPerformed
        removeRow();
}//GEN-LAST:event_removeselectedActionPerformed

    private void removeallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
        dtm.setRowCount(0);
        txtTotal.setText("");
        txtVATTotal.setText("");
}//GEN-LAST:event_removeallActionPerformed

    private void bLoadSupplierDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadSupplierDetailsActionPerformed
        getSupplierDetials();
    }//GEN-LAST:event_bLoadSupplierDetailsActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        try {
            ResultSet rss = DBControl.getResultFromLocalDB("SELECT po_no From po WHERE po_no='" + txtPO_no.getText() + "'");
            if (rss.next()) {
                if (txtPO_no.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the PO Number", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPO_no.grabFocus();
                } else if (txtSName.getText().isEmpty() && txtSAdd.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a SUPPLIER ID", "Error", JOptionPane.ERROR_MESSAGE);
                    txtSupplierNo.grabFocus();
                } else if (txtPO_date.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please enter the PO Date", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPO_date.grabFocus();
                } else if (tblPO.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Please add items to the Purchase Order ", "Error, Invalid PO Number !", JOptionPane.ERROR_MESSAGE);
                    txtStockCode.grabFocus();
                } else {
                    db.setResult("DELETE From po_details  WHERE po_no='" + txtPO_no.getText() + "'");
                    db.setResult("DELETE From po WHERE po_no='" + txtPO_no.getText() + "'");
                    savePO();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Purchase Order doesn't exist. \nPlease enter a valid Purchase Order Number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(edit_po.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_bSaveActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            clear();
        } else if (i == 1) {
            JOptionPane.showMessageDialog(null, "Please save the changes", "SAVE", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bNewActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
        po.previewPO(txtPO_no.getText());
    }//GEN-LAST:event_bPreviewActionPerformed

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
                v.add(rs.getString("uom"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtStockCodeKeyReleased

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the stock code first ", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
            txtQty.setText("");
        } else {
        }
    }//GEN-LAST:event_txtQtyKeyReleased

    private void txtUnitPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnitPriceKeyReleased
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the stock code first ", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
            txtUnitPrice.setText("");
        } else {
        }
    }//GEN-LAST:event_txtUnitPriceKeyReleased

    private void txtStockCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockCodeFocusLost
        if (txtPO_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the PO Number", "Error", JOptionPane.ERROR_MESSAGE);
            txtPO_no.grabFocus();
            txtStockCode.setText("");

        } else {
            DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
            String stock_code = txtStockCode.getText();
            int z = dtm.getRowCount();
            for (int i1 = 0; i1 < z; i1++) {
                String check_stock_code = dtm.getValueAt(i1, 0).toString();
                if (stock_code.equals(check_stock_code)) {
                    JOptionPane.showMessageDialog(null, stock_code + " is already in your PO item list !  ", "Error", JOptionPane.ERROR_MESSAGE);
                    txtStockCode.setText("");
                    txtStockCode.grabFocus();
                }
            }
        }
    }//GEN-LAST:event_txtStockCodeFocusLost

private void txtStockCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyTyped
    tblStockLoad.setVisible(true);
    jScrollPane5.setVisible(true);
}//GEN-LAST:event_txtStockCodeKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtStockCode.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        tblStockLoad.setVisible(false);
        jScrollPane5.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblStockLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblStockLoad.getModel();
        int i = tblStockLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        txtStockCode.setText(s1);
        txtStockCode.grabFocus();
        tblStockLoad.setVisible(false);
        jScrollPane5.setVisible(false);
    }//GEN-LAST:event_tblStockLoadMouseClicked

    private void tblStockLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblStockLoadFocusLost
        tblStockLoad.setVisible(false);
        jScrollPane5.setVisible(false);
    }//GEN-LAST:event_tblStockLoadFocusLost

    private void lblDeliveryTermMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeliveryTermMouseClicked
        new new_po_delivery_term().setVisible(true);
    }//GEN-LAST:event_lblDeliveryTermMouseClicked

    private void lblProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProjectMouseClicked
        new new_po_project_detail().setVisible(true);
    }//GEN-LAST:event_lblProjectMouseClicked

    private void lblPaymentTermMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentTermMouseClicked
        new new_po_payment_term().setVisible(true);
    }//GEN-LAST:event_lblPaymentTermMouseClicked

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        po.createPDF(txtPO_no.getText());
    }//GEN-LAST:event_bPDFActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        if (tblStockLoad.isVisible()) {
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);
        } else {
            tblStockLoad.setVisible(true);
            jScrollPane5.setVisible(true);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void tblSupLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblSupLoad.getModel();
        int i = tblSupLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        txtSupplierNo.setText(s1);
        txtSupplierNo.grabFocus();
        getSupplierDetials();
        tblSupLoad.setVisible(false);
        jScrollPane6.setVisible(false);
    }//GEN-LAST:event_tblSupLoadMouseClicked

    private void tblSupLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblSupLoadFocusLost
        tblSupLoad.setVisible(false);
        jScrollPane6.setVisible(false);
    }//GEN-LAST:event_tblSupLoadFocusLost

    private void txtSupplierNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierNoKeyReleased
        try {
            String Search = txtSupplierNo.getText();
            String s2 = Search.toUpperCase();
            txtSupplierNo.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM supplier_details "
                    + "WHERE supplier_name LIKE '" + Search + '%' + "' "
                    + "OR supplier_no LIKE '" + Search + '%' + "' "
                    + "ORDER BY supplier_no ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblSupLoad.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier_no"));
                v.add(rs.getString("supplier_name"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtSupplierNoKeyReleased

    private void txtSupplierNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierNoKeyTyped
        tblSupLoad.setVisible(true);
        jScrollPane6.setVisible(true);
    }//GEN-LAST:event_txtSupplierNoKeyTyped

    private void txtStockCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockCodeMouseClicked
        if (tblStockLoad.isVisible() || !txtSupplierNo.isEditable()) {
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);
        } else {
            tblStockLoad.setVisible(true);
            jScrollPane5.setVisible(true);
        }
    }//GEN-LAST:event_txtStockCodeMouseClicked

    private void txtSupplierNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSupplierNoMouseClicked
        if (tblSupLoad.isVisible() || !txtSupplierNo.isEditable()) {
            tblSupLoad.setVisible(false);
            jScrollPane6.setVisible(false);
        } else {
            tblSupLoad.setVisible(true);
            jScrollPane6.setVisible(true);
        }
    }//GEN-LAST:event_txtSupplierNoMouseClicked

    private void lblProjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProjectMouseEntered
        lblProject.setForeground(Color.red);
    }//GEN-LAST:event_lblProjectMouseEntered

    private void lblProjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProjectMouseExited
        lblProject.setForeground(Color.black);
    }//GEN-LAST:event_lblProjectMouseExited

    private void lblDeliveryTermMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeliveryTermMouseEntered
        lblDeliveryTerm.setForeground(Color.red);
    }//GEN-LAST:event_lblDeliveryTermMouseEntered

    private void lblDeliveryTermMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeliveryTermMouseExited
        lblDeliveryTerm.setForeground(Color.black);
    }//GEN-LAST:event_lblDeliveryTermMouseExited

    private void lblPaymentTermMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentTermMouseEntered
        lblPaymentTerm.setForeground(Color.red);
    }//GEN-LAST:event_lblPaymentTermMouseEntered

    private void lblPaymentTermMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentTermMouseExited
        lblPaymentTerm.setForeground(Color.black);
    }//GEN-LAST:event_lblPaymentTermMouseExited

    private void loadGRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGRNActionPerformed
        loadPO();
    }//GEN-LAST:event_loadGRNActionPerformed

    private void txtPO_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPO_noActionPerformed
        loadPO();
    }//GEN-LAST:event_txtPO_noActionPerformed

    private void lblDeliverToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeliverToMouseClicked
        new new_po_deliver_to().setVisible(true);
    }//GEN-LAST:event_lblDeliverToMouseClicked

    private void lblDeliverToMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeliverToMouseEntered
        lblDeliverTo.setForeground(Color.red);
    }//GEN-LAST:event_lblDeliverToMouseEntered

    private void lblDeliverToMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeliverToMouseExited
        lblDeliverTo.setForeground(Color.black);
    }//GEN-LAST:event_lblDeliverToMouseExited

    private void tblPOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPOMouseClicked
    }//GEN-LAST:event_tblPOMouseClicked

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        DefaultTableModel dtmm = (DefaultTableModel) tblPO.getModel();
        int i = tblPO.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row to edit !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String s1 = dtmm.getValueAt(i, 0).toString();
            String s2 = dtmm.getValueAt(i, 1).toString();
            String s3 = dtmm.getValueAt(i, 2).toString();
            String discount = dtmm.getValueAt(i, 4).toString();
            txtStockCode.setText(s1);
            txtQty.setText(s2);
            txtUnitPrice.setText(s3);
            BigDecimal dis = new BigDecimal(discount);
            if (Double.parseDouble(discount) != 0) {
                //Using Double
                Double dis1 = new Double(discount);
                Double qty1 = new Double(s2);
                Double up1 = new Double(s3);
                Double dis3 = dis1 / qty1;
                Double disP = dis3 / up1;
                Double finalDis = disP * 100;
                BigDecimal f = new BigDecimal(finalDis).setScale(2, RoundingMode.UP);
                String finalDiscount1 = f.toString();
                //Using BigDecimal
                BigDecimal qty = new BigDecimal(s2);
                BigDecimal up = new BigDecimal(s3);
                BigDecimal dis2 = dis.divide(qty, RoundingMode.HALF_DOWN);
                BigDecimal discountPercentage = dis2.divide(up, RoundingMode.HALF_DOWN);
                BigDecimal hundred = new BigDecimal("100");
                BigDecimal discountPercentage2 = discountPercentage.multiply(hundred).setScale(2, RoundingMode.HALF_EVEN);
                String finalDiscount = discountPercentage2.toString();

                comboDiscount.setSelectedItem(finalDiscount1);
            } else {
                comboDiscount.setSelectedIndex(0);
            }
            removeRow();
        }
    }//GEN-LAST:event_bEditActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        scm.utils.HideLoadTable.TwoTables(tblStockLoad, jScrollPane5, tblSupLoad, jScrollPane6);
    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        scm.utils.HideLoadTable.TwoTables(tblStockLoad, jScrollPane5, tblSupLoad, jScrollPane6);
    }//GEN-LAST:event_formMouseMoved

    private void comboVATTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVATTypeActionPerformed
        if (comboVATType.getSelectedItem() == "SVAT") {
            comboVAT.setSelectedItem("12");
            lblVATType.setText("SVAT");
        } else if (comboVATType.getSelectedItem() == "VAT") {
            lblVATType.setText("VAT");
        } else if (comboVATType.getSelectedItem() == "No VAT") {
            comboVAT.setSelectedItem("0");
        }
    }//GEN-LAST:event_comboVATTypeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtolist;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bLoadSupplierDetails;
    private javax.swing.JButton bNew;
    public static javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboCurrency;
    public static javax.swing.JComboBox comboDeliverTo;
    public static javax.swing.JComboBox comboDeliveryTerm;
    private javax.swing.JComboBox comboDiscount;
    public static javax.swing.JComboBox comboPaymentTerm;
    public static javax.swing.JComboBox comboProject;
    private javax.swing.JComboBox comboVAT;
    private javax.swing.JComboBox comboVATType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDeliverTo;
    private javax.swing.JLabel lblDeliveryTerm;
    private javax.swing.JLabel lblLatestEdit;
    private javax.swing.JLabel lblPaymentTerm;
    private javax.swing.JLabel lblProject;
    private javax.swing.JLabel lblVATPercentage;
    private javax.swing.JLabel lblVATType;
    private javax.swing.JButton loadGRN;
    private javax.swing.JButton removeall;
    private javax.swing.JButton removeselected;
    private javax.swing.JTable tblPO;
    private javax.swing.JTable tblStockLoad;
    private javax.swing.JTable tblSupLoad;
    private javax.swing.JTextPane txtAttention;
    private com.toedter.calendar.JDateChooser txtDelivery_date;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtOurRef;
    private javax.swing.JTextPane txtPOBy;
    private com.toedter.calendar.JDateChooser txtPO_date;
    private javax.swing.JTextField txtPO_no;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextPane txtRemarks;
    private javax.swing.JTextPane txtRequestedBy;
    private javax.swing.JTextPane txtSAdd;
    private javax.swing.JTextPane txtSName;
    private javax.swing.JTextField txtStelephone;
    private javax.swing.JTextField txtStockCode;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSupRef;
    private javax.swing.JTextField txtSupplierNo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtVATTotal;
    // End of variables declaration//GEN-END:variables

    void getSupplierDetials() {
        try {
            String SID = txtSupplierNo.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM supplier_details WHERE supplier_no='" + SID + "'");
            while (rs.next()) {
                txtSAdd.setText(rs.getString("address"));
                txtSName.setText(rs.getString("supplier_name"));
                txtStelephone.setText(rs.getString("tel_no1"));
                txtEmail.setText(rs.getString("email_add"));
                txtAttention.setText(rs.getString("contact_name"));
            }
        } catch (Exception ex) {
            Logger.getLogger(edit_po.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addtolist() {
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the stock code first ", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
            txtUnitPrice.setText("");
        } else if (txtQty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the quantity ", "Error", JOptionPane.ERROR_MESSAGE);
            txtQty.grabFocus();
        } else if (Double.parseDouble(txtQty.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Quantity cannot be zero (0). Please re-enter the quantity !", "Error", JOptionPane.ERROR_MESSAGE);
            txtQty.grabFocus();
        } else if (txtUnitPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the unit price ", "Error", JOptionPane.ERROR_MESSAGE);
            txtUnitPrice.grabFocus();
        } else {
            try {
                int decimals = 2;
                BigDecimal qty = new BigDecimal(txtQty.getText());
                BigDecimal unit_price = new BigDecimal(txtUnitPrice.getText()).setScale(decimals, BigDecimal.ROUND_DOWN);
                String dis = (String) comboDiscount.getSelectedItem();
                BigDecimal discount = new BigDecimal(dis);
                BigDecimal hundred = new BigDecimal("100");

                BigDecimal subtotal = qty.multiply(unit_price).setScale(decimals, BigDecimal.ROUND_DOWN);
                BigDecimal dis1 = discount.divide(hundred).multiply(subtotal).setScale(decimals, BigDecimal.ROUND_DOWN);
                BigDecimal finalsubtotal = subtotal.subtract(dis1);
                txtSubTotal.setText(String.valueOf(finalsubtotal));

                String stock_code = txtStockCode.getText();
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
                DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(txtStockCode.getText());
                    v.add(txtQty.getText());
                    v.add(txtUnitPrice.getText());
                    v.add(rs.getString("description"));
                    v.add(dis1);
                    v.add(txtSubTotal.getText());
                    dtm.addRow(v);
                    BigDecimal b111 = new BigDecimal("0");
                    int x = dtm.getRowCount();
                    for (int i = 0; i < x; i++) {
                        String s1 = dtm.getValueAt(i, 5).toString();
                        BigDecimal b222 = new BigDecimal(s1);
                        b111 = b111.add(b222);
                        b111 = b111.setScale(decimals, BigDecimal.ROUND_DOWN);
                        String vatstring = (String) comboVAT.getSelectedItem();
                        BigDecimal vat = new BigDecimal(vatstring);
                        BigDecimal fvat = vat.divide(hundred).multiply(b111).setScale(decimals, BigDecimal.ROUND_DOWN);
                        txtVATTotal.setText(String.valueOf(fvat));
                        BigDecimal finaltotal = b111.add(fvat).setScale(decimals, BigDecimal.ROUND_DOWN);
                        txtTotal.setText("" + finaltotal);
                    }
                }
                txtStockCode.setText("");
                txtQty.setText("");
                txtUnitPrice.setText("");
                txtStockCode.grabFocus();
            } catch (Exception ex) {
                Logger.getLogger(edit_po.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                        null, "  ERROR  " + ex);
            }
        }
    }

    private void savePO() {
        try {

            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String valDate = ((JTextField) txtPO_date.getDateEditor().getUiComponent()).getText();
            String po_date = null;
            if (!valDate.isEmpty()) {
                po_date = date.format(txtPO_date.getDate());
            }
            String valDate1 = ((JTextField) txtDelivery_date.getDateEditor().getUiComponent()).getText();
            String del_date = null;
            if (!valDate1.isEmpty()) {
                del_date = date.format(txtDelivery_date.getDate());
            } else {
                del_date = "";
            }
            String po_no = txtPO_no.getText();
            String supplier_no = txtSupplierNo.getText();
            String project = comboProject.getSelectedItem().toString();
            String delTerm = comboDeliveryTerm.getSelectedItem().toString();
            String payTerm = comboPaymentTerm.getSelectedItem().toString();
            String POBy = txtPOBy.getText();
            String supRef = txtSupRef.getText();
            String ourRef = txtOurRef.getText();
            String attn = txtAttention.getText();
            String requestedBy = txtRequestedBy.getText();
            String remarks = txtRemarks.getText();
            String deliverTo = comboDeliverTo.getSelectedItem().toString();
            String vatType;
            if (comboVATType.getSelectedItem() == "No VAT") {
                vatType = "";
            } else {
                vatType = comboVATType.getSelectedItem().toString();
            }
            String currency = comboCurrency.getSelectedItem().toString();

            String vat = txtVATTotal.getText();
            String total = txtTotal.getText();
            String updated_by = Main.lblUser.getText();
            DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
            for (int i = 0; i < tblPO.getRowCount(); i++) {
                String stock_code = dtm.getValueAt(i, 0).toString();
                String quantity = dtm.getValueAt(i, 1).toString();
                String unit_price = dtm.getValueAt(i, 2).toString();
                String description = dtm.getValueAt(i, 3).toString();
                String discount = dtm.getValueAt(i, 4).toString();
                String sub_total = dtm.getValueAt(i, 5).toString();
                db.setResult("INSERT INTO po_details VALUES('" + po_no + "','" + stock_code + "','" + description + "','" + quantity + "',"
                        + "'" + unit_price + "','" + discount + "','" + sub_total + "')");
            }
            db.setResult("INSERT INTO po VALUES ('" + po_no + "','" + po_date + "','" + supplier_no + "','" + project + "',"
                    + "'" + delTerm + "','" + del_date + "','" + payTerm + "','" + supRef + "','" + ourRef + "','" + POBy + "',"
                    + "'" + attn + "','" + requestedBy + "','" + remarks + "','" + deliverTo + "','" + vatType + "','" + currency + "','" + vat + "','" + total + "','" + updated_by + "','" + timestamp + "')");
           // JOptionPane.showMessageDialog(null, "Successfully Saved");
            bPDF.setEnabled(true);
            bPreview.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(edit_po.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "If the problem continues, please restart WMS \n" + ex, "Error! PO was not Saved", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadPO() {
        DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
        clear();
        if (txtPO_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the PO Number to search for !", "Error", JOptionPane.ERROR_MESSAGE);
            txtPO_no.grabFocus();
        } else {
            try {
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM po WHERE po_no = '" + txtPO_no.getText() + "'");
                ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT * FROM po_details WHERE po_no = '" + txtPO_no.getText() + "'");
                while (rs.next()) {
                    txtSupplierNo.setText(rs.getString("supplier_no"));
                    String SID = txtSupplierNo.getText();
                    ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM supplier_details WHERE supplier_no='" + SID + "'");
                    while (rs1.next()) {
                        txtSAdd.setText(rs1.getString("address"));
                        txtSName.setText(rs1.getString("supplier_name"));
                        txtStelephone.setText(rs1.getString("tel_no1"));
                        txtEmail.setText(rs1.getString("email_add"));
                    }
                    rs1.close();

                    // PO Date
                    DateFormat formatter;
                    Date date = null;
                    Date date1 = null;
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                    String dd = rs.getString("po_date");
                    if (!dd.isEmpty()) {
                        try {
                            date = (Date) formatter.parse(dd);
                            format.format(date);
                            txtPO_date.setDate(date);
                        } catch (ParseException ex) {
                        }
                    }
                    String dd1 = rs.getString("delivery_date");
                    if (!dd1.isEmpty()) {
                        try {
                            date1 = (Date) formatter.parse(dd1);
                            format.format(date1);
                            txtDelivery_date.setDate(date1);
                        } catch (ParseException ex) {
                        }
                    }

                    comboProject.setSelectedItem(rs.getString("project_details"));
                    comboDeliveryTerm.setSelectedItem(rs.getString("delivery_term"));
                    comboPaymentTerm.setSelectedItem(rs.getString("payment_term"));
                    comboDeliverTo.setSelectedItem(rs.getString("deliver_to"));
                    txtPOBy.setText(rs.getString("po_by"));
                    txtOurRef.setText(rs.getString("our_ref"));
                    txtSupRef.setText(rs.getString("sup_ref"));
                    txtAttention.setText(rs.getString("attention"));
                    txtRemarks.setText(rs.getString("remarks"));
                    txtRequestedBy.setText(rs.getString("requested_by"));
                    lblLatestEdit.setText(rs.getString("time"));

                    ///PO Items /////
                    while (rs4.next()) {
                        Vector v = new Vector();
                        String stock_code = rs4.getString("stock_code");
                        String des = rs4.getString("description");
                        String qty = rs4.getString("quantity");
                        String unit_price = rs4.getString("unit_price");
                        v.add(stock_code);
                        v.add(qty);
                        v.add(unit_price);
                        v.add(des);
                        v.add(rs4.getString("discount"));
                        v.add(rs4.getString("sub_total"));
                        dtm.addRow(v);
                    }
                    comboVATType.setSelectedItem(rs.getString("vat_type"));
                    comboCurrency.setSelectedItem(rs.getString("currency"));
                    txtVATTotal.setText(rs.getString("vat"));
                    txtTotal.setText(rs.getString("total"));
                }
            } catch (Exception ex) {
                Logger.getLogger(view_po.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void clear() {
        txtStockCode.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        comboDiscount.setSelectedIndex(0);
        txtPO_date.setDate(null);
        txtSupplierNo.setText("");
        txtSubTotal.setText("");
        txtTotal.setText("");
        txtSAdd.setText("");
        txtSName.setText("");
        txtStelephone.setText("");
        txtEmail.setText("");
        txtDelivery_date.setDate(null);
        txtPO_date.setDate(null);
        txtOurRef.setText("");
        txtSupRef.setText("");
        txtAttention.setText("");
        txtRequestedBy.setText("");
        txtRemarks.setText("");
        txtVATTotal.setText("");
        comboCurrency.setSelectedIndex(0);
        comboVATType.setSelectedIndex(0);
//        comboPaymentTerm.setSelectedIndex(0);
        comboDeliveryTerm.setSelectedIndex(0);
        comboProject.setSelectedIndex(0);
        comboDeliverTo.setSelectedIndex(0);
        lblLatestEdit.setText("");
        DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
        dtm.setRowCount(0);
    }

    private void removeRow() {
        int decimals = 2;
        BigDecimal hundred = new BigDecimal("100");
        String vatstring = (String) comboVAT.getSelectedItem();

        DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
        int arr[] = tblPO.getSelectedRows();
        for (int i = 0; i < arr.length; i++) {
            BigDecimal total = new BigDecimal(txtTotal.getText());
            int j = tblPO.getSelectedRow();
            String subt = dtm.getValueAt(j, 5).toString();
            BigDecimal subtotal = new BigDecimal(subt);
            BigDecimal curVat = new BigDecimal(txtVATTotal.getText());
            BigDecimal newTotal = total.subtract(curVat);
            BigDecimal fTotal = newTotal.subtract(subtotal);
            BigDecimal vat = new BigDecimal(vatstring);
            BigDecimal fvat = vat.divide(hundred).multiply(fTotal).setScale(decimals, BigDecimal.ROUND_DOWN);
            BigDecimal finaltotal = fTotal.add(fvat);
            txtVATTotal.setText(String.valueOf(fvat));
            txtTotal.setText("" + finaltotal);
            dtm.removeRow(tblPO.getSelectedRow());
        }
    }
}
