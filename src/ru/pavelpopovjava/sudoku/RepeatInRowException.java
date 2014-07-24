package ru.pavelpopovjava.sudoku;

public final class RepeatInRowException extends WrongSudokuConditionException {
    private int col;
    private int row;
    private int figure;

    @Override
    public String getMessage() {
        return new RepeatInRowException(col, row, figure).getMessage();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getFigure() {
        return figure;
    }

    public RepeatInRowException(int col, int row, int figure) {
        this.col = col;
        this.row = row;
        this.figure = figure;
    }
}

final class RepeatInRowMessage extends Message {
    RepeatInRowMessage(int col, int row, int figure) {
        ru = "Ошибка в ячейке (" + col + " ;" + row + "). " + "Цифра " + figure + " уже встречалась в ряду №" + row;
        en = "Error in (" + col + " ;" + row + "). cell. Figure " + figure + "already founded in row №" + row;
    }
}