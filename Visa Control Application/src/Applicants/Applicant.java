package Applicants;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Info.*;

public abstract class Applicant {
	private static ArrayList<Applicant> list = new ArrayList<Applicant>();
	private int applicantID;
	private String applicantName;
	
	public Applicant(){
		this(0,null);
	}
	
	public Applicant(int ID, String name){
		setApplicantID(ID);
		setApplicantName(name);
	}
	
	public Applicant(Applicant other){
		setApplicantID(other.getApplicantID());
		setApplicantName(other.getApplicantName());
	}
	
	public void setApplicantID(int ID) {
		applicantID = ID;
	}
	
	public void setApplicantName(String name) {
		applicantName = name;
	}
	
	public int getApplicantID() {
		return applicantID;
	}
	
	public String getApplicantName() {
		return applicantName;
	}
	
	
	public static void setList(Applicant applicant) {
		list.add(applicant);
	}
	
	public static ArrayList<Applicant> getList(){
		ArrayList<Applicant> temp = new ArrayList<Applicant>();
		for(Applicant applicant: list) {
			temp.add(applicant);
		}
		return temp;
	}
	
	public String checkPassport() {
		Passport passport=Passport.getPassportFromID(getApplicantID());
		Date date = new Date();
		
		if( passport != null) {
			int diff = calculateDateDifference(passport.getExpirationDate(), date);
			String passNum = passport.getpassportNo();
			String result = "Default result";
			if(passNum.length() == 10 || passNum.startsWith("P") == true) {
				if(isNumeric(passNum.substring(7)) == true) {
					if(diff >= 6) {
						result = null;
					}
					else {
						result = "Passport expiration date is not valid";
					}
				}
				else {
					result = "Passport is not valid";
				}
			}
			else {
				result = "Passport is not valid";
			}
				return result;
		}
		else {
			return "Applicant does not have a passport";
		}
		
	}
	
	public String checkPhoto() {
		Photo photo = Photo.getPhotoFromID(applicantID);
		if(photo != null) {
			int dimension1 = photo.getResolution()[0];
			int dimension2 = photo.getResolution()[1];
			String result = "Default result";
			String position = photo.getPosition();
			
			if(dimension1 != dimension2) {
				result = "Resolution of photo is not valid";
			}
			else if(dimension1 > 1200 || dimension1 < 600) {
				result = "Resolution of photo is not valid";
			}
			else if(!(position.equals("Neutral Face")) && !(position.equals("Natural Smile"))) {
				result = "Position in the photo is not valid";
			}
			else {
				result = null;
			}
			return result;
		}
		else {
			return "Applicant does not have a photo";
		}
		
	}
	
	private boolean isNumeric(String strNum) {
		if(strNum == null) {
			return false;
		}
		try {
			int i = Integer.parseInt(strNum);
		} catch(NumberFormatException nfe) {
			return false;
		}
		
		return true;
	}
		
	public int calculateDateDifference(Date one, Date two) {
		long diffInMillies = Math.abs(one.getTime() - two.getTime());
		int diff = (int) (TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 30);
		return diff;
	}
	
	public abstract String checkFinancialStatus();
	
	public abstract boolean checkDocument();
	
	public abstract String calculateVisaDuration();

	
	public String toString() {
		return "Applicant ID: " + getApplicantID() + ", Name: " + getApplicantName();
	}

}
