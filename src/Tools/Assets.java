package Tools;

//Game assets include everything that can go into a game,
//        including 3D models, sprites, sound effects, music, code snippets and modules,
//        and even complete projects that can be used by a game engine

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage lavatile;
    public static BufferedImage grasstile;
    public static BufferedImage grasstile2;
    public static BufferedImage grasstile3;
    public static BufferedImage woodtile;
    public static SpriteSheet sheet;

    private static final int width = 32;
    private static final int height = 32;


    public static void init() {
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/groundtiles.png"));

        lavatile = sheet.crop(0, 0, width, height);
        grasstile = sheet.crop(width, 0, width, height);
        grasstile2 = sheet.crop(width * 2, 0, width, height);
        grasstile3 = sheet.crop(width * 3, 0, width, height);
        woodtile = sheet.crop(0, height, width, height);
    }
}
