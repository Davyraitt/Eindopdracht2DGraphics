package Game;

import Entity.Entity;
import Tiles.Tile;

/**
 * GameCamera class
 * Controls the game camera
 *
 * @author Davy Raitt
 */

public class GameCamera {
	
	private float xOffset;
	private float yOffset;
	private Handler handler;
	
	// These offset variables are basicly numbers that tell us how far off we actually draw (add, substract)
	// something from its original position
	
	public GameCamera ( Handler handler , float xOffset , float yOffset ) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace ( ) { // checks for a blank space (the part of the map that doesnt contain anything)
		if ( xOffset < 0 )
		{ // left side
			xOffset = 0;
		} else if ( xOffset > handler.getWorld ( ).getWidth ( ) * Tile.tileWidth - handler.getWidth ( ) )
		{ // width of our world in pixels , minus the width of our window
			xOffset = handler.getWorld ( ).getWidth ( ) * Tile.tileWidth - handler.getWidth ( );
		}
		
		if ( yOffset < 0 )
		{ // top side
			yOffset = 0;
		} else if ( yOffset > handler.getWorld ( ).getHeight ( ) * Tile.tileHeight - handler.getHeight ( ) )
		{       // height of our world in pixels , minus the height of our window
			yOffset = handler.getWorld ( ).getHeight ( ) * Tile.tileHeight - handler.getHeight ( );
		}
		
	}
	
	public void move ( float xAmt , float yAmt ) { // amount we need to move
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace ( );
	}
	
	public void centerOnEntity ( Entity entity ) { // Here we can enter an entity, de game will be centered around
		// this entity. can be play/monster/anything else
		xOffset = entity.getX ( ) - handler.getWidth ( ) / 2 + entity.getWidth ( ) / 2; // divide by 2 so the
		// player gets centered on the X
		yOffset = entity.getY ( ) - handler.getHeight ( ) / 2 + entity.getHeight ( ) / 2; // divide by 2 so the
		// player gets centered on the Y
		
		checkBlankSpace ( );
		
	}
	
	//getters and setters and default methods
	
	public float getxOffset ( ) {
		return xOffset;
	}
	
	public void setxOffset ( float xOffset ) {
		this.xOffset = xOffset;
	}
	
	public float getyOffset ( ) {
		return yOffset;
	}
	
	public void setyOffset ( float yOffset ) {
		this.yOffset = yOffset;
	}
}
