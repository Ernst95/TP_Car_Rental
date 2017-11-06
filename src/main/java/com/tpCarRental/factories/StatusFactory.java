package com.tpCarRental.factories;


import com.tpCarRental.domain.Status;
import com.tpCarRental.domain.CarType;

public class StatusFactory {

    public static Status buildStatus(String id, String statuc,CarType carType)
    {
        Status status = new Status.Builder()
                .id(id)
                .statuc(statuc)
                .carType(carType)
                .build();
        return status;
    }
}
