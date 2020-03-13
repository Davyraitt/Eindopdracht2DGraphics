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


public class MenuButton extends Button {

    private Rectangle2D rectangle2D;
    private BufferedImage image;
    private BufferedImage hovered;

    public MenuButton(int x, int y, int width, int height, BufferedImage image, BufferedImage hovered) {
        super(x, y, width, height);
        this.image = image;
        this.hovered = hovered;
        rectangle2D = new Rectangle2D.Double(x,y, width, height);
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

        //g.fillRect((int)rectangle2D.getX(), (int)rectangle2D.getY(), (int)rectangle2D.getWidth(), (int)rectangle2D.getHeight());

        g.drawImage(image, super.getX(), super.getY(), super.getWidth(), super.getHeight(), null  );

    }

    public void drawHovered(Graphics g) {

        //g.fillRect((int)rectangle2D.getX(), (int)rectangle2D.getY(), (int)rectangle2D.getWidth(), (int)rectangle2D.getHeight());

        g.drawImage(hovered, super.getX(), super.getY(), super.getWidth(), super.getHeight(), null  );

    }

    public Rectangle2D getRectangle2D() {
        return rectangle2D;
    }


}
