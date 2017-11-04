package com.tpCarRental.factories;

import com.tpCarRental.domain.Address;

/**
 * Created by Ernst on 2017/11/04.
 */
public class AddressFactory {

    public static Address buildAddress(String id, String houseNumber, String streetName, String suburb, String postalCode, String city)
    {
        Address address = new Address.Builder()
                .id(id)
                .houseNumber(houseNumber)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(postalCode)
                .city(city)
                .build();
        return address;
    }
}
