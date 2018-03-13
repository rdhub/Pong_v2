import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenuGUI extends JPanel implements MouseListener
{
	// Container and layout variables to let the program switch between panels
	private Container container;
	private CardLayout cards;
	private GamePlayGUI gameplayGUI;
	
	public MainMenuGUI(Container container, CardLayout cards, GamePlayGUI gameplayGUI)
	{
		// Saves the container and layout used for this program
		this.container = container;
		this.cards = cards;
		this.gameplayGUI = gameplayGUI;
		
		this.setLayout(null);
		this.addMouseListener(this);
		this.setBackground(Color.black);
		
		JLabel title_label = new JLabel("PONG", SwingConstants.CENTER);
		title_label.setFont(new Font("Courier", Font.BOLD, 40));
		title_label.setForeground(Color.white);
		title_label.setBounds(250, 50, 100, 30);
		this.add(title_label);
		
		JLabel playgame_label = new JLabel("Play Game", SwingConstants.CENTER);
		playgame_label.setFont(new Font("Courier", Font.BOLD, 20));
		playgame_label.setForeground(Color.white);
		playgame_label.setBounds(230,350,140,25);
		this.add(playgame_label);
		
		JLabel instructions_label = new JLabel("Instructions", SwingConstants.CENTER);
		instructions_label.setFont(new Font("Courier", Font.BOLD, 20));
		instructions_label.setForeground(Color.white);
		instructions_label.setBounds(210,400,180,25);
		this.add(instructions_label);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	}
	public void mouseClicked(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		if(mouseX >= 230 && mouseX <= 230 + 140 && mouseY >= 350 && mouseY <= 350 + 25)
		{
			cards.show(container, "Game Options");
			//~ gameplayGUI.startGame();
		}
		else if(mouseX >= 210 && mouseX <= 210 + 180 && mouseY >= 400 && mouseY <= 400 + 25)
		{
			cards.show(container, "Instructions");
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
