package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC VARIABLE
	
	
	public static Tile[] tiles = new Tile[256]; // Arrray in Tiles class,
	//example: GrassTile has ID 0, it points to entry 0 in the arraylist
	public static Tile GrassTile = new GrassTile ( 0 ); //creating new tile
	public static Tile LavaTile = new LavaTile ( 1 ); //creating new tile
	public static Tile WoodTile = new WoodTile ( 2 ); //creating new tile
	
	
	
	//CLASS
	
	protected BufferedImage texture;
	protected final int id;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	
	public Tile ( BufferedImage texture , int id ) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this; // Adds the tile to the index, for example: GrassTile is ID 0, adds it to Index 0 of the array
		
	}
	
	public void tick ( ) {
	}
	
	public void draw ( Graphics g , int x , int y ) {
		g.drawImage ( texture, x, y, tileWidth, tileHeight, null  );
	}
	
	public int getId ( ) {
		return id;
	}
	
	public boolean isSolid ()
	{
		return false;
	}
}
