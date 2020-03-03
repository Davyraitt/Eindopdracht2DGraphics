package Entity.Statics;

import Game.Handler;
import Tiles.Tile;
import Tools.Assets;

import java.awt.*;

public class Portal extends StaticEntity {
	public Portal ( Handler handler , float x , float y ) {
		super ( handler , x , y, Tile.tileWidth, Tile.tileHeight );
	}
	
	@Override
	public void update ( ) {
	
	}
	
	@Override
	public void draw ( Graphics g ) {
		g.drawImage ( Assets.portalTile ,(int) (x - handler.getGameCamera ().getxOffset ()), (int) (y - handler.getGameCamera ().getyOffset ()) , width, height, null);
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
