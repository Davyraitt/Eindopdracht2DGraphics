package Game;

import Entity.Player;
import States.*;
import Tools.Assets;
import Tools.SpriteSheet;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

/**
 * Game class
 * Contains all the main code of our game
 *
 * @author Davy Raitt
 */

public class Game extends Application {
	//project data
	private int width = 400; // size of the canvas
	private int height = 400; // size of the canvas
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
	private int lastFPSValue = 0;
	
	//images
	private BufferedImage testImage; // Testimage initialiseren
	private SpriteSheet sheet;
	
	//multiple states of the game, we declare them all here
	private State menuState;
	private State settingState;
	private State gameState;
	private State loadingState;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	//mousestates
	boolean leftPressed;
	boolean rigthPressed;
	int mouseX;
	int mouseY;
	
	public Game ( ) {
	
	}
	
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
		
		BorderPane mainPane = new BorderPane ( ); // creating a new borderpane
		
		//methods for input
		canvas = new ResizableCanvas ( g -> draw ( g ) , mainPane );
		canvas.setFocusTraversable ( true );
		canvas.setOnScroll ( this::mouseScrolled ); // mouseScrolled method is called when the user scrolls
		canvas.setOnKeyPressed ( this::keyPressed ); // keyPressed method is called when the user presses a key
		canvas.setOnKeyReleased ( this::keyReleased ); // keyPressed method is called when the user presses a key
		canvas.setOnMouseMoved ( this::mouseMoved ); //
		canvas.setOnMousePressed ( this::mousePressed ); //
		canvas.setOnMouseReleased ( this::mouseReleased ); //
		mainPane.setCenter ( canvas );
		FXGraphics2D g2d = new FXGraphics2D ( canvas.getGraphicsContext2D ( ) );
		
		//calls our init method
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
					updates = 0; // reset the variables
					timer = 0;  // reset the variables
					
				}
				
			}
		}.start ( );
		
		stage.setScene ( new Scene ( mainPane , width , height ) );
		stage.setTitle ( gameTitle );
		stage.show ( );
		
	}
	
	private void mousePressed ( MouseEvent e ) { // contains simple mouseclick booleans
		
		if ( e.isPrimaryButtonDown ( ) )
		{
			leftPressed = true;
		} else if ( e.isSecondaryButtonDown ( ) )
		{
			rigthPressed = true;
		}
	}
	
	private void mouseReleased ( MouseEvent e ) {  // contains simple mousereleased booleans
		
		if ( !e.isPrimaryButtonDown ( ) )
		{
			leftPressed = false;
		} else if ( !e.isSecondaryButtonDown ( ) )
		{
			rigthPressed = false;
		}
		
	}
	
	private void mouseMoved ( MouseEvent e ) { // when the mouse moves, we constantly update the x and y
		mouseX = ( int ) e.getX ( );
		mouseY = ( int ) e.getY ( );
		
	}
	
	private void keyReleased ( KeyEvent e ) { // when we release a certain key, we call a certain method
		switch ( e.getCode ( ) )
		{
			case W:
				
				gameState.moveUpReleased ( );
				break;
			case A:
				gameState.moveLeftReleased ( );
				break;
			case S:
				gameState.moveDownReleased ( );
				break;
			case D:
				gameState.moveRightReleased ( );
				break;
			case UP:
				gameState.moveUpReleased ( );
				break;
			case DOWN:
				gameState.moveDownReleased ( );
				break;
			case LEFT:
				gameState.moveLeftReleased ( );
				break;
			case RIGHT:
				gameState.moveRightReleased ( );
				break;
			case SHIFT:
				gameState.setSpeed ( 1.0f );
				break;
		}
		
	}
	
	private void keyPressed ( KeyEvent e ) { // when we press a certain key, we call a certain method
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
			case ESCAPE:
				State.setState ( getMenuState ( ) );
				break;
			case SHIFT:
				gameState.setSpeed ( 2.0f );
				break;
			case Q:
				gameState.attack ( );
				break;
		}
		
	}
	
	private void mouseScrolled ( ScrollEvent e ) { // method for zooming into the game
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
		//initialising the assets (images, etc)
		Assets.init ( );
		
		//creating the states
		gameCamera = new GameCamera ( handler , 0 , 0 );
		handler = new Handler ( this );
		gameState = new GameState ( handler );
		menuState = new MenuState ( handler );
		settingState = new SettingsState ( handler );
		// class)
		loadingState = new LoadingState ( handler );
		State.setState ( menuState ); // sets the first state of the game, if we switch this to gameState we
		// spawn in the game
		
	}
	
	public void draw ( FXGraphics2D graphics ) {
		
		graphics.setBackground ( Color.white );
		
		//Clearing the screen first
		graphics.clearRect ( 0 , 0 , this.width , this.height );
		
		// Start drawing
		if ( State.getState ( ) != null ) // double check, if no state is set we dont draw anything...
		{
			State.getState ( ).draw ( graphics );
		}
		
		//FPS drawen
		if ( timer >= 1000000000 )
		{ // prints how many updates we did in the last second?
			lastFPSValue = updates;
			
		}
		
		//draws the FPS right corner
		graphics.drawString ( String.valueOf ( lastFPSValue ) , 382 , 15 );
		
		// Stop drawing
		graphics.dispose ( );
		
	}
	
	public void update ( double deltaTime ) {
		
		if ( State.getState ( ) != null ) // double check, if no state is set we dont update anything...
		{
			long now = System.nanoTime ( );
			long last = -1;
			State.getState ( ).update ( now - last / 1000000000.0 ); // updates the state
		}
		
	}
	
	//getters and setters and default methods
	
	public boolean isLeftPressed ( ) {
		return leftPressed;
	}
	
	public double getMouseX ( ) {
		return mouseX;
	}
	
	public double getMouseY ( ) {
		return mouseY;
	}
	
	public State getMenuState ( ) {
		return menuState;
	}
	
	public State getGameState ( ) {
		return gameState;
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
	
	public State getSettingState ( ) {
		return settingState;
	}
	
	public State getLoadingState ( ) {
		return loadingState;
	}
}
