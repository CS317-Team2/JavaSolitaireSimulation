import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	private ArrayList<Card> playingDeck;
	private ArrayList<Card> discardDeck;
	private final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};
	private int circulation;
	
	public CardDeck() {
		this.circulation = 0;
		this.playingDeck = new ArrayList<Card>();
		this.discardDeck = new ArrayList<Card>();
		for (int i = 0; i < SUITS.length; i++) {
			for (int j = 1; j < 14; j++) {
				Card card = new Card(j, SUITS[i], 1);
				this.playingDeck.add(card);
			}
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
