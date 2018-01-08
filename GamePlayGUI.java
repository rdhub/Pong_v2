import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePlayGUI extends JPanel implements MouseListener, ActionListener, KeyListener
{
	// Container and layout variables to let the program switch between panels
	private Container container;
	private CardLayout cards;
	private GamePlay game;
	private Timer timer;
	private JLabel left_player_score, right_player_score, left_winner, right_winner;
	private int score_text_width;
	private int win_text_width;
	private static final int SCREEN_CENTER_X = 300;
	private static final int SCREEN_CENTER_Y = 250;
	private static final int SCREEN_RIGHT_EDGE = 600;
	private static final int SCREEN_BOTTOM_EDGE = 500;
	
	public GamePlayGUI(Container container, CardLayout cards)
	{
		// Saves the container and layout used for this program
		this.container = container;
		this.cards = cards;
		this.addMouseListener(this);
		this.addKeyListener(this);
		this.requestFocus();
		
		this.setBackground(Color.black);
		game = new GamePlay(SCREEN_CENTER_X, SCREEN_CENTER_Y, SCREEN_BOTTOM_EDGE, SCREEN_RIGHT_EDGE);
		
		this.setLayout(null);
		
		score_text_width = 60;
		left_player_score = new JLabel("0", SwingConstants.CENTER);
		left_player_score.setFont(new Font("Courier", Font.BOLD, 40));
		left_player_score.setBounds(295 - score_text_width, 8, score_text_width, 30);
		left_player_score.setForeground(Color.white);
		this.add(left_player_score);
		
		right_player_score = new JLabel("0", SwingConstants.CENTER);
		right_player_score.setFont(new Font("Courier", Font.BOLD, 40));
		right_player_score.setBounds(305, 8, score_text_width, 30);
		right_player_score.setForeground(Color.white);
		this.add(right_player_score);
		
		win_text_width = 250;
		right_winner = new JLabel("Right Player Wins!", SwingConstants.CENTER);
		right_winner.setFont(new Font("Courier", Font.BOLD, 20));
		right_winner.setBounds(325, 100, win_text_width, 30);
		right_winner.setForeground(Color.white);
		//~ right_winner.setVisible(false);
		this.add(right_winner);
		
		left_winner = new JLabel("Left Player Wins!", SwingConstants.CENTER);
		left_winner.setFont(new Font("Courier", Font.BOLD, 20));
		left_winner.setBounds(25, 100, win_text_width, 30);
		left_winner.setForeground(Color.white);
		//~ left_winner.setVisible(false);
		this.add(left_winner);
		timer = new Timer(5, this); // Creates timer for animation
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.white);
		
		// Draws the center line
		for (int i = 0; i < 10; i++)
		{
			g.fillRect(297, 12+50*i, 6, 25); // line width = 6, line length = 25
		}

		// Draws the "ball" if the game is not over
		if(!game.isGameOver())
			g.fillRect(game.getBallX(), game.getBallY(), game.getBallSize(), game.getBallSize());
		
		// get left paddle or get right paddle
		g.fillRect(game.getPaddleX("left"), game.getPaddleY("left"), game.getPaddleWidth(), game.getPaddleLength());
		g.fillRect(game.getPaddleX("right"), game.getPaddleY("right"), game.getPaddleWidth(), game.getPaddleLength());
	}
	
	public void startGame()
	{
		timer.start();
		game.resetGame();
		right_winner.setVisible(false);
		left_winner.setVisible(false);
		this.requestFocus();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(!game.isGameOver())
		{
			game.updatePositions();
		}
		else
		{
			if(game.getWinner().equals("right"))
				right_winner.setVisible(true);
			if(game.getWinner().equals("left"))
				left_winner.setVisible(true);
			timer.stop();
		}
		left_player_score.setText("" + game.getPlayerScore("left"));
		right_player_score.setText("" + game.getPlayerScore("right"));
		this.repaint();
	}
	public void mouseClicked(MouseEvent e)
	{
		cards.show(container, "Main Menu");
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e)
	{
		this.requestFocus();
	}
	public void mouseExited(MouseEvent e) {}
	public void keyPressed(KeyEvent e)
	{
		char letter = e.getKeyChar();
		
		// controls for left player
		if(letter == 'w')
			game.setLeftMovingUp(true);
		if(letter == 's')
			game.setLeftMovingDown(true);
			
		// controls for right player
		if(letter == 'i')
			game.setRightMovingUp(true);
		if(letter == 'k')
			game.setRightMovingDown(true);
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e)
	{
		char letter = e.getKeyChar();
		
		// controls for left player
		if(letter == 'w')
			game.setLeftMovingUp(false);
		if(letter == 's')
			game.setLeftMovingDown(false);
			
		// controls for right player
		if(letter == 'i')
			game.setRightMovingUp(false);
		if(letter == 'k')
			game.setRightMovingDown(false);
	}
}
