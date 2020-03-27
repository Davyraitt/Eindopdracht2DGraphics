package States;

import Game.Handler;
import World.World;
import org.jfree.fx.FXGraphics2D;

import java.io.*;

/**
 * Gamestate class
 * Our game exists of states, for example: If we are in the gamestate, the game is playing, if we are in the
 * MenuState, the game is in the Menu (paused)
 *
 * @author Davy Raitt
 */

public class GameState extends State {
	
	private World world;
	private World world2;
	private World world3;
	private World world4;
	private int currentLevel;
	
	public GameState ( Handler handler ) {
		super ( handler );
		world = new World ( handler , "Resources/WorldFiles/World1.txt" ); // creates world 1
		world2 = new World ( handler , "Resources/WorldFiles/World2.txt" );  // creates world 2
		world3 = new World ( handler , "Resources/WorldFiles/World3.txt" ); // creates world 3
		generateRandomWorld ( ); // generates the random world
		world4 = new World ( handler , "Resources/WorldFiles/World4.txt" ); // creates world 4
		handler.setWorld ( world ); // startworld is world 1
		currentLevel = 1; // keeps track of the current level
		
	}
	
	private void generateRandomWorld ( ) { // generates a random world for lever 4, fills the text file with random
		// tiles
		try
		{
			FileOutputStream f = new FileOutputStream ( new File ( "Resources/WorldFiles/World4.txt" ) );
			
			FileWriter fileWriter = new FileWriter ( "Resources/WorldFiles/World4.txt" , false );
			
			fileWriter.flush ( );
			fileWriter.write ( "20 20" );
			fileWriter.write ( "\n" );
			
			fileWriter.write ( "30 70" );
			fileWriter.write ( "\n" );
			
			for ( int i = 0 ; i < 20 ; i++ )
			{
				fileWriter.write ( "1 " );
			}
			
			fileWriter.write ( "\n" );
			
			for ( int i = 0 ; i < 20 ; i++ )
			{
				fileWriter.write ( "1 " );
			}
			
			fileWriter.write ( "\n" );
			fileWriter.write ( "1 21 1 22 1 23 1 24 1 25 1 1 1 1 1 1 1 1 1 1" );
			
			fileWriter.write ( "\n" );
			
			for ( int i = 0 ; i < 20 ; i++ )
			{
				fileWriter.write ( "2 " );
			}
			
			for ( int i = 0 ; i < 16 ; i++ )
			{
				fileWriter.write ( "\n" );
				for ( int y = 0 ; y < 20 ; y++ )
				{
					double randomNumber = ( Math.random ( ) * ( ( 6 - 0 ) + 1 ) ) + 0;
					int rN = ( int ) randomNumber;
					fileWriter.write ( String.valueOf ( rN ) + " " );
				}
			}
			
			fileWriter.close ( );
			
			f.close ( );
		} catch ( IOException e )
		{
			e.printStackTrace ( );
		}
		
	}
	
	@Override
	public void draw ( FXGraphics2D graphics ) { // draws the worlds.. based on the currentlevel
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
			case 4:
				handler.getWorld ( ).setCurrentLevel ( 4 );
				handler.setWorld ( world4 );
				world4.draw ( graphics );
				break;
		}
		
	}
	
	@Override
	public void update ( double deltaTime ) {  // updates the worlds.. based on the currentlevel
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
			
			case 4:
				handler.setWorld ( world4 );
				world4.update ( );
				break;
		}
		
	}
	
	// move commands for the player
	
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
			case 4:
				world4.moveUp ( );
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
			case 4:
				world4.moveDown ( );
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
			case 4:
				world4.moveRight ( );
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
			case 4:
				world4.moveLeft ( );
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
			case 4:
				world4.moveUpReleased ( );
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
			case 4:
				world4.moveDownReleased ( );
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
			case 4:
				world4.moveRightReleased ( );
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
			case 4:
				world4.moveLeftReleased ( );
				break;
		}
	}
	
	@Override
	public void setSpeed ( float speed ) {
		switch ( currentLevel )
		{
			case 1:
				world.setSpeed ( speed );
				break;
			case 2:
				world2.setSpeed ( speed );
				break;
			case 3:
				world3.setSpeed ( speed );
				break;
			case 4:
				world4.setSpeed ( speed );
				break;
		}
	}
	
	// attack moves for the player
	
	@Override
	public void attack ( ) {
		switch ( currentLevel )
		{
			case 1:
				world.attack ( );
				break;
			case 2:
				world2.attack ( );
				break;
			case 3:
				world3.attack ( );
				break;
			case 4:
				world4.attack ( );
				break;
		}
	}
	
	// getters and setters
	
	@Override
	public void setCurrentLevel ( int newLevel ) {
		this.currentLevel = newLevel;
	}
	
	@Override
	public int getCurrentLevel ( ) {
		return this.currentLevel;
	}
	
}
