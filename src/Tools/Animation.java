package Tools;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */


public class Animation {
	
	private int speed;
	private int index;
	private  ArrayList < BufferedImage > frames;
	private long lastTime;
	private long timer;
	
	public Animation ( int speed, ArrayList < BufferedImage > frames ) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis ();
	}
	
	public void update() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed){
			index++;
			timer = 0;
			if(index >= frames.size ())
				index = 0;
		}
		
	}
	
	public BufferedImage getCurrentFrame() {
		return frames.get ( index );
	}
}
