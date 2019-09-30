package aa;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class Ball {

	
	public static String retVal = ""; // I didn't need to make this public. #secrets
	
	public static boolean playerLost = false; // Used for java to see if the player has lost. I needed to make this public
	
	public static JFrame frame = new JFrame("frame");
	
	/* Sets the ball to the middle of the frame */
	public static int x = t.WINDOW_WIDTH / 2; 
	public static int y = t.WINDOW_HEIGHT / 2;
	
	
	private int xVelocity =    -4;
	private int yVelocity = 	4;
	
	private int size = 			7; // Sets the size of the ball
	
	private int playerScore =	0;
	private int player2Score = 	0;
	
	static Random ran = new Random();
	
	/**
	 * Updates the ball, Checks playerLost, sets the X and Y values
	 */
	
	/** Originally in an if statement when the ball reached x < 0 in update() */
	public static void ballReset() {
		GamePanel.time= 0; // Resets the count-timer used for delaying the ball upon a loss
		/* Resets the ball position "Sure, call it a scratch, I know it wasn't" */
		x = t.WINDOW_WIDTH / 2;
		y = t.WINDOW_HEIGHT / 2;
	}
	

	public void update() {
		
		x = x + xVelocity;
		y = y + yVelocity;
		
		if(x < 0) 									{
														xVelocity = 	 4;
														if(t.plyr != 1) { playerScore = 0; ballReset(); }
														player2Score++;
													}
		
		
		else if(x + size > t.WINDOW_WIDTH - 6) 		{
														xVelocity = 	-4; 
														playerScore++;
													}
		
		if( y < 0 ) 								{ 	yVelocity = 	 4;  	} 
		
		else if( y + size > t.WINDOW_HEIGHT - 28 ) 	{ 	yVelocity = 	-4;		}
			
	}
	
	public void paint(Graphics g) {
		
		// This can be set accordingly. Colors are neato
		g.setColor(Color.YELLOW);
		
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
		
		if(	Ball.x > player.getX()	&& 	Ball.x < player.getX() + player.getWidth()) {
			if(	Ball.y > player.getY()	&& 	Ball.y < player.getY() + player.getHeight()){
				reverseDirection();
			}
			
		}
		
	}
	
	public void checkCollsionWith2(Player2 player) {
		
		if(Ball.x > player.getX() && Ball.x < player.getX() + player.getWidth()) {
			if(Ball.y > player.getY() && Ball.y < player.getY() + player.getHeight()){
				reverseDirection();
			}
			
		}
		
	}
	
	
	
	public void hitWall() {
		if(Ball.y < 30) {
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
		String p2 = "";
		if(t.plyr == 1) { p2 = " : P2 SCORE: " + player2Score; }
		if(playerLost == false) {
			retVal = "P1 SCORE: " + playerScore + p2;
		} else {
			retVal = "PLAYER LOST";
		}
		
		return retVal;
		
	}
	
	
	
}




