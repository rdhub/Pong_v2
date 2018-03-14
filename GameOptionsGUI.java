import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOptionsGUI extends JPanel implements MouseListener
{
	// Container and layout variables to let the program switch between panels
	private Container container;
	private CardLayout cards;
	private GamePlayGUI gameplayGUI;
	private JLabel title, oneplayer, twoplayer;
	private JLabel back_button, main_menu;
	private JLabel easy, medium, hard;
	private boolean computer;
	
	public GameOptionsGUI(Container container, CardLayout cards, GamePlayGUI gameplayGUI)
	{
		// Saves the container and layout used for this program
		this.container = container;
		this.cards = cards;
		this.gameplayGUI = gameplayGUI;
		this.addMouseListener(this);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		
		title = new JLabel("Select an option", SwingConstants.CENTER);
		title.setFont(new Font("Courier", Font.BOLD, 25));
		title.setForeground(Color.white);
		title.setBounds(150,50,300,25);
		this.add(title);
		
		oneplayer = new JLabel("One Player", SwingConstants.CENTER);
		oneplayer.setFont(new Font("Courier", Font.BOLD, 25));
		oneplayer.setForeground(Color.white);
		oneplayer.setBounds(70,220,160,25);
		this.add(oneplayer);
		
		twoplayer = new JLabel("Two Player", SwingConstants.CENTER);
		twoplayer.setFont(new Font("Courier", Font.BOLD, 25));
		twoplayer.setForeground(Color.white);
		twoplayer.setBounds(370,220,160,25);
		this.add(twoplayer);
		
		back_button = new JLabel("Back", SwingConstants.CENTER);
		back_button.setFont(new Font("Courier", Font.BOLD, 20));
		back_button.setBounds(275, 400, 50, 25);
		back_button.setForeground(Color.white);
		back_button.setVisible(false);
		this.add(back_button);
		
		main_menu = new JLabel("Return to Main Menu", SwingConstants.CENTER);
		main_menu.setFont(new Font("Courier", Font.BOLD, 20));
		main_menu.setBounds(175, 400, 250, 25);
		main_menu.setForeground(Color.white);
		this.add(main_menu);
		
		easy = new JLabel("Easy", SwingConstants.CENTER);
		easy.setFont(new Font("Courier", Font.BOLD, 25));
		easy.setForeground(Color.white);
		easy.setBounds(260, 170, 80, 25);
		easy.setForeground(Color.white);
		easy.setVisible(false);
		this.add(easy);
		
		medium = new JLabel("Medium", SwingConstants.CENTER);
		medium.setFont(new Font("Courier", Font.BOLD, 25));
		medium.setForeground(Color.white);
		medium.setBounds(250, 220, 100, 25);
		medium.setForeground(Color.white);
		medium.setVisible(false);
		this.add(medium);
		
		hard = new JLabel("Hard", SwingConstants.CENTER);
		hard.setFont(new Font("Courier", Font.BOLD, 25));
		hard.setForeground(Color.white);
		hard.setBounds(260, 270, 80, 25);
		hard.setForeground(Color.white);
		hard.setVisible(false);
		this.add(hard);
		
		
		computer = false;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	public void resetButtons()
	{
		computer = false;
		main_menu.setVisible(true);
		back_button.setVisible(false);
		twoplayer.setVisible(true);
		oneplayer.setVisible(true);
		easy.setVisible(false);
		medium.setVisible(false);
		hard.setVisible(false);
		title.setText("Select an option");
	}
	public void mouseClicked(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		if(!computer)
		{
			// One player button
			if(mouseX >= 70 && mouseX <= 70 + 160 && mouseY >= 220 && mouseY <= 220 + 25)
			{
				computer = true;
				main_menu.setVisible(false);
				back_button.setVisible(true);
				twoplayer.setVisible(false);
				oneplayer.setVisible(false);
				easy.setVisible(true);
				medium.setVisible(true);
				hard.setVisible(true);
				title.setText("Select a difficulty");
			}
			// Two player button
			else if(mouseX >= 370 && mouseX <= 370 + 160 && mouseY >= 220 && mouseY <= 220 + 25)
			{
				cards.show(container, "Game Area");
				gameplayGUI.startGame();
			}
			else if(mouseX >= 175 && mouseX <= 150 + 250 && mouseY >= 400 && mouseY <= 400 + 30)
			{
				// Return to main menu button
				cards.show(container, "Main Menu");
			}
		}
		else // One player selected
		{
			// Back button
			if(mouseX >= 275 && mouseX <= 275 + 50 && mouseY >= 400 && mouseY <= 400 + 30)
			{
				resetButtons();
			}
			// Easy
			else if(mouseX >= 260 && mouseX <= 260 + 80 && mouseY >= 170 && mouseY <= 170 + 25)
			{
				cards.show(container, "Game Area");
				gameplayGUI.startGame();
				resetButtons();
			}
			// Medium
			else if(mouseX >= 250 && mouseX <= 250 + 100 && mouseY >= 220 && mouseY <= 220 + 25)
			{
				cards.show(container, "Game Area");
				gameplayGUI.startGame();
				resetButtons();
			}
			// Hard
			else if(mouseX >= 260 && mouseX <= 260 + 80 && mouseY >= 270 && mouseY <= 270 + 25)
			{
				cards.show(container, "Game Area");
				gameplayGUI.startGame();
				resetButtons();
			}
		}
			
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e) {}

}
