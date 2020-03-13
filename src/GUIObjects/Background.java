package GUIObjects;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */


public class Background {
    private int x;
    private int y;
    private BufferedImage image;

    public Background( int x, int y, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void update() {

    }


    public void draw(Graphics g) {
        g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);

    }
}
