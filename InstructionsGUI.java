import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsGUI extends JPanel implements MouseListener
{
	private Container container;
	private CardLayout cards;
	private JTextArea instructions;
	private JLabel main_menu, left_player, right_player, controls;
	private JLabel w, s;
	private JLabel i, k;
	private JLabel up_L, down_L, up_R, down_R;
	
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

		instructions = new JTextArea("Each player moves a paddle up and down to hit a ball moving in the field. A player scores a point when " +
								"the opposing player fails to hit ball back. The first player to reach 10 points wins. The game can be " +
								"played against another human player, or against a computer player.");
		instructions.setFont(new Font("Courier", Font.BOLD, 17));
		instructions.setLineWrap(true);
		instructions.setWrapStyleWord(true);
		instructions.setForeground(Color.WHITE);
		instructions.setBackground(Color.BLACK);
		instructions.setBounds(50, 80, 500, 150);
		this.add(instructions);
		
		JLabel controls = new JLabel("Controls", SwingConstants.CENTER);
		controls.setFont(new Font("Courier", Font.BOLD, 20));
		controls.setForeground(Color.white);
		controls.setBounds(210,250,180,25);
		this.add(controls);

		JLabel left_player = new JLabel("Left Player", SwingConstants.CENTER);
		left_player.setFont(new Font("Courier", Font.BOLD, 20));
		left_player.setForeground(Color.white);
		left_player.setBounds(50,275,200,25);
		this.add(left_player);
		
		JLabel w = new JLabel("W", SwingConstants.CENTER);
		w.setFont(new Font("Courier", Font.BOLD, 25));
		w.setForeground(Color.white);
		w.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		w.setBounds(110,310,30,30);
		this.add(w);
		
		JLabel up_L = new JLabel("up");
		up_L.setFont(new Font("Courier", Font.BOLD, 20));
		up_L.setForeground(Color.white);
		up_L.setBounds(150,310,50,30);
		this.add(up_L);
		
		JLabel s = new JLabel("S", SwingConstants.CENTER);
		s.setFont(new Font("Courier", Font.BOLD, 25));
		s.setForeground(Color.white);
		s.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		s.setBounds(110,350,30,30);
		this.add(s);
		
		JLabel down_L = new JLabel("down");
		down_L.setFont(new Font("Courier", Font.BOLD, 20));
		down_L.setForeground(Color.white);
		down_L.setBounds(150,350,50,30);
		this.add(down_L);
		
		JLabel right_player = new JLabel("Right Player", SwingConstants.CENTER);
		right_player.setFont(new Font("Courier", Font.BOLD, 20));
		right_player.setForeground(Color.white);
		right_player.setBounds(350,275,200,25);
		this.add(right_player);
		
		JLabel i = new JLabel("I", SwingConstants.CENTER);
		i.setFont(new Font("Courier", Font.BOLD, 25));
		i.setForeground(Color.white);
		i.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		i.setBounds(410,310,30,30);
		this.add(i);
		
		JLabel up_R = new JLabel("up");
		up_R.setFont(new Font("Courier", Font.BOLD, 20));
		up_R.setForeground(Color.white);
		up_R.setBounds(450,310,50,30);
		this.add(up_R);
		
		JLabel k = new JLabel("K", SwingConstants.CENTER);
		k.setFont(new Font("Courier", Font.BOLD, 25));
		k.setForeground(Color.white);
		k.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		k.setBounds(410,350,30,30);
		this.add(k);
		
		JLabel down_R = new JLabel("down");
		down_R.setFont(new Font("Courier", Font.BOLD, 20));
		down_R.setForeground(Color.white);
		down_R.setBounds(450,350,50,30);
		this.add(down_R);
		
		main_menu = new JLabel("Return to Main Menu", SwingConstants.CENTER);
		main_menu.setFont(new Font("Courier", Font.BOLD, 20));
		main_menu.setBounds(175, 400, 250, 25);
		main_menu.setForeground(Color.white);
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
		if(mouseX >= 175 && mouseX <= 150 + 250 && mouseY >= 400 && mouseY <= 400 + 30)
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
