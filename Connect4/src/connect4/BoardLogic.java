package connect4;

import javax.swing.JOptionPane;

public class BoardLogic {
	
	private static int rows;
	private static int columns;
	
	Pieces [][]grid;
	
	public BoardLogic(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		grid = new Pieces[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j< columns; j++) {
				grid[i][j] = null;
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Pieces[][] getBoard() {
		return grid;
	}
	
	public int addPiece(int colToAdd, String color) {
		
		if(colToAdd >= 0 && colToAdd < columns) {
			//we can add
			if(grid[0][colToAdd] == null) {
				boolean addedThePiece = false;
				int addedRow = -1;
				for(int row = rows - 1; row >= 0; row--)
					if(grid[row][colToAdd] == null) {
						grid[row][colToAdd] = new Pieces();
						//qui sto settando a 1 solo colore potrebbe non funzionare
						grid[row][colToAdd].setColor(color);
						addedThePiece = true;
						addedRow = row;
						break;
					}
				return addedRow;
			}else {
				//error
				return -1;
			}
		}else {
			return -1;
		}
	}
}
