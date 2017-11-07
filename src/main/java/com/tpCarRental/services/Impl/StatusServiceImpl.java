package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Status;
import com.tpCarRental.repositories.StatusRepository;
import com.tpCarRental.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository repository;

    @Override
    public Status save(Status entity)
    {
        return repository.save(entity);
    }

    @Override
    public Status findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Status update(Status entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Status entity)
    {
        repository.delete(entity);
    }

    public List<Status> getStatus() {
        List<Status> allRental = new ArrayList<Status>();

        Iterable<Status> rental = repository.findAll();
        for (Status status : rental) {
            allRental.add(status);
        }
        return allRental;
    }
}
