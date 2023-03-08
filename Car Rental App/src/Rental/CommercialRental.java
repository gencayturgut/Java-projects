package Rental;

import java.util.ArrayList;

import Customers.*;


public class CommercialRental extends Rental{
	private static ArrayList<CommercialRental> commercialRentals = new ArrayList<CommercialRental>();
	private static int numberOfDaysCount=0;
	private static int numberOfCommercialRentalCount=0;
	public CommercialRental() {
		this(null,0,null,0,0);
	}
	public CommercialRental(String ID, int numberOfDays, String model, int modelYear, double basePrice) {
		super("Commercial",ID,numberOfDays,model,modelYear,basePrice);	
		addToCommercialRentals(this);
		addNumberOfDaysCount(numberOfDays);
		addNumberOfCommercialRentalCount();
	}
	public CommercialRental(CommercialRental other) {
		this(other.getID(),other.getNumberOfDays(),other.getModel(),other.getModelYear(),other.getBasePrice());
	}
	
	@Override
	public double calculatePrice() {
		Customer customer = Customer.getCustomer(getID());
		double discount = customer.getDiscount();
		double modelYearRatio = getModelYearRatio();
		double dailyPrice = getBasePrice()*modelYearRatio;
		return (dailyPrice*30)*(1-discount);
	}
	
	public static ArrayList<CommercialRental> getCommercialRentals() {
		ArrayList<CommercialRental> temp = new ArrayList<CommercialRental>();
		for(CommercialRental rental:commercialRentals) {
			temp.add(rental);
		}
		return temp;	
	}
	public static void addToCommercialRentals(CommercialRental rental) {
		commercialRentals.add(rental);
	}
	public static void setCommercialRentals(ArrayList<CommercialRental> rentals) {
		CommercialRental.commercialRentals = rentals;
	}
	public static int getNumberOfCommercialRentalCount() {
		return numberOfCommercialRentalCount;
	}
	public static void addNumberOfCommercialRentalCount() {
		numberOfCommercialRentalCount = numberOfCommercialRentalCount+1;
	}
	public static int getNumberOfDaysCount() {
		return numberOfDaysCount;
	}
	public static void addNumberOfDaysCount(int numberOfDays) {
		numberOfDaysCount = numberOfDaysCount+ numberOfDays;
	}
	public String membershipType() {
		switch(getID().charAt(0)) {
		case 'S':
			return "Silver membership";
		case 'G':
			return "Gold membership";
		case 'P':
			return "Platinum membership";
		default:
			return "";
		}
	}

}
