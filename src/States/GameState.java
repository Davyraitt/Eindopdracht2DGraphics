package States;

import Entity.Player;
import Game.Game;
import World.World;
import org.jfree.fx.FXGraphics2D;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState( Game game) {
        super (game);
        player = new Player ( game, 100,100 );
        world = new World(game,  "D:/Java Projects/Eindopdracht2DGraphics/Eindopdracht2DGraphics/Resources/WorldFiles/World1.txt" );
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
    
}
