package scm.stock;

import scm.utils.systemTray;
import scm.utils.SendMail;
import scm.database.DBControl;
import scm.database.validate;
import scm.utils.LabelColor;
import java.awt.TrayIcon.MessageType;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scm.*;

public class new_stock extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
    Date today = new Date();
    long time = today.getTime();
    Timestamp ts = new Timestamp(time);
    String timestamp = ts.toString();

    public new_stock() {
        initComponents();
        try {
            load();
            tblAccountLoad.setVisible(false);
            jScrollPane4.setVisible(false);
//////////// Loading UOM//////////////////////////
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT uom FROM new_uom ORDER BY uom");
            Vector v2 = new Vector();
            v2.add("");
            while (rs1.next()) {
                v2.add(rs1.getString("uom"));
            }
            comboUOM.setModel(new DefaultComboBoxModel(v2));
//////////// Loading Category//////////////////////////
            ResultSet rs6 = DBControl.getResultFromLocalDB("SELECT category FROM new_stock_category ORDER BY category");
            Vector v6 = new Vector();
            v6.add("");
            while (rs6.next()) {
                v6.add(rs6.getString("category"));
            }
            txtType.setModel(new DefaultComboBoxModel(v6));
//////////////////////////////////////////////////
            //////////// Loading Plant//////////////////////////
            ResultSet rs7 = DBControl.getResultFromLocalDB("SELECT plant FROM new_stock_plant ORDER BY plant");
            Vector v7 = new Vector();
            v7.add("");
            while (rs7.next()) {
                v7.add(rs7.getString("plant"));
            }
            txtPlant.setModel(new DefaultComboBoxModel(v7));
//////////////////////////////////////////////////
            rbStock.setSelected(true);
            txtStockType.setText("Stock");
            txtBinLocation.setText("");
            txtBinLocation.setEnabled(true);
//////////////////////////////////////////////////
            ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT * FROM account_center ORDER BY account_code");
            DefaultTableModel dtm = (DefaultTableModel) tblAccountLoad.getModel();
            dtm.setRowCount(0);
            while (rs4.next()) {
                Vector v4 = new Vector();
                v4.add(rs4.getString("account_code"));
                v4.add(rs4.getString("description"));
                dtm.addRow(v4);
            }
//////////////////////////////////////////////////
        } catch (Exception ex) {
            Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAccountLoad = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
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
        txtStockCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        bShowAll = new javax.swing.JButton();
        rbStock = new javax.swing.JRadioButton();
        rbNonStock = new javax.swing.JRadioButton();
        comboUOM = new javax.swing.JComboBox();
        expenseLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtAccountCode = new javax.swing.JTextField();
        clearAccountCode = new javax.swing.JButton();
        txtType = new javax.swing.JComboBox();
        lblCategory1 = new javax.swing.JLabel();
        txtPlant = new javax.swing.JComboBox();

        setResizable(true);
        setTitle("New Stock");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Stock.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(249, 249, 249));
        jScrollPane4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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
        jScrollPane4.setViewportView(tblAccountLoad);
        tblAccountLoad.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblAccountLoad.getColumnModel().getColumn(1).setPreferredWidth(200);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 360, 260));

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("New Stock");
        jLabel12.setIconTextGap(10);
        jLabel12.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

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
        getContentPane().add(lblUOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 50, 30));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Stock Code");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Stock Type");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 80, 30));

        lblCategory.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory.setText("Plant");
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
        getContentPane().add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 50, 30));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Part No/Size");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 30));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Description");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 40));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Bin Location");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 100, 30));

        txtBinLocation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtBinLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, 140, 30));

        txtPartNoSize.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtPartNoSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 190, 30));

        txtStockType.setEditable(false);
        txtStockType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtStockType, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 90, 30));

        txtStockCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockCodeFocusLost(evt);
            }
        });
        txtStockCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockCodeKeyReleased(evt);
            }
        });
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 190, 30));

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(txtDescription);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 610, 40));

        bShowAll.setText("Show All");
        bShowAll.setFocusable(false);
        bShowAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowAllActionPerformed(evt);
            }
        });
        getContentPane().add(bShowAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 80, 30));

        buttonGroup1.add(rbStock);
        rbStock.setText("Stock");
        rbStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStockActionPerformed(evt);
            }
        });
        getContentPane().add(rbStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, 30));

        buttonGroup1.add(rbNonStock);
        rbNonStock.setText("Non-Stock");
        rbNonStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNonStockActionPerformed(evt);
            }
        });
        getContentPane().add(rbNonStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, 30));

        comboUOM.setEditable(true);
        comboUOM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboUOM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "metre", "litre", "kilogram", "kilometer", "ounce", "yard", "cubic", "foot", "inch", "pound", "gallon", "centimetre", "milimetre", "miligram", "tonne", "mile" }));
        getContentPane().add(comboUOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 80, 30));

        expenseLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        expenseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expenseLabel.setText("Account Code");
        expenseLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        expenseLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        expenseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expenseLabelMouseClicked(evt);
            }
        });
        getContentPane().add(expenseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 110, 30));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Account Code", "Stock Type", "Description", "Part No/Size", "UOM", "Category", "Plant", "Bin Location"
            }
        ));
        jTable1.setRowHeight(20);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setVerifyInputWhenFocusTarget(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(30);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 970, 260));

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
        getContentPane().add(txtAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 230, 30));

        clearAccountCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        clearAccountCode.setBorderPainted(false);
        clearAccountCode.setContentAreaFilled(false);
        clearAccountCode.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        clearAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAccountCodeActionPerformed(evt);
            }
        });
        getContentPane().add(clearAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, 20, 30));

        txtType.setEditable(true);
        txtType.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 170, 30));

        lblCategory1.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblCategory1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory1.setText("Category");
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
        getContentPane().add(lblCategory1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 70, 30));

        txtPlant.setEditable(true);
        txtPlant.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtPlant, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 220, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            clear();
        } else if (i == 1) {
            JOptionPane.showMessageDialog(null, "Please UPDATE the changes", "UPDATE", WIDTH, null);
        }
    }//GEN-LAST:event_bNewActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
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
                ResultSet rss = DBControl.getResultFromLocalDB("SELECT stock_code FROM stock_details WHERE stock_code='" + txtStockCode.getText() + "'");
                if (rss.next()) {
                    update();
                } else {
                    try {
                        String stock_code = txtStockCode.getText();
                        String account_code = txtAccountCode.getText();
                        String stock_type = txtStockType.getText();
                        String description = txtDescription.getText();
                        String PartNoSize = txtPartNoSize.getText();
                        String UOM = comboUOM.getSelectedItem().toString();
                        String Type = txtType.getSelectedItem().toString();
                        String BinLocation = txtBinLocation.getText();
                        String Plant = txtPlant.getSelectedItem().toString();
                        db.setResult("INSERT INTO stock_details VALUES('" + stock_code + "','" + account_code + "','" + stock_type + "',"
                                + "'" + description + "','" + PartNoSize + "','" + UOM + "','" + Type + "','" + Plant + "','" + BinLocation + "', 0,0)");
                        // JOptionPane.showMessageDialog(null, "Successfully Saved");
                        validate.isSaved(stock_code, "stock_details", "stock_code");
                        if (DBControl.isSaved() == true) {
                            new systemTray().getTrayicon().displayMessage("Successfully Saved", " Stock Code : [" + stock_code + "] ,  Description : [" + description + "]", MessageType.INFO);
                        }
                        SendMail sm = new SendMail();
                        sm.sendMail("New Stock Code Added [" + stock_code + "] by " + Main.lblUser.getText(),
                                "Stock Added at " + timestamp + " by " + Main.lblUser.getText() + " "
                                + "\n\n<|-----Stock Details-----|>\n\t*Stock Code: " + stock_code + "\n\t*Account Code: " + account_code + "\n\t*Stock Type: " + stock_type + ""
                                + "\n\t*Description: " + description + "\n\t*PartNo Size: " + PartNoSize + "\n\t*UOM: " + UOM + "\n\t*Category: " + Type + ""
                                + "\n\t*Plant: " + Plant + "\n\t*Bin Location: " + BinLocation);
                        load();
                    } catch (Exception ex) {
                        Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "  ERROR  " + ex);

                    }
                    txtStockCode.grabFocus();
                }
            } catch (Exception ex) {
                Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        deleteStock.deleteStock(txtStockCode);
        clear();
        load();
    }//GEN-LAST:event_bDeleteActionPerformed

    private void txtStockCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyReleased
        try {
            String stock_code = txtStockCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code LIKE '" + stock_code + "%' ORDER BY stock_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("account_code"));
                v.add(rs.getString("stock_type"));
                v.add(rs.getString("description"));
                v.add(rs.getString("partno_size"));
                v.add(rs.getString("uom"));
                v.add(rs.getString("type"));
                v.add(rs.getString("plant"));
                v.add(rs.getString("bin_location"));
                dtm.addRow(v);
            }
            String s1 = txtStockCode.getText();
            String s2 = s1.toUpperCase();
            txtStockCode.setText(s2);

        } catch (Exception ex) {
            Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR " + ex);
        }
    }//GEN-LAST:event_txtStockCodeKeyReleased

    private void bShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowAllActionPerformed
        load();
    }//GEN-LAST:event_bShowAllActionPerformed

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

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_bCloseActionPerformed

    private void lblUOMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUOMMouseClicked
        Main.newuom.setVisible(true);
    }//GEN-LAST:event_lblUOMMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JTable dtm = (JTable) evt.getSource();
        int i = jTable1.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();
        String t3 = dtm.getValueAt(i, 2).toString();
        String t4 = dtm.getValueAt(i, 3).toString();
        String t5 = dtm.getValueAt(i, 4).toString();
        String t6 = dtm.getValueAt(i, 5).toString();
        String t8 = dtm.getValueAt(i, 6).toString();
        String t9 = dtm.getValueAt(i, 7).toString();
        String t10 = dtm.getValueAt(i, 8).toString();

        txtStockCode.setText(t1);
        txtAccountCode.setText(t2);
        txtStockType.setText(t3);
        txtDescription.setText(t4);
        txtPartNoSize.setText(t5);
        comboUOM.setSelectedItem(t6);
        txtType.setSelectedItem(t8);
        txtPlant.setSelectedItem(t9);
        txtBinLocation.setText(t10);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtStockCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockCodeFocusLost
