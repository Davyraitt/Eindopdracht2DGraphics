package Entity;

import Entity.Creature.Creature;
import Game.Game;
import Tools.Assets;
import Game.Handler;

import java.awt.*;

public class Player extends Creature {
	
	private Handler handler;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.handler = handler;
	}
	
	
	@Override
	public void update (  ) {
		getInput ();
		move ();
		handler.getGameCamera ().centerOnEntity ( this );
	
	}
	
	private void getInput () {
		xMove = 0;
		yMove = 0;
	}
	
	
	
	public void draw ( Graphics g ) {
		g.drawImage(Assets.playertile, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
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
