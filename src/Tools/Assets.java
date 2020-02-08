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

    private static final int width = 32;
    private static final int height = 32;


    public static void init () {
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/groundtiles.jpg"));
    }
}
