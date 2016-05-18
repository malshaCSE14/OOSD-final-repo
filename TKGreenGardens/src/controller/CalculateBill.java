/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.RoomBooking;

/**
 *
 * @author Malsha
 */
public class CalculateBill {
    public int getBill(ArrayList<RoomBooking> bookings){
        int amount=0;
        for(int i=0; i<bookings.size();i++){
            int days = bookings.get(i).getDateList().size();
            amount+= (bookings.get(i).getRoom().getPrice()*days);
        }
        return amount;
    }
    
}
