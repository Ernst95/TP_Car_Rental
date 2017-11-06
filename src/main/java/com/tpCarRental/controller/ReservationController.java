package com.tpCarRental.controller;

import com.google.gson.Gson;
import com.tpCarRental.domain.Reservation;
import com.tpCarRental.factories.ReservationFactory;
import com.tpCarRental.services.Impl.ReservationServiceImpl;
import com.tpCarRental.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping(path = "/addReservation/{reservationId}/{receiveDate}/{returnDate}/{paymentAmountDue}/{rentDays}")
    public @ResponseBody
    String addReservation(@PathVariable String reservationId, @PathVariable String receiveDate, @PathVariable String returnDate, @PathVariable double paymentAmountDue,@PathVariable int rentDays)
    {
       Reservation reservation= ReservationFactory.buildReservation(reservationId, receiveDate,returnDate,paymentAmountDue,rentDays);
        reservationService.save(reservation);
        return new Gson().toJson(reservation);


    }

    @GetMapping(path = "readReservation/{reservationId}")
    public @ResponseBody String readReservation(@PathVariable String reservationId)
    {
        Reservation reservation= reservationService.findById(reservationId);
        return new Gson().toJson(reservation);
    }

    @GetMapping(path = "/updateReservation/{reservationId}/{receiveDate}/{returnDate}/{paymentAmountDue}/{rentDays}")
    public @ResponseBody
    String updateReservation(@PathVariable String reservationId, @PathVariable String receiveDate, @PathVariable String returnDate, @PathVariable double paymentAmountDue,@PathVariable int rentDays)

    {
       Reservation reservation=reservationService.findById(reservationId);

        if(reservation == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Reservation reservationInsert = ReservationFactory.buildReservation(reservationId, receiveDate,returnDate,paymentAmountDue,rentDays);
        reservationService.update(reservationInsert);
        return new Gson().toJson(reservationInsert);


    }

    @GetMapping(path = "deleteReservation/{reservationId}")
    public @ResponseBody void deleteReservation(@PathVariable String reservationId) {
       Reservation reservation=reservationService.findById(reservationId);
        if (reservation == null) {
            System.out.println("Record does not exist");
        } else {
            reservationService.delete(reservation);
            System.out.println("Record deleted");
        }
    }

}
