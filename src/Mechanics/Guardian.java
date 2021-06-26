package Mechanics;

import java.util.ArrayList;
import java.util.Random;

public class Guardian {
    private int xPos;
    private int yPos;
    private int prevX;
    private int prevY;

    public Guardian(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.prevX = x;
        this.prevY = y;
    }

    public int getPreX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public boolean hasKilledPlayer(int playerX, int playerY){
        return this.xPos == playerX && this.yPos == playerY;
    }

    public int getX(){
        return this.xPos;
    }

    public int getY(){
        return this.yPos;
    }

    public void move(Maze maze){
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        if(!maze.getTile(this.getX() - 1, this.getY()).isWalled()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0, this.getX() - 1);
            temp.add(1, this.getY());
            coordinates.add(temp);
        }
        if(!maze.getTile(this.getX() + 1, this.getY()).isWalled()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0, this.getX() + 1);
            temp.add(1, this.getY());
            coordinates.add(temp);
        }
        if(!maze.getTile(this.getX(), this.getY() - 1).isWalled()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0, this.getX());
            temp.add(1, this.getY() - 1);
            coordinates.add(temp);
        }
        if(!maze.getTile(this.getX(), this.getY() + 1).isWalled()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0, this.getX());
            temp.add(1, this.getY() + 1);
            coordinates.add(temp);
        }

        if(coordinates.size() > 1) {
            for(int i = 0; i < coordinates.size(); i++){
                if(coordinates.get(i).get(0) == getPreX() && coordinates.get(i).get(1) == getPrevY()){
                    coordinates.remove(i);
                }
            }
        }

        Random rand = new Random();
        int nextCoordinateIndex = rand.nextInt(coordinates.size());
        this.prevX = this.xPos;
        this.prevY = this.yPos;
        this.xPos = coordinates.get(nextCoordinateIndex).get(0);
        this.yPos = coordinates.get(nextCoordinateIndex).get(1);

    }
}
