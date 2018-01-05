
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JApplet
{
	private Container container;
	private CardLayout cards;
	private MainMenuGUI mainmenuGUI;
	private GamePlayGUI gameplayGUI;
	
	public void init()
	{
		container = this.getContentPane();
		cards = new CardLayout();
		container.setLayout(cards);
		
		mainmenuGUI = new MainMenuGUI(container, cards);
		container.add(mainmenuGUI, "Main Menu");
		
		gameplayGUI = new GamePlayGUI(container, cards);
		container.add(gameplayGUI, "Game Area");
		
	}
}
