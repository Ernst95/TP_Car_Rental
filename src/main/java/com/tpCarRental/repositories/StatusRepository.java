package com.tpCarRental.repositories;

import com.tpCarRental.domain.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StatusRepository extends CrudRepository<Status, String>{

    public List<Status> findByStatus(String statuc);
}
