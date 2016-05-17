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
public class Receptionist extends People{
    
    public void addNewBooking(Booking booking,int ID,int roomNo, Date date, String mobileNo, String customerName){
        // interface to get details: name,.... 
        // call advancePayment (optional)

    }
    
    public void checkBooking(String roomCondition ,Date date, String roomPackage){
        //true: if room is available -> want to book? then addNewBooking
        //, false: otherwise
    }
    
    public void addAdvancepayment(Booking booking, int amount){
    }
    
    public void modification(String HallPackage){
    }
   
    public void createHallBooking(Booking booking, Date date, String mobileNo, String hallPackage,String customerName){
    }
    
    public void registerPayment(Booking booking, int amount){
        // check amount to be paid, calculate balance
    }
}
