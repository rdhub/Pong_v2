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
		
		this.setLayout(null);
		this.addMouseListener(this);
		this.setBackground(Color.black);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("Courier", Font.BOLD, 40));
		
		g.drawRect(250, 50, 100, 30);
		g.drawString("PONG", 252, 80);
		
		g.setFont(new Font("Courier", Font.BOLD, 25));
		g.drawRect(230, 350, 140, 23); //bottom of box is y = 373
		g.drawString("Play Game", 232, 370);
		
		g.drawRect(210, 400, 180, 23); //bottom of box is y = 423
		g.drawString("Instructions", 210, 420);
	}
	public void mouseClicked(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		if(mouseX >= 230 && mouseX <= 230 + 140 && mouseY >= 350 && mouseY <= 350 + 23)
			cards.show(container, "Game Area");
		if(mouseX >= 210 && mouseX <= 210 + 180 && mouseY >= 400 && mouseY <= 400 + 23)
			;//~ cards.show(container, "Instructions");
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
