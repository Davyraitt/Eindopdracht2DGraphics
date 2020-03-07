package Tiles;

import Tiles.TextureTiles.*;
import Tiles.LevelTiles.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC VARIABLE
	
	public static Tile[] tiles = new Tile[ 256 ]; // Arrray in Tiles class,
	//example: GrassTile has ID 0, it points to entry 0 in the arraylist
	public static Tile GrassTile = new GrassTile ( 0 ); //creating new tile
	public static Tile WaterTile = new WaterTile ( 1 ); //creating new tile
	public static Tile WoodTile = new WoodTile ( 2 ); //creating new tile
	
	public static Tile DirtTile = new DirtTile ( 3 ); //creating new tile
	public static Tile DirtyGrassTile = new DirtyGrassTile ( 4 ); //creating new tile
	public static Tile StoneTile = new StoneTile ( 5 ); //creating new tile
	public static Tile StoneTile2 = new StoneTile2 ( 6 ); //creating new tile
	
	public static Tile Level1Tile = new Level1Tile ( 21 ); //creating new tile
	public static Tile Level2Tile = new Level2Tile ( 22 ); //creating new tile
	public static Tile Level3Tile = new Level3Tile ( 23 ); //creating new tile
	public static Tile Level4Tile = new Level4Tile ( 24 ); //creating new tile
	public static Tile Level5Tile = new Level5Tile ( 25 ); //creating new tile
	
	//CLASS
	
	protected BufferedImage texture;
	protected final int id;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	
	public Tile ( BufferedImage texture , int id ) {
		this.texture = texture;
		this.id = id;
		
		tiles[ id ] = this; // Adds the tile to the index, for example: GrassTile is ID 0, adds it to Index 0 of
		// the array
		
	}
	
	public void update ( ) {
	}
	
	public void draw ( Graphics g , int x , int y ) {
		g.drawImage ( texture , x , y , tileWidth , tileHeight , null );
	}
	
	public int getId ( ) {
		return id;
	}
	
	public boolean isSolid ( ) {
		return false;
	}
}
