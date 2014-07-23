package ru.pavelpopovjava.sudoku;

public class SudokuLibraryInternalErrorForUserException extends SudokuSolverException {
    private String message;

    SudokuLibraryInternalErrorForUserException(String message){
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
