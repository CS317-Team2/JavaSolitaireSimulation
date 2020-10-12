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
	
	public ArrayList<Card> getFoundationHeart() {
		return foundationHeart;
	}
	
	public ArrayList<Card> getFoundationDiamond() {
		return foundationDiamond;
	}
	
	public ArrayList<Card> getFoundationSpade() {
		return foundationSpade;
	}
	
	public void setUp() {
		//this.deck.shuffle();
		tableau[0].add(this.deck.drawCard());
		
		for (int i = 0; i < 2; i++) {
			tableau[1].add(this.deck.drawCard());		
		}
		tableau[1].get(1).hide();
		
		for (int i = 0; i < 3; i++) {
			tableau[2].add(this.deck.drawCard());
		}
		tableau[2].get(1).hide();
		tableau[2].get(2).hide();
		
		for (int i = 0; i < 4; i++) {
			tableau[3].add(this.deck.drawCard());
		}
		tableau[3].get(1).hide();
		tableau[3].get(2).hide();
		tableau[3].get(3).hide();
		
		for (int i = 0; i < 5; i++) {
			tableau[4].add(this.deck.drawCard());
		}
		tableau[4].get(1).hide();
		tableau[4].get(2).hide();
		tableau[4].get(3).hide();
		tableau[4].get(4).hide();
		
		for (int i = 0; i < 6; i++) {
			tableau[5].add(this.deck.drawCard());
		}
		tableau[5].get(1).hide();
		tableau[5].get(2).hide();
		tableau[5].get(3).hide();
		tableau[5].get(4).hide();
		tableau[5].get(5).hide();
		
		for (int i = 0; i < 7; i++) {
			tableau[6].add(this.deck.drawCard());
		}
		tableau[6].get(1).hide();
		tableau[6].get(2).hide();
		tableau[6].get(3).hide();
		tableau[6].get(4).hide();
		tableau[6].get(5).hide();
		tableau[6].get(6).hide();
	}
	
	public ArrayList<Card>[] getTableau() {
		return tableau;
	}

	public ArrayList<Card> getTableau0() {
		return tableau[1];
	}
	
	public CardDeck getDeck() {
		return deck;
	}
	
	

	public String solve() {
		boolean solved = false;
		boolean failed = false;
		//boolean move = false;
		while (solved == false && failed == false) {
			
			while (tableauToFoundation());
			deckToFoundation();
			//Attempted move king to open spot
			
			//if (checkOpen()){
				//ArrayList<Card> kingSpot = new ArrayList<Card>();
				//for (int i = 0; i < 7; i ++) {
				//	if (tableau[i].size() == 0) {
				//		kingSpot = tableau[i];
				//	}
				//}
				//for (int i = 0; i < 7; i ++) {
				//	if (tableau[i].get(tableau[i].size() - 1).getRank() == 13) {
				//		kingSpot.add(tableau[i].remove(tableau[i].size()- 1));
				//	}
				//}
		//	}
			
			if (deck.getCirculation() > 3) {
				failed = true;
				break;
			}
			if (this.foundationHeart.size() == 14 &&
				this.foundationDiamond.size() == 14 &&
				this.foundationClub.size() == 14 &&
				this.foundationSpade.size() == 14) {
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
	
	public void tableauToTableau() {
		int empty = 100;
		int rank = 100;
		
		for (int i = 0; i < 7; i++) {
			if (tableau[i].size()==0) {
				//potential king spot
			}
			//tableau[i].
		}
	}
	
	public boolean deckToFoundation() {
		if (deck.getPlayingDeck().isEmpty() && deck.getDiscardDeck().isEmpty()) {
			return false;	
		}
		if (deck.getPlayingDeck().isEmpty()) {
			deck.reset();
		}
		
		Card card = deck.drawCard();
		String suit  = card.getSuit();
		if (canPutFoundation(card)) {
			if (suit == "Hearts") {
				this.foundationHeart.add(card);
				return true;
			}
			if (suit == "Diamonds") {
				this.foundationDiamond.add(card);
				return true;
			}
			if (suit == "Clubs") {
				this.foundationClub.add(card);
				return true;
			}
			if (suit == "Spades") {
				this.foundationSpade.add(card);
				return true;
			}
			
		}
		return false;
	}
	
	public boolean tableauToFoundation() {
		for (int i = 0; i < 7; i++) {
			if (tableau[i].size() != 0) { 
				Card card = tableau[i].get(tableau[i].size()- 1);
				String suit  = card.getSuit();
				if (canPutFoundation(card)) {
					if (suit == "Hearts") {
						this.foundationHeart.add(tableau[i].remove(tableau[i].size()- 1));
						return true;
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
