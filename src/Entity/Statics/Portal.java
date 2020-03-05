package Entity.Statics;

import Entity.Player;
import GUIObjects.LoadingScreen;
import Game.Handler;
import States.GameState;
import States.State;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class Portal extends StaticEntity {
	
	private Rectangle2D boundsBox;
	private boolean localCheck;
	
	public Portal ( Handler handler , float x , float y ) {
		super ( handler , x , y , Tile.tileWidth , Tile.tileHeight );
		
		boundsBox = new Rectangle2D.Double ( x , y , Tile.tileWidth , Tile.tileHeight ); //boundsbox
	}
	
	@Override
	public void update ( ) {
		
		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) && handler.getLevel ( ) == 2 )
		{ // checks if the player is in the portal....
			handler.setLevel ( 1 );
			
		}
		
		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) && handler.getLevel ( ) == 1 )
		{ // checks if the player is in the portal....
			handler.setLevel ( 2 );
			System.out.println ( handler.getLevel ( ) );
		}
		
	}
	
	@Override
	public void draw ( Graphics g ) {
		
//		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
//		{ // checks if the player is in the portal....
//			State.setState ( handler.getGame ( ).getLoadingState ( ) );
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
//
//		}
//
		g.drawImage ( Assets.portalTile , ( int ) ( x - handler.getGameCamera ( ).getxOffset ( ) ) ,
                     ( int ) ( y - handler.getGameCamera ( ).getyOffset ( ) ) , width , height , null );
		
		//g.drawRect((int)boundsBox.getX(), (int)boundsBox.getY(), (int)boundsBox.getWidth(), (int)boundsBox
           // .getHeight());
		//showrectangleboundsbox
		//g.drawRect((int)rectangle2D.getX(), (int)rectangle2D.getY(), (int)rectangle2D.getWidth(), (int)
           // rectangle2D.getHeight());
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
