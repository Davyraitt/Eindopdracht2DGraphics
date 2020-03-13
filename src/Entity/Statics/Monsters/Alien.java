package Entity.Statics.Monsters;

import Entity.Statics.StaticEntity;
import Game.Handler;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */

public class Alien extends StaticEntity {
	
	public Alien ( Handler handler , float x , float y ) {
		super ( handler , x , y , Tile.tileWidth , Tile.tileHeight );
		
		bounds.x = 5;
		bounds.y = 5;
		bounds.width = 23;
		bounds.height = 23;
	}
	
	@Override
	protected void die ( ) {
	
	}
	
	@Override
	public void update ( ) {
	
	}
	
	@Override
	public void draw ( Graphics g ) {
		g.drawImage ( Assets.monsterDown.get ( 1 ) , ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null );
	}
	
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
