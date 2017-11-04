package com.tpCarRental.repositories;

import com.tpCarRental.domain.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ernst on 2017/11/04.
 */
public interface AddressRepository extends CrudRepository<Address, String> {

}
