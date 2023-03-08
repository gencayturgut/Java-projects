package Records;

public class Issue {
	
	private int ID;
	private int memberID;
	private String bookID;
	private String issueDate;
	private String returningDate;
	
	public Issue() {}
	
	public Issue(int ID, int memberID, String bookID, String issueDate, String returnDate) {
		this.ID = ID;
		this.memberID = memberID;
		this.bookID = bookID;
		this.issueDate = issueDate;
		this.returningDate = returnDate;
		
	}
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}

	public String toString() {
		return "Issue [ID=" + ID + ", memberID=" + memberID + ", bookID=" + bookID + ", issueDate=" + issueDate
				+ ", returningDate=" + returningDate + "]";
	}
	
}
