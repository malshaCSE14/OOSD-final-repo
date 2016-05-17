package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Malsha
 */
public class Booking {

    private int bookingIndex;
    private Customer customer;
    
    List<Payment> payment = new ArrayList<Payment>();

    public Booking() {
    }

    /**
     * @return the bookingIndex
     */
    public int getBookingIndex() {
        return bookingIndex;
    }

    /**
     * @param bookingIndex the bookingIndex to set
     */
    public void setBookingIndex(int bookingIndex) {
        this.bookingIndex = bookingIndex;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
