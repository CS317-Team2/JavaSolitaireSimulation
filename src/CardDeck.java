import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	private ArrayList<Card> playingDeck;
	private ArrayList<Card> discardDeck;
	private final String[] SUITS = {"Clubs", "Spades", "Hearts", "Diamonds"};
	private int circulation;
	
	
	// normal deck
//	public CardDeck() {
//		this.circulation = 0;
//		this.playingDeck = new ArrayList<Card>();
//		this.discardDeck = new ArrayList<Card>();
//		for (int i = 0; i < SUITS.length; i++) {
//			for (int j = 1; j <= 14; j++) {
//				Card card = new Card(j, SUITS[i], 1);
//				this.playingDeck.add(card);
//			}
//		}
//	}
	 
	
	
	//deck that wins every time
	
	public CardDeck() {
		this.circulation = 0;
		this.playingDeck = new ArrayList<Card>();
		this.discardDeck = new ArrayList<Card>();
		this.playingDeck.add(new Card(1, "Clubs", 1));
		this.playingDeck.add(new Card(3, "Clubs", 1));
		this.playingDeck.add(new Card(2, "Clubs", 1));
		this.playingDeck.add(new Card(6, "Clubs", 1));
		this.playingDeck.add(new Card(5, "Clubs", 1));
		this.playingDeck.add(new Card(4, "Clubs", 1));
		this.playingDeck.add(new Card(10, "Clubs", 1));
		this.playingDeck.add(new Card(9, "Clubs", 1));
		this.playingDeck.add(new Card(8, "Clubs", 1));
		this.playingDeck.add(new Card(7, "Clubs", 1));
		this.playingDeck.add(new Card(14, "Clubs", 1));
		this.playingDeck.add(new Card(13, "Clubs", 1));
		this.playingDeck.add(new Card(12, "Clubs", 1));
		this.playingDeck.add(new Card(11, "Clubs", 1));
		this.playingDeck.add(new Card(1, "Spades", 1));
		this.playingDeck.add(new Card(7, "Spades", 1));
		this.playingDeck.add(new Card(6, "Spades", 1));
		this.playingDeck.add(new Card(5, "Spades", 1));
		this.playingDeck.add(new Card(4, "Spades", 1));
		this.playingDeck.add(new Card(3, "Spades", 1));
		this.playingDeck.add(new Card(2, "Spades", 1));
		this.playingDeck.add(new Card(14, "Spades", 1));
		this.playingDeck.add(new Card(13, "Spades", 1));
		this.playingDeck.add(new Card(12, "Spades", 1));
		this.playingDeck.add(new Card(11, "Spades", 1));
		this.playingDeck.add(new Card(10, "Spades", 1));
		this.playingDeck.add(new Card(9, "Spades", 1));
		this.playingDeck.add(new Card(8, "Spades", 1));
		for (int j = 1; j <= 14; j++) {
			Card card = new Card(j,"Hearts", 1);
			this.playingDeck.add(card);
		}
		for (int j = 1; j <= 14; j++) {
			Card card = new Card(j,"Diamonds", 1);
			this.playingDeck.add(card);
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.getPlayingDeck());
	}
	
	public Card drawCard() {
		return this.playingDeck.remove(0);
	}
	
	public int getCardsLeft() {
		return this.playingDeck.size();
	}
	
	public void discard(Card card) {
		this.discardDeck.add(card);
	}
	
	public void reset() {
		int size = this.discardDeck.size();
		for (int i = 0; i < size; i++) {
			Card card = this.discardDeck.remove(0);
			this.playingDeck.add(card);
		}
		circulation+=1;
		System.out.println("cir" + circulation);
	}
	
	public ArrayList<Card> getPlayingDeck(){
		return this.playingDeck;
	}
	
	public ArrayList<Card> getDiscardDeck(){
		return this.discardDeck;
	}
	
	public int getCirculation() {
		return this.circulation;
	}
}
