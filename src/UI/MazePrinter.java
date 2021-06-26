package UI;

import Mechanics.*;

import java.util.ArrayList;

public class MazePrinter {
    public static void printMaze(Maze maze, Player player, Relic relic, ArrayList<Guardians> guardians) {
        System.out.println("Maze:");
        Tile temp;
        for(int i = 0; i < maze.HEIGHT; i++){
            for(int j = 0; j < maze.WIDTH; j++){
                if(i == player.getY() && j == player.getX()){
                    if(player.isAlive()) {
                        System.out.print("@");
                    }else {
                        System.out.print("X");
                    }
                }else if(i == relic.getYPos() && j == relic.getXPos()) {
                    System.out.print("^");
                }else{
                    temp = maze.getTile(j, i);
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
