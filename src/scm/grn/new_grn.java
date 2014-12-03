package scm.grn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;
import scm.utils.LabelColor;
import scm.Main;
import scm.stock.stock_details;

public final class new_grn extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
    Date today = new Date();
    long time = today.getTime();
    Timestamp ts = new Timestamp(time);
    String timestamp = ts.toString();
    static String blank = " ";

    public new_grn() {
        try {
            initComponents();
            bPDF.setEnabled(false);
            bPreview.setEnabled(false);
            bSave.setEnabled(true);
            ////////
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(SwingConstants.CENTER);
          //  tblStockLoad.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            // For the drop down effect of stock codes instead of using the combo box
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);

            tblSupLoad.setVisible(false);
            jScrollPane6.setVisible(false);
            // Auto Increment of GRN_No//
            newGRN();
            ////////////////////Loading Stock codes/////////////////////////////
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
            //Supplier IDs loaded
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM supplier_details ORDER by supplier_no");
            DefaultTableModel dtm = (DefaultTableModel) tblSupLoad.getModel();
            dtm.setRowCount(0);
            while (rs1.next()) {
                Vector v2 = new Vector();
                v2.add(rs1.getString("supplier_no"));
                v2.add(rs1.getString("supplier_name"));
                dtm.addRow(v2);
            }
            ///////////////

            /////////////////// JTABLE RIGHT Alignment///////////////
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            /////////////
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            sdf.format(today);
            txtGRN_date.setDate(today);
            ////////
            loadPO_No();
            /////////
            ResultSet rs5 = DBControl.getResultFromLocalDB("SELECT payment_term FROM new_po_payment_term");
            Vector v5 = new Vector();
            v5.add(blank);
            while (rs5.next()) {
                v5.add(rs5.getString("payment_term"));
            }
            comboPaymentTerm.setModel(new DefaultComboBoxModel(v5));
            ////////////
            ResultSet rs6 = DBControl.getResultFromLocalDB("SELECT project_detail FROM new_grn_project_detail");
            Vector v6 = new Vector();
            v6.add(blank);
            while (rs6.next()) {
                v6.add(rs6.getString("project_detail"));
            }
            comboGRNProject.setModel(new DefaultComboBoxModel(v6));
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
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
        bDelete = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        bPreview = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bPDF = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblStockLoad = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSupLoad = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGRN_no = new javax.swing.JTextField();
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
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtStockCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtGRN_date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        txtSupplierNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        comboPO_NO = new javax.swing.JComboBox();
        lblPO_No = new javax.swing.JLabel();
        lblPaymentTerm = new javax.swing.JLabel();
        comboPaymentTerm = new javax.swing.JComboBox();
        lblProject = new javax.swing.JLabel();
        comboGRNProject = new javax.swing.JComboBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtStockPartNo = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtStockDescription = new javax.swing.JTextPane();

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sub Total");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setPreferredSize(new java.awt.Dimension(0, 25));

        txtSubTotal.setEditable(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(0, 25));

        setTitle("New GRN");
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

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        bSave.setText("Save");
        bSave.setFocusable(false);
        bSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSave.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSave.addMouseListener(new java.awt.event.MouseAdapter() {
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
        jToolBar1.add(jSeparator1);

        bDelete.setForeground(new java.awt.Color(204, 0, 0));
        bDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDelete.setText("Delete");
        bDelete.setEnabled(false);
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
        jToolBar1.add(jSeparator9);

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
        jToolBar1.add(jSeparator8);

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
        jToolBar1.add(jSeparator5);

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
        jLabel12.setText("New GRN");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(600, 37));
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jScrollPane5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblStockLoad.setBackground(new java.awt.Color(240, 240, 240));
        tblStockLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        tblStockLoad.getColumnModel().getColumn(1).setPreferredWidth(160);
        tblStockLoad.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblStockLoad.getColumnModel().getColumn(3).setPreferredWidth(30);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 195, 510, 290));

        jScrollPane6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tblSupLoad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        tblSupLoad.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblSupLoad.getColumnModel().getColumn(1).setPreferredWidth(200);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 95, 340, 300));

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("E-Mail");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel2.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 70, 25));

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
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 70, 25));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Invoice");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel8.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 70, 25));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Supplier No");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 100, 25));

        txtGRN_no.setEditable(false);
        txtGRN_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtGRN_no.setNextFocusableComponent(txtGRN_date);
        txtGRN_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtGRN_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGRN_noFocusLost(evt);
            }
        });
        getContentPane().add(txtGRN_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 130, 25));

        bLoadSupplierDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadSupplierDetails.setBorderPainted(false);
        bLoadSupplierDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bLoadSupplierDetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadSupplierDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadSupplierDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadSupplierDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 30, 25));

        txtSAdd.setEditable(false);
        txtSAdd.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane2.setViewportView(txtSAdd);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 160, 55));

        txtSName.setEditable(false);
        txtSName.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane4.setViewportView(txtSName);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 250, 25));

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
        getContentPane().add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 120, 25));

        txtUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUnitPrice.setNextFocusableComponent(txtStockCode);
        txtUnitPrice.setPreferredSize(new java.awt.Dimension(0, 25));
        txtUnitPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUnitPriceFocusLost(evt);
            }
        });
        txtUnitPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnitPriceKeyReleased(evt);
            }
        });
        getContentPane().add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 25));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 240, 25));

        addtolist.setText("Add");
        addtolist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtolist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtolistActionPerformed(evt);
            }
        });
        getContentPane().add(addtolist, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 90, 30));

        removeselected.setText("Remove  ");
        removeselected.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeselectedActionPerformed(evt);
            }
        });
        getContentPane().add(removeselected, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 90, 30));

        removeall.setText("Clear Table");
        removeall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallActionPerformed(evt);
            }
        });
        getContentPane().add(removeall, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 90, 30));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Quantity", "Unit Price", "Description", "Part No.", "Sub-Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 730, 260));

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Unit Price");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel7.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 80, 25));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Quantity");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 80, 25));

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Stock Code");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 25));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 80, 25));

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
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 120, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Rs.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, -1, 25));

        txtGRN_date.setDateFormatString("dd/MM/yy");
        txtGRN_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtGRN_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, 25));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 20, 20));

        txtSupplierNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        getContentPane().add(txtSupplierNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 130, 25));

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(" Name");
        jLabel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel14.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 100, 25));

        txtInvoice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtInvoice.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 140, -1));

        jLabel15.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("GRN No");
        jLabel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel15.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 25));

        comboPO_NO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPO_NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPO_NOActionPerformed(evt);
            }
        });
        getContentPane().add(comboPO_NO, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 90, 25));

        lblPO_No.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblPO_No.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPO_No.setText("PO No");
        lblPO_No.setToolTipText("Click to reload PO Numbers");
        lblPO_No.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblPO_No.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPO_No.setPreferredSize(new java.awt.Dimension(0, 25));
        lblPO_No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPO_NoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPO_NoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPO_NoMouseExited(evt);
            }
        });
        getContentPane().add(lblPO_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 25));

        lblPaymentTerm.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblPaymentTerm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaymentTerm.setText("Payment");
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
        getContentPane().add(lblPaymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 70, 25));

        comboPaymentTerm.setEditable(true);
        comboPaymentTerm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(comboPaymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 120, 25));

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
        getContentPane().add(lblProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 60, 25));

        comboGRNProject.setEditable(true);
        comboGRNProject.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(comboGRNProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 310, 25));

        txtStockPartNo.setEditable(false);
        txtStockPartNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane7.setViewportView(txtStockPartNo);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 230, 25));

        txtStockDescription.setEditable(false);
        txtStockDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(txtStockDescription);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 490, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addtolistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtolistActionPerformed
        addtolist();
    }//GEN-LAST:event_addtolistActionPerformed

    private void removeselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeselectedActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int arr[] = jTable1.getSelectedRows();
        for (int i = 0; i < arr.length; i++) {
            BigDecimal d3 = new BigDecimal(txtTotal.getText());

            int j = jTable1.getSelectedRow();
            String s1 = dtm.getValueAt(j, 5).toString();
            BigDecimal d4 = new BigDecimal(s1);
            d3 = d3.subtract(d4);
            txtTotal.setText("" + d3);
            dtm.removeRow(jTable1.getSelectedRow());
        }
}//GEN-LAST:event_removeselectedActionPerformed

    private void removeallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        txtTotal.setText("");
}//GEN-LAST:event_removeallActionPerformed

    private void bLoadSupplierDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadSupplierDetailsActionPerformed
        getSupplierDetials();
    }//GEN-LAST:event_bLoadSupplierDetailsActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        increaseGRN();
        if (txtGRN_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Number", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_no.grabFocus();
        } else if (txtSName.getText().isEmpty() && txtSAdd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a SUPPLIER ID", "Error", JOptionPane.ERROR_MESSAGE);
            txtSupplierNo.grabFocus();
        } else if (txtGRN_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Date", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_date.grabFocus();
        } else if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please add items to the GRN", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
        } else {
            saveGRN();
        }
}//GEN-LAST:event_bSaveActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            newGRN();
            editTrue();
            txtGRN_date.setDate(null);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            sdf.format(today);
            txtGRN_date.setDate(today);
            comboPO_NO.setSelectedItem("");
            comboPaymentTerm.setSelectedItem("");
            comboGRNProject.setSelectedItem("");
            txtStockCode.setText("");
            txtQty.setText("");
            txtUnitPrice.setText("");
            txtSubTotal.setText("");
            txtTotal.setText("");
            txtInvoice.setText("");
            txtSupplierNo.setText("");
            txtSAdd.setText("");
            txtSName.setText("");
            txtStelephone.setText("");
            txtEmail.setText("");
            DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
            dtm1.setRowCount(0);
            bPDF.setEnabled(false);
            bPreview.setEnabled(false);
            bSave.setEnabled(true);

        } else if (i == 1) {
            JOptionPane.showMessageDialog(null, "Please save the changes", "SAVE", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bNewActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
        grn.previewGRN(txtGRN_no.getText());
    }//GEN-LAST:event_bPreviewActionPerformed

    private void txtUnitPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUnitPriceFocusLost
//        addtolist();
    }//GEN-LAST:event_txtUnitPriceFocusLost

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if (txtGRN_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Delete not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_no.grabFocus();
        } else if (txtSName.getText().isEmpty() && txtSAdd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Delete not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            txtSupplierNo.grabFocus();
        } else if (txtGRN_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Delete not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_date.grabFocus();
        } else if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Delete not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
        } else {
            try {
                int op = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (op == 0) {

                    DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                    for (int i = 0; i < jTable1.getRowCount(); i++) {
                        String stock_code = dtm.getValueAt(i, 0).toString();
                        String quantity = dtm.getValueAt(i, 1).toString();
                        db.setResult("DELETE From grn_details  WHERE grn_no='" + txtGRN_no.getText() + "'");
                        ResultSet rs = DBControl.getResultFromLocalDB("SELECT unit_price,qoh FROM stock_details WHERE stock_code = '" + stock_code + "' ");
                        while (rs.next()) {

                            BigDecimal current_price = rs.getBigDecimal("unit_price"); // 110
                            BigDecimal current_qoh = rs.getBigDecimal("qoh"); // 10
                            BigDecimal current_value = current_price.multiply(current_qoh); //1100

                            String n1 = (String) dtm.getValueAt(i, 1);
                            String n2 = (String) dtm.getValueAt(i, 2);
                            BigDecimal new_quantity = new BigDecimal(n1); // 5
                            BigDecimal new_price = new BigDecimal(n2); // 120
                            BigDecimal new_value = new_quantity.multiply(new_price); // 600

                            BigDecimal final_value = current_value.subtract(new_value); // 500
                            BigDecimal final_quantity = current_qoh.subtract(new_quantity); // 5

                            BigDecimal zero = new BigDecimal("0");
                            if (final_value.equals(zero) || final_quantity.equals(zero)) {
                                jTextField1.setText(String.valueOf(new_price));
                            } else {
                                BigDecimal final_price = final_value.divide(final_quantity, RoundingMode.HALF_DOWN); // 100

                                BigDecimal hundred = new BigDecimal("100");
                                BigDecimal r = final_price.multiply(hundred); // 10000
                                BigDecimal x = r.divide(hundred, 2, RoundingMode.HALF_DOWN); // 100.00
                                jTextField1.setText(String.valueOf(x));
                            }
                        }
                        String xx = jTextField1.getText();
                        db.setResult("UPDATE stock_details SET unit_price ='" + xx + "' WHERE stock_code = '" + stock_code + "' ");
                        db.setResult("UPDATE stock_details SET qoh = qoh -'" + quantity + "' WHERE stock_code = '" + stock_code + "' ");
                    }
                    JOptionPane.showMessageDialog(null, "Successfully Deleted !");
                    txtGRN_no.setText("");
                    txtGRN_date.setDate(null);
                    txtStockCode.setText("");
                    txtQty.setText("");
                    txtUnitPrice.setText("");
                    txtSubTotal.setText("");
                    txtTotal.setText("");
                    txtInvoice.setText("");
                    txtSAdd.setText("");
                    txtSName.setText("");
                    txtStelephone.setText("");
                    txtEmail.setText("");
                    DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
                    dtm1.setRowCount(0);
                    newGRN();

                } else if (op == 1) {
                }
            } catch (Exception ex) {
                Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "GRN was not Deleted!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

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
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
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
        if (txtGRN_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Number", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_no.grabFocus();
            txtStockCode.setText("");
            txtUnitPrice.setText("");
        } else {
            try {
                String stock_code = txtStockCode.getText();
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
                while (rs.next()) {
                    txtUnitPrice.setText(rs.getString("unit_price"));
                }
            } catch (Exception ex) {
                Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            String stock_code = txtStockCode.getText();
            int z = dtm.getRowCount();
            for (int i1 = 0; i1 < z; i1++) {
                String check_stock_code = dtm.getValueAt(i1, 0).toString();
                if (stock_code.equals(check_stock_code)) {
                    JOptionPane.showMessageDialog(null, stock_code + " is already in your GRN item list !  ", "Error", JOptionPane.ERROR_MESSAGE);
                    txtStockCode.setText("");
                    txtStockCode.grabFocus();
                }
            }
        }
    }//GEN-LAST:event_txtStockCodeFocusLost

    private void txtGRN_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGRN_noFocusLost
        increaseGRN();
    }//GEN-LAST:event_txtGRN_noFocusLost

private void txtStockCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyTyped
    tblStockLoad.setVisible(true);
    jScrollPane5.setVisible(true);
}//GEN-LAST:event_txtStockCodeKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtStockCode.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
        txtStockDescription.setText("");
        txtStockPartNo.setText("");
        tblStockLoad.setVisible(false);
        jScrollPane5.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblStockLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockLoadMouseClicked
        try {
            DefaultTableModel dtmm = (DefaultTableModel) tblStockLoad.getModel();
            int i = tblStockLoad.getSelectedRow();
            String s1 = dtmm.getValueAt(i, 0).toString();
            txtStockCode.setText(s1);
            String stock_code = txtStockCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("Select * from stock_details WHERE stock_code = '" + stock_code + "'");
            while (rs.next()) {
                String desc = rs.getString("description");
                String partNo = rs.getString("partno_size");
                String ac = rs.getString("account_code");
                txtStockDescription.setText(desc);
                txtStockPartNo.setText(partNo);
            }
            txtStockCode.grabFocus();
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblStockLoadMouseClicked

    private void tblStockLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblStockLoadFocusLost
        tblStockLoad.setVisible(false);
        jScrollPane5.setVisible(false);
    }//GEN-LAST:event_tblStockLoadFocusLost

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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if (tblSupLoad.isVisible()) {
            tblSupLoad.setVisible(false);
            jScrollPane6.setVisible(false);
        } else {
            tblSupLoad.setVisible(true);
            jScrollPane6.setVisible(true);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txtStockCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockCodeMouseClicked
        if (tblStockLoad.isVisible()) {
            tblStockLoad.setVisible(false);
            jScrollPane5.setVisible(false);
        } else {
            tblStockLoad.setVisible(true);
            jScrollPane5.setVisible(true);
        }
    }//GEN-LAST:event_txtStockCodeMouseClicked

    private void txtSupplierNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSupplierNoMouseClicked
        if (tblSupLoad.isVisible()) {
            tblSupLoad.setVisible(false);
            jScrollPane6.setVisible(false);
        } else {
            tblSupLoad.setVisible(true);
            jScrollPane6.setVisible(true);
        }
    }//GEN-LAST:event_txtSupplierNoMouseClicked

    private void bSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSaveMouseEntered
        if (bSave.isEnabled()) {
            increaseGRN();
        }
    }//GEN-LAST:event_bSaveMouseEntered

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        grn.createPDF(txtGRN_no.getText());
    }//GEN-LAST:event_bPDFActionPerformed

    private void lblPaymentTermMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentTermMouseClicked
        Main.pp.setVisible(true);
    }//GEN-LAST:event_lblPaymentTermMouseClicked

    private void lblPaymentTermMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentTermMouseEntered
        LabelColor.lblMouseEntered(evt, lblPaymentTerm);
    }//GEN-LAST:event_lblPaymentTermMouseEntered

    private void lblPaymentTermMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentTermMouseExited
        LabelColor.lblMouseExited(evt, lblPaymentTerm);
    }//GEN-LAST:event_lblPaymentTermMouseExited

    private void lblProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProjectMouseClicked
        Main.gp.setVisible(true);
    }//GEN-LAST:event_lblProjectMouseClicked

    private void lblProjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProjectMouseEntered
        LabelColor.lblMouseEntered(evt, lblProject);
    }//GEN-LAST:event_lblProjectMouseEntered

    private void lblProjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProjectMouseExited
        LabelColor.lblMouseExited(evt, lblProject);
    }//GEN-LAST:event_lblProjectMouseExited

    private void comboPO_NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPO_NOActionPerformed
        try {
            String po_no = comboPO_NO.getSelectedItem().toString();
            ResultSet rs = DBControl.getResultFromLocalDB("Select * from po WHERE po_no = '" + po_no + "'");
            while (rs.next()) {
                String payment_term = rs.getString("payment_term");
                comboPaymentTerm.setSelectedItem(payment_term);
            }

        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboPO_NOActionPerformed

    private void lblPO_NoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPO_NoMouseEntered
        LabelColor.lblMouseEntered(evt, lblPO_No);
    }//GEN-LAST:event_lblPO_NoMouseEntered

    private void lblPO_NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPO_NoMouseClicked
        loadPO_No();
    }//GEN-LAST:event_lblPO_NoMouseClicked

    private void lblPO_NoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPO_NoMouseExited
        LabelColor.lblMouseExited(evt, lblPO_No);
    }//GEN-LAST:event_lblPO_NoMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        scm.utils.HideLoadTable.TwoTables(tblStockLoad, jScrollPane5, tblSupLoad, jScrollPane6);
    }//GEN-LAST:event_formMouseMoved

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int i = jTable1.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            String stock_code = dtm.getValueAt(i, 0).toString();
            ResultSet rs = DBControl.getResultFromLocalDB("Select * from stock_details WHERE stock_code = '" + stock_code + "'");
            while (rs.next()) {
                String des = rs.getString("description");
                String partNo = rs.getString("partno_size");
                txtStockDescription.setText(des);
                txtStockPartNo.setText(partNo);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtolist;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bLoadSupplierDetails;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bSave;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JComboBox comboGRNProject;
    public static javax.swing.JComboBox comboPO_NO;
    public static javax.swing.JComboBox comboPaymentTerm;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblPO_No;
    private javax.swing.JLabel lblPaymentTerm;
    private javax.swing.JLabel lblProject;
    private javax.swing.JButton removeall;
    private javax.swing.JButton removeselected;
    private javax.swing.JTable tblStockLoad;
    private javax.swing.JTable tblSupLoad;
    private javax.swing.JTextField txtEmail;
    private com.toedter.calendar.JDateChooser txtGRN_date;
    private javax.swing.JTextField txtGRN_no;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextPane txtSAdd;
    private javax.swing.JTextPane txtSName;
    private javax.swing.JTextField txtStelephone;
    private javax.swing.JTextField txtStockCode;
    private javax.swing.JTextPane txtStockDescription;
    private javax.swing.JTextPane txtStockPartNo;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSupplierNo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables

    void getSupplierDetials() {
        try {
            String SID = (String) txtSupplierNo.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM supplier_details WHERE supplier_no='" + SID + "'");
            while (rs.next()) {
                txtSAdd.setText(rs.getString("address"));
                txtSName.setText(rs.getString("supplier_name"));
                txtStelephone.setText(rs.getString("tel_no1"));
                txtEmail.setText(rs.getString("email_add"));
            }
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void newGRN() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT max(grn_no) AS '99999' FROM grn");
            while (rs.next()) {
                int r = rs.getInt("99999");
                txtGRN_no.setText("" + (r + 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
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
                BigDecimal d22 = new BigDecimal(txtQty.getText());
                BigDecimal d33 = new BigDecimal(txtUnitPrice.getText());
                d33 = d33.setScale(decimals, BigDecimal.ROUND_DOWN);
                BigDecimal d44 = d22.multiply(d33);
                d44 = d44.setScale(decimals, BigDecimal.ROUND_DOWN);
                txtSubTotal.setText(String.valueOf(d44));
                String stock_code = txtStockCode.getText();
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(txtStockCode.getText());
                    v.add(txtQty.getText());
                    v.add(txtUnitPrice.getText());
                    v.add(rs.getString("description"));
                    v.add(rs.getString("partno_size"));
                    v.add(txtSubTotal.getText());
                    dtm.addRow(v);
                    BigDecimal b111 = new BigDecimal("0");
                    int x = dtm.getRowCount();
                    for (int i = 0; i < x; i++) {
                        String s1 = dtm.getValueAt(i, 5).toString();
                        BigDecimal b222 = new BigDecimal(s1);
                        b111 = b111.add(b222);
                        b111 = b111.setScale(decimals, BigDecimal.ROUND_DOWN);
                        txtTotal.setText("" + b111);
                    }
                }
                txtStockCode.setText("");
                txtQty.setText("");
                txtUnitPrice.setText("");
                txtStockDescription.setText("");
                txtStockPartNo.setText("");
                txtStockCode.grabFocus();
            } catch (Exception ex) {
                Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
            }
        }
    }

    private void increaseGRN() {
        try {
            ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT grn_no FROM grn ORDER BY grn_no DESC LIMIT 1");
            while (rs2.next()) {
                String grn_no = rs2.getString("grn_no");
                int grn = Integer.parseInt(grn_no);
                int new_grn = grn + 1;
                txtGRN_no.setText(String.valueOf(new_grn));
            }
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveGRN() {
        try {
            int decimals = 2;
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String valDate = ((JTextField) txtGRN_date.getDateEditor().getUiComponent()).getText();
            String grn_date = null;
            if (!valDate.isEmpty()) {
                grn_date = date.format(txtGRN_date.getDate());
            }
            String grn_no = txtGRN_no.getText();
            String user = Main.lblUser.getText();
            String total = txtTotal.getText();
            BigDecimal tott = new BigDecimal(total).setScale(decimals, BigDecimal.ROUND_DOWN);
            String supplier_no = txtSupplierNo.getText();
            String po_no = comboPO_NO.getSelectedItem().toString();
            String payment_term = comboPaymentTerm.getSelectedItem().toString();
            String project = comboGRNProject.getSelectedItem().toString();
            String invoice = txtInvoice.getText();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String stock_code = dtm.getValueAt(i, 0).toString();
                String quantity = dtm.getValueAt(i, 1).toString();
                String unit_price = dtm.getValueAt(i, 2).toString();
                String sub_total = dtm.getValueAt(i, 5).toString();
                db.setResult("INSERT INTO grn_details(grn_no,stock_code,quantity,unit_price,sub_total)"
                        + " VALUES('" + grn_no + "','" + stock_code + "','" + quantity + "',"
                        + "'" + unit_price + "','" + sub_total + "')");
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT unit_price,qoh FROM stock_details "
                        + "WHERE stock_code = '" + stock_code + "' ");
                while (rs.next()) {
                    BigDecimal current_price = rs.getBigDecimal("unit_price");
                    BigDecimal qoh = rs.getBigDecimal("qoh");
                    BigDecimal current_value = current_price.multiply(qoh);

                    String new_quantity = (String) dtm.getValueAt(i, 1);
                    String new_price = (String) dtm.getValueAt(i, 2);
                    BigDecimal n1 = new BigDecimal(new_quantity);
                    BigDecimal n2 = new BigDecimal(new_price);
                    BigDecimal new_value = n1.multiply(n2);

                    BigDecimal final_value = new_value.add(current_value);
                    BigDecimal final_quantity = qoh.add(n1);
                    BigDecimal final_price = final_value.divide(final_quantity, RoundingMode.HALF_DOWN);

                    // always use ( 2,RoundingMode.HALF_DOWN) when dividing a BigDecimal
                    BigDecimal hundred = new BigDecimal("100");
                    BigDecimal r = final_price.multiply(hundred);
                    BigDecimal x = r.divide(hundred, 2, RoundingMode.HALF_DOWN);
                    jTextField1.setText(String.valueOf(x));
                }
                String xx = jTextField1.getText();
                db.setResult("UPDATE stock_details SET unit_price ='" + xx + "' "
                        + "WHERE stock_code = '" + stock_code + "' ");
                db.setResult("UPDATE stock_details SET qoh = qoh +'" + quantity + "' "
                        + "WHERE stock_code = '" + stock_code + "' ");
                db.setResult("INSERT INTO grn_qty (grn_no,stock_code,quantity) "
                        + "VALUES('" + grn_no + "','" + stock_code + "','" + quantity + "')");
            }
            db.setResult("INSERT INTO grn(grn_no,grn_date,supplier_no,po_no,payment_term,"
                    + "project,invoice,total,user,time) "
                    + "VALUES('" + grn_no + "','" + grn_date + "','" + supplier_no + "',"
                    + "'" + po_no + "','" + payment_term + "','" + project + "','" + invoice + "',"
                    + "'" + tott + "','" + user + "','" + timestamp + "')");
            JOptionPane.showMessageDialog(null, "Successfully Saved and Stock Adjusted");
            bPDF.setEnabled(true);
            bPreview.setEnabled(true);
            bSave.setEnabled(false);
            txtGRN_no.setEditable(false);

            editFalse();
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "If the problem continues, please restart WMS \n" + ex, "Error! GRN was not saved !", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }

    public static void loadPO_No() {
        try {
            ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT po_no FROM po ORDER BY po_no DESC");
            Vector v4 = new Vector();
            v4.add(blank);
            while (rs4.next()) {
                v4.add(rs4.getString("po_no"));
            }
            comboPO_NO.setModel(new DefaultComboBoxModel(v4));
        } catch (Exception ex) {
            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editFalse() {
        txtGRN_date.setEnabled(false);
        txtInvoice.setEditable(false);
        txtSupplierNo.setEditable(false);
        txtStockCode.setEditable(false);
        txtUnitPrice.setEditable(false);
        txtQty.setEditable(false);
        comboPO_NO.setEditable(false);
        comboGRNProject.setEditable(false);
        comboPaymentTerm.setEditable(false);
        jTable1.setEnabled(false);
        addtolist.setVisible(false);
        removeall.setVisible(false);
        removeselected.setVisible(false);
    }

    private void editTrue() {
        txtGRN_date.setEnabled(true);
        txtInvoice.setEditable(true);
        txtSupplierNo.setEditable(true);
        txtStockCode.setEditable(true);
        txtUnitPrice.setEditable(true);
        txtQty.setEditable(true);
        comboPO_NO.setEditable(true);
        comboGRNProject.setEditable(true);
        comboPaymentTerm.setEditable(true);
        jTable1.setEnabled(true);
        addtolist.setVisible(true);
        removeall.setVisible(true);
        removeselected.setVisible(true);
    }
}
