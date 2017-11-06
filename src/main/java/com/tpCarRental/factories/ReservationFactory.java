package com.tpCarRental.factories;

import com.tpCarRental.domain.Reservation;

public class ReservationFactory {
    public static Reservation buildReservation(String id, String receiveDate, String returnDate, double paymentAmountDue,int rentDays)
    {
        Reservation reservation=new Reservation.Builder()
                .id(id)
                .receiveDate(receiveDate)
                .returnDate(returnDate)
                .paymentAmountDue(paymentAmountDue)
                .rentDays(rentDays)
                .build();
        return reservation;
    }


}
