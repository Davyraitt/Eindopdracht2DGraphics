package Entity;

// Entity class, all Entities (non tiles) extend this class.

import java.awt.*;

public abstract class Entity {
	
	protected float x,y;
	
	public Entity ( float x , float y ) {
		this.x = x;
		this.y = y;
	}
	
	
	public abstract void update ();
	
	public abstract void draw ( Graphics g);

	public abstract void moveUp ();

	public abstract void moveDown ();

	public abstract void moveLeft ();

	public abstract void moveRight ();
	
}
