package States;

import Entity.Player;
import Game.Game;
import Game.Handler;
import World.World;
import org.jfree.fx.FXGraphics2D;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState( Handler handler) {
        super (handler);
        world = new World(handler, "Resources/WorldFiles/World1.txt");
        handler.setWorld ( world );
        player = new Player ( handler, 100,100 );
        
    }

    @Override
    public void draw(FXGraphics2D graphics) {
  
        world.draw(graphics);
        player.draw ( graphics );

    }
    

    @Override
    public void update(double deltaTime) {
        world.update();
        player.update ();
        
        
    }
    
    @Override
    public void moveUp ( ) {
        player.moveUp ();
    }
    
    @Override
    public void moveDown ( ) {
        player.moveDown ();
    }
    
    @Override
    public void moveRight ( ) {
        player.moveRight ();
    }
    
    @Override
    public void moveLeft ( ) {
        player.moveLeft ();
    }
    
    @Override
    public void moveUpReleased ( ) {
        player.moveUpReleased ();
    }
    
    @Override
    public void moveDownReleased ( ) {
        player.moveDownReleased ();
    }
    
    @Override
    public void moveRightReleased ( ) {
        player.moveRightReleased ();
    }
    
    @Override
    public void moveLeftReleased ( ) {
        player.moveLeftReleased ();
    }
    
}
