package ru.metaer.javasudokusolver;

class SudokuConditionValidator {

    public static void validateInitialCondition(SudokuField field) throws WrongSudokuConditionException {
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
            int currentFigure = field.getCellContents(col, row);
            if (figures.contains(String.valueOf(currentFigure))) {
                throw new RepeatInRowException(col, row, currentFigure);
            }

            if (currentFigure != 0) {
                figures += currentFigure;
            }
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
            int currentFigure = field.getCellContents(col, row);
            if (figures.contains(String.valueOf(currentFigure))) {
                throw new RepeatInColumnException(col, row, currentFigure);
            }

            if (currentFigure != 0) {
                figures += currentFigure;
            }
        }
    }

    private static void validateSmallSquaresCondition(SudokuField field) throws RepeatInSquareException {

        for (int squareNumber = 0; squareNumber < 9; squareNumber++) {
            validateOneSmallSquare(field, squareNumber + 1);
        }

    }

    private static void validateOneSmallSquare(SudokuField field, int squareNumber) throws RepeatInSquareException {

        //Зададим начальные координаты x,y для обхода малого квадрата

        int x = getInitialXCoordBySmallSquareNumber(squareNumber);
        int y = getInitialYCoordBySmallSquareNumber(squareNumber);

        String figures = ""; //цифры в колонке

        for (int col = x; col <= x + 2; col++) {
            for (int row = y; row <= y + 2; row++) {

                int currentFigure = field.getCellContents(col, row);

                if (figures.contains(String.valueOf(currentFigure))) {
                    throw new RepeatInSquareException(col, row, squareNumber, currentFigure);
                }

                if (currentFigure != 0) {
                    figures += currentFigure;
                }

            }
        }


    }

    private static int getInitialXCoordBySmallSquareNumber(int n) {
        return 1 + 3 * (n - 1 - ((n - 1) / 3) * 3);
    }

    private static int getInitialYCoordBySmallSquareNumber(int n) {
        return 1 + ((n - 1) / 3) * 3;
    }

}
