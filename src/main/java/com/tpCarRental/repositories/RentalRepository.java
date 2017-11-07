package com.tpCarRental.repositories;

import com.tpCarRental.domain.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental,String> {
}
