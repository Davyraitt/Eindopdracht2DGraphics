package Tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyManager implements KeyListener {
	
	private ArrayList<Boolean> keys;
	
	
	public boolean up, up2, down, down2, left, left2, right, right2;
	
	
	public KeyManager ( ) {
		keys = new ArrayList <> (  );
	}
	
	public void update() {
		up = keys.get ( KeyEvent.VK_UP );
		up2 = keys.get ( KeyEvent.VK_W );
		down = keys.get ( KeyEvent.VK_DOWN );
		down2 = keys.get ( KeyEvent.VK_S );
		left = keys.get ( KeyEvent.VK_A );
		left2 = keys.get ( KeyEvent.VK_LEFT );
		right = keys.get ( KeyEvent.VK_RIGHT );
		right2 = keys.get ( KeyEvent.VK_D );
		
		
		
	}
	
	@Override
	public void keyTyped ( KeyEvent e ) {
		keys.add (  e.getKeyCode (), false );
	}
	
	@Override
	public void keyPressed ( KeyEvent e ) {
		keys.add (  e.getKeyCode (), true );
	
	}
	
	@Override
	public void keyReleased ( KeyEvent e ) {
	
	}
}
