package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class Ball {

	
	public static String retVal = ""; // I didn't need to make this public. #secrets
	
	public static boolean playerLost = false; // Used for java to see if the player has lost. I needed to make this public
	
	public static JFrame frame = new JFrame("frame");
	
	/* Sets the ball to the middle of the frame */
	public int x = Pong.WINDOW_WIDTH / 2; 
	public int y = Pong.WINDOW_HEIGHT / 2;
	
	
	private int xVelocity = -4;
	private int yVelocity = 4;
	
	private int size = 7; // Sets the size of the ball
	
	private int playerScore = 0;
	
	static Random ran = new Random();
	
	/**
	 * Updates the ball, Checks playerLost, sets the X and Y values
	 */
	public void update() {
		
		x = x + xVelocity;
		y = y + yVelocity;
		
		
		if(x < 0) {
			xVelocity = 4;
			
			GamePanel.time= 0; // Resets the count-timer used for delaying the ball upon a loss
			
			/* Resets the ball position "Sure, call it a scratch, I know it wasn't" */
			x = Pong.WINDOW_WIDTH / 2;
			y = Pong.WINDOW_HEIGHT / 2;
			
			playerLost = true;
			playerScore = 0; // Resets the players score
			
		} else if(x + size > Pong.WINDOW_WIDTH - 6) {
			
			xVelocity = -4; 
			playerScore++; // Adds a point
			
		}
		if( y < 0 ) { yVelocity = 4; } 
		
		else if( y + size > Pong.WINDOW_HEIGHT - 28 ) { yVelocity = -4; }
			
	}
	
	public void paint(Graphics g) {
		
		// This can be set accordingly. Colors are neato
		g.setColor(Color.RED);
		
		// Creates a ball with the defined variables as sizes
		g.fillOval(x,  y,  size,  size);
		
		g.drawString(toPlayer(),  5,  15);;
		
	}
	
	private void reverseDirection() {
		xVelocity = -xVelocity;
	}
	
	private void reverseDirectionY() {
		yVelocity = -yVelocity;
	}
	
	public void checkCollsionWith(Player player) {
		
		if(this.x > player.getX() && this.x < player.getX() + player.getWidth()) {
			if(this.y > player.getY() && this.y < player.getY() + player.getHeight()){
				
				reverseDirection();
				
			}
			
		}
		
	}
	
	public void hitWall() {
		if(this.y < 30) {
			reverseDirectionY();
		}
	}
	
	
	
	public int getX() {
		
		return x;
		
	}
	
	public int getY() {
		return y;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public String toPlayer() {
		retVal = "";
		
		if(playerLost == false) {
			retVal = "SCORE: " + playerScore;
		} else {
			retVal = "PLAYER LOST";
		}
		
		return retVal;
		
	}
	
	
	
}




