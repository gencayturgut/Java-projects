package Critics;

import Contents.Game;

public class GameCritic extends Critic{
	private int timeWorked=0;
	public GameCritic() {
		this(0,0);
	}
	public GameCritic(double opinion,int no) {
		super(opinion,no);
	}
	public GameCritic(GameCritic critic) {
		this(critic.getOpinion(),critic.getTurnNo());
	}
	
	@Override
	public <Game> double calculateRating(Game game) {
		double rating = ((Contents.Game) game).getRating(getOpinion());
		if(rating>100) {
			return 100;
		}
		else {
			return rating;
		}
	}
	
	public void setTimeWorked(int time) {
		timeWorked=time;
	}
	public int getTimeWorked() {
		return timeWorked;
	}

}
