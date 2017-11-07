package com.tpCarRental.factories;

import com.tpCarRental.domain.Car;
import com.tpCarRental.domain.Customer;
import com.tpCarRental.domain.Rental;

public class RentalFactory {
    public static Rental buildRental(String id, String receiveDate, String returnDate, double paymentAmountDue, int rentDays, Customer customer,Boolean status, Car car)
    {
        Rental rental=new Rental.Builder()
                .id(id)
                .receiveDate(receiveDate)
                .returnDate(returnDate)
                .paymentAmountDue(paymentAmountDue)
                .rentDays(rentDays)
                .customer(customer)
                .status(status)
                .car(car)
                .build();
        return rental;
    }
}
