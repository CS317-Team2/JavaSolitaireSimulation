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
	private ArrayList<Card>[] tableau;
	private CardDeck deck;
	private int moves;
	
	/**
	 * 
	 * Initialize the game board setup
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
	public int getMoves() {
		return moves;
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

		if (this.foundationHeart.size() == 13 &&
			this.foundationDiamond.size() == 13 &&
			this.foundationClub.size() == 13 &&
			this.foundationSpade.size() == 13) {
			System.out.println("Moves: " + moves);
				return true;
		}
		else if (deck.getCirculation() > 3) {
			System.out.println("Moves: " + moves);
			return false;
		}
		else {
			tableauToTableau();
			while(tableauToFoundation());
			deckToTableau();
			deckToFoundation();
			
			

			//smart();
			
			//gameWatch();
			
			return solve();
			//return false;
		}	

	}
	
	public void smart() {
		for (int i = 0; i < 7; i++) {
			if (!tableau[i].isEmpty()) {
				if (canPutFoundation(tableau[i].get(tableau[i].size()-1))) {
					while(tableauToFoundation());
					deckToFoundation();
				}
				if (checkCardsAbove(i).size() > 0) {
					Card a = checkCardsAbove(i).get(0);
					for (int j = 0; j < 7; j++) {
						if (!tableau[j].isEmpty()) {
							Card b = tableau[j].get(tableau[j].size()-1);
							if (j != i) {
								if (b.getRank() == a.getRank()+1 && !(b.getColor().equals(a.getColor()))) {
									tableauToTableau();
									while(tableauToFoundation());
								}
							}
						}
					}
				}
				deckToTableau();
				deckToFoundation();
			
			}
		}
		
		
	}
	
	
	/**
	 * 
	 * updates console of what is happening during the game
	 * 
	 */
	public void gameWatch() {
		for (int i = 0; i < 7; i++) {
			System.out.print("|T" + i +"|");
			ArrayList<Card> a = tableau[i];
			if ((tableau[i].size() >= 0)) {
				for (int j = tableau[i].size()-1; j >= 0; j--) {
					Card b = (Card) a.get(j);
					System.out.print(" " + b.getRank() + b.getSuit() + b.getHidden());
				}
				 System.out.println(" C"+ tableau[i].size() + " ");
			}
		}
		System.out.println();
	}
	
	/**
	 * Moves a card from the deck to the tableau
	 */
	public boolean deckToTableau() {
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
						return true;
					}
				}
				if (tableau[i].size() == 0 && DCard.getRank() == 13) {
					tableau[i].add(DCard);
					deck.removeFromDiscard(DCard);
					moves++;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Moves a card from one of the tableaus to one of the other 
	 * tableaus.
	 */
	public void tableauToTableau() {
		for (int i = 0; i < 7; i++) {
			
		}
		ArrayList<Card> t0 = checkCardsAbove(0);
		ArrayList<Card> t1 = checkCardsAbove(1);
		ArrayList<Card> t2 = checkCardsAbove(2);
		ArrayList<Card> t3 = checkCardsAbove(3);
		ArrayList<Card> t4 = checkCardsAbove(4);
		ArrayList<Card> t5 = checkCardsAbove(5);
		ArrayList<Card> t6 = checkCardsAbove(6);
		ArrayList<Card> bottomCards = new ArrayList<Card>();
		for (int i =0; i < 7; i++) {
			if (!tableau[i].isEmpty()){
				if (tableau[i].size() >= 1) {
					bottomCards.add(tableau[i].get(tableau[i].size() - 1));
				}
			}
		}
		
		for (int i = 0; i < bottomCards.size(); i++) {
			for (int j = 0; j < bottomCards.size(); j++) {
				if (!tableau[j].isEmpty()) {
				if (i != j) {
					Card first = (Card) bottomCards.get(i);
					Card second;
					if (j == 0) {
						if (t0.size() <=0) {
							second = new Card(100, "Hearts", 1);
						} else {
						 second = (Card) t0.get(t0.size()-1);
						}
					} else if (j == 1) {
						if (t1.size() <=0) {
							second = new Card(100, "Hearts", 1);
						} else {
						 second = (Card) t1.get(t1.size()-1);
						}
					} else if (j == 2) {
						if (t2.size() <=0) {
							second = new Card(100, "Hearts", 1);
						} else {
						 second = (Card) t2.get(t2.size()-1);
						}
					} else if (j == 3) {
						if (t3.size() <=0) {
							second = new Card(100, "Hearts", 1);
						} else {
						 second = (Card) t3.get(t3.size()-1);
						}
					} else if (j == 4) {
						if (t4.size() <=0) {
							second = new Card(100, "Hearts", 1);
						} else {
						 second = (Card) t4.get(t4.size()-1);
						}
					} else if (j == 5) {
						if (t5.size() <=0) {
							second = new Card(100, "Hearts", 1);
						} else {
						 second = (Card) t5.get(t5.size()-1);
						}
					} else {
						if (t6.size() <=0) {
							second = new Card(100, "Hearts", 1);
						} else {
						 second = (Card) t6.get(t6.size()-1);
						}
					}
					//King movement
					if(second.getRank() == 13 && tableau[i].size() == 0){
						if (j == 0) {
							for (int m = t0.size()-1; m >= 0; m--) {
								tableau[i].add(t0.get(m));
								tableau[j].remove(t0.get(m));
							}
						} else if (j == 1) {
							for (int m = t1.size()-1; m >= 0; m--) {
								tableau[i].add(t1.get(m));
								tableau[j].remove(t1.get(m));
							}
						} else if (j == 2) {
							for (int m = t2.size()-1; m >= 0; m--) {
								tableau[i].add(t2.get(m));
								tableau[j].remove(t2.get(m));
							}
						} else if (j == 3) {
							for (int m = t3.size()-1; m >= 0; m--) {
								tableau[i].add(t3.get(m));
								tableau[j].remove(t3.get(m));
							}
						} else if (j == 4) {
							for (int m = t4.size()-1; m >= 0; m--) {
								tableau[i].add(t4.get(m));
								tableau[j].remove(t4.get(m));
							}
						} else if (j == 5) {
							for (int m = t5.size()-1; m >= 0; m--) {
								tableau[i].add(t5.get(m));
								tableau[j].remove(t5.get(m));
							}
						} else {
							for (int m = t6.size()-1; m >= 0; m--) {
								tableau[i].add(t6.get(m));
								tableau[j].remove(t6.get(m));
							}
						}
						if (!tableau[j].isEmpty()) {
							Card b = tableau[j].get((tableau[j].size()-1));
							b.makeVisible();
						}
						return;
					}
					if (!(first.getColor().equals(second.getColor())) && first.getRank() == second.getRank()+1
							&& hasHidden(i)) {
						if (tableau[i].size() > 0 && tableau[j].size() >0) {
							if (j == 0) {
								for (int m = t0.size()-1; m >= 0; m--) {
									tableau[i].add(t0.get(m));
								}
								tableau[j].removeAll(t0);
							} else if (j == 1) {
								for (int m = t1.size()-1; m >= 0; m--) {
									tableau[i].add(t1.get(m));
								}
								tableau[j].removeAll(t1);
							} else if (j == 2) {
								for (int m = t2.size()-1; m >= 0; m--) {
									tableau[i].add(t2.get(m));
								}
								tableau[j].removeAll(t2);
							} else if (j == 3) {
								for (int m = t3.size()-1; m >= 0; m--) {
									tableau[i].add(t3.get(m));
								}
								tableau[j].removeAll(t3);
							} else if (j == 4) {
								for (int m = t4.size()-1; m >= 0; m--) {
									tableau[i].add(t4.get(m));
								}
								tableau[j].removeAll(t4);
							} else if (j == 5) {
								for (int m = t5.size()-1; m >= 0; m--) {
									tableau[i].add(t5.get(m));
								}
								tableau[j].removeAll(t5);
							} else {
								for (int m = t6.size()-1; m >= 0; m--) {
									tableau[i].add(t6.get(m));
								}
								tableau[j].removeAll(t6);
							}
							if (!tableau[j].isEmpty()) {
								Card b = tableau[j].get((tableau[j].size()-1));
								b.makeVisible();
							}
							return;
						}
					}
					
				} 
			}
			}
		}
		t0.clear();
		t1.clear();
		t2.clear();
		t3.clear();
		t4.clear();
		t5.clear();
		t6.clear();
	}
	

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
					return deckToFoundation();
				}
				if (suitD == "Diamonds") {
					this.foundationDiamond.add(discard);
					return deckToFoundation();
				}
				if (suitD == "Clubs") {
					this.foundationClub.add(discard);
					return deckToFoundation();
				}
				if (suitD == "Spades") {
					this.foundationSpade.add(discard);
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
				String suit  = card.getSuit();
				if (canPutFoundation(card)) {
					if (suit == "Hearts") {
						this.foundationHeart.add(tableau[i].remove(tableau[i].size()- 1));
						if (!tableau[i].isEmpty()) {
							Card b = tableau[i].get((tableau[i].size()-1));
							b.makeVisible();
						}
						return true;
					}
					if (suit == "Diamonds") {
						this.foundationDiamond.add(tableau[i].remove(tableau[i].size()- 1));
						if (!tableau[i].isEmpty()) {
							Card b = tableau[i].get((tableau[i].size()-1));
							b.makeVisible();
						}
						return true;
					}
					if (suit == "Clubs") {
						this.foundationClub.add(tableau[i].remove(tableau[i].size()- 1));
						if (!tableau[i].isEmpty()) {
							Card b = tableau[i].get((tableau[i].size()-1));
							b.makeVisible();
						}
						return true;
					}
					if (suit == "Spades") {
						this.foundationSpade.add(tableau[i].remove(tableau[i].size()- 1));
						if (!tableau[i].isEmpty()) {
							Card b = tableau[i].get((tableau[i].size()-1));
							b.makeVisible();
						}
						return true;
					}
					
				}
			}
		}
		return false;
	}
		
	public boolean hasHidden(int i) {
		if (!tableau[i].isEmpty()) {
		if (tableau[i].get(0).getHidden() == 1) {
			return true;
		}
		for (int j = 0; j < tableau[i].size()-1; j++) {
			if (tableau[i].get(j).getHidden() == 0) {
				return true;
			}
		}
		
	}
		return false;
	}
	
	
	/**
	 * 
	 * Checking if the card can be placed in the foundation
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
		if (!tableau[i].isEmpty()) {
			Card card = tableau[i].get(tableau[i].size() - 1);
			holdArray.add(card);
			if (tableau[i].size() > 1) {
				for(int j = tableau[i].size()-1; j > 0; j--) {
					card = tableau[i].get(j);
					Card cardAbove = tableau[i].get(j-1);
					if(card.getHidden() == 1 && cardAbove.getHidden() == 1) {
						if(!card.getColor().equals(cardAbove.getColor()) && cardAbove.getRank() == card.getRank() + 1) {
							holdArray.add(cardAbove);
						}
					}
				}
			}
		}

		
		return holdArray;
	}
	
	

}
