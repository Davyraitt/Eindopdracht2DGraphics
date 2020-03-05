package Tools;

//Game assets include everything that can go into a game,
//        including 3D models, sprites, sound effects, music, code snippets and modules,
//        and even complete projects that can be used by a game engine

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {

    public static BufferedImage lavatile;
    public static BufferedImage grasstile;
    private static BufferedImage grasstile2;
    private static BufferedImage grasstile3;
    public static BufferedImage woodtile;
    private static BufferedImage playertile;

    public static BufferedImage treetile1;
    private static BufferedImage treetile2;
    private static BufferedImage treetile3;
    private static BufferedImage treetile4;

    public static BufferedImage menuBackground;
    public static BufferedImage startButton;
    public static BufferedImage startButtonHovered;


    public static BufferedImage loadingScreen;
    public static BufferedImage portalTile;

    private static SpriteSheet sheet;
    private static SpriteSheet sheet2;
    private static SpriteSheet sheet3;
    private static SpriteSheet sheet4;
    private static SpriteSheet sheet5;
    private static SpriteSheet sheet6;
    private static SpriteSheet sheet7;
    private static SpriteSheet sheet8;

    public static ArrayList<BufferedImage> playerDown;
    public static ArrayList<BufferedImage> playerUp;
    public static ArrayList<BufferedImage> playerLeft;
    public static ArrayList<BufferedImage> playerRight;


    private static final int width = 32;
    private static final int height = 32;

    private static final int widthx2 = 64;
    private static final int heightx2 = 64;

    public Assets() {

    }

    public static void init() {
        playerDown = new ArrayList<>();
        playerUp = new ArrayList<>();
        playerLeft = new ArrayList<>();
        playerRight = new ArrayList<>();


        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/groundtiles.png")); // sheet containing
        // all the ground tiles
        sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/pokemonsprite.png")); // sheet
        // containing player walk animation
        sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/trees.png")); // sheet containing player
        // walk animation
        sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/groundtiles.jpg"));

        sheet5 = new SpriteSheet(ImageLoader.loadImage("/GUIResources/MenuBackground.png")); // contains the menubackground

        sheet6 = new SpriteSheet(ImageLoader.loadImage("/GUIResources/startgamebutton.png")); // contains the menu button

        sheet7 = new SpriteSheet(ImageLoader.loadImage("/GUIResources/startgamebuttonhovered.png")); // contains the menu button

        sheet8 = new SpriteSheet(ImageLoader.loadImage("/textures/LoadingScreen.png")); // contains the loadingscreen


        playerDown.add(0, sheet2.crop(0, 0, widthx2, heightx2));
        playerDown.add(1, sheet2.crop(widthx2, 0, widthx2, heightx2));
        playerDown.add(2, sheet2.crop(widthx2 * 2, 0, widthx2, heightx2));
        playerDown.add(3, sheet2.crop(widthx2 * 3, 0, widthx2, heightx2));

        playerLeft.add(0, sheet2.crop(0, heightx2, widthx2, heightx2));
        playerLeft.add(1, sheet2.crop(widthx2, heightx2, widthx2, heightx2));
        playerLeft.add(2, sheet2.crop(widthx2 * 2, heightx2, widthx2, heightx2));
        playerLeft.add(3, sheet2.crop(widthx2 * 3, heightx2, widthx2, heightx2));

        playerRight.add(0, sheet2.crop(0, heightx2 * 2, widthx2, heightx2));
        playerRight.add(1, sheet2.crop(widthx2, heightx2 * 2, widthx2, heightx2));
        playerRight.add(2, sheet2.crop(widthx2 * 2, heightx2 * 2, widthx2, heightx2));
        playerRight.add(3, sheet2.crop(widthx2 * 3, heightx2 * 2, widthx2, heightx2));

        playerUp.add(0, sheet2.crop(0, 64 * 3, widthx2, heightx2));
        playerUp.add(1, sheet2.crop(widthx2, 64 * 3, widthx2, heightx2));
        playerUp.add(2, sheet2.crop(widthx2 * 2, 64 * 3, widthx2, heightx2));
        playerUp.add(3, sheet2.crop(widthx2 * 3, 64 * 3, widthx2, heightx2));


        treetile1 = sheet3.crop(0, 0, width, height);
        treetile2 = sheet3.crop(32, 0, width, height);
        treetile3 = sheet3.crop(64, 0, width, height);
        treetile4 = sheet3.crop(96, 0, width, height);

        portalTile = sheet4.crop(32, 32, width, height);
        loadingScreen = sheet8.crop(0,0,400,400);

        startButton = sheet6.crop(0, 0, 200, 100);
        startButtonHovered = sheet7.crop(0, 0, 200, 100);
        menuBackground = sheet5.crop(0, 0, 400, 400);

        lavatile = sheet.crop(0, 0, width, height);
        grasstile = sheet.crop(width, 0, width, height);
        grasstile2 = sheet.crop(width * 2, 0, width, height);
        grasstile3 = sheet.crop(width * 3, 0, width, height);
        woodtile = sheet.crop(0, height, width, height);
        playertile = sheet.crop(width, height, width, height);
    }
}
