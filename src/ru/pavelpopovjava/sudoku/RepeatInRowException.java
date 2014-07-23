package ru.pavelpopovjava.sudoku;

public final class RepeatInRowException extends WrongSudokuConditionException {
    private int col;
    private int row;

    public RepeatInRowException(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
