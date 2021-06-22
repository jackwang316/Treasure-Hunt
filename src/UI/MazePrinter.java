package UI;

import Mechanics.*;

public class MazePrinter {
    public static void printMaze(Maze maze, Player player, Relic relic) {
        Cell temp;
        for(int i = 0; i < maze.HEIGHT; i++){
            for(int j = 0; j < maze.WIDTH; j++){
                if(i == player.getY() && j == player.getX()){
                    System.out.print("@");
                }else if(i == relic.getYPos() && j == relic.getXPos()) {
                    System.out.print("^");
                }else{
                    temp = maze.getCell(j, i);
                    if(!temp.isVisited()){
                        System.out.print(".");
                    }else {
                        if(temp.isWalled()) {
                            System.out.print("#");
                        }else {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
