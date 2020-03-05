package GUIObjects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Button {
    private int x;
    private int y;
    private int width;
    private int height;


    public Button(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;


    }

    public abstract void update ( );

    public abstract void draw (Graphics g );

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
