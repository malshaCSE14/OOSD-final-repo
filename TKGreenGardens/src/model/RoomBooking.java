/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Malsha
 */
public class RoomBooking extends Booking{
    private Room room;
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;
    private int noOfAdults;
    private int noOfChildren;
    
    
    private ArrayList<Date> dateList = new ArrayList<>();
    
    
    
    /**
     * @param noOfChildren the noOfChildren to set
     */
    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }
    
    /**
     * @return the noOfChildren
     */
    public int getNoOfChildren() {
        return noOfChildren;
    }
    /**
     * @return the checkIn
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return the noOfAdults
     */
    public int getNoOfAdults() {
        return noOfAdults;
    }

    /**
     * @param noOfPeople the noOfAdults to set
     */
    public void setNoOfAdults(int noOfPeople) {
        this.noOfAdults = noOfPeople;
    }


    /**
     * @return the dateList
     */
    public ArrayList<Date> getDateList() {
        return dateList;
    }

    /**
     * @param dateList the dateList to set
     */
    public void setDateList(ArrayList<Date> dateList) {
        this.dateList = dateList;
    }

    /**
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }


    
}
