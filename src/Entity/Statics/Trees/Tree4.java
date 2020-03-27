package Entity.Statics.Trees;

import Entity.Statics.StaticEntity;
import Game.Handler;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;

/**
 * Tree class, contains details of our tree
 *
 * @author Davy Raitt
 */
public class Tree4 extends StaticEntity {
	public Tree4 ( Handler handler , float x , float y ) {
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
		g.drawImage ( Assets.treetile3 , ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null );
		
		//		g.setColor ( Color.red ); // shows the bound box
		//				g.fillRect ( ( int ) ( x + bounds.x - handler.getGameCamera ( ).getxOffset (
		//				) ) ,
		//					( int ) ( y + bounds.y - handler.getGameCamera ( ).getyOffset ( ) ) ,
		//					bounds.width ,
		//					bounds.height );
		// uncomment above to see the bounds box
		// fills the bound box
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
