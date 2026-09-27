import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Scanner scanner = new Scanner(System.in);

        boolean isPlayer1Turn = true;
        boolean gameActive = true;

        System.out.println("Welcome to Connect 4!");

        while (gameActive) {
            gameBoard.printBoard();

            char currentPlayer = isPlayer1Turn ? 'X' : 'O';
            System.out.println("Player " + currentPlayer + ", enter a column from 1-7: ");

            int col = scanner.nextInt() - 1;

            if (gameBoard.dropToken(col, currentPlayer)) {
            
                if (gameBoard.checkWin(currentPlayer)) {
                    gameBoard.printBoard();
                    System.out.println("Player " + currentPlayer + " wins! Game over.");
                    gameActive = false;
                } else {
                    isPlayer1Turn = !isPlayer1Turn;
                }
            }
        }
    scanner.close();
    }
}