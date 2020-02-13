package Entity.Creature;

import Entity.Entity;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;

public class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature ( float x , float y , int width , int height ) {
		super ( x , y , width , height );
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	@Override
	public void update ( ) {
	
	}
	
	public void move ( ) {
		x += xMove;
		y += yMove;
		
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
