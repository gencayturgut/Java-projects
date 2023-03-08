package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Records.Book;
import Records.Issue;
import Records.Library;
import Records.LibraryManagement;
import Records.Member;

public class FileIO {
	
	public static Member[] readFile(Library L1, Library L2, Library L3, LibraryManagement management, Member[] members) throws FileNotFoundException {
		
		readIssues("src/FileIO/L1_Issues.csv", management);
		readIssues("src/FileIO/L2_Issues.csv", management);
		readIssues("src/FileIO/L3_Issues.csv", management);
		
		readBooks("src/FileIO/L1_Books.csv", L1);
		readBooks("src/FileIO/L2_Books.csv", L2);
		readBooks("src/FileIO/L3_Books.csv", L3);
		
		Member[] member = readMembers(members);
		
		return member;
	}
	
	private static Library readBooks(String fileName, Library L) throws FileNotFoundException {
		
		File BooksFile = new File(fileName);
		Scanner scan = new Scanner(BooksFile);
		
		while(scan.hasNextLine()) {
			String[] attr = scan.nextLine().split(",");
			L.add(new Book(attr[0], attr[1], attr[2], attr[3]
					, Integer.parseInt(attr[4]), attr[5], Integer.parseInt(attr[6])));
		}
		
		scan.close();
		return L;
	}
	
	private static LibraryManagement readIssues(String fileName, LibraryManagement libIssues) throws FileNotFoundException {
		
		int libraryIndex = Character.getNumericValue(fileName.charAt(12));
		libIssues.addLibrary();
		
		File IssuesFile = new File(fileName);
		Scanner scan = new Scanner(IssuesFile);
		
		while(scan.hasNextLine()) {
			String[] attr = scan.nextLine().split(",");
			Issue issue = new Issue(Integer.parseInt(attr[0]), Integer.parseInt(attr[1]), attr[2], attr[3], attr[4]);
			libIssues.addIssue(issue, libraryIndex);
			
		}
		scan.close();
		return libIssues;
	}
	
	private static Member[] readMembers(Member[] members) throws FileNotFoundException {
		
		File membersFile = new File("src/FileIO/Members.csv");
		Scanner scan = new Scanner(membersFile);
		
		scan.nextLine();
		scan.nextLine();
		while(scan.hasNextLine()) {
			String[] attr = scan.nextLine().split(",");
			Member member = new Member(Integer.parseInt(attr[0]), attr[1], attr[2]);
			
			Member[] members2 = new Member[members.length + 1];
			
			for (int i=0; i<members.length; i++) {
				members2[i] = members[i];
			}
			
			members2[members2.length - 1] = member;
			members = members2;
		}
		
		scan.close();
		return members;
	}

}
