package Tiles;

import Tools.Assets;

import java.awt.image.BufferedImage;

public class LavaTile extends Tile {
	
	public LavaTile (int id ) {
		super ( Assets.lavatile , id );
	}
	
	@Override
	public boolean isSolid ()
	{
		return true;
	}
}
