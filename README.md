# Console-Based Sudoku Solver in Java

This is an interactive Java console application that solves 9x9 Sudoku puzzles using a backtracking algorithm.  
The game starts with a predefined board, welcomes the user, and allows them to manually modify any cell before solving begins.  
Users can enter the row, column, and value to update cells, with built-in validation to prevent breaking Sudoku rules.

## Key Features

- Console-based interaction with a user-friendly flow  
- Real-time board editing with input validation  
- Backtracking algorithm for solving the puzzle  
- Graceful handling of invalid or unexpected input  
- Clean output with empty cells represented as dots (`.`) for better readability  

Perfect for practicing algorithm design and Java fundamentals in a hands-on way.

## Sample Output

Welcome to the Console Sudoku Solver!

Here's the current Sudoku board:

5 3 X X 7 X X X X  
6 X X 1 9 5 X X X  
X 9 8 X X X X 6 X  
8 X X X 6 X X X 3  
4 X X 8 X 3 X X 1  
7 X X X 2 X X X 6  
X 6 X X X X 2 8 X  
X X X 4 1 9 X X 5  
X X X X 8 X X 7 9

Would you like to modify any cell? (y/n): y
Enter row (1-9): 1
Enter column (1-9): 3
Enter value (1-9, 0 to clear): 4

Updated board:

5 3 4 X 7 X X X X  
6 X X 1 9 5 X X X  
X 9 8 X X X X 6 X  
8 X X X 6 X X X 3  
4 X X 8 X 3 X X 1  
7 X X X 2 X X X 6  
X 6 X X X X 2 8 X  
X X X 4 1 9 X X 5  
X X X X 8 X X 7 9

Modify another cell? (y/n): n

Attempting to solve the puzzle...

Success! Here's the solved Sudoku:

5 3 4 6 7 8 9 1 2  
6 7 2 1 9 5 3 4 8  
1 9 8 3 4 2 5 6 7  
8 5 9 7 6 1 4 2 3  
4 2 6 8 5 3 7 9 1  
7 1 3 9 2 4 8 5 6  
9 6 1 5 3 7 2 8 4  
2 8 7 4 1 9 6 3 5  
3 4 5 2 8 6 1 7 9


Thank you for using the Sudoku Solver. Goodbye!
