package com.tpCarRental.controller;

import com.google.gson.Gson;
import com.tpCarRental.domain.Address;
import com.tpCarRental.domain.Admin;
import com.tpCarRental.factories.AddressFactory;
import com.tpCarRental.factories.AddressFactory;
import com.tpCarRental.factories.AdminFactory;
import com.tpCarRental.services.Impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ernst on 2017/11/04.
 */
@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping(path = "/addAddress/{id}/{houseNumber}/{streetName}/{suburb}/{postalCode}/{city}")
    public @ResponseBody String addAddress(@PathVariable String id, @PathVariable String houseNumber, @PathVariable String streetName, @PathVariable String suburb, @PathVariable String postalCode, @PathVariable String city)
    {
        Address address = AddressFactory.buildAddress(id, houseNumber, streetName, suburb, postalCode, city);
        addressService.save(address);
        return new Gson().toJson(address);
    }

    @GetMapping(path = "readAddress/{id}")
    public @ResponseBody String readAddress(@PathVariable String id)
    {
        Address address = addressService.findById(id);
        return new Gson().toJson(address);
    }

    @GetMapping(path = "/updateAddress/{id}/{houseNumber}/{streetName}/{suburb}/{postalCode}/{city}")
    public @ResponseBody String updateAddress(@PathVariable String id, @PathVariable String houseNumber, @PathVariable String streetName, @PathVariable String suburb, @PathVariable String postalCode, @PathVariable String city)
    {
        Address address = addressService.findById(id);

        if(address == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Address addressInsert = AddressFactory.buildAddress(id, houseNumber, streetName, suburb, postalCode, city);
        addressService.save(addressInsert);
        return new Gson().toJson(addressInsert);
    }

    @GetMapping(path = "deleteAddress/{id}")
    public @ResponseBody void deleteAddress(@PathVariable String id) {
        Address address = addressService.findById(id);
        if (address == null) {
            System.out.println("Record does not exist");
        } else {
            addressService.delete(address);
            System.out.println("Record deleted");
        }
    }

    @GetMapping(path = "getAllAddresses")
    public @ResponseBody String getAllAddresses()
    {
        List<Address> address = addressService.getAddress();
        return new Gson().toJson(address);
    }
}
