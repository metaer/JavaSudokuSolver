package ru.pavelpopovjava.sudoku;


public class InternalErrorException extends RuntimeException {

    private String message;

    InternalErrorException(){
        this.message = getFirstPartMessage();
    }

    public InternalErrorException(String message){
        this.message = getFirstPartMessage() + message;
    }

    public String getMessage(){
        return message;
    }

    private String getFirstPartMessage(){
        return new InternalErrorFirstPartMessage().getMessage();
    }

}

class InternalErrorFirstPartMessage extends Message {
    InternalErrorFirstPartMessage() {
        ru = "Внутренняя ошибка библиотеки ru.pavelpopovjava.sudoku: ";
        en = "Internal ru.pavelpopovjava.sudoku library error: ";
    }
}
