package GUIObjects;

import Tools.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Background class
 * This class contains details of a background
 * For example: We use this in the loadingstate, to display a loading screen.....
 *
 * @author Davy Raitt
 */

public class LoadingScreen {
	private int x;
	private int y;
	private BufferedImage image;
	LoadingScreen loadingScreen;
	
	public LoadingScreen ( int x , int y , BufferedImage image ) {
		this.x = x;
		this.y = y;
		this.image = image;
		loadingScreen = new LoadingScreen ( 0 , 0 , Assets.loadingScreen );
	}
	
	public void update ( ) {
	
	}
	
	public void draw ( Graphics g ) {
	
	}
}
