package com.codewithudo.contactbookapi.controller;

import com.codewithudo.contactbookapi.model.Contact;
import com.codewithudo.contactbookapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Contact>>  getContacts() {
        return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ArrayList<Contact>> addContact(@RequestBody Contact contact) {
        ArrayList<Contact> updatedContacts = contactService.addContact(contact);
        return new ResponseEntity<>(updatedContacts, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> updateContact(@PathVariable int id, @RequestBody Contact updatedContact) {
        boolean updated = contactService.updateContact(id, updatedContact);
        if (updated) {
            return new ResponseEntity<>("Contact updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contact not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteContact(@PathVariable int id) {
        boolean deleted = contactService.removeContact(id);
        if (deleted) {
            return new ResponseEntity<>("Contact deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contact not found.", HttpStatus.NOT_FOUND);
        }
    }

}
