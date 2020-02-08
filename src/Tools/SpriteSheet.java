package Tools;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage SpriteSheet;

    public SpriteSheet(BufferedImage spriteSheet) {
        SpriteSheet = spriteSheet;
    }

    public BufferedImage crop (int x, int y, int width, int height) {
        return this.SpriteSheet.getSubimage(x, y, width, height);
    }
}

