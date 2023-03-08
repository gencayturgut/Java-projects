package FileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Applicants.*;
import Applicants.Tourist;
import Info.*;
public class FileIO {
	public static void readFile(String fileName) throws FileNotFoundException, ParseException {
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			String[] attr = scan.nextLine().split(",");
			switch(attr[0]) {
			case "A":
				readApplicant(attr);
				break;
			case "S":
				readPassport(attr);
				break;
			case "P":
				readPhoto(attr);
				break;
			case "F":
				readFinancialStatus(attr);
				break;
			case "D":
				readDocument(attr);
				break;
			}
		}
		scan.close();
	}
	
	private static void readApplicant(String[] attr) {
		int ID = Integer.parseInt(attr[1]);
		String name = attr[2];
		String typeIndicator = attr[1].substring(0,2);
		switch(typeIndicator) {
			case "11":
				Tourist tourist = new Tourist(ID,name);
				Applicant.setList(tourist);
				break;
			case "23":
				Worker worker = new Worker(ID,name);
				Applicant.setList(worker);
				break;
			case "25":
				Educational educational = new Educational(ID,name);
				Applicant.setList(educational);
				break;
			case "30":
				Immigrant immigrant = new Immigrant(ID,name);
				Applicant.setList(immigrant);
				break;
			default:
				System.out.println("invalid applicant type!");
		}
		
		
		
	}

	private static void readDocument(String[] attr) {
		int ID = Integer.parseInt(attr[1]);
		String documentType = attr[2];
		if(attr.length == 4) {
			String duration = attr[3];
			Document document = new Document(ID,documentType,duration);
			Document.setList(document);
		}
		else if(attr.length == 3) {
			Document document = new Document(ID,documentType,null);
			Document.setList(document);
		}
		
		
	}

	private static void readFinancialStatus(String[] attr) {
		int ID = Integer.parseInt(attr[1]);
		int income = Integer.parseInt(attr[2]);
		int savings = Integer.parseInt(attr[3]);
		FinancialStatus financialStatus = new FinancialStatus(ID,income,savings);
		FinancialStatus.setList(financialStatus);
	}

	private static void readPhoto(String[] attr) {
		int ID = Integer.parseInt(attr[1]);
		String resolution = attr[2];
		String position = attr[3];
		Photo photo = new Photo(ID,resolution,position);
		Photo.setList(photo);
	}

	private static void readPassport(String[] attr) throws ParseException {
		int ID = Integer.parseInt(attr[1]);
		String passportNumber = attr[2];
		Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(attr[3]);
		Passport passport = new Passport(ID,passportNumber,expirationDate);
		Passport.setList(passport);
	}

}
