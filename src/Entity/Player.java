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
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
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
		g.setColor ( Color.red ); // shows the bound box
		g.fillRect ((int) (x + bounds.x - handler.getGameCamera ().getxOffset ()) , (int) ( y + bounds.y - handler.getGameCamera ().getyOffset ()), bounds.width, bounds.height);
		// fills the bound box
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
