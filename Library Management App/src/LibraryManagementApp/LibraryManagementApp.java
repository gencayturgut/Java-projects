package LibraryManagementApp;

import java.io.FileNotFoundException;

import FileIO.FileIO;
import Records.Library;
import Records.LibraryManagement;
import Records.Member;

public class LibraryManagementApp {

	public static void main(String[] args) throws FileNotFoundException {
		LibraryManagement libIssues = new LibraryManagement();
		Library L1_Books = new Library();
		Library L2_Books = new Library();
		Library L3_Books = new Library();
		Library[] libraries = {L1_Books, L2_Books, L3_Books};
		Member[] members = new Member[0];
		members = FileIO.readFile(L1_Books, L2_Books, L3_Books, libIssues, members);
		
		LibraryQuery.mostIssuedBook(libIssues, L1_Books, L2_Books, L3_Books);
		LibraryQuery.memberWhoIssuesMost(libIssues, members);
		LibraryQuery.highestPenalty(libIssues);
		LibraryQuery.mostCopiedBook(L1_Books, L2_Books, L3_Books);
		LibraryQuery.leastCopyIssued(libIssues, libraries);
		LibraryQuery.memberWhoIssuesLeastBooks(libIssues, L3_Books, members);
	}
}
