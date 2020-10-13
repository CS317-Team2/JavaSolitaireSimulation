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
			
			//prints off number of cards in club foundation
			ArrayList a = board.getFoundationClub();
			for (int j = 0; j < a.size(); j ++) {
				Card c = (Card) a.get(j);
				System.out.print(c.getRank() + ", ");
			}
			System.out.println("Club Foundation");
			
			ArrayList b = board.getFoundationDiamond();
			for (int j = 0; j < b.size(); j ++) {
				Card c = (Card) b.get(j);
				System.out.print(c.getRank()+ ", ");
			}
			System.out.println("Diamond Foundation");
			
			ArrayList d = board.getFoundationHeart();
			for (int j = 0; j < d.size(); j ++) {
				Card c = (Card) d.get(j);
				System.out.print(c.getRank()+ ", ");
			}
			System.out.println("Heart Foundation");
			
			ArrayList e = board.getFoundationSpade();
			for (int j = 0; j < e.size(); j ++) {
				Card c = (Card) e.get(j);
				System.out.print(c.getRank()+ ", ");
			}
			System.out.println("Spade Foundation");
			System.out.println("******");
		}
		System.out.println("total number of wins: " + wins);
		System.out.println("winning percentage: " + wins/games * 100);
		s.close();
		
		}

}
