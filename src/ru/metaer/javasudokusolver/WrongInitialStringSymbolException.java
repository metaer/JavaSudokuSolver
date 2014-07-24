package ru.metaer.javasudokusolver;

import java.util.ArrayList;
import java.util.List;

public final class WrongInitialStringSymbolException extends WrongInitialStringException {

    private String foundedSymbols;

    //Позиции ошибочных символов (начиная осчет от 1)
    private ArrayList<Integer> errorSymbolPositions;

    /**
     * Переданная строка
     */
    private String initialString;



    public String getFoundedSymbols() {
        return foundedSymbols;
    }

    public ArrayList<Integer> getErrorSymbolPositions() {

        return errorSymbolPositions;
    }

    public String getInitialString() {

        return initialString;
    }

    public WrongInitialStringSymbolException(String initialString, ArrayList<Integer> errorSymbolPositions, String foundedSymbols) {
        this.initialString = initialString;
        this.errorSymbolPositions = errorSymbolPositions;
        this.foundedSymbols = foundedSymbols;

    }

    @Override
    public String getMessage() {

        if (errorSymbolPositions.size() == 0) {
            new InternalErrorException(new NullSizeArrayMessage().getMessage());
        }

        if (errorSymbolPositions.size() != foundedSymbols.length()){
            new InternalErrorException(new DifferentArraySizeMessage().getMessage());
        }

        if (errorSymbolPositions.size() == 1){
            int pos = (int)errorSymbolPositions.get(0);
            return new WrongInitialStringSymbolMessage(pos, foundedSymbols.charAt(0), initialString).getMessage();
        } else {
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
    WrongInitialStringSymbolMessage(Integer errorSymbolPosition, char foundedSymbol, String initialString){
        String allowedSymbolMessageString = new AllowedSymbolsMessage().getMessage();
        String fpMessage = new ErrorInPassedStringMessage(initialString).getMessage();

        ru = fpMessage
                + "В позиции "
                + errorSymbolPosition
                + " найден символ \""
                + foundedSymbol
                + "\". "
                + allowedSymbolMessageString;

        en = fpMessage
                + "\""
                + foundedSymbol
                + "\""
                + "was founded in position "
                + "\""
                + errorSymbolPosition
                + "\""
                + ". "
                + allowedSymbolMessageString;
    }

    WrongInitialStringSymbolMessage(ArrayList<Integer> errorSymbolPositions, String foundedSymbols, String initialString){
        String fpMessage = new ErrorInPassedStringMessage(initialString).getMessage();

        String allowedSymbolMessageString = new AllowedSymbolsMessage().getMessage();

        ru = fpMessage
                + "В позициях "
                + WISSEEConverter.converToStringWithDevider(errorSymbolPositions)
                + " найдены символы "
                + WISSEEConverter.convertToStringWithDevider(foundedSymbols)
                + ". "
                +  allowedSymbolMessageString;
            ;

        en = fpMessage
                + "\""
                + WISSEEConverter.convertToStringWithDevider(foundedSymbols)
                + "\""
                + "were founded in positions "
                + "\""
                + WISSEEConverter.converToStringWithDevider(errorSymbolPositions)
                + "\". "
                + allowedSymbolMessageString;
    }

    class ErrorInPassedStringMessage extends Message{
        ErrorInPassedStringMessage(String initialString) {
            ru = "Ошибка в переданной строке \"" + initialString + "\": ";
            en = "Wrong input string \"" + initialString + "\": ";
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
        en = "Not the same size arrays: errorSymbolPositions and foundedSymbols";
    }
}

class AllowedSymbolsMessage extends Message {
    AllowedSymbolsMessage() {
        ru = "Допустимые символы: " + Constants.ALLOWED_CHARS_IN_QUOTES;
        en = "One of " + Constants.ALLOWED_CHARS_IN_QUOTES +" expected";
    }
}

class WISSEEConverter {
    static String convertToStringWithDevider(String str) {
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            output += "\"" + str.charAt(i) + "\";";
        }

        output = StringHelper.removeLastChar(output);
        return output;
    }

    static String converToStringWithDevider(ArrayList<Integer> list) {
        String output = "";

        for (Integer val : list) {
            output += "\"" + val + "\";";
        }

        output = StringHelper.removeLastChar(output);
        return output;
    }
}