package Entity.Statics;

import Entity.Entity;
import Game.Handler;

/**
 * This class extends Entity.
 * // a static entity is an entity that does not move. So like a tree, rock, river, etc etc
 *
 * @author Davy Raitt
 */

public abstract class StaticEntity extends Entity {
	public StaticEntity ( Handler handler , float x , float y , int width , int height ) {
		super ( handler , x , y , width , height );
	}
	
}
