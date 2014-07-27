package ru.metaer.javasudokusolver;

public class FigureChecker {

    private SudokuField sudokuField;
    private int col;
    private int row;
    private int figure;

    public FigureChecker(SudokuField sudokuField, int col, int row, int figure) {
        this.sudokuField = sudokuField;
        this.col = col;
        this.row = row;
        this.figure = figure;
    }

    /**
     * Проверяет, может ли быть цифра кандидатом. Если да - возвращает true
     *
     * @return
     */
    public boolean checkFigureIfCanBeCandidate() {
        return (checkInRow() && checkInColumn() && checkInSmallSquare());
    }

    /**
     * Проверка в малом квадрате
     * @return
     */
    private boolean checkInSmallSquare() {
        int colBegin = convertToBeginCycleVarForSmallSquareCycle(this.col);
        int rowBegin = convertToBeginCycleVarForSmallSquareCycle(this.row);

        for (int colCycleVar = colBegin; colCycleVar <= colBegin + 2 ; colCycleVar++) {
            for (int rowCycleVar = rowBegin; rowCycleVar <= rowBegin + 2 ; rowCycleVar++) {
                int currentFigure = sudokuField.getCellContents(colCycleVar, rowCycleVar);
                if (currentFigure == figure) {
                    return false;
                }
            }
        }

        return true;
    }

    int convertToBeginCycleVarForSmallSquareCycle(int var) {
        return (var - 1) / 3 * 3 + 1;
    }

    /**
     * Проверка в колонке
     * Используем принцип DRY (проверка для ряда и для колонки схожая)
     * @return
     */
    private boolean checkInColumn() {
        return checkInLine(LineTypes.COL);
    }

    /**
     * Проверка в ряду
     * @return
     */
    private boolean checkInRow() {
        return checkInLine(LineTypes.ROW);
    }

    /**
     * Проверка в колонке/ряду
     * @param type - параметр из enum (в зависимости от него идет проверка либо в колонке, либо в ряду)
     * @return
     */
    private boolean checkInLine(LineTypes type) {
        for (int cellNumberInLine = 1; cellNumberInLine <= Constants.FIELD_SIZE; cellNumberInLine++) {
            int currentFigure = (type.equals(LineTypes.ROW) ? sudokuField.getCellContents(cellNumberInLine, row) : sudokuField.getCellContents(col, cellNumberInLine));
            if (currentFigure == figure) {
                return false;
            }
        }
        return true;
    }
}


enum LineTypes {
    COL,
    ROW
}