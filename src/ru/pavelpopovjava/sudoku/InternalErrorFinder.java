package ru.pavelpopovjava.sudoku;

class InternalErrorFinder {
    public static void condChecker(boolean condition, String code){
        if (!condition){
            throw new InternalErrorException("Internal Error in ru.pavelpopovjava.sudoku library. Error code: " + code);
        }
    }
}