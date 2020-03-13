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


public class DirtyGrassTile extends Tile {
	
	public DirtyGrassTile ( int id ) {
		super ( Assets.dirtygrasstile , id );
	}
}
