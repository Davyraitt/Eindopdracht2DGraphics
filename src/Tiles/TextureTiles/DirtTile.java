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


public class DirtTile extends Tile {
	
	public DirtTile ( int id ) {
		super ( Assets.dirttile , id );
	}
}
