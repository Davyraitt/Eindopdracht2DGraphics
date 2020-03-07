package World;

import Entity.EntityManager;
import Entity.Player;
import Entity.Statics.PortalLevel1;
import Entity.Statics.PortalLevel2;
import Entity.Statics.Trees.Tree;
import Entity.Statics.Trees.Tree2;
import Entity.Statics.Trees.Tree3;
import Entity.Statics.Trees.Tree4;
import Tiles.Tile;
import Tools.Utils;

import java.awt.*;
import java.util.ArrayList;

import Game.Handler;

public class World {
	
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private Handler handler;
	
	private int[][] tiles;
	private int currentLevel;
	
	//Entities
	private EntityManager entityManagerLevel1;
	private EntityManager entityManagerLevel2;
	private EntityManager entityManagerLevel3;
	private EntityManager entityManagerLevel4;
	private EntityManager entityManagerLevel5;
	private EntityManager entityManagerLevel6;
	
	private ArrayList < EntityManager > entityManagers;
	
	public World ( Handler handler , String path ) {
		this.handler = handler;
		
		entityManagers = new ArrayList < EntityManager > ( );
		
		//creating the entity manager
		entityManagerLevel1 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel2 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel3 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel4 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel5 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel6 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		
		entityManagers.add ( entityManagerLevel1 );
		entityManagers.add ( entityManagerLevel2 );
		entityManagers.add ( entityManagerLevel3 );
		entityManagers.add ( entityManagerLevel4 );
		entityManagers.add ( entityManagerLevel5 );
		entityManagers.add ( entityManagerLevel6 );
		
		// add the static entities here
		entityManagerLevel2.addEntity ( new Tree ( handler , 150 , 100 ) );
		entityManagerLevel2.addEntity ( new Tree ( handler , 150 , 300 ) );
		entityManagerLevel2.addEntity ( new Tree ( handler , 150 , 400 ) );
		
		entityManagerLevel3.addEntity ( new Tree ( handler , 150 , 100 ) );
		entityManagerLevel3.addEntity ( new Tree2 ( handler , 150 , 150 ) );
		entityManagerLevel3.addEntity ( new Tree3 ( handler , 150 , 200 ) );
		entityManagerLevel3.addEntity ( new Tree4 ( handler , 150 , 250 ) );
		
		for ( EntityManager entityManager : entityManagers )
		{
			entityManager.addEntity ( new PortalLevel1 ( handler , 32 , 32 , 32 , 32 ) );
			entityManager.addEntity ( new PortalLevel2 ( handler , 96 , 32 , 32 , 32 ) );
		}
		
		loadWorld ( path );
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).setX ( spawnX );
				entityManagerLevel1.getPlayer ( ).setY ( spawnY );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).setX ( spawnX );
				entityManagerLevel2.getPlayer ( ).setY ( spawnY );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).setX ( spawnX );
				entityManagerLevel3.getPlayer ( ).setY ( spawnY );
				break;
		}
		
	}
	
	public void update ( ) {
		switch ( currentLevel )
		{
			
			case 1:
				entityManagerLevel1.update ( );
				break;
			case 2:
				entityManagerLevel2.update ( );
				break;
			case 3:
				entityManagerLevel3.update ( );
				break;
		}
		
	}
	
	public void draw ( Graphics g ) {
		
		for ( int y = 0 ; y < height ; y++ ) //going down one row
		{
			for ( int x = 0 ; x < width ; x++ ) //looping from the first left tile to the far right tile
			{
				getTile ( x , y ).draw ( g ,
					( int ) ( x * Tile.tileWidth - handler.getGameCamera ( ).getxOffset ( ) ) ,
					( int ) ( y * Tile.tileHeight - handler.getGameCamera ( ).getyOffset ( ) ) );
			}
		}
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.draw ( g );
				break;
			case 2:
				entityManagerLevel2.draw ( g );
				break;
			case 3:
				entityManagerLevel3.draw ( g );
				break;
		}
		
	}
	
	public Tile getTile ( int x , int y ) { // asks for x and y coordinates
		
		if ( x < 0 || y < 0 || x >= width || y >= height )
		{
			return Tile.GrassTile;
		}
		
		Tile tile = Tile.tiles[ tiles[ x ][ y ] ]; // creates a new tile, calls the tiles arraylist from Tile
		// .java first, then inputs our arraylist
		if ( tile == null )
		{ // if the tile doesnt exist, we place a grasstile to prevent errors
			return Tile.GrassTile;
		}
		
		return tile;
	}
	
	private void loadWorld ( String path ) {
		String file = Utils.loadFileAsString ( path );
		String[] tokens = file.split ( "\\s+" );
		width = Utils.parseInt ( tokens[ 0 ] );
		height = Utils.parseInt ( tokens[ 1 ] );
		spawnX = Utils.parseInt ( tokens[ 2 ] );
		spawnY = Utils.parseInt ( tokens[ 3 ] );
		
		tiles = new int[ width ][ height ];
		for ( int y = 0 ; y < height ; y++ )
		{
			for ( int x = 0 ; x < width ; x++ )
			{
				tiles[ x ][ y ] = Utils.parseInt ( tokens[ ( x + y * width ) + 4 ] );
			}
		}
	}
	
	public int getWidth ( ) {
		return width;
	}
	
	public int getHeight ( ) {
		return height;
	}
	
	public void moveUp ( ) {
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveUp ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveUp ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveUp ( );
				break;
		}
		
	}
	
	public EntityManager getEntityManagerLevel1 ( ) {
		return entityManagerLevel1;
	}
	
	public EntityManager getEntityManagerLevel2 ( ) {
		return entityManagerLevel2;
	}
	
	public EntityManager getEntityManagerLevel3 ( ) {
		return entityManagerLevel3;
	}
	
	public void moveDown ( ) {
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveDown ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveDown ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveDown ( );
				break;
		}
		
	}
	
	public void moveRight ( ) {
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveRight ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveRight ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveRight ( );
				break;
		}
		
	}
	
	public void moveLeft ( ) {
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveLeft ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveLeft ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveLeft ( );
				break;
		}
		
	}
	
	public void moveUpReleased ( ) {
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveUpReleased ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveUpReleased ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveUpReleased ( );
				break;
		}
		
	}
	
	public void moveDownReleased ( ) {
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveDownReleased ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveDownReleased ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveDownReleased ( );
				break;
		}
		
	}
	
	public void moveRightReleased ( ) {
		
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveRightReleased ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveRightReleased ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveRightReleased ( );
				break;
		}
		
	}
	
	public void moveLeftReleased ( ) {
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).moveLeftReleased ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).moveLeftReleased ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).moveLeftReleased ( );
				break;
		}
		
	}
	
	public void setCurrentLevel ( int cl ) {
		this.currentLevel = cl;
	}
	
	public ArrayList < EntityManager > getEntityManagers ( ) {
		return entityManagers;
	}
}
