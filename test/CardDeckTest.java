import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class CardDeckTest {

	@Test
	//Tests creating a deck and getter methods in card class
	void createDeckTest() {
		CardDeck deck = new CardDeck();
		//deck should be 52 cards
		Assert.assertTrue(deck.getCardsLeft() == 52);
		Card firstCard = deck.drawCard();
		Card lastCard = deck.getPlayingDeck().get(51);
		//FirstCard is Ace of spades
		Assert.assertTrue(firstCard.getRank() == 1);
		Assert.assertTrue(firstCard.getSuit().equals("Spades"));
		Assert.assertTrue(firstCard.getColor().equals("Black"));
		//Last Card is a King(13) of diamonds
		Assert.assertTrue(lastCard.getRank() == 13);
		Assert.assertTrue(lastCard.getSuit().equals("Diamonds"));
		Assert.assertTrue(lastCard.getColor().equals("Red"));
	}
	
	@Test
	//Tests the discard and reset method
	void discardTest() {
		CardDeck deck = new CardDeck();
		//discard first card - cards left should be 51
		deck.discard();
		Assert.assertTrue(deck.getCardsLeft() == 51);
		//discard first card - cards left should be 50
		deck.discard();
		Assert.assertTrue(deck.getCardsLeft() == 50);
		//reset the deck - two cards added to the end of the array
		deck.reset();
		Assert.assertTrue(deck.getCardsLeft() == 52);
	}
	
	@Test
	//Tests the shuffle method to see if ArrayList elements are shuffled randomly
	void shuffleTest() {
		CardDeck deck = new CardDeck();
		//shuffle deck
		deck.shuffle();
		//deck still 52 cards
		Assert.assertTrue(deck.getCardsLeft() == 52);
		//make new non-shuffled deck
		CardDeck deck2 = new CardDeck();
		//Two decks shouldn't be equal
		Assert.assertFalse(deck.equals(deck2));
	}
	
	@Test
	//Tests a full reset with a non-shuffled deck
	void fullResetTest() {
		CardDeck deck = new CardDeck();
		//discard every card
		for (int i = 0; i < 52; i++) {
			deck.discard();
		}
		//no cards are left
		Assert.assertTrue(deck.getCardsLeft() == 0);
		//reset the deck - all cards should be back in order
		deck.reset();
		Assert.assertTrue(deck.getCardsLeft() == 52);
		Card firstCard = deck.drawCard();
		//FirstCard is still Ace of spades
		Assert.assertTrue(firstCard.getRank() == 1);
		Assert.assertTrue(firstCard.getSuit().equals("Spades"));
		Assert.assertTrue(firstCard.getColor().equals("Black"));
	}
	
	@Test 
	//Tests a full reset with a shuffled deck
	void shuffleResetTest(){
		CardDeck deck = new CardDeck();
		deck.shuffle();
		//get attributes of first card after shuffle
		int rank = deck.drawCard().getRank();
		String suit = deck.drawCard().getSuit();
		String color = deck.drawCard().getColor();
		//discard every card
		for (int i = 0; i < 52; i++) {
			deck.discard();
		}
		Assert.assertTrue(deck.getCardsLeft() == 0);
		//reset the deck in order
		deck.reset();
		Assert.assertTrue(deck.getCardsLeft() == 52);
		Card firstCard = deck.drawCard();
		//First card should still be the same after reset
		Assert.assertTrue(firstCard.getRank() == rank);
		Assert.assertTrue(firstCard.getSuit().equals(suit));
		Assert.assertTrue(firstCard.getColor().equals(color));
		
	}

}
