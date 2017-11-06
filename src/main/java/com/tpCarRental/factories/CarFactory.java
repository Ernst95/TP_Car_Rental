package com.tpCarRental.factories;


import com.tpCarRental.domain.Car;
import com.tpCarRental.domain.CarType;

import java.util.ArrayList;
import java.util.Map;

public class CarFactory {

    public static Car buildCar(String id, String name, String model, String year,CarType carType)
    {
        Car car = new Car.Builder()
                .id(id)
                .name(name)
                .model(model)
                .year(year)
                .carType(carType)
                .build();
        return car;
    }
}
