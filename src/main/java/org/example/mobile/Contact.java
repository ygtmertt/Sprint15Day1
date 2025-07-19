package org.example.mobile;


import java.util.Objects;

public class Contact {
  private String name;
  private String phoneNumber;

  public Contact(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public static Contact createContact(String name, String phoneNumber) {
    Contact newContact = new Contact(name, phoneNumber);
    return newContact;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Contact contact = (Contact) obj;
    return name.equals(contact.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

}
