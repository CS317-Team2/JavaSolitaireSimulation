// Import Array List
import java.util.ArrayList;

/**
 * 
 * The initiation of the game board for solitaire
 * 
 * @author pengs
 *
 */
public class GameBoard {
	
	private static ArrayList<Card> foundationDiamond;
	private static ArrayList<Card> foundationSpade;
	private static ArrayList<Card> foundationHeart;
	private static ArrayList<Card> foundationClub;
	private ArrayList<Card>[] tableau, stopT;
	private CardDeck deck;
	private int moves;
	
	/**
	 * 
	 * Initalizing the game board setup
	 * 
	 */
	public GameBoard() {
		// Creates the tableau
		this.tableau = new ArrayList[7];
		
		// Creates a new Card Deck
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
	
	/**
	 * 
	 * Gets the Club foundation
	 * 
	 * @return the array list for the club foundation
	 */
	public ArrayList<Card> getFoundationClub() {
		return foundationClub;
	}
	
	/**
	 * 
	 * Gets the Heart foundation
	 * 
	 * @return the array list for the heart foundation
	 */
	public ArrayList<Card> getFoundationHeart() {
		return foundationHeart;
	}
	
	/**
	 * 
	 * Gets the Diamond foundation
	 * 
	 * @return the array list for the diamond foundation
	 */
	public ArrayList<Card> getFoundationDiamond() {
		return foundationDiamond;
	}
	
	/**
	 * 
	 * Gets the Spade foundation
	 * 
	 * @return the array list for the spade foundation
	 */
	public ArrayList<Card> getFoundationSpade() {
		return foundationSpade;
	}
	
	/**
	 * Set up the game board
	 */
	public void setUp() {
		this.deck.shuffle();
		moves = 0;
		
		// First tableau gets 1 card
		tableau[0].add(this.deck.drawCard());
		
		// Second tableau gets 2 cards but 1 card is hidden
		for (int i = 0; i < 2; i++) {
			tableau[1].add(this.deck.drawCard());		
		}
		tableau[1].get(0).hide();
		
		// Third tableau gets 3 cards but 2 cards are hidden
		for (int i = 0; i < 3; i++) {
			tableau[2].add(this.deck.drawCard());
		}
		tableau[2].get(0).hide();
		tableau[2].get(1).hide();
		
		// Fourth tableau gets 4 cards but 3 cards are hidden
		for (int i = 0; i < 4; i++) {
			tableau[3].add(this.deck.drawCard());
		}
		tableau[3].get(0).hide();
		tableau[3].get(1).hide();
		tableau[3].get(2).hide();
		
		// Fifth tableau gets 5 cards but 4 cards are hidden
		for (int i = 0; i < 5; i++) {
			tableau[4].add(this.deck.drawCard());
		}
		tableau[4].get(0).hide();
		tableau[4].get(1).hide();
		tableau[4].get(2).hide();
		tableau[4].get(3).hide();
		
		// Sixth tableau gets 6 cards but 5 cards are hidden
		for (int i = 0; i < 6; i++) {
			tableau[5].add(this.deck.drawCard());
		}
		tableau[5].get(0).hide();
		tableau[5].get(1).hide();
		tableau[5].get(2).hide();
		tableau[5].get(3).hide();
		tableau[5].get(4).hide();
		
		// Seventh tableau gets 7 cards but 6 cards are hidden
		for (int i = 0; i < 7; i++) {
			tableau[6].add(this.deck.drawCard());
		}
		tableau[6].get(0).hide();
		tableau[6].get(1).hide();
		tableau[6].get(2).hide();
		tableau[6].get(3).hide();
		tableau[6].get(4).hide();
		tableau[6].get(5).hide();
		
		stopT = tableau;
	}
	
	/**
	 * 
	 * Get the tableau
	 * 
	 * @return the tableau
	 */
	public ArrayList<Card>[] getTableau() {
		return tableau;
	}

	/**
	 * 
	 * Get the deck
	 * 
	 * @return the deck
	 */
	public CardDeck getDeck() {
		return deck;
	}
	
	/**
	 * 
	 * Solves the game
	 * 
	 * @return true if solved
	 */
	public boolean solve() {

		if (this.foundationHeart.size() == 14 &&
			this.foundationDiamond.size() == 14 &&
			this.foundationClub.size() == 14 &&
			this.foundationSpade.size() == 14) {
			System.out.println("Moves: " + moves);
				return true;
		}
		else if (deck.getCirculation() > 3) {
			System.out.println("Moves: " + moves);
			return false;
		}
		else {
			while(tableauToFoundation());
			tableauToTableau();
			deckToFoundation();
			deckToTableau();
			System.out.println("Moves: " + moves);
			gameWatch();
			return solve();
		}	

	}
	
	/**
	 * 
	 * Watches if any tableau are open
	 * 
	 */
	public void gameWatch() {
		for (int i = 0; i < 7; i++) {
			System.out.print("|T" + i +"|");
			ArrayList a = tableau[i];
			if ((tableau[i].size() >= 1)) {
				Card b = (Card) a.get(tableau[i].size()-1);
				System.out.print(" " + b.getRank() + b.getSuit() + " C"+ tableau[i].size() + " ");
			}
		}
		System.out.println();
	}
	
	/**
	 * Moves a card from the deck to the tableau
	 */
	public void deckToTableau() {
		ArrayList<Card> discard = deck.getDiscardDeck();
		if (!discard.isEmpty()) {
			Card DCard = discard.get(discard.size()-1);
			for (int i = 0; i < 7; i++) {
				if (tableau[i].size() > 0) {
					Card TCard = tableau[i].get(tableau[i].size() - 1);
					if (TCard.getRank() == DCard.getRank()+1 && TCard.getColor() != DCard.getColor()) {
						tableau[i].add(DCard);
						deck.removeFromDiscard(DCard);
						moves++;
						return;
					}
				}
			}
		}
	}
	//tableautotableau but only moving one card at a time
	public void tableauToTableau() {
		//Checks for open tableau space, and then looks for/places a king
		for (int i = 0; i < 7; i++) {
			if (tableau[i].size() == 0) {
				for(int j = 0; j < 7; j++) {
					if(!tableau[j].isEmpty()) {
						if(tableau[j].get(tableau[j].size() - 1).getRank() == 14){
							tableau[i].add(tableau[j].remove(tableau[j].size()- 1));
							moves++;
						}
					}
				}
			}
		}
		ArrayList bottomCards = new ArrayList();
		
		for (int i =0; i < 7; i++) {
			 bottomCards.add(tableau[i].get(tableau[i].size() - 1));
		}
		ArrayList duplicate = bottomCards;
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (i <= j) {
					Card first = (Card) bottomCards.get(i);
					Card second = (Card) duplicate.get(j);
					if (!(first.getColor().equals(second.getColor())) && first.getRank() == second.getRank()+1) {
						System.out.println(duplicate.get(i));
						tableau[i].add(tableau[j].remove(tableau[j].size()-1));
						moves++;
						break;
					}
				} 
			}
		}
	}
	
	
	/**
	 * Moves a card from one of the tableaus to one of the other 
	 * tableaus.
	 */
