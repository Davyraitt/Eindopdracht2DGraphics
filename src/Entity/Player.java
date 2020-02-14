package Entity;

import Entity.Creature.Creature;
import Game.Game;
import Tools.Assets;


import java.awt.*;

public class Player extends Creature {
	
	public Player ( Game game, float x , float y ) {
		super ( game, x , y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT );
	}
	
	
	@Override
	public void update (  ) {
		getInput ();
	
	}
	
	private void getInput () {
		xMove = 0;
		yMove = 0;
	}
	
	
	
	public void draw ( Graphics g ) {
		g.drawImage ( Assets.playertile, (int)x ,(int)y, width, height, null );
	}

	@Override
	public void moveUp() {
		y = y - 32;
	}

	@Override
	public void moveDown() {
		y = y + 32;
	}

	@Override
	public void moveLeft() {
		x = x - 32;
	}

	@Override
	public void moveRight() {
		x = x + 32;
	}


	
	
	
	
}
