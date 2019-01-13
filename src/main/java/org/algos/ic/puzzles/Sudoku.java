package org.algos.ic.puzzles;

public class Sudoku {

    //Initialization
    private static final Integer BOARD_SIZE = 9;
    private static final Integer MIN        = 1;
    private static final Integer MAX        = 9;
    private static final Integer BOX_SIZE   = 3;
    private static final int[][] board      = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

    public static void main(String[] args) {
        solvePuzzle();
    }

    private static void solvePuzzle() {

        //start with StartIndex, EndIndex with 0
        if (solve(0, 0)) {
            showResults();
        } else {
            System.out.println("No Sudoku Solution found for a given input.");
        }
    }

    private static boolean solve(int rowIndex, int colIndex) {

        System.out.println("Before Called solve method: rowIndex=" + rowIndex+" colIndex=" + colIndex);

        // return true if rowIndex and columnIndex is equal to BOARD_SIZE
        if (rowIndex == BOARD_SIZE && ++colIndex == BOARD_SIZE)
            return true;

        System.out.println("After Called solve method: rowIndex=" + rowIndex+" colIndex=" + colIndex);

        // If rowIndex reached BOARD_SIZE, reset the rowIndex to zero
        if (rowIndex == BOARD_SIZE) {
            System.out.println("Hop to next column, reinitialize rowIndex=0");
            rowIndex = 0;
        }

        //we don't want to manipulate values which already have value, Hence skip them.
        if (board[rowIndex][colIndex] != 0)
            return solve(rowIndex + 1, colIndex);

        for (int number = MIN; number <= MAX; ++number) {

            if (valid(rowIndex, colIndex, number)) {

                board[rowIndex][colIndex] = number;

                if (solve(rowIndex + 1, colIndex))
                    return true;

                //Backtrack
                board[rowIndex][colIndex] = 0;
            }
        }

        return false;
    }

    private static boolean valid(int colIndex, int rowIndex, int number) {

        //first-condition to check if the given number is already in the row

        for (int i = 0; i < BOARD_SIZE; ++i) {
            if (board[i][rowIndex] == number)
                return false;
        }

        //second-condition to check if the given number is already in column

        for (int k = 0; k < BOARD_SIZE; ++k) {
            if (board[colIndex][k] == number)
                return false;
        }

        //third-condition to check if it is with-in the box.

        int boxRowOffset = (colIndex / 3) * BOX_SIZE;
        int boxColOffset = (rowIndex / 3) * BOX_SIZE;

        for (int i = 0; i < BOX_SIZE; ++i) {

            for (int j = 0; j < BOX_SIZE; ++j) {

                if (number == board[boxRowOffset + i][boxColOffset + j])
                    return false;
            }
        }

        return true;

    }

    private static void showResults() {

        for (int i = 0; i < BOARD_SIZE; i++) {

            for (int j = 0; j < BOARD_SIZE; j++) {

                if (j % 3 == 0)
                    System.out.print(" ");

                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
