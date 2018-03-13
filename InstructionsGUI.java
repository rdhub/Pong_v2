import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsGUI extends JPanel implements MouseListener
{
	private Container container;
	private CardLayout cards;
	private JTextArea instructions;
	private JTextArea text;
	private JLabel main_menu, left_player, right_player, controls;
	
	public InstructionsGUI(Container container, CardLayout cards)
	{
		this.setLayout(null);
		this.container = container;
		this.cards = cards;
		this.addMouseListener(this);
		this.setBackground(Color.BLACK);
		
		JLabel title_label = new JLabel("HOW TO PLAY", SwingConstants.CENTER);
		title_label.setFont(new Font("Courier", Font.BOLD, 25));
		title_label.setForeground(Color.white);
		title_label.setBounds(210,50,180,25);
		this.add(title_label);

		text = new JTextArea(".");
		text.setFont(new Font("Courier", Font.BOLD, 25));
		text.setLineWrap(true);
		text.setForeground(Color.WHITE);
		text.setBackground(Color.BLACK);
		text.setBounds(50, 100, 100, 30);
		this.add(text);
		
		JLabel left_player = new JLabel("Left Player", SwingConstants.CENTER);
		left_player.setFont(new Font("Courier", Font.BOLD, 20));
		left_player.setForeground(Color.white);
		left_player.setBounds(50,200,200,25);
		this.add(left_player);
		
		JLabel right_player = new JLabel("Right Player", SwingConstants.CENTER);
		right_player.setFont(new Font("Courier", Font.BOLD, 20));
		right_player.setForeground(Color.white);
		right_player.setBounds(350,200,200,25);
		this.add(right_player);
		
		main_menu = new JLabel("Return to Main Menu", SwingConstants.CENTER);
		main_menu.setFont(new Font("Courier", Font.BOLD, 20));
		main_menu.setBounds(150, 400, 300, 30);
		main_menu.setForeground(Color.white);
		main_menu.setBackground(Color.black);
		this.add(main_menu);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	public void mouseClicked(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
	
		// Return to main menu button
		if(mouseX >= 150 && mouseX <= 150 + 300 && mouseY >= 400 && mouseY <= 400 + 30)
		{
			cards.show(container, "Main Menu");
		}
			
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e)
	{
		this.requestFocus();
	}
	public void mouseExited(MouseEvent e) {}

}
