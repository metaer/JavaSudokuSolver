package ru.pavelpopovjava.sudoku;

/**
 * API библиотеки!
 */
interface SudokuSolverInterface {

    /**
     * Получает массив по массиву
     * Входящий массив должен быть размером 9х9 и элементы - цифры от 0 до 9. На выходе массив 9х9, цифры от 1 до 9
     */
    public int[][] getSolutionArray(int[][] arr) throws SudokuSolverException;


    /**
     * Получает строку по массиву
     * Входящий массив должен быть размером 9х9 и элементы - цифры от 0 до 9. На выходе строка длиной 81 символ с цифрами от 1 до 9
     */
    public String getSolutionString(int[][] arr) throws SudokuSolverException;

    /**
     * Получает массив по строке
     * На входе строка 81 символ: цифры от 1 до 9 и точки
     */
    public int[][] getSolutionArray(String str) throws SudokuSolverException;

    /**
     * Получает строку по строке.
     */
    public String getSolutionString(String str) throws SudokuSolverException;

    /**
     * Json строка с решением или инфой об ошибке
     */
    public String getSolutionJsonString(String str);

}
