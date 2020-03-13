package Tiles.LevelTiles;

import Tiles.Tile;
import Tools.Assets;


/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */


import java.awt.image.BufferedImage;

public class Level1Tile extends Tile {
	
	public Level1Tile ( int id ) {
		super ( Assets.levelTile1 , id );
	}
}
