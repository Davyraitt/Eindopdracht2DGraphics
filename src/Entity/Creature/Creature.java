package Entity.Creature;

import Entity.Entity;

import java.awt.*;

public class Creature extends Entity {
	
	protected int health;
	
	public Creature ( float x , float y ) {
		super ( x , y );
		health = 10;
	}
	
	
	public void update ( ) {
	
	}


	public void draw ( Graphics g ) {
	
	}

	@Override
	public void moveUp() {

	}

	@Override
	public void moveDown() {

	}

	@Override
	public void moveLeft() {

	}

	@Override
	public void moveRight() {

	}
}
