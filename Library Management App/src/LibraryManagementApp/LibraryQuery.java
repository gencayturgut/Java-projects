package LibraryManagementApp;

import java.util.Calendar;
import java.util.Date;

import Records.Book;
import Records.Issue;
import Records.Library;
import Records.LibraryManagement;
import Records.Member;

public class LibraryQuery {
	
	public static void mostIssuedBook(LibraryManagement management, Library L1, Library L2, Library L3) {
		
		String mostIssuedBookID = "";
		int count = 0;
		int maxCount = 0;
		
		for(int i=0; i<management.getIssues().length; i++) {
			for(Issue issue: management.getIssues()[i]) {
				count = 1;
				for(Issue innerIssue: management.getIssues()[i]) {
					if(issue.getBookID().equals(innerIssue.getBookID())) {
						count++;
					}
					
					if(count > maxCount) {
						maxCount = count;
						mostIssuedBookID = issue.getBookID();
					}
				}
			}
		}
		
		boolean found = false;
		while(found == false) {
			for(Book book: L1.getBooks()) {
				if(mostIssuedBookID.equals(book.getID())) {
					found = true;
					System.out.println("1) " + book.getTitle());
				}
			}
			for(Book book: L2.getBooks()) {
				if(mostIssuedBookID.equals(book.getID())) {
					found = true;
					System.out.println("1) " + book.getTitle());
				}
			}
			for(Book book: L3.getBooks()) {
				if(mostIssuedBookID.equals(book.getID())) {
					found = true;
					System.out.println("1) " + book.getTitle());
				}
			}
		}
	}
	
	public static void memberWhoIssuesMost(LibraryManagement management, Member[] members) {
		
		int mostIssuedMemberID = 0;
		int count = 0;
		int maxCount = 0;
		
		for(int i=0; i<management.getIssues().length; i++) {
			for(Issue issue: management.getIssues()[i]) {
				count = 1;
				for(Issue innerIssue: management.getIssues()[i]) {
					if(issue.getMemberID() == innerIssue.getMemberID()) {
						count++;
					}
					
					if(count > maxCount) {
						maxCount = count;
						mostIssuedMemberID = issue.getMemberID();
					}
				}
			}
		}
		
		for(int i=0; i<members.length; i++) {
			if(members[i].getID() == mostIssuedMemberID) {
				System.out.println("2) " + members[i].getName());
			}
		}
		
	}
	
	public static void highestPenalty(LibraryManagement issueLibraries) {
		Issue[][] issueLibrariesArray= issueLibraries.getIssues();
		double maxPenalty = dateOrganiser(issueLibrariesArray[0][0]);
		for(int libraryIndex=0;issueLibraries.libraryQuantity()>libraryIndex;libraryIndex++) {
			for(int issueIndex=0;issueLibrariesArray[libraryIndex].length>issueIndex;issueIndex++) {
				if(maxPenalty<dateOrganiser(issueLibrariesArray[libraryIndex][issueIndex])) {
					maxPenalty=dateOrganiser(issueLibrariesArray[libraryIndex][issueIndex]);
				}
			}
		}
		System.out.println("3) " + maxPenalty);;
	}
	
	public static void mostCopiedBook(Library L1, Library L2, Library L3) {
		
		int mostCopiedBookQuantity = 0;
		
		for(Book book: L1.getBooks()) {
			if(book.getQuantity() > mostCopiedBookQuantity) {
				mostCopiedBookQuantity = book.getQuantity();
			}
		}
		
		for(Book book: L2.getBooks()) {
			if(book.getQuantity() > mostCopiedBookQuantity) {
				mostCopiedBookQuantity = book.getQuantity();
			}
		}
		
		for(Book book: L3.getBooks()) {
			if(book.getQuantity() > mostCopiedBookQuantity) {
				mostCopiedBookQuantity = book.getQuantity();
			}
		}
		
		boolean found = false;
		while(found == false) {
			for(Book book: L1.getBooks()) {
				if(book.getQuantity() == mostCopiedBookQuantity) {
					found = true;
					System.out.println("4) " + book.getTitle());
				}
			}
			for(Book book: L2.getBooks()) {
				if(book.getQuantity() == mostCopiedBookQuantity) {
					found = true;
					System.out.println("4) " + book.getTitle());
				}
			}
			for(Book book: L3.getBooks()) {
				if(book.getQuantity() == mostCopiedBookQuantity) {
					found = true;
					System.out.println("4) " + book.getTitle());
				}
			}
		}
	}
	
	public static void leastCopyIssued(LibraryManagement management,Library[] libraries) {
		
		Book bookWithFewestCopies=null;
		Issue[][] issues = management.getIssues();
		Book minBook=getBookFromID(libraries, issues[0][0].getBookID());
		int minQuantity = minBook.getQuantity();
		
		for(int i=0; i<issues.length; i++) {
			for(int j=0;j<issues[i].length-1;j++) {
				Book nextBook = getBookFromID(libraries,issues[i][j+1].getBookID());
				int nextQuantity = nextBook.getQuantity();
				if(nextQuantity<minQuantity) {
					minBook = nextBook;
					minQuantity=nextQuantity;
				}
			}
		}
		bookWithFewestCopies = minBook;
		System.out.println("5) " + bookWithFewestCopies.getTitle());
	}
	
