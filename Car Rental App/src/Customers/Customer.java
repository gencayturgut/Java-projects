package Customers;

import java.util.ArrayList;

import Rental.Rental;

public abstract class Customer {
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private String ID;
	
	public Customer(String ID) {
		this.ID = ID;
		customers.add(this);
	}
	
	public Customer(Customer other) {
		this(other.getID());
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}

	public static ArrayList<Customer> getCustomers() {
		ArrayList<Customer> temp = new ArrayList<Customer>();
		for(Customer customer: customers) {
			temp.add(customer);
		}
		return temp;
	}
	public abstract String returnIsMember();
	
	public static Customer getCustomer(String ID) {
		for(Customer customer: customers) {
			if(customer.getID().equals(ID)) {
				return customer;
			}
		}
		return null;
	}
	
	public static Customer returnCustomerFromID(ArrayList<Customer> customerArray, String id) {
		for(Customer customer: customerArray) {
			if(customer.getID().equals(id)) {
				return customer;
			}
			
		}
		return null;
	}

	public abstract double getDiscount();
	public abstract boolean checkMembership();

	
	
}
