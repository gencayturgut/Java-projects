package Customers;

public class IndividualCustomer extends Customer implements IndividualCustomerInterface{
	private boolean membership;
	private static int nonMemberCount=0;
	private static int memberCount=0;
	
	public IndividualCustomer(String ID) {
		super(ID);
	}
	
	public IndividualCustomer(IndividualCustomer other) {
		this(other.getID());
	}
	
	public boolean checkMembership() {
		return membership;
	}

	@Override
	public double getDiscount() {
		if(checkMembership() == true) {
			return 0.10;
		}
		else {
			return 0;
		}
	}

	public static int getNonMemberCount() {
		return nonMemberCount;
	}

	public static void addNonMemberCount() {
		nonMemberCount=nonMemberCount+1;
	}

	public static int getMemberCount() {
		return memberCount;
	}

	public static void addMemberCount() {
		memberCount=memberCount+1;
	}

	@Override
	public String returnIsMember() {
		if(membership==true) {
			return "member";
		}
		else {
			return "non member";
		}
		
	}

	public void setMembership() {
		this.membership=true;
		
	}

}
