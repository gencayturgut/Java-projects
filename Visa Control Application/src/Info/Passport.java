package Info;

import java.util.ArrayList;
import java.util.Date;

public class Passport {
	private static ArrayList<Passport> list = new ArrayList<Passport>();
	private int applicantID;
	private String passportNo;
	private Date expirationDate;
	
	public Passport(){
		this(0,null,null);
	}
	
	public Passport(int ID, String passNo, Date date){
		applicantID = ID;
		passportNo = passNo;
		expirationDate = date;
	}
	
	public Passport(Passport other){
		applicantID = other.getApplicantID();
		passportNo = other.getpassportNo();
		expirationDate = other.getExpirationDate();
	}
	
	public int getApplicantID() {
		return applicantID;
	}
	
	public String getpassportNo() {
		return passportNo;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public static void setList(Passport passport) {
		list.add(passport);
	}
	
	public static ArrayList<Passport> getList(){
		ArrayList<Passport> temp = new ArrayList<Passport>();
		for(Passport passport: list) {
			temp.add(passport);
		}
		return temp;
	}
	
	public String toString() {
		return "Application ID = " + getApplicantID() + ", passport Number = " + getpassportNo() + ", Expiration Date = " + getExpirationDate();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passport other = (Passport) obj;
		if (applicantID != other.applicantID)
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (passportNo != other.passportNo)
			return false;
		return true;
	}
	
	public static Passport getPassportFromID(int ID) {
		for(Passport passport:list) {
			if(passport.getApplicantID() == ID) {
				return passport;
			}
		}
		return null;
	}
	
	
}
