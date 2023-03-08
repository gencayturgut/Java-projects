package Info;

import java.util.ArrayList;

public class Photo {
	private static ArrayList<Photo> list = new ArrayList<Photo>();
	private int applicantID;
	private int[] resolution;
	private String position;
	
	public Photo() {
		this(0, null, null);
	}
	
	public Photo(int applicantID, String resolution, String position) {
		this.applicantID = applicantID;
		this.resolution = parseResolution(resolution);
		this.position = position;
	}
	
	public Photo(Photo other) {
		this.applicantID = other.getApplicantID();
		this.resolution = other.getResolution();
		this.position = other.position;
	}
	
	public int getApplicantID() {
		return applicantID;
	}
	
	public int[] getResolution() {
		int[] temp = {resolution[0], resolution[1]};
		return temp;
	}
	
	public String getPosition() {
		return position;
	}
	
	public static ArrayList<Photo> getList(){
		ArrayList<Photo> temp = new ArrayList<Photo>();
		for(Photo photo: list) {
			temp.add(photo);
		}
		return temp;
	}
	
	public static void setList(Photo photo) {
		list.add(photo);
	}
	
	private int[] parseResolution(String resolution) {
		if(resolution == null) {
			System.out.println("Resolution of photo is not valid");
			System.exit(0);
		}
		else {
			int[] resolutionArray = new int[2];
			
			String[] attr = resolution.split("x");
			resolutionArray[0] = Integer.parseInt(attr[0]);
			resolutionArray[1] = Integer.parseInt(attr[1]);
			
			return resolutionArray;
		}
		
		return null;
	}

	public String toString() {
		return "applicantID=" + applicantID + ", resolution=" + resolution + ", position=" + position;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photo other = (Photo) obj;
		if (applicantID != other.applicantID)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		return true;
	}
	public static Photo getPhotoFromID(int ID) {
		for(Photo photo:list) {
			if(photo.getApplicantID() == ID) {
				return photo;
			}
		}
		return null;
	}
	
}

