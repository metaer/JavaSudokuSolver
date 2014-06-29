package ru.pavelpopovjava.sudoku;

public final class WrongInitialStringLengthException extends WrongInitialStringException {

    private int length;

    public int getLength() {
        return length;
    }

    public WrongInitialStringLengthException(int length){
        super();
        this.length = length;
    }

    public String getMessage(){
        return "Ожидалась строка длиной 81 символ. Получена строка длиной " + String.valueOf(length) + " символов.";
    }
}
