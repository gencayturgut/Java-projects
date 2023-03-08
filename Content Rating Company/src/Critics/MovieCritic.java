package Critics;

import Contents.*;

public class MovieCritic extends Critic{
	public MovieCritic() {
		this(0,0);
	}
	public MovieCritic(double opinion,int no) {
		super(opinion,no);
	}
	public MovieCritic(MovieCritic critic) {
		this(critic.getOpinion(),critic.getTurnNo());
	}
	
	@SuppressWarnings("hiding")
	@Override
	public <Movie> double calculateRating(Movie movie) {
		double rating = ((Contents.Movie) movie).getRating(getOpinion());
		return rating;
	}

	
}
