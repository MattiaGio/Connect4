package connect4;

import javax.swing.JOptionPane;

import connect4.CompositeBoardTest.Piece;

public class Logic {

	protected String player1;
	protected String player2;
	protected String color1 = "RED";
	protected String color2 = "YELLOW";
	
	protected BoardLogic board;
	
	protected boolean player1Turn = true;
	
	public boolean player1Turn() {
		return player1Turn;
	}
	
	public Logic() {
		this.player1 = StartingWindow.NamePla1;
		this.player2 = StartingWindow.NamePla2;
	}
	
	
	public boolean round(int col) {
		//String color = is1Playing ? color1 : color2;
		boolean success = false;
		
		String color = player1Turn ? color1 : color2;
		
		success = board.addPiece(col, color);
		
		
		if(row != -1) player1Turn = !player1Turn;
		
		return row;
	}
	
	public boolean checkForWinnerInGUI(int column) {
        String winningPlayer;

        // inversion because of late information
        if(!player1Turn) {
            winningPlayer = player1;
        } else {
            winningPlayer = player2;
        }

        return checkForWinner(column, winningPlayer);
    }
	
	
	public boolean checkForWinner(int col, String winningPlayer) {
        int rows = board.getRows();
        int columns = board.getColumns();
        Pieces[][] Board = board.getBoard();

        for(int row = 0; row < rows; row++) {
            if(Board[row][col] != null) {
                // if this reaches 0, we have won
                int winningStreak = 3;

                // check downwards
                for(int winRow = row + 1; winRow < rows; winRow++) {
                	//ho messo color 1 ma deve essere specificato
                    if(Board[winRow][col].getColor1().equals(winningPlayer)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 3;
                }

                winningStreak = 4;
                // look at the horizontal
                for(int winCol = col - 3; winCol <= col + 3; winCol++) {
                    if(winCol < 0) continue;
                    if(winCol >= columns) break;

                    if(Board[row][winCol] != null && Board[row][winCol].getColor2().equals(winningPlayer)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 4;
                }

                if(checkDiagonal(row, col, winningPlayer, false)) return true;
                if(checkDiagonal(row, col, winningPlayer, true)) return true;

                return false;
            }
        }
        return false;
    }
	
	
	private boolean checkDiagonal(int row, int col, String winningPlayer, boolean rightDiagonal) {
        int winningStreak = 4;
        int reverser = rightDiagonal ? 1 : -1;
        int rows = board.getRows();
        int columns = board.getColumns();
        Pieces[][] Board = board.getBoard();

        for(int winRow = row - 3, winPla = col - (3 * reverser); winRow <= row + 3; winRow++, winPla += reverser) {
            if (!rightDiagonal) {
                if (winRow < 0 || winPla < 0) continue;
                if (winRow >= rows || winPla >= columns) break;
            } else {
                if(winRow < 0 || winPla >= columns) continue;
                if(winRow >= rows || winPla < 0) break;
            }

            //attenzione ai colori anche qua
            if(Board[winRow][winPla] != null && Board[winRow][winPla].getColor1().equals(winningPlayer)) {
                if (--winningStreak == 0) return true;
            } else winningStreak = 4;
        }
        return false;
    }

	public void reset(int rows, int columns) {
		// TODO Auto-generated method stub
		this.board = new BoardLogic(rows, columns);
		player1Turn = true;
		
	}
	
}