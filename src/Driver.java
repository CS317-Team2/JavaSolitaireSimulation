// Import Array List
import java.util.ArrayList;

// Import Scanner
import java.util.Scanner;

/**
 * 
 * The driver class starts the game of Klondike Solitaire
 * 
 * @author pengs
 *
 */
public class Driver {
	
	/**
	 * 
	 * Main method to activate the game
	 * 
	 * @param args input for number of games
	 */
	public static void main(String[] args) {
		
		// Scanner input
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of games: ");
		
		// Beginning of the timer
		final long startTime = System.currentTimeMillis();
		
		// Gets the number of games from s (Scanner)
		double games = s.nextDouble();
		double wins = 0.0;
		
		// Loop through the total amount of games
		for (int i = 0; i < games; i ++) {
			
			// Calls the Game Board class and creates a game board simulator
			GameBoard board = new GameBoard();
			
			// Sets up the board
			board.setUp();

			// Boolean if the entire foundations have all four ranks and colors correctly
			Boolean results = board.solve();
			
			// If true, increase your win
			if (results) {
				wins++;
			}
			
			// Array list created for the Club Foundation
			ArrayList a = board.getFoundationClub();
			for (int j = 0; j < a.size(); j ++) {
				Card c = (Card) a.get(j);
				System.out.print(c.getRank() + ", ");
			}
			System.out.println("Club Foundation");
			
			// Array list created for the Diamond Foundation
			ArrayList b = board.getFoundationDiamond();
			for (int j = 0; j < b.size(); j ++) {
				Card c = (Card) b.get(j);
				System.out.print(c.getRank()+ ", ");
			}
			System.out.println("Diamond Foundation");
			
			// Array list created for the Heart Foundation
			ArrayList d = board.getFoundationHeart();
			for (int j = 0; j < d.size(); j ++) {
				Card c = (Card) d.get(j);
				System.out.print(c.getRank()+ ", ");
			}
			System.out.println("Heart Foundation");
			
			// Array list created for the Spade Foundation
			ArrayList e = board.getFoundationSpade();
			for (int j = 0; j < e.size(); j ++) {
				Card c = (Card) e.get(j);
				System.out.print(c.getRank()+ ", ");
			}
			System.out.println("Spade Foundation");
			System.out.println("******");
		}
		// Ending of the timer
		final long endTime = System.currentTimeMillis();
		
		System.out.println("total number of wins: " + wins);
		
		System.out.println("winning percentage: " + wins/games * 100);
		
		System.out.println("Time in milliseconds: " + (endTime - startTime));
		
		// Closes the scanner
		s.close();
		
		}

}
