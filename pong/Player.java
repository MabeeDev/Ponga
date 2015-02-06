package pong;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Sets up the player and it's corresponding variables
 * @author Mabee
 */
public class Player {

	// Sets the initial point of the player to half the height of the window
	private int y = Pong.WINDOW_HEIGHT / 2;
	
	// Initiates the speed at 0
	static int yVelocity = 0;
	
	/* Set the height and width of the player */
	private int width = 10;
	private int height = 40;
	
	// Magic
	public Player() {
	}
	
	// Updates the players movement by grabbing the speed of y as inputted
	public void update() {
		y = y + yVelocity;	
	}
	
	
	/**
	 *  paints the user with the color white
	 *  @param g
	 */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		
		g.fillRect(35,  y, width, height); // Sets the rectangles size according to the variables defined
	}
	
	/**
	 * @how_to_use Input the speed when calling this method in order to set the speed of the player
	 * @param speed
	 */
	public void setYVelocity(int speed) {
		yVelocity = speed;
	}
	
	/* returns the x-size of the player(width) */
	public int getX() {
		return 35;
	}
	
	// returns the y value of the player
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



