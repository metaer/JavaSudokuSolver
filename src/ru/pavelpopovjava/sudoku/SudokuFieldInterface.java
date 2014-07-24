package ru.pavelpopovjava.sudoku;

interface SudokuFieldInterface {

    int getCellValue(int col, int row);

    void setCellValue(int col, int row, int val);

    boolean completelyFilled();

    int[][] toArray();
}