package Applicants;

import java.util.ArrayList;
import java.util.Date;

import Info.Document;
import Info.FinancialStatus;
import Info.Passport;

public class Tourist extends Applicant {

	public Tourist() {
		this(0,null);
	}
	public Tourist(int ID,String name) {
		super(ID,name);
	}
	
	public Tourist(Tourist other) {
		this(other.getApplicantID(),other.getApplicantName());
	}
	@Override
	public String checkFinancialStatus() {
		FinancialStatus status = FinancialStatus.getFinancialStatusFromID(getApplicantID());
		if(status != null) {
			int income = status.getIncome();
			int savings = status.getSavings();
			boolean checkDoc = checkDocument();
			double coeff=1;
			if(checkDoc==true) {
				coeff=0.5;
			}
			if(income>=2000*coeff && income <= 3000*coeff) {
				if(savings>=12000*coeff) {
					return null;
				}
			}
			else if(income>3000*coeff && income <= 4000*coeff) {
				if(savings>=6000*coeff) {
					return null;	
				}
				
			}
			if(income>4000*coeff) {
				return null;
			}
			
			return "Applicant does not have a stable financial status";
		}
		else {
			return "Applicant does not have a financial status report";
		}
	}
	@Override
	public boolean checkDocument() {
		ArrayList<Document> documents = Document.getDocumentFromID(getApplicantID());
		String requiredLetter = "IL";
		for(Document document:documents) {
			if(document.getDocumentType().equals(requiredLetter)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String calculateVisaDuration() {
		boolean docCheck = checkDocument();
		int income = FinancialStatus.getFinancialStatusFromID(getApplicantID()).getIncome();
		int savings = FinancialStatus.getFinancialStatusFromID(getApplicantID()).getSavings();
		Date currentDate = new Date();
		int durationInMonths = 0;
		Passport passport = Passport.getPassportFromID(getApplicantID());
		int diff = calculateDateDifference(passport.getExpirationDate(), currentDate);
		double dc=0;
		if(docCheck) {
			dc =  ((income - 2000) * 6 + savings)/12000; 
		}
		else {
			dc =  ((income - 2000) * 6 + savings)/6000;
		}
		
		if(dc <= 2 && dc >= 1) {
			durationInMonths = 6;
			if(diff < durationInMonths) {
				return "invalid duration";
			}
			else {
				return "6 months";
			}
		}
		else if(dc > 2 && dc <= 4) {
			durationInMonths = 1 * 12;
			if(diff < durationInMonths) {
				if(diff < 6) {
					
					return "invalid duration";
				}
				else {
					return "6 months";
				}
			}
			else {
				return "1 year";
			}
		}
		else if(dc > 4) {
			durationInMonths = 5 * 12;
			if(diff < durationInMonths) {
				if(diff < 6) {
					
					return "invalid duration";
				}
				else if(6 < diff && diff < 12) {
					return "6 months";
				}
				else {
					return "1 year";
				}
			}
			else {
				return "5 years";
			}
		}
		
		return "invalid duration";
	}
	
	
}
