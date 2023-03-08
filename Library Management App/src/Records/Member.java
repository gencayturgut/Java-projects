package Records;

public class Member {
	
	private int ID;
	private	String Name;
	private String Email;
	
	public Member() {}
	
	public Member(int ID, String Name, String Email) {
		this.ID = ID;
		this.Name = Name;
		this.Email = Email;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}

	public String toString() {
		return "Member [ID=" + ID + ", Name=" + Name + ", Email=" + Email + "]";
	}

}
