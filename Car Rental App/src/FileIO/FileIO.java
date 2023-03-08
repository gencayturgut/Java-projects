package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Customers.*;
import Rental.*;

public class FileIO {
	
	public static void readFile(String fileName) throws FileNotFoundException, CustomerInvalidIdException {

		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			String[] attr = scan.nextLine().split(",");
			try {
			readRental(attr);
			}
			catch(CustomerInvalidIdException e) {
				System.err.print(e);
				System.exit(0);
			}
		}
		
	}
	
	private static void readRental(String[] attr) throws CustomerInvalidIdException {
		String type = attr[0];
		String ID = attr[1];
		int numberOfDays = Integer.parseInt(attr[2]);
		String carModel = attr[3];
		int carModelYear = Integer.parseInt(attr[4]);
		double basePrice = Double.parseDouble(attr[5]);
		switch(type) {
			case "Commercial":
				CommercialRental commercialRental = new CommercialRental(ID,numberOfDays,carModel,carModelYear,basePrice);
				
				break;
			case "Individual":
				IndividualRental individualRental = new IndividualRental(ID,numberOfDays,carModel,carModelYear,basePrice);
		
				break;
			default:
				System.out.println("Invalid rental type.");
				break;
		}
		switch(ID.charAt(0)) {
		case 'M':
			if(ID.length()==12) {
			IndividualCustomer customerIndividualMember = new IndividualCustomer(ID);
			customerIndividualMember.setMembership();
			IndividualCustomer.addMemberCount();
			
			}
			else {
				throw new CustomerInvalidIdException("Invalid ID: "+ID+"\n");
			}
			break;
		case 'S':
			if(ID.length()==8) {
			 SilverMember customerSilver = new SilverMember(ID);
			
			}
			else {
				throw new CustomerInvalidIdException("Invalid ID: "+ID+"\n");
			}
			break;
		case 'G':
			if(ID.length()==8) {
			GoldMember customerGold = new GoldMember(ID);
			
			}
			else {
				throw new CustomerInvalidIdException("Invalid ID: "+ID+"\n");
			}
			break;
		case 'P':
			if(ID.length()==8) {
			PlatinumMember customerPlatinum = new PlatinumMember(ID);
			
			}
			else {
				throw new CustomerInvalidIdException("Invalid ID: "+ID+"\n");
			}
			break;
		case '0','1','2','3','4','5','6','7','8','9':
			if(ID.length()==11) {
			IndividualCustomer customerIndividualNonMember = new IndividualCustomer(ID);
			IndividualCustomer.addNonMemberCount();
			
			}
			else {
				throw new CustomerInvalidIdException("Invalid ID: "+ID+"\n");
			}
			break;
		default:
			System.out.println("Invalid customer type.");
			break;
	}
	}

}
