package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Car;
import com.tpCarRental.repositories.CarRepository;
import com.tpCarRental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StatusServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> getCar(String name)
    {
        return repository.findByName(name);
    }

    @Override
    public Car save(Car entity)
    {
        return repository.save(entity);
    }

    @Override
    public Car findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Car update(Car entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Car entity)
    {
        repository.delete(entity);
    }


}
