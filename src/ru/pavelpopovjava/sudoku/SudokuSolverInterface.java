package ru.pavelpopovjava.sudoku;

interface SudokuSolverInterface {

    public String getSolutionJsonString(String str);

    public String getSolutionString(String str) throws UserErrorException;

    public byte[][] getSolutionArray(String str) throws UserErrorException;

    //TODO дописать сюда остальные методы, предоставляемые данной библиотекой.
}
