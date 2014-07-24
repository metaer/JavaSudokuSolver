package ru.metaer.javasudokusolver;

public final class WrongInitialStringLengthException extends WrongInitialStringException {

    private int passedLength;

    public int getPassedLength() {
        return passedLength;
    }

    public WrongInitialStringLengthException(int passedLength){
        super();
        this.passedLength = passedLength;
    }

    @Override
    public String getMessage(){
        return new WrongInitialStringLengthMessage(passedLength).getMessage();
    }
}

final class WrongInitialStringLengthMessage extends Message {
    public WrongInitialStringLengthMessage(int receivedLength){
        ru = "Ожидалась строка длиной 81 символ. Получена строка длиной " + receivedLength + " символов.";
        en = "Expected 81-length string. " + receivedLength + "-length string received.";
    }
}