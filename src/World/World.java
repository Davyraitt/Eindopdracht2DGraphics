package World;

import Entity.EntityManager;
import Entity.Player;
import Entity.Portals.PortalLevel3;
import Entity.Statics.Monsters.Alien;
import Entity.Portals.PortalLevel1;
import Entity.Portals.PortalLevel2;
import Entity.Statics.Trees.Tree;
import Entity.Statics.Trees.Tree2;
import Entity.Statics.Trees.Tree3;
import Entity.Statics.Trees.Tree4;
import Tiles.Tile;
import Tools.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * World class
 * This class contains all the details of our worlds
 *
 * @author Davy Raitt
 */

import Game.Handler;

public class World {
	
	private int width; // width of our world
	private int height; // height of our world
	private int spawnX; // spawn location of the player
	private int spawnY; // spawn location of the player
	private Handler handler; // creating a handler to pass along variables
	
	private int[][] tiles; // 2d arraylist
	private int currentLevel; // keeps track of our current level
	
	//Entities
	private EntityManager entityManagerLevel1; // creating entity managers for each level
	private EntityManager entityManagerLevel2; // creating entity managers for each level
	private EntityManager entityManagerLevel3; // creating entity managers for each level
	private EntityManager entityManagerLevel4; // creating entity managers for each level
	private EntityManager entityManagerLevel5; // creating entity managers for each level
	private EntityManager entityManagerLevel6; // creating entity managers for each level
	
	private ArrayList < EntityManager > entityManagers;
	
	public World ( Handler handler , String path ) { // if we want to create a world we have to pass trough a
		// handler and a path
		this.handler = handler;
		
		entityManagers = new ArrayList < EntityManager > ( ); // creating the entitymanager
		
		//creating the entity manager
		entityManagerLevel1 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel2 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel3 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel4 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel5 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		entityManagerLevel6 = new EntityManager ( handler , new Player ( handler , 100 , 100 ) );
		
		// add the static entities here
		entityManagerLevel1.addEntity ( new Tree ( handler , 120 , 120 ) );
		entityManagerLevel1.addEntity ( new Tree ( handler , 150 , 300 ) );
		entityManagerLevel1.addEntity ( new Tree ( handler , 150 , 400 ) );
		
		entityManagerLevel3.addEntity ( new Tree ( handler , 200 , 100 ) );
		entityManagerLevel3.addEntity ( new Tree2 ( handler , 150 , 150 ) );
		entityManagerLevel3.addEntity ( new Tree3 ( handler , 150 , 200 ) );
		entityManagerLevel3.addEntity ( new Tree4 ( handler , 150 , 250 ) );
		
		entityManagerLevel3.addEntity ( new Alien ( handler , 70 , 130 ) );
		entityManagerLevel3.addEntity ( new Alien ( handler , 100 , 130 ) );
		entityManagerLevel3.addEntity ( new Alien ( handler , 130 , 130 ) );
		entityManagerLevel3.addEntity ( new Alien ( handler , 170 , 130 ) );
		entityManagerLevel3.addEntity ( new Alien ( handler , 210 , 130 ) );
		
		//adding to the arraylist of entityManagers
		entityManagers.add ( entityManagerLevel1 );
		entityManagers.add ( entityManagerLevel2 );
		entityManagers.add ( entityManagerLevel3 );
		entityManagers.add ( entityManagerLevel4 );
		entityManagers.add ( entityManagerLevel5 );
		entityManagers.add ( entityManagerLevel6 );
		
		for ( EntityManager entityManager : entityManagers ) // for each entitymanager we add each portal
		{
			entityManager.addEntity ( new PortalLevel1 ( handler , 32 , 32 , 32 , 32 ) );
			entityManager.addEntity ( new PortalLevel2 ( handler , 96 , 32 , 32 , 32 ) );
			entityManager.addEntity ( new PortalLevel3 ( handler , 160 , 32 , 32 , 32 ) );
		}
		
		loadWorld ( path ); // we load the world from the txt file
		
		//setting the spawn locations for each level
		entityManagerLevel1.getPlayer ( ).setX ( spawnX );
		entityManagerLevel1.getPlayer ( ).setY ( spawnY );
		
		entityManagerLevel2.getPlayer ( ).setX ( spawnX );
		entityManagerLevel2.getPlayer ( ).setY ( spawnY );
		
		entityManagerLevel3.getPlayer ( ).setX ( spawnX );
		entityManagerLevel3.getPlayer ( ).setY ( spawnY );
		
		entityManagerLevel4.getPlayer ( ).setX ( spawnX );
		entityManagerLevel4.getPlayer ( ).setY ( spawnY );
		
	}
	
