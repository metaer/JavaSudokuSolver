package ru.pavelpopovjava.sudoku;

interface LocalManagerInterface extends SudokuLibraryInterface {
    public void setCurrentLocale(String currentLocale);
    public String getCurrentLocale();
}
