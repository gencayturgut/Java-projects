package Applicants;

import java.util.ArrayList;
import java.util.Date;

import Info.Document;
import Info.FinancialStatus;
import Info.Passport;

public class Educational extends Applicant{
	public Educational() {
		this(0,null);
	}
	public Educational(int ID,String name) {
		super(ID,name);
	}
	
	public Educational(Educational other) {
		this(other.getApplicantID(),other.getApplicantName());
	}
	@Override
	public String checkFinancialStatus() {
		FinancialStatus status = FinancialStatus.getFinancialStatusFromID(getApplicantID());
		if(status != null) {
			int income = status.getIncome();
			int savings = status.getSavings();
			ArrayList<Document> documents = Document.getDocumentFromID(getApplicantID());
			boolean extraDoc= false;
			for(Document doc:documents) {
				if(doc.getDocumentType().equals("IL")) {
					extraDoc=true;
				}
			}
			boolean requiredDoc = checkDocument();
			double coeff=1;
			if(extraDoc==true) {
				coeff=0.5;
			}
			
			if(income>=1000*coeff && income <= 2000*coeff) {
				if(savings>=6000*coeff) {
					if(!requiredDoc) {
						return "Applicant does not have a letter of acceptance";
					}
					return null;
					
				}
			}
			else if(income>2000*coeff && income <= 3000*coeff) {
				if(savings>=3000*coeff) {
					if(!requiredDoc) {
						return "Applicant does not have a letter of acceptance";
					}
					return null;	
				}
				
			}
			if(income>3000*coeff) {
				if(!requiredDoc) {
					return "Applicant does not have a letter of acceptance";
				}
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
		String requiredLetter = "LA";
		for(Document document:documents) {
			if(document.getDocumentType().equals(requiredLetter)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String calculateVisaDuration() {
		ArrayList<Document> documentList = Document.getDocumentFromID(getApplicantID());
		int acceptanceDuration = 0;
		Date date = new Date();
		Passport passport = Passport.getPassportFromID(getApplicantID());
		Document document = null;
		
		for(Document doc: documentList) {
			if(doc.getDocumentType().equals("LA")) {
				document = doc;
			}
		}
		
		if(document.getDuration() != null) {
			acceptanceDuration = Integer.parseInt(document.getDuration());
		}

		
		int expirationDate = calculateDateDifference(passport.getExpirationDate(), date);
		if(acceptanceDuration <= 12) {
			if(expirationDate >= 12) {
				return "1 year";
			}
			else {
				
				return "invalid duration";
			}
		}
		else if(acceptanceDuration > 12 && acceptanceDuration <= 24) {
			if(expirationDate >= 24) {
				return "2 years";
			}
			else if(expirationDate < 24 && expirationDate >=12) {
				return "1 year";
			}
			else {
				
				return "invalid duration";
			}
		}
		else if(acceptanceDuration > 24 && acceptanceDuration <= 48) {
			if(expirationDate >= 48) {
				return "4 years";
			}
			else if(expirationDate < 48 && expirationDate >=24) {
				return "2 years";
			}
			else if(expirationDate >= 12 && expirationDate < 24) {
				return "1 year";
			}
			else {
				
				return "invalid duration";
			}
		}
		else {
			return "invalid duration";
		}
	}

}
