package com.tpCarRental.repositories;

import com.tpCarRental.domain.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface AdminRepository extends CrudRepository<Admin, String> {

}
