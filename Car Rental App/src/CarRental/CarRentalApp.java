package CarRental;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Customers.*;
import FileIO.*;
import Rental.*;

public class CarRentalApp {
	
	public static void main(String[] args) throws FileNotFoundException, CustomerInvalidIdException {
		FileIO.readFile("src/FileIO/HW4_Rentals.csv");
		
		ArrayList<IndividualRental> individualRentalArrayList = new ArrayList<IndividualRental>();
		individualRentalArrayList = IndividualRental.getIndividualRentals();
		ArrayList<CommercialRental> commercialRentalArrayList = new ArrayList<CommercialRental>();
		commercialRentalArrayList = CommercialRental.getCommercialRentals();
		
		ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
		customerArrayList = Customer.getCustomers();
		
		System.out.println("Welcome!\n");
		
		System.out.println("Total number of cars rented: "+(CommercialRental.getNumberOfCommercialRentalCount()+IndividualRental.getNumberOfIndividualRentalCount())+"\n");
		System.out.println("Total number of commercials rentals: "+CommercialRental.getNumberOfCommercialRentalCount()+"\n");
		System.out.println("Total number of commercial rental-month: "+CommercialRental.getNumberOfDaysCount()+"\n");
		System.out.println("Total number of individual rentals: "+IndividualRental.getNumberOfIndividualRentalCount()+"\n");
		System.out.println("Total number of individual rental-day: "+IndividualRental.getNumberOfDaysCount()+"\n");
		System.out.println("Total number of rentals of individual non-member customers: "+ IndividualCustomer.getNonMemberCount()+"\n");
		System.out.println("Total number of rentals of individual member customers: "+ IndividualCustomer.getMemberCount()+"\n");
		System.out.println("Total number of rentals of silver commercial customers: "+SilverMember.getSilverMemberCount() +"\n");
		System.out.println("Total number of rentals of gold commercial customers:"+GoldMember.getGoldMemberCount()+"\n");
		System.out.println("Total number of rentals of platinum commercial customers: "+PlatinumMember.getPlatinumMemberCount()+"\n"+"\n");
		System.out.println("Individual Rentals:\n");
		System.out.format("No   Rental Code  Customer ID   isMember    Number of Days   Car Model         Model Year   Rental Price");
		int individualno = 1;
		for(IndividualRental rental :individualRentalArrayList ) {
			IndividualCustomer individualCustomer = (IndividualCustomer) Customer.returnCustomerFromID(customerArrayList,rental.getID());
			individualCustomer.checkMembership();
			System.out.format("\n%-5d%-13d%-14s%-16s%-13d%-18s%-13d%.2f",individualno,rental.getRentalCode(),rental.getID(),individualCustomer.returnIsMember(),rental.getNumberOfDays(),rental.getModel(),rental.getModelYear(),rental.calculatePrice()*rental.getNumberOfDays());
			individualno=individualno+1;

		}
		
		System.out.println("\n\nCommercial Rentals:\n");
		int commercialno= 1;
		System.out.format("No   Rental Code  Customer ID   Customer Type       Number of Months   Car Model            Model Year   Rental Price");
		for(CommercialRental rental :commercialRentalArrayList ) {
			Customer commercialCustomer= Customer.returnCustomerFromID(customerArrayList, rental.getID());
			double months = rental.getNumberOfDays()/30.0;
			System.out.format("\n%-5d%-13d%-14s%-24s%-13.2f%-23s%-13d%.2f",commercialno,rental.getRentalCode(), rental.getID(),rental.membershipType(),months,rental.getModel(),rental.getModelYear(),rental.calculatePrice()*rental.getNumberOfDays()/30);
			commercialno=commercialno+1;

		}
	
		
	}




}
