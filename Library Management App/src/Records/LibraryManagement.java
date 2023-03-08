package Records;

import java.util.Arrays;

public class LibraryManagement {
	
	private Issue[][] issues;
	
	public LibraryManagement() {
		this.issues = new Issue[0][0];
	}
	
	public Issue[][] getIssues() {
		return issues;
	}
	
	public int libraryQuantity() {
		return issues.length;
	}
	
	public void addIssue(Issue item, int L) {
		L--;
		issues[L] = Arrays.copyOf(issues[L], issues[L].length + 1);
		issues[L][issues[L].length-1]=item;
	}
	
	public void addLibrary() {
		Issue[][] temp = new Issue[issues.length+1][0];
		System.arraycopy(issues, 0, temp, 0,issues.length);
		issues = temp;
		
	}
}
