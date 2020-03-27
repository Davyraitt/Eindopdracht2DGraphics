package Entity;

import Game.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Entitymanager class
 * this entity manager manages all our entities
 *
 * @author Davy Raitt
 */

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList < Entity > entities;
	private Comparator < Entity > renderSorter = new Comparator < Entity > ( ) { // creating a new comparator
		// renderSorter
		
		@Override
		public int compare ( Entity a , Entity b ) { // this comparator takes in two entities a, and b
			if ( a.getY ( ) + a.getHeight ( ) < b.getY ( ) + b.getHeight ( ) ) // if the height and Y of a
				// are smaller then b, render it first
			{
				return -1; // returns negative, A should be rendered before B
			}
			return 1; // returns positive, A should be rendered after B
		}
	};
	
	public EntityManager ( Handler handler , Player player ) {
		this.handler = handler;
		this.player = player;
		this.entities = new ArrayList < Entity > ( );
		addEntity ( player );
	}
	
	public void update ( ) { // in this class we update each entity
		for ( int i = 0 ; i < entities.size ( ) ; i++ )
		{
			Entity e = entities.get ( i );
			e.update ( );
			if ( !e.active )
			{
				entities.remove ( e ); // if the entity is dead, we remove it from our arraylist with
				// entities
			}
		}
		entities.sort ( renderSorter ); // goes trough all the entities in the array, and compare them to
		// eachother
		
	}
	
	public void draw ( Graphics g ) {
		for ( int i = 0 ; i < entities.size ( ) ; i++ )
		{
			Entity e = entities.get ( i ); // draws each entity
			e.draw ( g );
		}
		
	}
	
	//getters and setters and default methods
	
	public void addEntity ( Entity e ) { // method for adding entities to the arraylist
		this.entities.add ( e );
	}
	
	public Handler getHandler ( ) {
		return handler;
	}
	
	public void setHandler ( Handler handler ) {
		this.handler = handler;
	}
	
	public Player getPlayer ( ) {
		return player;
	}
	
	public ArrayList < Entity > getEntities ( ) {
		return entities;
	}
	
	public void setPlayer ( Player player ) {
		this.player = player;
	}
	
}
