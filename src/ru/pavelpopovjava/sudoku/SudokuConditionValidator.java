package ru.pavelpopovjava.sudoku;

class SudokuConditionValidator {

    public static void validateInitialCondition(SudokuField field) throws WrongSudokuConditionException{
        validateRowsCondition(field);
        validateColsCondition(field);
        validateSmallSquaresCondition(field);
    }

    private static void validateRowsCondition(SudokuField field) throws RepeatInRowException {
        for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
            validateOneRowCondition(field, row);
        }
    }

    private static void validateOneRowCondition(SudokuField field, int row) throws RepeatInRowException {

        String figures = ""; //цифры в строке

        for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
            int currentFigure = field.getCellValue(col,row);
            if (figures.contains(String.valueOf(currentFigure))) {
                throw new RepeatInRowException(col,row);
            }
            figures += currentFigure;
        }
    }

    private static void validateColsCondition(SudokuField field) throws RepeatInColumnException {
        for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
            validateOneColCondition(field, col);
        }
    }

    private static void validateOneColCondition(SudokuField field, int col) throws RepeatInColumnException {

        String figures = ""; //цифры в колонке

        for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
            int currentFigure = field.getCellValue(col,row);
            if (figures.contains(String.valueOf(currentFigure))) {
                throw new RepeatInColumnException(col,row);
            }
            figures += currentFigure;
        }
    }

    private static void validateSmallSquaresCondition(SudokuField field) throws RepeatInSquareException {

    }


}
