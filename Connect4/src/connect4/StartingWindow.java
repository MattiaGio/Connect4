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
import java.awt.Font;



public class StartingWindow {

	private JFrame frmConnect;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.setBounds(238, 413, 122, 45);
		frmConnect.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(263, 196, 139, 20);
		frmConnect.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(263, 239, 139, 20);
		frmConnect.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Player 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(255, 0, 255));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(194, 202, 59, 14);
		frmConnect.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Player 2:");
		lblNewLabel_1_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(194, 241, 59, 14);
		frmConnect.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\matti\\git\\Connect4\\Connect4\\img\\hggfhhgfgfh.jpg"));
		lblNewLabel.setBounds(0, 0, 599, 469);
		frmConnect.getContentPane().add(lblNewLabel);
	}
}
