package Entity.Creature;

import Entity.Entity;
import Game.Game;
import Game.Handler;
import Tiles.Tile;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;

public class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32;
	public static final int DEFAULT_CREATURE_HEIGHT = 32;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature ( Handler handler, float x , float y , int width , int height ) {
		super (handler,  x , y , width , height );
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	@Override
	public void update ( ) {
	
	}
	
	public void move ( ) {
		moveX ();
		moveY ();
		
		
	}
	
	public void moveX () {
		if (xMove > 0) {
			int tx = (int) ( x + xMove + bounds.x + bounds.width) / Tile.tileWidth;
			
			if (!colissionWidthTile ( tx, (int) (y + bounds.y) / Tile.tileHeight )) {
				x += xMove;
			}
			
			
		} // we are moving right
		
		else if (xMove < 0) {
			x += xMove;
		} // we are moving left
		
	
	}
	
	public void moveY () {
		y += yMove;
	}
	
	protected boolean colissionWidthTile (int x, int y) {
		return handler.getWorld ().getTile ( x,y  ).isSolid ();
	}
	
	
	public int getHealth ( ) {
		return health;
	}
	
	public void setHealth ( int health ) {
		this.health = health;
	}
	
	public float getSpeed ( ) {
		return speed;
	}
	
	public void setSpeed ( float speed ) {
		this.speed = speed;
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
	
	public float getxMove ( ) {
		return xMove;
	}
	
	public void setxMove ( float xMove ) {
		this.xMove = xMove;
	}
	
	public float getyMove ( ) {
		return yMove;
	}
	
	public void setyMove ( float yMove ) {
		this.yMove = yMove;
	}
}
