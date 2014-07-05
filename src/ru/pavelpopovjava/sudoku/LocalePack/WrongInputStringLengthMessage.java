package ru.pavelpopovjava.sudoku.LocalePack;

public class WrongInputStringLengthMessage extends Message {
    WrongInputStringLengthMessage(int receivedLength){
        this.ru = "Ожидалась строка длиной 81 символ. Получена строка длиной " + receivedLength + " символов.";
        this.en = "Expected 81-length string. " + receivedLength + "-length string received.";
    }
}
