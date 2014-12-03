package scm.fas;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import scm.database.DBControl;
import scm.Main;
import scm.utils.Permission;
import scm.help.settings;
import scm.issue.new_issue;
import scm.stock.stock_details;
import scm.utils.systemTray;

public class new_fas extends javax.swing.JInternalFrame {

    /////////////////////// Image Path/////
    String path;
    String imagefile;
    ////////////////////////////////
    static DBControl db = new DBControl();

    public new_fas() {
        try {
            initComponents();
            /////// Load Accounts /////
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center ORDER BY account_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblAccountLoad.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("account_code"));
                v.add(rs.getString("description"));
                dtm.addRow(v);
            }
            /////////////////////
            tblAccountLoad.setVisible(false);
            jScrollPane4.setVisible(false);
            equipment_no.grabFocus();

            //////Clearing the fields in date choosers, becoz of the null pointer exception/////
            date_purchase.setDate(null);
            vet_cert_issue.setDate(null);
            vet_cert_exp.setDate(null);
            veh_rev_issue.setDate(null);
            veh_rev_exp.setDate(null);
            insurance_issue.setDate(null);
            insurance_exp.setDate(null);
            maint_date.setDate(null);
            refresh();
        } catch (Exception ex) {
            Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUpdated.setText("jTextField1");

        setResizable(true);
        setTitle("FAS Details");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fas icon menu item.png"))); // NOI18N
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

        bReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basic_report.png"))); // NOI18N
        bReports.setText("Reports");
        bReports.setFocusable(false);
        bReports.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReports.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bReports.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportsActionPerformed(evt);
            }
        });
        jToolBar1.add(bReports);
        jToolBar1.add(jSeparator7);

        previewFas_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preview.png"))); // NOI18N
        previewFas_report.setText("Preview");
        previewFas_report.setFocusable(false);
        previewFas_report.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewFas_report.setMargin(new java.awt.Insets(2, 15, 2, 15));
        previewFas_report.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewFas_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewFas_reportActionPerformed(evt);
            }
        });
        jToolBar1.add(previewFas_report);
        jToolBar1.add(jSeparator10);

        bPDFBASIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        bPDFBASIC.setText("PDF");
        bPDFBASIC.setFocusable(false);
        bPDFBASIC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPDFBASIC.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bPDFBASIC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bPDFBASIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFBASICActionPerformed(evt);
            }
        });
        jToolBar1.add(bPDFBASIC);
        jToolBar1.add(jSeparator9);

        bClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        bClose1.setText("Close");
        bClose1.setFocusable(false);
        bClose1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClose1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        bClose1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClose1ActionPerformed(evt);
            }
        });
        jToolBar1.add(bClose1);
        jToolBar1.add(jSeparator8);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(102, 102, 102));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Fixed Assets Management");
        jLabel61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel61.setIconTextGap(10);
        jLabel61.setPreferredSize(new java.awt.Dimension(500, 37));
        jToolBar1.add(jLabel61);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 153));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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

        jScrollPane4.setBounds(250, 86, 370, 220);
        jLayeredPane1.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Account Code");
        jLabel2.setBounds(10, 60, 160, 25);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Registration No.");
        jLabel3.setBounds(10, 140, 160, 25);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Class of Vehicle/Equipment");
        jLabel4.setBounds(10, 180, 220, 25);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("YOM");
        jLabel5.setBounds(10, 220, 130, 25);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Weight /Kg");
        jLabel7.setBounds(10, 260, 130, 25);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        equipment_no.setToolTipText("EX - 01");
        equipment_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        equipment_no.setNextFocusableComponent(txtAccountCode);
        equipment_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                equipment_noKeyReleased(evt);
            }
        });
        equipment_no.setBounds(250, 20, 180, 25);
        jLayeredPane1.add(equipment_no, javax.swing.JLayeredPane.DEFAULT_LAYER);

        registration_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        registration_no.setToolTipText("WP HJ - 1234");
        registration_no.setNextFocusableComponent(class_vehicle);
        registration_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                registration_noKeyReleased(evt);
            }
        });
        registration_no.setBounds(250, 140, 180, 25);
        jLayeredPane1.add(registration_no, javax.swing.JLayeredPane.DEFAULT_LAYER);

        class_vehicle.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        class_vehicle.setToolTipText("Crawler Excavator");
        class_vehicle.setNextFocusableComponent(yom);
        class_vehicle.setBounds(250, 180, 300, 25);
        jLayeredPane1.add(class_vehicle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        try {
            yom.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        yom.setToolTipText("2011");
        yom.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        yom.setNextFocusableComponent(weight);
        yom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yomKeyTyped(evt);
            }
        });
        yom.setBounds(150, 220, 110, 25);
        jLayeredPane1.add(yom, javax.swing.JLayeredPane.DEFAULT_LAYER);

        weight.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        weight.setToolTipText("26200 kg");
        weight.setNextFocusableComponent(machine_serial);
        weight.setBounds(150, 260, 110, 25);
        jLayeredPane1.add(weight, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pin_details_background.gif"))); // NOI18N
        jLabel40.setBounds(500, 50, 300, 340);
        jLayeredPane1.add(jLabel40, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAccountCode.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtAccountCode.setNextFocusableComponent(registration_no);
        txtAccountCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAccountCodeMouseClicked(evt);
            }
        });
        txtAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountCodeActionPerformed(evt);
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
        txtAccountCode.setBounds(250, 60, 180, 25);
        jLayeredPane1.add(txtAccountCode, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAccountDescription.setEditable(false);
        txtAccountDescription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAccountDescription.setBounds(250, 100, 300, 25);
        jLayeredPane1.add(txtAccountDescription, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setText("RRC Equipment No.");
        jLabel38.setBounds(10, 20, 160, 25);
        jLayeredPane1.add(jLabel38, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 102));
        jLabel41.setText("Accnt. Description");
        jLabel41.setBounds(10, 100, 160, 25);
        jLayeredPane1.add(jLabel41, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bAddImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/picture_add.png"))); // NOI18N
        bAddImage.setToolTipText("Add Image");
        bAddImage.setBorderPainted(false);
        bAddImage.setContentAreaFilled(false);
        bAddImage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/picture_add_big.png"))); // NOI18N
        bAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddImageActionPerformed(evt);
            }
        });
        bAddImage.setBounds(130, 300, 40, 40);
        jLayeredPane1.add(bAddImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bDeleteImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/picture_delete.png"))); // NOI18N
        bDeleteImage.setToolTipText("Delete Image");
        bDeleteImage.setBorderPainted(false);
        bDeleteImage.setContentAreaFilled(false);
        bDeleteImage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/picture_delete_big.png"))); // NOI18N
        bDeleteImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteImageActionPerformed(evt);
            }
        });
        bDeleteImage.setBounds(220, 300, 40, 40);
        jLayeredPane1.add(bDeleteImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 102));
        jLabel42.setText("Image");
        jLabel42.setBounds(10, 305, 70, 25);
        jLayeredPane1.add(jLabel42, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel43.setText("Remove");
        jLabel43.setBounds(180, 310, 50, 20);
        jLayeredPane1.add(jLabel43, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel60.setText("Add ");
        jLabel60.setBounds(110, 310, 30, 20);
        jLayeredPane1.add(jLabel60, javax.swing.JLayeredPane.DEFAULT_LAYER);
        image.setBounds(270, 220, 150, 130);
        jLayeredPane1.add(image, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bClearAccountCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close bw.png"))); // NOI18N
        bClearAccountCode.setBorderPainted(false);
        bClearAccountCode.setContentAreaFilled(false);
        bClearAccountCode.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        bClearAccountCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearAccountCodeActionPerformed(evt);
            }
        });
        bClearAccountCode.setBounds(430, 60, 25, 25);
        jLayeredPane1.add(bClearAccountCode, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel20.setText("Select only from Images folder in C:\\SCM Files\\Dropbox");
        jLabel20.setBounds(0, 340, 270, 14);
        jLayeredPane1.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("PIN", jLayeredPane1);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Make ");
        jLabel9.setBounds(10, 140, 180, 25);
        jLayeredPane2.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        machine_make.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        machine_make.setBounds(180, 140, 320, 25);
        jLayeredPane2.add(machine_make, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("Model ");
        jLabel10.setBounds(10, 200, 180, 25);
        jLayeredPane2.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        machine_model.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        machine_model.setToolTipText("CAT 320 D");
        machine_model.setBounds(180, 200, 320, 25);
        jLayeredPane2.add(machine_model, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Chasis No.");
        jLabel11.setBounds(10, 80, 180, 25);
        jLayeredPane2.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        machine_serial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        machine_serial.setToolTipText("CAT0336DCKKTOO384");
        machine_serial.setBounds(180, 20, 320, 25);
        jLayeredPane2.add(machine_serial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel57.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 102));
        jLabel57.setText("Serial No. ");
        jLabel57.setBounds(10, 20, 180, 25);
        jLayeredPane2.add(jLabel57, javax.swing.JLayeredPane.DEFAULT_LAYER);

        machine_chasis.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        machine_chasis.setToolTipText("CAT-320DFAL04577");
        machine_chasis.setBounds(180, 80, 320, 25);
        jLayeredPane2.add(machine_chasis, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel63.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 102));
        jLabel63.setText("Fuel Consumption");
        jLabel63.setBounds(10, 310, 150, 25);
        jLayeredPane2.add(jLabel63, javax.swing.JLayeredPane.DEFAULT_LAYER);

        machine_capacity.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        machine_capacity.setToolTipText("1 m3 Bucket/20T");
        machine_capacity.setBounds(180, 260, 320, 25);
        jLayeredPane2.add(machine_capacity, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 102));
        jLabel64.setText("Capacity");
        jLabel64.setBounds(10, 260, 150, 25);
        jLayeredPane2.add(jLabel64, javax.swing.JLayeredPane.DEFAULT_LAYER);

        machine_fuel_consumption.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        machine_fuel_consumption.setToolTipText("1 m3 Bucket/20T");
        machine_fuel_consumption.setBounds(180, 310, 320, 25);
        jLayeredPane2.add(machine_fuel_consumption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Machine ", jLayeredPane2);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Serial No.");
        jLabel12.setBounds(10, 20, 150, 25);
        jLayeredPane3.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        engine_serial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        engine_serial.setBounds(180, 20, 320, 25);
        jLayeredPane3.add(engine_serial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Make ");
        jLabel13.setBounds(10, 80, 150, 25);
        jLayeredPane3.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        engine_make.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        engine_make.setBounds(180, 80, 320, 25);
        jLayeredPane3.add(engine_make, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Capacity");
        jLabel14.setBounds(10, 200, 150, 25);
        jLayeredPane3.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        engine_model.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        engine_model.setBounds(180, 140, 320, 25);
        jLayeredPane3.add(engine_model, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 102));
        jLabel58.setText("Model ");
        jLabel58.setBounds(10, 140, 150, 25);
        jLayeredPane3.add(jLabel58, javax.swing.JLayeredPane.DEFAULT_LAYER);

        engine_capacity.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        engine_capacity.setBounds(180, 200, 320, 25);
        jLayeredPane3.add(engine_capacity, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Engine ", jLayeredPane3);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Volt");
        jLabel15.setBounds(10, 20, 140, 25);
        jLayeredPane6.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        power_volt.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        power_volt.setBounds(150, 20, 300, 25);
        jLayeredPane6.add(power_volt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Watt");
        jLabel16.setBounds(10, 80, 140, 25);
        jLayeredPane6.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        power_watt.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        power_watt.setBounds(150, 80, 300, 25);
        jLayeredPane6.add(power_watt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("Horse power");
        jLabel17.setBounds(10, 200, 140, 25);
        jLayeredPane6.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        power_hp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        power_hp.setBounds(150, 200, 300, 25);
        jLayeredPane6.add(power_hp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("Amp");
        jLabel18.setBounds(10, 140, 140, 25);
        jLayeredPane6.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        power_amp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        power_amp.setBounds(150, 140, 300, 25);
        jLayeredPane6.add(power_amp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setText("RPM");
        jLabel19.setBounds(10, 260, 140, 25);
        jLayeredPane6.add(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        power_rpm.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        power_rpm.setBounds(150, 260, 300, 25);
        jLayeredPane6.add(power_rpm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Power ", jLayeredPane6);

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 102));
        jLabel21.setText("PR");
        jLabel21.setBounds(20, 110, 160, 25);
        jLayeredPane4.add(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 102));
        jLabel22.setText("Type");
        jLabel22.setBounds(20, 170, 160, 25);
        jLayeredPane4.add(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 102));
        jLabel23.setText("Brand");
        jLabel23.setBounds(20, 230, 160, 25);
        jLayeredPane4.add(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setText("No Of Tyres");
        jLabel24.setBounds(20, 290, 160, 25);
        jLayeredPane4.add(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Front", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel10.setLayout(null);

        tyre_sizef.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel10.add(tyre_sizef);
        tyre_sizef.setBounds(20, 40, 180, 25);

        tyre_prf.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel10.add(tyre_prf);
        tyre_prf.setBounds(20, 100, 180, 25);

        tyre_typef.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel10.add(tyre_typef);
        tyre_typef.setBounds(20, 160, 180, 25);

        tyre_brandf.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel10.add(tyre_brandf);
        tyre_brandf.setBounds(20, 220, 180, 25);

        tyre_nof.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel10.add(tyre_nof);
        tyre_nof.setBounds(20, 280, 180, 25);

        jPanel10.setBounds(130, 10, 220, 340);
        jLayeredPane4.add(jPanel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rear", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel1.setLayout(null);

        tyre_sizer.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(tyre_sizer);
        tyre_sizer.setBounds(24, 38, 180, 25);

        tyre_prr.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(tyre_prr);
        tyre_prr.setBounds(24, 98, 180, 25);

        tyre_typer.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(tyre_typer);
        tyre_typer.setBounds(24, 158, 180, 25);

        tyre_brandr.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(tyre_brandr);
        tyre_brandr.setBounds(24, 218, 180, 25);

        tyre_nor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(tyre_nor);
        tyre_nor.setBounds(24, 278, 180, 25);

        jPanel1.setBounds(370, 10, 230, 340);
        jLayeredPane4.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 102));
        jLabel59.setText("Size");
        jLabel59.setBounds(20, 50, 160, 25);
        jLayeredPane4.add(jLabel59, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tire 2.jpg"))); // NOI18N
        jLabel50.setBounds(630, 10, 150, 170);
        jLayeredPane4.add(jLabel50, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tire 1.jpg"))); // NOI18N
        jLabel49.setBounds(600, 170, 90, 120);
        jLayeredPane4.add(jLabel49, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tire 3.jpg"))); // NOI18N
        jLabel48.setBounds(680, 220, 120, 170);
        jLayeredPane4.add(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Tyre ", jLayeredPane4);

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 102));
        jLabel25.setText("Type / Model");
        jLabel25.setBounds(10, 20, 140, 25);
        jLayeredPane8.add(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bat_type.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bat_type.setBounds(150, 20, 180, 25);
        jLayeredPane8.add(bat_type, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 102));
        jLabel26.setText("Volt");
        jLabel26.setBounds(10, 80, 140, 25);
        jLayeredPane8.add(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bat_volt.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bat_volt.setBounds(150, 80, 180, 25);
        jLayeredPane8.add(bat_volt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 102));
        jLabel27.setText("Amp");
        jLabel27.setBounds(10, 140, 140, 25);
        jLayeredPane8.add(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bat_amp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bat_amp.setBounds(150, 140, 180, 25);
        jLayeredPane8.add(bat_amp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 102));
        jLabel28.setText("Brand");
        jLabel28.setBounds(10, 200, 140, 25);
        jLayeredPane8.add(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bat_brand.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bat_brand.setBounds(150, 200, 180, 25);
        jLayeredPane8.add(bat_brand, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 102));
        jLabel29.setText("No Of Batteries");
        jLabel29.setBounds(10, 260, 140, 25);
        jLayeredPane8.add(jLabel29, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bat_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bat_no.setBounds(150, 260, 180, 25);
        jLayeredPane8.add(bat_no, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exide 2.jpg"))); // NOI18N
        jLabel51.setBounds(420, 40, 310, 270);
        jLayeredPane8.add(jLabel51, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Battery", jLayeredPane8);

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 102));
        jLabel30.setText("Lube Oil");
        jLabel30.setBounds(10, 20, 130, 25);
        jLayeredPane5.add(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_oil.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_oil.setBounds(150, 20, 180, 25);
        jLayeredPane5.add(filter_oil, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 102));
        jLabel31.setText("Fuel");
        jLabel31.setBounds(10, 60, 130, 25);
        jLayeredPane5.add(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_fuel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_fuel.setBounds(150, 60, 180, 25);
        jLayeredPane5.add(filter_fuel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 102));
        jLabel32.setText("Fuel/Water Sep");
        jLabel32.setBounds(10, 100, 130, 25);
        jLayeredPane5.add(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_sep.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_sep.setBounds(150, 100, 180, 25);
        jLayeredPane5.add(filter_sep, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 102));
        jLabel33.setText("Hydraulic");
        jLabel33.setBounds(10, 180, 130, 25);
        jLayeredPane5.add(jLabel33, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_hyd.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_hyd.setBounds(150, 180, 180, 25);
        jLayeredPane5.add(filter_hyd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 102));
        jLabel34.setText("Air Primary");
        jLabel34.setBounds(10, 260, 130, 25);
        jLayeredPane5.add(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_airp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_airp.setBounds(150, 260, 180, 25);
        jLayeredPane5.add(filter_airp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_trans.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_trans.setBounds(150, 220, 180, 25);
        jLayeredPane5.add(filter_trans, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 102));
        jLabel35.setText("Transmission");
        jLabel35.setBounds(10, 220, 130, 25);
        jLayeredPane5.add(jLabel35, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setText("Hydraulic Tank");
        jLabel36.setBounds(10, 140, 130, 25);
        jLayeredPane5.add(jLabel36, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_hyd_tank.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_hyd_tank.setBounds(150, 140, 180, 25);
        jLayeredPane5.add(filter_hyd_tank, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 102));
        jLabel37.setText("Air Secondary");
        jLabel37.setBounds(10, 300, 130, 25);
        jLayeredPane5.add(jLabel37, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_airs.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_airs.setBounds(150, 300, 180, 25);
        jLayeredPane5.add(filter_airs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_fuel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_fuel2.setBounds(360, 60, 180, 25);
        jLayeredPane5.add(filter_fuel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_oil2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_oil2.setBounds(360, 20, 180, 25);
        jLayeredPane5.add(filter_oil2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_sep2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_sep2.setBounds(360, 100, 180, 25);
        jLayeredPane5.add(filter_sep2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_hyd_tank2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_hyd_tank2.setBounds(360, 140, 180, 25);
        jLayeredPane5.add(filter_hyd_tank2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_hyd2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_hyd2.setBounds(360, 180, 180, 25);
        jLayeredPane5.add(filter_hyd2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        filter_trans2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        filter_trans2.setBounds(360, 220, 180, 25);
        jLayeredPane5.add(filter_trans2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter 1.jpg"))); // NOI18N
        jLabel66.setBounds(530, 110, 250, 230);
        jLayeredPane5.add(jLabel66, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Filters", jLayeredPane5);

        remarks.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jScrollPane2.setViewportView(remarks);

        jScrollPane2.setBounds(170, 300, 380, 80);
        jLayeredPane7.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        grn_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        grn_no.setBounds(170, 260, 180, 25);
        jLayeredPane7.add(grn_no, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("GRN No");
        jLabel6.setBounds(10, 260, 160, 25);
        jLayeredPane7.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Date of Purchase");
        jLabel1.setBounds(10, 20, 160, 25);
        jLayeredPane7.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel52.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 102));
        jLabel52.setText("Value / Rs");
        jLabel52.setBounds(10, 60, 160, 25);
        jLayeredPane7.add(jLabel52, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 102));
        jLabel53.setText("Remarks");
        jLabel53.setBounds(10, 300, 160, 25);
        jLayeredPane7.add(jLabel53, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 102));
        jLabel54.setText("Internal Hire Rate");
        jLabel54.setBounds(10, 100, 160, 25);
        jLayeredPane7.add(jLabel54, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 102));
        jLabel55.setText("Supplier");
        jLabel55.setBounds(10, 180, 160, 25);
        jLayeredPane7.add(jLabel55, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel56.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 102));
        jLabel56.setText("Invoice No");
        jLabel56.setBounds(10, 220, 160, 25);
        jLayeredPane7.add(jLabel56, javax.swing.JLayeredPane.DEFAULT_LAYER);

        value.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        value.setBounds(170, 60, 180, 25);
        jLayeredPane7.add(value, javax.swing.JLayeredPane.DEFAULT_LAYER);

        warranty.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        warranty.setBounds(170, 140, 180, 25);
        jLayeredPane7.add(warranty, javax.swing.JLayeredPane.DEFAULT_LAYER);

        supplier_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        supplier_no.setBounds(170, 180, 380, 25);
        jLayeredPane7.add(supplier_no, javax.swing.JLayeredPane.DEFAULT_LAYER);

        invoice_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        invoice_no.setBounds(170, 220, 180, 25);
        jLayeredPane7.add(invoice_no, javax.swing.JLayeredPane.DEFAULT_LAYER);

        date_purchase.setDateFormatString("dd/MM/yy");
        date_purchase.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        date_purchase.setBounds(170, 20, 180, 25);
        jLayeredPane7.add(date_purchase, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 102));
        jLabel62.setText("Warranty");
        jLabel62.setBounds(10, 140, 160, 25);
        jLayeredPane7.add(jLabel62, javax.swing.JLayeredPane.DEFAULT_LAYER);

        hirerate.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        hirerate.setBounds(170, 100, 180, 25);
        jLayeredPane7.add(hirerate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Receipt ", jLayeredPane7);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Revenue License", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel7.setLayout(null);

        jLabel72.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 102));
        jLabel72.setText("Revenue No:");
        jPanel7.add(jLabel72);
        jLabel72.setBounds(30, 30, 160, 25);

        jLabel73.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 0, 102));
        jLabel73.setText("Date of Issue");
        jPanel7.add(jLabel73);
        jLabel73.setBounds(30, 70, 130, 25);

        jLabel74.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 102));
        jLabel74.setText("Date of Expire");
        jPanel7.add(jLabel74);
        jLabel74.setBounds(30, 110, 130, 25);

        veh_rev_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel7.add(veh_rev_no);
        veh_rev_no.setBounds(150, 30, 180, 25);

        veh_rev_issue.setDateFormatString("dd/MM/yy");
        veh_rev_issue.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel7.add(veh_rev_issue);
        veh_rev_issue.setBounds(150, 70, 180, 25);

        veh_rev_exp.setDateFormatString("dd/MM/yy");
        veh_rev_exp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel7.add(veh_rev_exp);
        veh_rev_exp.setBounds(150, 110, 180, 25);

        jPanel7.setBounds(380, 20, 360, 160);
        jLayeredPane14.add(jPanel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VET Certificate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel8.setLayout(null);

        jLabel69.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 102));
        jLabel69.setText("Date of Expire");
        jPanel8.add(jLabel69);
        jLabel69.setBounds(30, 110, 160, 25);

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 102));
        jLabel45.setText("VET No:");
        jPanel8.add(jLabel45);
        jLabel45.setBounds(30, 30, 160, 25);

        jLabel68.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 102));
        jLabel68.setText("Date of Issue");
        jPanel8.add(jLabel68);
        jLabel68.setBounds(30, 70, 160, 25);

        vet_cert_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel8.add(vet_cert_no);
        vet_cert_no.setBounds(150, 30, 180, 25);

        vet_cert_issue.setDateFormatString("dd/MM/yy");
        vet_cert_issue.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel8.add(vet_cert_issue);
        vet_cert_issue.setBounds(150, 70, 180, 25);

        vet_cert_exp.setDateFormatString("dd/MM/yy");
        vet_cert_exp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel8.add(vet_cert_exp);
        vet_cert_exp.setBounds(150, 110, 180, 25);

        jPanel8.setBounds(10, 20, 350, 160);
        jLayeredPane14.add(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insurance Certificate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel9.setLayout(null);

        jLabel75.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 102));
        jLabel75.setText("Company :");
        jPanel9.add(jLabel75);
        jLabel75.setBounds(30, 70, 160, 25);

        jLabel76.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 102));
        jLabel76.setText("Date of Issue");
        jPanel9.add(jLabel76);
        jLabel76.setBounds(30, 110, 130, 25);

        jLabel77.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 102));
        jLabel77.setText("Date of Expire");
        jPanel9.add(jLabel77);
        jLabel77.setBounds(30, 150, 130, 25);

        insurance_no.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel9.add(insurance_no);
        insurance_no.setBounds(150, 30, 180, 25);

        insurance_issue.setDateFormatString("dd/MM/yy");
        insurance_issue.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel9.add(insurance_issue);
        insurance_issue.setBounds(150, 110, 180, 25);

        insurance_exp.setDateFormatString("dd/MM/yy");
        insurance_exp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel9.add(insurance_exp);
        insurance_exp.setBounds(150, 150, 180, 25);

        jLabel80.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 102));
        jLabel80.setText("Insurance No:");
        jPanel9.add(jLabel80);
        jLabel80.setBounds(30, 30, 160, 25);

        insurance_company.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel9.add(insurance_company);
        insurance_company.setBounds(150, 70, 180, 25);

        jPanel9.setBounds(10, 190, 350, 190);
        jLayeredPane14.add(jPanel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Registration", jLayeredPane14);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Service Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N
        jPanel11.setLayout(null);

        maint_parts.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maint_parts.setNextFocusableComponent(maint_reading);
        jPanel11.add(maint_parts);
        maint_parts.setBounds(150, 110, 540, 25);

        jLabel70.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 102));
        jLabel70.setText("Parts Replaced");
        jPanel11.add(jLabel70);
        jLabel70.setBounds(30, 110, 120, 25);

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 102));
        jLabel46.setText("ID");
        jPanel11.add(jLabel46);
        jLabel46.setBounds(30, 30, 120, 25);

        jLabel71.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 102));
        jLabel71.setText("Date");
        jPanel11.add(jLabel71);
        jLabel71.setBounds(30, 70, 120, 25);

        maint_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        maint_id.setNextFocusableComponent(maint_date);
        jPanel11.add(maint_id);
        maint_id.setBounds(70, 30, 130, 25);

        maint_technician.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maint_technician.setNextFocusableComponent(maint_save);
        jPanel11.add(maint_technician);
        maint_technician.setBounds(330, 70, 360, 25);

        jLabel78.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 102));
        jLabel78.setText("Technician");
        jPanel11.add(jLabel78);
        jLabel78.setBounds(210, 70, 120, 25);

        jLabel79.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 102));
        jLabel79.setText("Next Service");
        jPanel11.add(jLabel79);
        jLabel79.setBounds(470, 30, 100, 25);

        maint_nextService.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maint_nextService.setNextFocusableComponent(maint_technician);
        jPanel11.add(maint_nextService);
        maint_nextService.setBounds(570, 30, 120, 25);

        maint_reading.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maint_reading.setNextFocusableComponent(maint_nextService);
        jPanel11.add(maint_reading);
        maint_reading.setBounds(330, 30, 120, 25);

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 102));
        jLabel47.setText("Meter Reading");
        jPanel11.add(jLabel47);
        jLabel47.setBounds(210, 30, 120, 25);

        maint_save.setText("Save");
        maint_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maint_saveActionPerformed(evt);
            }
        });
        jPanel11.add(maint_save);
        maint_save.setBounds(700, 60, 75, 45);

        maint_delete.setText("Delete");
        maint_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maint_deleteActionPerformed(evt);
            }
        });
        jPanel11.add(maint_delete);
        maint_delete.setBounds(700, 110, 75, 25);

        maint_new.setText("New");
        maint_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maint_newActionPerformed(evt);
            }
        });
        jPanel11.add(maint_new);
        maint_new.setBounds(700, 30, 75, 25);

        maint_date.setDateFormatString("dd/MM/yy");
        maint_date.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maint_date.setNextFocusableComponent(maint_parts);
        jPanel11.add(maint_date);
        maint_date.setBounds(70, 70, 130, 25);

        jPanel11.setBounds(10, 10, 790, 150);
        jLayeredPane9.add(jPanel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblMaint.setAutoCreateRowSorter(true);
        tblMaint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblMaint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Parts Replaced", "Meter Reading", "Next Service", "Technician"
            }
        ));
        tblMaint.setRowHeight(20);
        tblMaint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaintMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaint);
        tblMaint.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblMaint.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblMaint.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblMaint.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblMaint.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblMaint.getColumnModel().getColumn(5).setPreferredWidth(60);

        jScrollPane1.setBounds(10, 160, 770, 200);
        jLayeredPane9.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ShowMaintenanceDetails.setText("Show All");
        ShowMaintenanceDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowMaintenanceDetailsActionPerformed(evt);
            }
        });
        ShowMaintenanceDetails.setBounds(710, 360, 73, 30);
        jLayeredPane9.add(ShowMaintenanceDetails, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Maintenance", jLayeredPane9);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 810, 430));

        txtSearch.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtSearch.setToolTipText("Enter your search item");
        txtSearch.setName(""); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 30));

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh bw.gif"))); // NOI18N
        search.setToolTipText("Refresh FAS List");
        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        search.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        search.setMargin(new java.awt.Insets(2, 1, 1, 2));
        search.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.gif"))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 25, 30));

        comboSearchitems.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        comboSearchitems.setForeground(new java.awt.Color(0, 0, 102));
        comboSearchitems.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RRC Equipment No." }));
        getContentPane().add(comboSearchitems, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 25));

        jLabel44.setForeground(new java.awt.Color(153, 153, 153));
        jLabel44.setText("Search by");
        getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jList1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(jList1);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 350));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remarks_textpane - Copy.jpg"))); // NOI18N
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 50, 220, 480));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Operator");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 60, 20));

        location.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 130, 20));

        lblLastUpdated.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLastUpdated.setText("Last Updated By :");
        getContentPane().add(lblLastUpdated, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 350, 30));

        jLabel65.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 102));
        jLabel65.setText("Location");
        getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 60, 20));

        operator.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(operator, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 170, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
            searchEquipment();
    }//GEN-LAST:event_jList1MouseClicked

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            bSave.setEnabled(true);
            clear();
            equipment_no.grabFocus();
        } else if (i == 1) {
            JOptionPane.showMessageDialog(null, "Please UPDATE the changes", "UPDATE", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bNewActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        String delEquipmentNo = equipment_no.getText();
        if (delEquipmentNo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an equipment number", "Error", JOptionPane.ERROR_MESSAGE);
            equipment_no.grabFocus();
        } else {
            try {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete [ " + delEquipmentNo + " ] ?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    Permission.getPermission();
                    Boolean b = Permission.allow;
                    if (b.equals(true)) {
                        //db.setResult("UPDATE fas_details SET updated_by = '" + Main.lblUser.getText() + "' WHERE equipment_no = '" + equipment_no + "'");
                        // db.setResult("INSERT INTO fas_details_del" + values + " SELECT " + valuesWithoutBrackets + " '" + Main.lblUser.getText() + "' FROM fas_details fd WHERE equipment_no='" + equipment_no.getText() + "'");
                        db.setResult("DELETE From fas_details  WHERE equipment_no='" + equipment_no.getText() + "'");
                        new systemTray().getTrayicon().displayMessage("Successfully Deleted", "Equipment No : [" + delEquipmentNo + "] ", MessageType.WARNING);
                        clear();
                        Permission.allow = false;
                        JOptionPane.showMessageDialog(this, "Successfully Deleted", "Deleted", JOptionPane.WARNING_MESSAGE);
                    }
                }
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details ORDER BY equipment_no ASC ");
                Vector v = new Vector();
                while (rs.next()) {
                    v.add(rs.getString("equipment_no"));
                }
                jList1.setListData(v);

            } catch (Exception ex) {
                Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " DELETE Failed ! ", "Error", JOptionPane.ERROR_MESSAGE);
            }
            setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed

        Date today = new Date();
        long time = today.getTime();
        Timestamp ts = new Timestamp(time);
        String timestamp = ts.toString();
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

            Date Ii = insurance_issue.getDate();
            String insI = null;
            if (Ii != null) {
                insI = sdf.format(insurance_issue.getDate());
            }
            Date Ie = insurance_exp.getDate();
            String insE = null;
            if (Ie != null) {
                insE = sdf.format(insurance_exp.getDate());
            }
            Date Vi = vet_cert_issue.getDate();
            String vetI = null;
            if (Vi != null) {
                vetI = sdf.format(vet_cert_issue.getDate());
            }
            Date Ve = vet_cert_exp.getDate();
            String vetE = null;
            if (Ve != null) {
                vetE = sdf.format(vet_cert_exp.getDate());
            }
            Date Ri = veh_rev_issue.getDate();
            String revI = null;
            if (Ri != null) {
                revI = sdf.format(veh_rev_issue.getDate());
            }
            Date Re = veh_rev_exp.getDate();
            String revE = null;
            if (Re != null) {
                revE = sdf.format(veh_rev_exp.getDate());
            }

            String updated_by = Main.lblUser.getText();

            if (equipment_no.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an equipment number", " Error", JOptionPane.ERROR_MESSAGE);
                equipment_no.grabFocus();
            } else if (Ie != null && Ii != null && Ie.before(Ii)) {
                JOptionPane.showMessageDialog(null, "Please make sure that Insurance Expiry Date [ " + insE + " ] is greater than Insurance Issue Date [ " + insI + " ]", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (Ve != null && Vi != null && Ve.before(Vi)) {
                JOptionPane.showMessageDialog(null, "Please make sure that VET Expiry Date [ " + vetE + " ] is greater than VET Issue Date [ " + vetI + " ]", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (Re != null && Ri != null && Re.before(Ri)) {
                JOptionPane.showMessageDialog(null, "Please make sure that Revenue Expiry Date [ " + revE + " ]  is greater than Revenue Issue Date [ " + revI + " ]", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ResultSet rss = DBControl.getResultFromLocalDB("SELECT equipment_no From fas_details WHERE equipment_no='" + equipment_no.getText() + "'");
                if (rss.next()) {
                    try {
                        update();
                    } catch (Throwable ex) {
                        Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    try {
                        String Equipment_no = equipment_no.getText();
                        String Account_code = txtAccountCode.getText();
                        String Registration_no = registration_no.getText();
                        String Class_vehicle = class_vehicle.getText();
                        String Yom = yom.getText();
                        String Weight = weight.getText();
                        // String Date_purchase = date_purchase.getText();
                        String Location = location.getText();
                        String Operator = operator.getText();
                        String Value = value.getText();
                        String Hire_rate = hirerate.getText();
                        String Machine_serial = machine_serial.getText();
                        String Machine_chasis = machine_chasis.getText();
                        String Machine_make = machine_make.getText();
                        String Machine_model = machine_model.getText();
                        String Machine_capacity = machine_capacity.getText();
                        String Machine_fuel_consumption = machine_fuel_consumption.getText();
                        String Engine_serial = engine_serial.getText();
                        String Engine_make = engine_make.getText();
                        String Engine_model = engine_model.getText();
                        String Engine_capacity = engine_capacity.getText();
                        String Power_volt = power_volt.getText();
                        String Power_watt = power_watt.getText();
                        String Power_hp = power_hp.getText();
                        String Power_amp = power_amp.getText();
                        String Power_rpm = power_rpm.getText();
                        String Tyre_sizef = tyre_sizef.getText();
                        String Tyre_typef = tyre_typef.getText();
                        String Tyre_brandf = tyre_brandf.getText();
                        String Tyre_prf = tyre_prf.getText();
                        String Tyre_nof = tyre_nof.getText();
                        String Tyre_sizer = tyre_sizer.getText();
                        String Tyre_typer = tyre_typer.getText();
                        String Tyre_brandr = tyre_brandr.getText();
                        String Tyre_prr = tyre_prr.getText();
                        String Tyre_nor = tyre_nor.getText();
                        String Bat_type = bat_type.getText();
                        String Bat_volt = bat_volt.getText();
                        String Bat_amp = bat_amp.getText();
                        String Bat_brand = bat_brand.getText();
                        String Bat_no = bat_no.getText();
                        String Filter_airp = filter_airp.getText();
                        String Filter_airs = filter_airs.getText();
                        String Filter_fuel = filter_fuel.getText();
                        String Filter_fuel2 = filter_fuel2.getText();
                        String Filter_hyd = filter_hyd.getText();
                        String Filter_hyd2 = filter_hyd2.getText();
                        String Filter_hyd_tank = filter_hyd_tank.getText();
                        String Filter_hyd_tank2 = filter_hyd_tank2.getText();
                        String Filter_oil = filter_oil.getText();
                        String Filter_oil2 = filter_oil2.getText();
                        String Filter_sep = filter_sep.getText();
                        String Filter_sep2 = filter_sep2.getText();
                        String Filter_trans = filter_trans.getText();
                        String Filter_trans2 = filter_trans2.getText();
                        String Warranty = warranty.getText();
                        String Supplier_no = supplier_no.getText();
                        String Invoice_no = invoice_no.getText();
                        String Grn_no = grn_no.getText();
                        String Remarks = remarks.getText();
                        String reg_vet_no = vet_cert_no.getText();
                        String reg_veh_no = veh_rev_no.getText();
                        String reg_insurance_no = insurance_no.getText();
                        String reg_insurance_company = insurance_company.getText();

                        // Declaration of Dates using jDateChooser || Main problem was solved, when an empty date was sent to DB, a null pointr exception occured.
                        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

                        String valDate = ((JTextField) vet_cert_issue.getDateEditor().getUiComponent()).getText();
                        String reg_vet_issue = null;
                        if (!valDate.isEmpty()) {
                            reg_vet_issue = date.format(vet_cert_issue.getDate());
                        } else {
                            reg_vet_issue = "";
                        }
                        String valDate1 = ((JTextField) vet_cert_exp.getDateEditor().getUiComponent()).getText();
                        String reg_vet_exp = null;
                        if (!valDate1.isEmpty()) {
                            reg_vet_exp = date.format(vet_cert_exp.getDate());
                        } else {
                            reg_vet_exp = "";
                        }
                        String valDate2 = ((JTextField) veh_rev_issue.getDateEditor().getUiComponent()).getText();
                        String reg_veh_issue = null;
                        if (!valDate2.isEmpty()) {
                            reg_veh_issue = date.format(veh_rev_issue.getDate());
                        } else {
                            reg_veh_issue = "";
                        }
                        String valDate3 = ((JTextField) veh_rev_exp.getDateEditor().getUiComponent()).getText();
                        String reg_veh_exp = null;
                        if (!valDate3.isEmpty()) {
                            reg_veh_exp = date.format(veh_rev_exp.getDate());
                        } else {
                            reg_veh_exp = "";
                        }
                        String valDate4 = ((JTextField) insurance_issue.getDateEditor().getUiComponent()).getText();
                        String reg_insurance_issue = null;
                        if (!valDate4.isEmpty()) {
                            reg_insurance_issue = date.format(insurance_issue.getDate());
                        } else {
                            reg_insurance_issue = "";
                        }
                        String valDate5 = ((JTextField) insurance_exp.getDateEditor().getUiComponent()).getText();
                        String reg_insurance_exp = null;
                        if (!valDate5.isEmpty()) {
                            reg_insurance_exp = date.format(insurance_exp.getDate());
                        } else {
                            reg_insurance_exp = "";
                        }
                        String valDate7 = ((JTextField) date_purchase.getDateEditor().getUiComponent()).getText();
                        String Date_purchase = null;
                        if (!valDate7.isEmpty()) {
                            Date_purchase = date.format(date_purchase.getDate());
                        } else {
                            Date_purchase = "";
                        }

                        db.setResult(
                                "INSERT INTO fas_details VALUES('" + Equipment_no + "','" + Account_code + "','" + Registration_no + "','" + Location + "','" + Operator + "','" + Yom + "',"
                                + "'" + Weight + "','" + Date_purchase + "','" + Class_vehicle + "','" + Value + "','" + Hire_rate + "','" + Machine_serial + "','" + Machine_chasis + "',"
                                + "'" + Machine_make + "','" + Machine_model + "','" + Machine_capacity + "','" + Machine_fuel_consumption + "','" + Engine_serial + "','" + Engine_make + "','" + Engine_model + "',"
                                + "'" + Engine_capacity + "','" + Power_volt + "','" + Power_watt + "', " + "'" + Power_hp + "','" + Power_amp + "','" + Power_rpm + "',"
                                + "'" + Tyre_sizef + "','" + Tyre_prf + "','" + Tyre_typef + "','" + Tyre_brandf + "','" + Tyre_nof + "','" + Tyre_sizer + "',"
                                + "'" + Tyre_prr + "','" + Tyre_typer + "','" + Tyre_brandr + "','" + Tyre_nor + "','" + Bat_type + "','" + Bat_volt + "','" + Bat_amp + "',"
                                + "'" + Bat_brand + "','" + Bat_no + "','" + Filter_oil + "','" + Filter_oil2 + "','" + Filter_fuel + "','" + Filter_fuel2 + "',"
                                + "'" + Filter_sep + "'," + "'" + Filter_sep2 + "','" + Filter_hyd_tank + "','" + Filter_hyd_tank2 + "','" + Filter_hyd + "',"
                                + "'" + Filter_hyd2 + "','" + Filter_trans + "','" + Filter_trans2 + "','" + Filter_airp + "','" + Filter_airs + "','" + Warranty + "',"
                                + "'" + Supplier_no + "','" + Invoice_no + "','" + Grn_no + "','" + Remarks + "', '" + reg_vet_no + "','" + reg_vet_issue + "'" + ","
                                + "'" + reg_vet_exp + "','" + reg_veh_no + "','" + reg_veh_issue + "','" + reg_veh_exp + "','" + reg_insurance_no + "',"
                                + "'" + reg_insurance_company + "','" + reg_insurance_issue + "','" + reg_insurance_exp + "','" + path + "',"
                                + "'" + updated_by + "','" + timestamp + "')");
                        System.out.println("SOUTTTTTT AT FAS" + DBControl.isSaved());
                        if (DBControl.isSaved() == true) {
                            new systemTray().getTrayicon().displayMessage("Successfully Saved", "Equipment No : [" + Equipment_no + "] ,  Class : [" + Class_vehicle + "]", MessageType.INFO);

                        }
                        ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no LIKE '" + Equipment_no + '%' + "' ORDER BY equipment_no ASC ");
                        Vector v = new Vector();
                        while (rs.next()) {
                            v.add(rs.getString("equipment_no"));
                        }
                        jList1.setListData(v);

                    } catch (Exception ex) {
                        Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Save Failed !   [" + equipment_no.getText() + "]  :", "ERROR IN SAVING", JOptionPane.ERROR_MESSAGE);
                        new systemTray().getTrayicon().displayMessage("ERROR!", "Connection Failed", MessageType.ERROR);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_bSaveActionPerformed

    private void maint_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maint_saveActionPerformed
        String Maint_id = maint_id.getText();
        String Maint_parts = maint_parts.getText();
        String Maint_reading = maint_reading.getText();
        String Maint_nextService = maint_nextService.getText();
        String Maint_technician = maint_technician.getText();
        String Maint_date = ((JTextField) maint_date.getDateEditor().getUiComponent()).getText();
        if (equipment_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an equipment number", " Error", JOptionPane.ERROR_MESSAGE);
            equipment_no.grabFocus();
        } else if (Maint_id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a maintenance ID", " Error", JOptionPane.ERROR_MESSAGE);
            maint_id.grabFocus();
        } else if (Maint_date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Maintenance Date cannot be empty!!  ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                Maint_date = date.format(maint_date.getDate());
                // ResultSet rss = DBControl.getResult("SELECT maintenance_id FROM fas_maintenance WHERE maintenance_id='" + Maint_id + "'");
                ResultSet rss = DBControl.getResultFromLocalDB("SELECT maintenance_id FROM fas_maintenance WHERE maintenance_id='" + Maint_id + "' and equipment_no='" + equipment_no.getText() + "'");
                if (rss.next()) {
                    updateMaintenanceDetails();
                } else {
                    db.setResult("INSERT INTO fas_maintenance VALUES('" + equipment_no.getText() + "','" + Maint_id + "','" + Maint_date + "',"
                            + "'" + Maint_parts + "','" + Maint_reading + "','" + Maint_nextService + "','" + Maint_technician + "')");
                    load_MaintenanceDetails();
                }
            } catch (Exception ex) {
                Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error occurred while saving maintenance details  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_maint_saveActionPerformed

    private void maint_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maint_deleteActionPerformed
        if (equipment_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an equipment number", " Error", JOptionPane.ERROR_MESSAGE);
            equipment_no.grabFocus();
        } else {
            try {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    db.setResult("DELETE From fas_maintenance  WHERE maintenance_id ='" + maint_id.getText() + "'");
                }
                maint_id.setText("");
                maint_date.setDate(null);
                maint_parts.setText("");
                maint_reading.setText("");
                maint_nextService.setText("");
                maint_technician.setText("");
                load_MaintenanceDetails();
            } catch (Exception ex) {
                Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error occurred while saving maintenance details " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }

            setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_maint_deleteActionPerformed

    private void maint_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maint_newActionPerformed
        if (equipment_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an equipment number", " Error", JOptionPane.ERROR_MESSAGE);
            equipment_no.grabFocus();
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Did you save the changes you made ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                maint_id.setText("");
                maint_date.setDate(null);
                maint_parts.setText("");
                maint_reading.setText("");
                maint_nextService.setText("");
                maint_technician.setText("");
            } else if (i == 1) {
                JOptionPane.showMessageDialog(this, "Please SAVE the changes", "SAVE", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_maint_newActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String Search = txtSearch.getText();
            if (comboSearchitems.getSelectedIndex() == 0) {
                String s2 = Search.toUpperCase();
                txtSearch.setText(s2);
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details "
                        + "WHERE equipment_no LIKE '" + Search + '%' + "' "
                        + "OR class_vehicle LIKE '" + Search + '%' + "' "
                        + "ORDER BY equipment_no ASC ");
                Vector v = new Vector();
                while (rs.next()) {
                    v.add(rs.getString("equipment_no"));
                }
                jList1.setListData(v);
            } else if (comboSearchitems.getSelectedIndex() == 1) {
                ResultSet rs3 = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE machine_serial LIKE '" + Search + '%' + "'ORDER BY equipment_no ASC ");
                Vector v2 = new Vector();
                while (rs3.next()) {
                    v2.add(rs3.getString("machine_serial"));
                }
                jList1.setListData(v2);
            } else if (comboSearchitems.getSelectedIndex() == 2) {

                ResultSet rs4 = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE engine_serial LIKE '" + Search + '%' + "'ORDER BY equipment_no ASC ");
                Vector v3 = new Vector();
                while (rs4.next()) {
                    v3.add(rs4.getString("engine_serial"));
                }
                jList1.setListData(v3);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_fas.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        refresh();
    }//GEN-LAST:event_searchActionPerformed

    private void ShowMaintenanceDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowMaintenanceDetailsActionPerformed
        load_MaintenanceDetails();
    }//GEN-LAST:event_ShowMaintenanceDetailsActionPerformed

    private void equipment_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_equipment_noKeyReleased
        String s1 = equipment_no.getText();
        String s2 = s1.toUpperCase();
        equipment_no.setText(s2);
    }//GEN-LAST:event_equipment_noKeyReleased

    private void registration_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registration_noKeyReleased
        String s1 = registration_no.getText();
        String s2 = s1.toUpperCase();
        registration_no.setText(s2);
    }//GEN-LAST:event_registration_noKeyReleased

    private void yomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yomKeyTyped
//        char c = evt.getKeyChar();
//        if (!(Character.isDigit(c))) {
//            evt.consume();
//            getToolkit().beep();
//        }
    }//GEN-LAST:event_yomKeyTyped

    private void tblMaintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaintMouseClicked
        JTable dtm = (JTable) evt.getSource();
        int i = tblMaint.getSelectedRow();
        String t1 = dtm.getValueAt(i, 0).toString();
        String t2 = dtm.getValueAt(i, 1).toString();
        String t3 = dtm.getValueAt(i, 2).toString();
        String t4 = dtm.getValueAt(i, 3).toString();
        String t5 = dtm.getValueAt(i, 4).toString();
        String t6 = dtm.getValueAt(i, 5).toString();

        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        if (!t2.isEmpty()) {
            try {
                date = (Date) formatter.parse(t2);
                format.format(date);
                maint_date.setDate(date);
            } catch (ParseException ex) {
            }
        } else {
        }
        maint_id.setText(t1);
        maint_date.setDate(date);
        maint_parts.setText(t3);
        maint_reading.setText(t4);
        maint_nextService.setText(t5);
        maint_technician.setText(t6);
    }//GEN-LAST:event_tblMaintMouseClicked

    private void bReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportsActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Main.fasrep.setVisible(true);
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_bReportsActionPerformed

    private void bClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClose1ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            this.setVisible(false);
            Main.ScrollPaneMessageBox.setVisible(false);
            Main.info.setVisible(false);
        } else if (i == 1) {
        }
    }//GEN-LAST:event_bClose1ActionPerformed

    private void txtAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountCodeActionPerformed
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String SID = (String) txtAccountCode.getText();
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code='" + SID + "'");
            while (rs.next()) {
                txtAccountDescription.setText(rs.getString("description"));
            }
        } catch (Exception ex) {
            Logger.getLogger(new_issue.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "  ERROR  " + ex);
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_txtAccountCodeActionPerformed

    private void txtAccountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyReleased
        try {
            String Search = txtAccountCode.getText();
            String s2 = Search.toUpperCase();
            txtAccountCode.setText(s2);
            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM account_center "
                    + "WHERE account_code LIKE '" + Search + '%' + "' "
                    + "OR description LIKE '" + Search + '%' + "' "
                    + "ORDER BY account_code ASC");
            DefaultTableModel dtm = (DefaultTableModel) tblAccountLoad.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("account_code"));
                v.add(rs.getString("description"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(stock_details.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtAccountCodeKeyReleased

    private void previewFas_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewFas_reportActionPerformed
        if (!equipment_no.getText().isEmpty()) {
            try {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                String reportSource = settings.filepath + "fas_report.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("equipment_no", equipment_no.getText());
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("FAS Report [ " + equipment_no.getText() + " ]");
                jv.setExtendedState(jv.getExtendedState() | JasperViewer.MAXIMIZED_BOTH);
                jv.setVisible(true);

            } catch (Exception exception) {
                Logger.getLogger(new_fas.class
                        .getName()).log(Level.SEVERE, null, exception);
                Main.errorDisplay(exception);
            }
            setCursor(Cursor.getDefaultCursor());
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Equipment number to Preview !");
        }
    }//GEN-LAST:event_previewFas_reportActionPerformed

private void txtAccountCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountCodeKeyTyped
    tblAccountLoad.setVisible(true);
    jScrollPane4.setVisible(true);
}//GEN-LAST:event_txtAccountCodeKeyTyped

    private void bAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddImageActionPerformed
        if (equipment_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an equipment number first");
            equipment_no.grabFocus();
        } else {
            int i = jFileChooser1.showOpenDialog(this);
            if (i == 0) {
                try {
                    File file = jFileChooser1.getSelectedFile();
                    path = file.getAbsolutePath();
                    path = path.replace("\\", "/");
                    File f = new File(path);
                    Image img = ImageIO.read(f);
                    img = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(img);
                    image.setIcon(icon);

                } catch (IOException ex) {
                    Logger.getLogger(new_fas.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bAddImageActionPerformed

    private void bDeleteImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteImageActionPerformed
        image.setIcon(null);
        path = "";

    }//GEN-LAST:event_bDeleteImageActionPerformed

    private void bNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNextActionPerformed
    }//GEN-LAST:event_bNextActionPerformed

    private void bClearAccountCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearAccountCodeActionPerformed
        txtAccountCode.setText("");
        txtAccountDescription.setText("");
        tblAccountLoad.setVisible(false);
        jScrollPane4.setVisible(false);
    }//GEN-LAST:event_bClearAccountCodeActionPerformed

    private void tblAccountLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountLoadMouseClicked
        DefaultTableModel dtmm = (DefaultTableModel) tblAccountLoad.getModel();
        int i = tblAccountLoad.getSelectedRow();
        String s1 = dtmm.getValueAt(i, 0).toString();
        String s2 = dtmm.getValueAt(i, 1).toString();
        txtAccountCode.setText(s1);
        txtAccountDescription.setText(s2);
        txtAccountCode.grabFocus();
        tblAccountLoad.setVisible(false);
        jScrollPane4.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadMouseClicked

    private void tblAccountLoadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblAccountLoadFocusLost
        tblAccountLoad.setVisible(false);
        jScrollPane4.setVisible(false);
    }//GEN-LAST:event_tblAccountLoadFocusLost

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        searchEquipment();
    }//GEN-LAST:event_jList1ValueChanged

    private void txtAccountCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccountCodeMouseClicked
        if (tblAccountLoad.isVisible()) {
            tblAccountLoad.setVisible(false);
            jScrollPane4.setVisible(false);
        } else {
            tblAccountLoad.setVisible(true);
            jScrollPane4.setVisible(true);
        }
    }//GEN-LAST:event_txtAccountCodeMouseClicked

    private void bPDFBASICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFBASICActionPerformed
        if (!equipment_no.getText().isEmpty()) {
            try {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                String reportSource = settings.filepath + "fas_report.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("equipment_no", equipment_no.getText());
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Connection c = DBControl.getServerDB_Connection();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
                String path = settings.pdfpath + "FAS Reports\\" + "FAS_Report_" + equipment_no.getText() + ".pdf";
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
                Logger.getLogger(new_fas.class
                        .getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                        null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            setCursor(Cursor.getDefaultCursor());
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Equipment number to generate PDF !");
        }
    }//GEN-LAST:event_bPDFBASICActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    final javax.swing.JButton ShowMaintenanceDetails = new javax.swing.JButton();
    final javax.swing.JButton bAddImage = new javax.swing.JButton();
    final javax.swing.JButton bClearAccountCode = new javax.swing.JButton();
    final javax.swing.JButton bClose1 = new javax.swing.JButton();
    final javax.swing.JButton bDelete = new javax.swing.JButton();
    final javax.swing.JButton bDeleteImage = new javax.swing.JButton();
    final javax.swing.JButton bNew = new javax.swing.JButton();
    final javax.swing.JButton bPDFBASIC = new javax.swing.JButton();
    final javax.swing.JButton bReports = new javax.swing.JButton();
    final javax.swing.JButton bSave = new javax.swing.JButton();
    final javax.swing.JTextField bat_amp = new javax.swing.JTextField();
    final javax.swing.JTextField bat_brand = new javax.swing.JTextField();
    final javax.swing.JTextField bat_no = new javax.swing.JTextField();
    final javax.swing.JTextField bat_type = new javax.swing.JTextField();
    final javax.swing.JTextField bat_volt = new javax.swing.JTextField();
    final javax.swing.JTextField class_vehicle = new javax.swing.JTextField();
    final javax.swing.JComboBox comboSearchitems = new javax.swing.JComboBox();
    final com.toedter.calendar.JDateChooser date_purchase = new com.toedter.calendar.JDateChooser();
    final javax.swing.JTextField engine_capacity = new javax.swing.JTextField();
    final javax.swing.JTextField engine_make = new javax.swing.JTextField();
    final javax.swing.JTextField engine_model = new javax.swing.JTextField();
    final javax.swing.JTextField engine_serial = new javax.swing.JTextField();
    final javax.swing.JFormattedTextField equipment_no = new javax.swing.JFormattedTextField();
    final javax.swing.JTextField filter_airp = new javax.swing.JTextField();
    final javax.swing.JTextField filter_airs = new javax.swing.JTextField();
    final javax.swing.JTextField filter_fuel = new javax.swing.JTextField();
    final javax.swing.JTextField filter_fuel2 = new javax.swing.JTextField();
    final javax.swing.JTextField filter_hyd = new javax.swing.JTextField();
    final javax.swing.JTextField filter_hyd2 = new javax.swing.JTextField();
    final javax.swing.JTextField filter_hyd_tank = new javax.swing.JTextField();
    final javax.swing.JTextField filter_hyd_tank2 = new javax.swing.JTextField();
    final javax.swing.JTextField filter_oil = new javax.swing.JTextField();
    final javax.swing.JTextField filter_oil2 = new javax.swing.JTextField();
    final javax.swing.JTextField filter_sep = new javax.swing.JTextField();
    final javax.swing.JTextField filter_sep2 = new javax.swing.JTextField();
    final javax.swing.JTextField filter_trans = new javax.swing.JTextField();
    final javax.swing.JTextField filter_trans2 = new javax.swing.JTextField();
    final javax.swing.JTextField grn_no = new javax.swing.JTextField();
    final javax.swing.JTextField hirerate = new javax.swing.JTextField();
    final javax.swing.JLabel image = new javax.swing.JLabel();
    final javax.swing.JTextField insurance_company = new javax.swing.JTextField();
    final com.toedter.calendar.JDateChooser insurance_exp = new com.toedter.calendar.JDateChooser();
    final com.toedter.calendar.JDateChooser insurance_issue = new com.toedter.calendar.JDateChooser();
    final javax.swing.JTextField insurance_no = new javax.swing.JTextField();
    final javax.swing.JTextField invoice_no = new javax.swing.JTextField();
    final javax.swing.JFileChooser jFileChooser1 = new javax.swing.JFileChooser();
    final javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel16 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel17 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel18 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel19 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel20 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel21 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel22 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel23 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel24 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel25 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel26 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel27 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel28 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel29 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel30 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel31 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel32 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel33 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel34 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel35 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel36 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel37 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel38 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel39 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel40 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel41 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel42 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel43 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel44 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel45 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel46 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel47 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel48 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel49 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel50 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel51 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel52 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel53 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel54 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel55 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel56 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel57 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel58 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel59 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel60 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel61 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel62 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel63 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel64 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel65 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel66 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel68 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel69 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel70 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel71 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel72 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel73 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel74 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel75 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel76 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel77 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel78 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel79 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel80 = new javax.swing.JLabel();
    final javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    final javax.swing.JLayeredPane jLayeredPane1 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane14 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane2 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane3 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane4 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane5 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane6 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane7 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane8 = new javax.swing.JLayeredPane();
    final javax.swing.JLayeredPane jLayeredPane9 = new javax.swing.JLayeredPane();
    final javax.swing.JList jList1 = new javax.swing.JList();
    final javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
    final javax.swing.JPanel jPanel10 = new javax.swing.JPanel();
    final javax.swing.JPanel jPanel11 = new javax.swing.JPanel();
    final javax.swing.JPanel jPanel7 = new javax.swing.JPanel();
    final javax.swing.JPanel jPanel8 = new javax.swing.JPanel();
    final javax.swing.JPanel jPanel9 = new javax.swing.JPanel();
    final javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    final javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
    final javax.swing.JScrollPane jScrollPane4 = new javax.swing.JScrollPane();
    final javax.swing.JScrollPane jScrollPane6 = new javax.swing.JScrollPane();
    final javax.swing.JToolBar.Separator jSeparator10 = new javax.swing.JToolBar.Separator();
    final javax.swing.JToolBar.Separator jSeparator2 = new javax.swing.JToolBar.Separator();
    final javax.swing.JToolBar.Separator jSeparator3 = new javax.swing.JToolBar.Separator();
    final javax.swing.JToolBar.Separator jSeparator4 = new javax.swing.JToolBar.Separator();
    final javax.swing.JToolBar.Separator jSeparator6 = new javax.swing.JToolBar.Separator();
    final javax.swing.JToolBar.Separator jSeparator7 = new javax.swing.JToolBar.Separator();
    final javax.swing.JToolBar.Separator jSeparator8 = new javax.swing.JToolBar.Separator();
    final javax.swing.JToolBar.Separator jSeparator9 = new javax.swing.JToolBar.Separator();
    final javax.swing.JTabbedPane jTabbedPane1 = new javax.swing.JTabbedPane();
    final javax.swing.JToolBar jToolBar1 = new javax.swing.JToolBar();
    final javax.swing.JLabel lblLastUpdated = new javax.swing.JLabel();
    final javax.swing.JTextField location = new javax.swing.JTextField();
    final javax.swing.JTextField machine_capacity = new javax.swing.JTextField();
    final javax.swing.JTextField machine_chasis = new javax.swing.JTextField();
    final javax.swing.JTextField machine_fuel_consumption = new javax.swing.JTextField();
    final javax.swing.JTextField machine_make = new javax.swing.JTextField();
    final javax.swing.JTextField machine_model = new javax.swing.JTextField();
    final javax.swing.JTextField machine_serial = new javax.swing.JTextField();
    final com.toedter.calendar.JDateChooser maint_date = new com.toedter.calendar.JDateChooser();
    final javax.swing.JButton maint_delete = new javax.swing.JButton();
    final javax.swing.JTextField maint_id = new javax.swing.JTextField();
    final javax.swing.JButton maint_new = new javax.swing.JButton();
    final javax.swing.JTextField maint_nextService = new javax.swing.JTextField();
    final javax.swing.JTextField maint_parts = new javax.swing.JTextField();
    final javax.swing.JTextField maint_reading = new javax.swing.JTextField();
    final javax.swing.JButton maint_save = new javax.swing.JButton();
    final javax.swing.JTextField maint_technician = new javax.swing.JTextField();
    final javax.swing.JTextField operator = new javax.swing.JTextField();
    final javax.swing.JTextField power_amp = new javax.swing.JTextField();
    final javax.swing.JTextField power_hp = new javax.swing.JTextField();
    final javax.swing.JTextField power_rpm = new javax.swing.JTextField();
    final javax.swing.JTextField power_volt = new javax.swing.JTextField();
    final javax.swing.JTextField power_watt = new javax.swing.JTextField();
    final javax.swing.JButton previewFas_report = new javax.swing.JButton();
    final javax.swing.JTextField registration_no = new javax.swing.JTextField();
    final javax.swing.JTextPane remarks = new javax.swing.JTextPane();
    final javax.swing.JButton search = new javax.swing.JButton();
    final javax.swing.JTextField supplier_no = new javax.swing.JTextField();
    final javax.swing.JTable tblAccountLoad = new javax.swing.JTable();
    final javax.swing.JTable tblMaint = new javax.swing.JTable();
    final javax.swing.JTextField txtAccountCode = new javax.swing.JTextField();
    final javax.swing.JTextField txtAccountDescription = new javax.swing.JTextField();
    final javax.swing.JTextField txtSearch = new javax.swing.JTextField();
    final javax.swing.JTextField txtUpdated = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_brandf = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_brandr = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_nof = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_nor = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_prf = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_prr = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_sizef = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_sizer = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_typef = new javax.swing.JTextField();
    final javax.swing.JTextField tyre_typer = new javax.swing.JTextField();
    final javax.swing.JTextField value = new javax.swing.JTextField();
    final com.toedter.calendar.JDateChooser veh_rev_exp = new com.toedter.calendar.JDateChooser();
    final com.toedter.calendar.JDateChooser veh_rev_issue = new com.toedter.calendar.JDateChooser();
    final javax.swing.JTextField veh_rev_no = new javax.swing.JTextField();
    final com.toedter.calendar.JDateChooser vet_cert_exp = new com.toedter.calendar.JDateChooser();
    final com.toedter.calendar.JDateChooser vet_cert_issue = new com.toedter.calendar.JDateChooser();
    final javax.swing.JTextField vet_cert_no = new javax.swing.JTextField();
    final javax.swing.JTextField warranty = new javax.swing.JTextField();
    final javax.swing.JTextField weight = new javax.swing.JTextField();
    final javax.swing.JFormattedTextField yom = new javax.swing.JFormattedTextField();
    // End of variables declaration//GEN-END:variables

    void clear() {
        equipment_no.setText("");
        txtAccountCode.setText("");
        txtAccountDescription.setText("");
        registration_no.setText("");
        class_vehicle.setText("");
        yom.setText("");
        weight.setText("");
        date_purchase.setDate(null);
        location.setText("");
        operator.setText("");
        machine_serial.setText("");
        machine_chasis.setText("");
        machine_make.setText("");
        machine_model.setText("");
        machine_capacity.setText("");
        machine_fuel_consumption.setText("");
        engine_serial.setText("");
        engine_make.setText("");
        engine_model.setText("");
        engine_capacity.setText("");
        power_volt.setText("");
        power_watt.setText("");
        power_hp.setText("");
        power_amp.setText("");
        power_rpm.setText("");
        tyre_sizef.setText("");
        tyre_typef.setText("");
        tyre_brandf.setText("");
        tyre_prf.setText("");
        tyre_nof.setText("");
        tyre_sizer.setText("");
        tyre_typer.setText("");
        tyre_brandr.setText("");
        tyre_prr.setText("");
        tyre_nor.setText("");
        bat_type.setText("");
        bat_volt.setText("");
        bat_amp.setText("");
        bat_brand.setText("");
        bat_no.setText("");
        filter_airp.setText("");
        filter_airs.setText("");
        filter_fuel.setText("");
        filter_fuel2.setText("");
        filter_hyd.setText("");
        filter_hyd2.setText("");
        filter_hyd_tank.setText("");
        filter_hyd_tank2.setText("");
        filter_oil.setText("");
        filter_oil2.setText("");
        filter_sep.setText("");
        filter_sep2.setText("");
        filter_trans.setText("");
        filter_trans2.setText("");
        value.setText("");
        hirerate.setText("");
        warranty.setText("");
        supplier_no.setText("");
        grn_no.setText("");
        invoice_no.setText("");
        remarks.setText("");
        vet_cert_no.setText("");
        vet_cert_issue.setDate(null);
        vet_cert_exp.setDate(null);
        veh_rev_no.setText("");
        veh_rev_issue.setDate(null);
        veh_rev_exp.setDate(null);
        insurance_no.setText("");
        insurance_company.setText("");
        insurance_issue.setDate(null);
        insurance_exp.setDate(null);
        DefaultTableModel dtm11 = (DefaultTableModel) tblMaint.getModel();
        dtm11.setRowCount(0);
        maint_id.setText("");
        maint_date.setDate(null);
        maint_parts.setText("");
        maint_reading.setText("");
        maint_nextService.setText("");
        maint_technician.setText("");
        image.setIcon(null);
        path = "";
        lblLastUpdated.setText("");
    }

    void searchEquipment() {
        clear();
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String s1 = (String) jList1.getSelectedValue();
            if (comboSearchitems.getSelectedIndex() == 0) {
                txtSearch.setText(s1);
            } else {
                txtSearch.setText(s1);
            }
            String Search = txtSearch.getText();
            if (comboSearchitems.getSelectedIndex() == 0) {
                ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM fas_maintenance WHERE equipment_no='" + Search + "'");
                DefaultTableModel dtm = (DefaultTableModel) tblMaint.getModel();
                dtm.setRowCount(0);
                while (rs1.next()) {
                    Vector v = new Vector();
                    v.add(rs1.getString("maintenance_id"));
                    v.add(rs1.getString("date"));
                    v.add(rs1.getString("parts_replaced"));
                    v.add(rs1.getString("service_hour"));
                    v.add(rs1.getString("nextservice_hour"));
                    v.add(rs1.getString("technician"));
                    dtm.addRow(v);
                }
                ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details WHERE equipment_no='" + Search + "'");
                while (rs.next()) {
                    String user = rs.getString("updated_by");
                    String time = rs.getString("updated");
                    if (user == null) {
                        lblLastUpdated.setText("");
                    } else {
                        lblLastUpdated.setText("Last Updated By: " + user + " at " + time);
                    }
                    equipment_no.setText(rs.getString("equipment_no"));
                    txtAccountCode.setText(rs.getString("account_code"));
                    registration_no.setText(rs.getString("registration_no"));
                    class_vehicle.setText(rs.getString("class_vehicle"));
                    yom.setText(rs.getString("yom"));
                    weight.setText(rs.getString("weight"));
                    location.setText(rs.getString("location"));
                    operator.setText(rs.getString("operator"));
                    machine_serial.setText(rs.getString("machine_serial"));
                    machine_chasis.setText(rs.getString("machine_chasis"));
                    machine_make.setText(rs.getString("machine_make"));
                    machine_model.setText(rs.getString("machine_model"));
                    machine_capacity.setText(rs.getString("machine_capacity"));
                    machine_fuel_consumption.setText(rs.getString("machine_fuel_consumption"));
                    engine_serial.setText(rs.getString("engine_serial"));
                    engine_make.setText(rs.getString("engine_make"));
                    engine_model.setText(rs.getString("engine_model"));
                    engine_capacity.setText(rs.getString("engine_capacity"));
                    power_volt.setText(rs.getString("power_volt"));
                    power_watt.setText(rs.getString("power_watt"));
                    power_hp.setText(rs.getString("power_hp"));
                    power_amp.setText(rs.getString("power_amp"));
                    power_rpm.setText(rs.getString("power_rpm"));
                    tyre_sizef.setText(rs.getString("tyre_sizef"));
                    tyre_typef.setText(rs.getString("tyre_typef"));
                    tyre_brandf.setText(rs.getString("tyre_brandf"));
                    tyre_prf.setText(rs.getString("tyre_prf"));
                    tyre_nof.setText(rs.getString("tyre_nof"));
                    tyre_sizer.setText(rs.getString("tyre_sizer"));
                    tyre_typer.setText(rs.getString("tyre_typer"));
                    tyre_brandr.setText(rs.getString("tyre_brandr"));
                    tyre_prr.setText(rs.getString("tyre_prr"));
                    tyre_nor.setText(rs.getString("tyre_nor"));
                    bat_type.setText(rs.getString("bat_type"));
                    bat_volt.setText(rs.getString("bat_volt"));
                    bat_amp.setText(rs.getString("bat_amp"));
                    bat_brand.setText(rs.getString("bat_brand"));
                    bat_no.setText(rs.getString("bat_no"));
                    filter_oil.setText(rs.getString("filter_oil"));
                    filter_oil2.setText(rs.getString("filter_oil2"));
                    filter_fuel.setText(rs.getString("filter_fuel"));
                    filter_fuel2.setText(rs.getString("filter_fuel2"));
                    filter_sep.setText(rs.getString("filter_sep"));
                    filter_sep2.setText(rs.getString("filter_sep2"));
                    filter_hyd_tank.setText(rs.getString("filter_hyd_tank"));
                    filter_hyd_tank2.setText(rs.getString("filter_hyd_tank2"));
                    filter_hyd.setText(rs.getString("filter_hyd"));
                    filter_hyd2.setText(rs.getString("filter_hyd2"));
                    filter_trans.setText(rs.getString("filter_trans"));
                    filter_trans2.setText(rs.getString("filter_trans2"));
                    filter_airp.setText(rs.getString("filter_airp"));
                    filter_airs.setText(rs.getString("filter_airs"));
                    value.setText(rs.getString("value"));
                    hirerate.setText(rs.getString("hirerate"));
                    warranty.setText(rs.getString("warranty"));
                    supplier_no.setText(rs.getString("supplier_no"));
                    grn_no.setText(rs.getString("grn_no"));
                    invoice_no.setText(rs.getString("invoice_no"));
                    remarks.setText(rs.getString("remarks"));

                    vet_cert_no.setText(rs.getString("vet_cert_no"));
                    veh_rev_no.setText(rs.getString("veh_rev_no"));
                    insurance_no.setText(rs.getString("insurance_no"));
                    insurance_company.setText(rs.getString("insurance_company"));
                    try {
                        Date date_purchased = rs.getDate("date_purchase");
                        if (date_purchased != null) {
                            date_purchase.setDate(date_purchased);
                        } else {
                        }
                    } catch (Exception exception) {
                    }
                    //////// VET_CERT_ISSUE////////
                    try {
                        Date reg_vet_issued = rs.getDate("vet_cert_issue");
                        if (reg_vet_issued != null) {
                            vet_cert_issue.setDate(reg_vet_issued);
                        } else {
                        }
                    } catch (Exception exception) {
                    }
                    /////////VET_VERT_EXP///////////
                    try {
                        Date reg_vet_expd = rs.getDate("vet_cert_exp");
                        if (reg_vet_expd != null) {
                            vet_cert_exp.setDate(reg_vet_expd);
                        } else {
                        }
                    } catch (Exception exception) {
                    }
                    /////////VEH_REV_ISSUE////////////
                    try {
                        Date veh_rev_issued = rs.getDate("veh_rev_issue");
                        if (veh_rev_issued != null) {
                            veh_rev_issue.setDate(veh_rev_issued);
                        } else {
                        }
                    } catch (Exception exception) {
                    }
                    /////////VEH_REV_EXP/////////
                    try {
                        Date veh_rev_expd = rs.getDate("veh_rev_exp");
                        if (veh_rev_expd != null) {
                            veh_rev_exp.setDate(veh_rev_expd);
                        } else {
                        }
                    } catch (Exception exception) {
                    }
                    ///////INSURANCE_ISSUE///////
                    try {
                        Date insurance_issued = rs.getDate("insurance_issue");
                        if (insurance_issued != null) {
                            insurance_issue.setDate(insurance_issued);
                        } else {
                        }
                    } catch (Exception exception) {
                    }

                    /////////INSURANCE EXP//////////
                    try {
                        Date insurance_expd = rs.getDate("insurance_exp");
                        if (insurance_expd != null) {
                            insurance_exp.setDate(insurance_expd);
                        } else {
                        }
                    } catch (Exception exception) {
                    }
                    ////////////--END--//////////////

                    imagefile = rs.getString("image");
                    if (imagefile.isEmpty() || imagefile.equals("null")) {
                        image.setIcon(null);
                    } else {
                        try {
                            File f = new File(rs.getString("image"));
                            Image img = ImageIO.read(f);
                            img = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(img);
                            image.setIcon(icon);
                        } catch (Exception ex) {
                        }
                    }
                }
                ResultSet rs11 = DBControl.getResultFromLocalDB("SELECT * FROM account_center WHERE account_code = '" + txtAccountCode.getText() + "'");
                while (rs11.next()) {
                    txtAccountDescription.setText(rs11.getString("description"));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(new_fas.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, ex + " !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        setCursor(Cursor.getDefaultCursor());
    }

    private void update() throws Throwable {
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            Date Ii = insurance_issue.getDate();
            Date Ie = insurance_exp.getDate();
            Date Vi = vet_cert_issue.getDate();
            Date Ve = vet_cert_exp.getDate();
            Date Ri = veh_rev_issue.getDate();
            Date Re = veh_rev_exp.getDate();
            String updated_by = Main.lblUser.getText();

            if (equipment_no.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an equipment number", "Error", JOptionPane.ERROR_MESSAGE);
                equipment_no.grabFocus();
            } else if (Ie != null && Ii != null && Ie.before(Ii)) {
                JOptionPane.showMessageDialog(null, "Please make sure that Expire Date is greater than Issue Date", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (Ve != null && Vi != null && Ve.before(Vi)) {
                JOptionPane.showMessageDialog(null, "Please make sure that Expire Date is greater than Issue Date", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (Re != null && Ri != null && Re.before(Ri)) {
                JOptionPane.showMessageDialog(null, "Please make sure that Expire Date is greater than Issue Date", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ResultSet rss = DBControl.getResultFromLocalDB("SELECT equipment_no From fas_details WHERE equipment_no='" + equipment_no.getText() + "'");
                if (!rss.next()) {
                    JOptionPane.showMessageDialog(null, "Equipment Number " + equipment_no.getText() + " does not exists ! Please select an existing equipment number to Update !", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    try {
                        String Equipment_no = equipment_no.getText();
                        String Account_code = txtAccountCode.getText();
                        String Registration_no = registration_no.getText();
                        String Class_vehicle = class_vehicle.getText();
                        String Yom = yom.getText();
                        String Weight = weight.getText();
                        //Date Date_purchase = date_purchase.getDate();
                        String Location = location.getText();
                        String Operator = operator.getText();
                        String Value = value.getText();
                        String Hire_rate = hirerate.getText();
                        String Machine_serial = machine_serial.getText();
                        String Machine_chasis = machine_chasis.getText();
                        String Machine_make = machine_make.getText();
                        String Machine_model = machine_model.getText();
                        String Machine_capacity = machine_capacity.getText();
                        String Machine_fuel_consumption = machine_fuel_consumption.getText();
                        String Engine_serial = engine_serial.getText();
                        String Engine_make = engine_make.getText();
                        String Engine_model = engine_model.getText();
                        String Engine_capacity = engine_capacity.getText();
                        String Power_volt = power_volt.getText();
                        String Power_watt = power_watt.getText();
                        String Power_hp = power_hp.getText();
                        String Power_amp = power_amp.getText();
                        String Power_rpm = power_rpm.getText();
                        String Tyre_sizef = tyre_sizef.getText();
                        String Tyre_typef = tyre_typef.getText();
                        String Tyre_brandf = tyre_brandf.getText();
                        String Tyre_prf = tyre_prf.getText();
                        String Tyre_nof = tyre_nof.getText();
                        String Tyre_sizer = tyre_sizer.getText();
                        String Tyre_typer = tyre_typer.getText();
                        String Tyre_brandr = tyre_brandr.getText();
                        String Tyre_prr = tyre_prr.getText();
                        String Tyre_nor = tyre_nor.getText();
                        String Bat_type = bat_type.getText();
                        String Bat_volt = bat_volt.getText();
                        String Bat_amp = bat_amp.getText();
                        String Bat_brand = bat_brand.getText();
                        String Bat_no = bat_no.getText();
                        String Filter_airp = filter_airp.getText();
                        String Filter_airs = filter_airs.getText();
                        String Filter_fuel = filter_fuel.getText();
                        String Filter_fuel2 = filter_fuel2.getText();
                        String Filter_hyd = filter_hyd.getText();
                        String Filter_hyd2 = filter_hyd2.getText();
                        String Filter_hyd_tank = filter_hyd_tank.getText();
                        String Filter_hyd_tank2 = filter_hyd_tank2.getText();
                        String Filter_oil = filter_oil.getText();
                        String Filter_oil2 = filter_oil2.getText();
                        String Filter_sep = filter_sep.getText();
                        String Filter_sep2 = filter_sep2.getText();
                        String Filter_trans = filter_trans.getText();
                        String Filter_trans2 = filter_trans2.getText();
                        String Warranty = warranty.getText();
                        String Supplier_no = supplier_no.getText();
                        String Invoice_no = invoice_no.getText();
                        String Grn_no = grn_no.getText();
                        String Remarks = remarks.getText();

                        String reg_vet_no = vet_cert_no.getText();
                        String reg_veh_no = veh_rev_no.getText();
                        String reg_insurance_no = insurance_no.getText();
                        String reg_insurance_company = insurance_company.getText();
                        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

                        String reg_vet_issue = ((JTextField) vet_cert_issue.getDateEditor().getUiComponent()).getText();
                        if (!reg_vet_issue.isEmpty()) {
                            reg_vet_issue = date.format(vet_cert_issue.getDate());
                        } else {
                        }
                        String reg_vet_exp = ((JTextField) vet_cert_exp.getDateEditor().getUiComponent()).getText();
                        if (!reg_vet_exp.isEmpty()) {
                            reg_vet_exp = date.format(vet_cert_exp.getDate());
                        } else {
                        }
                        String reg_veh_issue = ((JTextField) veh_rev_issue.getDateEditor().getUiComponent()).getText();
                        if (!reg_veh_issue.isEmpty()) {
                            reg_veh_issue = date.format(veh_rev_issue.getDate());
                        } else {
                        }
                        String reg_veh_exp = ((JTextField) veh_rev_exp.getDateEditor().getUiComponent()).getText();
                        if (!reg_veh_exp.isEmpty()) {
                            reg_veh_exp = date.format(veh_rev_exp.getDate());
                        } else {
                        }
                        String reg_insurance_issue = ((JTextField) insurance_issue.getDateEditor().getUiComponent()).getText();
                        if (!reg_insurance_issue.isEmpty()) {
                            reg_insurance_issue = date.format(insurance_issue.getDate());
                        } else {
                        }
                        String reg_insurance_exp = ((JTextField) insurance_exp.getDateEditor().getUiComponent()).getText();
                        if (!reg_insurance_exp.isEmpty()) {
                            reg_insurance_exp = date.format(insurance_exp.getDate());
                        } else {
                        }
                        String Date_purchase = ((JTextField) date_purchase.getDateEditor().getUiComponent()).getText();
                        if (!Date_purchase.isEmpty()) {
                            Date_purchase = date.format(date_purchase.getDate());
                        } else {
                        }

                        db.setResult("UPDATE fas_details SET account_code='" + Account_code + "',registration_no = '" + Registration_no + "',"
                                + "location='" + Location + "', operator='" + Operator + "', yom = '" + Yom + "', weight = '" + Weight + "',date_purchase = '" + Date_purchase + "',"
                                + "class_vehicle = '" + Class_vehicle + "',value = '" + Value + "',hirerate = '" + Hire_rate + "', machine_serial = '" + Machine_serial + "', "
                                + "machine_chasis ='" + Machine_chasis + "', machine_make ='" + Machine_make + "', machine_model= '" + Machine_model + "',"
                                + "machine_capacity = '" + Machine_capacity + "',machine_fuel_consumption='" + Machine_fuel_consumption + "', engine_serial = '" + Engine_serial + "', engine_make = '" + Engine_make + "', "
                                + "engine_model = '" + Engine_model + "', engine_capacity ='" + Engine_capacity + "', power_volt = '" + Power_volt + "',"
                                + "power_watt= '" + Power_watt + "', power_hp = '" + Power_hp + "', power_amp = '" + Power_amp + "', power_rpm ='" + Power_rpm + "', "
                                + "tyre_sizef= '" + Tyre_sizef + "', tyre_prf = '" + Tyre_prf + "', tyre_typef = '" + Tyre_typef + "', tyre_brandf= '" + Tyre_brandf + "', "
                                + "tyre_nof ='" + Tyre_nof + "', tyre_sizer = '" + Tyre_sizer + "', tyre_prr = '" + Tyre_prr + "', tyre_typer ='" + Tyre_typer + "', "
                                + "tyre_brandr= '" + Tyre_brandr + "', tyre_nor = '" + Tyre_nor + "', bat_type = '" + Bat_type + "', bat_volt = '" + Bat_volt + "', "
                                + "bat_amp= '" + Bat_amp + "', bat_brand= '" + Bat_brand + "', bat_no ='" + Bat_no + "', filter_oil = '" + Filter_oil + "', "
                                + "filter_oil2 ='" + Filter_oil2 + "', filter_fuel ='" + Filter_fuel + "', filter_fuel2= '" + Filter_fuel2 + "', filter_sep= '" + Filter_sep + "', "
                                + "filter_sep2= '" + Filter_sep2 + "', filter_hyd_tank ='" + Filter_hyd_tank + "', filter_hyd_tank2= '" + Filter_hyd_tank2 + "', "
                                + "filter_hyd= '" + Filter_hyd + "', filter_hyd2= '" + Filter_hyd2 + "', filter_trans ='" + Filter_trans + "', filter_trans2 = '" + Filter_trans2 + "',"
                                + "filter_airp ='" + Filter_airp + "', filter_airs ='" + Filter_airs + "', warranty= '" + Warranty + "', supplier_no= '" + Supplier_no + "',"
                                + "invoice_no= '" + Invoice_no + "', grn_no ='" + Grn_no + "', remarks = '" + Remarks + "', vet_cert_no = '" + reg_vet_no + "', "
                                + "vet_cert_issue = '" + reg_vet_issue + "', vet_cert_exp = '" + reg_vet_exp + "', veh_rev_no = '" + reg_veh_no + "', "
                                + "veh_rev_issue  = '" + reg_veh_issue + "'," + " veh_rev_exp = '" + reg_veh_exp + "', insurance_no = '" + reg_insurance_no + "',"
                                + "insurance_company='" + reg_insurance_company + "',insurance_issue = '" + reg_insurance_issue + "', insurance_exp = '" + reg_insurance_exp + "', image = '" + path + "', updated_by='" + updated_by + "' WHERE equipment_no='" + Equipment_no + "'");
                        //   JOptionPane.showMessageDialog(tyre_typef, "Successfully Updated!", "UPDATED", WIDTH, null);
                        if (DBControl.isSaved() == true) {
                            new systemTray().getTrayicon().displayMessage("Successfully Updated", "Equipment No : [" + Equipment_no + "] ,  Class : [" + Class_vehicle + "]", MessageType.INFO);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Update Failed !  [" + equipment_no.getText() + "]  :", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Failed !", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, e);
        }
        setCursor(Cursor.getDefaultCursor());

    }

    private void refresh() {
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            ResultSet rs = DBControl.getResultFromLocalDB("SELECT * FROM fas_details ORDER BY equipment_no ASC ");
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("equipment_no"));
            }
            jList1.setListData(v);
        } catch (Exception ex) {
            Logger.getLogger(new_fas.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null, "Connection Failed !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        setCursor(Cursor.getDefaultCursor());
    }
    String values = "(equipment_no,account_code,registration_no,location,yom,"
            + " weight,date_purchase,class_vehicle,value,hirerate,machine_serial,machine_chasis, machine_make ,"
            + " machine_model,machine_capacity,machine_fuel_consumption, engine_serial, engine_make,engine_model,engine_capacity,"
            + " power_volt,power_watt, power_hp, power_amp, power_rpm,tyre_sizef, tyre_prf, tyre_typef,"
            + "tyre_brandf,tyre_nof,tyre_sizer, tyre_prr , tyre_typer,tyre_brandr, tyre_nor , bat_type ,"
            + " bat_volt,bat_amp,bat_brand, bat_no , filter_oil,filter_oil2, filter_fuel, filter_fuel2,"
            + " filter_sep,filter_sep2, filter_hyd_tank,filter_hyd_tank2,filter_hyd, filter_hyd2, "
            + "filter_trans, filter_trans2,filter_airp, filter_airs, warranty,supplier_no,invoice_no,"
            + " grn_no, remarks, vet_cert_no,vet_cert_issue, vet_cert_exp, veh_rev_no,veh_rev_issue,"
            + "veh_rev_exp, insurance_no,insurance_issue, insurance_exp , image, updated_by)";
    String valuesWithoutBrackets = "equipment_no,account_code,registration_no,location,yom,"
            + " weight,date_purchase,class_vehicle,value,hirerate,machine_serial,machine_chasis, machine_make ,"
            + " machine_model,machine_capacity,machine_fuel_consumption, engine_serial, engine_make,engine_model,engine_capacity,"
            + " power_volt,power_watt, power_hp, power_amp, power_rpm,tyre_sizef, tyre_prf, tyre_typef,"
            + "tyre_brandf,tyre_nof,tyre_sizer, tyre_prr , tyre_typer,tyre_brandr, tyre_nor , bat_type ,"
            + " bat_volt,bat_amp,bat_brand, bat_no , filter_oil,filter_oil2, filter_fuel, filter_fuel2,"
            + " filter_sep,filter_sep2, filter_hyd_tank,filter_hyd_tank2,filter_hyd, filter_hyd2, "
            + "filter_trans, filter_trans2,filter_airp, filter_airs, warranty,supplier_no,invoice_no,"
            + " grn_no, remarks, vet_cert_no,vet_cert_issue, vet_cert_exp, veh_rev_no,veh_rev_issue,"
            + "veh_rev_exp, insurance_no,insurance_issue, insurance_exp , image,";

    private void load_MaintenanceDetails() {
        try {
            ResultSet rs1 = DBControl.getResultFromLocalDB("SELECT * FROM fas_maintenance WHERE equipment_no='" + equipment_no.getText() + "'");
            DefaultTableModel dtm = (DefaultTableModel) tblMaint.getModel();
            dtm.setRowCount(0);
            while (rs1.next()) {
                Vector v = new Vector();
                v.add(rs1.getString("maintenance_id"));
                v.add(rs1.getString("date"));
                v.add(rs1.getString("parts_replaced"));
                v.add(rs1.getString("service_hour"));
                v.add(rs1.getString("nextservice_hour"));
                v.add(rs1.getString("technician"));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateMaintenanceDetails() {
        try {
            String Equip_no = equipment_no.getText();
            String Maint_id = maint_id.getText();
            String Maint_parts = maint_parts.getText();
            String Maint_reading = maint_reading.getText();
            String Maint_nextService = maint_nextService.getText();
            String Maint_technician = maint_technician.getText();

            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String Maint_date = ((JTextField) maint_date.getDateEditor().getUiComponent()).getText();
            Maint_date = date.format(maint_date.getDate());
            db.setResult("UPDATE fas_maintenance SET date ='" + Maint_date + "', parts_replaced ='" + Maint_parts + "',"
                    + " service_hour ='" + Maint_reading + "', nextservice_hour ='" + Maint_nextService + "',  "
                    + "technician='" + Maint_technician + "'WHERE equipment_no ='" + Equip_no + "'AND maintenance_id ='" + Maint_id + "' ");
            load_MaintenanceDetails();
        } catch (Exception ex) {
            Logger.getLogger(new_fas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error occurred while saving maintenance details " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
