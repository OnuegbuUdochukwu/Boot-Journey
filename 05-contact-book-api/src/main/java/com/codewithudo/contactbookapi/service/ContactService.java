package com.codewithudo.contactbookapi.service;

import com.codewithudo.contactbookapi.model.Contact;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final ArrayList<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    public ArrayList<Contact> addContact(Contact contact) {
        contact.setId(nextId++);
        contacts.add(contact);
        return contacts;
    }

    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }

    public Contact getContactById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id)
                return contact;
        }
        return null;
    }

    public boolean updateContact(int id, Contact updatedContact) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contact.setName(updatedContact.getName());
                contact.setAddress(updatedContact.getAddress());
                contact.setEmail(updatedContact.getEmail());
                contact.setPhone(updatedContact.getPhone());
                return true;
            }
        }
        return false;
    }

    public boolean removeContact(int id) {
        return contacts.removeIf(contact -> contact.getId().equals(id));
    }

}
