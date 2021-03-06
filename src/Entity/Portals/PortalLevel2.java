package Entity.Portals;

import Entity.Player;
import Entity.Statics.StaticEntity;
import Game.Handler;
import States.State;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Portal class, when the player enters the boundbox of the portal, we switch to another level
 *
 * @author Davy Raitt
 */

public class PortalLevel2 extends StaticEntity {
	
	private Rectangle2D boundsBox;
	
	public PortalLevel2 ( Handler handler , float x , float y , int width , int height ) {
		super ( handler , x , y , width , height );
		boundsBox = new Rectangle2D.Double ( x , y , Tile.tileWidth , Tile.tileHeight ); //boundsbox
	}
	
	@Override
	protected void die ( ) {
	
	}
	
	@Override
	public void update ( ) {
		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
			
			handler.setLevel ( 3 );
		
	}
	
	@Override
	public void draw ( Graphics g ) {
		
		g.drawImage ( Assets.portalTile , ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
			( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null );
		
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
