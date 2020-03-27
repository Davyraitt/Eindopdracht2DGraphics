package Tiles.LevelTiles;

import Tiles.Tile;
import Tools.Assets;

/**
 * Tile class
 * Our game exists out of tiles, a tile is a 32 by 32 image. Tiles can look different, for example we have a grass
 * tile and water tile.
 *
 * @author Davy Raitt
 */

import java.awt.image.BufferedImage;

public class Level1Tile extends Tile {
	
	public Level1Tile ( int id ) {
		super ( Assets.levelTile1 , id );
	}
}
