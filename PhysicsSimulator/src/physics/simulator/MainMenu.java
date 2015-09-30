package physics.simulator;

import javax.swing.JFrame;

public class MainMenu {
	
	private static final int WIDTH_OF_PANEL = 1000, HEIGHTOFPANEL = 1000;
	
	private static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("Physics Simulator");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		MainMenuPanel mainPanel = new MainMenuPanel();
		frame.getContentPane().add(mainPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static JFrame getFrame(){
		return frame;
	}

	public static int getWidthOfPanel() {
		return WIDTH_OF_PANEL;
	}

	public static int getHeightofpanel() {
		return HEIGHTOFPANEL;
	}
}
