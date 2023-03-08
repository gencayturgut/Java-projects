package Customers;

public class PlatinumMember extends Customer implements CommercialCustomerInterface{
	private String membership;
	private static int platinumMemberCount=0;

	public PlatinumMember(String ID) {
		super(ID);
		addPlatinumMemberCount();
		
	}
	
	public PlatinumMember(PlatinumMember other) {
		this(other.getID());
	}
	

	@Override
	public double getDiscount() {
		return 0.30;
	}

	public static int getPlatinumMemberCount() {
		return platinumMemberCount;
	}
	public static void addPlatinumMemberCount() {
		platinumMemberCount=platinumMemberCount+1;
	}

	public String returnIsMember() {
		// TODO Auto-generated method stub
		return membership;
	}


	public void setMembership() {
		membership="Platinum member";
	}


	public boolean checkMembership() {
		return false;
	}

}
