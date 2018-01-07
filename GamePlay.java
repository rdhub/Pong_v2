public class GamePlay
{
	private int ballX, ballY, ballSize;
	private int leftPaddleX, leftPaddleY, rightPaddleX, rightPaddleY;
	private int paddleWidth, paddleLength;
	private int gap_from_edge;
	private int screen_center_x, screen_center_y, screen_bottom_edge, screen_right_edge;
	
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
	}
	
	// Getters
	public int getBallX()
	{
		return ballX;
	}
	
	public int getBallY()
	{
		return ballY;
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
	
	public int getPaddleX(boolean left)
	{
		if(left)
			return leftPaddleX;
		else
			return rightPaddleX;
	}
	
	public int getPaddleY(boolean left)
	{
		if(left)
			return leftPaddleY;
		else
			return rightPaddleY;
	}
	
	public int getGapFromEdge()
	{
		return gap_from_edge;
	}
}
