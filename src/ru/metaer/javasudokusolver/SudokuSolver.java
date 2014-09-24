package ru.metaer.javasudokusolver;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class SudokuSolver implements SudokuSolverInterface {
    private static SudokuSolver instance = new SudokuSolver();

    private String initialString = "not defined yet";

    private boolean showSolutionLogToConsole = false;

    String getInitialString() {
        return initialString;
    }

    public static SudokuSolver getInstance() {
        return instance;
    }

    public void setShowSolutionLogToConsole(boolean showSolutionLogToConsole) {
        this.showSolutionLogToConsole = showSolutionLogToConsole;
    }

    public void setShowSolutionLogToConsole() {
        this.showSolutionLogToConsole = true;
    }

    public boolean isShowSolutionLogToConsole() {
        return showSolutionLogToConsole;
    }

    /**
     * Метод 3.
     * Получает массив по строке. Использует метод 1.
     * @param str
     * @return
     * @throws SudokuSolverLibException
     */
    private int[][] getSolutionArray(String str) throws SudokuSolverLibException {
        initialString = str;
        Validator.validateInputString(str);
        str = Converter.pointsToZeros(str); //replace points to zeros
        return getSolutionArray(SudokuFieldConverter.toArray(str));
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
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            throw new InternalErrorException(sw.toString());
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
            if (field.completelyFilled()) {
                throw new TaskIsAlreadySolvedException();
            }
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