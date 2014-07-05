package ru.pavelpopovjava.sudoku;

import java.util.List;

public final class WrongInitialStringSymbolException extends WrongInitialStringException {

    private char[] foundedSymbols;

    //Позиции ошибочных символов (начиная осчет от 1)
    private int[] errorSymbolPositions;

    /**
     * Переданная строка
     */
    private String initialString;



    public char[] getFoundedSymbols() {
        return foundedSymbols;
    }

    public int[] getErrorSymbolPositions() {

        return errorSymbolPositions;
    }

    public String getInitialString() {

        return initialString;
    }

    public WrongInitialStringSymbolException(String initialString, int[] errorSymbolPositions, char[] foundedSymbols) {
        this.initialString = initialString;
        this.errorSymbolPositions = errorSymbolPositions;
        this.foundedSymbols = foundedSymbols;

    }

    public String getMessage() {

        if (errorSymbolPositions.length == 0) {
            new InternalErrorException(new NullSizeArrayMessage().getMessage());
        }

        if (errorSymbolPositions.length != foundedSymbols.length){
            new InternalErrorException(new DifferentArraySizeMessage().getMessage());
        }

        if (errorSymbolPositions.length == 1){
//            return  getFirstPartMessage() + "В позиции "
//                    + errorSymbolPositions[0] + " ожидалась цифра от 1 до 9 либо точка. Найден символ \"" +
//                    foundedSymbols[0] + "\"";

            return new WrongInitialStringSymbolMessage(errorSymbolPositions[0], foundedSymbols[0], initialString).getMessage();
        }
        else {
//            return getFirstPartMessage() + "В позициях " + arrayToString(Arrays.asList(errorSymbolPositions), false) +
//                    " ожидались цифры от 1 до 9 либо точки. Найдены символы " + arrayToString(Arrays.asList(errorSymbolPositions), true);
            return new WrongInitialStringSymbolMessage(errorSymbolPositions, foundedSymbols, initialString).getMessage();
        }
    }

    private <T> String arrayToString(List<T> array, boolean inQuotes) {
        String str = "";

        String quote = inQuotes ? "\"" : "";

        for (T element : array) {
            str += ( quote + element + quote + " ;");
        }

        //Удалим " ;" на конце и вернем
        return str.substring(0,str.length() - 3);
    }

}

class WrongInitialStringSymbolMessage extends Message {
    WrongInitialStringSymbolMessage(int errorSymbolPosition, char foundedSymbol, String initialString){
        String fpMessage = new ErrorInPassedStringMessage(initialString).getMessage();
        ru = fpMessage + "";//TODO
        en = fpMessage + "";//TODO
    }
    WrongInitialStringSymbolMessage(int[] errorSymbolPositions, char[] foundedSymbols, String initialString){
        String fpMessage = new ErrorInPassedStringMessage(initialString).getMessage();
        ru = fpMessage + "";//TODO
        en = fpMessage + "";//TODO
    }

    class ErrorInPassedStringMessage extends Message{
        ErrorInPassedStringMessage(String initialString) {
            ru = "Ошибка в переданной строке (" + initialString + "). ";
            en = "Wrong input string (" + initialString + "). ";
        }
    }
}

class NullSizeArrayMessage extends Message {
    NullSizeArrayMessage(){
        ru = "Передан пустой массив";
        en = "Passed array has null size";
    }
}

class DifferentArraySizeMessage extends Message {
    DifferentArraySizeMessage() {
        ru = "Не совпадают размеры массивов errorSymbolPositions и foundedSymbols";
        en = "Not the same size arrays: errorSymbolPositions и foundedSymbols";
    }
}