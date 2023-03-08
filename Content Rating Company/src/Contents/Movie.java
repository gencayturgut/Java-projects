package Contents;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

import Critics.GameCritic;
import Critics.MovieCritic;

public class Movie implements Comparable{
	private int arrivalDay;
	private String name;
	private int year;
	private int duration;
	private double averageRating;
	private static Stack<Movie> movieStack = new Stack<Movie>();
	private double finalRating;
	private MovieCritic critic;
	
	
	public Movie() {
		this.arrivalDay = 0;
		this.name = null;
		this.year = 0;
		this.duration = 0;
		this.averageRating = 0;
	}
	
	public Movie(int arrivalDay, String name, int year, int duration, double averageRating) {
		this.arrivalDay = arrivalDay;
		this.name = name;
		this.year = year;
		this.duration = duration;
		this.averageRating = averageRating;
	}
	
	public Movie(Movie other) {
		this.arrivalDay = other.getArrivalDay();
		this.name = other.getName();
		this.year = other.getYear();
		this.duration = other.getDuration();
		this.averageRating = other.getAverageRating();
	}

	public int getArrivalDay() {
		return arrivalDay;
	}

	public void setArrivalDay(int arrivalDay) {
		this.arrivalDay = arrivalDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	
	public double getRating(double opinion) {
		double averageRating=getAverageRating();
		int duration = getDuration();
		int year = getYear();
		double rating = averageRating + ((duration-150)*0.01) - ((2021-year)*0.01) + opinion;
		return rating;
	}

	public static Stack<Movie> getMovieStack() {
		Stack<Movie> temp = new Stack<Movie>();
		Iterator<Movie> iter = movieStack.iterator();
		while(iter.hasNext()) {
			temp.push((Movie) iter.next());
		}
		return movieStack;
	}

	public static void setMovieStack(Stack<Movie> movieStack) {
		Movie.movieStack = movieStack;
	}
	
	public static void addMovieToStack(Movie movie) {
		movieStack.add(movie);
		
	}
	
	public static void sortStack() {
		movieStack.sort(null);
		Collections.reverse(movieStack);
	}

	@Override
	public int compareTo(Object o) throws ClassCastException{
		return getArrivalDay()-((Movie) o).getArrivalDay();
	}
	
	public String toString() {
		double rating = getFinalRating();
		DecimalFormat newFormat = new DecimalFormat("#.##");
		return (getName() + ", " + newFormat.format(rating));
	}

	public MovieCritic getCritic() {
		return new MovieCritic(critic);
	}

	public void setCritic(MovieCritic critic) {
		this.critic = critic;
		double rating = critic.calculateRating(this);
		setFinalRating(rating);
	}

	public double getFinalRating() {
		return finalRating;
	}

	public void setFinalRating(double finalRating) {
		this.finalRating = finalRating;
	}

	
	
	
}
