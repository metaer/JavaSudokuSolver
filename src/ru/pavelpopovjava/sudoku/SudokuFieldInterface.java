package ru.pavelpopovjava.sudoku;

interface SudokuFieldInterface {

    public int getCellValue(int col, int row);

    public void setCellValue(int col, int row, int val);

    public boolean completelyFilled();
}