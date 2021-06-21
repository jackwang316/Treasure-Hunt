package Mechanics;

public class Player {
    private int xPos = 1;
    private int yPos = 1;

    public Player(){}

    public void move(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }

    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }
}
