package connect4;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class CompositeBoardTest {
    private static int size = 650;
    private static int offset = 10;
    private static int ovalSize = size/7 - offset*2;
    private static int pos = offset/2;
    private static int incr = size/7;
    private static JFrame CompositeBoardTest;
    //private static JPanel Board;
    private static JMenuBar menuBar;
    private static JMenuItem saveItem;
    private static JMenuItem loadItem;
    private static JMenuItem aboutItem;
    private static JMenuItem exitItem;
    

    public static void main( String[] args ) throws Exception {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() { new CompositeBoardTest(); }
            
        } );
    }
//
    public CompositeBoardTest() {
        //super( "CompositeBoardTest" );
    	CompositeBoardTest = new JFrame();
        CompositeBoardTest.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\matti\\git\\Connect4\\Connect4\\img\\38753106 (1).jpg"));
        CompositeBoardTest.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        Board board = new Board();
        CompositeBoardTest.getContentPane().add( board );
//<<<<<<< HEAD
        board.setLayout(null);
        CompositeBoardTest.setSize( size-90, size+34 );
//=======
        CompositeBoardTest.setSize( 560, 706 );
//>>>>>>> branch 'main' of https://github.com/MattiaGio/Connect4.git
        CompositeBoardTest.setVisible( true );
        CompositeBoardTest.setResizable(false);
        CompositeBoardTest.setLocationRelativeTo( null );
        CompositeBoardTest.setJMenuBar(menuBar);
        
    }


	static class Board extends JPanel implements ActionListener {
        protected int[][] pieces = new int[7][6];
        protected Piece addingPiece = null;
        protected Timer pieceDropped = null;

        public Board() {
            setPreferredSize( new Dimension( size, size ) );
            setBounds( 0, 0, size, size );
            pieceDropped = new Timer( 2, this );
            
            addMouseListener( new MouseAdapter() {
                public void mousePressed( MouseEvent e ) {
                    int column = ( e.getPoint().x-pos )/incr;
                    addPiece( column );
                   
                }

            });
            
            menuBar = new JMenuBar();
    		menuBar.setBackground(SystemColor.menu);
    		menuBar.setForeground(new Color(255, 255, 255));
    		JMenu gameSettings = new JMenu("Game Settings");
    		JMenu help = new JMenu("Help");
    		
    		loadItem = new JMenuItem("Load");
    		saveItem = new JMenuItem("Save");
    		exitItem = new JMenuItem("Exit");
    		
    		aboutItem = new JMenuItem("About");
    		
    
    		menuBar.add(gameSettings);
    		menuBar.add(help);
    		gameSettings.add(loadItem);
    		gameSettings.add(saveItem);
    		gameSettings.add(exitItem);
    		help.add(aboutItem);
    		
    		loadItem.addActionListener(this);
    		saveItem.addActionListener(this);
    		exitItem.addActionListener(this);
    		aboutItem.addActionListener(this);
    		//AGGIUNGERE SALVATAGGIO E CARICAMENTO
        }

        protected void paintComponent( Graphics g ) {
            super.paintComponent( g );

            Graphics2D g2d = (Graphics2D) g;
            Composite comp = g2d.getComposite();

            Dimension d = getSize();
            int w = d.width;
            int h = d.height;

            BufferedImage buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = buffImg.createGraphics();

            // Clear area
            g2d.setColor( Color.WHITE );//CAMBIA IL COLORE DELLO SFONDO
            g2d.fillRect( 0, 0, w, h );

            // Draw screen
            //gbi.setColor( Color.YELLOW );
            gbi.setColor( Color.BLUE ); //CAMBIA IL COLORE DELLA GRIGLIA
            gbi.fillRect( 0, 0, w, h );

            // Draw pieces or holes
            gbi.setColor( Color.RED ); //CAMBIA IL COLORE DEL DISCHETTO
            for ( int row = 0 ; row < 7 ; row++ ) {
                for ( int column = 0 ; column < 6 ; column++ ) {
                	//DISCS COLOR
                    if ( pieces[row][column] == 1 ) {
                        gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER, .999f ) );
                    } else {//FILLS THE WHITE HOLES
                        gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.CLEAR, 0.5f ) );
                    }
                    gbi.fillOval( incr*column+pos, incr*row+pos, ovalSize, ovalSize );
                }
            }

            //ANIMATION OF THE FALLING PIECE
            if ( addingPiece != null ) {
                gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.DST_OVER, 1.0f ) );
                gbi.fillOval( addingPiece.x, addingPiece.y, ovalSize, ovalSize );
            }

            // Draws the buffered image.
            g2d.drawImage(buffImg, null, 0, 0);

//          g2d.setComposite( comp );
        }

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
                    JOptionPane.showMessageDialog(null, "FULL COLUMN", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
//commento di prova
        public void actionPerformed( ActionEvent e ) {
        	if(e.getSource()==aboutItem) {
    			JOptionPane.showMessageDialog(null, "Connect4 Game: v.1.0 \nMade by: JvckDL & MattiaGio", "About", JOptionPane.INFORMATION_MESSAGE);
    		}
        	if(e.getSource()==exitItem) {
    			JOptionPane.showOptionDialog(CompositeBoardTest, "You will exit the game without saving\nDo you want to continue?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
    			CompositeBoardTest.dispose();
        	}
            if ( addingPiece != null ) {
                addingPiece.y += 5;
                int row = ( addingPiece.y - pos )/incr + 1;
                if ( row > 6 || pieces[row][addingPiece.column] == 1 ) {
                    pieces[row-1][addingPiece.column] = 1;
                    addingPiece = null;
                    pieceDropped.stop();
                }
            }
            repaint();
        }
    }

    public static class Piece {
        public int row, column, x, y;
    }
    
}