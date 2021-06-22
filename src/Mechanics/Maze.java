package Mechanics;

import java.util.ArrayList;

public class Maze {
    public static final int HEIGHT = 20;
    public static final int WIDTH = 16;
    public static final int HEIGHT_WITHOUT_WALLS = 18;
    public static final int WIDTH_WITHOUT_WALLS = 14;
    private ArrayList<ArrayList<Tile>> tiles;

    public Maze(){
        this.tiles = new ArrayList<>(HEIGHT);
        for(int i = 0; i < HEIGHT; i++){
            this.tiles.add(new ArrayList<>());
            for(int j = 0; j < WIDTH; j++) {
                this.tiles.get(i).add(new Tile());
            }
        }
        initMaze();
    }

    public void initMaze(){
        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                this.tiles.get(i).get(j).setWall(true);
            }
        }
        binaryTreeGenerate();
        removeCornerWalls();
        surroundWithWalls();
    }

    public void surroundWithWalls(){
        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                if(i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1){
                    this.tiles.get(i).get(j).setWall(true);
                    this.tiles.get(i).get(j).setVisited();
                }
            }
        }
    }

    public void revealNearPlayer(int x, int y){
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++){
                if((i > 0 && i < WIDTH) && (j > 0 && j < HEIGHT)){
                    getTile(i,j).setVisited();
                }
            }
        }
    }

    public void revealAll(){
        for(int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                this.tiles.get(i).get(j).setVisited();
            }
        }
    }

    private void binaryTreeGenerate() {
        for(int i = 1; i < HEIGHT; i++) {
            for(int j = 1; j < WIDTH; j++) {
                if((i - 1) > 0 && ((j + 1) < WIDTH)){
                    if(Math.random() < 0.5) {
                        this.tiles.get(i - 1).get(j).setWall(false);
                    }else{
                        this.tiles.get(i).get(j + 1).setWall(false);
                    }
                }else if((i - 1) > 0 && !((j + 1) < WIDTH)){
                    this.tiles.get(i - 1).get(j).setWall(false);
                }else if(!(i - 1 > 0) && ((j + 1) < WIDTH)){
                    this.tiles.get(i).get(j + 1).setWall(false);
                }
            }
        }
    }

    private void removeCornerWalls(){
        this.tiles.get(1).get(1).setWall(false);
        this.tiles.get(1).get(WIDTH - 2).setWall(false);
        this.tiles.get(HEIGHT - 2).get(1).setWall(false);
        this.tiles.get(HEIGHT - 2).get(WIDTH - 2).setWall(false);
    }

    public Tile getTile(int x, int y){
        return this.tiles.get(y).get(x);
    }
}


