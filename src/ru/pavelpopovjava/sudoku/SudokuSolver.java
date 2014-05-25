package ru.pavelpopovjava.sudoku;

public class SudokuSolver implements SudokuSolverInterface {

    private SudokuSolver instance = new SudokuSolver();

    public SudokuSolver getInstance() {
        return instance;
    }

    public String getSolutionJsonString(String str){

        String solution;

        try{
            solution = getSolutionString(str);
        }
        catch (UserErrorException e){
            if (e instanceof WrongInitialParameterException){

            }
            else if (e instanceof WrongSudokuConditionException){

            }
            else if (e instanceof NoSolutionException){

            }
        }

    }

    /**
     * Основной метод!
     * @param arr
     * @return
     * @throws UserErrorException
     */
    public byte[][] getSolutionArray(byte[][] arr) throws UserErrorException{
        Validator.validateInputArrayAsInitialParameter(arr);

        SudokuField field = new SudokuField(arr);

        field.validateSudokuCondition();

        SudokuTask task = new SudokuTask(field);
    }




    public String getSolutionString(String str) throws UserErrorException{
        return SudokuFieldConverter.toString(getSolutionArray(str));
    }

    public String getSolutionString(byte[][] arr) throws UserErrorException{
        return SudokuFieldConverter.toString(getSolutionArray(arr));
    }

    public byte[][] getSolutionArray(String str) throws UserErrorException{
        Validator.validateInputString(str);
        return getSolutionArray(SudokuFieldConverter.toArray(str));
    }

    /**
     * Конструктор закрыт, т.к. используем паттерн Singleton
     */
    private SudokuSolver(){}
}