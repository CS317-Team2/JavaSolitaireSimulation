import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		board.setUp();
		ArrayList<Card>[] tableau = board.getTableau();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < tableau[i].size(); j++) {
				Card card = tableau[i].get(j);
				System.out.println(card.getRank() + " of " + card.getSuit());
				
			}
			System.out.println("************");
		}
	}

}
