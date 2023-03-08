package Contents;

public class IndefiniteGame extends Game {
	private int minEvaluationTime;
	
	public IndefiniteGame(int arrivalDay, int gameType, String name, int duration, int averageRating) {
		super(arrivalDay,gameType,name,duration,averageRating);
		minEvaluationTime = duration;
		setTimeLeftPlaying(4);
	}

	public void setMinEvaluationTime(int minEvaluationTime) {
		this.minEvaluationTime = minEvaluationTime;
	}

	@Override
	public int getDuration() {
		return minEvaluationTime;
	}

	@Override
	public double getRating(double opinion) {
		int averageRating=getAverageRating();
		int duration = getDuration();
		double rating = averageRating + ((10-duration)*0.25) + opinion;
		return rating;
	}
	
	
}
