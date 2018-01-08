import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsGUI extends JPanel
{
	private Container container;
	private CardLayout cards;
	private JTextArea instructions;
	private JLabel title;
	
	public InstructionsGUI(Container container, CardLayout cards)
	{
		this.container = container;
		this.cards = cards;
		
		instructions = new JTextArea("Hello");
		instructions.setLineWrap(true);
		instructions.setEditable(false);
		this.add(instructions);
		
		title = new JLabel("Instructions");
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}
