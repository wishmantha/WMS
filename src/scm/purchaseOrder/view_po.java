package scm.purchaseOrder;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;
import scm.Main;

public final class view_po extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
    Date today = new Date();
    long time = today.getTime();
    Timestamp ts = new Timestamp(time);
    String timestamp = ts.toString();

    public view_po() {
        try {
            initComponents();
            txtPO_no.grabFocus();


            /////////////////// JTABLE RIGHT Alignment///////////////
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
            tblPO.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(4).setCellRenderer(dtcr);
            tblPO.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            ////////////////////////////
        } catch (Exception ex) {
            Logger.getLogger(view_po.class.getName()).log(Level.SEVERE, null, ex);
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
        bPreview = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bPDF = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPO_no = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSAdd = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSName = new javax.swing.JTextPane();
        txtStelephone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPO = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtPO_date = new com.toedter.calendar.JDateChooser();
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
        comboVAT = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtAttention = new javax.swing.JTextPane();
        jLabel26 = new javax.swing.JLabel();
        txtVATTotal = new javax.swing.JTextField();
        comboDeliveryTerm = new javax.swing.JComboBox();
        comboPaymentTerm = new javax.swing.JComboBox();
        comboProject = new javax.swing.JComboBox();
        txtSupplierNo = new javax.swing.JTextField();
        loadGRN = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtRemarks = new javax.swing.JTextPane();

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sub Total");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setPreferredSize(new java.awt.Dimension(0, 25));

        txtSubTotal.setEditable(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(0, 25));

        setTitle("View Purchase Order");
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
        jLabel12.setText("View Purchase Order");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(600, 37));
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

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
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 60, 25));

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

        txtPO_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPO_no.setNextFocusableComponent(txtPO_date);
        txtPO_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtPO_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPO_noActionPerformed(evt);
            }
        });
        getContentPane().add(txtPO_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 25));

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

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 210, 25));

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
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPO.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblPO);
        tblPO.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblPO.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblPO.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblPO.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblPO.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblPO.getColumnModel().getColumn(5).setPreferredWidth(70);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 970, 190));

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("VAT");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel7.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 60, 25));

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
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 110, 25));

        txtPO_date.setDateFormatString("dd/MM/yy");
        txtPO_date.setEnabled(false);
        txtPO_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPO_date.setNextFocusableComponent(txtSupplierNo);
        getContentPane().add(txtPO_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, 25));

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
        });
        getContentPane().add(lblProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 100, 25));

        jLabel16.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Attn :");
        jLabel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel16.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 80, 25));

        txtDelivery_date.setDateFormatString("dd/MM/yy");
        txtDelivery_date.setEnabled(false);
        txtDelivery_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDelivery_date.setNextFocusableComponent(comboPaymentTerm);
        getContentPane().add(txtDelivery_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 130, 25));

        txtSupRef.setEditable(false);
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
        });
        getContentPane().add(lblPaymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 100, 25));

        jLabel20.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Sup. Ref No");
        jLabel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel20.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 90, 25));

        txtOurRef.setEditable(false);
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
        });
        getContentPane().add(lblDeliveryTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 100, 25));

        txtPOBy.setEditable(false);
        txtPOBy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPOBy.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane7.setViewportView(txtPOBy);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 270, 55));

        comboVAT.setEditable(true);
        comboVAT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboVAT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12", "0" }));
        getContentPane().add(comboVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 50, 25));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("%");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, -1, 20));

        txtAttention.setEditable(false);
        txtAttention.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAttention.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane8.setViewportView(txtAttention);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 280, 25));

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
        getContentPane().add(txtVATTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 160, 25));

        comboDeliveryTerm.setEditable(true);
        comboDeliveryTerm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboDeliveryTerm.setNextFocusableComponent(txtDelivery_date);
        getContentPane().add(comboDeliveryTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 160, 25));

        comboPaymentTerm.setEditable(true);
        comboPaymentTerm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboPaymentTerm.setNextFocusableComponent(txtOurRef);
        getContentPane().add(comboPaymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 130, 25));

        comboProject.setEditable(true);
        comboProject.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboProject.setNextFocusableComponent(comboDeliveryTerm);
        getContentPane().add(comboProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 640, 25));

        txtSupplierNo.setEditable(false);
        txtSupplierNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        jLabel27.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Remarks");
        jLabel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel27.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 100, 25));

        txtRemarks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRemarks.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane9.setViewportView(txtRemarks);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 640, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        Main.po.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bNewActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
       po.previewPO(txtPO_no.getText());
    }//GEN-LAST:event_bPreviewActionPerformed

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

    private void loadGRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGRNActionPerformed
        loadPO();
    }//GEN-LAST:event_loadGRNActionPerformed

    private void txtPO_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPO_noActionPerformed
        loadPO();
    }//GEN-LAST:event_txtPO_noActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JComboBox comboDeliveryTerm;
    public static javax.swing.JComboBox comboPaymentTerm;
    public static javax.swing.JComboBox comboProject;
    private javax.swing.JComboBox comboVAT;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDeliveryTerm;
    private javax.swing.JLabel lblPaymentTerm;
    private javax.swing.JLabel lblProject;
    private javax.swing.JButton loadGRN;
    private javax.swing.JTable tblPO;
    private javax.swing.JTextPane txtAttention;
    private com.toedter.calendar.JDateChooser txtDelivery_date;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtOurRef;
    private javax.swing.JTextPane txtPOBy;
    private com.toedter.calendar.JDateChooser txtPO_date;
    private javax.swing.JTextField txtPO_no;
    private javax.swing.JTextPane txtRemarks;
    private javax.swing.JTextPane txtSAdd;
    private javax.swing.JTextPane txtSName;
    private javax.swing.JTextField txtStelephone;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSupRef;
    private javax.swing.JTextField txtSupplierNo;
    private javax.swing.JTextField txtTotal;
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
            }
        } catch (Exception ex) {
            Logger.getLogger(view_po.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadPO() {
        int decimals = 2;
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
        txtVATTotal.setText("");
        comboPaymentTerm.setSelectedItem("");
        comboDeliveryTerm.setSelectedItem("");
        comboProject.setSelectedItem("");
        DefaultTableModel dtm = (DefaultTableModel) tblPO.getModel();
        dtm.setRowCount(0);

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
                    txtPOBy.setText(rs.getString("po_by"));
                    txtOurRef.setText(rs.getString("our_ref"));
                    txtSupRef.setText(rs.getString("sup_ref"));
                    txtAttention.setText(rs.getString("attention"));
                    txtRemarks.setText(rs.getString("remarks"));

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
//                        ResultSet rs2 = DBControl.getResult("SELECT * FROM stock_details WHERE stock_code='" + stock_code + "'");
//                        while (rs2.next()) {
//                            v.add(rs2.getString("description"));
//                        }
                        v.add(des);
                        v.add(rs4.getString("discount"));
                        v.add(rs4.getString("sub_total"));
                        dtm.addRow(v);
                    }
                    txtVATTotal.setText(rs.getString("vat"));
                    txtTotal.setText(rs.getString("total"));
                }
            } catch (Exception ex) {
                Logger.getLogger(view_po.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }
}
