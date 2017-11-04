package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Admin;
import com.tpCarRental.repositories.AdminRepository;
import com.tpCarRental.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/08/14.
 */

@Component
public class AdminServiceImpl implements AdminService {

   @Autowired
    private AdminRepository repository;

   @Override
    public Admin save(Admin entity)
   {
       return repository.save(entity);
   }

   @Override
    public Admin findById(String s)
   {
       return repository.findOne(s);
   }

   @Override
    public Admin update(Admin entity)
   {
       return repository.save(entity);
   }

   @Override
    public void delete(Admin entity)
   {
       repository.delete(entity);
   }
}
