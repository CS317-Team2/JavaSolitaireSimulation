public class Card {

	private int rank;
	private String suit;
	
	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return this.rank;
	}

	public String getSuit() {
		return this.suit;
	}
	
	public String getColor() {
		if (this.getSuit().equals("Hearts") || this.getSuit().equals("Diamonds")) {
			return "Red";
		}
		else {
			return "Black";
		}
	}
	
	

}
