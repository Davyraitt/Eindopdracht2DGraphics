package States;

import Entity.Player;
import Game.Game;
import org.jfree.fx.FXGraphics2D;

public class GameState extends State {

    private Player player;
    

    public GameState() {
    public GameState( Game game) {
        super (game);
        player = new Player ( 100,100 );
    }

    @Override
    public void draw(FXGraphics2D graphics) {
    player.draw ( graphics );
    
    }

    @Override
    public void update(double deltaTime) {
            player.update ();
    }
}
