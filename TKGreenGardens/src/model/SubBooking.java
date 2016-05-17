/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Malsha
 */
public class SubBooking extends RoomBooking{
    private int roomNumber;
    private Date date = null;
    public SubBooking(int roomNumber, Date date){
        this.roomNumber = roomNumber;
        this.date = date;
    }
    /**
     * @return the RoomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param RoomNumber the RoomNumber to set
     */
    public void setRoomNumber(int RoomNumber) {
        this.roomNumber = RoomNumber;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
