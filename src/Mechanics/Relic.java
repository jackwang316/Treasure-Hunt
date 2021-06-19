package Mechanics;

public class Relic {
    private int numSpawns = 3;
    private int xPos;
    private int yPos;

    public int getNumSpawns(){
        return numSpawns;
    }

    public int getXPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }

    public void activateCheat(){
        numSpawns = 1;
    }
}
