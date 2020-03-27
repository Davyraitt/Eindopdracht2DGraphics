package States;

import Game.Game;
import org.jfree.fx.FXGraphics2D;
import Game.Handler;

/**
 * State class
 * Our game exists of states, for example: If we are in the gamestate, the game is playing, if we are in the
 * MenuState, the game is in the Menu (paused)
 *
 * @author Davy Raitt
 */

public abstract class State {
	
	protected Handler handler;
	
	public State ( Handler handler ) {
		this.handler = handler;
	}
	
	private static State currentState = null;
	
	public static State getState ( ) {
		return currentState;
	}
	
	public static void setState ( State state ) {
		State.currentState = state;
	}
	
	//MUST IMPLEMENT
	
	public abstract void draw ( FXGraphics2D graphics );
	
	public abstract void update ( double deltaTime );
	
	public abstract void moveUp ( );
	
	public abstract void setCurrentLevel ( int newLevel );
	
	public abstract int getCurrentLevel ( );
	
	public abstract void moveDown ( );
	
	public abstract void moveRight ( );
	
	public abstract void moveLeft ( );
	
	public abstract void moveUpReleased ( );
	
	public abstract void moveDownReleased ( );
	
	public abstract void moveRightReleased ( );
	
	public abstract void moveLeftReleased ( );
	
	public abstract void setSpeed ( float speed );
	
	public abstract void attack ( );
	
}
