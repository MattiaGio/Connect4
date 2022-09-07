package connect4;

public interface boardInterface {
	static int size = 650;
    static int offset = 10;
    static int ovalSize = size/7 - offset*2;
    static int pos = offset/2;
    static int incr = size/7;
	int[][] pieces = new int[7][6];
	
	public static class Piece {
        public int row, column, x, y;
    }
}
