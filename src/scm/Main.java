package scm;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import scm.accountCenter.new_account;
import scm.database.DBControl;
import scm.fas.entry_details;
import scm.fas.fas_reports;
import scm.fas.new_fas;
import scm.grn.grn_list;
import scm.grn.new_grn;
import scm.grn.new_grn_project_detail;
import scm.grn.new_grn_return;
import scm.help.about;
import scm.help.settings;
import scm.help.user_accounts;
import scm.issue.issue_list;
import scm.issue.new_issue;
import scm.issue.new_issue_direct_return;
import scm.issue.new_issue_return;
import scm.purchaseOrder.*;
import scm.stock.*;
import scm.supplier.new_supplier;
import scm.supplier.supplier_list;
import scm.utils.Permission;
import scm.utils.systemTray;

public class Main extends JFrame {

    //Stock
    public static new_stock ns = new new_stock();
    public stock_details sd = new stock_details();
    public stock_list stocklist = new stock_list();
    public stock_valuation stockval = new stock_valuation();
    public static new_stock_category nsc = new new_stock_category();
    public static new_stock_plant nsp = new new_stock_plant();
    public static new_uom newuom = new new_uom();
    //Account
    public new_account na = new new_account();
    //FAS
    public new_fas nf = new new_fas();
    public static fas_reports fasrep = new fas_reports();
    public entry_details ed = new entry_details();
    //PO
    public static new_po po = new new_po();
    public static view_po pv = new view_po();
    public po_list pl = new po_list();
    public static new_po_delivery_term pd = new new_po_delivery_term();
    public static new_po_payment_term pp = new new_po_payment_term();
    public static new_po_project_detail pr = new new_po_project_detail();
    public static new_po_bill_to pb = new new_po_bill_to();
    public static new_po_deliver_to pt = new new_po_deliver_to();
    public static new_po_vat_no po_vat = new new_po_vat_no();
    //GRN
    public static new_grn ng = new new_grn();
    public grn_list gl = new grn_list();
    public static new_grn_return gr = new new_grn_return();
    public static new_grn_project_detail gp = new new_grn_project_detail();
    //Issue
    public static new_issue ni = new new_issue();
    public issue_list il = new issue_list();
    public static new_issue_return ir = new new_issue_return();
    public static new_issue_direct_return id = new new_issue_direct_return();
    //Supplier
    public static new_supplier newsup = new new_supplier();
    public supplier_list sl = new supplier_list();
    //Settings//Help
    public settings settings = new settings();
    public static user_accounts ua = new user_accounts();
    //System Tray for DBControl and Main
    public static systemTray SystemTray = new systemTray();

    public Main() throws UnknownHostException, IOException {
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitAction();
            }
        };
        JFrame main = this;
        main.addWindowListener(exitListener);
        initComponents();

        ScrollPaneMessageBox.setVisible(false);
        info.setVisible(false);
        ////Set File Path
        settings.getFilepath();
        settings.getPDFpath();
        settings.getEmailSettings();
        settings.filepath = settings.txtFilePath.getText();
        settings.pdfpath = settings.txtPDFPath.getText();
        ////

        ////////Adding Components to Panel////////////////////////////
        jDesktopPane1.add(ns);
        jDesktopPane1.add(na);
        jDesktopPane1.add(nf);
        jDesktopPane1.add(po);
        jDesktopPane1.add(pv);
        jDesktopPane1.add(ng);
        jDesktopPane1.add(gr);
        jDesktopPane1.add(ni);
        jDesktopPane1.add(ir);
        jDesktopPane1.add(id);
        jDesktopPane1.add(newsup);
        jDesktopPane1.add(fasrep);
        jDesktopPane1.add(sl);
        jDesktopPane1.add(sd);
        jDesktopPane1.add(stocklist);
        jDesktopPane1.add(stockval);
        jDesktopPane1.add(gl);
        jDesktopPane1.add(pl);
        jDesktopPane1.add(il);
        jDesktopPane1.add(settings);
        jDesktopPane1.add(ed);

        String UserName = login.txtUN.getText();
        lblUser.setText(UserName);
