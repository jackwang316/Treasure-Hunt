package Mechanics;

import java.util.ArrayList;

public class Maze {
    private static final int HEIGHT = 18;
    private static final int WIDTH = 14;
    public ArrayList<ArrayList<Cell>> cells;

    public Maze(){
        cells = new ArrayList<>(HEIGHT);
        for(int i = 0; i < HEIGHT; i++){
            cells.add(new ArrayList<>());
            for(int j = 0; j < WIDTH; j++) {
                cells.get(i).add(new Cell());
            }
        }
        initMaze();
    }

    public void initMaze(){
        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                cells.get(i).get(j).setWall(true);
                if(i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1){
                    cells.get(i).get(j).setVisited();
                }
            }
        }
        binaryTreeGenerate();
        removeCornerWalls();
    }

    public void revealAll(){
        for(int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                cells.get(i).get(j).setVisited();
            }
        }
    }

    private void binaryTreeGenerate() {
        for(int i = 1; i < HEIGHT - 1; i++) {
            for(int j = 1; (j < WIDTH - 1); j++) {
                if((i - 1) > 0 && ((j + 1) < (WIDTH - 1))){
                    if(Math.random() < 0.5) {
                        cells.get(i - 1).get(j).setWall(false);
                    } else{
                        cells.get(i).get(j + 1).setWall(false);
                    }
                }else if((i - 1) > 0 && !((j + 1) < (WIDTH - 1))){
                    cells.get(i - 1).get(j).setWall(false);
                }else if(!(i - 1 > 0) && ((j + 1) < (WIDTH - 1))){
                    cells.get(i).get(j + 1).setWall(false);
                }
            }
        }
    }

    private void removeCornerWalls(){
        cells.get(1).get(1).setWall(false);
        cells.get(1).get(WIDTH - 2).setWall(false);
        cells.get(HEIGHT - 2).get(1).setWall(false);
        cells.get(HEIGHT - 2).get(WIDTH - 2).setWall(false);
    }

    public Cell getCell(int x, int y){
        return cells.get(y).get(x);
    }
}


