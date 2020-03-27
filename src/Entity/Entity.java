package Entity;

// Entity class, all Entities (non tiles) extend this class.

import Game.Handler;

import java.awt.*;

/**
 * Main entity class
 *
 * @author Davy Raitt
 */

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	private static final int DEFAULT_HEALTH = 10; // entity has a default health of 10
	private int health;
	protected boolean active = true;
	
	public Entity ( Handler handler , float x , float y , int width , int height ) {
		
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle ( 0 , 0 , width , height );
		health = DEFAULT_HEALTH; // health is 10 (default)
	}
	
	protected boolean checkEntityCollisions ( float xOffset , float yOffset ) {
		
		handler.getWorld ( ).getEntityManagers ( );
		
		if ( handler.getLevel ( ) == 1 )
		{
			for ( Entity e : handler.getWorld ( ).getEntityManagerLevel1 ( ).getEntities ( ) ) // gets each
			// entity in level 1, and checks for intersection
			{
				if ( e.equals ( this ) ) // if the entity is itself, skip to the next
				{
					continue;
				}
				if ( e.getCollisionBounds ( 0f , 0f ).intersects ( getCollisionBounds ( xOffset ,
					yOffset ) ) ) // if the entity has collision, we return true (that is has)
				{
					return true;
				}
			}
			return false;
		}
		
		if ( handler.getLevel ( ) == 2 ) // gets each entity in level 2, and checks for intersection
		{
			for ( Entity e : handler.getWorld ( ).getEntityManagerLevel2 ( ).getEntities ( ) )
			{
				if ( e.equals ( this ) ) // if the entity is itself, skip to the next
				{
					continue;
				}
				if ( e.getCollisionBounds ( 0f , 0f ).intersects ( getCollisionBounds ( xOffset ,
					yOffset ) ) )
				{
					return true;
				}
			}
			return false;
		}
		
		if ( handler.getLevel ( ) == 3 )
		{
			for ( Entity e : handler.getWorld ( ).getEntityManagerLevel3 ( ).getEntities ( ) ) // gets each
			// entity in level 3, and checks for intersection
			{
				if ( e.equals ( this ) ) // if the entity is itself, skip to the next
				{
					continue;
				}
				if ( e.getCollisionBounds ( 0f , 0f ).intersects ( getCollisionBounds ( xOffset ,
					yOffset ) ) )
				{
					return true;
				}
			}
			return false;
		}
		
		return false;
	}
	
	public Rectangle getCollisionBounds ( float xOffset , float yOffset ) { // getter for our collisionbounds
		return new Rectangle ( ( int ) ( x + bounds.x + xOffset ) , ( int ) ( y + bounds.y + yOffset ) ,
			bounds.width , bounds.height );
	}
	
	public void hurt ( int amount ) { // we can hurt a entity, the given amount hurts it
		health = health - amount;
		
		if ( health <= 0 )
		{
			active = false; // if this boolean is false, the Entitymanager doesnt render it
			die ( );
		}
	}
	
	//getters and setters and default methods
	
	protected abstract void die ( );
	
	public abstract void update ( );
	
	public abstract void draw ( Graphics g );
	
	public abstract void moveUp ( );
	
	public abstract void moveDown ( );
	
	public abstract void moveLeft ( );
	
	public abstract void moveRight ( );
	
	public abstract void moveUpReleased ( );
	
	public abstract void moveDownReleased ( );
	
	public abstract void moveLeftReleased ( );
	
	public abstract void moveRightReleased ( );
	
	public float getX ( ) {
		return x;
	}
	
	public void setX ( float x ) {
		this.x = x;
	}
	
	public float getY ( ) {
		return y;
	}
	
	public void setY ( float y ) {
		this.y = y;
	}
	
	public int getWidth ( ) {
		return width;
	}
	
	public void setWidth ( int width ) {
		this.width = width;
	}
	
	public int getHeight ( ) {
		return height;
	}
	
	public void setHeight ( int height ) {
		this.height = height;
	}
	
	public int getHealth ( ) {
		return health;
	}
	
	public void setHealth ( int health ) {
		this.health = health;
	}
	
	public boolean isActive ( ) {
		return active;
	}
	
	public void setActive ( boolean active ) {
		this.active = active;
	}
}
