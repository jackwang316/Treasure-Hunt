package Mechanics;

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
