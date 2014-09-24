package ru.metaer.javasudokusolver;

import java.util.ArrayList;

class SudokuTask {
    private String currentId = "1";
    private SudokuField initialField;
    private SudokuField outputField;
    private SudokuTaskTree tree;

    SudokuTask(SudokuField initialField) {
        this.initialField = initialField;
        tree = new SudokuTaskTree(currentId, initialField);
    }

    public SudokuField getSolution() throws NoSolutionException{
        if (SudokuSolver.getInstance().isShowSolutionLogToConsole()) {
            Logger.println("Начанаем решать. Начальное поле:");
            Logger.printField(initialField);
        }
        solveSudoku();
        return outputField;
    }

    /**
     * Может устанавливать переменную outputField
     * @throws NoSolutionException
     */
    private void solveSudoku() throws NoSolutionException{
        while (true) {
            SudokuField sudokuField = getCurrentField();
            CandidatesField candidatesField = new CandidatesField();

            Logger.println("Составляем список кандидатов для каждой пустой ячейки...");
            candidatesField.makeCandidatesField(sudokuField);
            Logger.println("Вот они:");
            Logger.printField(candidatesField);

            //Если хотя бы для одной незаполненной ячейки нет кандидатов:
            if (candidatesField.hasNoCandidatesForAtListOneOfFilledCells(sudokuField)) {
                impasseHandler(candidatesField); //Зашли в тупик. Обработаем эту ситуацию.
                continue;
            }

            //Если есть свободные ячейки, для которых имеется ровно 1 кандидат - проставляем таких кандидатов в судоку-поле, продолжаем цикл сначала
            if (putDownCellsWithExactlyOneCandidate(sudokuField, candidatesField)) {
                //Если задача решена, устанавлиаем решение. Если нет - продолжаем цикл.
                if (sudokuField.completelyFilled()) {
                    outputField = sudokuField;
                    return;
                }
                continue;
            } else {
                forAllEmptyCellsHaveTwoOrMoreCandidatesHandler(sudokuField, candidatesField);
            }
        }
    }

    private void forAllEmptyCellsHaveTwoOrMoreCandidatesHandler(SudokuField sudokuField, CandidatesField candidatesField) throws NoSolutionException {
        //Если ещё не рассматривались кандидаты на текущем id
        if (tree.noOneCandidateWasConsidered(currentId)) {
            saveCoordinatesAndCandidatesToTree(candidatesField);
        }

        //TODO если предположение подтвердится - удалить следующий блок кода
        //Если уже все кандидаты рассматривались на текущем id
        if (tree.allCandidateWereConsidered(currentId)) {
            //fixme сюда не зайдет! Если зайдет вывести сообщение с кучей "!"
            System.out.println("Сцуко зашло!!!!!!!!!!!");
            System.exit(0);
            impasseHandler(candidatesField); //Зашли в тупик. Обработаем эту ситуацию.
            return;
        }

        int col = tree.getCol(currentId);
        int row = tree.getRow(currentId);
        //Проставляем n-го кандидата, где n - количество уже рассмотренных кандидатов. Нумерация в списке кандидатов с 0!
        SudokuField newSudokuField = new SudokuField(sudokuField.toArray());
        newSudokuField.setCellValue(col, row, tree.getCandidate(currentId, tree.getNumberOfConsideredCandidates(currentId)));
        convertId();
        tree.incrementNumberOfConsideredCandidates(currentId);
        tree.setSudokuField(currentId, newSudokuField);
    }

    private void saveCoordinatesAndCandidatesToTree(CandidatesField candidatesField) {
        int[] coordinates = getCoordinatesWithMinNumberOfCandidates(candidatesField);
        tree.setCol(currentId, coordinates[0]);
        tree.setRow(currentId, coordinates[1]);
        tree.setCandidates(currentId, candidatesField.getCellContents(coordinates[0], coordinates[1]));
    }

    private int[] getCoordinatesWithMinNumberOfCandidates(CandidatesField candidatesField) {
        for (int i = 2; i <= 9; i++) {
            for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
                for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
                    ArrayList candidates = candidatesField.getCellContents(col, row);
                    if (candidates != null && candidates.size() == i) {
                        return new int[]{col, row};
                    }
                }
            }
        }
        return null;
    }

    private void impasseHandler(CandidatesField candidatesField) throws NoSolutionException {
        if (tree.getLevelById(currentId) == 1) {
            throw new NoSolutionException();
        }
        else {
            convertId();
            return;
        }
    }

    private void convertId() {
        if (tree.getCandidatesById(currentId) == null || tree.allCandidateWereConsidered(currentId)) {
            currentId = StringHelper.removeLastChar(currentId);
        } else if (tree.noOneCandidateWasConsidered(currentId)) {
            currentId += "1";
        }
        else {
            char lastChar = currentId.charAt(currentId.length() - 1);
            String newLastChar = String.valueOf(Integer.valueOf(lastChar) + 1);
            currentId = StringHelper.removeLastChar(currentId);
            currentId = currentId + newLastChar;
        }
    }

    /**
     * Если есть ячейки, для которых имеется ровно один кандидат, возвращает true и проставляет кандидатов в такие ячейки
     * @param sudokuField
     * @param candidatesField
     * @return
     */
    private boolean putDownCellsWithExactlyOneCandidate(SudokuField sudokuField, CandidatesField candidatesField) {
        boolean returnValue = false;
        for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
            for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
                ArrayList<Integer> cellContentsInCandidatesField = candidatesField.getCellContents(col, row);
                if (cellContentsInCandidatesField != null && cellContentsInCandidatesField.size() == 1) {
                    sudokuField.setCellValue(col, row, cellContentsInCandidatesField.get(0));
                    returnValue = true;
                }
            }
        }
        Logger.printField(sudokuField);
        return returnValue;
    }

    private SudokuField copyField(SudokuField field) {
        return new SudokuField(field.toArray());
    }

    private SudokuField getCurrentField() {
        return tree.getSudokuFieldById(currentId);
    }
}
