package connect4;

public class Pieces {
	
	protected static Logic logic = new Logic();
	protected boolean player1Turn = logic.player1Turn;
	private static String color1 = "RED";
	private static String color2 ="YELLOW";
	
	public String getColor() {
		if(player1Turn == false) {
			return color2;
		}else {
			return color1;
		}
	}
	
	public void setColor(String color) {
		if(player1Turn == false) {
			color = this.color2;
		}else {
			color = this.color1;
		}
	}
	
}