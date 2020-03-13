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


public class StoneTile extends Tile {
	
	public StoneTile ( int id ) {
		super ( Assets.stonetile , id );
	}
}
