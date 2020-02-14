package World;

import Game.Game;
import Tiles.Tile;
import Tools.Utils;

import java.awt.*;

public class World {

    private int width;
    private int height;
    private int spawnX;
    private int spawnY;
    private Game game;
    
    private int [][] tiles;

    public World(Game game, String path) {
              this.game = game;
              loadWorld(path);
       

    }

    public void update () {

    }

    public void draw(Graphics g) {
        for ( int y = 0 ; y < height ; y++ )
        {
            for ( int x = 0 ; x < width ; x++ )
            {
                getTile ( x, y ).draw ( g, x * Tile.tileWidth, y * Tile.tileHeight);
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
       
       private void loadWorld(String path){
              String file = Utils.loadFileAsString(path);
              String[] tokens = file.split("\\s+");
              width = Utils.parseInt(tokens[0]);
              height = Utils.parseInt(tokens[1]);
              spawnX = Utils.parseInt(tokens[2]);
              spawnY = Utils.parseInt(tokens[3]);
              
              tiles = new int[width][height];
              for(int y = 0;y < height;y++){
                     for(int x = 0;x < width;x++){
                            tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
                     }
              }
       }
}
