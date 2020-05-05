package com.bridgelabz.codinclub.Controller;
import com.bridgelabz.codinclub.Service.AddressBook;
import com.bridgelabz.codinclub.Service.AddressBookInterface;
/**
  *class Address Book Controller
*/
public class AddressBookController {
	AddressBookInterface addressBook = new AddressBook();
	public void addPerson() {
		addressBook.addPerson();
	}
	public void createNewAddressBook() {
		addressBook.createNewAddressBook();
	}
	public void sortByName() {
		addressBook.sortByName();
	}
	public void sortByZip() {
		addressBook.sortByZip();
	}
	public void delete() {
		addressBook.deleteByFirstName();
	}
	public void Edit() {
		addressBook.editDetails();
	}
	public void display() {
		addressBook.display();
	}
}
