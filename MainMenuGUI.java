import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenuGUI extends JPanel implements MouseListener
{
	// Container and layout variables to let the program switch between panels
	private Container container;
	private CardLayout cards;
	private GamePlayGUI gameplayGUI;
	
	public MainMenuGUI(Container container, CardLayout cards)
	{
		// Saves the container and layout used for this program
		this.container = container;
		this.cards = cards;
		
		this.addMouseListener(this);
		this.setBackground(Color.black);
		this.setOpaque(false); // sets background to transparent
		gameplayGUI = new GamePlayGUI(container, cards);
		this.add(gameplayGUI);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("Courier", Font.BOLD, 35));
		
		g.drawString("Main Menu", 200, 400);
	}
	public void mouseClicked(MouseEvent e)
	{
		cards.show(container, "Game Area");
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
