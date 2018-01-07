import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePlayGUI extends JPanel implements MouseListener, ActionListener, KeyListener
{
	// Container and layout variables to let the program switch between panels
	private Container container;
	private CardLayout cards;
	private GamePlay game;
	private Timer timer;
	private static final int SCREEN_CENTER_X = 300;
	private static final int SCREEN_CENTER_Y = 250;
	private static final int SCREEN_RIGHT_EDGE = 600;
	private static final int SCREEN_BOTTOM_EDGE = 500;
	
	public GamePlayGUI(Container container, CardLayout cards)
	{
		// Saves the container and layout used for this program
		this.container = container;
		this.cards = cards;
		this.addMouseListener(this);
		this.addKeyListener(this);
		this.requestFocus();
		
		this.setBackground(Color.black);
		game = new GamePlay(SCREEN_CENTER_X, SCREEN_CENTER_Y, SCREEN_BOTTOM_EDGE, SCREEN_RIGHT_EDGE);
		
		
		timer = new Timer(5, this); // Creates timer for animation
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.white);
		
		// Draws the center line
		for (int i = 0; i < 10; i++)
		{
			g.fillRect(297, 12+50*i, 6, 25); // line width = 6, line length = 25
		}
		
		// Draws the "ball"
		g.fillRect(game.getBallX(), game.getBallY(), game.getBallSize(), game.getBallSize());
		
		// get left paddle or get right paddle
		g.fillRect(game.getPaddleX("left"), game.getPaddleY("left"), game.getPaddleWidth(), game.getPaddleLength());
		g.fillRect(game.getPaddleX("right"), game.getPaddleY("right"), game.getPaddleWidth(), game.getPaddleLength());
	}
	
	public void startGame()
	{
		timer.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		game.updatePositions();
		
		this.repaint();
	}
	public void mouseClicked(MouseEvent e)
	{
		cards.show(container, "Main Menu");
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e)
	{
		this.requestFocus();
	}
	public void mouseExited(MouseEvent e) {}
	public void keyPressed(KeyEvent e)
	{
		char letter = e.getKeyChar();
		
		// controls for left player
		if(letter == 'w')
			game.setLeftMovingUp(true);
		if(letter == 's')
			game.setLeftMovingDown(true);
			
		// controls for right player
		if(letter == 'i')
			game.setRightMovingUp(true);
		if(letter == 'k')
			game.setRightMovingDown(true);
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e)
	{
		char letter = e.getKeyChar();
		
		// controls for left player
		if(letter == 'w')
			game.setLeftMovingUp(false);
		if(letter == 's')
			game.setLeftMovingDown(false);
			
		// controls for right player
		if(letter == 'i')
			game.setRightMovingUp(false);
		if(letter == 'k')
			game.setRightMovingDown(false);
	}
}
