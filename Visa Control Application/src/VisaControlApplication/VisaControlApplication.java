package VisaControlApplication;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import Applicants.Applicant;
import FileIO.FileIO;

public class VisaControlApplication {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		FileIO.readFile("src/FileIO/HW2_ApplicantsInfo.csv");
		CheckStatus checkStatus = new CheckStatus();
		ArrayList<Applicant> applicants = Applicant.getList();
		sortArrayListByID(applicants);
		for(Applicant applicant: applicants) {
			checkStatus.formOutput(applicant);
		}

	}

	public static void sortArrayListByID(ArrayList<Applicant> list) {
			
			for(int i = 0; i<list.size(); i++) {
				Applicant min = list.get(i);
				int minIndex=i;
				for (int k=i+1; k<list.size(); k++) {
					if (min.getApplicantID()>list.get(k).getApplicantID()) {
						min = list.get(k);
						minIndex=k;
				}
			}
				Applicant min2 = list.get(i);
				list.set(i, min);
				list.set(minIndex, min2);
		  }
		}
}
