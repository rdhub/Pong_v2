public class GamePlay
{
	private double ballX, ballY;
	private int ballSize, ballCenter;
	private double ball_dx, ball_dy;
	
	private int leftPaddleX, rightPaddleX;
	private double leftPaddleY, rightPaddleY;
	private int paddleWidth, paddleLength;
	private int gap_from_edge;
	private double paddleMoveSpeed;
	private double ballMoveSpeed;
	
	private int screen_center_x, screen_center_y, screen_bottom_edge, screen_right_edge;
	private boolean ball_moving_right;
	private int left_player_score, right_player_score, winning_score;
	
	private boolean left_moving_up, left_moving_down, right_moving_up, right_moving_down;
	
	public GamePlay(int screen_center_x, int screen_center_y, int screen_bottom_edge, int screen_right_edge)
	{
		this.screen_center_x = screen_center_x;
		this.screen_center_y = screen_center_y;
		this.screen_bottom_edge = screen_bottom_edge;
		this.screen_right_edge = screen_right_edge;
		
		ballSize = 20;
		ballX = screen_center_x - ballSize/2;
		ballY = screen_center_y - ballSize/2;
		ballMoveSpeed = 1;
		
		paddleWidth = 10;
		paddleLength = 50;
		gap_from_edge = 40;
		paddleMoveSpeed = 2.5;
		
		leftPaddleX = gap_from_edge;
		leftPaddleY = screen_center_y - paddleLength/2;
		
		rightPaddleX = screen_right_edge - gap_from_edge - paddleWidth;
		rightPaddleY = screen_center_y - paddleLength/2;
		
		left_moving_down = left_moving_up = right_moving_down = right_moving_up = false;
		
		// Randomize the starting direction of the ball (either left or right)
		switch((int)(Math.random()*2))
		{
			case 0: ball_moving_right = true; break;
			case 1: ball_moving_right = false; break;
		}
		
		left_player_score = right_player_score = 0;
		winning_score = 10;
		
		ball_dx = 0;
		ball_dy = 0;
		int angle = (int)(Math.random()*91-45); // generate a random angle from -45 to +45 degrees
		ball_dy = ballMoveSpeed*Math.sin(Math.toRadians(angle));
		switch((int)(Math.random()*2))
		{
			case 0: ball_dx = ballMoveSpeed; ball_moving_right = true; break;
			case 1: ball_dx = -ballMoveSpeed; ball_moving_right = false; break;
		}
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
		if(ballY + ball_dy < 0 || ballY + ballSize + ball_dy > screen_bottom_edge)
			ball_dy = -ball_dy;

		// Checks if ball went into left side's wall
		if(ballX < 0)
		{
			resetBall();
			right_player_score++;
		} // Checks if ball went into right side's wall
		else if(ballX + ballSize > screen_right_edge)
		{
			resetBall();
			left_player_score++;
		}

		// Checks if the ball collides with right paddle
		if(ballX + ballSize + ball_dx > rightPaddleX && //ballX + ballSize + ball_dx < rightPaddleX + paddleWidth && 
			(ballY + ball_dy < rightPaddleY + paddleLength && ballY + ballSize + ball_dy > rightPaddleY))
		{
			double ballCenterY = ballY + ballSize/2;
			double rightPaddleCenterY = rightPaddleY + paddleLength/2;
			
			// Finds the dist b/w the center of paddle and the ball, and maps it to 45 degrees to find the bounce off angle
			int angle = (int)((ballCenterY - rightPaddleCenterY)/paddleLength/2 *45);
			ball_dy = 2*Math.sin(Math.toRadians(angle));
			
			ball_moving_right = true;
			ballX = rightPaddleX - ballSize; // to avoid ball getting stuck in paddle
		}
		
		// Checks if the ball collides with left paddle
		if(ballX + ball_dx < leftPaddleX + paddleWidth &&// ballX + ball_dx > leftPaddleX && 
			(ballY + ball_dy < leftPaddleY + paddleLength && ballY + ballSize + ball_dy > leftPaddleY))
		{
			double ballCenterY = ballY + ballSize/2;
			double leftPaddleCenterY = leftPaddleY + paddleLength/2;
			
			// Finds the dist b/w the center of paddle and the ball, and maps it to 45 degrees to find the bounce off angle
			int angle = (int)((ballCenterY - leftPaddleCenterY)/paddleLength/2 *45);
			ball_dy = 2*Math.sin(Math.toRadians(angle));
			
			ball_moving_right = false;
			ballX = leftPaddleX + paddleWidth; // to avoid ball getting stuck in paddle
		}
		
		if(ball_moving_right && ball_dx < 0)
			ball_dx = -ball_dx;
		if(!ball_moving_right && ball_dx > 0)
			ball_dx = -ball_dx;
			
		ballX += ball_dx;
		ballY += ball_dy;
		
		if(left_moving_up)
			leftPaddleY -= paddleMoveSpeed;
		if(left_moving_down)
			leftPaddleY += paddleMoveSpeed;
		if(right_moving_up)
			rightPaddleY -= paddleMoveSpeed;
		if(right_moving_down)
			rightPaddleY += paddleMoveSpeed;
	}
	
	public void setLeftMovingUp(boolean move)
	{
		left_moving_up = move;
	}
	public void setLeftMovingDown(boolean move)
	{
		left_moving_down = move;
	}
	public void setRightMovingUp(boolean move)
	{
		right_moving_up = move;
	}
	public void setRightMovingDown(boolean move)
	{
		right_moving_down = move;
	}
	
	public void resetBall()
	{
		ballX = screen_center_x - ballSize/2;
		ballY = screen_center_y - ballSize/2;
		int angle = (int)(Math.random()*91-45); // generate a random angle from -45 to +45 degrees
		ball_dy = ballMoveSpeed*Math.sin(Math.toRadians(angle));
		switch((int)(Math.random()*2))
		{
			case 0: ball_dx = ballMoveSpeed; ball_moving_right = true; break;
			case 1: ball_dx = -ballMoveSpeed; ball_moving_right = false; break;
		}
	}
}
