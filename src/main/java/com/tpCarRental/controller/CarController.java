package com.tpCarRental.controller;

import com.google.gson.Gson;
import com.tpCarRental.domain.Car;
import com.tpCarRental.domain.CarType;
import com.tpCarRental.factories.CarFactory;
import com.tpCarRental.services.Impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping(path = "/addCar/{carId}/{carName}/{carModel}/{carYear}/{carType}")
    public @ResponseBody
    String addCar(@PathVariable String carId, @PathVariable String carName, @PathVariable String carModel, @PathVariable String carYear, CarType carType)
    {
        Car car = CarFactory.buildCar(carId, carName, carModel, carYear,carType);
        carService.save(car);
        return new Gson().toJson(car);
    }

    @GetMapping(path = "readCar/{carId}")
    public @ResponseBody String readCar(@PathVariable String carId)
    {
        Car car = carService.findById(carId);
        return new Gson().toJson(car);
    }

    @GetMapping(path = "/updateCar/{carId}/{carName}/{carModel}/{carYear}/{carType}")
    public @ResponseBody String updateCar(@PathVariable String carId, @PathVariable String carName, @PathVariable String carModel, @PathVariable String carYear,@PathVariable CarType carType)
    {
        Car car = carService.findById(carId);

        if(car == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Car carInsert = CarFactory.buildCar(carId, carName, carModel, carYear,carType);
        carService.update(carInsert);
        return new Gson().toJson(carInsert);
    }

    @GetMapping(path = "deleteCar/{carId}")
    public @ResponseBody void deleteCar(@PathVariable String carId) {
        Car car = carService.findById(carId);
        if (car == null) {
            System.out.println("Record does not exist");
        } else {
            carService.delete(car);
            System.out.println("Record deleted");
        }
    }
}