	public void update ( ) { // update each level
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
			case 4:
				entityManagerLevel4.update ( );
				break;
		}
		
	}
	
	public void draw ( Graphics g ) { // draw each level
		
		for ( int y = 0 ; y < height ; y++ ) //going down one row
		{
			for ( int x = 0 ; x < width ; x++ ) //looping from the first left tile to the far right tile
			{
				// gets the correct tile and draws it at the offset 
				getTile ( x , y ).draw ( g ,
					//drawing the tiles
					( int ) ( x * Tile.tileWidth - handler.getGameCamera ( ).getxOffset ( ) ) ,
					( int ) ( y * Tile.tileHeight - handler.getGameCamera ( ).getyOffset ( ) ) );
			}
		}
		
		switch ( currentLevel ) // draw each level dependent on the currentlevel
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
			case 4:
				entityManagerLevel4.draw ( g );
				break;
		}
		
	}
	
	public Tile getTile ( int x , int y ) { // asks for x and y coordinates
		
		if ( x < 0 || y < 0 || x >= width || y >= height ) // if the input is wrong, we return a grasstile
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
		String file = Utils.loadFileAsString ( path ); // load the world as a string
		String[] tokens = file.split ( "\\s+" ); // creates an arraylist of strings, and we split the string at
		// any amount of whitespace
		
		//reading in the first four numbers of our .txt file
		width = Utils.parseInt ( tokens[ 0 ] ); // first entry of the world is the width
		height = Utils.parseInt ( tokens[ 1 ] ); // second entry of the world is the height
		spawnX = Utils.parseInt ( tokens[ 2 ] ); // thirds entry of the world is the spawn X
		spawnY = Utils.parseInt ( tokens[ 3 ] ); // fourth entry of the world is the spawn Y
		
		tiles = new int[ width ][ height ]; // initialize tiles array, 1st dimention size is width, 2nd
		// dimention size is height
		for ( int y = 0 ; y < height ; y++ )
		{ // for each height from the world (declared above)
			{
				for ( int x = 0 ; x < width ; x++ )  // for each width from the world (declared above)
				{
					tiles[ x ][ y ] = Utils.parseInt ( tokens[ ( x + y * width ) + 4 ] );
					// add 4 because the first 4 elements are width, height, and spawns
					// convert the array to an 2d array
				}
			}
		}
	}
	
	//getters and setters and default methods
	
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveUp ( );
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveDown ( );
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveRight ( );
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveLeft ( );
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveUpReleased ( );
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveDownReleased ( );
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveRightReleased ( );
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
			case 4:
				entityManagerLevel4.getPlayer ( ).moveLeftReleased ( );
				break;
		}
		
	}
	
	public void setSpeed ( float speed ) {
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).setSpeed ( speed );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).setSpeed ( speed );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).setSpeed ( speed );
				break;
			case 4:
				entityManagerLevel4.getPlayer ( ).setSpeed ( speed );
				break;
		}
		
	}
	
	public void attack ( ) {
		switch ( currentLevel )
		{
			case 1:
				entityManagerLevel1.getPlayer ( ).attack ( );
				break;
			case 2:
				entityManagerLevel2.getPlayer ( ).attack ( );
				break;
			case 3:
				entityManagerLevel3.getPlayer ( ).attack ( );
				break;
			case 4:
				entityManagerLevel4.getPlayer ( ).attack ( );
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
