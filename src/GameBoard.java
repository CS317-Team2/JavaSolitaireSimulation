import java.util.ArrayList;

public class GameBoard {
	
	private ArrayList<Card>[] foundation;
	private ArrayList<Card>[] tableau;
	private CardDeck deck;
	
	public GameBoard() {
		this.foundation = new ArrayList[4];
		this.tableau = new ArrayList[7];
		this.deck = new CardDeck();
	}
	
	public void setUp() {
		this.deck.shuffle();
		tableau[0].add(this.deck.drawCard());
		
		for (int i = 0; i < 2; i++) {
			tableau[1].add(this.deck.drawCard());
		}
		
		for (int i = 0; i < 3; i++) {
			tableau[2].add(this.deck.drawCard());
		}
		
		for (int i = 0; i < 4; i++) {
			tableau[3].add(this.deck.drawCard());
		}
		
		for (int i = 0; i < 5; i++) {
			tableau[4].add(this.deck.drawCard());
		}
		
		for (int i = 0; i < 6; i++) {
			tableau[5].add(this.deck.drawCard());
		}
		
		for (int i = 0; i < 7; i++) {
			tableau[6].add(this.deck.drawCard());
		}
	}

	public ArrayList<Card>[] getFoundation() {
		return foundation;
	}

	public ArrayList<Card>[] getTableau() {
		return tableau;
	}

	public CardDeck getDeck() {
		return deck;
	}
	
	
	//IMPLEMENT RULES HERE
	//public String solve() {}
	
}