//	public void tableauToTableau() {
//		
//		//Checks for open tableau space, and then looks for/places a king
//		for (int i = 0; i < 7; i++) {
//			if (tableau[i].size() == 0) {
//				for(int j = 0; j < 7; j++) {
//					if(!tableau[j].isEmpty()) {
//						if(tableau[j].get(tableau[j].size() - 1).getRank() == 14){
//							tableau[i].add(tableau[j].remove(tableau[j].size()- 1));
//							moves++;
//						}
//					}
//				}
//			}
//		}
//
//		for(int i = 0; i < 7; i++) {
//			ArrayList<Card> toMove = checkCardsAbove(i);
//			boolean moved = false;
//			int temp = toMove.size() - 1;
//			if(!toMove.isEmpty()) {
//				Card cardToCheck = toMove.get(toMove.size()-1);
//				for(int j = 0; j < 7; j++) {
//					if (tableau[j].size() > 0) {
//						Card card = tableau[j].get(tableau[j].size() - 1);
//						if(cardToCheck.getRank() == card.getRank() + 1 && !cardToCheck.getColor().equals(card.getColor())) {
//							int column = i;
//							moved = true;
//							while(temp > 0) {
//								Card toAdd = toMove.get(temp);
//								tableau[j].add(toAdd);
//								temp--;
//							}
//							if(moved) {
//								removeCards(toMove, column);
//								moves++;
//								break;
//							}
//						}
//					}
//				}
//			}
//		}
//	}

	/**
	 * 
	 * Placing a rank from the deck to the foundation
	 * 
	 * @return true if the rank matches to the foundation requirements
	 */
	public boolean deckToFoundation() {
		if (deck.getPlayingDeck().isEmpty() && deck.getDiscardDeck().isEmpty()) {
			return false;	
		}
		if (!deck.getDiscardDeck().isEmpty()) {
			Card discard = deck.discardCard();
			String suitD = discard.getSuit();
			if (canPutFoundation(discard)) {
				if (suitD == "Hearts") {
					this.foundationHeart.add(discard);
					moves++;
					return deckToFoundation();
				}
				if (suitD == "Diamonds") {
					this.foundationDiamond.add(discard);
					moves++;
					return deckToFoundation();
				}
				if (suitD == "Clubs") {
					this.foundationClub.add(discard);
					moves++;
					return deckToFoundation();
				}
				if (suitD == "Spades") {
					this.foundationSpade.add(discard);
					moves++;
					return deckToFoundation();
				}
			}
		}
		if (deck.getPlayingDeck().isEmpty()) {
			deck.reset();
		}
		
		Card card = deck.drawCard();
		moves++;
		String suit  = card.getSuit();
		if (canPutFoundation(card)) {
			if (suit == "Hearts") {
				this.foundationHeart.add(card);
				moves++;
				return true;
			}
			if (suit == "Diamonds") {
				this.foundationDiamond.add(card);
				moves++;
				return true;
			}
			if (suit == "Clubs") {
				this.foundationClub.add(card);
				moves++;
				return true;
			}
			if (suit == "Spades") {
				this.foundationSpade.add(card);
				moves++;
				return true;
			}
			
		}
		else {
			deck.addToDiscardPile(card);
		}
		deckToTableau();
		return false;
	}
	
	/**
	 * 
	 * Placing a rank from the tableau to the foundation
	 * 
	 * @return true if the rank matches to the foundation requirements
	 */
	public boolean tableauToFoundation() {
		
		for (int i = 0; i < 7; i++) {
			if (tableau[i].size() != 0) { 
				Card card = tableau[i].get(tableau[i].size()- 1);
				Card cardAbove = tableau[i].get(tableau[i].size()- 1);
				if (tableau[i].size() > 1) {
					cardAbove = tableau[i].get(tableau[i].size()- 2);
				}
				String suit  = card.getSuit();
				if (canPutFoundation(card)) {
					if (suit == "Hearts") {
						cardAbove.makeVisible();
						this.foundationHeart.add(tableau[i].remove(tableau[i].size()- 1));
						moves++;
						return true;
					}
					if (suit == "Diamonds") {
						cardAbove.makeVisible();
						this.foundationDiamond.add(tableau[i].remove(tableau[i].size()- 1));
						moves++;
						return true;
					}
					if (suit == "Clubs") {
						cardAbove.makeVisible();
						this.foundationClub.add(tableau[i].remove(tableau[i].size()- 1));
						moves++;
						return true;
					}
					if (suit == "Spades") {
						cardAbove.makeVisible();
						this.foundationSpade.add(tableau[i].remove(tableau[i].size()- 1));
						moves++;
						return true;
					}
					
				}
			}
			else {
				tableauToTableau();
			}
		}
		return false;
	}
		
	
	/**
	 * 
	 * Ckecing if the card can be placed in the foundation
	 * 
	 * @param card the card had it's rank and color
	 * @return true if it can be placed on the foundation
	 */
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
	
	/**
	 * 
	 * Checking if there is any open spot
	 * 
	 * @return true if there is an open spot
	 */
	public boolean checkOpen() {
		boolean result = false;
		if (tableau[0].size() == 0 &&
			tableau[1].size() == 0 &&
			tableau[2].size() == 0 &&
			tableau[3].size() == 0 &&
			tableau[4].size() == 0 &&
			tableau[5].size() == 0 &&
			tableau[6].size() == 0) {
				result = true;
		}
		return result;
	}
	
	/**
	 * 
	 * Check the card above
	 * 
	 * @param i the number for which card to check
	 * @return the card that is being checked
	 */
	public ArrayList<Card> checkCardsAbove(int i) {
		ArrayList<Card> holdArray = new ArrayList<Card>();
			for(int j = tableau[i].size()-1; j > 0; j--) {
				Card card = tableau[i].get(tableau[i].size() - 1);
				int temp = j;
				while(temp > 0) {
					if(card.getHidden() == 1) {
						Card cardAbove = tableau[i].get(temp);
						if(!card.getColor().equals(cardAbove.getColor()) && cardAbove.getRank() == card.getRank() + 1) {
							holdArray.add(cardAbove);
						}
					}
					temp--;
				}

			}
		return holdArray;
	}
	
	/**
	 * 
	 * Remove the cards
	 * 
	 * @param moved the ones that have been moved
	 * @param column the ones that are in the tableau
	 */
	public void removeCards(ArrayList<Card> moved, int column) {
		for(int i = 0; i > moved.size() - 1; i++) {
			tableau[column].remove(tableau[column].get(tableau[column].indexOf(moved.get(i))));
			moves++;
		}
		if(!tableau[column].isEmpty()) {
			tableau[column].get(tableau[column].size() - 1).makeVisible();
		}
	}
	
}
