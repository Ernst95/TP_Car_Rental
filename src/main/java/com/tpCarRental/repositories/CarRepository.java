package com.tpCarRental.repositories;

import com.tpCarRental.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CarRepository extends CrudRepository<Car, String>{

    public List<Car> findByName(String name);
}
