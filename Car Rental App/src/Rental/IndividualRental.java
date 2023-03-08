package Rental;

import java.util.ArrayList;

import Customers.*;

public class IndividualRental extends Rental{
	private static ArrayList<IndividualRental> individualRentals = new ArrayList<IndividualRental>();
	private static int numberOfDaysCount=0;
	private static int numberOfIndividualRentalCount=0;
	public IndividualRental() {
		this(null,0,null,0,0);
	}
	public IndividualRental(String ID, int numberOfDays, String model, int modelYear, double basePrice) {
		super("Individual",ID,numberOfDays,model,modelYear,basePrice);	
		addToIndividualRentals(this);
		addNumberOfDaysCount(numberOfDays);
		addNumberOfIndividualRentalCount();
		
	}
	public IndividualRental(CommercialRental other) {
		this(other.getID(),other.getNumberOfDays(),other.getModel(),other.getModelYear(),other.getBasePrice());
		
	}
	
	@Override
	public double calculatePrice() {
		Customer customer = Customer.getCustomer(getID());
		double discount = customer.getDiscount();
		double modelYearRatio = getModelYearRatio();
		double dailyPrice = getBasePrice()*modelYearRatio;
		return dailyPrice*(1-discount);
	}
	
	public static ArrayList<IndividualRental> getIndividualRentals() {
		ArrayList<IndividualRental> temp = new ArrayList<IndividualRental>();
		for(IndividualRental rental:individualRentals) {
			temp.add(rental);
		}
		return temp;	
	}
	public static void addToIndividualRentals(IndividualRental rental) {
		individualRentals.add(rental);
	}
	public static void setIndividualRentals(ArrayList<IndividualRental> rentals) {
		IndividualRental.individualRentals = rentals;
	}

	public static int getNumberOfIndividualRentalCount() {
		return numberOfIndividualRentalCount;
	}
	public static void addNumberOfIndividualRentalCount() {
		numberOfIndividualRentalCount = numberOfIndividualRentalCount+1;
	}
	public static int getNumberOfDaysCount() {
		return numberOfDaysCount;
	}
	public static void addNumberOfDaysCount(int numberOfDays) {
		numberOfDaysCount = numberOfDaysCount+ numberOfDays;
	}

}
