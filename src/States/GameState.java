package States;

import Entity.Player;
import Game.Game;
import Tiles.Tile;
import org.jfree.fx.FXGraphics2D;

public class GameState extends State {

    private Player player;


    public GameState( Game game) {
        super (game);
        player = new Player ( 100,100 );
    }

    @Override
    public void draw(FXGraphics2D graphics) {
        player.draw ( graphics );
        Tile.tiles[0].draw ( graphics, 0, 0 );

    }
    

    @Override
    public void update(double deltaTime) {
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
    
}
