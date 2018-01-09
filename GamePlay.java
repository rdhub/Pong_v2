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
		
		ballSize = 10;
		ballMoveSpeed = 5;
		ball_dx = ballMoveSpeed;
		resetBall(); // Resets the ball to the center of the screen
		
		paddleWidth = 10;
		paddleLength = 50;
		gap_from_edge = 30;
		paddleMoveSpeed = 2.5;
		
		leftPaddleX = gap_from_edge;
		leftPaddleY = screen_center_y - paddleLength/2;
		
		rightPaddleX = screen_right_edge - gap_from_edge - paddleWidth;
		rightPaddleY = screen_center_y - paddleLength/2;
		
		left_moving_down = left_moving_up = right_moving_down = right_moving_up = false;
		
		left_player_score = right_player_score = 0;
		winning_score = 10;
		
	}
	
	public void updatePositions()
	{
		// Checks if the ball hit the top or bottom of the screen
		if(ballY + ball_dy < 0 || ballY + ballSize + ball_dy > screen_bottom_edge)
			ball_dy = -ball_dy;

		// Checks if the ball collides with right paddle
		if(ballX + ballSize + ball_dx > rightPaddleX && ballX + ballSize + ball_dx < rightPaddleX + paddleWidth && 
			(ballY + ball_dy < rightPaddleY + paddleLength && ballY + ballSize + ball_dy > rightPaddleY))
		{
			double ballCenterY = ballY + ballSize/2;
			double rightPaddleCenterY = rightPaddleY + paddleLength/2;
			
			// Finds the dist b/w the center of paddle and the ball, and maps it to 45 degrees to find the bounce off angle
			int angle = (int)((ballCenterY - rightPaddleCenterY)/(paddleLength/2) * 45);
			ball_dy = 2*Math.sin(Math.toRadians(angle));
			
			ball_moving_right = false;
		}
		
		// Checks if the ball collides with left paddle
		if(ballX - ball_dx < leftPaddleX + paddleWidth && ballX - ball_dx > leftPaddleX && 
			(ballY + ball_dy < leftPaddleY + paddleLength && ballY + ballSize + ball_dy > leftPaddleY))
		{
			double ballCenterY = ballY + ballSize/2;
			double leftPaddleCenterY = leftPaddleY + paddleLength/2;
			
			// Finds the dist b/w the center of paddle and the ball, and maps it to 45 degrees to find the bounce off angle
			int angle = (int)((ballCenterY - leftPaddleCenterY)/(paddleLength/2) * 45);
			ball_dy = 2*Math.sin(Math.toRadians(angle));
			
			ball_moving_right = true;
		}
		
		// Update the horizontal ball position based on the current direction
		if(ball_moving_right)
			ballX += ball_dx;
		if(!ball_moving_right)
			ballX -= ball_dx;
		
		// Updates the y position of the ball
		ballY += ball_dy;
		
		// Updates the left paddle vertical position
		if(left_moving_up && leftPaddleY - paddleMoveSpeed >= 0)
			leftPaddleY -= paddleMoveSpeed;
		if(left_moving_down && leftPaddleY + paddleMoveSpeed + paddleLength <= screen_bottom_edge)
			leftPaddleY += paddleMoveSpeed;
		
		// Updates the right paddle vertical position
		if(right_moving_up && rightPaddleY - paddleMoveSpeed >= 0)
			rightPaddleY -= paddleMoveSpeed;
		if(right_moving_down && rightPaddleY + paddleMoveSpeed + paddleLength <= screen_bottom_edge)
			rightPaddleY += paddleMoveSpeed;
			
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
	}
	
	public void resetBall()
	{
		ballX = screen_center_x - ballSize/2;
		ballY = screen_center_y - ballSize/2;
		int angle = (int)(Math.random()*91-45); // generate a random angle from -45 to +45 degrees
		ball_dy = ballMoveSpeed*Math.sin(Math.toRadians(angle));
		
		// Randomize the starting direction of the ball (either left or right)
		switch((int)(Math.random()*2))
		{
			case 0: ball_moving_right = true; break;
			case 1: ball_moving_right = false; break;
		}
	}
	
	public boolean isGameOver()
	{
		return right_player_score == winning_score || left_player_score == winning_score;
	}
	
	public String getWinner()
	{
		if(right_player_score == winning_score)
			return "right";
		else if(left_player_score == winning_score)
			return "left";
		else
			return "";
	}
	public void resetGame()
	{
		resetBall();
		leftPaddleY = screen_center_y - paddleLength/2;
		rightPaddleY = screen_center_y - paddleLength/2;
		left_player_score = right_player_score = 0;
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
	
	public int getPlayerScore(String player)
	{
		if(player.equals("left"))
			return left_player_score;
		else if(player.equals("right"))
			return right_player_score;
		else
			return 0;
	}
	public int getPaddleX(String paddle)
	{
		if(paddle.equals("left"))
			return leftPaddleX;
		else if(paddle.equals("right"))
			return rightPaddleX;
		else
			return 0;
	}
	
	public int getPaddleY(String paddle)
	{
		if(paddle.equals("left"))
			return (int)Math.round(leftPaddleY);
		else if(paddle.equals("right"))
			return (int)Math.round(rightPaddleY);
		else
			return 0;
	}
	
	public int getPaddleCenterY(String paddle)
	{
		if(paddle.equals("left"))
			return (int)Math.round(leftPaddleY + paddleLength/2);
		else if(paddle.equals("right"))
			return (int)Math.round(rightPaddleY + paddleLength/2);
		else
			return 0;
	}
	
	// Setters
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
}
