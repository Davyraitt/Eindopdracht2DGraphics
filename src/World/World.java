package World;

import Game.Game;
import Tiles.Tile;
import Tools.Utils;

import java.awt.*;
import Game.Handler;

public class World {

    private int width;
    private int height;
    private int spawnX;
    private int spawnY;
    private Handler handler;
    
   
    
    
    private int [][] tiles;

    public World(Handler handler, String path) {
              this.handler = handler;
              loadWorld(path);
       

    }

    public void update () {

    }

    public void draw(Graphics g) {
       
           for ( int y = 0 ; y < height ; y++ ) //going down one row
        {
            for ( int x = 0 ; x < width ; x++ ) //looping from the first left tile to the far right tile
            {
                getTile ( x, y ).draw ( g, (int) (x * Tile.tileWidth - handler.getGameCamera ().getxOffset ()), (int) (y * Tile.tileHeight - handler.getGameCamera ().getyOffset ()));
            }
        }
        
    
    }

    public Tile getTile (int x, int y){ // asks for x and y coordinates
           
           if (x < 0 || y < 0 || x>= width || y >= height) {
                  return Tile.GrassTile;
           }
           
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
       
       public int getWidth ( ) {
              return width;
       }
       
       public int getHeight ( ) {
              return height;
       }
}
