package scm.fas;

import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scm.database.DBControl;

public final class entry_details extends javax.swing.JInternalFrame {

    public entry_details() {
        initComponents();
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        tblAdded.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        tblUpdated.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        update();
        entry();
        delete();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bRefresh = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bClose = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAdded = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUpdated = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDeleted = new javax.swing.JTable();

        setResizable(true);
        setTitle("Entry Details");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/entry_details.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator6);

        bRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        bRefresh.setText("Refresh");
        bRefresh.setFocusable(false);
        bRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRefresh.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });
        jToolBar1.add(bRefresh);
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
        jLabel12.setText("Entry Details");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(10);
        jLabel12.setMaximumSize(new java.awt.Dimension(1000, 37));
        jLabel12.setMinimumSize(new java.awt.Dimension(600, 37));
        jLabel12.setPreferredSize(new java.awt.Dimension(800, 37));
        jToolBar1.add(jLabel12);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 51));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLayeredPane2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        tblAdded.setAutoCreateRowSorter(true);
        tblAdded.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAdded.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Class", "Make"
            }
        ));
        tblAdded.setRowHeight(20);
        tblAdded.getTableHeader().setReorderingAllowed(false);
        tblAdded.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(tblAdded);
        tblAdded.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblAdded.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblAdded.getColumnModel().getColumn(2).setPreferredWidth(40);

        jScrollPane3.setBounds(0, 0, 550, 360);
        jLayeredPane2.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Last Added", jLayeredPane2);

        tblUpdated.setAutoCreateRowSorter(true);
        tblUpdated.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblUpdated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Class", "Make", "By", "Time"
            }
        ));
        tblUpdated.setRowHeight(20);
        tblUpdated.getTableHeader().setReorderingAllowed(false);
        tblUpdated.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tblUpdated);
        tblUpdated.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblUpdated.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblUpdated.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblUpdated.getColumnModel().getColumn(3).setPreferredWidth(10);

        jScrollPane2.setBounds(0, 0, 550, 360);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Last Updated", jLayeredPane1);

        tblDeleted.setAutoCreateRowSorter(true);
        tblDeleted.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDeleted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Class", "Make", "By", "Time"
            }
        ));
        tblDeleted.setRowHeight(20);
        tblDeleted.getTableHeader().setReorderingAllowed(false);
        tblDeleted.setVerifyInputWhenFocusTarget(false);
        jScrollPane4.setViewportView(tblDeleted);
        tblDeleted.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblDeleted.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblDeleted.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblDeleted.getColumnModel().getColumn(3).setPreferredWidth(10);

        jScrollPane4.setBounds(0, 0, 550, 360);
        jLayeredPane3.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Last Deleted", jLayeredPane3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 970, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_bCloseActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        update();
        entry();
        delete();
    }//GEN-LAST:event_bRefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblAdded;
    private javax.swing.JTable tblDeleted;
    private javax.swing.JTable tblUpdated;
    // End of variables declaration//GEN-END:variables

    void update() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details ORDER BY updated ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblUpdated.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("updated_by"));
                v.add(rs.getString("updated"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(entry_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }

    }

    void entry() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details ");
            DefaultTableModel dtm = (DefaultTableModel) tblAdded.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(entry_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }

    }

    private void delete() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details_del ORDER BY id DESC ");
            DefaultTableModel dtm = (DefaultTableModel) tblDeleted.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("updated_by"));
                v.add(rs.getString("updated"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(entry_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }
}
