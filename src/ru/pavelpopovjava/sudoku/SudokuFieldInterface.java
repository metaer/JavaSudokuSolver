package ru.pavelpopovjava.sudoku;

interface SudokuFieldInterface {

    public byte getCellValue(byte col, byte row);

    public byte setCellValue(byte col, byte row, byte val);

    public boolean completelyFilled();
}