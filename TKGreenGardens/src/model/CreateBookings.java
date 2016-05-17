/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Malsha
 */
public class CreateBookings {

    private ArrayList<RoomBooking> bookingList = new ArrayList<>();
    private ArrayList<Date> dateList;
    private DateFormat dfy = new SimpleDateFormat("D");

    public ArrayList<RoomBooking> getBookingList(ArrayList<SubBooking> subBookingList) {
        for (int i = 0; i < subBookingList.size(); i++) {
            boolean added = false;
            int roomNo = subBookingList.get(i).getRoomNumber();

            int date1InYear = Integer.parseInt(dfy.format(subBookingList.get(i).getDate()));

            for (int j = 0; j < bookingList.size(); j++) {
                if (bookingList.get(j).getRoomNumber() == roomNo) {
                    dateList = bookingList.get(j).getDateList();
                    for (int m = 0; m < dateList.size(); m++) {
                        int date2InYear = Integer.parseInt(dfy.format(dateList.get(m)));
                        if (Math.abs(date1InYear - date2InYear) == 1) {
                            bookingList.get(j).getDateList().add(subBookingList.get(i).getDate());
                            // e sub booking eka me booking ekatama add karanna puluwan
                            added = true;
//                            System.out.println("-1- added to room" + bookingList.get(j).getRoomNumber() + "for date" + subBookingList.get(i).getDate());
                            break;
                        }
                    }

                }

                // dateList.clear();
                if (added) {
                    break;
                }
            }
            if (added == false) {
                RoomBooking b = new RoomBooking();
                b.setRoomNumber(roomNo);
                b.getDateList().add(subBookingList.get(i).getDate());
                //System.out.println("-2- added to room" + b.getRoomNumber() + "for date" + subBookingList.get(i).getDate());
                

                bookingList.add(b);
                added = true;
            }
        }
        //System.out.println("bookingList.size()" + bookingList.size());
        for(int i=0; i<bookingList.size();i++){
            Date checkIn = Collections.min(bookingList.get(i).getDateList());
            Date checkOut = Collections.max(bookingList.get(i).getDateList());
            bookingList.get(i).setCheckIn(checkIn);
            bookingList.get(i).setCheckOut(checkOut);
            //System.out.println(i+" CheckIn "+checkIn);
            //System.out.println(i+" CheckOut "+checkOut);
            
        }
        
        return bookingList;
    }

}
