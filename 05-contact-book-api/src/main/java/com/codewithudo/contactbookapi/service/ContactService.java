package com.codewithudo.contactbookapi.service;

import com.codewithudo.contactbookapi.model.Contact;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ContactService {

    ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public Contact getContactById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id)
                return contact;
        }
        return null;
    }

    public ArrayList<Contact> addContact(Contact contact) {
        contacts.add(contact);
        return contacts;
    }

    public ArrayList<Contact> removeContact(Contact contact) {
        contacts.remove(contact);
        return contacts;
    }

    public ArrayList<Contact> updateContact(int id, Contact contact) {
        contacts.get(id).setName(contact.getName());
        contacts.get(id).setAddress(contact.getAddress());
        contacts.get(id).setEmail(contact.getEmail());
        contacts.get(id).setPhone(contact.getPhone());
        return contacts;

    }

}
