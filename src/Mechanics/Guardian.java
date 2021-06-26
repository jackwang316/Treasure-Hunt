package Mechanics;

public class Guardian {
    private int xPos;
    private int yPos;

    public Guardian(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public int getX(){
        return this.xPos;
    }

    public int getY(){
        return this.yPos;
    }

    public void move(Maze maze){
        if(!maze.getTile(this.getX() - 1, this.getY()).isWalled()){

        }
        if(!maze.getTile(this.getX() + 1, this.getY()).isWalled()){

        }
        if(!maze.getTile(this.getX(), this.getY() - 1).isWalled()){

        }
        if(!maze.getTile(this.getX(), this.getY() + 1).isWalled()){

        }
    }
}
