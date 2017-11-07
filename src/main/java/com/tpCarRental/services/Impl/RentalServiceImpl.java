package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Rental;
import com.tpCarRental.repositories.RentalRepository;
import com.tpCarRental.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository repository;

    @Override
    public Rental save(Rental entity)
    {
        return repository.save(entity);
    }

    @Override
    public Rental findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Rental update(Rental entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Rental entity)
    {
        repository.delete(entity);
    }


}
