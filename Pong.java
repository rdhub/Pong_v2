
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JApplet
{
	private Container container;
	private CardLayout cards;
	private MainMenuGUI mainmenuGUI;
	private GamePlayGUI gameplayGUI;
	private InstructionsGUI instructionsGUI;
	private GameOptionsGUI gameoptionsGUI;
	
	public void init()
	{
		container = this.getContentPane();
		cards = new CardLayout();
		container.setLayout(cards);
		
		// Passes the container and layout so that other classes can change panels during the program
		gameplayGUI = new GamePlayGUI(container, cards);
		
		// Passes the container and layout so that other classes can change panels during the program
		mainmenuGUI = new MainMenuGUI(container, cards, gameplayGUI);
		
		// Passes the container and layout so that other classes can change panels during the program
		instructionsGUI = new InstructionsGUI(container, cards);
		
		// Passes the container and layout so that other classes can change panels during the program
		gameoptionsGUI = new GameOptionsGUI(container, cards, gameplayGUI);
		
		// Adds the panel to the card layout
		container.add(mainmenuGUI, "Main Menu");
		container.add(gameplayGUI, "Game Area");
		container.add(instructionsGUI, "Instructions");
		container.add(gameoptionsGUI, "Game Options");
		
		
		//~ cards.show(container, "Main Menu"); // Sets Main Menu as the first panel to be shown
		
		
	}
}
