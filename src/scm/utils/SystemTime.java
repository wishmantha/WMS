/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author anuwlk
 */
public class SystemTime {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
        System.out.println(getCurrentDateTime());
    }
    public static String getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
}
