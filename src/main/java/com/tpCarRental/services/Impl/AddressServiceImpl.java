package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Address;
import com.tpCarRental.repositories.AddressRepository;
import com.tpCarRental.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
