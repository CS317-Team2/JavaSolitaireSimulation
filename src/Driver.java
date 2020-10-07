import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("Enter number of games:");
		
		
		Scanner s = new Scanner(System.in);
		double games = s.nextDouble();
		double wins = 0.0;
		for (int i = 0; i < games; i ++) {
			GameBoard board = new GameBoard();
			board.setUp();

		
			String results = board.solve();
			if (results.equals("solved")) {
				wins++;
			}
		}
		System.out.println("total number of wins: " + wins);
		System.out.println("winning percentage: " + wins/games);
		
		
		//ArrayList<Card> a = board.getFoundationClub();
		//for (int i = 0; i < a.size(); i++) {
	//		System.out.println(a.get(i).getRank());
	//	}
		
		}

}