/////////////////////////////////////////////////////////
        keepChangingServerStatusLabel();

        final JFrame Main = this;

        Main.setFont(new Font("System", Font.PLAIN, 13));
        Font f = Main.getFont();
        FontMetrics fm = Main.getFontMetrics(f);
        int y = fm.stringWidth(" ");
        int z = Main.getWidth() / 2;
        int w = z / y;
        String pad = "";
        for (int i = 0; i != w; i++) {
            pad += " ";
        }
        Main.setTitle(pad + "Warehouse Management System");

        //Centre align Main Frame relative to Screen Size
        setLocationRelativeTo(null);

        //System Tray Notifications
        new systemTray().setJframe(this);
        SystemTray.getTrayicon().displayMessage("Welcome to WMS " + lblUser.getText(), "Warehouse Management System for RR Constructions (Pvt) Ltd. ", MessageType.NONE);

        ////
        ///
        //      WMSLobby   //
        refreshLobby();
        ///
        ////
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        WMSLobby = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLatestPO = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLatestFAS = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblWinner1 = new javax.swing.JLabel();
        lblWinner2 = new javax.swing.JLabel();
        lblWinner3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblServerIndicator = new javax.swing.JLabel();
        ScrollPaneMessageBox = new javax.swing.JScrollPane();
        info = new javax.swing.JTextPane();
        lblUser = new javax.swing.JLabel();
        lblRedStatus = new javax.swing.JLabel();
        lblGreenStatus = new javax.swing.JLabel();
        lblCompanyName = new javax.swing.JLabel();
        lblCompanyLogo = new javax.swing.JLabel();
        lblSilverBottomBackgroun = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mNewStock = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        mNewUOM = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mStockDetails = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        mStockList = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mNewAccount = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        mNewPO = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mPOList = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mNewGRN = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mGRNList = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mNewGRN1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mNewIssue = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mIssueList = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mIssueNoReturn = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        mNewSupplier = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mSupplierList = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mStockValuation = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        mSupplierStockHistory = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenu8 = new javax.swing.JMenu();
        mFAS = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        mFASReports = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        mUserAccounts = new javax.swing.JMenuItem();
        mSettings = new javax.swing.JMenuItem();
        mAbout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mLogOut = new javax.swing.JMenuItem();
        mRestart = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Warehouse Management System");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
            Main.class.getResource("/images/WMS_Logo.png")));
    setResizable(false);
    getContentPane().setLayout(null);

    WMSLobby.setBackground(new java.awt.Color(204, 204, 255));
    WMSLobby.setOpaque(false);
    WMSLobby.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("Latest FAS Updates");
    WMSLobby.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 110, -1));

    tblLatestPO.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "PO No", "Supplier", "Project", "Total"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane1.setViewportView(tblLatestPO);
    if (tblLatestPO.getColumnModel().getColumnCount() > 0) {
        tblLatestPO.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblLatestPO.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblLatestPO.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblLatestPO.getColumnModel().getColumn(3).setPreferredWidth(40);
    }

    WMSLobby.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 580, 110));

    jLabel2.setText("Latest Purchase Orders");
    WMSLobby.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

    tblLatestFAS.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Equip No", "Class", "Make", "By", "Time"
        }
    ));
    tblLatestFAS.getTableHeader().setReorderingAllowed(false);
    tblLatestFAS.setVerifyInputWhenFocusTarget(false);
    jScrollPane3.setViewportView(tblLatestFAS);
    if (tblLatestFAS.getColumnModel().getColumnCount() > 0) {
        tblLatestFAS.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblLatestFAS.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblLatestFAS.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblLatestFAS.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblLatestFAS.getColumnModel().getColumn(4).setPreferredWidth(120);
    }

    WMSLobby.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 580, 190));

    lblWinner1.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
    lblWinner1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblWinner1.setText("Winner 1");
    jLayeredPane1.add(lblWinner1);
    lblWinner1.setBounds(84, 207, 80, 20);

    lblWinner2.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
    lblWinner2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblWinner2.setText("Winner 2");
    jLayeredPane1.add(lblWinner2);
    lblWinner2.setBounds(4, 224, 80, 20);

    lblWinner3.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
    lblWinner3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblWinner3.setText("Winner 3");
    jLayeredPane1.add(lblWinner3);
    lblWinner3.setBounds(164, 230, 70, 17);

    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WMSLobby_Winner.png"))); // NOI18N
    jLabel10.setText("jLabel10");
    jLayeredPane1.add(jLabel10);
    jLabel10.setBounds(0, 9, 240, 241);

    WMSLobby.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 250, 250));

    jButton1.setText("Refresh");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    WMSLobby.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, -1));

    jLabel5.setText("Monthly FAS Updates");
    WMSLobby.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 140, -1));

    jDesktopPane1.add(WMSLobby);
    WMSLobby.setBounds(0, 0, 1030, 540);

    jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(51, 51, 51));
    jLabel4.setText("Anuradha Wishmantha Software Solutions");
    jDesktopPane1.add(jLabel4);
    jLabel4.setBounds(700, 60, 290, 30);

    jLabel12.setForeground(new java.awt.Color(51, 51, 51));
    jLabel12.setText("Developed and Maintained by ");
    jDesktopPane1.add(jLabel12);
    jLabel12.setBounds(720, 40, 210, 20);

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WMS_Background2.png"))); // NOI18N
    jDesktopPane1.add(jLabel3);
    jLabel3.setBounds(0, -20, 1050, 560);

    getContentPane().add(jDesktopPane1);
    jDesktopPane1.setBounds(0, 0, 1020, 540);

    jPanel1.setBackground(new java.awt.Color(211, 214, 215));
    jPanel1.setForeground(new java.awt.Color(255, 255, 255));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lblServerIndicator.setBackground(new java.awt.Color(255, 255, 255));
    lblServerIndicator.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
    lblServerIndicator.setText("STATUS:");
    lblServerIndicator.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblServerIndicatorMouseClicked(evt);
        }
    });
    jPanel1.add(lblServerIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 80, 25));

    info.setEditable(false);
    info.setFont(new java.awt.Font("Gisha", 0, 12)); // NOI18N
    info.setToolTipText("Click here to dismiss ");
    info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    info.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            infoMouseClicked(evt);
        }
    });
    ScrollPaneMessageBox.setViewportView(info);

    jPanel1.add(ScrollPaneMessageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 960, 40));

    lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel1.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 150, 30));

    lblRedStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/red_status.png"))); // NOI18N
    jPanel1.add(lblRedStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

    lblGreenStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/green_status.png"))); // NOI18N
    jPanel1.add(lblGreenStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

    lblCompanyName.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
    lblCompanyName.setForeground(new java.awt.Color(102, 0, 0));
    lblCompanyName.setText("RR Constructions (Pvt) Ltd.");
    jPanel1.add(lblCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 400, 40));

    lblCompanyLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RR Logo.png"))); // NOI18N
    jPanel1.add(lblCompanyLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, 50, 80));

    lblSilverBottomBackgroun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Main_Bottom_Background.png"))); // NOI18N
    lblSilverBottomBackgroun.setText("jLabel5");
    jPanel1.add(lblSilverBottomBackgroun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 90));

    getContentPane().add(jPanel1);
    jPanel1.setBounds(0, 540, 1600, 120);

    jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Stock.png"))); // NOI18N
    jMenu2.setText("Stock");
    jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu2.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mNewStock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
    mNewStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new stock.png"))); // NOI18N
    mNewStock.setText("New Stock");
    mNewStock.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewStock.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewStockActionPerformed(evt);
        }
    });
    jMenu2.add(mNewStock);
    jMenu2.add(jSeparator15);

    mNewUOM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/uom.png"))); // NOI18N
    mNewUOM.setText("New UOM");
    mNewUOM.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewUOM.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewUOMActionPerformed(evt);
        }
    });
    jMenu2.add(mNewUOM);
    jMenu2.add(jSeparator2);

    mStockDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_details.png"))); // NOI18N
    mStockDetails.setText("Stock Details");
    mStockDetails.setPreferredSize(new java.awt.Dimension(200, 35));
    mStockDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mStockDetailsActionPerformed(evt);
        }
    });
    jMenu2.add(mStockDetails);
    jMenu2.add(jSeparator16);

    mStockList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list.png"))); // NOI18N
    mStockList.setText("Stock List");
    mStockList.setPreferredSize(new java.awt.Dimension(200, 35));
    mStockList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mStockListActionPerformed(evt);
        }
    });
    jMenu2.add(mStockList);

    jMenuBar1.add(jMenu2);

    jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cost_center.png"))); // NOI18N
    jMenu3.setText("Center");
    jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu3.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mNewAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
    mNewAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new cost_center.png"))); // NOI18N
    mNewAccount.setText("Account Center");
    mNewAccount.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewAccount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewAccountActionPerformed(evt);
        }
    });
    jMenu3.add(mNewAccount);

    jMenuBar1.add(jMenu3);

    jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PO.png"))); // NOI18N
    jMenu9.setText("PO");
    jMenu9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu9.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mNewPO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
    mNewPO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new PO.png"))); // NOI18N
    mNewPO.setText("New Purchase Order");
    mNewPO.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewPO.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewPOActionPerformed(evt);
        }
    });
    jMenu9.add(mNewPO);
    jMenu9.add(jSeparator12);

    mPOList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list.png"))); // NOI18N
    mPOList.setText("Purchase Order List");
    mPOList.setPreferredSize(new java.awt.Dimension(200, 35));
    mPOList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mPOListActionPerformed(evt);
        }
    });
    jMenu9.add(mPOList);

    jMenuBar1.add(jMenu9);

    jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GRN.png"))); // NOI18N
    jMenu4.setText("GRN");
    jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu4.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mNewGRN.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
    mNewGRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new GRN.png"))); // NOI18N
    mNewGRN.setText("New GRN");
    mNewGRN.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewGRN.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewGRNActionPerformed(evt);
        }
    });
    jMenu4.add(mNewGRN);
    jMenu4.add(jSeparator4);

    mGRNList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list.png"))); // NOI18N
    mGRNList.setText("GRN List");
    mGRNList.setPreferredSize(new java.awt.Dimension(200, 35));
    mGRNList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mGRNListActionPerformed(evt);
        }
    });
    jMenu4.add(mGRNList);
    jMenu4.add(jSeparator7);

    mNewGRN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return_grn.png"))); // NOI18N
    mNewGRN1.setText("GRN Return");
    mNewGRN1.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewGRN1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewGRN1ActionPerformed(evt);
        }
    });
    jMenu4.add(mNewGRN1);

    jMenuBar1.add(jMenu4);

    jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Issue.png"))); // NOI18N
    jMenu5.setText("Issue");
    jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu5.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mNewIssue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
    mNewIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new issue.png"))); // NOI18N
    mNewIssue.setText("New Issue");
    mNewIssue.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewIssue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewIssueActionPerformed(evt);
        }
    });
    jMenu5.add(mNewIssue);
    jMenu5.add(jSeparator3);

    mIssueList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list.png"))); // NOI18N
    mIssueList.setText("Issue List");
    mIssueList.setPreferredSize(new java.awt.Dimension(200, 35));
    mIssueList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mIssueListActionPerformed(evt);
        }
    });
    jMenu5.add(mIssueList);
    jMenu5.add(jSeparator6);

    mIssueNoReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return_issue.png"))); // NOI18N
    mIssueNoReturn.setText("Issue No. Return");
    mIssueNoReturn.setPreferredSize(new java.awt.Dimension(200, 35));
    mIssueNoReturn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mIssueNoReturnActionPerformed(evt);
        }
    });
    jMenu5.add(mIssueNoReturn);
    jMenu5.add(jSeparator17);

    jMenuBar1.add(jMenu5);

    jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier.png"))); // NOI18N
    jMenu6.setText("Supplier");
    jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu6.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mNewSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new supplier.png"))); // NOI18N
    mNewSupplier.setText("New Supplier");
    mNewSupplier.setPreferredSize(new java.awt.Dimension(200, 35));
    mNewSupplier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mNewSupplierActionPerformed(evt);
        }
    });
    jMenu6.add(mNewSupplier);
    jMenu6.add(jSeparator5);

    mSupplierList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list.png"))); // NOI18N
    mSupplierList.setText("Supplier List");
    mSupplierList.setPreferredSize(new java.awt.Dimension(200, 35));
    mSupplierList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mSupplierListActionPerformed(evt);
        }
    });
    jMenu6.add(mSupplierList);

    jMenuBar1.add(jMenu6);

    jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reports (2).png"))); // NOI18N
    jMenu1.setText("Reports");
    jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu1.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mStockValuation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basic_report.png"))); // NOI18N
    mStockValuation.setText("Stock Report");
    mStockValuation.setPreferredSize(new java.awt.Dimension(200, 35));
    mStockValuation.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mStockValuationActionPerformed(evt);
        }
    });
    jMenu1.add(mStockValuation);
    jMenu1.add(jSeparator10);

    mSupplierStockHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier_stock_history.png"))); // NOI18N
    mSupplierStockHistory.setText("Supplier Stock History");
    mSupplierStockHistory.setPreferredSize(new java.awt.Dimension(200, 35));
    jMenu1.add(mSupplierStockHistory);
    jMenu1.add(jSeparator8);

    jMenuBar1.add(jMenu1);

    jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fas icon.png"))); // NOI18N
    jMenu8.setText("FAS");
    jMenu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu8.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mFAS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
    mFAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fas icon menu item.png"))); // NOI18N
    mFAS.setText("FAS");
    mFAS.setPreferredSize(new java.awt.Dimension(200, 35));
    mFAS.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mFASActionPerformed(evt);
        }
    });
    jMenu8.add(mFAS);
    jMenu8.add(jSeparator14);

    mFASReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basic_report.png"))); // NOI18N
    mFASReports.setText("FAS Reports");
    mFASReports.setPreferredSize(new java.awt.Dimension(200, 35));
    mFASReports.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mFASReportsActionPerformed(evt);
        }
    });
    jMenu8.add(mFASReports);
    jMenu8.add(jSeparator13);

    jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/entry_details.png"))); // NOI18N
    jMenuItem7.setText("Entry Details");
    jMenuItem7.setPreferredSize(new java.awt.Dimension(200, 35));
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem7ActionPerformed(evt);
        }
    });
    jMenu8.add(jMenuItem7);

    jMenuBar1.add(jMenu8);

    jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
    jMenu7.setText("Help");
    jMenu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jMenu7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jMenu7.setMargin(new java.awt.Insets(2, 10, 2, 20));
    jMenu7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jMenu7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

    mUserAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change_password.png"))); // NOI18N
    mUserAccounts.setText("User Accounts");
    mUserAccounts.setPreferredSize(new java.awt.Dimension(200, 35));
    mUserAccounts.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mUserAccountsActionPerformed(evt);
        }
    });
    jMenu7.add(mUserAccounts);

    mSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    mSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
    mSettings.setText("Settings");
    mSettings.setPreferredSize(new java.awt.Dimension(200, 35));
    mSettings.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mSettingsActionPerformed(evt);
        }
    });
    jMenu7.add(mSettings);

    mAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
    mAbout.setText("About");
    mAbout.setPreferredSize(new java.awt.Dimension(200, 35));
    mAbout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mAboutActionPerformed(evt);
        }
    });
    jMenu7.add(mAbout);
    jMenu7.add(jSeparator1);

    mLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
    mLogOut.setText("Log Out");
    mLogOut.setPreferredSize(new java.awt.Dimension(200, 35));
    mLogOut.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mLogOutActionPerformed(evt);
        }
    });
    jMenu7.add(mLogOut);

    mRestart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restart.png"))); // NOI18N
    mRestart.setText("Restart");
    mRestart.setPreferredSize(new java.awt.Dimension(200, 35));
    mRestart.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mRestartActionPerformed(evt);
        }
    });
    jMenu7.add(mRestart);

    mExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
    mExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quit.png"))); // NOI18N
    mExit.setText("Exit");
    mExit.setPreferredSize(new java.awt.Dimension(200, 35));
    mExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mExitActionPerformed(evt);
        }
    });
    jMenu7.add(mExit);

    jMenuBar1.add(jMenu7);

    setJMenuBar(jMenuBar1);

    setSize(new java.awt.Dimension(1027, 725));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mNewStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewStockActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ns.setVisible(true);
            ns.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!new_stock.txtStockCode.getText().isEmpty()) {
            int i = JOptionPane.showConfirmDialog(null, "Do you want to add New Stock Item or Continue editing previous Stock Code?\n Click YES - To add new stock \n Click NO - To continue Editing !", "Confirm", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                ns.clear();
            } else if (i == 1) {
                JOptionPane.showMessageDialog(null, "Please Save the changes", "Save Changes", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_mNewStockActionPerformed

    private void mNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewAccountActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            na.setVisible(true);
            na.setSelected(true);
            na.load();
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mNewAccountActionPerformed

    private void mNewGRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewGRNActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ng.setVisible(true);
            ng.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mNewGRNActionPerformed

    private void mNewIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewIssueActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ni.setVisible(true);
            ni.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mNewIssueActionPerformed

    private void mNewSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewSupplierActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            newsup.setVisible(true);
            newsup.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mNewSupplierActionPerformed

    private void mSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSettingsActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            settings.setVisible(true);
            settings.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mSettingsActionPerformed

    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAboutActionPerformed
        about frame = new about();
        jDesktopPane1.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mAboutActionPerformed

    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        exitAction();
    }//GEN-LAST:event_mExitActionPerformed

    private void mNewUOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewUOMActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        newuom.setVisible(true);
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_mNewUOMActionPerformed

    private void mStockValuationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mStockValuationActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            stockval.setVisible(true);
            stockval.setSelected(true);
            setCursor(Cursor.getDefaultCursor());

        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mStockValuationActionPerformed

    private void mStockDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mStockDetailsActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            sd.setVisible(true);
            sd.setSelected(true);
            sd.loadAccountTable();
            sd.loadStockTable();
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mStockDetailsActionPerformed

    private void mStockListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mStockListActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            stocklist.setVisible(true);
            stocklist.setSelected(true);
            stocklist.loadStock();
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mStockListActionPerformed

    private void mGRNListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGRNListActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            gl.setVisible(true);
            gl.setSelected(true);
            gl.load();
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mGRNListActionPerformed

    private void mIssueListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIssueListActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            il.setVisible(true);
            il.setSelected(true);
            il.load();
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mIssueListActionPerformed

    private void mFASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFASActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            nf.setVisible(true);
            nf.setSelected(true);
            jDesktopPane1.remove(this);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mFASActionPerformed

    private void mFASReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFASReportsActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            fasrep.setVisible(true);
            fasrep.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mFASReportsActionPerformed

    private void mLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLogOutActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            new login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_mLogOutActionPerformed

    private void mUserAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUserAccountsActionPerformed
        Permission.getPermission();
        Boolean b = Permission.allow;
        if (b.equals(true)) {
            user_accounts frame = new user_accounts();
            scm.Main.jDesktopPane1.add(frame);
            frame.setVisible(true);
            Permission.allow = false;
        }
    }//GEN-LAST:event_mUserAccountsActionPerformed

    private void mSupplierListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSupplierListActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            sl.setVisible(true);
            sl.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mSupplierListActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ed.setVisible(true);
            ed.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

private void mRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRestartActionPerformed
    int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to restart ?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (i == 0) {
        try {
            new scm.Main().setVisible(true);
            this.dispose();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if (i == 1) {
    }
}//GEN-LAST:event_mRestartActionPerformed

    private void mNewGRN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewGRN1ActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            gr.setVisible(true);
            gr.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mNewGRN1ActionPerformed

    private void mNewPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewPOActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            po.setVisible(true);
            po.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mNewPOActionPerformed

    private void mPOListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPOListActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            pl.setVisible(true);
            pl.setSelected(true);
            pl.load();
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
   }//GEN-LAST:event_mPOListActionPerformed

    private void mIssueNoReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIssueNoReturnActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ir.setVisible(true);
            ir.setSelected(true);
            setCursor(Cursor.getDefaultCursor());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mIssueNoReturnActionPerformed

    private void infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseClicked
        Main.ScrollPaneMessageBox.setVisible(false);
        Main.info.setVisible(false);
        Main.info.setText("");
    }//GEN-LAST:event_infoMouseClicked

    private void lblServerIndicatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblServerIndicatorMouseClicked
        //   keepChecking();
    }//GEN-LAST:event_lblServerIndicatorMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshLobby();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JScrollPane ScrollPaneMessageBox;
    public static javax.swing.JPanel WMSLobby;
    public static javax.swing.JTextPane info;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLayeredPane jLayeredPane1;
    public static javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu2;
    public static javax.swing.JMenu jMenu3;
    public static javax.swing.JMenu jMenu4;
    public static javax.swing.JMenu jMenu5;
    public static javax.swing.JMenu jMenu6;
    public static javax.swing.JMenu jMenu7;
    public static javax.swing.JMenu jMenu8;
    public static javax.swing.JMenu jMenu9;
    public static javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem7;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JPopupMenu.Separator jSeparator1;
    public static javax.swing.JPopupMenu.Separator jSeparator10;
    public static javax.swing.JPopupMenu.Separator jSeparator12;
    public static javax.swing.JPopupMenu.Separator jSeparator13;
    public static javax.swing.JPopupMenu.Separator jSeparator14;
    public static javax.swing.JPopupMenu.Separator jSeparator15;
    public static javax.swing.JPopupMenu.Separator jSeparator16;
    public static javax.swing.JPopupMenu.Separator jSeparator17;
    public static javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JPopupMenu.Separator jSeparator3;
    public static javax.swing.JPopupMenu.Separator jSeparator4;
    public static javax.swing.JPopupMenu.Separator jSeparator5;
    public static javax.swing.JPopupMenu.Separator jSeparator6;
    public static javax.swing.JPopupMenu.Separator jSeparator7;
    public static javax.swing.JPopupMenu.Separator jSeparator8;
    public static javax.swing.JLabel lblCompanyLogo;
    public static javax.swing.JLabel lblCompanyName;
    public static javax.swing.JLabel lblGreenStatus;
    public static javax.swing.JLabel lblRedStatus;
    public static javax.swing.JLabel lblServerIndicator;
    public static javax.swing.JLabel lblSilverBottomBackgroun;
    public static javax.swing.JLabel lblUser;
    public static javax.swing.JLabel lblWinner1;
    public static javax.swing.JLabel lblWinner2;
    public static javax.swing.JLabel lblWinner3;
    public static javax.swing.JMenuItem mAbout;
    public static javax.swing.JMenuItem mExit;
    public static javax.swing.JMenuItem mFAS;
    public static javax.swing.JMenuItem mFASReports;
    public static javax.swing.JMenuItem mGRNList;
    public static javax.swing.JMenuItem mIssueList;
    public static javax.swing.JMenuItem mIssueNoReturn;
    public static javax.swing.JMenuItem mLogOut;
    public static javax.swing.JMenuItem mNewAccount;
    public static javax.swing.JMenuItem mNewGRN;
    public static javax.swing.JMenuItem mNewGRN1;
    public static javax.swing.JMenuItem mNewIssue;
    public static javax.swing.JMenuItem mNewPO;
    public static javax.swing.JMenuItem mNewStock;
    public static javax.swing.JMenuItem mNewSupplier;
    public static javax.swing.JMenuItem mNewUOM;
    public static javax.swing.JMenuItem mPOList;
    public static javax.swing.JMenuItem mRestart;
    public static javax.swing.JMenuItem mSettings;
    public static javax.swing.JMenuItem mStockDetails;
    public static javax.swing.JMenuItem mStockList;
    public static javax.swing.JMenuItem mStockValuation;
    public static javax.swing.JMenuItem mSupplierList;
    public static javax.swing.JMenuItem mSupplierStockHistory;
    public static javax.swing.JMenuItem mUserAccounts;
    public static javax.swing.JTable tblLatestFAS;
    public static javax.swing.JTable tblLatestPO;
    // End of variables declaration//GEN-END:variables

    public static void keepChangingServerStatusLabel() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (theme.serverConnection == true) {
                        //  Thread.sleep(1000);
                        lblGreenStatus.setVisible(true);
                        lblRedStatus.setVisible(false);
                        // lblServerIndicator.setText("Online");
                        //lblServerIndicator.setForeground(Color.blue);
                        Thread.sleep(4000);
                        this.run();
                    }

                    while (theme.serverConnection == false) {
                        lblGreenStatus.setVisible(false);
                        lblRedStatus.setVisible(true);
                        Thread.sleep(800);
                        lblRedStatus.setVisible(false);
                        //  lblServerIndicator.setText("Offline");
                        //  lblServerIndicator.setForeground(Color.red);
                        Thread.sleep(800);
                        this.run();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
        ).start();
    }
    //    @Override
    //    public void actionPerformed(ActionEvent e) {
    //        String oldText = ex.getText();
    //        String newText = oldText.substring(1) + oldText.substring(0, 1);
    //        ex.setText(newText);
    //    }

    private void exitAction() {
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            System.exit(0);
        } else if (i == 1) {
        }
    }

    public static void errorDisplay(Exception ex) {
        Main.ScrollPaneMessageBox.setVisible(true);
        Main.info.setVisible(true);
        Main.info.setText(ex + "\n <<--Click here to dismiss-->>.");
        Main.info.setForeground(Color.red);
    }

    public static void msgDisplay(String ex) {
        Main.ScrollPaneMessageBox.setVisible(true);
        Main.info.setVisible(true);
        Main.info.setText(ex + "\n <<--Click here to dismiss-->>.");
        Main.info.setForeground(Color.GREEN);
    }

    private void loadLatestPO() {
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT p.po_no, sd.supplier_name, "
                    + "p.project_details, p.total FROM po p, supplier_details sd "
                    + "WHERE p.supplier_no = sd.supplier_no  ORDER BY p.po_no DESC LIMIT 5 ");
            DefaultTableModel dtm = (DefaultTableModel) tblLatestPO.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("po_no"));
                // v.add(rs.getString("po_date"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("project_details"));
                v.add(rs.getBigDecimal("total"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(Cursor.getDefaultCursor());
    }

    private void loadLatestFASUpdate() {
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details ORDER BY updated DESC LIMIT 10");
            DefaultTableModel dtm = (DefaultTableModel) tblLatestFAS.getModel();
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
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadFASWinners() {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT  updated_by, COUNT(*) AS user_count FROM fas_details "
                    + "WHERE updated_by <> 'Admin' AND updated >= DATE_SUB( CURDATE(), INTERVAL 1 MONTH ) GROUP BY updated_by ORDER BY user_count DESC LIMIT 4");
            while (rs.next()) {
                arrayList.add(rs.getString("updated_by") + " - " + rs.getString("user_count"));
                //   lblWinner1.setText(rs.getString);
            }
            //  for (String listValues : arrayList) {
            lblWinner1.setText(arrayList.get(0));
            lblWinner2.setText(arrayList.get(1));
            lblWinner3.setText(arrayList.get(2));
            //  }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshLobby() {
        loadLatestPO();
        loadLatestFASUpdate();
        loadFASWinners();
    }
}
