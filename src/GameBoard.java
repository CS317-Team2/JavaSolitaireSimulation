import java.util.ArrayList;

public class GameBoard {
	
	private ArrayList<Card> spadeFoundation, clubFoundation, heartFoundation, diamondFoundation;
	private ArrayList<Card> tableau1, tableau2, tableau3, tableau4, tableau5, tableau6, tableau7;
	private ArrayList<Card> deck;
	
	public GameBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public void setUp(CardDeck a) {
		a.shuffle();
		tableau1.add(a.drawCard());
		
		tableau2.add(a.drawCard());
		tableau2.add(a.drawCard());
		
		tableau3.add(a.drawCard());
		tableau3.add(a.drawCard());
		tableau3.add(a.drawCard());
		
		tableau4.add(a.drawCard());
		tableau4.add(a.drawCard());
		tableau4.add(a.drawCard());
		tableau4.add(a.drawCard());
		
		tableau5.add(a.drawCard());
		tableau5.add(a.drawCard());
		tableau5.add(a.drawCard());
		tableau5.add(a.drawCard());
		tableau5.add(a.drawCard());
		
		tableau6.add(a.drawCard());
		tableau6.add(a.drawCard());
		tableau6.add(a.drawCard());
		tableau6.add(a.drawCard());
		tableau6.add(a.drawCard());
		tableau6.add(a.drawCard());
		
		tableau7.add(a.drawCard());
		tableau7.add(a.drawCard());
		tableau7.add(a.drawCard());
		tableau7.add(a.drawCard());
		tableau7.add(a.drawCard());
		tableau7.add(a.drawCard());
		tableau7.add(a.drawCard());
		
		deck = a.getPlayingDeck();
		
	}
	
	///IMPLEMENT RULES HERE
	
}
