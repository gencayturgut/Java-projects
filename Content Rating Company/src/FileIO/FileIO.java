package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import Contents.*;

public class FileIO {
	@SuppressWarnings("resource")
	public static <T> void readFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] attr = line.split(",");
			if(attr.length!=1) {
				switch(attr[1]) {
				case "0":
					readMovie(attr);
					break;
				case "1","2","3":
					readGame(attr);
					break;
				default:
					System.out.println("invalid content type");
					break;
				}
			}
		}
		scan.close();
	}
	public static void readMovie(String[] attr) {
		int arrDay = Integer.parseInt(attr[0]);
		String name = attr[2];
		int year = Integer.parseInt(attr[3]);
		int duration = Integer.parseInt(attr[4]);
		double rating = Double.parseDouble(attr[5]);
		Movie movie = new Movie(arrDay,name,year,duration,rating);
		Movie.addMovieToStack(movie);
	}
	public static void readGame(String[] attr) {
		int arrDay = Integer.parseInt(attr[0]);
		int gameType = Integer.parseInt(attr[1]);
		String name = attr[2];
		int duration = Integer.parseInt(attr[3]);
		int rating = Integer.parseInt(attr[4]);
		switch(attr[1]) {
			case "1":
				IndefiniteGame indefiniteGame = new IndefiniteGame(arrDay,gameType,name,duration,rating);
				Game.addGameToStack(indefiniteGame);
				break;
			case "2":
				StoryGame storyGame = new StoryGame(arrDay,gameType,name,duration,rating);
				Game.addGameToStack(storyGame);
				break;
			case "3":
				CasualGame casualGame = new CasualGame(arrDay,gameType,name,duration,rating);
				Game.addGameToStack(casualGame);
				break;
			default:
				System.out.println("invalid game type");
				break;
		}
		
		
	}

	
}
