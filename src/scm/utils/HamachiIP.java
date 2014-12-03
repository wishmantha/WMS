/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.utils;

import java.net.*;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anuradha
 */
public class HamachiIP {

    public static String HamachiIPAddress;
    public static String HamachiUsername;

//    public static void main(String[] args) {
//        System.out.println(getHamachiUsername());
//
//    }
    public static String getHamachiIPAddress() {
        try {
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            while (ifaces.hasMoreElements()) {
                NetworkInterface iface = ifaces.nextElement();
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr instanceof Inet4Address && !addr.isLoopbackAddress()) {
                        if (iface.getDisplayName() == null) {
                            System.out.println("Null Interface Name detected");
                        } else if (iface.getDisplayName().contains("Hamachi Network Interface")) {
                            HamachiIPAddress = addr.getHostAddress();
                            System.out.println("--HamchiIP:Hamachi IP from Hamachi Network Interface " + HamachiIPAddress);
                        } else {
                            for (InterfaceAddress address : iface.getInterfaceAddresses()) {
                                if (address.getNetworkPrefixLength() == 8) { // NetworkPrefixLength of 8 = 255.0.0.0
                                    HamachiIPAddress = address.getAddress().toString().replace("/", "");
                                    System.out.println("--HamchiIP:Hamachi IP from Subnet mask " + HamachiIPAddress);
                                }
//                                else {
//                                    JOptionPane.showMessageDialog(null, "ERROR: Couldn't get Hamachi IP from Network Interfaces at ipconfig", "Error", JOptionPane.ERROR_MESSAGE);
//                                }
                            }
                        }
                    }

                }

            }
        } catch (SocketException ex) {
            Logger.getLogger(HamachiIP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return HamachiIPAddress;
    }

    public static String getHamachiUsername() {
        HamachiUsername = CreateProperties.getPropertyValue(getHamachiIPAddress());
        if (HamachiUsername == null) {
            CreateProperties.newProperty(getHamachiIPAddress(), "NEW_USER");
            HamachiUsername = CreateProperties.getPropertyValue(getHamachiIPAddress());
        }
        return HamachiUsername;
    }

}
