package Applicants;

import java.util.ArrayList;
import java.util.Date;

import Info.Document;
import Info.FinancialStatus;
import Info.Passport;

public class Worker extends Applicant {
	public Worker() {
		this(0,null);
	}
	public Worker(int ID,String name) {
		super(ID,name);
	}
	
	public Worker(Worker other) {
		this(other.getApplicantID(),other.getApplicantName());
	}
	@Override
	public String checkFinancialStatus() {
		FinancialStatus status = FinancialStatus.getFinancialStatusFromID(getApplicantID());
		if(status != null) {
			if(checkDocument() == true) {
				int savings = status.getSavings();
	
				if(savings >= 2000) {
					return null;
				}
				else {
					return "Applicant does not have a stable financial status";
				}
			}
			else {
				return "Applicant does not have a letter of acceptance";
			}
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
		else if(acceptanceDuration > 24 && acceptanceDuration <= 60) {
			if(expirationDate >= 60) {
				return "5 years";
			}
			else if(expirationDate < 60 && expirationDate >=24) {
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
