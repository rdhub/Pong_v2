
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JApplet
{
	private Container container;
	private CardLayout cards;
	private MainMenuGUI mainmenuGUI;
	private GamePlayGUI gameplayGUI;
	//~ private InstructionsGUI instructionsGUI;
	
	public void init()
	{
		container = this.getContentPane();
		cards = new CardLayout();
		container.setLayout(cards);
		
		// Passes the container and layout so that other classes can change panels during the program
		gameplayGUI = new GamePlayGUI(container, cards);
		container.add(gameplayGUI, "Game Area");
		
		// Passes the container and layout so that other classes can change panels during the program
		mainmenuGUI = new MainMenuGUI(container, cards, gameplayGUI);
		container.add(mainmenuGUI, "Main Menu");
		
		cards.show(container, "Main Menu");
	}
}
