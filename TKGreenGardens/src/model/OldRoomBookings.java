/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBOperations;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nethmi
 */
public class OldRoomBookings {

    private ArrayList<SubBooking> subBookings = new ArrayList<>();
    private DBOperations db = DBOperations.getInstance();
    private DateCreator dc = new DateCreator();

    public ArrayList<SubBooking> getSubBookingList(int week) {
        ArrayList<Room> rooms = new ArrayList<>();
        //rooms.add(new Room(3));
        ArrayList<Date> daysOfWeek = dc.getWeek(week * 7);
        for (int i = 0; i < daysOfWeek.size(); i++) {
            // import the roomNumbers according to the given date
            rooms = db.getBookedRooms(new java.sql.Date(daysOfWeek.get(i).getTime()));
            //System.out.println(rooms);
            for (int j = 0; j < rooms.size(); j++) {
                subBookings.add(new SubBooking(rooms.get(j).getRoomNo(), daysOfWeek.get(i)));
            }
        }
        return subBookings;
    }

}

