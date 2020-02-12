package Entity;

import Entity.Creature.Creature;
import Tools.Assets;

import java.awt.*;

public class Player extends Creature {
	
	public Player ( float x , float y ) {
		super ( x , y );
	}
	
	
	public void update ( ) {

	}
	
	
	public void draw ( Graphics g ) {
		g.drawImage ( Assets.playertile, (int)x ,(int)y, null );
	}

	@Override
	public void moveUp() {
		y = y - 2;
	}

	@Override
	public void moveDown() {
		y = y + 2;
	}

	@Override
	public void moveLeft() {
		x = x - 2;
	}

	@Override
	public void moveRight() {
		x = x + 2;
	}


	
	
	
	
}
