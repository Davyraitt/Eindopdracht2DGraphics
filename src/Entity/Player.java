package Entity;

import Entity.Creature.Creature;
import Game.Game;
import Tiles.Tile;
import Tools.Assets;
import Game.Handler;

import java.awt.*;

public class Player extends Creature {
	
	boolean moveUpPressed = false;
	boolean moveDownPressed = false;
	boolean moveRightPressed = false;
	boolean moveLeftPressed = false;
	
	private Handler handler;
	
	public Player ( Handler handler , float x , float y ) {
		super ( handler , x , y , Creature.DEFAULT_CREATURE_WIDTH , Creature.DEFAULT_CREATURE_HEIGHT );
		this.handler = handler;
		
		bounds.x = 0;
		bounds.y = 12;
		bounds.width = 32;
		bounds.height = 20;
	}
	
	@Override
	public void update ( ) {
		getInput ( );
		move ( );
		handler.getGameCamera ( ).centerOnEntity ( this );
		
	}
	
	private void getInput ( ) {
		xMove = 0;
		yMove = 0;
		
		if ( moveUpPressed )
		{
			yMove = -speed;
			moveUpPressed = false;
		}
		if ( moveDownPressed )
		{
			yMove = speed;
			moveDownPressed = false;
		}
		if ( moveLeftPressed )
		{
			xMove = -speed;
			moveLeftPressed = false;
		}
	
		if ( moveRightPressed )
		{
			xMove = speed;
			moveRightPressed = false;
		}
	}
	
	public void draw ( Graphics g ) {
		g.drawImage ( Assets.playertile , ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null );
//		g.setColor ( Color.red ); // shows the bound box
//		g.fillRect ( ( int ) ( x + bounds.x - handler.getGameCamera ( ).getxOffset ( ) ) ,
//			( int ) ( y + bounds.y - handler.getGameCamera ( ).getyOffset ( ) ) , bounds.width ,
//			bounds.height );
		// uncomment above to see the bounds box
		// fills the bound box
	}
	
	public void move ( ) {
		moveX ( );
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
	
}
