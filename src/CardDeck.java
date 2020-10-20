// Import Array List
import java.util.ArrayList;

// Import Collections
import java.util.Collections;

/**
 * 
 * The Card Deck for solitaire
 * 
 * @author pengs
 *
 */
public class CardDeck {

	private ArrayList<Card> playingDeck;
	private ArrayList<Card> discardDeck;
	private final String[] SUITS = {"Clubs", "Spades", "Hearts", "Diamonds"};
	private int circulation;
	
	
	// normal deck
	public CardDeck() {
		this.circulation = 0;
		this.playingDeck = new ArrayList<Card>();
		this.discardDeck = new ArrayList<Card>();
		for (int i = 0; i < SUITS.length; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card(j, SUITS[i], 1);
				this.playingDeck.add(card);
			}
		}
	}
	 
	
	
	
	/**
	 * 
	 * Card deck method. The deck that wins every time
	 * 
	 */
//	public CardDeck() {
//		this.circulation = 0;
//		this.playingDeck = new ArrayList<Card>();
//		this.discardDeck = new ArrayList<Card>();
//		this.playingDeck.add(new Card(1, "Clubs", 1));
//		this.playingDeck.add(new Card(3, "Clubs", 1));
//		this.playingDeck.add(new Card(2, "Clubs", 1));
//		this.playingDeck.add(new Card(6, "Clubs", 1));
//		this.playingDeck.add(new Card(5, "Clubs", 1));
//		this.playingDeck.add(new Card(4, "Clubs", 1));
//		this.playingDeck.add(new Card(10, "Clubs", 1));
//		this.playingDeck.add(new Card(9, "Clubs", 1));
//		this.playingDeck.add(new Card(8, "Clubs", 1));
//		this.playingDeck.add(new Card(7, "Clubs", 1));
//		this.playingDeck.add(new Card(14, "Clubs", 1));
//		this.playingDeck.add(new Card(13, "Clubs", 1));
//		this.playingDeck.add(new Card(12, "Clubs", 1));
//		this.playingDeck.add(new Card(11, "Clubs", 1));
//		this.playingDeck.add(new Card(1, "Spades", 1));
//		this.playingDeck.add(new Card(7, "Spades", 1));
//		this.playingDeck.add(new Card(6, "Spades", 1));
//		this.playingDeck.add(new Card(5, "Spades", 1));
//		this.playingDeck.add(new Card(4, "Spades", 1));
//		this.playingDeck.add(new Card(3, "Spades", 1));
//		this.playingDeck.add(new Card(2, "Spades", 1));
//		this.playingDeck.add(new Card(13, "Spades", 1));
//		this.playingDeck.add(new Card(12, "Spades", 1));
//		this.playingDeck.add(new Card(11, "Spades", 1));
//		this.playingDeck.add(new Card(10, "Spades", 1));
//		this.playingDeck.add(new Card(9, "Spades", 1));
//		this.playingDeck.add(new Card(8, "Spades", 1));
//		for (int j = 1; j < 14; j++) {
//			Card card = new Card(j,"Hearts", 1);
//			this.playingDeck.add(card);
//		}
//		for (int j = 1; j < 14; j++) {
//			Card card = new Card(j,"Diamonds", 1);
//			this.playingDeck.add(card);
//		}
//	}
	
	//deck that looses every time
//	public CardDeck() {
//		this.circulation = 0;
//		this.playingDeck = new ArrayList<Card>();
//		this.discardDeck = new ArrayList<Card>();
//		for (int i = 0; i < SUITS.length; i++) {
//			for (int j = 1; j <= 12; j++) {
//				Card card = new Card(j, SUITS[i], 1);
//				this.playingDeck.add(card);
//			}
//		}
//	}
	
	/**
	 * 
	 * Shuffles the deck
	 * 
	 */
	public void shuffle() {
		Collections.shuffle(this.getPlayingDeck());
	}
	
	public void removeFromDiscard(Card a) {
		this.discardDeck.remove(a);
	}
	
	/**
	 * 
	 * Draws a card from the card deck.
	 * 
	 * @return a card from the deck which is called from the array list playingDeck
	 */
	public Card drawCard() {
		return this.playingDeck.remove(0);
	}
	
	/**
	 * 
	 * Discards the card that has been played
	 * 
	 * @return the discarded card
	 */
	public Card discardCard() {
		return this.discardDeck.get(discardDeck.size()-1);
	}
	
	/**
	 * 
	 * Adds a card to the discarded pile
	 * 
	 * @param a the card that is being discarded
	 */
	public void addToDiscardPile(Card a) {
		this.discardDeck.add(a);
		this.playingDeck.remove(a);
	}
	
	/**
	 * 
	 * Get how many cards are lefted in the deck
	 * 
	 * @return how many cards are left in the deck
	 */
	public int getCardsLeft() {
		return this.playingDeck.size();
	}
	
	/**
	 * 
	 * Discards a card
	 * 
	 * @param card the card that is being discarded
	 */
	public void discard(Card card) {
		this.discardDeck.add(card);
	}
	
	/**
	 * 
	 * Resets the card deck
	 * 
	 */
	public void reset() {
		int size = this.discardDeck.size();
		for (int i = 0; i < size; i++) {
			Card card = this.discardDeck.remove(0);
			this.playingDeck.add(card);
		}
		circulation+=1;
	}
	
	/**
	 * 
	 * Gets the playing deck
	 * 
	 * @return the playing deck
	 */
	public ArrayList<Card> getPlayingDeck(){
		return this.playingDeck;
	}
	
	/**
	 * 
	 * Gets the discarded pile
	 * 
	 * @return the discarded pile
	 */
	public ArrayList<Card> getDiscardDeck(){
		return this.discardDeck;
	}
	
	/**
	 * 
	 * Gets the circulation
	 * 
	 * @return the circulation
	 */
	public int getCirculation() {
		return this.circulation;
	}
}
