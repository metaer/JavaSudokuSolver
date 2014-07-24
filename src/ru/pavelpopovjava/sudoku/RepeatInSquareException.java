package ru.pavelpopovjava.sudoku;

public final class RepeatInSquareException extends WrongSudokuConditionException {
    private int col;
    private int row;
    private int squareNumber;
    private int figure;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getSquareNumber() {
        return squareNumber;
    }

    public int getFigure() {
        return figure;
    }

    RepeatInSquareException(int col, int row, int squareNumber, int figure) {
        this.col = col;
        this.row = row;
        this.squareNumber = squareNumber;
        this.figure = figure;
    }

    @Override
    public String getMessage() {
        return new RepeatInSquareMessage(col, row, squareNumber, figure).getMessage();
    }
}

final class RepeatInSquareMessage extends Message {
    RepeatInSquareMessage(int col, int row, int squareNumber, int figure) {
        ru = "Ошибка в ячейке (" + col + " ;" + row + "). " + "Цифра " + figure + " уже встречалась в малом квадрате №" + squareNumber;
        en = "Error in (" + col + " ;" + row + "). cell. Figure " + figure + "already founded in small square №" + squareNumber;
    }
}