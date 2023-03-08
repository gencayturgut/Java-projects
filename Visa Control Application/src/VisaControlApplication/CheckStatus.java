package VisaControlApplication;

import Applicants.*;

public class CheckStatus {
	public String startChecking(Applicant applicant) {
		boolean condition = true;
		String result = applicant.checkPassport();
		if(result != null) {
			return result;
		}
		else {
			result = applicant.checkPhoto();
			if(result != null) {
				return result;
			}
			else {
				result = applicant.checkFinancialStatus();
				if(result != null) {
					return result;
				}
				else {
					return "Accepted";
				}
			}
		}
	}
	
	public void formOutput(Applicant applicant) {
		String status = startChecking(applicant);
		String str = (applicant.toString() + ", Visa Type: " + applicant.getClass().getSimpleName());
		if(status.equals("Accepted")) {
			String visaDuration = applicant.calculateVisaDuration();
			
			if(visaDuration.equals("invalid duration")) {
				
				System.out.println(str + ", Status: Rejected" + ", Reason: Passport expiration date is not valid");
			}
			else {
			System.out.println(str + ", Status: " + status + ", Visa Duration: " + visaDuration);
			}
		}
		else {
			System.out.println(str + ", Status: Rejected" + ", Reason: " + status);
			
		}
	}
	
	
}
