package tictactoe;

public class Grid {
    private String[][] grid = new String[3][3];

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void newGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j % 2 == 0) {
                    grid[i][j] = " ";
                } else {
                    grid[i][j] = " ";
                }

            }
        }
    }

    public void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);

                System.out.print(" ");

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public void setGrid(String input) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = String.valueOf(input.charAt(counter));
                counter++;
            }

        }
    }

    public void checkGrid() {
        if (!winner(grid).equals("1")) {
            System.out.println(winner(grid));
        }

    }

    public String getResult() {
        return winner(grid);
    }


    public String winner(String board[][]) {
        String checkedSign = "X";
        Boolean x = false;
        Boolean o = false;

        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                checkedSign = "O";
            }
            if (board[0][0].equals(checkedSign) && board[0][1].equals(checkedSign) && board[0][2].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            } else if (board[1][0].equals(checkedSign) && board[1][1].equals(checkedSign) && board[1][2].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            } else if (board[2][0].equals(checkedSign) && board[2][1].equals(checkedSign) && board[2][2].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            } else if (board[0][0].equals(checkedSign) && board[1][0].equals(checkedSign) && board[2][0].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            } else if (board[0][1].equals(checkedSign) && board[1][1].equals(checkedSign) && board[2][1].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            } else if (board[0][2].equals(checkedSign) && board[1][2].equals(checkedSign) && board[2][2].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            } else if (board[0][0].equals(checkedSign) && board[1][1].equals(checkedSign) && board[2][2].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            } else if (board[0][2].equals(checkedSign) && board[1][1].equals(checkedSign) && board[2][0].equals(checkedSign)) {
                if (checkedSign == "X") {
                    x = true;
                } else {
                    o = true;
                }
            }
        }

//        if (x == true && o == true) {
//            return "Impossible";
//        } else

        if (x == true || o == true) {
            if (x == true) {
                return "X wins";
            } else {
                return "O wins";
            }

        } else {
            int numOfSigns = 0;
            int numOfX = 0;
            int numOfO = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals("X") || board[i][j].equals("O")) {
                        numOfSigns++;
                        if (board[i][j].equals("X")) {
                            numOfX++;
                        } else {
                            numOfO++;
                        }
                    }
                }


            }
            if (Math.abs(numOfO - numOfX) >= 2) {
                return "Impossible";
            } else if (numOfSigns == 9) {
                return "Draw";
            } else {
                return "1";
            }
        }


    }


    public boolean checkMove(int[] move, int counter) {
        if (move[0] < 1 || move[1] < 1 || move[0] > 3 || move[1] > 3) {
            System.out.println("Coordinates should be from 1 to 3!");

            return false;
        } else if (grid[move[0] - 1][move[1] - 1].equals("X") || grid[move[0] - 1][move[1] - 1].equals("O")) {

            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            if (counter % 2 == 1) {
                grid[move[0] - 1][move[1] - 1] = "X";
                return true;
            } else {
                grid[move[0] - 1][move[1] - 1] = "O";
                return true;
            }

        }

    }
}