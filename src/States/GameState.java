package States;

import Tools.Assets;
import org.jfree.fx.FXGraphics2D;

public class GameState extends State {



    public GameState() {
    }

    @Override
    public void draw(FXGraphics2D graphics) {
        graphics.drawImage(Assets.woodtile, 0 , 0 , null);

    }

    @Override
    public void update(double deltaTime) {

    }
}
