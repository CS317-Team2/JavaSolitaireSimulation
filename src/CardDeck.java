import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	private ArrayList<Card> playingDeck;
	private ArrayList<Card> discardDeck;
	private final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};
	
	public CardDeck() {
		this.playingDeck = new ArrayList<Card>();
		this.discardDeck = new ArrayList<Card>();
		for (int i = 0; i < SUITS.length; i++) {
			for (int j = 1; j < 14; j++) {
				Card card = new Card(j, SUITS[i]);
				this.playingDeck.add(card);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.getPlayingDeck());
	}
	
	public Card drawCard() {
		return this.playingDeck.get(0);
	}
	
	public int getCardsLeft() {
		return this.playingDeck.size();
	}
	
	public void discard() {
		Card card = this.playingDeck.remove(0);
		this.discardDeck.add(card);
	}
	
	public void reset() {
		int size = this.discardDeck.size();
		for (int i = 0; i < size; i++) {
			Card card = this.discardDeck.remove(0);
			this.playingDeck.add(card);
		}
	}
	
	public ArrayList<Card> getPlayingDeck(){
		return this.playingDeck;
	}
	
	public ArrayList<Card> getDiscardDeck(){
		return this.discardDeck;
	}
}
