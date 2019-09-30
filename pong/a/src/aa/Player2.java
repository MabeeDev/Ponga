package aa;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Sets up the Player2 and it's corresponding variables
 * @author Mabee
 */
public class Player2 {

	/* Set the height and width of the Player2 */
	private static	int 	width = 10;
	private static	int 	height = 40;
	
	// Sets the initial point of the Player2 to half the height of the window
	private static int		x = t.WINDOW_WIDTH - 35 - width;
	private int				y = t.WINDOW_HEIGHT / 2;
	
	// Initiates the speed at 0
	static int 				yVelocity = 0;
	

	
	// Magic
	public Player2() {  }
	
	// Updates the Player2s movement by grabbing the speed of y as inputted
	public void update() {
		y = y + yVelocity;	
	}
	
	
	/**
	 *  paints the user with the color white
	 *  @param g
	 */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		
		g.fillRect(x,  y, width, height); // Sets the rectangles size according to the variables defined
	}
	
	/**
	 * @how_to_use Input the speed when calling this method in order to set the speed of the Player2
	 * @param speed
	 */
	
	public void setXVelocity(int speed) {
		//int velocity = speed;
	}
	
	public void setYVelocity(int speed) {
		yVelocity = speed;
	}
	
	/* returns the x-size of the Player2(width) */
	public int getX() {
		return x;
	}
	
	static int setHeight(int nH) {
		height = nH;
		return height;
	}
	
	// returns the y value of the Player2
	public int getY() {
		return y;
	}
	
	// Gets the wdith
	public int getWidth() {
		return width;
	}
	
	// Gets the height
	public int getHeight() {
		return height;
	}
	
}



