package com.tpCarRental.repositories;

import com.tpCarRental.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,String>{


}
