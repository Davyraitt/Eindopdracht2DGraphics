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


public class WoodTile extends Tile {
	public WoodTile ( int id ) {
		super ( Assets.woodtile , id );
	}
}
