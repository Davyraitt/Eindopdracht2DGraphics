package Entity.Statics;

import Entity.Player;
import GUIObjects.LoadingScreen;
import Game.Handler;
import States.GameState;
import States.LoadingState;
import States.State;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class PortalLevel1 extends StaticEntity {
	
	private Rectangle2D boundsBox;
	
	public PortalLevel1 ( Handler handler , float x , float y , int width , int height ) {
		super ( handler , x , y , width , height );
		boundsBox = new Rectangle2D.Double ( x , y , Tile.tileWidth , Tile.tileHeight ); //boundsbox
	}
	
	@Override
	public void update ( ) {
		//		if ( boundsBox.isEmpty () ) {
		//			System.out.println ("isempty" );
		//		}
		
		//		if ( !boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
		//		{ // checks if the player is not in the protal
		//			outTheBounds = true;
		//
		//		} == 1 && !outTheBounds
		//&& !outTheBounds
		//
		//		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
		//		{ // checks if the player is not in the protal
		//			outTheBounds = false;
		//
		//		}
		
		//		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) &&
		//		handler.getLevel ( ) == 2 )
		//		{ // checks if the player is in the portal....
		//			handler.setLevel ( 1 );
		//			outTheBounds = false;
		//			System.out.println ("CALLED TOP METHOD" );
		//			return;
		//		}
		
		if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
			
			handler.setLevel ( 2 );
		
	}
	
	@Override
	public void draw ( Graphics g ) {
//
//				if ( boundsBox.contains ( Player.boundsBox.getX ( ) , Player.boundsBox.getY ( ) ) )
//				{ // checks if the player is in the portal....
//					State.setState ( handler.getGame ( ).getLoadingState ( ) );
//					System.out.println ("we set the state" );
//
//					Timer timer = new Timer ( );
//
//					TimerTask task = new TimerTask ( ) {
//						public void run ( ) {
//							State.setState ( handler.getGame ( ).getGameState ( ) );
//						}
//
//					};
//					timer.schedule ( task , 3000 );
//				}
		
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
