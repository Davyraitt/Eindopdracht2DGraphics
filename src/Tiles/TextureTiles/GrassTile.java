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


public class GrassTile extends Tile {
	public GrassTile ( int id ) {
		super ( Assets.grasstile, id );
	}
}
