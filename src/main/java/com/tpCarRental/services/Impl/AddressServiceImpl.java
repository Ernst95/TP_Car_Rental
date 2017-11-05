package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Address;
import com.tpCarRental.repositories.AddressRepository;
import com.tpCarRental.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ernst on 2017/11/04.
 */

@Component
public class AddressServiceImpl implements AddressService {

   @Autowired
    private AddressRepository repository;

   @Override
    public Address save(Address entity)
   {
       return repository.save(entity);
   }

   @Override
    public Address findById(String s)
   {
       return repository.findOne(s);
   }

   @Override
    public Address update(Address entity)
   {
       return repository.save(entity);
   }

   @Override
    public void delete(Address entity)
   {
       repository.delete(entity);
   }

   //return all addresses
    public List<Address> getAddress() {

        List<Address> allAddress = new ArrayList<Address>();

        Iterable<Address> address = repository.findAll();
        for (Address addr : address) {
            allAddress.add(addr);
        }
        return allAddress;
    }

    //return all requested cities
    public List<Address> getAddressCity(String city) {

        List<Address> allAddress = new ArrayList<Address>();

        Iterable<Address> address = repository.findAll();

        for (Address addr : address) {

            /*System.out.println("Address City: " + addr.getCity());
            System.out.println("City: " + city);*/

            String value = addr.getCity();

            /*if(a.equals(city))
            {
                System.out.println("Match");
            }*/

            if(city.equals(value))
            {
                allAddress.add(addr);
            }
        }
        return allAddress;
    }

}
