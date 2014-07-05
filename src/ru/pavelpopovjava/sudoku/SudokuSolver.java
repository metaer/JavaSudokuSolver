package ru.pavelpopovjava.sudoku;

public final class SudokuSolver implements SudokuSolverInterface {

    private static SudokuSolver instance = new SudokuSolver();

    public static SudokuSolver getInstance() {
        return instance;
    }

    /**
     * Метод 1. Основной метод!
     * Получает массив по массиву
     * @param arr
     * @return
     * @throws SudokuSolverException
     */
    public int[][] getSolutionArray(int[][] arr) throws SudokuSolverException{

        Validator.validateInputArrayAsInitialParameter(arr);

        SudokuField field = new SudokuField(arr);

        field.validateSudokuCondition();

        //SudokuTask task = new SudokuTask(field);

        return new int[9][9];
    }


    /**
     * Метод 2.
     * Получает строку по массиву. Использует метод 1.
     * @param arr
     * @return
     * @throws SudokuSolverException
     */
    public String getSolutionString(int[][] arr) throws SudokuSolverException{
        return SudokuFieldConverter.toString(getSolutionArray(arr));
    }

    /**
     * Метод 3.
     * Получает массив по строке. Использует метод 1.
     * @param str
     * @return
     * @throws SudokuSolverException
     */
    public int[][] getSolutionArray(String str) throws SudokuSolverException{
        Validator.validateInputString(str);
        return getSolutionArray(SudokuFieldConverter.toArray(str));
    }

    /**
     * Метод 4.
     * Получает строку по строке. Использует метод 3, который в свою очередь использует Метод 1.
     * @param str
     * @return
     * @throws SudokuSolverException
     */
    public String getSolutionString(String str) throws SudokuSolverException{
        return SudokuFieldConverter.toString(getSolutionArray(str));
    }


    /**
     * Конструктор закрыт, т.к. используем паттерн Singleton
     */
    private SudokuSolver(){}
}