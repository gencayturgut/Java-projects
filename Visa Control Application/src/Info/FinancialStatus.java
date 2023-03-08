package Info;

import java.util.ArrayList;

public class FinancialStatus {
	private static ArrayList<FinancialStatus> list = new ArrayList<FinancialStatus>();
	private int applicantID;
	private int income;
	private int savings;
	
	public FinancialStatus() {
		this(0,0,0);
	}
	
	public FinancialStatus(int applicantID, int income, int savings) {
		this.applicantID = applicantID;
		this.income = income;
		this.savings = savings;
	}
	
	public FinancialStatus(FinancialStatus other) {
		this.applicantID = other.getApplicantID();
		this.income = other.getIncome();
		this.savings = other.getSavings();
	}
	
	public int getApplicantID() {
		return applicantID;
	}

	public int getIncome() {
		return income;
	}

	public int getSavings() {
		return savings;
	}
	
	public static void setList(FinancialStatus financialStatus) {
		list.add(financialStatus);
	}
	
	public static ArrayList<FinancialStatus> getList(){
		ArrayList<FinancialStatus> temp = new ArrayList<FinancialStatus>();
		for(FinancialStatus financialStatus: list) {
			temp.add(financialStatus);
		}
		return temp;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancialStatus other = (FinancialStatus) obj;
		if (applicantID != other.applicantID)
			return false;
		if (income != other.income)
			return false;
		if (savings != other.savings)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinancialStatus [applicantID=" + applicantID + ", income=" + income + ", savings=" + savings + "]";
	}

	public static FinancialStatus getFinancialStatusFromID(int ID) {
		for(FinancialStatus financialStatus:list) {
			if(financialStatus.getApplicantID() == ID) {
				return financialStatus;
			}
		}
		return null;
	}
	
	
}
