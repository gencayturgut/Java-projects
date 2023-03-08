package Contents;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

import Critics.GameCritic;

public abstract class Game implements Comparable{
	private int arrivalDay;
	private int gameType;
	private String name;
	private int duration;
	private int averageRating;
	private static Stack<Game> gameStack= new Stack<Game>();
	private double finalRating;
	private int timeLeftPlaying;
	private GameCritic critic;
	private boolean completed=false;
	
	public Game() {
		this(0,0,null,0,0);
	}
	
	public Game(int arrivalDay, int gameType, String name, int duration, int averageRating) {
		setArrivalDay(arrivalDay);
		setGameType(gameType);
		setName(name);
		setDuration(duration);
		setAverageRating(averageRating);
	}
	
	public Game(Game other) {
		this(other.arrivalDay,other.gameType,other.name,other.duration,other.averageRating);
	}

	public int getArrivalDay() {
		return arrivalDay;
	}

	public void setArrivalDay(int arrivalDay) {
		this.arrivalDay = arrivalDay;
	}

	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract int getDuration();
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}
	
	public abstract double getRating(double opinion);

	public static Stack<Game> getGameStack() {
		Stack<Game> temp = new Stack<Game>();
		Iterator<Game> iter = gameStack.iterator();
		while(iter.hasNext()) {
			temp.push((Game) iter.next());
		}
		return gameStack;
	}

	public static void setGameStack(Stack<Game> stack) {
		gameStack = stack;
	}
	
	public static void addGameToStack(Game game) {
		gameStack.add(game);
	}
	
	public static void sortStack() {
		gameStack.sort(null);
		Collections.reverse(gameStack);
	}
	
	@Override
	public int compareTo(Object o) throws ClassCastException{
		return getArrivalDay()-((Game) o).getArrivalDay();
	}
	
	public void setFinalRating(double rating) {
		finalRating=rating;
	}
	
	public double getFinalRating() {
		return finalRating;
	}

	public int getTimeLeftPlaying() {
		return timeLeftPlaying;
	}

	public void setTimeLeftPlaying(int timeLeftPlaying) {
		this.timeLeftPlaying = timeLeftPlaying;
	}

	public GameCritic getCritic() {
		return new GameCritic(critic);
	}

	public void setCritic(GameCritic critic) {
		this.critic = critic;
		double rating = critic.calculateRating(this);
		setFinalRating(rating);
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public String toString() {
		return (getName() + ", " + getFinalRating());
	}
	
	
}
