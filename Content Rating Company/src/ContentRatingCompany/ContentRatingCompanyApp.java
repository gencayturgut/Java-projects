package ContentRatingCompany;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import Contents.Game;
import Contents.Movie;
import Contents.SortByName;
import Critics.*;
import FileIO.FileIO;

public class ContentRatingCompanyApp {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		FileIO.readFile("src/FileIO/contents.csv");
		
		Queue<MovieCritic> movieCritics = new LinkedList<MovieCritic>();
		Queue<GameCritic> gameCritics = new LinkedList<GameCritic>();
		
		MovieCritic mC1 = new MovieCritic(0.1,1);
		MovieCritic mC2 = new MovieCritic(-0.2,2);
		MovieCritic mC3 = new MovieCritic(0.3,3);
		
		GameCritic gC1 = new GameCritic(5,1);
		GameCritic gC2 = new GameCritic(9,2);
		GameCritic gC3 = new GameCritic(-3,3);
		GameCritic gC4 = new GameCritic(2,4);
		GameCritic gC5 = new GameCritic(-7,5);
		
		movieCritics.add(mC1);
		movieCritics.add(mC2);
		movieCritics.add(mC3);
		gameCritics.add(gC1);
		gameCritics.add(gC2);
		gameCritics.add(gC3);
		gameCritics.add(gC4);
		gameCritics.add(gC5);
		
		Queue<MovieCritic> tempMC = new LinkedList<MovieCritic>();
		Queue<GameCritic> tempGC = new LinkedList<GameCritic>();
		
		Queue<Game> interruptedGames = new LinkedList<Game>();
		Queue<GameCritic> interruptedCritics = new LinkedList<GameCritic>();
		
		for(MovieCritic critic: movieCritics) {
			tempMC.add(critic);
		}
		for(GameCritic critic: gameCritics) {
			tempGC.add(critic);
		}
		
		Movie.sortStack();
		Game.sortStack();
		
		ArrayList<Movie> processedMovies = new ArrayList<Movie>();
		ArrayList<Game> gamesDoneToday = new ArrayList<Game>();
		
		
		for(int day=1;day<=5;day++) {
			System.out.println("\n" + day + ". day:\n");
			Stack<Movie> movieStack = Movie.getMovieStack();
			while(tempMC.size()!=0) {
				MovieCritic movieCritic = tempMC.peek();
				Movie currentMovie = movieStack.peek();
				if(currentMovie.getArrivalDay()==day) {
					currentMovie.setCritic(movieCritic);
					tempMC.poll();
					movieStack.remove(currentMovie);
					processedMovies.add(currentMovie);
					System.out.println(currentMovie.getCritic().getTurnNo() + ". movie critic evaluated " + currentMovie.getName());
					
				}
				else {break;}
			}
			for(MovieCritic member: movieCritics) {
				
				tempMC.add(member);
			}
			
			
			Queue<Game> temp = new LinkedList<Game>();
			
			while(interruptedGames.size()!=0) {
				Game currentGame = interruptedGames.poll();
				GameCritic gameCritic = interruptedCritics.poll();
				tempGC.remove(gameCritic);
				int timeWorked = gameCritic.getTimeWorked();
				gamesDoneToday.add(currentGame);
				
				if((timeWorked + currentGame.getTimeLeftPlaying())>8 ) {
					System.out.println(currentGame.getCritic().getTurnNo() + ". game critic works on " + currentGame.getName());
					temp.add(currentGame);
					gameCritic.setTimeWorked(0);
					interruptedCritics.add(gameCritic);
				}
				else if((timeWorked + currentGame.getTimeLeftPlaying())==8) {
					System.out.println(currentGame.getCritic().getTurnNo() + ". game critic evaluated " + currentGame.getName());
					currentGame.setCompleted(true);
					currentGame.setFinalRating(gameCritic.calculateRating(currentGame));
					gameCritic.setTimeWorked(0);
				}
				else if((timeWorked + currentGame.getTimeLeftPlaying())<8) {
					System.out.println(currentGame.getCritic().getTurnNo() + ". game critic evaluated " + currentGame.getName());
					currentGame.setCompleted(true);
					currentGame.setFinalRating(gameCritic.calculateRating(currentGame));
					tempGC.add(gameCritic);
					gameCritic.setTimeWorked(timeWorked + currentGame.getTimeLeftPlaying());
				}
				else {System.out.println("invalid result in timeWorked");}
				
			}
			interruptedGames = temp;
			
			
			Stack<Game> gameStack = Game.getGameStack();
			
			while(tempGC.size()!=0) {
				if(!gameStack.isEmpty()) {
					Game currentGame = gameStack.peek();
					if(currentGame.getArrivalDay()==day) {
						GameCritic critic = tempGC.peek();
						int timeWorked=critic.getTimeWorked();
						currentGame.setCritic(critic);
						gamesDoneToday.add(currentGame);
						if((timeWorked + currentGame.getTimeLeftPlaying())>8 ) {
							System.out.println(currentGame.getCritic().getTurnNo() + ". game critic works on " + currentGame.getName());
							interruptedGames.add(currentGame);
							gameStack.pop();
							critic.setTimeWorked(0);
							interruptedCritics.add(critic);
							tempGC.poll();
						}
						else if((timeWorked + currentGame.getTimeLeftPlaying())==8) {
							gameStack.pop();
							System.out.println(currentGame.getCritic().getTurnNo() + ". game critic evaluated " + currentGame.getName());
							currentGame.setCompleted(true);
							currentGame.setFinalRating(critic.calculateRating(currentGame));
							tempGC.poll();
							critic.setTimeWorked(0);
						}
						else if((timeWorked + currentGame.getTimeLeftPlaying())<8) {
							gameStack.pop();
							System.out.println(currentGame.getCritic().getTurnNo() + ". game critic evaluated " + currentGame.getName());
							currentGame.setCompleted(true);
							currentGame.setFinalRating(critic.calculateRating(currentGame));
							currentGame.getFinalRating();
							tempGC.poll();
							tempGC.add(critic);
							critic.setTimeWorked(timeWorked + currentGame.getTimeLeftPlaying());
						}
						else {System.out.println("invalid result in timeWorked");}
						
					}
					else {break;}
				}
				else {break;}
			}
			
			for(GameCritic gameCritic: gameCritics) {
				tempGC.add(gameCritic);
			}
			
		}
		
		Comparator<Movie> comparatorMovie = (Comparator<Movie>) new SortByName<Movie>();
		Comparator<Game> comparatorGame = (Comparator<Game>) new SortByName<Game>();
		
		System.out.println("\n" + "Ratings:\n");
		processedMovies.sort(comparatorMovie);
		List<Game> games = gamesDoneToday.stream().distinct().collect(Collectors.toList());
		gamesDoneToday.sort(comparatorGame);
		for(Movie movie:processedMovies) {
			System.out.println(movie);
		}
		for(Game game: games) {
			System.out.println(game);
		}
		
		
	}	
		
}
	

