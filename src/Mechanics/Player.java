package Mechanics;

public class Player {
    private int xPos = 1;
    private int yPos = 1;
    private boolean isAlive = true;

    public Player(){}

    public void move(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }

    public boolean isAlive(){
        return this.isAlive;
    }

    public void playerKilled(){
        this.isAlive = false;
    }

    public int getX(){
        return this.xPos;
    }

    public int getY(){
        return this.yPos;
    }
}
