package com.bridgelabz.codinclub.Model;
import java.io.Serializable;
import java.util.Comparator;
/**
  *class Person
  *Having Fist Name, Last Name, Address, City, State, Zipcode, and Phone Number.
  *@author: shubhamkamble
*/
public class Person implements Serializable {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return " " + firstName + " \t " + lastName + " \t " + address + " \t " + city + " \t " + state + " \t " + zipcode + " \t " + phoneNumber + "";
	}
	public static Comparator<Person> sortEntriesName = new Comparator<Person>() {
		public int compare(Person s1, Person s2) {
			String FirstName1 = s1.getFirstName().toUpperCase();
			String FirstName2 = s2.getFirstName().toUpperCase();
			/**
			  *Ascending Order
			*/
			return FirstName1.compareTo(FirstName2);
		}
	};
	public static Comparator<Person> sortEntriesZip = new Comparator<Person>() {
		public int compare(Person s1, Person s2) {
			int Zip1 = s1.getZipcode();
			int Zip2 = s2.getZipcode();
			/**
			  *Ascending Order
			*/
			return Zip1 - Zip2;
		}
	};
}
