package connect4;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		Logic game = new Logic();
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

}
