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
        Logger.println("Начанаем решать. Начальное поле:");
        solveSudoku();
        Logger.println("Задача решена");
        Logger.printField(outputField);
        return outputField;
    }

    /**
     * Может устанавливать переменную outputField
     * @throws NoSolutionException
     */
    private void solveSudoku() throws NoSolutionException{
        int iteration = 0;
        while (true) {
            iteration++;
//            if (iteration == 35) {
//                System.exit(0);
//            }
            Logger.println("Итерация № " + iteration);
            SudokuField sudokuField = getCurrentField();
            Logger.printField(sudokuField);
            CandidatesField candidatesField = new CandidatesField();

            Logger.println("Текущий id: " + currentId);
            Logger.println("Составляем список кандидатов для каждой пустой ячейки...");
            candidatesField.makeCandidatesField(sudokuField);
            Logger.println("Вот они:");
            Logger.printField(candidatesField);

            //Если хотя бы для одной незаполненной ячейки нет кандидатов:
            if (candidatesField.hasNoCandidatesForAtListOneOfFilledCells(sudokuField)) {
                impasseHandler(candidatesField); //Зашли в тупик. Обработаем эту ситуацию.
                continue;
            }

            //Если есть хотя бы одна свободная ячейка, для которой имеется ровно 1 кандидат - проставляем и продолжаем цикл сначала
            if (putDownCellWithExactlyOneCandidate(sudokuField, candidatesField)) {
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

        //Если уже все кандидаты рассматривались на текущем id
        if (tree.allCandidateWereConsidered(currentId)) {
            impasseHandler(candidatesField); //Зашли в тупик. Обработаем эту ситуацию.
            return;
        }

        int col = tree.getCol(currentId);
        int row = tree.getRow(currentId);
        //Проставляем n-го кандидата, где n - количество уже рассмотренных кандидатов. Нумерация в списке кандидатов с 0!
        SudokuField newSudokuField = copyField(sudokuField);
        newSudokuField.setCellValue(col, row, tree.getCandidate(currentId, tree.getNumberOfConsideredCandidates(currentId)));
        currentId = levelDown(currentId);
        tree.incrementNumberOfConsideredCandidates(leveUp(currentId));
        tree.setSudokuField(currentId, newSudokuField);
    }

    private String leveUp(String id) {
        return StringHelper.removeLastChar(id);
    }

    private void saveCoordinatesAndCandidatesToTree(CandidatesField candidatesField) {
        int[] coordinates = getCoordinatesWithMinNumberOfCandidates(candidatesField);
        tree.setCol(currentId, coordinates[0]);
        tree.setRow(currentId, coordinates[1]);
        tree.setCandidates(currentId, candidatesField.getCellContents(coordinates[0], coordinates[1]));
    }

    private int[] getCoordinatesWithMinNumberOfCandidates(CandidatesField candidatesField) {
        for (int i = 2; i <= 9; i++) {
            for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
                for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
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
            currentId = leveUp(currentId);
            return;
        }
    }

    private String levelDown(String id) {
        return id + String.valueOf(tree.getNumberOfConsideredCandidates(id) + 1);
    }

    /**
     * Если есть ячейки, для которых имеется ровно один кандидат, возвращает true и проставляет кандидатов в такие ячейки
     * @param sudokuField
     * @param candidatesField
     * @return
     */
    private boolean putDownCellWithExactlyOneCandidate(SudokuField sudokuField, CandidatesField candidatesField) {
        for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
            for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
                ArrayList<Integer> cellContentsInCandidatesField = candidatesField.getCellContents(col, row);
                if (cellContentsInCandidatesField != null && cellContentsInCandidatesField.size() == 1) {
                    sudokuField.setCellValue(col, row, cellContentsInCandidatesField.get(0));
                    return true;
                }
            }
        }
        return false;
    }

    private SudokuField copyField(SudokuField field) {
        return new SudokuField(field.toArray());
    }

    private SudokuField getCurrentField() {
        return tree.getSudokuFieldById(currentId);
    }
}
