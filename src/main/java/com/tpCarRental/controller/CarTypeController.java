package com.tpCarRental.controller;

import com.google.gson.Gson;
import com.tpCarRental.domain.CarType;
import com.tpCarRental.factories.CarTypeFactory;
import com.tpCarRental.services.Impl.CarTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class CarTypeController {

    @Autowired
    private CarTypeServiceImpl carTypeService;

    @GetMapping(path = "/addCarType/{carTypeId}/{carTypeType}/{carTypePrice}")
    public @ResponseBody
    String addCarType(@PathVariable String carTypeId, @PathVariable String carTypeType, @PathVariable int carTypePrice)
    {
        CarType CarType = CarTypeFactory.buildCarType(carTypeId, carTypeType, carTypePrice);
        carTypeService.save(CarType);
        return new Gson().toJson(CarType);
    }

    @GetMapping(path = "readCarType/{carTypeId}")
    public @ResponseBody String readcarType(@PathVariable String carTypeId)
    {
        CarType CarType = carTypeService.findById(carTypeId);
        return new Gson().toJson(CarType);
    }

    @GetMapping(path = "/updateCarType/{carTypeId}/{carTypeType}/{carTypePrice}")
    public @ResponseBody String updatecarType(@PathVariable String carTypeId, @PathVariable String carTypeType, @PathVariable int carTypePrice)
    {
        CarType CarType = carTypeService.findById(carTypeId);

        if(CarType == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        CarType carTypeInsert = CarTypeFactory.buildCarType(carTypeId, carTypeType, carTypePrice);
        carTypeService.update(carTypeInsert);
        return new Gson().toJson(carTypeInsert);
    }

    @GetMapping(path = "deleteCarType/{carTypeId}")
    public @ResponseBody void deletecarType(@PathVariable String carTypeId) {
        CarType CarType = carTypeService.findById(carTypeId);
        if (CarType == null) {
            System.out.println("Record does not exist");
        } else {
            carTypeService.delete(CarType);
            System.out.println("Record deleted");
        }
    }
}
