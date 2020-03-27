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
 * Player class
 * extends Creature
 * contains all the code of our player
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
	
	//boundsbox
	public static Rectangle2D boundsBox;
	
	//attacking
	private Boolean attackPressed = false;
	
	//creates a handler object
	private Handler handler;
	
	//boundsbox for our attackrange
	private Rectangle2D attackRange = new Rectangle2D.Double ( 0 , 0 , 20 , 20 );
	
	public Player ( Handler handler , float x , float y ) {
		super ( handler , x , y , Creature.DEFAULT_CREATURE_WIDTH , Creature.DEFAULT_CREATURE_HEIGHT );
		this.handler = handler;
		
		bounds.x = 8; //boundsbox/collisionbox for our player
		bounds.y = 16;  //boundsbox/collisionbox for our player
		bounds.width = 16;  //boundsbox/collisionbox for our player
		bounds.height = 16;  //boundsbox/collisionbox for our player
		
		animationDown = new Animation ( 300 , Assets.playerDown ); //creates a new animation for walking down
		animationUp = new Animation ( 300 , Assets.playerUp ); //creates a new animation for walking up
		animationLeft = new Animation ( 300 , Assets.playerLeft ); //creates a new animation for walking left
		animationRight = new Animation ( 300 , Assets.playerRight ); //creates a new animation for walking right
		
	}
	
	@Override
	public void update ( ) {
		boundsBox = new Rectangle2D.Double ( ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height ); // constantly
		// updates the boundsbox
		
		animationDown.update ( );
		animationUp.update ( );
		animationLeft.update ( );
		animationRight.update ( );
		getInput ( ); // gets the input from keyboard
		move ( ); //moves the player
		handler.getGameCamera ( ).centerOnEntity ( this ); // center on the player again
		
		//Attack
		
	}
	
	protected void die ( ) {
		System.out.println ( "Oh dear, you are dead!" );
	} // if the player dies we print this
	
	private void getInput ( ) {
		xMove = 0; // resets the xmove
		yMove = 0;  // resets the ymove
		
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
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null ); // method for
		// drawing the player
		
		if ( attackPressed ) // creates the attack animation
		{
			double randomNumber = ( Math.random ( ) * ( ( 3 - 0 ) + 1 ) ) + 0;
			int rN = ( int ) randomNumber;
			
			g.drawImage ( Assets.swords.get ( rN ) , ( int ) attackRange.getX ( ) ,
				( int ) attackRange.getY ( ) , ( int ) attackRange.getWidth ( ) ,
				( int ) attackRange.getHeight ( ) , null );
			attackPressed = false;
		}
		
		//draw the attackrectangle
		//		g.setColor ( Color.red );
		//		g.drawRect ( ( int ) attackRange.getX ( ) , ( int ) attackRange.getY ( ) ,
		//			( int ) attackRange.getWidth ( ) , ( int ) attackRange.getHeight ( ) );
		
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
		if ( !checkEntityCollisions ( xMove , 0f ) ) // if there is no collision, we can move
			moveX ( );
		if ( !checkEntityCollisions ( 0f , yMove ) ) // if there is no collision, we can move
			moveY ( );
	}
	
	public void attack ( ) { // attack method, with this method we can attack other entities
		attackPressed = true;
		
		int attackRangeSize = 15; // the range of our attack
		Rectangle2D collisionBounds =
			new Rectangle2D.Double ( ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
				( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height ); // creates
		// our collisionbounds rectangle
		
		int newX =
			( int ) ( ( ( Rectangle2D.Double ) collisionBounds ).x + ( ( Rectangle2D.Double ) collisionBounds ).width / 2 - attackRangeSize / 2 );
		int newY =
			( int ) ( ( ( Rectangle2D.Double ) collisionBounds ).y + ( ( Rectangle2D.Double ) collisionBounds ).height );
		
		attackRange = new Rectangle2D.Double ( newX , newY , attackRangeSize , attackRangeSize ); // creates a
		// new attackrange rectangle
		
		//attacking downwards
		
		for ( Entity entity : handler.getWorld ( ).getEntityManagerLevel1 ( ).getEntities ( ) ) //sorts trough
		// each entity on this world 1
		{
			if ( entity.equals ( this ) ) // if the entity is itself we can skip it
			{
				continue;
			}
			
			if ( entity.getCollisionBounds ( 0 , 0 ).contains ( attackRange ) ) // if the entity is someone
			// else, and is in our attackrange, we hurt it
			{
				entity.hurt ( 5 );
				System.out.println ( "Hurt it!" );
			}
			
		}
		
		for ( Entity entity : handler.getWorld ( ).getEntityManagerLevel2 ( ).getEntities ( ) )
		{
			if ( entity.equals ( this ) )
				if ( entity.getCollisionBounds ( 0 , 0 ).contains ( attackRange ) )
				{
					entity.hurt ( 5 );
					System.out.println ( "Hurt it!" );
				}
			
		}
		
		for ( Entity entity : handler.getWorld ( ).getEntityManagerLevel3 ( ).getEntities ( ) )
		{
			if ( entity.equals ( this ) )
			{
				continue;
			}
			if ( entity.getCollisionBounds ( 0 , 0 ).contains ( attackRange ) )
			{
				entity.hurt ( 5 );
				System.out.println ( "Hurt it!" );
			}
		}
		
	}
	
	//getters and setters and default methods
	
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
	
}
