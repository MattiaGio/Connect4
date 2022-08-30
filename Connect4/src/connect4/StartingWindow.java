package connect4;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.SystemColor;



public class StartingWindow implements ActionListener{

	private JFrame frmConnect;
	private JTextField NamePlayer1;
	private JTextField NamePlayer2;
	private JButton StartGameBtn;
	private JMenuItem aboutItem;

	
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
		frmConnect.setBackground(SystemColor.text);
		frmConnect.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\matti\\git\\Connect4\\Connect4\\img\\sfondo.jpeg"));
		//frmConnect.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\paffo\\git\\Connect4\\Connect4\\img\\sfondo.jpeg"));
		frmConnect.setTitle("Connect4");
		frmConnect.setBounds(100, 100, 560, 706);
		frmConnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnect.getContentPane().setLayout(null);
		frmConnect.setLocationRelativeTo( null );
		frmConnect.setBackground(Color.YELLOW);

		
		
		JLabel Player2Label = new JLabel("Player 2:");
		Player2Label.setForeground(new Color(0, 255, 0));
		Player2Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Player2Label.setBounds(194, 241, 59, 14);
		frmConnect.getContentPane().add(Player2Label);
		
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
		

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JButton loadGameButton = new JButton("Load Game");
		loadGameButton.setBounds(297, 466, 122, 45);
		panel.add(loadGameButton);
		loadGameButton.setFocusable(false);
		
		StartGameBtn = new JButton("New Game");
		StartGameBtn.setBounds(136, 466, 122, 45);
		panel.add(StartGameBtn);
		StartGameBtn.setFocusable(false);
		StartGameBtn.addActionListener(this);
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\matti\\git\\Connect4\\Connect4\\img\\sfondo.jpeg"));
		//JLabel label = new JLabel(new ImageIcon("C:\\Users\\paffo\\git\\Connect4\\Connect4\\img\\sfondo.jpeg"));
		label.setBounds(0, 0, 544, 644);
		panel.add(label);
		panel.setBounds(0, 0, 544, 644);
		frmConnect.getContentPane().add(panel);
		
		
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setForeground(new Color(255, 255, 255));
		JMenu help = new JMenu("Help");
		aboutItem = new JMenuItem("About");
		
		menuBar.add(help);
		help.add(aboutItem);
		
		
		aboutItem.addActionListener(this);
		
		
		frmConnect.setJMenuBar(menuBar);
		
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==aboutItem) {
			JOptionPane.showMessageDialog(null, "Connect4 Game: v.1.0 \nMade by: JvckDL & MattiaGio", "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getSource()==StartGameBtn) {
			
			CompositeBoardTest myBoard = new CompositeBoardTest();
			frmConnect.dispose();
		}
		
	}
}
