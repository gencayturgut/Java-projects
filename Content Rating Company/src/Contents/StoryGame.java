package Contents;

public class StoryGame extends Game {
	private int storyDuration;
	
	public StoryGame() {
		super();
	}
	
	public StoryGame(int arrivalDay, int gameType, String name, int duration, int averageRating) {
		super(arrivalDay,gameType,name,duration,averageRating);
		storyDuration = duration;
		setTimeLeftPlaying(getDuration());
	}

	public int getStoryDuration() {
		return storyDuration;
	}

	public void setStoryDuration(int storyDuration) {
		this.storyDuration = storyDuration;
	}

	@Override
	public int getDuration() {
		return storyDuration;
	}

	@Override
	public double getRating(double opinion) {
		int averageRating=getAverageRating();
		int duration = getDuration();
		double rating = averageRating + (duration*0.25) + opinion;
		return rating;
	}
	
}
