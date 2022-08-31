package connect4;

public class Players {
	protected static final char[] PLAYERS = {'R', 'Y'};
	
	protected static int turn = 0;

	public static int getTurn() {
		return turn;
		
	}
	
	public static void setTurn() {
		turn = turn + 1;
	}
	
	public static void decrementTurn() {
		turn = turn - 1;
	}
}
