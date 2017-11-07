package com.tpCarRental.domain;

import javax.persistence.*;

@Entity
public class Rental {

    @Id
    private String id;
    private String receiveDate;
    private String returnDate;
    private double paymentAmountDue;
    private int rentDays;
    private Boolean status;


    @ManyToOne
    private Customer customer;


    private Rental()
    {

    }

    //@OneToOne
    //@JoinColumn(name="idOfCar")
    //private Car car


    public String getId() {
        return id;
    }

    public double getPaymentAmountDue() {
        return paymentAmountDue;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getRentDays() {
        return rentDays;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Rental(Builder build)
    {
        this.id=build.id;
        this.returnDate=build.returnDate;
        this.receiveDate=build.receiveDate;
        this.paymentAmountDue=build.paymentAmountDue;
        this.rentDays=build.rentDays;
        this.customer=build.customer;
        this.status=build.status;

    }
    public static class Builder
    {

        private Customer customer;
        private String id;
        private String receiveDate;
        private String returnDate;
        private double paymentAmountDue;
        private int rentDays;
        private Boolean status;

        public Builder id(String value)
        {
            this.id=value;
            return this;


        }

        public Builder receiveDate(String value)
        {

            this.receiveDate=value;
            return this;

        }
        public Builder returnDate(String value)
        {

            this.returnDate=value;
            return this;

        }
        public Builder paymentAmountDue(double value)
        {

            this.paymentAmountDue=value;
            return this;

        }
        public Builder rentDays(int value)
        {
            this.rentDays=value;
            return this;


        }

        public Builder customer(Customer value)
        {

            this.customer=value;
            return this;

        }
        public Builder status(Boolean value)
        {
            this.status=value;
            return this;

        }

       /* public Builder car(Car value)
        {

            this.car=value;
            return this;

        }*/


        public Rental build()
        {
            return new Rental(this);


        }
    }
}
