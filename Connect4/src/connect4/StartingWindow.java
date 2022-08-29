package connect4;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;



public class StartingWindow implements ActionListener{

	private JFrame frmConnect;
	private JTextField NamePlayer1;
	private JTextField NamePlayer2;
	private JButton StartGameBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingWindow window = new StartingWindow();
					window.frmConnect.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnect = new JFrame();
		frmConnect.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\matti\\git\\Connect4\\Connect4\\img\\hggfhhgfgfh.jpg"));
		frmConnect.setTitle("Connect4");
		frmConnect.setBounds(100, 100, 615, 508);
		frmConnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnect.getContentPane().setLayout(null);
		
		StartGameBtn = new JButton("New Game");
		StartGameBtn.setBounds(238, 413, 122, 45);
		frmConnect.getContentPane().add(StartGameBtn);
		StartGameBtn.setFocusable(false);
		StartGameBtn.addActionListener(this);
		
		NamePlayer1 = new JTextField();
		NamePlayer1.setBounds(263, 196, 139, 20);
		frmConnect.getContentPane().add(NamePlayer1);
		NamePlayer1.setColumns(10);
		
		NamePlayer2 = new JTextField();
		NamePlayer2.setColumns(10);
		NamePlayer2.setBounds(263, 239, 139, 20);
		frmConnect.getContentPane().add(NamePlayer2);
		
		JLabel Player1Label = new JLabel("Player 1:");
		Player1Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Player1Label.setBackground(new Color(255, 0, 255));
		Player1Label.setForeground(new Color(0, 0, 255));
		Player1Label.setBounds(194, 202, 59, 14);
		frmConnect.getContentPane().add(Player1Label);
		
		JLabel Player2Label = new JLabel("Player 2:");
		Player2Label.setForeground(new Color(0, 255, 0));
		Player2Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Player2Label.setBounds(194, 241, 59, 14);
		frmConnect.getContentPane().add(Player2Label);
		
		JLabel BackgroundLabel = new JLabel("New label");
		BackgroundLabel.setIcon(new ImageIcon("C:\\Users\\matti\\git\\Connect4\\Connect4\\img\\hggfhhgfgfh.jpg"));
		BackgroundLabel.setBounds(0, 0, 599, 469);
		frmConnect.getContentPane().add(BackgroundLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		frmConnect.dispose();
		
		if(e.getSource()==StartGameBtn) {
			
			CompositeBoardTest myBoard = new CompositeBoardTest();
		}
		
	}
}
