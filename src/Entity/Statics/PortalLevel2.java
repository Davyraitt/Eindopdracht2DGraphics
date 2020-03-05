package Entity.Statics;

import Entity.Player;
import Game.Handler;
import States.State;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class PortalLevel2 extends StaticEntity {
	
	private Rectangle2D boundsBox;
	
	public PortalLevel2 ( Handler handler , float x , float y , int width , int height ) {
		super ( handler , x , y , width , height );
		boundsBox = new Rectangle2D.Double ( x , y , Tile.tileWidth , Tile.tileHeight ); //boundsbox
	}
	
	@Override
	public void update ( ) {
		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
			
			handler.setLevel ( 3 );
		
	}
	
	@Override
	public void draw ( Graphics g ) {
//
//		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
//		{ // checks if the player is in the portal....
//			State.setState ( handler.getGame ( ).getLoadingState ( ) );
//			System.out.println ("we set the state" );
//
//			Timer timer = new Timer ( );
//
//			TimerTask task = new TimerTask ( ) {
//				public void run ( ) {
//					State.setState ( handler.getGame ( ).getGameState ( ) );
//				}
//
//			};
//			timer.schedule ( task , 3000 );
//		}
		
		g.drawImage ( Assets.portalTile , ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
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
