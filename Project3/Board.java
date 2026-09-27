public class Board {
    private char[][] grid;
    private final int ROWS = 6;
    private final int COLS = 7;

    public Board() {
        grid = new char[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = '.';
            }
        }
    }


    public void printBoard() {
        System.out.println("1 2 3 4 5 6 7");
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public boolean dropToken(int col, char playerToken) {
        if (col < 0 || col >= COLS) {
            System.out.println("Invalid column. Please choose a column between 1 and 7.");
            return false;
        }

        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][col] == '.') {
                grid[i][col] = playerToken;
                return true;
            }
        }

        System.out.println("Column is full. Please choose another column.");
        return false;
    }
}