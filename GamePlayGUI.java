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
	private JLabel play_again, main_menu;
	private int score_text_width;
	private int win_text_width;
	private boolean computer;
	private int difficulty;
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
		right_winner.setVisible(false);
		this.add(right_winner);
		
		left_winner = new JLabel("Left Player Wins!", SwingConstants.CENTER);
		left_winner.setFont(new Font("Courier", Font.BOLD, 20));
		left_winner.setBounds(25, 100, win_text_width, 30);
		left_winner.setForeground(Color.white);
		left_winner.setVisible(false);
		this.add(left_winner);
		
		play_again = new JLabel("Play Again", SwingConstants.CENTER);
		play_again.setFont(new Font("Courier", Font.BOLD, 20));
		play_again.setBounds(230, 350, 140, 25);
		play_again.setForeground(Color.white);
		play_again.setBackground(Color.black);
		play_again.setOpaque(true);
		play_again.setVisible(false); // Hides label initially
		this.add(play_again);
		
		main_menu = new JLabel("Return to Main Menu", SwingConstants.CENTER);
		main_menu.setFont(new Font("Courier", Font.BOLD, 20));
		main_menu.setBounds(175, 400, 250, 25);
		main_menu.setForeground(Color.white);
		main_menu.setBackground(Color.black);
		main_menu.setOpaque(true);
		main_menu.setVisible(false); // Hides label initially
		this.add(main_menu);
		
		computer = false;
		difficulty = 1;
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
	
	public void startGame(boolean computer, int difficulty)
	{
		this.computer = computer;
		this.difficulty = difficulty;
		timer.start();
		game.resetGame();
		right_winner.setVisible(false);
		left_winner.setVisible(false);
		play_again.setVisible(false);
		main_menu.setVisible(false);
		this.requestFocus();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(computer)
		{
			// Adds randomness to the computer's movement based on the difficulty setting
			if(game.getPaddleY("right") + game.getPaddleWidth() < game.getBallY()+game.getBallSize()/2.)
			{
				if((int)(Math.random()*100) < difficulty*5 + 65)
				{
					game.setRightMovingDown(true);
					game.setRightMovingUp(false);
				}
				else
				{
					game.setRightMovingDown(false);
					game.setRightMovingUp(true);
				}
			}
			else if(game.getPaddleY("right") > game.getBallY())
			{
				if((int)(Math.random()*100) < difficulty*5 + 65)
				{
					game.setRightMovingDown(false);
					game.setRightMovingUp(true);
				}
				else
				{
					game.setRightMovingDown(true);
					game.setRightMovingUp(false);
				}
			}
			else
			{
				game.setRightMovingDown(false);
				game.setRightMovingUp(false);
			}					
		}
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
			play_again.setVisible(true);
			main_menu.setVisible(true);
		}
		left_player_score.setText("" + game.getPlayerScore("left"));
		right_player_score.setText("" + game.getPlayerScore("right"));
		this.repaint();
	}
	public void mouseClicked(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		if(game.isGameOver())
		{
			if(mouseX >= 175 && mouseX <= 175 + 250 && mouseY >= 400 && mouseY <= 400 + 30)
			{
				cards.show(container, "Main Menu");
			}
			else if(mouseX >= 230 && mouseX <= 230 + 140 && mouseY >= 350 && mouseY <= 350 + 30)
			{
				this.startGame(computer,difficulty);
			}
		}
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
		if(!computer) // Computer controls right player
		{
			if(letter == 'i')
				game.setRightMovingUp(true);
			if(letter == 'k')
				game.setRightMovingDown(true);
		}
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
		if(!computer) // Computer controls right player
		{
			if(letter == 'i')
				game.setRightMovingUp(false);
			if(letter == 'k')
				game.setRightMovingDown(false);
		}
	}
}
