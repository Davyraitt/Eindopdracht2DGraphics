package States;

import Game.Game;
import Game.Handler;
import org.jfree.fx.FXGraphics2D;

/**
 * SettingsState class
 * Our game exists of states, for example: If we are in the gamestate, the game is playing, if we are in the
 * MenuState, the game is in the Menu (paused)
 *
 * @author Davy Raitt
 */
public class SettingsState extends State {
	public SettingsState ( Handler handler ) {
		super ( handler );
	}
	
	@Override
	public void draw ( FXGraphics2D graphics ) {
	
	}
	
	@Override
	public void update ( double deltaTime ) {
	
	}
	
	@Override
	public void moveUp ( ) {
	
	}
	
	@Override
	public void setCurrentLevel ( int newLevel ) {
	
	}
	
	@Override
	public int getCurrentLevel ( ) {
		return 0;
	}
	
	@Override
	public void moveDown ( ) {
	
	}
	
	@Override
	public void moveRight ( ) {
	
	}
	
	@Override
	public void moveLeft ( ) {
	
	}
	
	@Override
	public void moveUpReleased ( ) {
	
	}
	
	@Override
	public void moveDownReleased ( ) {
	
	}
	
	@Override
	public void moveRightReleased ( ) {
	
	}
	
	@Override
	public void moveLeftReleased ( ) {
	
	}
	
	@Override
	public void setSpeed ( float speed ) {
	
	}
	
	@Override
	public void attack ( ) {
	
	}
	
}
