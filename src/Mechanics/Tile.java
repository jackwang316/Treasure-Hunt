package Mechanics;

/**
 * The tile class represents a grid in a maze. The class
 * tracks whether or not a tile has been visited and if the tile is a wall.
 * The class supports changing the status of the grid to visited or walled.
 */
public class Tile {
    private boolean isVisited;
    private boolean isWall;

    public Tile(){
        this.isVisited = false;
        this.isWall = false;
    }

    public boolean isVisited(){
        return this.isVisited;
    }

    public boolean isWalled(){
        return this.isWall;
    }

    public void setVisited(){
        this.isVisited = true;
    }

    public void setWall(boolean walled){
        this.isWall = walled;
    }
}
