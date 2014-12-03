/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anuwlk
 */
public class PingResult {

    public static void main(String[] args) {
        String ip = "173.194.108.45 -t10";
        String pingResult = "";
        String pingCmd = "ping " + ip;
        try {
            
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
//                pingResult += inputLine;
//            }
            Pattern pattern = Pattern.compile("time=(\\d+)ms|(Request timed out)");
            Matcher m = null;
            while ((inputLine = in.readLine()) != null) {
                pingServer();
                System.out.println(inputLine);
                m = pattern.matcher(inputLine);
                if (m.find() && m.group(1) != null) {
                    //  System.out.println(m.group(1));
                    // System.out.println(m.group(2));
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void pingServer() throws UnknownHostException, IOException {
        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 173.194.108.45");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal==0);
            System.out.println(reachable);
        } catch (InterruptedException ex) {
            Logger.getLogger(PingResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
