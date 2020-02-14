package World;

import Tiles.Tile;

import java.awt.*;

public class World {

    private int width;
    private int height;
    private int [][] tiles;

    public World(String path) {
        loadWorld(path);

    }

    public void update () {

    }

    public void draw(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x , y).draw(g,x * Tile.tileWidth,y * Tile.tileHeight);
            }

        }
    }

    public Tile getTile (int x, int y){ // asks for x and y coordinates
        Tile tile = Tile.tiles[tiles[x][y]]; // creates a new tile, calls the tiles arraylist from Tile.java first, then inputs our arraylist
        if (tile == null) { // if the tile doesnt exist, we place a grasstile to prevent errors
            return Tile.GrassTile;
        }

        return tile;
    }

    private void loadWorld (String path) {
        width = 5;
        height = 5;
        tiles = new int [width] [height];


        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles [x][y] = 1;
            }
        }
    }
}
