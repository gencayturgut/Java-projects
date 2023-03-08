package Contents;

public class CasualGame extends Game{
	private int matchDuration;
	
	public CasualGame(int arrivalDay, int gameType, String name, int duration, int averageRating) {
		super(arrivalDay,gameType,name,duration,averageRating);
		matchDuration = duration;
		setTimeLeftPlaying(getDuration()*3);
	}

	public int getMatchDuration() {
		return matchDuration;
	}

	public void setMatchDuration(int matchDuration) {
		this.matchDuration = matchDuration;
	}

	@Override
	public int getDuration() {
		return matchDuration;
	}
	@Override
	public  double getRating(double opinion) {
		int averageRating=getAverageRating();
		int duration = getDuration();
		double rating = averageRating + ((duration-3)*3) + opinion;
		return rating;
	}

	
}
