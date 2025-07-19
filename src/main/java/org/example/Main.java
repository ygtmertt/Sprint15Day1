package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Contact contact1 = new Contact("Eren", "0520 123 45 89");
        Contact contact2 = new Contact("Ali", "0569 448 12 23");
        Contact contact3 = new Contact("Zeynep", "0564 804 11 23");
        MobilePhone phone1 = new MobilePhone("0506 407 17 19", new ArrayList<>());

        contact1.getName();
        phone1.addNewContact(contact1);
        phone1.addNewContact(contact2);
        phone1.addNewContact(contact3);
        phone1.printContacts();
    }
}
