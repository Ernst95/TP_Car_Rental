package com.tpCarRental.repositories;

import com.tpCarRental.domain.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ernst on 2017/11/04.
 */
public interface ContactRepository extends CrudRepository<Contact, String> {

}
