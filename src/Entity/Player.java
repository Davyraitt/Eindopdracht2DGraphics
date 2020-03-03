package Entity;

import Entity.Creature.Creature;
import Game.Game;
import Tiles.Tile;
import Tools.Animation;
import Tools.Assets;
import Game.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Player extends Creature {
	
	//Walking booleans
	boolean moveUpPressed = false;
	boolean moveDownPressed = false;
	boolean moveRightPressed = false;
	boolean moveLeftPressed = false;
	
	//Animations
	private Animation animationDown;
	private Animation animationUp;
	private Animation animationLeft;
	private Animation animationRight;
	
	private Handler handler;
	
	public Player ( Handler handler , float x , float y ) {
		super ( handler , x , y , Creature.DEFAULT_CREATURE_WIDTH , Creature.DEFAULT_CREATURE_HEIGHT );
		this.handler = handler;
		
		bounds.x = 8;
		bounds.y = 16;
		bounds.width = 16;
		bounds.height = 16;
		
		animationDown = new Animation ( 300 , Assets.playerDown );
		animationUp = new Animation ( 300 , Assets.playerUp );
		animationLeft = new Animation ( 300 , Assets.playerLeft );
		animationRight = new Animation ( 300 , Assets.playerRight );
		
	}
	
	@Override
	public void update ( ) {
		
		animationDown.update ( );
		animationUp.update ( );
		animationLeft.update ( );
		animationRight.update ( );
		getInput ( );
		move ( );
		handler.getGameCamera ( ).centerOnEntity ( this );
		
	}
	
	private void getInput ( ) {
		xMove = 0;
		yMove = 0;
		
		//
		
		if ( moveLeftPressed )
		{
			xMove = -speed;
		}
		
		if ( moveRightPressed )
		{
			xMove = speed;
		}
		
		if ( moveUpPressed )
		{
			yMove = -speed;
			
		}
		if ( moveDownPressed )
		{
			yMove = speed;
		}
		
	}
	
	public void draw ( Graphics g ) {
		g.drawImage ( getCurrentAnimationFrame ( ) , ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null );
//				g.setColor ( Color.red ); // shows the bound box
//				g.fillRect ( ( int ) ( x + bounds.x - handler.getGameCamera ( ).getxOffset ( ) ) ,
//					( int ) ( y + bounds.y - handler.getGameCamera ( ).getyOffset ( ) ) , bounds.width ,
//					bounds.height );
		// uncomment above to see the bounds box
		// fills the bound box
	}
	
	private BufferedImage getCurrentAnimationFrame ( ) {
		if ( xMove < 0 )
		{
			return animationLeft.getCurrentFrame ( );
		} else if ( xMove > 0 )
		{
			return animationRight.getCurrentFrame ( );
		} else if ( yMove < 0 )
		{
			return animationUp.getCurrentFrame ( );
		} else
		{
			return animationDown.getCurrentFrame ( );
		}
		
	}
	
	public void move ( ) {
		if ( !checkEntityCollisions ( xMove , 0f ) )
			moveX ( );
		if ( !checkEntityCollisions ( 0f , yMove ) )
			moveY ( );
	}
	
	@Override
	public void moveUp ( ) {
		
		moveUpPressed = true;
		
	}
	
	@Override
	public void moveDown ( ) {
		
		moveDownPressed = true;
		
	}
	
	@Override
	public void moveLeft ( ) {
		
		moveLeftPressed = true;
		
	}
	
	@Override
	public void moveRight ( ) {
		
		moveRightPressed = true;
	}
	
	@Override
	public void moveUpReleased ( ) {
		
		moveUpPressed = false;
		
	}
	
	@Override
	public void moveDownReleased ( ) {
		
		moveDownPressed = false;
		
	}
	
	@Override
	public void moveLeftReleased ( ) {
		
		moveLeftPressed = false;
		
	}
	
	@Override
	public void moveRightReleased ( ) {
		
		moveRightPressed = false;
	}
	
}
