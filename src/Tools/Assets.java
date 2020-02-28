package Tools;

//Game assets include everything that can go into a game,
//        including 3D models, sprites, sound effects, music, code snippets and modules,
//        and even complete projects that can be used by a game engine

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {

    public static BufferedImage lavatile;
    public static BufferedImage grasstile;
    public static BufferedImage grasstile2;
    public static BufferedImage grasstile3;
    public static BufferedImage woodtile;
    public static BufferedImage playertile;
    public static SpriteSheet sheet;
    public static SpriteSheet sheet2;
    
    public static ArrayList <BufferedImage> playerDown;
    public static ArrayList <BufferedImage> playerUp;
    public static ArrayList <BufferedImage> playerLeft;
    public static ArrayList <BufferedImage> playerRight;

    private static final int width = 32;
    private static final int height = 32;
    
    private static final int widthx2 = 64;
    private static final int heightx2 = 64;
    
    public Assets ( ) {
    
    }
    
    public static void init() {
        playerDown = new ArrayList <> (  );
        playerUp = new ArrayList <> (  );
        playerLeft = new ArrayList <> (  );
        playerRight = new ArrayList <> (  );
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/groundtiles.png")); // sheet containing all the ground tiles
        sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/pokemonsprite.png")); // sheet containing player walk animation
    
        playerDown.add ( 0, sheet2.crop (0, 0, widthx2, heightx2) );
        playerDown.add ( 1, sheet2.crop (widthx2, 0, widthx2, heightx2) );
        playerDown.add ( 2, sheet2.crop (widthx2 * 2, 0, widthx2, heightx2) );
        playerDown.add ( 3, sheet2.crop (widthx2 * 3, 0, widthx2, heightx2) );
    
        playerLeft.add ( 0, sheet2.crop (0, heightx2, widthx2, heightx2) );
        playerLeft.add ( 1, sheet2.crop (widthx2, heightx2, widthx2, heightx2) );
        playerLeft.add ( 2, sheet2.crop (widthx2 * 2, heightx2, widthx2, heightx2) );
        playerLeft.add ( 3, sheet2.crop (widthx2 * 3, heightx2, widthx2, heightx2) );
    
        playerRight.add ( 0, sheet2.crop (0, heightx2 * 2, widthx2, heightx2) );
        playerRight.add ( 1, sheet2.crop (widthx2, heightx2 * 2, widthx2, heightx2) );
        playerRight.add ( 2, sheet2.crop (widthx2 * 2, heightx2 * 2, widthx2, heightx2) );
        playerRight.add ( 3, sheet2.crop (widthx2 * 3, heightx2 * 2, widthx2, heightx2) );
    
        playerUp.add ( 0, sheet2.crop (0, 64 * 3, widthx2, heightx2) );
        playerUp.add ( 1, sheet2.crop (widthx2, 64 * 3, widthx2, heightx2) );
        playerUp.add ( 2, sheet2.crop (widthx2 * 2, 64 * 3, widthx2, heightx2) );
        playerUp.add ( 3, sheet2.crop (widthx2 * 3, 64 * 3, widthx2, heightx2) );
        
        

        lavatile = sheet.crop(0, 0, width, height);
        grasstile = sheet.crop(width, 0, width, height);
        grasstile2 = sheet.crop(width * 2, 0, width, height);
        grasstile3 = sheet.crop(width * 3, 0, width, height);
        woodtile = sheet.crop(0, height, width, height);
        playertile = sheet.crop ( width, height, width, height);
    }
}
