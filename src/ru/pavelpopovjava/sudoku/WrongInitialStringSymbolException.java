package ru.pavelpopovjava.sudoku;

import java.util.Arrays;
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
            new InternalErrorException("Переданный массив имеет нулевой размер");
        }

        if (errorSymbolPositions.length != foundedSymbols.length){
            new InternalErrorException("Не совпадают размеры массивов errorSymbolPositions и foundedSymbols");
        }

        if (errorSymbolPositions.length == 1){
            return  getFirstPartMessage() + "В позиции "
                    + errorSymbolPositions[0] + " ожидалась цифра от 1 до 9 либо точка. Найден символ \"" +
                    foundedSymbols[0] + "\"";
        }
        else {
            return getFirstPartMessage() + "В позициях " + arrayToString(Arrays.asList(errorSymbolPositions), false) +
                    " ожидались цифры от 1 до 9 либо точки. Найдены символы " + arrayToString(Arrays.asList(errorSymbolPositions), true);
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

    private String getFirstPartMessage(){
        return "Ошибка в переданной строке (" + initialString + ")." ;
    }

}