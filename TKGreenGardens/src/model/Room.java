/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Malsha
 */
public class Room {

    private int price;
    private int roomNo;
    
    public Room(int roomNo) {
        this.roomNo=roomNo;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the roomNo
     */
    public int getRoomNo() {
        return roomNo;
    }
    
   

}
