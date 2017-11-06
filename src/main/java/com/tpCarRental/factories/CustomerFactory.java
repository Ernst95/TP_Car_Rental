package com.tpCarRental.factories;

import com.tpCarRental.domain.Address;
import com.tpCarRental.domain.Contact;
import com.tpCarRental.domain.Customer;

public class CustomerFactory {

    public static Customer buildCustomer(String id, String name, String surname, String username, String password, Boolean licence,Address address_id, Contact contact_id)
    {
       Customer customer = new Customer.Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .userName(username)
                .password(password)
                .licence(licence)
                .address_id(address_id)
                .contact_id(contact_id)
                .build();
        return customer;
    }
}
