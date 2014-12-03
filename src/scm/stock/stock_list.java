package scm.stock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import scm.database.DBControl;
import scm.Main;

public class stock_list extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();

    public stock_list() {
        initComponents();
        loadStock();
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        //tblStock_List.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        tblStock_List.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        tblStock_List.getColumnModel().getColumn(2).setCellRenderer(dtcr);
        JTableHeader header = tblStock_List.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        Font tableHeader = new Font("Tahoma", Font.BOLD, 12);
        header.setFont(tableHeader);
        header.setForeground(Color.BLACK);
        // header.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        TableCellRenderer renderer = header.getDefaultRenderer();
        JLabel label = (JLabel) renderer;
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel61 = new javax.swing.JLabel();
        txtStockCode = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStock_List = new javax.swing.JTable();
        bNonStock = new javax.swing.JButton();
        bStock = new javax.swing.JButton();
        bLoadStockCode = new javax.swing.JButton();
        bLoadAll = new javax.swing.JButton();
        txtAccountCode = new javax.swing.JTextField();
        bLoadAccountCode = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        txtPartNo = new javax.swing.JTextField();
        bLoadPartNo = new javax.swing.JButton();

        setResizable(true);
        setTitle("Stock List");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Stock.png"))); // NOI18N
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

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(102, 102, 102));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Stock List");
        jLabel61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel61.setIconTextGap(10);
        jLabel61.setMaximumSize(new java.awt.Dimension(800, 37));
        jLabel61.setPreferredSize(new java.awt.Dimension(500, 37));
        jToolBar1.add(jLabel61);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        txtStockCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockCodeKeyReleased(evt);
            }
        });
        getContentPane().add(txtStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        tblStock_List.setAutoCreateRowSorter(true);
        tblStock_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Account Code", "Stock Type", "Description", "Part No/Size", "UOM", "Type", "Plant", "Bin Location", "Unit Price", "QOH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, false, true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStock_List.setRowHeight(25);
        tblStock_List.getTableHeader().setReorderingAllowed(false);
        tblStock_List.setVerifyInputWhenFocusTarget(false);
        tblStock_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStock_ListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStock_List);
        tblStock_List.getColumnModel().getColumn(0).setPreferredWidth(48);
        tblStock_List.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblStock_List.getColumnModel().getColumn(2).setPreferredWidth(35);
        tblStock_List.getColumnModel().getColumn(3).setPreferredWidth(140);
        tblStock_List.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblStock_List.getColumnModel().getColumn(5).setPreferredWidth(10);
        tblStock_List.getColumnModel().getColumn(6).setPreferredWidth(60);
        tblStock_List.getColumnModel().getColumn(7).setPreferredWidth(60);
        tblStock_List.getColumnModel().getColumn(8).setPreferredWidth(45);
        tblStock_List.getColumnModel().getColumn(9).setPreferredWidth(55);
        tblStock_List.getColumnModel().getColumn(10).setPreferredWidth(10);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 970, 370));

        bNonStock.setText("Non-Stock");
        bNonStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNonStockActionPerformed(evt);
            }
        });
        getContentPane().add(bNonStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, -1, 30));

        bStock.setText("Stock");
        bStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStockActionPerformed(evt);
            }
        });
        getContentPane().add(bStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, -1, 30));

        bLoadStockCode.setText("Stock Code");
        bLoadStockCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadStockCodeActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadStockCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, 30));

        bLoadAll.setText("Show All");
        bLoadAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadAllActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, -1, 30));

        txtAccountCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAccountCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAccountCodeKeyReleased(evt);
            }
        });
        getContentPane().add(txtAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 130, 30));

        bLoadAccountCode.setText("Account Code");
        bLoadAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadAccountCodeActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadAccountCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, 30));

        jLabel67.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel67.setText("Filter Results by :");
        getContentPane().add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 30));

        txtPartNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPartNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPartNoKeyReleased(evt);
            }
        });
        getContentPane().add(txtPartNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 150, 30));

        bLoadPartNo.setText("Part No");
        bLoadPartNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadPartNoActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadPartNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        Main.ns.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bNewActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        deleteStock.deleteStock(txtStockCode);
        loadStock();
    }//GEN-LAST:event_bDeleteActionPerformed

    private void txtStockCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCodeKeyReleased
        String s1 = txtStockCode.getText();
        String s2 = s1.toUpperCase();
        txtStockCode.setText(s2);
        loadStockLike();
    }//GEN-LAST:event_txtStockCodeKeyReleased

    private void tblStock_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStock_ListMouseClicked
        JTable dtm = (JTable) evt.getSource();
        int i = tblStock_List.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();
        txtStockCode.setText(t1);
        txtAccountCode.setText(t2);
    }//GEN-LAST:event_tblStock_ListMouseClicked

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_bCloseActionPerformed

    private void bLoadAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadAllActionPerformed
        loadStock();
    }//GEN-LAST:event_bLoadAllActionPerformed

    private void bNonStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNonStockActionPerformed
        String sql = "SELECT * FROM stock_details WHERE bin_location = 'Non-Stock' ORDER BY stock_code ASC ";
        loadStockList(sql);
    }//GEN-LAST:event_bNonStockActionPerformed

    private void bStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStockActionPerformed
        String sql = "SELECT * FROM stock_details WHERE bin_location !='Non-Stock' ORDER BY stock_code ASC ";
        loadStockList(sql);
    }//GEN-LAST:event_bStockActionPerformed

    private void bLoadStockCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadStockCodeActionPerformed
        loadStockLike();
    }//GEN-LAST:event_bLoadStockCodeActionPerformed

    private void txtAccountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyReleased
        String s1 = txtAccountCode.getText();
        String s2 = s1.toUpperCase();
        txtAccountCode.setText(s2);
        loadAccountCode();
    }//GEN-LAST:event_txtAccountCodeKeyReleased

    private void bLoadAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadAccountCodeActionPerformed
        loadAccountCode();
    }//GEN-LAST:event_bLoadAccountCodeActionPerformed

    private void txtPartNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPartNoKeyReleased
        loadPartNo();
    }//GEN-LAST:event_txtPartNoKeyReleased

    private void bLoadPartNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadPartNoActionPerformed
        loadPartNo();
    }//GEN-LAST:event_bLoadPartNoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bLoadAccountCode;
    private javax.swing.JButton bLoadAll;
    private javax.swing.JButton bLoadPartNo;
    private javax.swing.JButton bLoadStockCode;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bNonStock;
    private javax.swing.JButton bStock;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblStock_List;
    private javax.swing.JTextField txtAccountCode;
    private javax.swing.JTextField txtPartNo;
    private javax.swing.JTextField txtStockCode;
    // End of variables declaration//GEN-END:variables

    private void loadAccountCode() {
        String account_code = txtAccountCode.getText();
        String sql = "SELECT * FROM stock_details WHERE account_code LIKE '" + account_code + "%'ORDER BY stock_code ASC ";
        loadStockList(sql);
    }

    private void loadPartNo() {
        String PartNo = txtPartNo.getText();
        String sql = "SELECT * FROM stock_details WHERE partno_size LIKE '" + PartNo + "%'ORDER BY stock_code ASC ";
        loadStockList(sql);
    }

    private void loadStockLike() {
        String stock_code = txtStockCode.getText();
        String sql = "SELECT * FROM stock_details "
                + "WHERE stock_code LIKE '" + stock_code + '%' + "' "
                + "OR description LIKE '" + stock_code + '%' + "' "
                + "ORDER BY stock_code ASC";
        loadStockList(sql);
    }

    public void loadStock() {
        String sql = "SELECT * FROM stock_details ORDER BY stock_code ";
        loadStockList(sql);
    }

    public void loadStockList(String sql) {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB(sql);
            DefaultTableModel dtm = (DefaultTableModel) tblStock_List.getModel();
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
                v.add(rs.getBigDecimal("unit_price"));
                v.add(rs.getLong("qoh"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }
}
