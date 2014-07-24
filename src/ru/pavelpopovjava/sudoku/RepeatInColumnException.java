package ru.pavelpopovjava.sudoku;

public final class RepeatInColumnException extends WrongSudokuConditionException {
    private int col;
    private int row;
    private int figure;

    @Override
    public String getMessage() {
        return new RepeatInColumnException(col, row, figure).getMessage();
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

    public RepeatInColumnException(int col, int row, int figure) {
        this.col = col;
        this.row = row;
        this.figure = figure;
    }
}

final class RepeatInColumnMessage extends Message {
    RepeatInColumnMessage(int col, int row, int figure) {
        ru = "Ошибка в ячейке (" + col + " ;" + row + "). " + "Цифра " + figure + " уже встречалась в колонке №" + col;
        en = "Error in (" + col + " ;" + row + "). cell. Figure " + figure + "already founded in row №" + col;
    }
}