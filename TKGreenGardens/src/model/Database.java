/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Malsha
 */
public class Database {
    private ArrayList<SubBooking> subBookings = new ArrayList<>();
    private DateCreator dc = new DateCreator();
    private Date today = dc.getDate(0);
    private DateFormat dinyr = new SimpleDateFormat("D");
    private int roomNo = 0;
    public ArrayList<SubBooking> getSubBookingList(int week){
        ArrayList<Date> daysOfWeek = dc.getWeek(week);
        for(int i=0; i< daysOfWeek.size();i++){
            // import the roomNumbers according to the given date
            subBookings.add(new SubBooking(roomNo, daysOfWeek.get(i)));
        }   
        return subBookings;
    }
}