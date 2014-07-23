package ru.pavelpopovjava.sudoku;

public final class RepeatInColumnException extends WrongSudokuConditionException {
    private int col;
    private int row;

    public RepeatInColumnException(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
