package World;

import Entity.EntityManager;
import Entity.Player;
import Entity.Statics.PortalLevel1;
import Entity.Statics.PortalLevel2;
import Entity.Statics.Trees.Tree;
import Tiles.Tile;
import Tools.Utils;

import java.awt.*;
import java.util.ArrayList;

import Game.Handler;

public class World {

    private int width;
    private int height;
    private int spawnX;
    private int spawnY;
    private Handler handler;

    private int[][] tiles;
    private int currentLevel;
    
    
    //Entities
    private EntityManager entityManagerLevel1;
    private EntityManager entityManagerLevel2;
    private EntityManager entityManagerLevel3;
    private EntityManager entityManagerLevel4;
    private EntityManager entityManagerLevel5;
    private EntityManager entityManagerLevel6;
    
    private ArrayList < EntityManager > entityManagers;
    

    public World(Handler handler, String path) {
        this.handler = handler;

        entityManagers = new ArrayList < EntityManager > (  );
        
        //creating the entity manager
        entityManagerLevel1 = new EntityManager(handler, new Player(handler, 100, 100));
        entityManagerLevel2 = new EntityManager(handler, new Player(handler, 100, 100));
        entityManagerLevel3 = new EntityManager(handler, new Player(handler, 100, 100));
        entityManagerLevel4 = new EntityManager(handler, new Player(handler, 100, 100));
        entityManagerLevel5 = new EntityManager(handler, new Player(handler, 100, 100));
        entityManagerLevel6 = new EntityManager(handler, new Player(handler, 100, 100));
    
        entityManagers.add ( entityManagerLevel1 );
        entityManagers.add ( entityManagerLevel2 );
        entityManagers.add ( entityManagerLevel3 );
        entityManagers.add ( entityManagerLevel4 );
        entityManagers.add ( entityManagerLevel5 );
        entityManagers.add ( entityManagerLevel6 );

        // add the static entities here
        entityManagerLevel2.addEntity(new Tree(handler, 100, 200));
        entityManagerLevel2.addEntity(new Tree(handler, 100, 300));
        entityManagerLevel2.addEntity(new Tree(handler, 100, 400));
        entityManagerLevel1.addEntity(new PortalLevel1 (handler, 32, 32, 32, 32));
        entityManagerLevel1.addEntity(new PortalLevel2 (handler, 96, 32, 32, 32));


        loadWorld(path);
    
        
        
        entityManagerLevel1.getPlayer().setX(spawnX);
        entityManagerLevel1.getPlayer().setY(spawnY);

    }

    public void update() {
        entityManagerLevel1.update();
    }

    public void draw(Graphics g) {

        for (int y = 0; y < height; y++) //going down one row
        {
            for (int x = 0; x < width; x++) //looping from the first left tile to the far right tile
            {
                getTile(x, y).draw(g, (int) (x * Tile.tileWidth - handler.getGameCamera().getxOffset()), (int) (y * Tile.tileHeight - handler.getGameCamera().getyOffset()));
            }
        }

        entityManagerLevel1.draw(g);

    }

    public Tile getTile(int x, int y) { // asks for x and y coordinates

        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.GrassTile;
        }

        Tile tile = Tile.tiles[tiles[x][y]]; // creates a new tile, calls the tiles arraylist from Tile.java first, then inputs our arraylist
        if (tile == null) { // if the tile doesnt exist, we place a grasstile to prevent errors
            return Tile.GrassTile;
        }

        return tile;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void moveUp() {
        entityManagerLevel1.getPlayer().moveUp();
        entityManagerLevel1.getPlayer().moveUp();
    }

    public EntityManager getEntityManagerLevel1 () {
        return entityManagerLevel1;
    }


    public void moveDown() {
        entityManagerLevel1.getPlayer().moveDown();
    }


    public void moveRight() {
        entityManagerLevel1.getPlayer().moveRight();
    }


    public void moveLeft() {
        entityManagerLevel1.getPlayer().moveLeft();
    }


    public void moveUpReleased() {
        entityManagerLevel1.getPlayer().moveUpReleased();
    }


    public void moveDownReleased() {
        entityManagerLevel1.getPlayer().moveDownReleased();
    }


    public void moveRightReleased() {
        entityManagerLevel1.getPlayer().moveRightReleased();
    }


    public void moveLeftReleased() {
        entityManagerLevel1.getPlayer().moveLeftReleased();
    }
}
