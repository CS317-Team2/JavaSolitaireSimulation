public class Card {

	private int rank;
	private String suit;
	//0 means not visible to person, 1 means visible
	private int hidden;
	
	public Card(int rank, String suit, int hidden) {
		this.rank = rank;
		this.suit = suit;
		this.hidden = hidden;
	}

	public int getRank() {
		return this.rank;
	}

	public int getHidden() {
		return this.hidden;
	}

	public void hide() {
		this.hidden = 0;
	}
	
	public void makeVisible() {
		this.hidden = 1;
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
