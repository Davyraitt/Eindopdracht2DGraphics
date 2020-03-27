package Tools;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Animation class
 * This class contains the code that handles the animations
 * For each specific animation we create this. For example: Walking down, walking up, walking left, walking right.
 *
 * @author Davy Raitt
 */

public class Animation {
	
	private int speed;
	private int index;
	private ArrayList < BufferedImage > frames;
	private long lastTime;
	private long timer;
	
	public Animation ( int speed , ArrayList < BufferedImage > frames ) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis ( );
	}
	
	public void update ( ) { // update method per animation
		timer = timer + ( System.currentTimeMillis ( ) - lastTime );
		lastTime = System.currentTimeMillis ( ); // gets the current time
		
		if ( timer > speed ) // if the time passed is higher then the set speed , we set a new animation
		{
			index = index + 1; // upping the index
			timer = 0; // resetting the timer
			if ( index >= frames.size ( ) )
			{ // if the index is higher then the size of the arraylist, reset it
				index = 0;
			}
		}
		
	}
	
	public BufferedImage getCurrentFrame ( ) { // get the current img
		return frames.get ( index );
	}
}
