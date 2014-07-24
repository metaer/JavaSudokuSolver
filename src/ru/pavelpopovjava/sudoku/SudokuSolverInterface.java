package ru.pavelpopovjava.sudoku;

/**
 * API библиотеки!
 */
interface SudokuSolverInterface extends SudokuLibraryInterface {

    /**
     * Получает массив по строке
     * На входе строка 81 символ: цифры от 1 до 9 и точки
     */
    public int[][] getSolutionArray(String str) throws SudokuSolverLibException;

    /**
     * Получает строку по строке.
     * На входе строка 81 символ: цифры от 1 до 9 и точки
     */
    public String getSolutionString(String str) throws SudokuSolverLibException;
}
