package Game;

import Entity.Entity;

public class GameCamera {
	
	private float xOffset;
	private float yOffset;
	private Game game;
	
	
	// These offset variables are basicly numbers that tell us how far off we actually draw (add, substract) something from its original position
	
	public GameCamera (Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	
	public void centerOnEntity ( Entity entity) { // Here we can enter an entity, de game will be centered around this entity. can be play/monster/anything else
		xOffset = entity.getX ( ) - game.getWidth () / 2 + entity.getWidth () / 2; // divide by 2 so the player gets centered on the X
		yOffset = entity.getY() - game.getHeight() / 2 + entity.getHeight() / 2; // divide by 2 so the player gets centered on the Y
		
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
