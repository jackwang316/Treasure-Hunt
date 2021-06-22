package Mechanics;

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

    public void respawn(int x, int y) {
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

    public boolean isCollected(int x, int y){
        return this.xPos == x && this.yPos == y;
    }

    public void activateCheat(){
        this.numSpawns = 1;
    }
}
