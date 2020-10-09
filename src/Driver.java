import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of games: ");
		double games = s.nextDouble();
		double wins = 0.0;
		for (int i = 0; i < games; i ++) {
			GameBoard board = new GameBoard();
			board.setUp();

		
			String results = board.solve();
			if (results.equals("solved")) {
				wins++;
			}
			
			//prints off number of cards in club foundation
			ArrayList a = board.getFoundationClub();
			for (int j = 0; j < a.size(); j ++) {
				Card b = (Card) a.get(j);
				System.out.println(b.getRank());
			}
			System.out.println("*****");
		}
		System.out.println("total number of wins: " + wins);
		System.out.println("winning percentage: " + wins/games);
		s.close();
		
		}

}
