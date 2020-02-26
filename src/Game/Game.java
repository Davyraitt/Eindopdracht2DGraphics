package Game;

import States.GameState;
import States.MenuState;
import States.SettingsState;
import States.State;
import Tools.Assets;
import Tools.SpriteSheet;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends Application {
	//project data
	private int width = 400;
	private int height = 400;
	private ResizableCanvas canvas;
	
	//title of game
	private String gameTitle = "Niciarex"; // name of the game
	
	//fps and fps counter
	private int x = 0; // x coordinate
	private int fps = 60; // frames per second , amount of times we want to call update and draw PER SECOND
	private int timePerUpdate = 1_000_000_000 / fps; // 1 second divided by our fps, now we get our frames per
	// second
	private double delta = 0; // delta is the amount of time we have left, untill we call update and draw
	private long lastTime = System.nanoTime ( ); // gets current computertime in nanoseconds
	private long timer = 0; // time until we hit 1s, print out how many updates and draw we did
	private int updates = 0; // int for the fps counter
	
	//images
	private BufferedImage testImage; // Testimage initialiseren
	private SpriteSheet sheet;
	
	
	//multiple states of the game, we declare them all here
	private State menuState;
	private State settingState;
	private State gameState;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public static void main ( String[] args ) {
		launch ( Game.class ); //launches the main game
	}
	
	@Override
	public void start ( Stage stage ) throws Exception {
		AudioInputStream audioIn =
                     AudioSystem.getAudioInputStream ( getClass ( ).getResource ( "/Sound/music" + ".wav" ) ); //
           // inputting sound
		Clip clip = AudioSystem.getClip ( ); // inputting sound
		clip.open ( audioIn ); // inputting sound
		clip.start ( ); // inputting sound
		BorderPane mainPane = new BorderPane ( );
		canvas = new ResizableCanvas ( g -> draw ( g ) , mainPane );
		canvas.setFocusTraversable ( true );
		canvas.setOnScroll ( this::mouseScrolled ); // mouseScrolled method is called when the user scrolls
		canvas.setOnKeyPressed ( this::keyPressed ); // keyPressed method is called when the user presses a key
		mainPane.setCenter ( canvas );
		FXGraphics2D g2d = new FXGraphics2D ( canvas.getGraphicsContext2D ( ) );
		init ( );
		new AnimationTimer ( ) { // main game loop, constantly runs update(update) and draw (draw) to show
			// things on the screen
			long last = -1;
			
			@Override
			public void handle ( long now ) {
				now = System.nanoTime ( );
				delta += ( now - lastTime ) / timePerUpdate; // delta variable tells the computer when and
				// when not to call update and draw
				timer += now - lastTime; // adding the amount of time which has passed, sinds we
				// update/drawed
				lastTime = now;
				if ( last == -1 )
				{
					last = now;
				}
				update ( ( now - last ) / 1000000000.0 );
				last = now;
				draw ( g2d );
				updates = updates + 1;
				delta = delta - 1;
				
				if ( timer >= 1000000000 )
				{ // prints how many updates we did in the last second?
					System.out.println ( "FPS Counter:" + updates );
					updates = 0; // reset the variables
					timer = 0;  // reset the variables
					
				}
				
			}
		}.start ( );
		
		stage.setScene ( new Scene ( mainPane , width , height ) );
		stage.setTitle ( gameTitle );
		stage.show ( );
		
	}
	
	private void keyPressed ( KeyEvent e ) {
		switch ( e.getCode ( ) )
		{
			case W:
				gameState.moveUp ( );
				break;
			case A:
				gameState.moveLeft ( );
				break;
			case S:
				gameState.moveDown ( );
				break;
			case D:
				gameState.moveRight ( );
				break;
			case UP:
				gameState.moveUp ( );
				break;
			case DOWN:
				gameState.moveDown ( );
				break;
			case LEFT:
				gameState.moveLeft ( );
				break;
			case RIGHT:
				gameState.moveRight ( );
				break;
		}
		
	}
	
	private void mouseScrolled ( ScrollEvent e ) {
		double zoomFactor = 1.05;
		double deltaY = e.getDeltaY ( );
		
		if ( deltaY < 0 )
		{
			zoomFactor = 0.95;
		}
		canvas.setScaleX ( canvas.getScaleX ( ) * zoomFactor );
		canvas.setScaleY ( canvas.getScaleY ( ) * zoomFactor );
		e.consume ( );
	}
	
	public void init ( ) { // initialisation method
		Assets.init ( );
		
		gameCamera = new GameCamera ( handler , 0 , 0 );
		handler = new Handler ( this ); // we pass in this, because it takes a game object (this class)
		gameState = new GameState ( handler ); // we pass in this, because it takes a game object (this class)
		menuState = new MenuState ( handler ); // we pass in this, because it takes a game object (this class)
		settingState = new SettingsState ( handler ); // we pass in this, because it takes a game object (this
           // class)
		
		State.setState ( gameState );
		
	}
	
	public void draw ( FXGraphics2D graphics ) { // AKA draw
		//graphics.drawImage( sheet.crop(32,0, 35, 51), 5,5, null); // using the crop method
		
		graphics.setBackground ( Color.white );
		
		//Eerst het scherm leeg maken
		graphics.clearRect ( 0 , 0 , this.width , this.height );
		// graphics.drawImage(testImage, 0, 0, null); // drawing a simple image
		
		// Hier begin ik met tekenen
		if ( State.getState ( ) != null )
		{
			State.getState ( ).draw ( graphics );
		}
		
		// Hier stop ik het tekenen
		graphics.dispose ( );
		
	}
	
	public void update ( double deltaTime ) {  // update aka update
		
		if ( State.getState ( ) != null )
		{
			long now = System.nanoTime ( );
			long last = -1;
			State.getState ( ).update ( now - last / 1000000000.0 );
		}
		
	}
	
	public ResizableCanvas getCanvas ( ) {
		return canvas;
	}
	
	public GameCamera getGameCamera ( ) {
		return gameCamera;
	}
	
	public int getWidth ( ) {
		return this.width;
	}
	
	public int getHeight ( ) {
		return this.height;
	}
}
