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
		
		JLabel title_label = new JLabel("PONG", SwingConstants.CENTER);
		title_label.setFont(new Font("Courier", Font.BOLD, 40));
		title_label.setForeground(Color.white);
		title_label.setBounds(250, 50, 100, 30);
		this.add(title_label);
		
		JLabel playgame_label = new JLabel("Play Game", SwingConstants.CENTER);
		playgame_label.setFont(new Font("Courier", Font.BOLD, 25));
		playgame_label.setForeground(Color.white);
		playgame_label.setBounds(230,350,140,25);
		this.add(playgame_label);
		
		JLabel instructions_label = new JLabel("Instructions", SwingConstants.CENTER);
		instructions_label.setFont(new Font("Courier", Font.BOLD, 25));
		instructions_label.setForeground(Color.white);
		instructions_label.setBounds(210,400,180,25);
		this.add(instructions_label);
	}
	public void paintComponent(Graphics g)
	{
		// Rectangles are added for use when determining the boundaries for clicking
		super.paintComponent(g);
		/*g.setColor(Color.white);
		g.setFont(new Font("Courier", Font.BOLD, 40));
		
		g.drawRect(250, 50, 100, 30);
		g.drawString("PONG", 252, 80);
		
		g.setFont(new Font("Courier", Font.BOLD, 25));
		//~ g.drawRect(230, 350, 140, 23); //bottom of box is y = 373
		//~ g.drawString("Play Game", 232, 370);
		
		g.drawRect(210, 400, 180, 23); //bottom of box is y = 423
		g.drawString("Instructions", 210, 420);*/
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
