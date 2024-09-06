package com.BookStore.BookStoreManagement.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")//the name of the database table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;//unique identifier for the customer ,auto generated by the database
    @Column(nullable = false)
    private String customerName;//customer name can not be null
    private String customerAddress;//customer address
    private String customerMNumber;//customer number
    private String customerEmail;//customer email



    /**
     * gets the customer id
     * @return unique key for the customer
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * set the customer id
     * @param customerID unique key to set the customer
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * get customer name
     * @return the name of the customer
     */
     public String getCustomerName() {
        return customerName;
    }

    /**
     * set customer name
     * @param customerName the name to set for customer
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * gets the customer address.
     * @return the address of the customer.
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Sets the customer address
     * @param customerAddress the address to set for the customer
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Gets the customer mobile number
     * @return the mobile number of the custome
     */
    public String getCustomerMNumber() {
        return customerMNumber;
    }

    /**
     * Sets the customer mobile number.
     * @param customerMNumber the mobile number to set for the customer.
     */
    public void setCustomerMNumber(String customerMNumber) {
        this.customerMNumber = customerMNumber;
    }

    /**
     * Gets the customer email.
     * @return the email of the customer.
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the customer email.
     * @param customerEmail the email to set for the customer.
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


}

