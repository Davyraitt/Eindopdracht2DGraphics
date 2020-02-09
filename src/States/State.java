package States;

import org.jfree.fx.FXGraphics2D;

public abstract class State {

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

}
