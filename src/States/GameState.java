package States;

import Game.Handler;
import World.World;
import org.jfree.fx.FXGraphics2D;

public class GameState extends State {
	
	private World world;
	private World world2;
	private World world3;
	private int currentLevel;
	
	public GameState ( Handler handler ) {
		super ( handler );
		world = new World ( handler , "Resources/WorldFiles/World1.txt" );
		world2 = new World ( handler , "Resources/WorldFiles/World2.txt" );
		world3 = new World ( handler , "Resources/WorldFiles/World3.txt" );
		handler.setWorld ( world );
		currentLevel = 1;
		
	}
	
	@Override
	public void draw ( FXGraphics2D graphics ) {
		switch ( currentLevel )
		{
			case 1:
				handler.getWorld ( ).setCurrentLevel ( 1 );
				handler.setWorld ( world2 );
				world.draw ( graphics );
				break;
			case 2:
				handler.getWorld ( ).setCurrentLevel ( 2 );
				handler.setWorld ( world2 );
				world2.draw ( graphics );
				break;
			case 3:
				handler.getWorld ( ).setCurrentLevel ( 3 );
				handler.setWorld ( world3 );
				world3.draw ( graphics );
				break;
		}
		
	}
	
	@Override
	public void update ( double deltaTime ) {
		switch ( currentLevel )
		{
			case 1:
				handler.setWorld ( world );
				world.update ( );
				break;
			case 2:
				handler.setWorld ( world2 );
				world2.update ( );
				break;
			case 3:
				handler.setWorld ( world3 );
				world3.update ( );
				break;
		}
		
	}
	
	@Override
	public void moveUp ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveUp ( );
				break;
			case 2:
				world2.moveUp ( );
				break;
			case 3:
				world3.moveUp ( );
				break;
		}
	}
	
	@Override
	public void moveDown ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveDown ( );
				break;
			case 2:
				world2.moveDown ( );
				break;
			case 3:
				world3.moveDown ( );
				break;
		}
	}
	
	@Override
	public void moveRight ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveRight ( );
				break;
			case 2:
				world2.moveRight ( );
				break;
			case 3:
				world3.moveRight ( );
				break;
		}
	}
	
	@Override
	public void moveLeft ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveLeft ( );
				break;
			case 2:
				world2.moveLeft ( );
				break;
			case 3:
				world3.moveLeft ( );
				break;
		}
	}
	
	@Override
	public void moveUpReleased ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveUpReleased ( );
				break;
			case 2:
				world2.moveUpReleased ( );
				break;
			case 3:
				world3.moveUpReleased ( );
				break;
		}
	}
	
	@Override
	public void moveDownReleased ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveDownReleased ( );
				break;
			case 2:
				world2.moveDownReleased ( );
				break;
			case 3:
				world3.moveDownReleased ( );
				break;
		}
	}
	
	@Override
	public void moveRightReleased ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveRightReleased ( );
				break;
			case 2:
				world2.moveRightReleased ( );
				break;
			case 3:
				world3.moveRightReleased ( );
				break;
		}
	}
	
	@Override
	public void moveLeftReleased ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.moveLeftReleased ( );
				break;
			case 2:
				world2.moveLeftReleased ( );
				break;
			case 3:
				world3.moveLeftReleased ( );
				break;
		}
	}
	
	@Override
	public void setCurrentLevel ( int newLevel ) {
		this.currentLevel = newLevel;
	}
	
	@Override
	public int getCurrentLevel ( ) {
		return this.currentLevel;
	}
	
}
