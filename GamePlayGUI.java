import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePlayGUI extends JPanel implements MouseListener
{
	// Container and layout variables to let the program switch between panels
	private Container container;
	private CardLayout cards;
	private int ballX, ballY, ballSize;
	private int leftPaddleX, leftPaddleY, rightPaddleX, rightPaddleY;
	private int paddleWidth, paddleLength;
	private int gap_from_edge;
	
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
		this.setBackground(Color.black);
		
		ballSize = 20;
		ballX = SCREEN_CENTER_X - ballSize/2;
		ballY = SCREEN_CENTER_Y - ballSize/2;
		
		paddleWidth = 10;
		paddleLength = 50;
		gap_from_edge = 40;
		
		leftPaddleX = gap_from_edge;
		leftPaddleY = SCREEN_CENTER_Y - paddleLength/2;
		
		rightPaddleX = SCREEN_RIGHT_EDGE - gap_from_edge;
		rightPaddleY = SCREEN_CENTER_Y - paddleLength/2;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.white);
		g.drawString("Game Area", 200, 200);
		
		// Draws the center line
		for (int i = 0; i < 10; i++)
		{
			g.fillRect(297, 12+50*i, 6, 25); // line width = 6, line length = 25
		}
		
		g.fillRect(ballX, ballY, ballSize, ballSize);
		
		g.fillRect(leftPaddleX, leftPaddleY, paddleWidth, paddleLength);
		g.fillRect(rightPaddleX, rightPaddleY, paddleWidth, paddleLength);
	}
	public void mouseClicked(MouseEvent e)
	{
		cards.show(container, "Main Menu");
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
