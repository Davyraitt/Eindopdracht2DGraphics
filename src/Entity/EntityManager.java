package Entity;

import Game.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */


public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList < Entity > entities;
	private Comparator<Entity> renderSorter = new Comparator <Entity>() {
		
		@Override
		public int compare ( Entity a , Entity b ) {
			if (a.getY () + a.getHeight () < b.getY () + b.getHeight ()) {return -1;}
			return 1;
		}
	};
	
	public EntityManager ( Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		this.entities = new ArrayList < Entity > ( );
		addEntity ( player );
	}
	
	public void update ( ) {
		for ( int i = 0 ; i < entities.size ( ) ; i++ )
		{
			Entity e = entities.get ( i );
			e.update ( );
			if (!e.active) {entities.remove ( e );}
		}
		entities.sort ( renderSorter );
		
		
	}
	
	public void draw ( Graphics g ) {
		for ( int i = 0 ; i < entities.size ( ) ; i++ )
		{
			Entity e = entities.get ( i );
			e.draw ( g );
		}
		
	}
	
	public void addEntity ( Entity e ) {
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
