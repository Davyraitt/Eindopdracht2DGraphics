package Entity;

import Entity.Creature.Creature;
import Game.Game;
import Tiles.Tile;
import Tools.Animation;
import Tools.Assets;
import Game.Handler;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */

public class Player extends Creature {
	
	//Walking booleans
	private boolean moveUpPressed = false;
	private boolean moveDownPressed = false;
	private boolean moveRightPressed = false;
	private boolean moveLeftPressed = false;
	
	//Animations
	private Animation animationDown;
	private Animation animationUp;
	private Animation animationLeft;
	private Animation animationRight;
	public static Rectangle2D boundsBox;
	
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
		boundsBox = new Rectangle2D.Double ( ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height );
		
		animationDown.update ( );
		animationUp.update ( );
		animationLeft.update ( );
		animationRight.update ( );
		getInput ( );
		move ( );
		handler.getGameCamera ( ).centerOnEntity ( this );
		
		//Attack
		checkAttacks ( );
		
	}
	
	private void checkAttacks ( ) {
		int attackRangeSize = 20;
		Rectangle2D collisionBounds =
			new Rectangle2D.Double ( ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
				( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height );
		Rectangle2D attackRange = new Rectangle2D.Double ( 0 , 0 , attackRangeSize , attackRangeSize );
		
	}
	
	protected void die ( ) {
		System.out.println ( "Oh dear, you are dead!" );
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
		
		//g.drawRect((int)boundsBox.getX(), (int)boundsBox.getY(), (int)boundsBox.getWidth(), (int)boundsBox
		// .getHeight()); draws the boundbox
		
		//boundsbox
		
		//				g.setColor ( Color.red ); // shows the bound box
		//				g.fillRect ( ( int ) ( x + bounds.x - handler.getGameCamera ( ).getxOffset (
		//				) ) ,
		//					( int ) ( y + bounds.y - handler.getGameCamera ( ).getyOffset ( ) ) ,
		//					bounds.width ,
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
	
	public void setSpeed ( float newSpeed ) {
		speed = newSpeed;
	}
	
	public void attack ( ) {
		System.out.println ( "attacking..." );
	}
}
