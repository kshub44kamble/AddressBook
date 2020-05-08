package com.bridgelabz.codinclub.Service;
import com.bridgelabz.codinclub.Model.Person;
import com.bridgelabz.codinclub.Service.AddressBookInterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
  *class AddressBook
  *implements Address Book Interface class
  *@author: shubhamkamble
*/

public class AddressBook implements AddressBookInterface {
	int countofaddressbook = 0;
	Map<String, LinkedList<Person>> hashMap = new HashMap<String, LinkedList<Person>>();
	LinkedList<Person> linkedList = new LinkedList<Person>();

	String[] addressbook = new String[100];
	Person person;
	Scanner scanner = new Scanner(System.in);
	static String key = "";

	public void addPerson() {
		fileReade();
		if (countofaddressbook == 0) {
			System.out.println("***Empty AddressBook ! Press 1 To Create New AddressBook***");
			int press = scanner.nextInt();
			if (press == 1) {
				createNewAddressBook();
			}
			else {
			}
		}
		else {
			for(int choose = 0; choose < countofaddressbook; choose++) {
				System.out.println(choose + " " + addressbook[choose]);
			}
			System.out.println("***Choose Your Address Book***");
			int choose = scanner.nextInt();
			key = addressbook[choose];
		}
		Person person = new Person();

		System.out.println("Enter FirstName");
		String firstName = scanner.next();
		person.setFirstName(firstName);

		System.out.println("Enter lastName");
		String lastName = scanner.next();
		person.setLastName(lastName);

		System.out.println("Ente address");
		String addr = scanner.next();
		person.setAddress(addr);

		System.out.println("Enter city");
		String city = scanner.next();
		person.setCity(city);

		System.out.println("Enter state");
		String state = scanner.next();
		person.setState(state);

		System.out.println("Enter zipCode");
		int zipcode = scanner.nextInt();
		person.setZipcode(zipcode);

		System.out.println("Enter phoneNumber");
		String phoneNumber = scanner.next();
		person.setPhoneNumber(phoneNumber);

		linkedList.add(person);
		hashMap.put(key, linkedList);
		/**
		  *display
		*/
		System.out.println("Data get Added Successfully into " + key);
		fileWrite();
	}
	/**
	  *file Writing
	*/
	public void fileWrite() {
		try{
			FileOutputStream fileOutputStream = new FileOutputStream("/home/Documents/AddressBook/address-book/com/bridgelabz/codinclub/data.csv");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(addressbook);
			objectOutputStream.writeInt(countofaddressbook);
			objectOutputStream.writeObject(hashMap);
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();
		}catch(Exception e) {
				e.printStackTrace();
			}
	}
	/**
	  *file reading
	*/
	public void fileReade() {

		try {
			FileInputStream fileInputStream = new FileInputStream("/home/Documents/AddressBook/address-book/com/bridgelabz/codinclub");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			addressbook = (String[]) objectInputStream.readObject();
			countofaddressbook = objectInputStream.readInt();
			hashMap = (HashMap) objectInputStream.readObject();
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	/**
	  *method Create New Address Book
	*/
	public void createNewAddressBook() {
		System.out.println("***Enter Your New Addressbok Name***");
		addressbook[countofaddressbook] = scanner.next();

		hashMap.put(addressbook[countofaddressbook], new LinkedList<Person>());
		countofaddressbook++;
		System.out.println("***Your Address Book Created***");
		fileWrite();
	}
	/**
	  *method Sort By Zip Code
	*/
	public void sortByZip() {
		fileReade();
		for (int choose = 0; choose < countofaddressbook; choose++) {
			System.out.println(choose + " " + addressbook[choose]);
		}
		System.out.println("***Please Choose Your Address Book***");
		int choose = scanner.nextInt();
		key = addressbook[choose];
		linkedList = hashMap.get(key);
		Collections.sort(linkedList, Person.sortEntriesName);
		fileWrite();
	}
	/**
	  *method Sort By Name
	*/
	public void sortByName() {
		fileReade();
		for (int choose = 0; choose < countofaddressbook; choose++) {
			System.out.println(choose + " " + addressbook[choose]);
		}
		System.out.println("***Please Choose Your Address Book***");
		int choose = scanner.nextInt();
		key = addressbook[choose];
		linkedList = hashMap.get(key);
		Collections.sort(linkedList, Person.sortEntriesName);
		display();
	}
	/**
	  *method delete by first name
	*/
	public void deleteByFirstName() {
		fileReade();
		System.out.println("***address book srearch***");
		for (int choose = 0; choose < countofaddressbook; choose++) {
			System.out.println(choose + " " + addressbook[choose]);
		}
		System.out.println("***Please Choose Your Address Book***");
		int choose = scanner.nextInt();
		key = addressbook[choose];
		linkedList = hashMap.get(key);
		System.out.println("##Do you Want to Delete Your Data \nIf YES Enter:1\nNOT Enter:2##");
		int n = scanner.nextInt();
		if (n == 1) {
			System.out.println("Enter Person FirstName");
			String name = scanner.next();

			for (int i = 0; i < linkedList.size(); i++) {
				String nam = hashMap.get(key).get(i).getFirstName();
				if (nam.equalsIgnoreCase(name)) {
					linkedList.remove(hashMap.get(key).get(i));
					fileWrite();
					System.out.println(name + "Details Are Sucessfully Deleted");
				}
				else
				{
					System.out.println(name + "Entered Name Is Not Present in Data");
				}
			}
		}
	}
	/**
	  *method to display records
	*/
	public void display() {
		fileReade();

		System.out.println("Numbers Of Address Book  :");
		for (int choose = 0; choose < countofaddressbook; choose++) {
			System.out.println(choose + " " + addressbook[choose]);
		}
		if (countofaddressbook == 0) {
			System.out.println("No Such Address Book");
		}

		System.out.println("Choose Your Address Book");
		int choose = scanner.nextInt();
		key = addressbook[choose];
		linkedList = hashMap.get(key);
		System.out.println("************************************************************************************************************************");
		System.out.println("     FirstName  \tLastNmae      \tAddress      \tCity      \tState           \tZipCode         \tPhoneNumber");
		System.out.println("************************************************************************************************************************");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.println(hashMap.get(key).get(i));
		}
	}
	/**
	  *method to edit details
	*/
	public void editDetails() {
		fileReade();

		System.out.println("Numbers Of Address Books  :");
		for (int choose = 0; choose < countofaddressbook; choose++) {
			System.out.println(choose + " " + addressbook[choose]);
		}
		System.out.println("Please Choose Your Address Book");
		int choose = scanner.nextInt();
		key = addressbook[choose];
		linkedList = hashMap.get(key);
		System.out.println("Enter The Name Of Person Whose Details You Want To Edit");
		String name = scanner.next();

		for (int i = 0; i < linkedList.size(); i++) {
			String nam = hashMap.get(key).get(i).getFirstName();
			if (nam.equals(name)) {
				int choice;
				do {
					System.out.println("1 :Firstname  \n2 :LastName \n3 :Address \n4 :City\n5 :State\n6 :ZipCode\n7 :PhoneNumber\n8: Exit");
					choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter New FirstName");
						String fname = scanner.next();
						linkedList.get(i).setFirstName(fname);
						break;
					case 2:
						System.out.println("Enter New LastName");
						String lname = scanner.next();
						linkedList.get(i).setLastName(lname);
						break;
					case 3:
						System.out.println("Enter New Address");
						String address = scanner.next();
						linkedList.get(i).setAddress(address);
						break;
					case 4:
						System.out.println("Enter New City");
						String city = scanner.next();
						linkedList.get(i).setCity(city);
						break;
					case 5:
						System.out.println("Enter New State");
						String state = scanner.next();
						linkedList.get(i).setState(state);
						break;
					case 6:
						System.out.println("Enter New ZipCode");
						int zipCode = scanner.nextInt();
						linkedList.get(i).setZipcode(zipCode);
						break;
					case 7:
						System.out.println("Enter New PhoneNumbar");
						String pnumber = scanner.next();
						linkedList.get(i).setPhoneNumber(pnumber);
						break;
					default:
					}
				} while (choice != 8);
				fileWrite();
			}

		}

	}
}
