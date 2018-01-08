import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsGUI extends JPanel
{
	private JTextArea instructions;
	public InstructionsGUI()
	{
		instructions = new JTextArea("");
		instructions.setLineWrap(true);
		instructions.setEditable(false);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}
