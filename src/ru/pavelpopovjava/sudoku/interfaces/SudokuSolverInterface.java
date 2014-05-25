package ru.pavelpopovjava.sudoku.interfaces;

import ru.pavelpopovjava.sudoku.exceptions.UserErrorException;

public interface SudokuSolverInterface {

    public String getSolutionJsonString(String str);

    public String getSolutionString(String str) throws UserErrorException;

    public byte[][] getSolutionArray(String str) throws UserErrorException;
}
