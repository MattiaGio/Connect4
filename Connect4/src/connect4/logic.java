package connect4;

import javax.swing.JOptionPane;

import connect4.CompositeBoardTest.Piece;

public class logic {

	protected Piece addingPiece;
	
	
	public void addPiece( int column ) {
        if ( addingPiece == null ) {
            if ( pieces[0][column] == 0 ) {
                addingPiece = new Piece();
                addingPiece.row = 0;
                addingPiece.column = column;
                addingPiece.x = incr*column+pos;
                addingPiece.y = 0;
                pieceDropped.start();
            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "COLONNA PIENA");
            }
        }
    }
}
