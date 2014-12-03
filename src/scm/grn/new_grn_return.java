package scm.grn;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;
import scm.Main;

public final class new_grn_return extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
    Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    long time = today.getTime();
    Timestamp ts = new Timestamp(time);
    String timestamp = ts.toString();

    public new_grn_return() {
        try {
            initComponents();
            bPreview.setEnabled(false);
            bPDF.setEnabled(false);
            bSave.setEnabled(true);
            /////////////////// JTABLE RIGHT Alignment///////////////
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(dtcr);

        } catch (Exception ex) {
            Logger.getLogger(new_grn_return.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGRN_no = new javax.swing.JTextField();
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
        loadGRN = new javax.swing.JButton();
        txtSupNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        bChangeDate = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sub Total");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setPreferredSize(new java.awt.Dimension(0, 25));

        txtSubTotal.setEditable(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(0, 25));

        setTitle("GRN Return");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return_grn.png"))); // NOI18N
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
        jLabel12.setText("GRN Returns");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(800, 37));
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
        jLabel3.setText("GRN No");
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
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 80, 25));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(" Name");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel8.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 100, 25));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Supplier No");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 100, 25));

        txtGRN_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtGRN_no.setNextFocusableComponent(txtGRN_date);
        txtGRN_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtGRN_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGRN_noActionPerformed(evt);
            }
        });
        getContentPane().add(txtGRN_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 25));

        txtSAdd.setEditable(false);
        txtSAdd.setPreferredSize(new java.awt.Dimension(0, 25));
        jScrollPane2.setViewportView(txtSAdd);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 170, 60));

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
        txtQty.setNextFocusableComponent(addtolist);
        txtQty.setPreferredSize(new java.awt.Dimension(0, 25));
        txtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQtyFocusGained(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
        });
        getContentPane().add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 120, 25));

        txtUnitPrice.setEditable(false);
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
        getContentPane().add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 120, 25));

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
        getContentPane().add(addtolist, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 90, 30));

        removeselected.setText("Remove  ");
        removeselected.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeselectedActionPerformed(evt);
            }
        });
        getContentPane().add(removeselected, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, 30));

        removeall.setText("Clear Table");
        removeall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallActionPerformed(evt);
            }
        });
        getContentPane().add(removeall, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 100, 30));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Quantity", "Unit Price", "Description", "Sub-Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setRowHeight(20);
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
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 730, 300));

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Unit Price");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel7.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 80, 25));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Quantity");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 80, 25));

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Stock Code");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 80, 25));

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

        txtStockCode.setEditable(false);
        txtStockCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 120, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Rs.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, -1, 25));

        txtGRN_date.setDateFormatString("dd/MM/yy");
        txtGRN_date.setEnabled(false);
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 20, 20));

        loadGRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        loadGRN.setBorderPainted(false);
        loadGRN.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        loadGRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGRNActionPerformed(evt);
            }
        });
        getContentPane().add(loadGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 30, 25));

        txtSupNo.setEditable(false);
        txtSupNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSupNo.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtSupNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 140, 25));

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Invoice");
        jLabel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel14.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 70, 25));

        txtInvoice.setEditable(false);
        txtInvoice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtInvoice.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(txtInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 140, -1));

        bChangeDate.setText("Edit Date");
        bChangeDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChangeDateActionPerformed(evt);
            }
        });
        getContentPane().add(bChangeDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 110, 20));

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
            String s1 = dtm.getValueAt(j, 4).toString();
            BigDecimal d4 = new BigDecimal(s1);
            d3 = d3.subtract(d4);
            txtTotal.setText("" + d3);
            dtm.removeRow(jTable1.getSelectedRow());
        }
        txtStockCode.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
}//GEN-LAST:event_removeselectedActionPerformed

    private void removeallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        txtTotal.setText("");
}//GEN-LAST:event_removeallActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        int decimals = 2;
        if (txtGRN_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Number to Return", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_no.grabFocus();
        } else if (txtSName.getText().isEmpty() && txtSAdd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "GRN Doesn't exist ", "Error", JOptionPane.ERROR_MESSAGE);
            txtSupNo.grabFocus();
        } else if (txtGRN_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Date", "Error", JOptionPane.ERROR_MESSAGE);
            txtGRN_date.grabFocus();
        } else if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No items found to return", "Error", JOptionPane.ERROR_MESSAGE);
            txtStockCode.grabFocus();
        } else {
            try {
                String grn_no = txtGRN_no.getText();
                String updated_by = Main.lblUser.getText();
                String total = txtTotal.getText();
                BigDecimal tott = new BigDecimal(total).setScale(decimals, BigDecimal.ROUND_DOWN);

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    String stock_code = dtm.getValueAt(i, 0).toString();
                    String quantity = dtm.getValueAt(i, 1).toString();
                    String unit_price = dtm.getValueAt(i, 2).toString();
                    String sub_total = dtm.getValueAt(i, 4).toString();
                    db.setResult("INSERT INTO grn_return(grn_no,stock_code,quantity,unit_price,sub_total,user,time) "
                            + " VALUES('" + grn_no + "','" + stock_code + "','" + quantity + "','" + unit_price + "',"
                            + "'" + sub_total + "','" + updated_by + "','" + timestamp + "')");

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

                        BigDecimal zero = new BigDecimal("0.00");
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
                    db.setResult("UPDATE grn_qty SET quantity = quantity - '" + quantity + "' WHERE grn_no = '" + grn_no + "' AND stock_code = '" + stock_code + "'");
                }
                db.setResult("UPDATE grn SET total = total -'" + tott + "' WHERE grn_no ='" + grn_no + "'");
                JOptionPane.showMessageDialog(null, "Successfully Returned and Stock Adjusted");
                bSave.setEnabled(false);
                bPreview.setEnabled(true);
                bPDF.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(new_grn_return.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Return was not saved !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

}//GEN-LAST:event_bSaveActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            txtGRN_no.setText("");
            txtGRN_date.setDate(null);
            txtStockCode.setText("");
            txtQty.setText("");
            txtUnitPrice.setText("");
            txtSubTotal.setText("");
            txtTotal.setText("");
            txtInvoice.setText("");
            txtSupNo.setText("");
            txtSAdd.setText("");
            txtSName.setText("");
            txtStelephone.setText("");
            txtEmail.setText("");
            bSave.setEnabled(true);
            bPreview.setEnabled(false);
            bPDF.setEnabled(false);
            DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
            dtm1.setRowCount(0);
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
        // addtolist();
    }//GEN-LAST:event_txtUnitPriceFocusLost

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the stock code first ");
            txtStockCode.grabFocus();
            txtQty.setText("");
        } else {
        }
    }//GEN-LAST:event_txtQtyKeyReleased

    private void txtUnitPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnitPriceKeyReleased
        if (txtStockCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the stock code first ");
            txtStockCode.grabFocus();
            txtUnitPrice.setText("");
        } else {
        }
    }//GEN-LAST:event_txtUnitPriceKeyReleased

    private void txtQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusGained
    }//GEN-LAST:event_txtQtyFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtStockCode.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadGRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGRNActionPerformed
        loadGRN();
    }//GEN-LAST:event_loadGRNActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        String stock_code = dtm.getValueAt(i, 0).toString();
        String qty = dtm.getValueAt(i, 1).toString();
        String unit_price = dtm.getValueAt(i, 2).toString();
        txtStockCode.setText(stock_code);
        txtQty.setText(qty);
        txtUnitPrice.setText(unit_price);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtGRN_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGRN_noActionPerformed
        loadGRN();
    }//GEN-LAST:event_txtGRN_noActionPerformed

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        grn.createPDF(txtGRN_no.getText());
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
                    db.setResult("UPDATE grn SET grn_date = '" + grn_date + "' WHERE grn_no = '" + txtGRN_no.getText() + "'");
                    loadGRN();
                    JOptionPane.showMessageDialog(null, "Date was successfully changed !", "Date", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(new_grn_return.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bChangeDateActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtolist;
    private javax.swing.JButton bChangeDate;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton loadGRN;
    private javax.swing.JButton removeall;
    private javax.swing.JButton removeselected;
    private javax.swing.JTextField txtEmail;
    private com.toedter.calendar.JDateChooser txtGRN_date;
    private javax.swing.JTextField txtGRN_no;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextPane txtSAdd;
    private javax.swing.JTextPane txtSName;
    private javax.swing.JTextField txtStelephone;
    private javax.swing.JTextField txtStockCode;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSupNo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables

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
                ResultSet rs2 = DBControl.getResultFromLocalDB("SELECT quantity FROM grn_details WHERE grn_no='" + txtGRN_no.getText() + "' AND stock_code='" + stock_code + "'");
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                while (rs.next()) {
                    while (rs2.next()) {
                        Double current_qty = Double.parseDouble(rs2.getString("quantity"));
                        Double new_qty = Double.parseDouble(txtQty.getText());
                        if (new_qty > current_qty) {
                            JOptionPane.showMessageDialog(null, "New quantity is greater than current quantity ", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Vector v = new Vector();
                            v.add(txtStockCode.getText());
                            v.add(txtQty.getText());
                            v.add(txtUnitPrice.getText());
                            v.add(rs.getString("description"));
                            v.add(txtSubTotal.getText());
                            if (jTable1.getRowCount() == 0) {
                                JOptionPane.showMessageDialog(null, "Please reload the GRN ", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                dtm.removeRow(jTable1.getSelectedRow());
                            }
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
                        }
                    }
                }
                txtStockCode.setText("");
                txtQty.setText("");
                txtUnitPrice.setText("");
                txtStockCode.grabFocus();
            } catch (Exception ex) {
                Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
            }
        }
    }

    private void loadGRN() {
        int decimals = 2;
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        dtm1.setRowCount(0);
        txtGRN_date.setDate(null);
        txtStockCode.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        txtInvoice.setText("");
        txtSubTotal.setText("");
        txtTotal.setText("");
        txtSAdd.setText("");
        txtSName.setText("");
        txtStelephone.setText("");
        txtEmail.setText("");

        if (txtGRN_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Number to search for !");
            txtGRN_no.grabFocus();
        } else {
            try {
                ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT * FROM grn_details WHERE grn_no = '" + txtGRN_no.getText() + "'");
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM grn WHERE grn_no = '" + txtGRN_no.getText() + "'");
                while (rs.next()) {
                    /// Load supplier ID and the following supplier details
                    txtSupNo.setText(rs.getString("supplier_no"));
                    String SID = txtSupNo.getText();
                    ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM supplier_details WHERE supplier_no='" + SID + "'");
                    while (rs1.next()) {
                        txtSAdd.setText(rs1.getString("address"));
                        txtSName.setText(rs1.getString("supplier_name"));
                        txtStelephone.setText(rs1.getString("tel_no1"));
                        txtEmail.setText(rs1.getString("email_add"));
                    }
                    rs1.close();
                    // GRN Date
                    DateFormat formatter;
                    Date date = null;
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                    String dd = rs.getString("grn_date");
                    if (!dd.isEmpty()) {
                        try {
                            date = (Date) formatter.parse(dd);
                            format.format(date);
                            txtGRN_date.setDate(date);
                        } catch (ParseException ex) {
                        }
                    }
                    //Invoice No
                    txtInvoice.setText(rs.getString("invoice"));
                    /// GRN Items
                    DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();


                    while (rs4.next()) {
                        Vector v = new Vector();
                        String stock_code = rs4.getString("stock_code");
                        ResultSet rs3 = DBControl.getResultFromLocalDB("SELECT quantity FROM grn_qty WHERE grn_no = '" + txtGRN_no.getText() + "' AND stock_code = '" + stock_code + "'");
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
}
