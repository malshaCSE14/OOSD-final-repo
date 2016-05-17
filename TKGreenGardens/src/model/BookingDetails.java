/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Malsha
 */
public class BookingDetails {
     public String getDate(int i) {
        DateFormat df = new SimpleDateFormat("MMM d");
        Date dateobj = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dateobj);
        c.add(Calendar.DATE, i);
        Date tomorrow;
        tomorrow = c.getTime();

        return df.format(tomorrow);
    }
    
}
