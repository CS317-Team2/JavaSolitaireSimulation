
/**
 * 
 * The Card class to create the cards for solitaire.
 * 
 * @author pengs
 *
 */
public class Card {

	// A, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
	private int rank;
	
	// Heart, Spade, Diamond, and Club
	private String suit;
	
	//0 means not visible to person, 1 means visible
	private int hidden;
	
	/**
	 * 
	 * Initiation of the card
	 * 												11		
	 * @param rank A, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
	 * @param suit Heart, Spade, Diamond, and Club
	 * @param hidden 0 means not visible to person, 1 means visible
	 */
	public Card(int rank, String suit, int hidden) {
		this.rank = rank;
		this.suit = suit;
		this.hidden = hidden;
	}

	/**
	 * 
	 * Gets the rank
	 * 
	 * @return the rank
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * 
	 * FInds out if the card is hidden
	 * 
	 * @return if the card is hidden
	 */
	public int getHidden() {
		return this.hidden;
	}

	/**
	 * 
	 * Hide the card
	 * 
	 */
	public void hide() {
		this.hidden = 0;
	}
	
	/**
	 * 
	 * Making the card visible
	 * 
	 */
	public void makeVisible() {
		this.hidden = 1;
	}
	
	/**
	 * 
	 * Gets the suit
	 * 
	 * @return the suit
	 */
	public String getSuit() {
		return this.suit;
	}
	
	/**
	 * 
	 * Get the color
	 * 
	 * @return the color
	 */
	public String getColor() {
		
		// Check if the card is Black (Clubs and Spades) or Red (Diamonds and Hearts)
		if (this.getSuit().equals("Hearts") || this.getSuit().equals("Diamonds")) {
			return "Red";
		}
		else {
			return "Black";
		}
	}
	
	

}
