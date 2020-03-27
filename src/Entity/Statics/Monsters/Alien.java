package Entity.Statics.Monsters;

import Entity.Statics.StaticEntity;
import Game.Handler;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;

/**
 * Class for the monster "ALien"
 *
 * @author Davy Raitt
 */

public class Alien extends StaticEntity {
	
	public Alien ( Handler handler , float x , float y ) {
		super ( handler , x , y , Tile.tileWidth , Tile.tileHeight );
		
		bounds.x = 5; //boundbox details of the Alien
		bounds.y = 5; //boundbox details of the Alien
		bounds.width = 23; //boundbox details of the Alien
		bounds.height = 23; //boundbox details of the Alien
	}
	
	@Override
	protected void die ( ) {
		System.out.println ( "dead" ); // when we kill the alien, we print the dead and it dissapears
	}
	
	@Override
	public void update ( ) {
	
	}
	
	@Override
	public void draw ( Graphics g ) { // drawing the alien, gets the img from our assets class
		if ( active )
		{
			g.drawImage ( Assets.monsterDown.get ( 1 ) ,
				( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
				( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null );
		}
	}
	
	//getters and setters and default methods
	
	@Override
	public void moveUp ( ) {
	
	}
	
	@Override
	public void moveDown ( ) {
	
	}
	
	@Override
	public void moveLeft ( ) {
	
	}
	
	@Override
	public void moveRight ( ) {
	
	}
	
	@Override
	public void moveUpReleased ( ) {
	
	}
	
	@Override
	public void moveDownReleased ( ) {
	
	}
	
	@Override
	public void moveLeftReleased ( ) {
	
	}
	
	@Override
	public void moveRightReleased ( ) {
	
	}
}
