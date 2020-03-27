package Tiles.TextureTiles;

import Tiles.Tile;
import Tools.Assets;

import java.awt.image.BufferedImage;

/**
 * Tile class
 * Our game exists out of tiles, a tile is a 32 by 32 image. Tiles can look different, for example we have a grass
 * tile and water tile.
 *
 * @author Davy Raitt
 */

public class WoodTile extends Tile {
	public WoodTile ( int id ) {
		super ( Assets.woodtile , id );
	}
}
