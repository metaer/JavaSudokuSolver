package ru.metaer.javasudokusolver;

interface SudokuFieldInterface {

    Integer getCellContents(int col, int row);

    void setCellValue(int col, int row, int val);

    boolean completelyFilled();

    int[][] toArray();
}