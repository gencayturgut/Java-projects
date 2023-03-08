package Applicants;

import java.util.ArrayList;

import Info.Document;
import Info.FinancialStatus;

public class Immigrant extends Applicant{
	public Immigrant() {
		this(0,null);
	}
	public Immigrant(int ID,String name) {
		super(ID,name);
	}
	
	public Immigrant(Immigrant other) {
		this(other.getApplicantID(),other.getApplicantName());
	}
	@Override
	public String checkFinancialStatus() {
		FinancialStatus status = FinancialStatus.getFinancialStatusFromID(getApplicantID()); 
		if(status != null) {
			int savings = FinancialStatus.getFinancialStatusFromID(getApplicantID()).getSavings();
			ArrayList<Document> documents = Document.getDocumentFromID(getApplicantID());
			boolean requiredDoc = checkDocument();
			boolean extraDoc= false;
			for(Document doc:documents) {
				if(doc.getDocumentType().equals("IL")) {
					extraDoc=true;
				}
			}
			double coeff=1;
			if(extraDoc) {
				coeff=0.5;
			}
			if(requiredDoc) {
				if(savings >= 4000*coeff) {
					return null;
				}
			}
			else if(savings >= 50000*coeff) {
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
		String requiredLetter = "GC";
		for(Document document:documents) {
			if(document.getDocumentType().equals(requiredLetter)) {
				
				return true;
			}
		}
		return false;
	}
	@Override
	public String calculateVisaDuration() {
		return "Permanent";
	}
}