	public static void memberWhoIssuesLeastBooks(LibraryManagement management, Library L, Member[] members) {
		
		int leastIssuedMemberID = 0;
		int memberID = management.getIssues()[2][0].getMemberID();
		int count = 0;
		int minCount = getFirstMemberCount(management);
		
		for(Member member: members) {
			memberID = member.getID();
			
			for(Issue issue: management.getIssues()[2]) {
				if(member.getID() == issue.getMemberID()) {
					count++;
				}
			}
			
			if(minCount > count) {
				minCount = count;
				leastIssuedMemberID = memberID;
			}
			
			count = 0;
		}
		
		for(Member member: members) {
			if(leastIssuedMemberID == member.getID()) {
				System.out.println("6) " + member.getName());
			}
		}
	}
	
	
	private static int getFirstMemberCount(LibraryManagement management) {
		int count = 0;
		
		int firstMemberID = management.getIssues()[2][0].getMemberID();
		for(Issue issue: management.getIssues()[2]) {
			if(firstMemberID == issue.getMemberID()) {
				count++;
			}
		}
		return count;
	}

	private static double dateOrganiser(Issue issue) {
        String stringReturnDate=issue.getReturningDate();
        String stringIssueDate=issue.getIssueDate();
        String [] returningStringDates = stringReturnDate.split("[-]");
        String [] issueStringDates = stringIssueDate.split("[-]");
        Date returningDates = new Date();
        Date issueDates = new Date();
        int dateOfReturn = Integer.parseInt(returningStringDates[0]);
        int monthOfReturn=0;
        for(int i=12;i>0;i--) {
        	if(returningStringDates[1].equals("Jan")) {
        		monthOfReturn = 0;	
        		break;
        	}
        	
        	else if(returningStringDates[1].equals("Feb")) {
        		monthOfReturn = 1;
        		break;
        	}
        	else if(returningStringDates[1].equals("Mar")) {
        		monthOfReturn = 2;
        		break;
        	}    
        	else if(returningStringDates[1].equals("Apr")) {
        		monthOfReturn = 3;
        		break;
        	}  
        	else if(returningStringDates[1].equals("May")) {
        		monthOfReturn = 4;
        		break;
        	}  
        	else if(returningStringDates[1].equals("Jun")) {
        		monthOfReturn = 5;
        		break;
        	}  
        	else if(returningStringDates[1].equals("Jul")) {
        		monthOfReturn = 6;
        		break;
        	}  
        	else if(returningStringDates[1].equals("Aug")) {
        		monthOfReturn = 7;
        		break;
        	}  
        	else if(returningStringDates[1].equals("Sep")) {
        		monthOfReturn = 8;
        		break;
        	}  
        	else if(returningStringDates[1].equals("Oct")) {
        		monthOfReturn = 9;
        		break;
        	}  
        	else if(returningStringDates[1].equals("Nov")) {
        		monthOfReturn = 10;
        		break;
        	}  
        	else {
        		monthOfReturn = 11;
        	}      	        	      	       	        	        	        	       	
		}
        int yearOfReturn = Integer.parseInt(returningStringDates[2]);
        Calendar cal = Calendar.getInstance();
        cal.set(yearOfReturn, monthOfReturn, dateOfReturn);
        returningDates = cal.getTime();
        
        int dateOfIssue = Integer.parseInt(issueStringDates[0]);
        int monthOfIssue=0;
        for(int i=12;i>0;i--) {
        	if(issueStringDates[1].equals("Jan")) {
        		monthOfIssue = 0;	
        		break;
        	}
        	
        	else if(issueStringDates[1].equals("Feb")) {
        		monthOfIssue = 1;
        		break;
        	}
        	else if(issueStringDates[1].equals("Mar")) {
        		monthOfIssue = 2;
        		break;
        	}    
        	else if(issueStringDates[1].equals("Apr")) {
        		monthOfIssue = 3;
        		break;
        	}  
        	else if(issueStringDates[1].equals("May")) {
        		monthOfIssue = 4;
        		break;
        	}  
        	else if(issueStringDates[1].equals("Jun")) {
        		monthOfIssue = 5;
        		break;
        	}  
        	else if(issueStringDates[1].equals("Jul")) {
        		monthOfIssue = 6;
        		break;
        	}  
        	else if(issueStringDates[1].equals("Aug")) {
        		monthOfIssue = 7;
        		break;
        	}  
        	else if(issueStringDates[1].equals("Sep")) {
        		monthOfIssue = 8;
        		break;
        	}  
        	else if(issueStringDates[1].equals("Oct")) {
        		monthOfIssue = 9;
        		break;
        	}  
        	else if(issueStringDates[1].equals("Nov")) {
        		monthOfIssue = 10;
        		break;
        	}  
        	else {
        		monthOfIssue = 11;
        	}      	        	      	       	        	        	        	       	
		}
        
        int yearOfIssue = Integer.parseInt(issueStringDates[2]);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(yearOfIssue, monthOfIssue, dateOfIssue);
        issueDates = cal2.getTime();
        
        long dayPassedIssue = issueDates.getTime()/86400000;
        long dayPassedReturn = returningDates.getTime()/86400000;
        long dayPassed=dayPassedIssue-dayPassedReturn;
        dayPassed = Math.abs(dayPassed);
        		
        if(dayPassed>14) {
        	double penaltyDay = dayPassed - 14;
        	return penaltyDay/2;
        }
        else {
        	return 0;
        }
    }
	
	private static Book getBookFromID(Library[] libraries, String ID) {

		for(Library L : libraries) {
			Book[] books = L.getBooks();
			for(int i=0;i<books.length;i++) {
				if(ID.equals(books[i].getID())) {
					return books[i];
				}
			}
		}
		return null;
	}
}
