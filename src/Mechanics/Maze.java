package Mechanics;

import java.util.ArrayList;

public class Maze {
    private static final int HEIGHT = 18;
    private static final int WIDTH = 14;
    private ArrayList<ArrayList<Cell>> cells;

    public Maze(){
        cells = new ArrayList<>(HEIGHT);
        for(int i = 0; i < HEIGHT; i++){
            cells.add(new ArrayList<>());
        }
    }

    public void initMaze(){
        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                if(i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1){
                    cells.get(i).get(j).setWall();
                    cells.get(i).get(j).setVisited();
                }
            }
        }
    }
}
