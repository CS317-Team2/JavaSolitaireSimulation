import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		board.setUp();

	
		String results = board.solve();
		System.out.println(results);
		}

}
