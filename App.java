package tictactoe;

import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private Grid game1;
    private String[] selection;
    private int[] selectionToInt;
    private boolean status;

    public App() {
        this.game1 = new Grid();
        this.selection = new String[2];
        this.selectionToInt = new int[2];
    }

    public void run() {
        game1.newGrid();
        int counter = 1;


        do {
            game1.printGrid();
            do {

                selection = scanner.nextLine().split(" ");
                try {
                    selectionToInt[0] = Integer.parseInt(selection[0]);
                    selectionToInt[1] = Integer.parseInt(selection[1]);


                } catch (NumberFormatException ex) {
                    System.out.println("You should enter numbers!");
                }
                status = game1.checkMove(selectionToInt, counter);


            } while (!status);
            counter++;
        } while (!game1.getResult().equals("X wins") && !game1.getResult().equals("O wins") && !game1.getResult().equals("Draw"));

        game1.printGrid();
        game1.checkGrid();
    }
}