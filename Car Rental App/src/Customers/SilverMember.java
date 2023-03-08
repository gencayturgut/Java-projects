package Customers;

public class SilverMember extends Customer implements CommercialCustomerInterface{
	private String membership;
	private static int silverMemberCount=0;
	
	
	public SilverMember(String ID) {
		super(ID);
		addSilverMemberCount();
		
	}
	
	public SilverMember(SilverMember other) {
		this(other.getID());
	}
		
	
	@Override
	public double getDiscount() {
		return 0.20;
	}

	public static int getSilverMemberCount() {
		return silverMemberCount;
	}
	public static void addSilverMemberCount() {
		silverMemberCount=silverMemberCount+1;
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
