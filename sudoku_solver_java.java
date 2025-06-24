
import java.util.*;

public class SudokuSolver {
    private static final int SIZE = 9;
    private static final int EMPTY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Welcome to the Console Sudoku Solver!\n");
        System.out.println("Here's the current Sudoku board:");
        printBoard(board);

        System.out.println("\nWould you like to modify any cell? (y/n): ");
        String response = scanner.nextLine();

        while (response.equalsIgnoreCase("y")) {
            try {
                System.out.print("Enter row (1-9): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Enter column (1-9): ");
                int col = scanner.nextInt() - 1;
                System.out.print("Enter value (1-9, 0 to clear): ");
                int value = scanner.nextInt();

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || value < 0 || value > 9) {
                    System.out.println("Invalid input. Try again.\n");
                    scanner.nextLine(); // Clear buffer
                    continue;
                }

                if (value != 0 && !isSafe(board, row, col, value)) {
                    System.out.println("This move would break Sudoku rules. Try a different value.\n");
                    scanner.nextLine(); // Clear buffer
                    continue;
                }

                board[row][col] = value;
                System.out.println("Updated board:");
                printBoard(board);
                scanner.nextLine(); // Clear buffer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.\n");
                scanner.nextLine(); // Clear buffer
            }

            System.out.println("\nModify another cell? (y/n): ");
            response = scanner.nextLine();
        }

        System.out.println("\nAttempting to solve the puzzle...\n");
        if (solveSudoku(board)) {
            System.out.println("Success! Here's the solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists for the current board.");
        }

        System.out.println("\nThank you for using the Sudoku Solver. Goodbye!");
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = EMPTY;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print((board[row][col] == 0 ? "." : board[row][col]) + " ");
            }
            System.out.println();
        }
    }
}
