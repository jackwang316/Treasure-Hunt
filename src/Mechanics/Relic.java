package Mechanics;

import java.util.Random;

/**
 * The Relic class represents the relic that must be collected in game.
 * The class stores the number of relics already collected, number of relics left
 * and the x,y coordinates of the relic. The class supports the respawning of relics, checking if a
 * relic has been collected, and updating the spawn and collected numbers.
 */
public class Relic {
    private int numSpawns = 3;
    private int numCollected = 0;
    private int xPos;
    private int yPos;

    public Relic(){}

    public int getNumSpawns(){
        return this.numSpawns;
    }

    public int getNumCollected(){
        return this.numCollected;
    }

    private void move(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public int getXPos(){
        return this.xPos;
    }

    public int getYPos(){
        return this.yPos;
    }

    public void collectRelic(){
        this.numSpawns--;
        this.numCollected++;
    }

    public void respawnRelic(Maze maze, Player player){
        //Keep picking random X and Y until the tile at x,y is empty.
        Random rn = new Random();
        boolean isValidPosition = false;
        while(!isValidPosition) {
            int x = rn.nextInt(Maze.WIDTH_WITHOUT_WALLS) + 1;
            int y = rn.nextInt(Maze.HEIGHT_WITHOUT_WALLS) + 1;
            Tile temp = maze.getTile(x, y);
            if(!temp.isWalled() && x != player.getX() && y != player.getY()){
                this.move(x , y);
                isValidPosition = true;
            }
        }
    }

    public boolean isCollected(int x, int y){
        return this.xPos == x && this.yPos == y;
    }

    public void activateCheat(){
        this.numSpawns = 1;
    }
}
