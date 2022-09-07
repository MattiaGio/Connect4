package connect4;

import java.awt.*;
import java.awt.image.BufferedImage;

//import connect4.boardInterface.Piece;
import javax.swing.JPanel;

public class CompositePanel extends JPanel implements boardInterface{
	//public static final Graphics2D gbi = null;
	Logic game = new Logic();
	Piece addingPiece = null;

	CompositePanel(){
		this.setPreferredSize(new Dimension(560, 706));
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		Composite comp = g2d.getComposite();
        
		
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;

        BufferedImage buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gbi = buffImg.createGraphics();
        
        g2d.setColor( Color.WHITE );//CAMBIA IL COLORE DELLO SFONDO
        g2d.fillRect( 0, 0, w, h );
        
        
        g2d.setColor( Color.BLUE ); //CAMBIA IL COLORE DELLA GRIGLIA
        g2d.fillRect( 0, 0, w, h );

        // Draw pieces or holes
        //gbi.setColor( Color.RED ); //CAMBIA IL COLORE DEL DISCHETTO
        gbi.setColor(Color.RED);
        for ( int row = 0 ; row < 7 ; row++ ) {
            for ( int column = 0 ; column < 6 ; column++ ) {
            	//DISCS COLOR
                if ( pieces[row][column] == 1) {
                		gbi.setComposite(AlphaComposite.getInstance( AlphaComposite.SRC_OVER, 1.0f ) );
                		//game.player1Turn = false;
                }else{//FILLS THE WHITE HOLES
                	
                    gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.CLEAR, 0.5f ) );
                }
                gbi.fillOval( incr*column+pos, incr*row+pos, ovalSize, ovalSize );
            }
        }
        
        if ( addingPiece != null ) {
			gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.DST_OVER, 1.0f ) );
			gbi.fillOval( addingPiece.x, addingPiece.y, ovalSize, ovalSize );
       
    	}
		
		g2d.drawImage(buffImg, null, 0, 0);
        
        if(game.player1Turn == true) {
			g2d.setPaint(Color.RED);
			g2d.fillRect(0, 0, 560, 50);
			g2d.setPaint(Color.black);
			g2d.setFont(new Font("Ink Free", Font.BOLD, 20));
			g2d.drawString(game.player1, 25, 270);
		}else {
			g2d.setPaint(Color.YELLOW);
			g2d.fillRect(0, 0, 560, 50);
			g2d.setPaint(Color.black);
			g2d.setFont(new Font("Ink Free", Font.BOLD, 20));
			g2d.drawString(game.player2, 25, 270);
			}
		
	}
}
