package ru.metaer.javasudokusolver;

interface SudokuFieldInterface {

    int getCellValue(int col, int row);

    void setCellValue(int col, int row, int val);

    boolean completelyFilled();

    int[][] toArray();
}