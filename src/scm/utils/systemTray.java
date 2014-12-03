
package scm.utils;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class systemTray {

    private static JFrame jframe;
    private static TrayIcon trayicon;

    public JFrame getJframe() {
        return jframe;
    }

    public void setJframe(final JFrame jframe) {
        this.jframe = jframe;
        trayicon = new TrayIcon(new ImageIcon(jframe.getClass().getResource("/images/tray_icon.png")).getImage(), "Warehouse Management System", getMenu());
        try {
            java.awt.SystemTray.getSystemTray().add(trayicon);
        } catch (Exception e) {
        }
    }

    
    private PopupMenu getMenu(){
        PopupMenu pm = new PopupMenu();
        MenuItem sub1=new MenuItem("Hide");
        MenuItem sub2=new MenuItem("Open");
        MenuItem sub3=new MenuItem("Exit");
        pm.add(sub1);
        pm.add(sub2);
        pm.add(sub3);
        
        sub1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jframe.setState(jframe.MAXIMIZED_BOTH);
                jframe.setVisible(false);
            }
        });
        sub2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setState(jframe.MAXIMIZED_BOTH);
                jframe.setVisible(true);
            }
        });
        sub3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            //  jframe.dispose();
               System.exit(0);
            }
        });
        return pm;
    }
    public TrayIcon getTrayicon() {
        return trayicon;
    }

    public void setTrayicon(TrayIcon trayicon) {
        this.trayicon = trayicon;
    }
}
