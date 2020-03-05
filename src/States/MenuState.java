package States;

import GUIObjects.Background;
import GUIObjects.MenuButton;
import Game.Handler;
import Tools.Assets;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class MenuState extends State {

    private MenuButton menuButton;
    private Background background;

    public MenuState(Handler handler) {
        super(handler);

        menuButton = new MenuButton(100, 100, 200, 100, Assets.startButton, Assets.startButtonHovered);
        background = new Background(0, 0, Assets.menuBackground);

    }

    @Override
    public void draw(FXGraphics2D graphics) {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.green);
        graphics.clearRect(0, 0, 400, 400);



        background.draw(graphics);
        menuButton.draw(graphics);

        if (menuButton.getRectangle2D().contains(handler.getGame().getMouseY(), handler.getGame().getMouseX())) {
        menuButton.drawHovered(graphics);


        }

        if (menuButton.getRectangle2D().contains(handler.getGame().getMouseY(), handler.getGame().getMouseX()) && handler.getGame().isLeftPressed()) {
            System.out.println("erin");
            State.setState(handler.getGame().getGameState());

        }

    }

    @Override
    public void update(double deltaTime) {

//        System.out.println(handler.getGame().isLeftPressed());
//        System.out.println(handler.getGame().isRigthPressed());
//        System.out.println(handler.getGame().getMouseX());
//        System.out.println(handler.getGame().getMouseY());


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
