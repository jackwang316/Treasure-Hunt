package Mechanics;

public class Cell {
    private boolean isVisited;
    private boolean isWall;

    public Cell(){
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

    public void setWall(){
        this.isWall = true;
    }
}
