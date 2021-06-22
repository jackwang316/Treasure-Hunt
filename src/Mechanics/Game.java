package Mechanics;
import UI.Menu;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Player player;
    private Relic relic;
    private Maze maze;
    private Menu menu;
    private ArrayList<Guardians> guardians;
    private int numGuardians = 3;

    public Game(){
        this.maze = new Maze();
        this.menu = new Menu();
        this.player = new Player();
        this.relic = new Relic();
        guardians = new ArrayList<>(numGuardians);
    }

    public boolean makeDecision(String choice) {
        if(choice.equals("?")) {
            menu.printHelp();
            return true;
        } else if(choice.equals("m")) {
            maze.revealAll();
            return true;
        } else if(choice.equals("c")){
            relic.activateCheat();
            return true;
        } else{
            Cell temp;
            if(choice.equals("a")) {
                temp = maze.getCell(player.getX() - 1, player.getY());
                if(!temp.isWalled()){
                    player.move(player.getX() - 1, player.getY());
                    maze.revealNearPlayer(player.getX(), player.getY());
                    return true;
                }
            } else if(choice.equals("w")) {
                temp = maze.getCell(player.getX(), player.getY() - 1);
                if(!temp.isWalled()) {
                    player.move(player.getX(), player.getY() - 1);
                    maze.revealNearPlayer(player.getX(), player.getY());
                    return true;
                }
            } else if(choice.equals("s")) {
                temp = maze.getCell(player.getX(), player.getY() + 1);
                if(!temp.isWalled()) {
                    player.move(player.getX(), player.getY() + 1);
                    maze.revealNearPlayer(player.getX(), player.getY());
                    return true;
                }
            } else if(choice.equals("d")) {
                temp = maze.getCell(player.getX() + 1, player.getY());
                if (!temp.isWalled()) {
                    player.move(player.getX() + 1, player.getY());
                    maze.revealNearPlayer(player.getX(), player.getY());
                    return true;
                }
            }
            return false;
        }
    }

    public void respawnRelic(){
        Random rn = new Random();
        boolean isValidPosition = false;
        while(!isValidPosition) {
            int x = rn.nextInt(maze.WIDTH_WITHOUT_WALLS - 1 + 1) + 1;
            int y = rn.nextInt(maze.HEIGHT_WITHOUT_WALLS - 1 + 1) + 1;
            Cell temp = maze.getCell(x, y);
            if(!temp.isWalled() && x != player.getX() && y != player.getY()){
                relic.respawn(x , y);
                isValidPosition = true;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.menu.printHelp();
        game.menu.printRelicInfo(game.relic);
    }
}
