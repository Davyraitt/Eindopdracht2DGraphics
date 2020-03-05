package Game;

import World.World;

public class Handler {

    // The handler class is a simple class that allows us to pass along a bunch of variables when we want to.

    private Game game;
    private World world;


    public Handler(Game game) {
        this.game = game;
    }

    public void setLevel(int level) {
        game.getGameState().setCurrentLevel(level);
    }


    public int getLevel() {
        return game.getGameState().getCurrentLevel();
    }

    public int getWidth() {

        return game.getWidth(); // getter for the width of the game, gets the width from the main game method getter
    }

    public int getHeight() {
        return game.getHeight(); // getter for the height of the game, gets the height from the main game method getter
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera(); // getter for the camera of the game, gets the camera from the main game method getter
    }



    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
