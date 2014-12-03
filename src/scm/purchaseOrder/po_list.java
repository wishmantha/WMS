package scm.purchaseOrder;

import java.awt.*;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import scm.database.DBControl;
import scm.Main;
import scm.utils.Permission;
import scm.utils.loadList;

public class po_list extends javax.swing.JInternalFrame {

    static DBControl db = new DBControl();
//    Date dated = new Date();
//    SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd hh-mm");
//    String d = sdff.format(dated);

    public po_list() {

        initComponents();
        String sql = "SELECT p.po_no, p.po_date, sd.supplier_no AS 'sd.supplier_no' , sd.supplier_name, "
                + "p.project_details, p.remarks, p.total, p.user AS 'p.user' FROM po p, supplier_details sd "
                + "WHERE p.supplier_no = sd.supplier_no  ORDER BY p.po_no ASC ";
        loadList.loadSearchBarComboSQL(sql, searchBarCombo);
        load();
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        tblPO_List.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        tblPO_List.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        tblPO_List.getColumnModel().getColumn(2).setCellRenderer(dtcr);
        tblPO_List.getColumnModel().getColumn(7).setCellRenderer(dtcr);
        JTableHeader header = tblPO_List.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        TableCellRenderer renderer = header.getDefaultRenderer();
        JLabel label = (JLabel) renderer;
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bNew = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bEdit = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        bPreview = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        bPDF = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPO_no = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPO_List = new javax.swing.JTable();
        bLoadGRN_no = new javax.swing.JButton();
        bLoadDate = new javax.swing.JButton();
        txtPO_date = new com.toedter.calendar.JDateChooser();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel13 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        searchBarCombo = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bClearAccountCode = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        bShowAll = new javax.swing.JButton();

        setTitle("PO List");
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

        bEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bEdit.setText("Edit");
        bEdit.setFocusable(false);
        bEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEdit.setIconTextGap(8);
        bEdit.setMargin(new java.awt.Insets(7, 15, 2, 15));
        bEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });
        jToolBar1.add(bEdit);
        jToolBar1.add(jSeparator11);

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
        jToolBar1.add(jSeparator7);

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
        jToolBar1.add(jSeparator1);

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
        jToolBar1.add(jSeparator5);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Purchase Order List");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(800, 37));
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PO No");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 25));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PO Date");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setPreferredSize(new java.awt.Dimension(0, 25));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 80, 25));

        txtPO_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPO_no.setNextFocusableComponent(txtPO_date);
        txtPO_no.setPreferredSize(new java.awt.Dimension(0, 25));
        txtPO_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPO_noActionPerformed(evt);
            }
        });
        txtPO_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPO_noKeyReleased(evt);
            }
        });
        getContentPane().add(txtPO_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 100, 25));

        tblPO_List.setAutoCreateRowSorter(true);
        tblPO_List.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblPO_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PO No", "Date", "Supplier No", "Supplier Name", "Project Details", "Remarks", "Total", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPO_List.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPO_List.setRowHeight(20);
        tblPO_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPO_ListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPO_List);
        if (tblPO_List.getColumnModel().getColumnCount() > 0) {
            tblPO_List.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPO_List.getColumnModel().getColumn(1).setPreferredWidth(25);
            tblPO_List.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblPO_List.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblPO_List.getColumnModel().getColumn(4).setPreferredWidth(160);
            tblPO_List.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblPO_List.getColumnModel().getColumn(7).setPreferredWidth(15);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 960, 380));

        bLoadGRN_no.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadGRN_no.setBorderPainted(false);
        bLoadGRN_no.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadGRN_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadGRN_noActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadGRN_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 30, 25));

        bLoadDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go bw.png"))); // NOI18N
        bLoadDate.setBorderPainted(false);
        bLoadDate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go.png"))); // NOI18N
        bLoadDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadDateActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 30, 25));

        txtPO_date.setDateFormatString("dd/MM/yy");
        txtPO_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtPO_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 130, 25));

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jLabel13.setText("Search Table  ");
        jToolBar2.add(jLabel13);

        searchBar.setMaximumSize(new java.awt.Dimension(150, 20));
        searchBar.setPreferredSize(new java.awt.Dimension(30, 20));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });
        jToolBar2.add(searchBar);
        jToolBar2.add(jSeparator9);

        jLabel1.setText("  Sort By ");
        jToolBar2.add(jLabel1);

        searchBarCombo.setMaximumSize(new java.awt.Dimension(150, 20));
        searchBarCombo.setPreferredSize(new java.awt.Dimension(28, 15));
        jToolBar2.add(searchBarCombo);
        jToolBar2.add(jSeparator2);

        bClearAccountCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        bClearAccountCode.setBorderPainted(false);
        bClearAccountCode.setContentAreaFilled(false);
        bClearAccountCode.setFocusable(false);
        bClearAccountCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClearAccountCode.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        bClearAccountCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClearAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearAccountCodeActionPerformed(evt);
            }
        });
        jToolBar2.add(bClearAccountCode);
        jToolBar2.add(jSeparator10);

        bShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh bw.gif"))); // NOI18N
        bShowAll.setFocusable(false);
        bShowAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowAll.setIconTextGap(1);
        bShowAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowAllActionPerformed(evt);
            }
        });
        jToolBar2.add(bShowAll);

        getContentPane().add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 960, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPO_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPO_ListMouseClicked
        JTable dtm = (JTable) evt.getSource();
        int i = tblPO_List.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();
        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        if (!t2.isEmpty()) {
            try {
                date = (Date) formatter.parse(t2);
                format.format(date);
                txtPO_date.setDate(date);
            } catch (ParseException ex) {
            }
        }
        txtPO_no.setText(t1);
        txtPO_date.setDate(date);
        //  new systemTray().getTrayicon().displayMessage("PO No: "+t1+" ","", TrayIcon.MessageType.INFO);

    }//GEN-LAST:event_tblPO_ListMouseClicked

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviewActionPerformed
        po.previewPO(txtPO_no.getText());
    }//GEN-LAST:event_bPreviewActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        Main.po.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bNewActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if (txtPO_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a PO Number to Delete !", "Error", JOptionPane.ERROR_MESSAGE);
            txtPO_no.grabFocus();
        } else {
            try {
                int op = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (op == 0) {
                    Permission.getPermission();
                    Boolean b = Permission.allow;
                    if (b.equals(true)) {
                        db.setResult("DELETE From po_details  WHERE po_no='" + txtPO_no.getText() + "'");
                        db.setResult("DELETE From po WHERE po_no='" + txtPO_no.getText() + "'");
                        JOptionPane.showMessageDialog(null, "Successfully Deleted !");
                        txtPO_no.setText("");
                        txtPO_date.setDate(null);
                        load();
                        Permission.allow = false;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(new_po.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PO was not Deleted!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        po.createPDF(txtPO_no.getText());
    }//GEN-LAST:event_bPDFActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        String comboText = searchBarCombo.getSelectedItem().toString();
        System.out.println(comboText);
        String sql = "SELECT * FROM po_details "
                + "WHERE  " + comboText + " LIKE '" + searchBar.getText() + "%' "
                + "ORDER BY po_no ASC ";
        String SQL = "SELECT p.po_no, p.po_date, sd.supplier_no, sd.supplier_name, "
                + "p.project_details, p.remarks, p.total, p.user FROM po p, supplier_details sd "
                + "WHERE p.supplier_no = sd.supplier_no AND  " + comboText + " LIKE '" + searchBar.getText() + "%' ORDER BY p.po_no DESC ";
        loadList.searchToolbar(tblPO_List, SQL, "PO");
    }//GEN-LAST:event_searchBarKeyReleased

    private void bClearAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearAccountCodeActionPerformed
        loadList.clearSearchBar(searchBar, searchBarCombo, tblPO_List);
    }//GEN-LAST:event_bClearAccountCodeActionPerformed

    private void bShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowAllActionPerformed
        load();
    }//GEN-LAST:event_bShowAllActionPerformed

    private void bLoadGRN_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadGRN_noActionPerformed
        if (txtPO_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the GRN Number to search for !");
            txtPO_no.grabFocus();
        } else {
            try {
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM  po p, supplier_details sd WHERE p.po_no = '" + txtPO_no.getText() + "' "
                        + "AND p.supplier_no = sd.supplier_no ORDER BY po_no ASC ");
                DefaultTableModel dtm = (DefaultTableModel) tblPO_List.getModel();
                dtm.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getInt("po_no"));
                    v.add(rs.getString("po_date"));
                    v.add(rs.getString("supplier_no"));
                    v.add(rs.getString("supplier_name"));
                    v.add(rs.getString("project_details"));
                    v.add(rs.getString("remarks"));
                    v.add(rs.getBigDecimal("total"));
                    v.add(rs.getString("user"));
                    dtm.addRow(v);
                }
            } catch (Exception ex) {
                Logger.getLogger(po_list.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
            }
        }
    }//GEN-LAST:event_bLoadGRN_noActionPerformed

    private void txtPO_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPO_noKeyReleased
        try {
            String po_no = txtPO_no.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM po p, supplier_details sd WHERE p.po_no LIKE '" + po_no + "%' AND p.supplier_no = sd.supplier_no ORDER BY po_no ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblPO_List.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("po_no"));
                v.add(rs.getString("po_date"));
                v.add(rs.getString("supplier_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("project_details"));
                v.add(rs.getString("remarks"));
                v.add(rs.getBigDecimal("total"));
                v.add(rs.getString("user"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(po_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }//GEN-LAST:event_txtPO_noKeyReleased

    private void txtPO_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPO_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPO_noActionPerformed

    private void bLoadDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadDateActionPerformed
        if (txtPO_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please enter a PO Date to search for !", "Error", JOptionPane.ERROR_MESSAGE);
            txtPO_date.grabFocus();
        } else {
            try {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                String valDate = ((JTextField) txtPO_date.getDateEditor().getUiComponent()).getText();
                String po_date = null;
                if (!valDate.isEmpty()) {
                    po_date = date.format(txtPO_date.getDate());
                }
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM  po p, supplier_details sd WHERE p.po_no = '" + po_date + "' "
                        + "AND p.supplier_no = sd.supplier_no  ORDER BY po_no ASC ");
                DefaultTableModel dtm = (DefaultTableModel) tblPO_List.getModel();
                dtm.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getInt("po_no"));
                    v.add(rs.getString("po_date"));
                    v.add(rs.getString("supplier_no"));
                    v.add(rs.getString("supplier_name"));
                    v.add(rs.getString("project_details"));
                    v.add(rs.getString("remarks"));
                    v.add(rs.getBigDecimal("total"));
                    v.add(rs.getString("user"));
                    dtm.addRow(v);
                }
            } catch (Exception ex) {
                Logger.getLogger(po_list.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
            }
        }
    }//GEN-LAST:event_bLoadDateActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        Permission.getPermission();
        Boolean b = Permission.allow;
        if (b.equals(true)) {
            try {
                Main.po.setVisible(true);
                Main.po.setSelected(true);
                if (Main.po.txtPO_no.getText().isEmpty()) {
                    Main.po.loadPO(txtPO_no.getText());
                } else {
                    int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made in the previous Purchase Order ?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        Main.po.loadPO(txtPO_no.getText());
                    } else if (i == 1) {
                        JOptionPane.showMessageDialog(null, "Please save the changes", "SAVE", JOptionPane.WARNING_MESSAGE);
                    }
                }
                Permission.allow = false;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(po_list.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_bEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClearAccountCode;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bLoadDate;
    private javax.swing.JButton bLoadGRN_no;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bPreview;
    private javax.swing.JButton bShowAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField searchBar;
    private javax.swing.JComboBox searchBarCombo;
    private javax.swing.JTable tblPO_List;
    private com.toedter.calendar.JDateChooser txtPO_date;
    private javax.swing.JTextField txtPO_no;
    // End of variables declaration//GEN-END:variables

    public void load() {
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT p.po_no, p.po_date, sd.supplier_no, sd.supplier_name, "
                    + "p.project_details, p.remarks, p.total, p.user FROM po p, supplier_details sd "
                    + "WHERE p.supplier_no = sd.supplier_no  ORDER BY p.po_no DESC ");
            DefaultTableModel dtm = (DefaultTableModel) tblPO_List.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("po_no"));
                v.add(rs.getString("po_date"));
                v.add(rs.getString("supplier_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("project_details"));
                v.add(rs.getString("remarks"));
                v.add(rs.getBigDecimal("total"));
                v.add(rs.getString("user"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(po_list.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
        setCursor(Cursor.getDefaultCursor());
    }
}
