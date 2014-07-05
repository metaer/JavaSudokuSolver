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
        return new WrongInitialStringLengthMessage(length).getMessage();
    }
}

final class WrongInitialStringLengthMessage extends Message {
    public WrongInitialStringLengthMessage(int receivedLength){
        ru = "Ожидалась строка длиной 81 символ. Получена строка длиной " + receivedLength + " символов.";
        en = "Expected 81-length string. " + receivedLength + "-length string received.";
    }
}