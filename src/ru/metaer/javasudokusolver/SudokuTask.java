package ru.metaer.javasudokusolver;

class SudokuTask {
    private SudokuField initialField;
    private SudokuField currentField;
    private SudokuField outputField;

    SudokuTask(SudokuField initialField) {
        this.initialField = initialField;
        currentField = new SudokuField(this.initialField.toArray());
    }

    public SudokuField getSolution() {
        solveSudoku();
        outputField = initialField;//fixme Заглушка
        return outputField;
    }

    private void solveSudoku() {

    }
}