//        try {
//            int rowCount = 0;
//            int newCount = 0;
//            String stock_code = txtStockCode.getText();
//            ResultSet rs1 = DBControl.getResult("SELECT COUNT(*) FROM stock_details WHERE stock_code = '" + stock_code + "'");
//            rs1.next();
//            rowCount = rs1.getInt(1);
//            if (rowCount != newCount) {
//                JOptionPane.showMessageDialog(null, "Stock code already exists ! Please enter a new Stock Code!", "Error", JOptionPane.ERROR_MESSAGE);
//                txtStockCode.setText("");
//                txtStockCode.grabFocus();
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(new_grn.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_txtStockCodeFocusLost

    private void tblAccountLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblAccountLoad.getModel();
        int i = tblAccountLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        txtAccountCode.setText(s1);
        txtAccountCode.grabFocus();
        tblAccountLoad.setVisible(false);
        jScrollPane4.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadMouseClicked

    private void tblAccountLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblAccountLoadFocusLost
        tblAccountLoad.setVisible(false);
        jScrollPane4.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadFocusLost

    private void txtAccountCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyTyped
        tblAccountLoad.setVisible(true);
        jScrollPane4.setVisible(true);
    }//GEN-LAST:event_txtAccountCodeKeyTyped

    private void txtAccountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyReleased
        try {
            String Search = txtAccountCode.getText();
            String s2 = Search.toUpperCase();
            txtAccountCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code LIKE '" + Search + '%' + "'ORDER BY account_code ASC");
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

    private void clearAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAccountCodeActionPerformed
        txtAccountCode.setText("");
        tblAccountLoad.setVisible(false);
        jScrollPane4.setVisible(false);
    }//GEN-LAST:event_clearAccountCodeActionPerformed

    private void lblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoryMouseClicked
        Main.nsp.setVisible(true);
    }//GEN-LAST:event_lblCategoryMouseClicked

    private void expenseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenseLabelMouseClicked
        if (tblAccountLoad.isVisible()) {
            tblAccountLoad.setVisible(false);
            jScrollPane4.setVisible(false);
        } else {
            tblAccountLoad.setVisible(true);
            jScrollPane4.setVisible(true);
        }
    }//GEN-LAST:event_expenseLabelMouseClicked

    private void txtAccountCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccountCodeMouseClicked
        if (tblAccountLoad.isVisible()) {
            tblAccountLoad.setVisible(false);
            jScrollPane4.setVisible(false);
        } else {
            tblAccountLoad.setVisible(true);
            jScrollPane4.setVisible(true);
        }
    }//GEN-LAST:event_txtAccountCodeMouseClicked

    private void lblUOMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUOMMouseEntered
        LabelColor.lblMouseEntered(evt, lblUOM);
    }//GEN-LAST:event_lblUOMMouseEntered

    private void lblUOMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUOMMouseExited
        LabelColor.lblMouseExited(evt, lblUOM);
    }//GEN-LAST:event_lblUOMMouseExited

    private void lblCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoryMouseEntered
        LabelColor.lblMouseEntered(evt, lblCategory);
    }//GEN-LAST:event_lblCategoryMouseEntered

    private void lblCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoryMouseExited
        LabelColor.lblMouseExited(evt, lblCategory);
    }//GEN-LAST:event_lblCategoryMouseExited

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        scm.utils.HideLoadTable.OneTable(tblAccountLoad, jScrollPane4);
    }//GEN-LAST:event_formMouseMoved

    private void lblCategory1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategory1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCategory1MouseClicked

    private void lblCategory1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategory1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCategory1MouseEntered

    private void lblCategory1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategory1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCategory1MouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bShowAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearAccountCode;
    public static javax.swing.JComboBox comboUOM;
    private javax.swing.JLabel expenseLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategory1;
    private javax.swing.JLabel lblUOM;
    private javax.swing.JRadioButton rbNonStock;
    private javax.swing.JRadioButton rbStock;
    private javax.swing.JTable tblAccountLoad;
    private javax.swing.JTextField txtAccountCode;
    private javax.swing.JTextField txtBinLocation;
    private javax.swing.JTextPane txtDescription;
    private javax.swing.JTextField txtPartNoSize;
    public static javax.swing.JComboBox txtPlant;
    public static javax.swing.JTextField txtStockCode;
    private javax.swing.JTextField txtStockType;
    public static javax.swing.JComboBox txtType;
    // End of variables declaration//GEN-END:variables

    private void update() {
        try {
            String stock_code = txtStockCode.getText();
            String account_code = txtAccountCode.getText();
            String stock_type = txtStockType.getText();
            String description = txtDescription.getText();
            String PartNoSize = txtPartNoSize.getText();
            String UOM = comboUOM.getSelectedItem().toString();
            String Type = txtType.getSelectedItem().toString();
            String Plant = txtPlant.getSelectedItem().toString();
            String BinLocation = txtBinLocation.getText();
            db.setResult("UPDATE stock_details SET account_code='" + account_code + "', stock_type='" + stock_type + "', "
                    + "description ='" + description + "', partno_size ='" + PartNoSize + "', uom ='" + UOM + "',"
                    + " type ='" + Type + "', plant = '" + Plant + "',bin_location ='" + BinLocation + "' "
                    + "WHERE stock_code='" + stock_code + "'");
           // JOptionPane.showMessageDialog(null, "Successfully Updated", title, WIDTH);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details WHERE stock_code ='" + stock_code + "'");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("account_code"));
                v.add(rs.getString("stock_type"));
                v.add(rs.getString("description"));
                v.add(rs.getString("partno_size"));
                v.add(rs.getString("uom"));
                v.add(rs.getString("type"));
                v.add(rs.getString("plant"));
                v.add(rs.getString("bin_location"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR " + ex);
        }
    }

    private void load() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM stock_details ORDER BY stock_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("stock_code"));
                v.add(rs.getString("account_code"));
                v.add(rs.getString("stock_type"));
                v.add(rs.getString("description"));
                v.add(rs.getString("partno_size"));
                v.add(rs.getString("uom"));
                v.add(rs.getString("type"));
                v.add(rs.getString("plant"));
                v.add(rs.getString("bin_location"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_stock.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR " + ex);
        }
    }

    public void clear() {
        txtStockCode.setText("");
        txtAccountCode.setText("");
        txtStockType.setText("");
        txtDescription.setText("");
        txtPartNoSize.setText("");
        comboUOM.setSelectedItem("");
        txtType.setSelectedItem("");
        txtPlant.setSelectedItem("");
        txtBinLocation.setText("");
        txtStockCode.grabFocus();
        rbStock.setSelected(true);
        txtStockType.setText("Stock");
        txtBinLocation.setEnabled(true);
        txtStockCode.setText("");
        txtStockCode.grabFocus();
    }
}
