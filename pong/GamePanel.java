package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")

/**
 * Creates the game panel and allows input into the program
 * @author Mabee
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	Player player = new Player();
	Ball ball = new Ball();
	
	/* Sets a timer, because why not. I may use it one day instead of a counter */
	public GamePanel() {
		Timer timer = new Timer(20, this);
		timer.start();
		
		
		this.addKeyListener(this); // Adds a keyListener for the class
		this.setFocusable(true);
		
	}
	
	// Just a counter for ol' times sake
	public static int time = 0;
	
	/**
	 * Updates the player and the ball
	 */
	public void update() {
		time++;
		player.update();
		
		/* Ball won't start moving for a set amount of time(until this updates 90 times) */
		if(time >= 90) {
			
			Ball.playerLost = false;// Variable used to determine whether the player lost
			
			ball.update(); // Updates the ball
			
		}
		
		// Calls to check if the ball has hit the player
		ball.checkCollsionWith(player);
		
		ball.hitWall();
		
	}
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
		
		player.paint(g);
		ball.paint(g);
		
		g.setColor(Color.WHITE);
		
		g.drawLine(0, 30, Pong.WINDOW_WIDTH,  30);
		g.drawLine(Pong.WINDOW_WIDTH / 2,  30,  Pong.WINDOW_WIDTH / 2,  Pong.WINDOW_HEIGHT);
		
		g.setColor(Color.YELLOW);
		
		
	}
	
	public Ball getBall() {
		return ball;
	}
	
	
	/**
	 * It's all basic from here down
	 */
	public void actionPerformed(ActionEvent e) {
		update(); // Updates upon action
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.setYVelocity(-5);
			if(player.getY() < 30) {
				player.setYVelocity(0);
			}
			
		} else if( e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setYVelocity(5);
			if(player.getY() + 40 > Pong.WINDOW_HEIGHT - 28) {
				player.setYVelocity(0);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
			player.setYVelocity(0);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	
	
}
	

