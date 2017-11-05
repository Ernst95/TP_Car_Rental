package com.tpCarRental.repositories;

import com.tpCarRental.domain.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Ernst on 2017/11/04.
 */
public interface AddressRepository extends CrudRepository<Address, String> {

    //public List<Address> findByAge(int age);
    //public List<Address> findById(String id);

}
