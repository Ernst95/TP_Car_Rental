package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.CarType;
import com.tpCarRental.repositories.CarTypeRepository;
import com.tpCarRental.services.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Component
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    private CarTypeRepository repository;

    @Override
    public CarType save(CarType entity)
    {
        return repository.save(entity);
    }

    @Override
    public CarType findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public CarType update(CarType entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(CarType entity)
    {
        repository.delete(entity);
    }

    public List<CarType> getCarType() {
        List<CarType> allCar = new ArrayList<CarType>();

        Iterable<CarType> car = repository.findAll();
        for (CarType cars : car) {
            allCar.add(cars);
        }
        return allCar;
    }
}
