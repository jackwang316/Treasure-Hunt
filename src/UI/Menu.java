package UI;

import Mechanics.Maze;

import java.util.Scanner;

public class Menu {
    private Maze maze;

    public Menu(Maze m){
        this.maze = m;
    }

    public void printHelp(){
        System.out.println("DIRECTIONS:");
        System.out.println("    Collect 3 relics!");
        System.out.println("LEGEND:");
        System.out.println("    #: Wall");
        System.out.println("    @: You (the treasure hunter)");
        System.out.println("    !: Guardian");
        System.out.println("    ^: Relic");
        System.out.println("    .: Unexplored space");
        System.out.println("Moves:");
        System.out.println("    Use W (up), A (left), S (down) and D (right) to move.");
        System.out.println("    (You must press enter after each move).");
    }

    public String getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your move [WASD?] : ");
        String input = sc.nextLine();
        input.trim().toLowerCase();
        while (!isInputValid(input)){
            System.out.println("Invalid move. Please enter just A(left), S(down), D(right) keys" +
                                "(both upper case and lower cases are acceptable).");
            System.out.print("Enter your move [WASD?] : ");
            input = sc.nextLine();
            input.trim().toLowerCase();
        }
        return input;
    }

    public boolean isInputValid(String input) {
        return (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")
                || input.equals("?") || input.equals("m") || input.equals("c"));
    }

    public static void printMaze(){

    }
}
