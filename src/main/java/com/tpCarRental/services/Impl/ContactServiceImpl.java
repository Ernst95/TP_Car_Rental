package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Contact;
import com.tpCarRental.repositories.ContactRepository;
import com.tpCarRental.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/11/04.
 */

@Component
public class ContactServiceImpl implements ContactService {

   @Autowired
    private ContactRepository repository;

   @Override
    public Contact save(Contact entity)
   {
       return repository.save(entity);
   }

   @Override
    public Contact findById(String s)
   {
       return repository.findOne(s);
   }

   @Override
    public Contact update(Contact entity)
   {
       return repository.save(entity);
   }

   @Override
    public void delete(Contact entity)
   {
       repository.delete(entity);
   }
}
