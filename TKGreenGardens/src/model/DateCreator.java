/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Malsha
 */
 public class DateCreator {

    public Date getDate(int i) {
        DateFormat df = new SimpleDateFormat("MMM d");
        Date dateobj = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dateobj);
        c.add(Calendar.DATE, i);
        Date date;
        date = c.getTime();
        return date;
    }
    public Date getFirstDay(Date date){
        DateCreator d = new DateCreator();
        //Date date = d.getDate(i);
        DateFormat df = new SimpleDateFormat("u");
        int dayOfWeek = Integer.parseInt(df.format(date));
        //System.out.println(dayOfWeek);
        DateFormat dfy = new SimpleDateFormat("D");
        int i = Integer.parseInt(dfy.format(date))-Integer.parseInt(dfy.format(d.getDate(0)));
        
        Date monday = d.getDate(i-dayOfWeek+1);
        DateFormat df2 = new SimpleDateFormat("MMM d");
        
        
        return monday;
  
        
    }
    public ArrayList<Date> getWeek(int i){
        ArrayList<Date> week = new ArrayList<Date>();
        DateCreator dc = new DateCreator();
        for(int k=0; k<7; k++){
            week.add(dc.getDate(i+k));
        }
        return week;
    }
    

}
