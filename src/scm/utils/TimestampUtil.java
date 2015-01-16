/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author anuwlk
 */
public class TimestampUtil {

    public static String getTimestamp() {
        Date today = new Date();
        long time = today.getTime();
        Timestamp ts = new Timestamp(time);
        String timestamp = ts.toString();
        return timestamp;
    }

}
