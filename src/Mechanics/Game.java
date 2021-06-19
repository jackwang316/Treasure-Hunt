package Mechanics;
import UI.Menu;

public class Game {
    private Player player;
    private Relic relic;
    private Maze maze;
    private Menu menu;

    public Game(){
        this.maze = new Maze();
        this.menu = new Menu(this.maze);
        this.player = new Player();
        this.relic = new Relic();
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
                    return true;
                }
            } else if(choice.equals("w")) {
                temp = maze.getCell(player.getX(), player.getY() - 1);
                if(!temp.isWalled()) {
                    player.move(player.getX(), player.getY() - 1);
                    return true;
                }
            } else if(choice.equals("s")) {
                temp = maze.getCell(player.getX(), player.getY() + 1);
                if(!temp.isWalled()) {
                    player.move(player.getX(), player.getY() + 1);
                    return true;
                }
            } else if(choice.equals("d")) {
                temp = maze.getCell(player.getX() + 1, player.getY());
                if (!temp.isWalled()) {
                    player.move(player.getX() + 1, player.getY());
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
