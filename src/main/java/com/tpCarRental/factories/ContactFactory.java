package com.tpCarRental.factories;

import com.tpCarRental.domain.Contact;

/**
 * Created by Ernst on 2017/11/04.
 */
public class ContactFactory {

    public static Contact buildContact(String id, String cell, String home, String email)
    {
        Contact contact = new Contact.Builder()
                .id(id)
                .cell(cell)
                .home(home)
                .email(email)
                .build();
        return contact;
    }
}
