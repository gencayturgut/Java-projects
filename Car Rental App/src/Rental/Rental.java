package Rental;

import java.util.ArrayList;
import java.util.Random;
import Customers.Customer.*;

public abstract class Rental implements RentalInterface{
	
	private String type;
	private String ID;
	private int numberOfDays;
	private String model;
	private int modelYear;
	private double basePrice;
	private int rentalCode;
	
	public Rental() {
		this(null,null,0,null,0,0);
	}
	
	public Rental(String type, String ID, int numberOfDays, String model, int modelYear, double basePrice) {
		setType(type);
		setID(ID);
		setNumberOfDays(numberOfDays);
		setModel(model);
		setModelYear(modelYear);
		setBasePrice(basePrice);
		setRentalCode();
	}

	public Rental(Rental other) {
		this(other.getType(),other.getID(),other.getNumberOfDays(),other.getModel(),other.getModelYear(),other.getBasePrice());
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public int getNumberOfDays() {
		return numberOfDays;
	}


	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getModelYear() {
		return modelYear;
	}


	public void setModelYear(int modelYear2) {
		this.modelYear = modelYear2;
	}


	public double getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public abstract double calculatePrice();

	public int getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode() {
		Random rand = new Random();
		rentalCode = rand.nextInt(9999999);
		
	}

	
	public double getModelYearRatio() {
		int modelYear = getModelYear();
		if(modelYear==2022) {
			return 1;
		}
		else if(modelYear == 2021 || modelYear == 2020) {
			return 0.95;
		}
		else if(modelYear == 2017 || modelYear == 2018 || modelYear == 2019) {
			return 0.9;
		}
		else {
			System.out.println("invalid model year.");
			return 0;
		}
	}
	
	
}
