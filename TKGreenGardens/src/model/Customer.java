/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Malsha
 */
public class Customer extends People {

    List<Booking> booking = new ArrayList<Booking>();
    private String customerID;
    private String name;
    private String address;
    private String NIC;
    
    private String region;

    public Customer() {
    }

    public void checkAvailbility(Date date, int no_of_people) {
        //do you confirm book or skip?

    }

    public void addNewBooking() {
        //interface to get details: name,.... 

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

   

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public void setRegion(String region) {
         this.region=region;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

}
