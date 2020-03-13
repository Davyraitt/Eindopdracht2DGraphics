package Game;

import Entity.Entity;
import Tiles.Tile;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */


public class GameCamera {
	
	private float xOffset;
	private float yOffset;
	private Handler handler;
	
	
	// These offset variables are basicly numbers that tell us how far off we actually draw (add, substract) something from its original position
	
	public GameCamera (Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	
	public void checkBlankSpace () {
		if (xOffset < 0) {
			xOffset = 0;
		}
		
		else if (xOffset > handler.getWorld ().getWidth () * Tile.tileWidth - handler.getWidth ()) {
			xOffset = handler.getWorld ().getWidth () * Tile.tileWidth - handler.getWidth ();
		}
		
		if (yOffset < 0) {
			yOffset = 0;
		}
		
		else if (yOffset > handler.getWorld ().getHeight () * Tile.tileHeight - handler.getHeight ()) {
			yOffset = handler.getWorld ().getHeight () * Tile.tileHeight - handler.getHeight ();
		}
		
	}
	
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace ();
	}
	
	
	public void centerOnEntity ( Entity entity) { // Here we can enter an entity, de game will be centered around this entity. can be play/monster/anything else
		xOffset = entity.getX ( ) - handler.getWidth () / 2 + entity.getWidth () / 2; // divide by 2 so the player gets centered on the X
		yOffset = entity.getY() - handler.getHeight() / 2 + entity.getHeight() / 2; // divide by 2 so the player gets centered on the Y
		
		checkBlankSpace ();
		
	}
	
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
