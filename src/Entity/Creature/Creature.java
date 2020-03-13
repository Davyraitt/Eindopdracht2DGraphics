package Entity.Creature;

import Entity.Entity;
import Game.Game;
import Game.Handler;
import Tiles.Tile;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */

public class Creature extends Entity {
	
	 // Default health of a Creature is 10
	public static final float DEFAULT_SPEED = 1.0f; // Default speed of a Creature is 1.0f
	public static final int DEFAULT_CREATURE_WIDTH = 32; // Default Width of a creature is 32 px
	public static final int DEFAULT_CREATURE_HEIGHT = 32; // Default height of a creature is 32 px
	
	// this variabel will be defined in the constructor later on
	protected float speed; // this variabel will be defined in the constructor later on
	protected float xMove, yMove; // this variabel will be defined in the constructor later on
	
	public Creature ( Handler handler , float x , float y , int width , int height ) { // When I create a creature,
		// these are the variables
		super ( handler , x , y , width , height ); // gets these variables from the super (entity)
		
		speed = DEFAULT_SPEED; // speed is 1.0f (default)
		xMove = 0;
		yMove = 0;
	}
	
	@Override
	protected void die ( ) {
	
	}
	
	@Override
	public void update ( ) { // Update funtion, the class has a draw () method and update () method. In update we
		// should keep track of all the variables, in draw() we should draw them
		
	}
	
	public void move ( ) {
		if ( !checkEntityCollisions ( xMove , 0f ) ) // if there is no entity collisions, we can move the X
			// coordinate (left or right)
			moveX ( );
		if ( !checkEntityCollisions ( 0f , yMove ) ) // if there is no entity collisions, we can move the y
			// coordinate (top or bottom)
			moveY ( );
	}
	
	public void moveX ( ) {
		if ( xMove > 0 )
		{//Moving right
			int tx = ( int ) ( x + xMove + bounds.x + bounds.width ) / Tile.tileWidth;
			
			if ( !collisionWithTile ( tx , ( int ) ( y + bounds.y ) / Tile.tileHeight ) && !collisionWithTile ( tx , ( int ) ( y + bounds.y + bounds.height ) / Tile.tileHeight ) )
			{
				x += xMove;
			} else
			{
				x = tx * Tile.tileWidth - bounds.x - bounds.width - 1;
			}
			
		} else if ( xMove < 0 )
		{//Moving left
			int tx = ( int ) ( x + xMove + bounds.x ) / Tile.tileWidth;
			
			if ( !collisionWithTile ( tx , ( int ) ( y + bounds.y ) / Tile.tileHeight ) && !collisionWithTile ( tx , ( int ) ( y + bounds.y + bounds.height ) / Tile.tileHeight ) )
			{
				x += xMove;
			} else
			{
				x = tx * Tile.tileWidth + Tile.tileWidth - bounds.x;
			}
			
		}
	}
	
	public void moveY ( ) {
		if ( yMove < 0 )
		{//Up
			int ty = ( int ) ( y + yMove + bounds.y ) / Tile.tileHeight;
			
			if ( !collisionWithTile ( ( int ) ( x + bounds.x ) / Tile.tileWidth , ty ) && !collisionWithTile ( ( int ) ( x + bounds.x + bounds.width ) / Tile.tileWidth , ty ) )
			{
				y += yMove;
			} else
			{
				y = ty * Tile.tileHeight + Tile.tileHeight - bounds.y;
			}
			
		} else if ( yMove > 0 )
		{//Down
			int ty = ( int ) ( y + yMove + bounds.y + bounds.height ) / Tile.tileHeight;
			
			if ( !collisionWithTile ( ( int ) ( x + bounds.x ) / Tile.tileWidth , ty ) && !collisionWithTile ( ( int ) ( x + bounds.x + bounds.width ) / Tile.tileWidth , ty ) )
			{
				y += yMove;
			} else
			{
				y = ty * Tile.tileHeight - bounds.y - bounds.height - 1;
			}
			
		}
	}
	
	protected boolean collisionWithTile ( int x , int y ) {
		
		return handler.getWorld ( ).getTile ( x , y ).isSolid ( );
		
	}
	
	public void draw ( Graphics g ) {
	
	}
	
	@Override
	public void moveUp ( ) {
	
	}
	
	@Override
	public void moveDown ( ) {
	
	}
	
	@Override
	public void moveLeft ( ) {
	
	}
	
	@Override
	public void moveRight ( ) {
	
	}
	
	@Override
	public void moveUpReleased ( ) {
	
	}
	
	@Override
	public void moveDownReleased ( ) {
	
	}
	
	@Override
	public void moveLeftReleased ( ) {
	
	}
	
	@Override
	public void moveRightReleased ( ) {
	
	}
	
}
