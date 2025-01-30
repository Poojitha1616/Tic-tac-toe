import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            printBoard();
            makeMove(scanner);
            gameOver = checkForWin();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard();
        System.out.println("Game over!");
    }

    private static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    private static void makeMove(Scanner scanner) {
        System.out.println("Player " + currentPlayer + ", enter your move (row and column numbers, 1-3):");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid move, try again.");
            makeMove(scanner);
        } else if (board[row][col] != ' ') {
            System.out.println("Space already occupied, try again.");
            makeMove(scanner);
        } else {
            board[row][col] = currentPlayer;
        }
    }

    private static boolean checkForWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }
}