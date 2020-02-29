package Entity;

import Game.Handler;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList < Entity > entities;
	
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
		}
		
		
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
