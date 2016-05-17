/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malsha
 */
public class Hotel {
   
    private static Hotel instance;
    private Hall hall;

    List<People> people = new ArrayList<People>();
    List<Room> booking = new ArrayList<Room>();

    private List<HallBooking> hallbooking = new ArrayList<HallBooking>();

    private Hotel() {
    }

    public static Hotel getInstance() {
        if (instance == null) {
            instance = new Hotel();
        }
        return instance;
    }

    public void setHallbooking(HallBooking hallbooking) {
        this.getHallbooking().add(hallbooking);
    }

    /**
     * @return the hallbooking
     */
    public List<HallBooking> getHallbooking() {
        return hallbooking;
    }
    
  
}
