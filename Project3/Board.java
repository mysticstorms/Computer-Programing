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

    public boolean checkWin(char token) {
        // Check horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (grid[i][j] == token && 
                grid[i][j + 1] == token && 
                grid[i][j + 2] == token && 
                grid[i][j + 3] == token) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == token && 
                grid[i + 1][j] == token && 
                grid[i + 2][j] == token && 
                grid[i + 3][j] == token) {
                    return true;
                }
            }
        }

        // Check diagonal (/)
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (grid[i][j] == token && 
                grid[i - 1][j + 1] == token && 
                grid[i - 2][j + 2] == token && 
                grid[i - 3][j + 3] == token) {
                    return true;
                }
            }
        }

        // Check diagonal (\)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (grid[i][j] == token && 
                grid[i + 1][j + 1] == token && 
                grid[i + 2][j + 2] == token && 
                grid[i + 3][j + 3] == token) {
                    return true;
                }
            }
        }

        return false;
    }
}