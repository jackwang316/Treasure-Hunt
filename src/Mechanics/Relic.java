package Mechanics;

public class Relic {
    private int numSpawns = 3;
    private int numCollected = 0;
    private int xPos;
    private int yPos;

    public Relic(){}

    public int getNumSpawns(){
        return numSpawns;
    }

    public int getNumCollected(){
        return numCollected;
    }

    public void respawn(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public int getXPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }

    public void collectRelic(int x, int y) {
        if(isCollected(x, y)) {
            numSpawns--;
            numCollected++;
        }
    }

    public boolean isCollected(int x, int y){
        return xPos == x && yPos == y;
    }

    public void activateCheat(){
        numSpawns = 1;
    }
}
