package com.tpCarRental.factories;

import com.tpCarRental.domain.Status;

public class StatusFactory {

    public static Status buildStatus(String id, String statuses)
    {
        Status status = new Status.Builder()
            .id(id)
            .statuses(statuses)
            .build();
        return status;
    }
}
