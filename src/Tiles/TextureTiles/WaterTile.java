package Tiles.TextureTiles;

import Tiles.Tile;
import Tools.Assets;

import java.awt.image.BufferedImage;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */


public class WaterTile extends Tile {
	
	public WaterTile ( int id ) {
		super ( Assets.watertile , id );
	}
	
	@Override
	public boolean isSolid ()
	{
		return true;
	}
}
