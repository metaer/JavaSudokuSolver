package ru.metaer.javasudokusolver;

public final class SudokuSolver implements SudokuSolverInterface {

    private static SudokuSolver instance = new SudokuSolver();

    private String initialString = "not defined yet";

    String getInitialString() {
        return initialString;
    }

    public static SudokuSolver getInstance() {
        return instance;
    }


    /**
     * Метод 3.
     * Получает массив по строке. Использует метод 1.
     * @param str
     * @return
     * @throws SudokuSolverLibException
     */
    public int[][] getSolutionArray(String str) throws SudokuSolverLibException {
        try{
            initialString = str;
            Validator.validateInputString(str);
            str = Converter.pointsToZeros(str); //replace points to zeros
            return getSolutionArray(SudokuFieldConverter.toArray(str));
        }
        catch (RuntimeException e) { //catch internal library errors
            throw new InternalErrorException(e.toString());
        }
    }

    /**
     * Метод 4.
     * Получает строку по строке. Использует метод 3, который в свою очередь использует Метод 1.
     * @param str
     * @return
     * @throws SudokuSolverLibException
     */
    public String getSolutionString(String str) throws SudokuSolverLibException {
        try{
            return SudokuFieldConverter.toString(getSolutionArray(str));
        }
        catch (RuntimeException e) { //catch internal library errors
            throw new InternalErrorException(e.toString());
        }
    }

    /**
     * Метод 1. Основной метод!
     * Получает массив по массиву
     * @param arr
     * @return
     * @throws SudokuSolverLibException
     */
    private int[][] getSolutionArray(int[][] arr) throws SudokuSolverLibException {

            SudokuField field = new SudokuField(arr);

            field.validateSudokuCondition();

            SudokuTask task = new SudokuTask(field); //pass pure field to SudokuTask

            SudokuField solution = task.getSolution();

            return solution.toArray();
    }


    /**
     * Метод 2.
     * Получает строку по массиву. Использует метод 1.
     * @param arr
     * @return
     * @throws SudokuSolverLibException
     */
    private String getSolutionString(int[][] arr) throws SudokuSolverLibException {
        return SudokuFieldConverter.toString(getSolutionArray(arr));
    }


    /**
     * Конструктор закрыт, т.к. используем паттерн Singleton
     */
    private SudokuSolver(){}
}