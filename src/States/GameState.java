package States;

import Entity.Player;
import Entity.Statics.Tree;
import Game.Game;
import Game.Handler;
import World.World;
import org.jfree.fx.FXGraphics2D;

public class GameState extends State {
	
	private Player player;
	private World world;
	private Tree tree;
	
	public GameState ( Handler handler ) {
		super ( handler );
		world = new World ( handler , "Resources/WorldFiles/World1.txt" );
		handler.setWorld ( world );
		
		
	}
	
	@Override
	public void draw ( FXGraphics2D graphics ) {
		
		world.draw ( graphics );
		
		
	}
	
	@Override
	public void update ( double deltaTime ) {
		world.update ( );
		
		
	}
	
	@Override
	public void moveUp ( ) {
		world.moveUp ( );
	}
	
	@Override
	public void moveDown ( ) {
		world.moveDown ( );
	}
	
	@Override
	public void moveRight ( ) {
		world.moveRight ( );
	}
	
	@Override
	public void moveLeft ( ) {
		world.moveLeft ( );
	}
	
	@Override
	public void moveUpReleased ( ) {
		world.moveUpReleased ( );
	}
	
	@Override
	public void moveDownReleased ( ) {
		world.moveDownReleased ( );
	}
	
	@Override
	public void moveRightReleased ( ) {
		world.moveRightReleased ( );
	}
	
	@Override
	public void moveLeftReleased ( ) {
		world.moveLeftReleased ( );
	}
	
}
