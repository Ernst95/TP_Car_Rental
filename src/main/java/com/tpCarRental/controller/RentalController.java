package com.tpCarRental.controller;

import com.google.gson.Gson;
import com.tpCarRental.domain.Car;
import com.tpCarRental.domain.Customer;
import com.tpCarRental.domain.Rental;
import com.tpCarRental.factories.RentalFactory;
import com.tpCarRental.services.Impl.RentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class RentalController {

    @Autowired
    private RentalServiceImpl rentalService;

    @GetMapping(path = "/addRental/{rentalId}/{receiveDate}/{returnDate}/{paymentAmountDue}/{rentDays}/{customer}/{status}/{carId}")
    public @ResponseBody
    String addRental(@PathVariable String rentalId, @PathVariable String receiveDate, @PathVariable String returnDate, @PathVariable double paymentAmountDue,@PathVariable int rentDays,@PathVariable Customer customer, @PathVariable Boolean status, @PathVariable Car car)
    {
        Rental rental= RentalFactory.buildRental(rentalId, receiveDate,returnDate,paymentAmountDue,rentDays,customer,status, car);
        rentalService.save(rental);
        return new Gson().toJson(rental);


    }

    @GetMapping(path = "readRental/{rentalId}")
    public @ResponseBody String readRental(@PathVariable String rentalId)
    {
        Rental rental=rentalService.findById(rentalId);
        return new Gson().toJson(rental);
    }

    @GetMapping(path = "/updateRental/{rentalId}/{receiveDate}/{returnDate}/{paymentAmountDue}/{rentDays}/{customer}/{status}/{carId}")
    public @ResponseBody
    String updateRental(@PathVariable String rentalId, @PathVariable String receiveDate, @PathVariable String returnDate, @PathVariable double paymentAmountDue,@PathVariable int rentDays,@PathVariable Customer customer,@PathVariable Boolean status, @PathVariable Car car)

    {
        Rental rental=rentalService.findById(rentalId);

        if(rental == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Rental rentalInsert = RentalFactory.buildRental(rentalId, receiveDate,returnDate,paymentAmountDue,rentDays,customer,status,car);
        rentalService.update(rentalInsert);
        return new Gson().toJson(rentalInsert);


    }

    @GetMapping(path = "deleteRental/{rentalId}")
    public @ResponseBody void deleteRental(@PathVariable String rentalId) {
        Rental rental=rentalService.findById(rentalId);
        if (rental == null) {
            System.out.println("Record does not exist");
        } else {
            rentalService.delete(rental);
            System.out.println("Record deleted");
        }
    }


}
