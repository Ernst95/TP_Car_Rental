package com.tpCarRental.factories;

import com.tpCarRental.domain.CarType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarTypeFactory {

    public static CarType buildCarType(String id, String type,int price)
    {
        CarType carType = new CarType.Builder()
            .id(id)
            .type(type)
            .price(price)
            .build();
        return carType;
    }
}
