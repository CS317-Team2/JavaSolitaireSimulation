import java.util.ArrayList;

public class GameBoard {
	
	private static ArrayList<Card> foundationDiamond;
	private static ArrayList<Card> foundationSpade;
	private static ArrayList<Card> foundationHeart;
	private static ArrayList<Card> foundationClub;
	private ArrayList<Card>[] tableau;
	private CardDeck deck;
	
	public GameBoard() {
		this.tableau = new ArrayList[7];
		this.deck = new CardDeck();
		tableau[0] = new ArrayList<Card>();
		tableau[1] = new ArrayList<Card>();
		tableau[2] = new ArrayList<Card>();
		tableau[3] = new ArrayList<Card>();
		tableau[4] = new ArrayList<Card>();
		tableau[5] = new ArrayList<Card>();
		tableau[6] = new ArrayList<Card>();
		
		foundationDiamond = new ArrayList<Card>();
		foundationSpade = new ArrayList<Card>();
		foundationHeart = new ArrayList<Card>();
		foundationClub = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getFoundationClub() {
		return foundationClub;
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
	
	public ArrayList<Card>[] getTableau() {
		return tableau;
	}

	public CardDeck getDeck() {
		return deck;
	}
	
	

	public String solve() {
		boolean solved = false;
		boolean failed = false;
		boolean move = false;
		while (solved == false && failed == false) {
			while (tableauToFoundation());
			deckToFoundation();
			//for (int i = 0; i < 7; i ++) {
				//if (checkOpen() && tableau[i].get(tableau[i].size() - 1).getRank() == 14) {
			//		.add(tableau[i].remove(tableau[i].size()- 1));
			//	}
			//}
			if (deck.getCirculation() > 3) {
				failed = true;
				break;
			}
			if (this.foundationHeart.size() == 13 &&
				this.foundationDiamond.size() == 13 &&
				this.foundationClub.size() == 13 &&
				this.foundationSpade.size() == 13) {
				solved = true;
				break;
			}
			solve();
		}
		if (solved == true) {
			return "solved";
		}
		else {
			return "not solved";
		}
		
	}
		
	public void deckToFoundation() {
		if (deck.getPlayingDeck().isEmpty()) {
			deck.reset();
			if (deck.getPlayingDeck().isEmpty()) {
				return;
			}
		}
		
		Card card = deck.drawCard();
		String suit  = card.getSuit();
		if (canPutFoundation(card)) {
			if (suit == "Hearts") {
				this.foundationHeart.add(card);
			}
			if (suit == "Diamonds") {
				this.foundationDiamond.add(card);
			}
			if (suit == "Clubs") {
				this.foundationClub.add(card);
			}
			if (suit == "Spades") {
				this.foundationSpade.add(card);
			}
			
		}
	}
	
	public boolean tableauToFoundation() {
		for (int i = 0; i < 7; i++) {
			if (tableau[i].size() == 0) {
				i++;
			} 
			if (checkOpen()) {
				return false;
			}
			Card card = tableau[i].get(tableau[i].size()- 1);
			String suit  = card.getSuit();
			if (canPutFoundation(card)) {
				if (suit == "Hearts") {
					this.foundationHeart.add(tableau[i].remove(tableau[i].size()- 1));						return true;
				}
				if (suit == "Diamonds") {
					this.foundationDiamond.add(tableau[i].remove(tableau[i].size()- 1));
					return true;
				}
				if (suit == "Clubs") {
					this.foundationClub.add(tableau[i].remove(tableau[i].size()- 1));
					return true;
				}
				if (suit == "Spades") {
					this.foundationSpade.add(tableau[i].remove(tableau[i].size()- 1));
					return true;
				}
					
			}
		}
		return false;
	}
		
	
	
	public static boolean canPutFoundation(Card card) {
		boolean a = false;
		String suit = card.getSuit();
		if (suit == "Hearts") {
			if (card.getRank() == foundationHeart.size() + 1) {
				a = true;
			}
		}
		if (suit == "Diamonds") {
			if (card.getRank() == foundationDiamond.size() + 1) {
				a = true;
			}
		}
		if (suit == "Clubs") {
			if (card.getRank() == foundationClub.size() + 1) {
				a = true;
			}
		}
		if (suit == "Spades") {
			if (card.getRank() == foundationSpade.size() + 1) {
				a = true;
			}
		}
		return a;
	}
	
	public boolean checkOpen() {
		boolean result = false;
		for (int i = 0; i < 7; i++) {
			if (tableau[i].size() == 0) {
				result = true;
			}
		}
		return result;
	}
}
