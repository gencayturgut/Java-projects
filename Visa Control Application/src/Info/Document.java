package Info;

import java.util.ArrayList;

public class Document {
	private static ArrayList<Document> list = new ArrayList<Document>();
	private int applicantID;
	private String documentType;
	private String duration;
	
	public Document(){
		this(0,null,null);
	}

	public Document(int applicantID, String documentType, String duration) {
		this.applicantID = applicantID;
		this.documentType = documentType;
		this.duration = duration;
	}
	
	public Document(Document other) {
		this.applicantID = other.getApplicantID();
		this.documentType = other.getDocumentType();
		this.duration = other.duration;
	}
	

	public int getApplicantID() {
		return applicantID;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getDuration() {
		return duration;
	}
	
	public static void setList(Document document) {
		list.add(document);
	}
	
	public static ArrayList<Document> getList(){
		ArrayList<Document> temp = new ArrayList<Document>();
		for(Document document: list) {
			temp.add(document);
		}
		return temp;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (applicantID != other.applicantID)
			return false;
		if (documentType == null) {
			if (other.documentType != null)
				return false;
		} else if (!documentType.equals(other.documentType))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [applicantID=" + applicantID + ", documentType=" + documentType + ", duration=" + duration
				+ "]";
	}
	public static ArrayList<Document> getDocumentFromID(int ID) {
		ArrayList<Document> stored = new ArrayList<Document>();
		for(Document document:list) {
			if(document.getApplicantID() == ID) {
				stored.add(document);
				
			}
		}
		return stored;
	}
	
	
}