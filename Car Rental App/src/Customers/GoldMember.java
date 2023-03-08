package Customers;

public class GoldMember extends Customer implements CommercialCustomerInterface{
	private String membership;
	private static int goldMemberCount=0;
	

	public GoldMember(String ID) {
		super(ID);
		addGoldMemberCount();
		
	}
	
	public GoldMember(GoldMember other) {
		this(other.getID());
	}
	
	
	@Override
	public double getDiscount() {
		return 0.25;
	}

	public static int getGoldMemberCount() {
		return goldMemberCount;
	}
	public static void addGoldMemberCount() {
		goldMemberCount=goldMemberCount+1;
	}


	public String returnIsMember() {
		return membership;
	}


	public void setMembership() {
		membership="Gold member";
	}


	public boolean checkMembership() {
		return false;
	}

}
