import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePlayGUI extends JPanel implements MouseListener
{
	private Container container;
	private CardLayout cards;
	
	
	public GamePlayGUI(Container container, CardLayout cards)
	{
		this.container = container;
		this.cards = cards;
		this.addMouseListener(this);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawString("Game Area", 200, 400);
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
