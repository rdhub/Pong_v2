public class GamePlay
{
	private double ballX, ballY;
	private int ballSize, ballCenter;
	private double ball_dx, ball_dy;
	
	private int leftPaddleX, rightPaddleX;
	private double leftPaddleY, rightPaddleY;
	private int paddleWidth, paddleLength;
	private int gap_from_edge;
	
	private int screen_center_x, screen_center_y, screen_bottom_edge, screen_right_edge;
	private boolean moving_right;
	private int left_player_score, right_player_score, winning_score;
	
	
	
	
	public GamePlay(int screen_center_x, int screen_center_y, int screen_bottom_edge, int screen_right_edge)
	{
		this.screen_center_x = screen_center_x;
		this.screen_center_y = screen_center_y;
		this.screen_bottom_edge = screen_bottom_edge;
		this.screen_right_edge = screen_right_edge;
		
		ballSize = 20;
		ballX = screen_center_x - ballSize/2;
		ballY = screen_center_y - ballSize/2;
		
		paddleWidth = 10;
		paddleLength = 50;
		gap_from_edge = 40;
		
		leftPaddleX = gap_from_edge;
		leftPaddleY = screen_center_y - paddleLength/2;
		
		rightPaddleX = screen_right_edge - gap_from_edge;
		rightPaddleY = screen_center_y - paddleLength/2;
		
		// Randomize the starting direction of the ball (either left or right)
		switch((int)(Math.random()*2))
		{
			case 0: moving_right = true; break;
			case 1: moving_right = false; break;
		}
		
		left_player_score = right_player_score = 0;
		winning_score = 10;
	}
	
	// Getters
	public int getBallX()
	{
		return (int)Math.round(ballX);
	}
	
	public int getBallY()
	{
		return (int)Math.round(ballY);
	}
	
	public int getBallSize()
	{
		return ballSize;
	}
	
	public int getPaddleWidth()
	{
		return paddleWidth;
	}
	
	public int getPaddleLength()
	{
		return paddleLength;
	}
	
	public int getGapFromEdge()
	{
		return gap_from_edge;
	}
	
	public int getPaddleX(String paddle)
	{
		if(paddle.equals("left"))
			return leftPaddleX;
		else
			return rightPaddleX;
	}
	
	public int getPaddleY(String paddle)
	{
		if(paddle.equals("left"))
			return (int)Math.round(leftPaddleY);
		else
			return (int)Math.round(rightPaddleY);
	}
	
	public int getPaddleCenterY(String paddle)
	{
		if(paddle.equals("left"))
			return (int)Math.round(leftPaddleY + paddleLength/2);
		else
			return (int)Math.round(rightPaddleY + paddleLength/2);
	}
	
	public void updatePositions()
	{
		
	}
}
