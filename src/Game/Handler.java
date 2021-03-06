package Game;

import World.World;

/**
 * Handler class
 * // The handler class is a simple class that allows us to pass along a bunch of variables when we want to.
 *
 * @author Davy Raitt
 */

public class Handler {
	
	private Game game;
	private World world;
	private int Currentlevel;
	
	public Handler ( Game game ) {
		this.game = game;
	}
	
	//getters and setters and default methods
	
	public void setSpeed ( int level ) {
	
	}
	
	public void setLevel ( int level ) {
		game.getGameState ( ).setCurrentLevel ( level );
		world.setCurrentLevel ( level );
		this.Currentlevel = level;
	}
	
	public int getCurrentlevel ( ) {
		return Currentlevel;
	}
	
	public int getLevel ( ) {
		return game.getGameState ( ).getCurrentLevel ( );
	}
	
	public int getWidth ( ) {
		
		return game.getWidth ( ); // getter for the width of the game, gets the width from the main game method
		// getter
	}
	
	public int getHeight ( ) {
		return game.getHeight ( ); // getter for the height of the game, gets the height from the main game
		// method getter
	}
	
	public GameCamera getGameCamera ( ) {
		return game.getGameCamera ( ); // getter for the camera of the game, gets the camera from the main game
		// method getter
	}
	
	public Game getGame ( ) {
		return game;
	}
	
	public void setGame ( Game game ) {
		this.game = game;
	}
	
	public World getWorld ( ) {
		return world;
	}
	
	public void setWorld ( World world ) {
		this.world = world;
	}
}
