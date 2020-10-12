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

		
			Boolean results = board.solve();
			if (results) {
				wins++;
			}
			
			//prints off number of cards in first tableau
			//ArrayList a = board.getTableau0();
			//prints off number of cards in club foundation
//			ArrayList a = board.getFoundationClub();
//			for (int j = 0; j < a.size(); j ++) {
//				Card c = (Card) a.get(j);
//				System.out.println(c.getRank());
//			}
//			System.out.println("*****");
//			
//			ArrayList b = board.getFoundationDiamond();
//			for (int j = 0; j < b.size(); j ++) {
//				Card c = (Card) b.get(j);
//				System.out.println(c.getRank());
//			}
//			System.out.println("*****");
		}
		System.out.println("total number of wins: " + wins);
		System.out.println("winning percentage: " + wins/games * 100);
		s.close();
		
		}

}
