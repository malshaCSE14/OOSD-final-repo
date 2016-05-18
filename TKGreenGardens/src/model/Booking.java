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
    private List<Payment> payment = new ArrayList<Payment>();
    private int advancePayment = 0;
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

    /**
     * @return the payment
     */
    public List<Payment> getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    /**
     * @return the advancePayment
     */
    public int getAdvancePayment() {
        return advancePayment;
    }

    /**
     * @param advancePayment the advancePayment to set
     */
    public void setAdvancePayment(int advancePayment) {
        this.advancePayment = advancePayment;
    }
    
}
