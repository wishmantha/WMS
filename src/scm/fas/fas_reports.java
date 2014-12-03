package scm.fas;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.Main;
import scm.help.settings;
import scm.utils.loadList;

public final class fas_reports extends javax.swing.JInternalFrame {

    String nul = "";
    Calendar currentDate = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateNow = formatter.format(currentDate.getTime());
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm");
    String d = sdf.format(date);
    String FAS_Renewal_SQL = "equipment_no, registration_no, insurance_company, insurance_no, insurance_exp, veh_rev_no, veh_rev_exp";

    public fas_reports() {
        try {
            initComponents();
            //Loading Search bar combo boxes with Table fields
            loadList.loadSearchBarComboCustomFields("fas_details", FAS_Renewal_SQL, searchBarSortByCombo);
            loadList.loadSearchBarComboCustomFields("fas_details", FAS_Renewal_SQL, searchBarOrderByCombo);

            JTableHeader header = tblBasic.getTableHeader();
            header.setPreferredSize(new Dimension(header.getWidth(), 30));
            TableCellRenderer renderer = header.getDefaultRenderer();
            JLabel label = (JLabel) renderer;
            label.setHorizontalAlignment(JLabel.CENTER);

            JTableHeader header2 = jTableFILTER.getTableHeader();
            header2.setPreferredSize(new Dimension(header.getWidth(), 30));
            TableCellRenderer renderer2 = header2.getDefaultRenderer();
            JLabel label2 = (JLabel) renderer2;
            label2.setHorizontalAlignment(JLabel.CENTER);

            showallBASICActionPerformed();
            showallFilterActionPerformed();
            showallRenewalActionPerformed();
            bInsDetailsActionPerformed();
            bVETDetailsActionPerformed();
            bRevDetailsActionPerformed();
            hireRate();

            DefaultTableModel dtm = (DefaultTableModel) tblBasic.getModel();
            int rowCount = dtm.getRowCount();
            txtCount.setText(String.valueOf(rowCount));
        } catch (Exception ex) {
            Logger.getLogger(fas_reports.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane3 = new javax.swing.JLayeredPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBasic = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        equipment_noSearchBASIC = new javax.swing.JFormattedTextField();
        jToolBar2 = new javax.swing.JToolBar();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bPDFBASIC = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        printBASIC = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        previewBASIC = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bCloseBASIC = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jToolBar3 = new javax.swing.JToolBar();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        addtolistBASIC = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        removeselectedBASIC = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        removeallBASIC = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        showallBASIC = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        txtCount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane11 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFILTER = new javax.swing.JTable();
        jLabel62 = new javax.swing.JLabel();
        equipment_noSearchFILTER = new javax.swing.JFormattedTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        addtolistFILTER = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        removeselectedFILTER = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        removeallFILTER = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        showallFilter = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        tblFilterFILTER = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bPDFFILTER = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        printFILTER = new javax.swing.JButton();
        jSeparator22 = new javax.swing.JToolBar.Separator();
        previewFILTER = new javax.swing.JButton();
        jSeparator23 = new javax.swing.JToolBar.Separator();
        bCloseFILTER = new javax.swing.JButton();
        jSeparator24 = new javax.swing.JToolBar.Separator();
        jLayeredPane13 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableRENEWAL = new javax.swing.JTable();
        SearchOrderToolbar = new javax.swing.JToolBar();
        jLabel13 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        searchBarSortByCombo = new javax.swing.JComboBox();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        jLabel6 = new javax.swing.JLabel();
        searchBarOrderByCombo = new javax.swing.JComboBox();
        jSeparator25 = new javax.swing.JToolBar.Separator();
        bClearAccountCode = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        bShowAll = new javax.swing.JButton();
        jToolBar6 = new javax.swing.JToolBar();
        addtolistRENEWAL = new javax.swing.JButton();
        jSeparator26 = new javax.swing.JToolBar.Separator();
        removeselectedRENEWAL = new javax.swing.JButton();
        jSeparator27 = new javax.swing.JToolBar.Separator();
        removeallRENEWAL = new javax.swing.JButton();
        jSeparator28 = new javax.swing.JToolBar.Separator();
        showallRenewal = new javax.swing.JButton();
        jSeparator29 = new javax.swing.JToolBar.Separator();
        jToolBar7 = new javax.swing.JToolBar();
        jSeparator31 = new javax.swing.JToolBar.Separator();
        bPDFRENEWAL = new javax.swing.JButton();
        jSeparator32 = new javax.swing.JToolBar.Separator();
        printRENEWAL = new javax.swing.JButton();
        jSeparator34 = new javax.swing.JToolBar.Separator();
        previewRENEWAL = new javax.swing.JButton();
        jSeparator35 = new javax.swing.JToolBar.Separator();
        bCloseRENEWAL = new javax.swing.JButton();
        jSeparator36 = new javax.swing.JToolBar.Separator();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        bInsDetails = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblInsurance = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar8 = new javax.swing.JToolBar();
        jSeparator33 = new javax.swing.JToolBar.Separator();
        bPDFRENEWAL1 = new javax.swing.JButton();
        jSeparator37 = new javax.swing.JToolBar.Separator();
        previewRENEWAL1 = new javax.swing.JButton();
        jSeparator39 = new javax.swing.JToolBar.Separator();
        bCloseRENEWAL1 = new javax.swing.JButton();
        jSeparator40 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        bVETDetails = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVET = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jToolBar9 = new javax.swing.JToolBar();
        jSeparator38 = new javax.swing.JToolBar.Separator();
        bPDFRENEWAL2 = new javax.swing.JButton();
        jSeparator41 = new javax.swing.JToolBar.Separator();
        previewRENEWAL2 = new javax.swing.JButton();
        jSeparator43 = new javax.swing.JToolBar.Separator();
        bCloseRENEWAL2 = new javax.swing.JButton();
        jSeparator44 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        bRevDetails = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRevenue = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jToolBar10 = new javax.swing.JToolBar();
        jSeparator42 = new javax.swing.JToolBar.Separator();
        bPDFRENEWAL3 = new javax.swing.JButton();
        jSeparator45 = new javax.swing.JToolBar.Separator();
        previewRENEWAL3 = new javax.swing.JButton();
        jSeparator46 = new javax.swing.JToolBar.Separator();
        bCloseRENEWAL3 = new javax.swing.JButton();
        jSeparator47 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        bHireRate = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblHireRate = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jToolBar14 = new javax.swing.JToolBar();
        jSeparator61 = new javax.swing.JToolBar.Separator();
        bPDFHireRate = new javax.swing.JButton();
        jSeparator62 = new javax.swing.JToolBar.Separator();
        previewHireRate = new javax.swing.JButton();
        jSeparator63 = new javax.swing.JToolBar.Separator();
        bCloseHireRate = new javax.swing.JButton();
        jSeparator64 = new javax.swing.JToolBar.Separator();

        setResizable(true);
        setTitle("FAS Reports");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basic_report.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1023, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 153));
        jTabbedPane2.setAutoscrolls(true);
        jTabbedPane2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBasic.setAutoCreateRowSorter(true);
        tblBasic.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblBasic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equip No", "Reg. No", "Make", "Class of Vehicle", "Model", "Chasis No", "Machine  SNo", "Engine SNo", "Capacity", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBasic.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblBasic.setRowHeight(22);
        tblBasic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBasicMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBasic);
        if (tblBasic.getColumnModel().getColumnCount() > 0) {
            tblBasic.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblBasic.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblBasic.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblBasic.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblBasic.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblBasic.getColumnModel().getColumn(6).setPreferredWidth(30);
            tblBasic.getColumnModel().getColumn(7).setPreferredWidth(30);
            tblBasic.getColumnModel().getColumn(8).setPreferredWidth(30);
            tblBasic.getColumnModel().getColumn(9).setPreferredWidth(20);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 990, 370));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 102));
        jLabel61.setText("RRC Equipment  No.");
        jPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        equipment_noSearchBASIC.setToolTipText("EX - 01");
        equipment_noSearchBASIC.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        equipment_noSearchBASIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                equipment_noSearchBASICKeyReleased(evt);
            }
        });
        jPanel2.add(equipment_noSearchBASIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 130, -1));

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.add(jSeparator4);

        bPDFBASIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFBASIC.setText("PDF");
        bPDFBASIC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFBASIC.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFBASIC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFBASICActionPerformed(evt);
            }
        });
        jToolBar2.add(bPDFBASIC);
        jToolBar2.add(jSeparator2);

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

        bCloseBASIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseBASIC.setText("Close");
        bCloseBASIC.setFocusable(false);
        bCloseBASIC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseBASIC.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseBASIC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseBASICActionPerformed(evt);
            }
        });
        jToolBar2.add(bCloseBASIC);
        jToolBar2.add(jSeparator8);

        jPanel2.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 450, 70));

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.add(jSeparator10);

        addtolistBASIC.setText("Add to List");
        addtolistBASIC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtolistBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtolistBASICActionPerformed(evt);
            }
        });
        jToolBar3.add(addtolistBASIC);
        jToolBar3.add(jSeparator7);

        removeselectedBASIC.setText("Remove ");
        removeselectedBASIC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeselectedBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeselectedBASICActionPerformed(evt);
            }
        });
        jToolBar3.add(removeselectedBASIC);
        jToolBar3.add(jSeparator9);

        removeallBASIC.setText("Remove All");
        removeallBASIC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeallBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallBASICActionPerformed(evt);
            }
        });
        jToolBar3.add(removeallBASIC);
        jToolBar3.add(jSeparator11);

        showallBASIC.setText("Show All");
        showallBASIC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showallBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showallBASICActionPerformed(evt);
            }
        });
        jToolBar3.add(showallBASIC);
        jToolBar3.add(jSeparator12);

        jPanel2.add(jToolBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 30));

        txtCount.setEditable(false);
        txtCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel2.add(txtCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 440, 60, 23));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setText("Count");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, 60, 23));

        jLayeredPane10.add(jPanel2);
        jPanel2.setBounds(0, 0, 1040, 520);

        jTabbedPane2.addTab("Basic Report", new javax.swing.ImageIcon(getClass().getResource("/images/basic_report.png")), jLayeredPane10); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableFILTER.setAutoCreateRowSorter(true);
        jTableFILTER.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equip No", "Class of Vehicle", "Model", "Lube Oil 1", "Lube Oil 2", "Fuel 1", "Fuel 2", "Fuel/Water Sep 1", "Fuel/Water Sep 2", "Hyd. Tank 1", "Hyd. Tank 2", "Hyd 1", "Hyd 2", "Trans. 1", "Trans. 2", "Air Primary", "Air Secondary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFILTER.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableFILTER.setRowHeight(20);
        jTableFILTER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFILTERMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableFILTER);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 990, 390));

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 102));
        jLabel62.setText("RRC Equipment  No.");
        jPanel3.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        equipment_noSearchFILTER.setToolTipText("EX - 01");
        equipment_noSearchFILTER.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        equipment_noSearchFILTER.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                equipment_noSearchFILTERKeyReleased(evt);
            }
        });
        jPanel3.add(equipment_noSearchFILTER, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 130, -1));

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);
        jToolBar4.add(jSeparator14);

        addtolistFILTER.setText("Add to List");
        addtolistFILTER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtolistFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtolistFILTERActionPerformed(evt);
            }
        });
        jToolBar4.add(addtolistFILTER);
        jToolBar4.add(jSeparator15);

        removeselectedFILTER.setText("Remove ");
        removeselectedFILTER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeselectedFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeselectedFILTERActionPerformed(evt);
            }
        });
        jToolBar4.add(removeselectedFILTER);
        jToolBar4.add(jSeparator16);

        removeallFILTER.setText("Remove All");
        removeallFILTER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeallFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallFILTERActionPerformed(evt);
            }
        });
        jToolBar4.add(removeallFILTER);
        jToolBar4.add(jSeparator17);

        showallFilter.setText("Show All");
        showallFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showallFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showallFilterActionPerformed(evt);
            }
        });
        jToolBar4.add(showallFilter);
        jToolBar4.add(jSeparator18);

        tblFilterFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblFilterFILTERActionPerformed(evt);
            }
        });
        jToolBar4.add(tblFilterFILTER);

        jPanel3.add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 30));

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);
        jToolBar5.add(jSeparator6);

        bPDFFILTER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFFILTER.setText("PDF");
        bPDFFILTER.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFFILTER.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFFILTER.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFFILTERActionPerformed(evt);
            }
        });
        jToolBar5.add(bPDFFILTER);
        jToolBar5.add(jSeparator20);

        printFILTER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printFILTER.setText("PRINT");
        printFILTER.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printFILTER.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printFILTER.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printFILTERActionPerformed(evt);
            }
        });
        jToolBar5.add(printFILTER);
        jToolBar5.add(jSeparator22);

        previewFILTER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewFILTER.setText("Preview");
        previewFILTER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewFILTER.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewFILTER.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewFILTER.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewFILTERActionPerformed(evt);
            }
        });
        jToolBar5.add(previewFILTER);
        jToolBar5.add(jSeparator23);

        bCloseFILTER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseFILTER.setText("Close");
        bCloseFILTER.setFocusable(false);
        bCloseFILTER.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseFILTER.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseFILTER.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseFILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseFILTERActionPerformed(evt);
            }
        });
        jToolBar5.add(bCloseFILTER);
        jToolBar5.add(jSeparator24);

        jPanel3.add(jToolBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 430, 70));

        jLayeredPane11.add(jPanel3);
        jPanel3.setBounds(0, 0, 1030, 520);

        jTabbedPane2.addTab("Filter Report", new javax.swing.ImageIcon(getClass().getResource("/images/ReportFilter.png")), jLayeredPane11); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRENEWAL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equip No", "Reg. No", "Insurance Company", "Insurance Certificate", "Ins. Expiry Date", "Revenue License", "Rev. Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRENEWAL.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableRENEWAL.setRowHeight(20);
        jTableRENEWAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRENEWALMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableRENEWAL);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 990, 360));

        SearchOrderToolbar.setFloatable(false);
        SearchOrderToolbar.setRollover(true);
        SearchOrderToolbar.setMargin(new java.awt.Insets(0, 2, 0, 2));

        jLabel13.setText("Search ");
        SearchOrderToolbar.add(jLabel13);

        searchBar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchBar.setMaximumSize(new java.awt.Dimension(150, 20));
        searchBar.setPreferredSize(new java.awt.Dimension(30, 20));
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });
        SearchOrderToolbar.add(searchBar);
        SearchOrderToolbar.add(jSeparator13);

        jLabel4.setText("  Search By ");
        SearchOrderToolbar.add(jLabel4);

        searchBarSortByCombo.setMaximumSize(new java.awt.Dimension(150, 20));
        searchBarSortByCombo.setPreferredSize(new java.awt.Dimension(28, 15));
        searchBarSortByCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarSortByComboActionPerformed(evt);
            }
        });
        SearchOrderToolbar.add(searchBarSortByCombo);
        SearchOrderToolbar.add(jSeparator19);

        jLabel6.setText("  Sort By ");
        SearchOrderToolbar.add(jLabel6);

        searchBarOrderByCombo.setMaximumSize(new java.awt.Dimension(150, 20));
        searchBarOrderByCombo.setPreferredSize(new java.awt.Dimension(28, 15));
        searchBarOrderByCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarOrderByComboActionPerformed(evt);
            }
        });
        SearchOrderToolbar.add(searchBarOrderByCombo);
        SearchOrderToolbar.add(jSeparator25);

        bClearAccountCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        bClearAccountCode.setToolTipText("Clear Selection");
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
        SearchOrderToolbar.add(bClearAccountCode);
        SearchOrderToolbar.add(jSeparator21);

        bShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh bw.gif"))); // NOI18N
        bShowAll.setToolTipText("Refresh Table");
        bShowAll.setFocusable(false);
        bShowAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowAll.setIconTextGap(1);
        bShowAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowAllActionPerformed(evt);
            }
        });
        SearchOrderToolbar.add(bShowAll);

        jPanel5.add(SearchOrderToolbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 30));

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);

        addtolistRENEWAL.setText("Add to List");
        addtolistRENEWAL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtolistRENEWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtolistRENEWALActionPerformed(evt);
            }
        });
        jToolBar6.add(addtolistRENEWAL);
        jToolBar6.add(jSeparator26);

        removeselectedRENEWAL.setText("Remove ");
        removeselectedRENEWAL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeselectedRENEWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeselectedRENEWALActionPerformed(evt);
            }
        });
        jToolBar6.add(removeselectedRENEWAL);
        jToolBar6.add(jSeparator27);

        removeallRENEWAL.setText("Remove All");
        removeallRENEWAL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeallRENEWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeallRENEWALActionPerformed(evt);
            }
        });
        jToolBar6.add(removeallRENEWAL);
        jToolBar6.add(jSeparator28);

        showallRenewal.setText("Show All");
        showallRenewal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showallRenewal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showallRenewalActionPerformed(evt);
            }
        });
        jToolBar6.add(showallRenewal);
        jToolBar6.add(jSeparator29);

        jPanel5.add(jToolBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 30));

        jToolBar7.setFloatable(false);
        jToolBar7.setRollover(true);
        jToolBar7.add(jSeparator31);

        bPDFRENEWAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFRENEWAL.setText("PDF");
        bPDFRENEWAL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFRENEWAL.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFRENEWAL.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFRENEWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFRENEWALActionPerformed(evt);
            }
        });
        jToolBar7.add(bPDFRENEWAL);
        jToolBar7.add(jSeparator32);

        printRENEWAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printRENEWAL.setText("PRINT");
        printRENEWAL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printRENEWAL.setMargin(new java.awt.Insets(2, 15, 2, 15));
        printRENEWAL.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printRENEWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printRENEWALActionPerformed(evt);
            }
        });
        jToolBar7.add(printRENEWAL);
        jToolBar7.add(jSeparator34);

        previewRENEWAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewRENEWAL.setText("Preview");
        previewRENEWAL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewRENEWAL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewRENEWAL.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewRENEWAL.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewRENEWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewRENEWALActionPerformed(evt);
            }
        });
        jToolBar7.add(previewRENEWAL);
        jToolBar7.add(jSeparator35);

        bCloseRENEWAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseRENEWAL.setText("Close");
        bCloseRENEWAL.setFocusable(false);
        bCloseRENEWAL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseRENEWAL.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseRENEWAL.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseRENEWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseRENEWALActionPerformed(evt);
            }
        });
        jToolBar7.add(bCloseRENEWAL);
        jToolBar7.add(jSeparator36);

        jPanel5.add(jToolBar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 350, 70));

        jLayeredPane2.add(jPanel5);
        jPanel5.setBounds(0, 0, 1020, 450);

        jTabbedPane1.addTab("Renewal Report", jLayeredPane2);

        jLayeredPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        bInsDetails.setText("Insurance Details");
        bInsDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsDetailsActionPerformed(evt);
            }
        });
        jLayeredPane4.add(bInsDetails);
        bInsDetails.setBounds(10, 0, 220, 70);

        tblInsurance.setAutoCreateRowSorter(true);
        tblInsurance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblInsurance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Registration No", "Insurance No", "Issue Date", "Exp. Date"
            }
        ));
        tblInsurance.setRowHeight(25);
        jScrollPane5.setViewportView(tblInsurance);
        if (tblInsurance.getColumnModel().getColumnCount() > 0) {
            tblInsurance.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblInsurance.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblInsurance.getColumnModel().getColumn(2).setPreferredWidth(140);
            tblInsurance.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblInsurance.getColumnModel().getColumn(4).setHeaderValue("Exp. Date");
        }

        jLayeredPane4.add(jScrollPane5);
        jScrollPane5.setBounds(10, 70, 970, 340);

        jToolBar8.setFloatable(false);
        jToolBar8.setRollover(true);
        jToolBar8.add(jSeparator33);

        bPDFRENEWAL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFRENEWAL1.setText("PDF");
        bPDFRENEWAL1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFRENEWAL1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFRENEWAL1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFRENEWAL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFRENEWAL1ActionPerformed(evt);
            }
        });
        jToolBar8.add(bPDFRENEWAL1);
        jToolBar8.add(jSeparator37);

        previewRENEWAL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewRENEWAL1.setText("Preview");
        previewRENEWAL1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewRENEWAL1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewRENEWAL1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewRENEWAL1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewRENEWAL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewRENEWAL1ActionPerformed(evt);
            }
        });
        jToolBar8.add(previewRENEWAL1);
        jToolBar8.add(jSeparator39);

        bCloseRENEWAL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseRENEWAL1.setText("Close");
        bCloseRENEWAL1.setFocusable(false);
        bCloseRENEWAL1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseRENEWAL1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseRENEWAL1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseRENEWAL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseRENEWAL1ActionPerformed(evt);
            }
        });
        jToolBar8.add(bCloseRENEWAL1);
        jToolBar8.add(jSeparator40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("This table contains equipment already expired and 30 days prior to expire ");
        jToolBar8.add(jLabel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 387, Short.MAX_VALUE))
        );

        jLayeredPane4.add(jPanel1);
        jPanel1.setBounds(0, 0, 1030, 450);

        jTabbedPane3.addTab("Insurance Details", jLayeredPane4);

        bVETDetails.setText("VET Details");
        bVETDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVETDetailsActionPerformed(evt);
            }
        });
        jLayeredPane5.add(bVETDetails);
        bVETDetails.setBounds(10, 0, 220, 70);

        tblVET.setAutoCreateRowSorter(true);
        tblVET.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblVET.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Registration No.", "Vet No", "Issue Date", "Exp. Date"
            }
        ));
        tblVET.setRowHeight(25);
        jScrollPane3.setViewportView(tblVET);

        jLayeredPane5.add(jScrollPane3);
        jScrollPane3.setBounds(10, 70, 970, 340);

        jToolBar9.setFloatable(false);
        jToolBar9.setRollover(true);
        jToolBar9.add(jSeparator38);

        bPDFRENEWAL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFRENEWAL2.setText("PDF");
        bPDFRENEWAL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFRENEWAL2.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFRENEWAL2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFRENEWAL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFRENEWAL2ActionPerformed(evt);
            }
        });
        jToolBar9.add(bPDFRENEWAL2);
        jToolBar9.add(jSeparator41);

        previewRENEWAL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewRENEWAL2.setText("Preview");
        previewRENEWAL2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewRENEWAL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewRENEWAL2.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewRENEWAL2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewRENEWAL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewRENEWAL2ActionPerformed(evt);
            }
        });
        jToolBar9.add(previewRENEWAL2);
        jToolBar9.add(jSeparator43);

        bCloseRENEWAL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseRENEWAL2.setText("Close");
        bCloseRENEWAL2.setFocusable(false);
        bCloseRENEWAL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseRENEWAL2.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseRENEWAL2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseRENEWAL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseRENEWAL2ActionPerformed(evt);
            }
        });
        jToolBar9.add(bCloseRENEWAL2);
        jToolBar9.add(jSeparator44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("This table contains equipment already expired and 30 days prior to expire ");
        jToolBar9.add(jLabel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jToolBar9, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 387, Short.MAX_VALUE))
        );

        jLayeredPane5.add(jPanel4);
        jPanel4.setBounds(0, 0, 1070, 450);

        jTabbedPane3.addTab("VET Details", jLayeredPane5);

        bRevDetails.setText("Revenue Details");
        bRevDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRevDetailsActionPerformed(evt);
            }
        });
        jLayeredPane6.add(bRevDetails);
        bRevDetails.setBounds(10, 0, 220, 70);

        tblRevenue.setAutoCreateRowSorter(true);
        tblRevenue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblRevenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Registration No.", "Rev No", "Issue Date", "Exp. Date"
            }
        ));
        tblRevenue.setRowHeight(25);
        jScrollPane6.setViewportView(tblRevenue);

        jLayeredPane6.add(jScrollPane6);
        jScrollPane6.setBounds(10, 70, 970, 340);

        jToolBar10.setFloatable(false);
        jToolBar10.setRollover(true);
        jToolBar10.add(jSeparator42);

        bPDFRENEWAL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFRENEWAL3.setText("PDF");
        bPDFRENEWAL3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFRENEWAL3.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFRENEWAL3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFRENEWAL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFRENEWAL3ActionPerformed(evt);
            }
        });
        jToolBar10.add(bPDFRENEWAL3);
        jToolBar10.add(jSeparator45);

        previewRENEWAL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewRENEWAL3.setText("Preview");
        previewRENEWAL3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewRENEWAL3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewRENEWAL3.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewRENEWAL3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewRENEWAL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewRENEWAL3ActionPerformed(evt);
            }
        });
        jToolBar10.add(previewRENEWAL3);
        jToolBar10.add(jSeparator46);

        bCloseRENEWAL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseRENEWAL3.setText("Close");
        bCloseRENEWAL3.setFocusable(false);
        bCloseRENEWAL3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseRENEWAL3.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseRENEWAL3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseRENEWAL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseRENEWAL3ActionPerformed(evt);
            }
        });
        jToolBar10.add(bCloseRENEWAL3);
        jToolBar10.add(jSeparator47);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("This table contains equipment already expired and 30 days prior to expire ");
        jToolBar10.add(jLabel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jToolBar10, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLayeredPane6.add(jPanel6);
        jPanel6.setBounds(0, 0, 1030, 440);

        jTabbedPane3.addTab("Revenue Details", jLayeredPane6);

        jLayeredPane1.add(jTabbedPane3);
        jTabbedPane3.setBounds(0, 0, 1000, 450);

        jTabbedPane1.addTab("Renewal Expiry Report", jLayeredPane1);

        jLayeredPane13.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1010, 480);

        jTabbedPane2.addTab("Renewal Report", new javax.swing.ImageIcon(getClass().getResource("/images/ReportRemarks.png")), jLayeredPane13); // NOI18N

        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLayeredPane9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        bHireRate.setText("Hire Rate");
        bHireRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHireRateActionPerformed(evt);
            }
        });
        jLayeredPane9.add(bHireRate);
        bHireRate.setBounds(10, 0, 220, 70);

        tblHireRate.setAutoCreateRowSorter(true);
        tblHireRate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHireRate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment No", "Class Of Vehicle", "Registration No", "Machine Model", "Machine Serial", "Engine Details", "Hire Rate"
            }
        ));
        tblHireRate.setRowHeight(25);
        jScrollPane8.setViewportView(tblHireRate);
        if (tblHireRate.getColumnModel().getColumnCount() > 0) {
            tblHireRate.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblHireRate.getColumnModel().getColumn(1).setPreferredWidth(140);
            tblHireRate.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblHireRate.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblHireRate.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHireRate.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblHireRate.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        jLayeredPane9.add(jScrollPane8);
        jScrollPane8.setBounds(10, 70, 970, 370);

        jToolBar14.setFloatable(false);
        jToolBar14.setRollover(true);
        jToolBar14.add(jSeparator61);

        bPDFHireRate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFHireRate.setText("PDF");
        bPDFHireRate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFHireRate.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFHireRate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFHireRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFRENEWAL5ActionPerformed(evt);
            }
        });
        jToolBar14.add(bPDFHireRate);
        jToolBar14.add(jSeparator62);

        previewHireRate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewHireRate.setText("Preview");
        previewHireRate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previewHireRate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewHireRate.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewHireRate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewHireRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewRENEWAL5ActionPerformed(evt);
            }
        });
        jToolBar14.add(previewHireRate);
        jToolBar14.add(jSeparator63);

        bCloseHireRate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bCloseHireRate.setText("Close");
        bCloseHireRate.setFocusable(false);
        bCloseHireRate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCloseHireRate.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bCloseHireRate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCloseHireRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseRENEWAL5ActionPerformed(evt);
            }
        });
        jToolBar14.add(bCloseHireRate);
        jToolBar14.add(jSeparator64);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jToolBar14, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jToolBar14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 387, Short.MAX_VALUE))
        );

        jLayeredPane9.add(jPanel9);
        jPanel9.setBounds(0, 0, 1030, 450);

        jTabbedPane5.addTab("Hire Rate", jLayeredPane9);

        jTabbedPane2.addTab("Hire Rate", new javax.swing.ImageIcon(getClass().getResource("/images/hireRate.png")), jTabbedPane5); // NOI18N
        jTabbedPane5.getAccessibleContext().setAccessibleName("Hire Rate");

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCloseBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseBASICActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseBASICActionPerformed

    private void bCloseFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseFILTERActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseFILTERActionPerformed

    private void bCloseRENEWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseRENEWALActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseRENEWALActionPerformed

    private void addtolistBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtolistBASICActionPerformed
        try {
            String EquipNo = equipment_noSearchBASIC.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no='" + EquipNo + "'");
            DefaultTableModel dtm = (DefaultTableModel) tblBasic.getModel();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(equipment_noSearchBASIC.getText());
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("machine_make"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("machine_chasis"));
                v.add(rs.getString("machine_serial"));
                v.add(rs.getString("engine_serial"));
                v.add(rs.getString("machine_capacity"));
                v.add(rs.getString("location"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        equipment_noSearchBASIC.setText("");
        equipment_noSearchBASIC.grabFocus();
    }//GEN-LAST:event_addtolistBASICActionPerformed

    private void removeselectedBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeselectedBASICActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblBasic.getModel();
        int numRows = tblBasic.getSelectedRows().length;
        for (int i = 0; i < numRows; i++) {
            dtm.removeRow(tblBasic.getSelectedRow());
        }
        equipment_noSearchBASIC.getText();
        equipment_noSearchBASIC.grabFocus();
    }//GEN-LAST:event_removeselectedBASICActionPerformed

    private void removeallBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallBASICActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblBasic.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_removeallBASICActionPerformed

    private void showallBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showallBASICActionPerformed
        showallBASICActionPerformed();
        DefaultTableModel dtm = (DefaultTableModel) tblBasic.getModel();
        int rowCount = dtm.getRowCount();
        txtCount.setText(String.valueOf(rowCount));
    }//GEN-LAST:event_showallBASICActionPerformed

    private void equipment_noSearchBASICKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_equipment_noSearchBASICKeyReleased
        String s1 = equipment_noSearchBASIC.getText();
        String s2 = s1.toUpperCase();
        equipment_noSearchBASIC.setText(s2);
        try {
            String EquipNo = equipment_noSearchBASIC.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no LIKE '" + EquipNo + "%'AND location != 'SOLD' ORDER BY equipment_no ASC ");
            DefaultTableModel dtm = (DefaultTableModel) tblBasic.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("machine_make"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("machine_chasis"));
                v.add(rs.getString("machine_serial"));
                v.add(rs.getString("engine_serial"));
                v.add(rs.getString("machine_capacity"));
                v.add(rs.getString("location"));
                dtm.addRow(v);
                int rowCount = dtm.getRowCount();
                txtCount.setText(String.valueOf(rowCount));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_equipment_noSearchBASICKeyReleased

    private void tblBasicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBasicMouseClicked
        int i = tblBasic.getSelectedRow();
        JTable dtm = (JTable) evt.getSource();
        String t5 = dtm.getValueAt(i, 0).toString();
        equipment_noSearchBASIC.setText(t5);
    }//GEN-LAST:event_tblBasicMouseClicked

    private void previewBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBASICActionPerformed
        try {
            TableModel model = (TableModel) tblBasic.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "rr.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("FAS Basic Report");
            jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (JRException jRException) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_previewBASICActionPerformed

    private void bPDFFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFFILTERActionPerformed
        try {
            TableModel model = (TableModel) jTableFILTER.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "rr_2.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            String path = settings.pdfpath + "FAS Reports\\" + "FILTER_" + d + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
            JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
            File file = new File(path);
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            try {
                desktop.open(file);
            } catch (IOException e) {
            }
        } catch (JRException jRException) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bPDFFILTERActionPerformed

    private void printFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printFILTERActionPerformed
        try {
            TableModel model = (TableModel) jTableFILTER.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "rr_2.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printFILTERActionPerformed

    private void previewFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewFILTERActionPerformed
        try {
            TableModel model = (TableModel) jTableFILTER.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "rr_2.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("FAS Filter Report");
            jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (JRException jRException) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_previewFILTERActionPerformed

    private void equipment_noSearchFILTERKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_equipment_noSearchFILTERKeyReleased
        String s1 = equipment_noSearchFILTER.getText();
        String s2 = s1.toUpperCase();
        equipment_noSearchFILTER.setText(s2);
        try {
            String EquipNo = equipment_noSearchFILTER.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no LIKE '" + EquipNo + "%' ORDER BY equipment_no ASC ");
            DefaultTableModel dtm = (DefaultTableModel) jTableFILTER.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("filter_oil"));
                v.add(rs.getString("filter_oil2"));
                v.add(rs.getString("filter_fuel"));
                v.add(rs.getString("filter_fuel2"));
                v.add(rs.getString("filter_sep"));
                v.add(rs.getString("filter_sep2"));
                v.add(rs.getString("filter_hyd_tank"));
                v.add(rs.getString("filter_hyd_tank2"));
                v.add(rs.getString("filter_hyd"));
                v.add(rs.getString("filter_hyd2"));
                v.add(rs.getString("filter_trans"));
                v.add(rs.getString("filter_trans2"));
                v.add(rs.getString("filter_airp"));
                v.add(rs.getString("filter_airs"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_equipment_noSearchFILTERKeyReleased

    private void jTableFILTERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFILTERMouseClicked
        int i = jTableFILTER.getSelectedRow();
        JTable dtm = (JTable) evt.getSource();
        String t5 = dtm.getValueAt(i, 0).toString();
        equipment_noSearchFILTER.setText(t5);
    }//GEN-LAST:event_jTableFILTERMouseClicked

    private void addtolistRENEWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtolistRENEWALActionPerformed
        try {
            String EquipNo = searchBar.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no='" + EquipNo + "'");
            DefaultTableModel dtm = (DefaultTableModel) jTableRENEWAL.getModel();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(searchBar.getText());
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("insurance_company"));
                v.add(rs.getString("insurance_no"));
                v.add(rs.getString("insurance_exp"));
                v.add(rs.getString("veh_rev_no"));
                v.add(rs.getString("veh_rev_exp"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        searchBar.setText("");
        searchBar.grabFocus();
    }//GEN-LAST:event_addtolistRENEWALActionPerformed

    private void removeselectedRENEWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeselectedRENEWALActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableRENEWAL.getModel();
        int numRows = jTableRENEWAL.getSelectedRows().length;
        for (int i = 0; i < numRows; i++) {
            dtm.removeRow(jTableRENEWAL.getSelectedRow());
        }
        searchBar.getText();
        searchBar.grabFocus();
    }//GEN-LAST:event_removeselectedRENEWALActionPerformed

    private void removeallRENEWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallRENEWALActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableRENEWAL.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_removeallRENEWALActionPerformed

    private void showallRenewalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showallRenewalActionPerformed
        showallRenewalActionPerformed();
    }//GEN-LAST:event_showallRenewalActionPerformed

    private void bPDFRENEWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFRENEWALActionPerformed
        try {
            TableModel model = (TableModel) jTableRENEWAL.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "rr_3.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            String path = settings.pdfpath + "FAS Reports\\" + "RENEWAL_" + d + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
            JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
            File file = new File(path);
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            try {
                desktop.open(file);
            } catch (IOException e) {
            }
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(fas_reports.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_bPDFRENEWALActionPerformed

    private void printRENEWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printRENEWALActionPerformed
        try {
            TableModel model = (TableModel) jTableRENEWAL.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "rr_3.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printRENEWALActionPerformed

    private void previewRENEWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewRENEWALActionPerformed
        try {
            TableModel model = (TableModel) jTableRENEWAL.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "rr_3.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("FAS Renewal Report");
            jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (JRException jRException) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException, "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_previewRENEWALActionPerformed

    private void jTableRENEWALMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRENEWALMouseClicked
        int i = jTableRENEWAL.getSelectedRow();
        JTable dtm = (JTable) evt.getSource();
        String t5 = dtm.getValueAt(i, 0).toString();
        searchBar.setText(t5);
    }//GEN-LAST:event_jTableRENEWALMouseClicked

private void bInsDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsDetailsActionPerformed
    bInsDetailsActionPerformed();
}//GEN-LAST:event_bInsDetailsActionPerformed

private void bVETDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVETDetailsActionPerformed
    bVETDetailsActionPerformed();
}//GEN-LAST:event_bVETDetailsActionPerformed

private void bRevDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRevDetailsActionPerformed
    bRevDetailsActionPerformed();
}//GEN-LAST:event_bRevDetailsActionPerformed

private void printBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBASICActionPerformed
    try {
        TableModel model = (TableModel) tblBasic.getModel();
        JRTableModelDataSource datasource = new JRTableModelDataSource(model);
        String reportSource = settings.filepath + "rr.jrxml";
        Map<String, Object> params = new HashMap<String, Object>();
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
        JasperPrintManager.printReport(jasperPrint, true);
    } catch (Exception exception) {
        JOptionPane.showMessageDialog(null, "  ERROR  " + exception, "Error", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_printBASICActionPerformed

private void bPDFBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFBASICActionPerformed
    try {
        TableModel model = (TableModel) tblBasic.getModel();
        JRTableModelDataSource datasource = new JRTableModelDataSource(model);
        String reportSource = settings.filepath + "rr.jrxml";
        Map<String, Object> params = new HashMap<String, Object>();
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
        String path = settings.pdfpath + "FAS Reports\\" + "BASIC_" + d + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, path);
        JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
        File file = new File(path);
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(file);
        } catch (IOException e) {
        }
    } catch (JRException jRException) {
        JOptionPane.showMessageDialog(null, "  ERROR  " + jRException, "Error", JOptionPane.ERROR_MESSAGE);
    }

}//GEN-LAST:event_bPDFBASICActionPerformed

    private void bPDFRENEWAL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFRENEWAL1ActionPerformed
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, +30);
        Date today30 = cal.getTime();
        String day30 = formatter.format(today30.getTime());
        try {
            String reportSource = settings.filepath + "renewal_Report_Insurance.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("30day", today30);
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            Connection c = DBControl.getServerDB_Connection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
            String path = settings.pdfpath + "Renewal Reports\\" + "Insurance_Renewal_" + day30 + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
            JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
            File file = new File(path);
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            try {
                desktop.open(file);
            } catch (IOException e) {
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }//GEN-LAST:event_bPDFRENEWAL1ActionPerformed

    private void previewRENEWAL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewRENEWAL1ActionPerformed
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, +30);
        Date today30 = cal.getTime();
        String day30 = formatter.format(today30.getTime());
        try {
            String reportSource = settings.filepath + "renewal_Report_Insurance.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("30day", today30);
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            Connection c = DBControl.getServerDB_Connection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("Insurance Renewal Report [ " + day30 + " ]");
            jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }//GEN-LAST:event_previewRENEWAL1ActionPerformed

    private void bCloseRENEWAL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseRENEWAL1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseRENEWAL1ActionPerformed

    private void bPDFRENEWAL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFRENEWAL2ActionPerformed
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, +30);
        Date today30 = cal.getTime();
        String day30 = formatter.format(today30.getTime());
        try {
            String reportSource = settings.filepath + "renewal_Report_VET.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("30day", today30);
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            Connection c = DBControl.getServerDB_Connection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
            String path = settings.pdfpath + "Renewal Reports\\" + "VET_Renewal_" + day30 + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
            JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
            File file = new File(path);
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            try {
                desktop.open(file);
            } catch (IOException e) {
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }//GEN-LAST:event_bPDFRENEWAL2ActionPerformed

    private void previewRENEWAL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewRENEWAL2ActionPerformed
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, +30);
        Date today30 = cal.getTime();
        String day30 = formatter.format(today30.getTime());
        try {
            String reportSource = settings.filepath + "renewal_Report_VET.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("30day", today30);
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            Connection c = DBControl.getServerDB_Connection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("VET Renewal Report [ " + day30 + " ]");
            jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }//GEN-LAST:event_previewRENEWAL2ActionPerformed

    private void bCloseRENEWAL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseRENEWAL2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseRENEWAL2ActionPerformed

    private void bPDFRENEWAL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFRENEWAL3ActionPerformed
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, +30);
        Date today30 = cal.getTime();
        String day30 = formatter.format(today30.getTime());
        try {
            String reportSource = settings.filepath + "renewal_Report_Revenue.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("30day", today30);
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            Connection c = DBControl.getServerDB_Connection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
            String path = settings.pdfpath + "Renewal Reports\\" + "Revenue_Renewal_" + day30 + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
            JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
            File file = new File(path);
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            try {
                desktop.open(file);
            } catch (IOException e) {
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }//GEN-LAST:event_bPDFRENEWAL3ActionPerformed

    private void previewRENEWAL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewRENEWAL3ActionPerformed
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, +30);
        Date today30 = cal.getTime();
        String day30 = formatter.format(today30.getTime());
        try {
            String reportSource = settings.filepath + "renewal_Report_Revenue.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("30day", today30);
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            Connection c = DBControl.getServerDB_Connection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("Revenue Renewal Report [ " + day30 + " ]");
            jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            Main.errorDisplay(ex);
        }
    }//GEN-LAST:event_previewRENEWAL3ActionPerformed

    private void bCloseRENEWAL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseRENEWAL3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bCloseRENEWAL3ActionPerformed

    private void tblFilterFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblFilterFILTERActionPerformed
        try {
            String EquipNo = equipment_noSearchFILTER.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no LIKE '" + EquipNo + "%' ORDER BY equipment_no ASC ");
            DefaultTableModel dtm = (DefaultTableModel) jTableFILTER.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("filter_oil"));
                v.add(rs.getString("filter_oil2"));
                v.add(rs.getString("filter_fuel"));
                v.add(rs.getString("filter_fuel2"));
                v.add(rs.getString("filter_sep"));
                v.add(rs.getString("filter_sep2"));
                v.add(rs.getString("filter_hyd_tank"));
                v.add(rs.getString("filter_hyd_tank2"));
                v.add(rs.getString("filter_hyd"));
                v.add(rs.getString("filter_hyd2"));
                v.add(rs.getString("filter_trans"));
                v.add(rs.getString("filter_trans2"));
                v.add(rs.getString("filter_airp"));
                v.add(rs.getString("filter_airs"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        TableModel model = (TableModel) jTableFILTER.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jTableFILTER.setRowSorter(sorter);
    }//GEN-LAST:event_tblFilterFILTERActionPerformed

    private void showallFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showallFilterActionPerformed
        showallFilterActionPerformed();
    }//GEN-LAST:event_showallFilterActionPerformed

    private void removeallFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeallFILTERActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableFILTER.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_removeallFILTERActionPerformed

    private void removeselectedFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeselectedFILTERActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableFILTER.getModel();
        int numRows = jTableFILTER.getSelectedRows().length;
        for (int i = 0; i < numRows; i++) {
            dtm.removeRow(jTableFILTER.getSelectedRow());
        }
        equipment_noSearchFILTER.getText();
        equipment_noSearchFILTER.grabFocus();
    }//GEN-LAST:event_removeselectedFILTERActionPerformed

    private void addtolistFILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtolistFILTERActionPerformed
        try {
            String EquipNo = equipment_noSearchFILTER.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no='" + EquipNo + "'");
            DefaultTableModel dtm = (DefaultTableModel) jTableFILTER.getModel();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(equipment_noSearchFILTER.getText());
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("filter_oil"));
                v.add(rs.getString("filter_oil2"));
                v.add(rs.getString("filter_fuel"));
                v.add(rs.getString("filter_fuel2"));
                v.add(rs.getString("filter_sep"));
                v.add(rs.getString("filter_sep2"));
                v.add(rs.getString("filter_hyd_tank"));
                v.add(rs.getString("filter_hyd_tank2"));
                v.add(rs.getString("filter_hyd"));
                v.add(rs.getString("filter_hyd2"));
                v.add(rs.getString("filter_trans"));
                v.add(rs.getString("filter_trans2"));
                v.add(rs.getString("filter_airp"));
                v.add(rs.getString("filter_airs"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        equipment_noSearchFILTER.setText("");
        equipment_noSearchFILTER.grabFocus();
    }//GEN-LAST:event_addtolistFILTERActionPerformed

    private void bCloseRENEWAL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseRENEWAL5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCloseRENEWAL5ActionPerformed

    private void previewRENEWAL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewRENEWAL5ActionPerformed
        try {
            TableModel model = (TableModel) tblHireRate.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "fas_hireRate.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("FAS Hire Rate Report");
            jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (JRException jRException) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_previewRENEWAL5ActionPerformed

    private void bPDFRENEWAL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFRENEWAL5ActionPerformed
        try {
            TableModel model = (TableModel) tblHireRate.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = settings.filepath + "fas_hireRate.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            String path = settings.pdfpath + "FAS Reports\\" + "HireRate_" + d + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
            JOptionPane.showMessageDialog(null, "PDF File Successfully Created in your SCM Reports folder" + "\n(" + path + ")");
            File file = new File(path);
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            try {
                desktop.open(file);
            } catch (IOException e) {
            }
        } catch (JRException jRException) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + jRException, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bPDFRENEWAL5ActionPerformed

    private void bHireRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHireRateActionPerformed
        hireRate();
    }//GEN-LAST:event_bHireRateActionPerformed

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        searchBar.setText(searchBar.getText().toUpperCase());
        searchRenewal();
    }//GEN-LAST:event_searchBarKeyReleased

    private void bClearAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearAccountCodeActionPerformed
        loadList.clearSearchBar(searchBar, searchBarSortByCombo, jTableRENEWAL);
    }//GEN-LAST:event_bClearAccountCodeActionPerformed

    private void bShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowAllActionPerformed
        showallRenewalActionPerformed();
    }//GEN-LAST:event_bShowAllActionPerformed

    private void searchBarOrderByComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarOrderByComboActionPerformed
        searchRenewal();
    }//GEN-LAST:event_searchBarOrderByComboActionPerformed

    private void searchBarSortByComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarSortByComboActionPerformed
        searchRenewal();
    }//GEN-LAST:event_searchBarSortByComboActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar SearchOrderToolbar;
    private javax.swing.JButton addtolistBASIC;
    private javax.swing.JButton addtolistFILTER;
    private javax.swing.JButton addtolistRENEWAL;
    private javax.swing.JButton bClearAccountCode;
    private javax.swing.JButton bCloseBASIC;
    private javax.swing.JButton bCloseFILTER;
    private javax.swing.JButton bCloseHireRate;
    private javax.swing.JButton bCloseRENEWAL;
    private javax.swing.JButton bCloseRENEWAL1;
    private javax.swing.JButton bCloseRENEWAL2;
    private javax.swing.JButton bCloseRENEWAL3;
    private javax.swing.JButton bHireRate;
    private javax.swing.JButton bInsDetails;
    private javax.swing.JButton bPDFBASIC;
    private javax.swing.JButton bPDFFILTER;
    private javax.swing.JButton bPDFHireRate;
    private javax.swing.JButton bPDFRENEWAL;
    private javax.swing.JButton bPDFRENEWAL1;
    private javax.swing.JButton bPDFRENEWAL2;
    private javax.swing.JButton bPDFRENEWAL3;
    private javax.swing.JButton bRevDetails;
    private javax.swing.JButton bShowAll;
    private javax.swing.JButton bVETDetails;
    private javax.swing.JFormattedTextField equipment_noSearchBASIC;
    private javax.swing.JFormattedTextField equipment_noSearchFILTER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane11;
    private javax.swing.JLayeredPane jLayeredPane13;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator2;
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
    private javax.swing.JToolBar.Separator jSeparator31;
    private javax.swing.JToolBar.Separator jSeparator32;
    private javax.swing.JToolBar.Separator jSeparator33;
    private javax.swing.JToolBar.Separator jSeparator34;
    private javax.swing.JToolBar.Separator jSeparator35;
    private javax.swing.JToolBar.Separator jSeparator36;
    private javax.swing.JToolBar.Separator jSeparator37;
    private javax.swing.JToolBar.Separator jSeparator38;
    private javax.swing.JToolBar.Separator jSeparator39;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator40;
    private javax.swing.JToolBar.Separator jSeparator41;
    private javax.swing.JToolBar.Separator jSeparator42;
    private javax.swing.JToolBar.Separator jSeparator43;
    private javax.swing.JToolBar.Separator jSeparator44;
    private javax.swing.JToolBar.Separator jSeparator45;
    private javax.swing.JToolBar.Separator jSeparator46;
    private javax.swing.JToolBar.Separator jSeparator47;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator61;
    private javax.swing.JToolBar.Separator jSeparator62;
    private javax.swing.JToolBar.Separator jSeparator63;
    private javax.swing.JToolBar.Separator jSeparator64;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTableFILTER;
    private javax.swing.JTable jTableRENEWAL;
    private javax.swing.JToolBar jToolBar10;
    private javax.swing.JToolBar jToolBar14;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JToolBar jToolBar9;
    private javax.swing.JButton previewBASIC;
    private javax.swing.JButton previewFILTER;
    private javax.swing.JButton previewHireRate;
    private javax.swing.JButton previewRENEWAL;
    private javax.swing.JButton previewRENEWAL1;
    private javax.swing.JButton previewRENEWAL2;
    private javax.swing.JButton previewRENEWAL3;
    private javax.swing.JButton printBASIC;
    private javax.swing.JButton printFILTER;
    private javax.swing.JButton printRENEWAL;
    private javax.swing.JButton removeallBASIC;
    private javax.swing.JButton removeallFILTER;
    private javax.swing.JButton removeallRENEWAL;
    private javax.swing.JButton removeselectedBASIC;
    private javax.swing.JButton removeselectedFILTER;
    private javax.swing.JButton removeselectedRENEWAL;
    private javax.swing.JTextField searchBar;
    private javax.swing.JComboBox searchBarOrderByCombo;
    private javax.swing.JComboBox searchBarSortByCombo;
    private javax.swing.JButton showallBASIC;
    private javax.swing.JButton showallFilter;
    private javax.swing.JButton showallRenewal;
    private javax.swing.JTable tblBasic;
    private javax.swing.JButton tblFilterFILTER;
    private javax.swing.JTable tblHireRate;
    private javax.swing.JTable tblInsurance;
    private javax.swing.JTable tblRevenue;
    private javax.swing.JTable tblVET;
    private javax.swing.JTextField txtCount;
    // End of variables declaration//GEN-END:variables

    public void bRevDetailsActionPerformed() {
        try {
            Date today = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_MONTH, +30);
            Date today30 = cal.getTime();
            String day30 = formatter.format(today30.getTime());
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE '" + day30 + "' > veh_rev_exp AND veh_rev_exp != '" + nul + "' ORDER BY veh_rev_exp");
            DefaultTableModel dtm = (DefaultTableModel) tblRevenue.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("veh_rev_no"));
                v.add(rs.getString("veh_rev_issue"));
                v.add(rs.getString("veh_rev_exp"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(fas_reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bVETDetailsActionPerformed() {
        try {
            Date today = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_MONTH, +30);
            Date today30 = cal.getTime();
            String day30 = formatter.format(today30.getTime());
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE '" + day30 + "' > vet_cert_exp AND vet_cert_exp != '" + nul + "' ORDER BY vet_cert_exp");
            DefaultTableModel dtm = (DefaultTableModel) tblVET.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("vet_cert_no"));
                v.add(rs.getString("vet_cert_issue"));
                v.add(rs.getString("vet_cert_exp"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(fas_reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bInsDetailsActionPerformed() {
        try {
            Date today = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_MONTH, +30);
            Date today30 = cal.getTime();
            String day30 = formatter.format(today30.getTime());
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE '" + day30 + "' > insurance_exp AND insurance_exp != '" + nul + "' ORDER BY insurance_exp");
            DefaultTableModel dtm = (DefaultTableModel) tblInsurance.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("insurance_no"));
                v.add(rs.getString("insurance_issue"));
                v.add(rs.getString("insurance_exp"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
        }
    }

    public void showallBASICActionPerformed() {
        try {
            //OR location != 'SCRAP' 
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE location != 'SOLD' AND location != 'SCRAP' ORDER BY equipment_no ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblBasic.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("machine_make"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("machine_chasis"));
                v.add(rs.getString("machine_serial"));
                v.add(rs.getString("engine_serial"));
                v.add(rs.getString("machine_capacity"));
                v.add(rs.getString("location"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }

    public void showallFilterActionPerformed() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE location != 'SOLD' AND location != 'SCRAP' ORDER BY equipment_no ASC ");
            DefaultTableModel dtm = (DefaultTableModel) jTableFILTER.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("filter_oil"));
                v.add(rs.getString("filter_oil2"));
                v.add(rs.getString("filter_fuel"));
                v.add(rs.getString("filter_fuel2"));
                v.add(rs.getString("filter_sep"));
                v.add(rs.getString("filter_sep2"));
                v.add(rs.getString("filter_hyd_tank"));
                v.add(rs.getString("filter_hyd_tank2"));
                v.add(rs.getString("filter_hyd"));
                v.add(rs.getString("filter_hyd2"));
                v.add(rs.getString("filter_trans"));
                v.add(rs.getString("filter_trans2"));
                v.add(rs.getString("filter_airp"));
                v.add(rs.getString("filter_airs"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
//        TableModel model = (TableModel) jTableFILTER.getModel();
//        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
//        jTableFILTER.setRowSorter(sorter);
    }

    public void showallRenewalActionPerformed() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE location != 'SOLD' AND location != 'SCRAP' ORDER BY equipment_no ASC ");
            DefaultTableModel dtm = (DefaultTableModel) jTableRENEWAL.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("insurance_company"));
                v.add(rs.getString("insurance_no"));
                v.add(rs.getString("insurance_exp"));
                v.add(rs.getString("veh_rev_no"));
                v.add(rs.getString("veh_rev_exp"));
                dtm.addRow(v);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "  ERROR  " + ex);
        }
    }

    private void hireRate() {
        try {
            String nul = "";
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE hirerate != '" + nul + "' ORDER BY equipment_no");
            DefaultTableModel dtm = (DefaultTableModel) tblHireRate.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("equipment_no"));
                v.add(rs.getString("class_vehicle"));
                v.add(rs.getString("registration_no"));
                v.add(rs.getString("machine_serial"));
                v.add(rs.getString("machine_model"));
                v.add(rs.getString("engine_serial"));
                v.add(rs.getString("hirerate"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(fas_reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchRenewal() {
        String comboSortByText = searchBarSortByCombo.getSelectedItem().toString();
        String comboOrderByText = searchBarOrderByCombo.getSelectedItem().toString();
        System.out.println(comboSortByText);
        String sql = "SELECT " + FAS_Renewal_SQL + " FROM fas_details "
                + "WHERE  " + comboSortByText + " LIKE '" + searchBar.getText() + "%' "
                + "ORDER BY " + comboOrderByText + "  ASC ";
        loadList.searchToolbar(jTableRENEWAL, sql, "Supplier");
    }
}
