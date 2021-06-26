package Mechanics;
import UI.Menu;

import java.util.ArrayList;
import java.util.Random;

import static UI.MazePrinter.printMaze;

public class Game {
    private Player player;
    private Relic relic;
    private Maze maze;
    private Menu menu;
    private ArrayList<Guardian> guardians;

    public Game(){
        this.maze = new Maze();
        this.menu = new Menu();
        this.player = new Player();
        this.relic = new Relic();
        this.guardians = new ArrayList<>();
        this.guardians.add(new Guardian(Maze.WIDTH_WITHOUT_WALLS,1));
        this.guardians.add(new Guardian(Maze.WIDTH_WITHOUT_WALLS, Maze.HEIGHT_WITHOUT_WALLS));
        this.guardians.add(new Guardian(1, Maze.HEIGHT_WITHOUT_WALLS));
        this.respawnRelic();
        this.maze.revealNearPlayer(this.player.getX(), this.player.getY());
    }

    public boolean makeDecision(String choice) {
        if(choice.equals("?")) {
            this.menu.printHelp();
            return false;
        } else if(choice.equals("m")) {
            this.maze.revealAll();
            return false;
        } else if(choice.equals("c")){
            this.relic.activateCheat();
            return false;
        } else{
            Tile temp;
            if(choice.equals("a")) {
                temp = this.maze.getTile(this.player.getX() - 1, this.player.getY());
                if(!temp.isWalled()){
                    this.player.move(this.player.getX() - 1, this.player.getY());
                    this.maze.revealNearPlayer(this.player.getX(), this.player.getY());
                    this.relic.isCollected(this.player.getX(), this.player.getY());
                    return true;
                }
                this.menu.printInvalidMove();
                return false;
            } else if(choice.equals("w")) {
                temp = this.maze.getTile(this.player.getX(), this.player.getY() - 1);
                if(!temp.isWalled()) {
                    this.player.move(this.player.getX(), this.player.getY() - 1);
                    this.maze.revealNearPlayer(this.player.getX(), this.player.getY());
                    return true;
                }
                this.menu.printInvalidMove();
                return false;
            } else if(choice.equals("s")) {
                temp = this.maze.getTile(this.player.getX(), this.player.getY() + 1);
                if(!temp.isWalled()) {
                    this.player.move(this.player.getX(), this.player.getY() + 1);
                    this.maze.revealNearPlayer(this.player.getX(), this.player.getY());
                    return true;
                }
                this.menu.printInvalidMove();
                return false;
            } else if(choice.equals("d")) {
                temp = this.maze.getTile(this.player.getX() + 1, this.player.getY());
                if (!temp.isWalled()) {
                    this.player.move(this.player.getX() + 1, this.player.getY());
                    this.maze.revealNearPlayer(this.player.getX(), this.player.getY());
                    return true;
                }
                this.menu.printInvalidMove();
                return false;
            }
            return false;
        }
    }

    public boolean isPlayerDead(){
        for(Guardian guardian : guardians){
            if(guardian.getX() == player.getX() && guardian.getY() == player.getY()){
                return true;
            }
        }
        return false;
    }

    public void onPlayerDeath(){
        this.player.playerKilled();
        this.menu.printDeathMsg();
        printMaze(this.maze, this.player, this.relic, this.guardians);
        this.menu.printRelicInfo(this.relic);
        this.menu.printGameOver();
    }

    public void play(){
        this.menu.printHelp();
        while (this.relic.getNumSpawns() > 0) {
            printMaze(this.maze, this.player, this.relic, this.guardians);
            this.menu.printRelicInfo(this.relic);
            String input = this.menu.getInput();
            while (!makeDecision(input)){
                input = this.menu.getInput();
            }
            if(isPlayerDead()){
                onPlayerDeath();
                return;
            }else if(this.relic.isCollected(this.player.getX(), this.player.getY())){
                this.relic.collectRelic();
                respawnRelic();
            }
            for(Guardian guardian : guardians){
                guardian.move(this.maze);
            }
            if(isPlayerDead()){
                onPlayerDeath();
                return;
            }
        }
        this.menu.printWinMsg();
        this.maze.revealAll();
        printMaze(this.maze, this.player, this.relic, this.guardians);
    }

    public void respawnRelic(){
        Random rn = new Random();
        boolean isValidPosition = false;
        while(!isValidPosition) {
            int x = rn.nextInt(Maze.WIDTH_WITHOUT_WALLS - 1 + 1) + 1;
            int y = rn.nextInt(Maze.HEIGHT_WITHOUT_WALLS - 1 + 1) + 1;
            Tile temp = this.maze.getTile(x, y);
            if(!temp.isWalled() && x != this.player.getX() && y != this.player.getY()){
                this.relic.respawn(x , y);
                isValidPosition = true;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
