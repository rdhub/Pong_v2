import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOptionsGUI extends JPanel implements MouseListener
{
	private Container container;
	private CardLayout cards;
	private GamePlayGUI gameplayGUI;
	private JTextArea instructions;
	private JLabel main_menu, left_player, right_player, controls;
	private JLabel w, s;
	private JLabel i, k;
	private JLabel up_L, down_L, up_R, down_R;
	
	public GameOptionsGUI(Container container, CardLayout cards, GamePlayGUI gameplayGUI)
	{
		this.setLayout(null);
		this.container = container;
		this.cards = cards;
		this.gameplayGUI = gameplayGUI;
		this.addMouseListener(this);
		this.setBackground(Color.BLACK);
		
		// Saves the container and layout used for this program
		this.container = container;
		this.cards = cards;
		this.gameplayGUI = gameplayGUI;
		this.addMouseListener(this);
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		this.setLayout(null);
		
		JLabel oneplayer = new JLabel("One Player", SwingConstants.CENTER);
		oneplayer.setFont(new Font("Courier", Font.BOLD, 25));
		oneplayer.setForeground(Color.white);
		oneplayer.setBounds(50,275,200,25);
		this.add(oneplayer);
		
		JLabel twoplayer = new JLabel("Two Player", SwingConstants.CENTER);
		twoplayer.setFont(new Font("Courier", Font.BOLD, 25));
		twoplayer.setForeground(Color.white);
		twoplayer.setBounds(350,275,200,25);
		this.add(twoplayer);
		
		JLabel back_button = new JLabel("Back", SwingConstants.CENTER);
		back_button.setFont(new Font("Courier", Font.BOLD, 20));
		back_button.setBounds(150, 400, 300, 25);
		back_button.setForeground(Color.white);
		back_button.setBackground(Color.black);
		back_button.setVisible(false);
		this.add(back_button);
		
		JLabel main_menu = new JLabel("Return to Main Menu", SwingConstants.CENTER);
		main_menu.setFont(new Font("Courier", Font.BOLD, 20));
		main_menu.setBounds(150, 400, 300, 25);
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
		
		if(mouseX >= 350 && mouseX <= 350 + 200 && mouseY >= 275 && mouseY <= 275 + 25)
		{
			cards.show(container, "Game Area");
			gameplayGUI.startGame();
		}
		// Return to main menu button
		if(mouseX >= 150 && mouseX <= 150 + 300 && mouseY >= 400 && mouseY <= 400 + 30)
		{
			cards.show(container, "Main Menu");
		}
			
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e) {}

}
