package com.tpCarRental.controller;


import com.google.gson.Gson;
import com.tpCarRental.domain.Address;
import com.tpCarRental.domain.Contact;
import com.tpCarRental.domain.Customer;
import com.tpCarRental.factories.CustomerFactory;
import com.tpCarRental.services.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;


    @GetMapping(path = "/addCustomer/{customerId}/{customerName}/{customerSurname}/{customerUsername}/{customerPassword}/{customerLicence}{customerAddressId}/{customerContactId}")
    public @ResponseBody
    String addCustomer(@PathVariable String customerId, @PathVariable String customerName, @PathVariable String customerSurname, @PathVariable String customerUsername, @PathVariable String customerPassword, @PathVariable Boolean customerLicence, @PathVariable Address customerAddressId, @PathVariable Contact customerContactId)
    {
        Customer customer = CustomerFactory.buildCustomer(customerId, customerName,customerSurname,customerUsername,customerPassword,customerLicence,customerAddressId,customerContactId);
        customerService.save(customer);
        return new Gson().toJson(customer);
    }

    @GetMapping(path = "readCustomer/{customerId}")
    public @ResponseBody String readCustomer(@PathVariable String customerId)
    {
        Customer customer = customerService.findById(customerId);
        return new Gson().toJson(customer);
    }

    @GetMapping(path = "/updateCustomer/{customerId}/{customerName}/{customerSurname}/{customerUsername}/{customerPassword}/{customerLicence}{customerAddressId}/{customerContactId}")
    public @ResponseBody String updateCustomer(@PathVariable String customerId, @PathVariable String customerName, @PathVariable String customerSurname, @PathVariable String customerUsername, @PathVariable String customerPassword,
                                               @PathVariable Boolean customerLicence,@PathVariable Address customerAddressId, @PathVariable Contact customerContactId)
    {
        Customer customer = customerService.findById(customerId);

        if(customer == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Customer customerInsert = CustomerFactory.buildCustomer(customerId, customerName,customerSurname,customerUsername,customerPassword,customerLicence,customerAddressId,customerContactId);
        customerService.update(customerInsert);
        return new Gson().toJson(customerInsert);
    }

    @GetMapping(path = "deleteCustomer/{customerId}")
    public @ResponseBody void deleteContact(@PathVariable String customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            System.out.println("Record does not exist");
        } else {
            customerService.delete(customer);
            System.out.println("Record deleted");
        }
    }
    @GetMapping(path = "getAllCustomers")
    public @ResponseBody String getAllCustomers()
    {
        List<Customer> customer = customerService.getCustomer();
        return new Gson().toJson(customer);
    }


}
