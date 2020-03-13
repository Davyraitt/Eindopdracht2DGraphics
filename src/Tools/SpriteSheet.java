package Tools;

import java.awt.image.BufferedImage;

/**
 * Creature class class
 * This class extends Entity.
 *
 * @author Davy Raitt
 */


public class SpriteSheet {

    private BufferedImage SpriteSheet;

    public SpriteSheet(BufferedImage spriteSheet) {
        SpriteSheet = spriteSheet;
    }

    public BufferedImage crop (int x, int y, int width, int height) {
        return this.SpriteSheet.getSubimage(x, y, width, height);
    }
}

