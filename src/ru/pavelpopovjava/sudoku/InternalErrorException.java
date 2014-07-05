package ru.pavelpopovjava.sudoku;


public class InternalErrorException extends RuntimeException {

    final private String INTERNAL_LIBRARY_MESSAGE = "Внутренняя ошибка библиотеки ru.pavelpopovjava.sudoku: ";

    private String message;

    InternalErrorException(){
    }

    public InternalErrorException(String message){
        this.message = INTERNAL_LIBRARY_MESSAGE + message;
    }

    public String getMessage(){
        return message;
    }

}
