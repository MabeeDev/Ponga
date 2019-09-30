package aa;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class t extends JFrame {

	public static int WINDOW_WIDTH = 203;
	public static int WINDOW_HEIGHT = 144;
	
	/**
	 * Asks the user for a difficulty and sets up the frame
	 * 
	 */
	public static int plyr;
	public t() {
		
		
		
		// Stores the user input in an integer.
		int lvl = JOptionPane.showOptionDialog(null, "Select Difficulty",  "Difficulty", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Easy", "Medium","Hard"}, "default");
		plyr = JOptionPane.showOptionDialog(null, "How many players?", "PONGA", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"1", "2"}, "default");
		/* Determines which option the user selected and sizes accordingly */
		if(lvl == 0) { WINDOW_WIDTH = 816; WINDOW_HEIGHT = 556; }
		else if(lvl == 1) { WINDOW_WIDTH = 406; WINDOW_HEIGHT = 278; }
		else { WINDOW_WIDTH = 203; WINDOW_HEIGHT = 144; }
		System.out.print(plyr);
		// Sets the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Makes it so pesky users can't interfere with our precious window size
		setResizable(false);
		
		// Tells Java what to do upon closing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Magic
		add(new GamePanel());
		
		// Gives user frame-vision abilities
		setVisible(true);
	}
	
	// Required main method
	public static void main(String[] args) {
		new t();
	}
	
}
