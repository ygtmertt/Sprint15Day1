package org.example.mobile;

import java.util.ArrayList;

public class MobilePhone {
  private String myNumber;
  private ArrayList<Contact> myContacts;

  public MobilePhone(String myNumber, ArrayList<Contact> myContacts) {
    this.myNumber = myNumber;
    this.myContacts = myContacts;
  }

  public boolean addNewContact(Contact newContact) {
    if(!myContacts.contains(newContact)) {
      myContacts.add(newContact);
      return true;
    }
    else {
      return false;
    }
  }

  public boolean updateContact(Contact oldContact, Contact newContact) {
    if(myContacts.contains(oldContact)) {
      myContacts.set(myContacts.indexOf(oldContact), newContact);
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeContact(Contact contactToBeDeleted) {
    if(myContacts.contains(contactToBeDeleted)) {
      myContacts.remove(contactToBeDeleted);
      return true;
    }
    else {
      return false;
    }
  }

  public int findContact(Contact contactToBeFound) {
    if(myContacts.contains(contactToBeFound)) {
      return myContacts.indexOf(contactToBeFound);
    }
    else {
      return -1;
    }
  }

  public int findContact(String contactToBeFound) {
    for (int i = 0; i < myContacts.size(); i++) {
      if (myContacts.get(i).getName().equals(contactToBeFound)) {
        return i;
      }
    }
    return -1;
  }

  public Contact queryContact(String query) {
    for (Contact contact : myContacts) {
      if (contact.getName().equals(query)) {
        return contact;
      }
    }
    return null;
  }

  public void printContacts() {
    System.out.println("---- Contacts List ----");
    for(Contact cont : myContacts) {
      System.out.println(cont.getName()+" ==> "+cont.getPhoneNumber());
    }
  }

  public String getMyNumber() {
    return myNumber;
  }

  public ArrayList<Contact> getMyContacts() {
    return myContacts;
  }
}
