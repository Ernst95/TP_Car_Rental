package com.tpCarRental.controller;

import com.google.gson.Gson;
import com.tpCarRental.domain.Contact;
import com.tpCarRental.factories.ContactFactory;
import com.tpCarRental.services.Impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ernst on 2017/11/04.
 */
@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/tpCarRental")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping(path = "/addContact/{contactId}/{contactCell}/{contactHome}/{contactEmail}")
    public @ResponseBody
    String addContact(@PathVariable String contactId, @PathVariable String contactCell, @PathVariable String contactHome, @PathVariable String contactEmail)
    {
        Contact contact = ContactFactory.buildContact(contactId, contactCell, contactHome, contactEmail);
        contactService.save(contact);
        return new Gson().toJson(contact);
    }

    @GetMapping(path = "readContact/{contactId}")
    public @ResponseBody String readContact(@PathVariable String contactId)
    {
        Contact contact = contactService.findById(contactId);
        return new Gson().toJson(contact);
    }

    @GetMapping(path = "/updateContact/{contactId}/{contactCell}/{contactHome}/{contactEmail}")
    public @ResponseBody String updateContact(@PathVariable String contactId, @PathVariable String contactCell, @PathVariable String contactHome, @PathVariable String contactEmail)
    {
        Contact contact = contactService.findById(contactId);

        if(contact == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Contact contactInsert = ContactFactory.buildContact(contactId, contactCell, contactHome, contactEmail);
        contactService.update(contactInsert);
        return new Gson().toJson(contactInsert);
    }

    @GetMapping(path = "deleteContact/{contactId}")
    public @ResponseBody void deleteContact(@PathVariable String contactId) {
        Contact contact = contactService.findById(contactId);
        if (contact == null) {
            System.out.println("Record does not exist");
        } else {
            contactService.delete(contact);
            System.out.println("Record deleted");
        }
    }
}
