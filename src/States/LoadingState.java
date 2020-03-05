package States;

import Game.Handler;
import Tools.Assets;
import org.jfree.fx.FXGraphics2D;

public class LoadingState extends State {
    public LoadingState(Handler handler) {
        super(handler);
    }

    @Override
    public void draw(FXGraphics2D graphics) {
        graphics.drawImage(Assets.loadingScreen, 0, 0, Assets.loadingScreen.getWidth(), Assets.loadingScreen.getHeight(), null);
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void setCurrentLevel(int newLevel) {

    }

    @Override
    public int getCurrentLevel() {
        return 0;
    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveUpReleased() {

    }

    @Override
    public void moveDownReleased() {

    }

    @Override
    public void moveRightReleased() {

    }

    @Override
    public void moveLeftReleased() {

    }
}
