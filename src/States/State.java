package States;

import Game.Game;
import org.jfree.fx.FXGraphics2D;

public abstract class State {
    
    protected Game game;
    
    public State ( Game game ) {
        this.game = game;
    }
    
    private static State currentState = null;

    public static State getState() {
        return currentState;
    }

    public static void setState(State state) {
        State.currentState = state;
    }
    
    

    //MUST IMPLEMENT
    public abstract void draw(FXGraphics2D graphics);
    public abstract void update(double deltaTime);
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveRight();
    public abstract void moveLeft();
    

}
