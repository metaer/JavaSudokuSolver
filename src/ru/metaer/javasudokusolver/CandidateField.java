package ru.metaer.javasudokusolver;

import java.util.ArrayList;

/**
 * Заметка. Для уже заполненных ячеек судоку-поля не может быть кандидатов
 */
class CandidateField extends Field {
    private ArrayList<Integer>[][] field = new ArrayList[9][9];

    @Override
    public ArrayList<Integer> getCellContents(int col, int row) {
        return field[col-1][row-1];
    }

    @Override
    public String getCellValueInStringPerformance(int col, int row) {
        String outputString = "";
        ArrayList<Integer> cell = getCellContents(col, row);
        if (cell != null) {
            for (int candidate : cell) {
                outputString += candidate;
            }
        }

        //Теперь нужно дополнить строку пробелами до 9 символов, чтоб не съехала.
        outputString = StringHelper.fillWithSpaces(outputString, Constants.FIELD_SIZE);

        return outputString;
    }

    @Override
    public String getAdditionalSymbolsForRendering() {
        return "________";
    }

    public void setCandidatesByCoordinates(int col, int row, ArrayList<Integer> val) {
        field[col-1][row-1] = val;
    }

    private void fillArrayWithEmptyElements() {
        for (int col = 0; col < Constants.FIELD_SIZE; col++) {
            for (int row = 0; row < Constants.FIELD_SIZE; row++) {
                field[col][row] = new ArrayList<Integer>();
            }
        }
    }


    /**
     * Составляет список кандидатов для каждой незаполненной ячейки
     * @param sudokuField
     */
    public void makeCandidatesField(SudokuField sudokuField) {
        for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
            for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
                if (sudokuField.cellIsFilled(col, row)) {
                    continue;
                }
                setCandidatesByCoordinates(col, row, makeCandidatesListByCoordinates(sudokuField, col, row));
            }
        }
    }

    /**
     * Составляет список кандидатов для заданной ячейки
     * @param sudokuField
     * @param col
     * @param row
     * @return
     */
    private ArrayList<Integer> makeCandidatesListByCoordinates(SudokuField sudokuField, int col, int row) {
        ArrayList candidates = new ArrayList<Integer>();
        for (int figure = 1; figure <= Constants.FIELD_SIZE; figure++) {
            if (new FigureChecker(sudokuField, col, row, figure).checkFigureIfCanBeCandidate()) {
                candidates.add(figure);
            }
        }
        return candidates;
    }

    /**
     * Возвращает true, если хотя бы для одной ячейки (не считая заполненных) нет кандидатов
     * @return
     */
    public boolean hasNoCandidatesForAtListOneOfFilledCells(SudokuField sudokuField) {
        for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
            for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
                if (sudokuField.cellIsFilled(col, row)) {
                    continue; //Пропускаем проверку для заполненных ячеек
                }

                ArrayList<Integer> currentCell = getCellContents(col, row);
                if (isEmpty(currentCell)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNotEmpty(ArrayList<Integer> currentCell) {
        return !isEmpty(currentCell);
    }

    private boolean isEmpty(ArrayList<Integer> currentCell) {
        if (currentCell == null || currentCell.isEmpty()) {
            return true;
        }
        return false;
    }

}
