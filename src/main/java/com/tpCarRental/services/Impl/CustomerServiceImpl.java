package com.tpCarRental.services.Impl;

import com.tpCarRental.domain.Customer;
import com.tpCarRental.repositories.CustomerRepository;
import com.tpCarRental.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer save(Customer entity)
    {
        return repository.save(entity);
    }

    @Override
    public Customer findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Customer update(Customer entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Customer entity)
    {
        repository.delete(entity);
    }
    public List<Customer> getCustomer() {

        List<Customer> allCustomer = new ArrayList<Customer>();

        Iterable<Customer> customer = repository.findAll();
        for (Customer cust : customer) {
            allCustomer.add(cust);
        }
        return allCustomer;
    }

}
