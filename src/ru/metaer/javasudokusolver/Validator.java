package ru.metaer.javasudokusolver;

import java.util.ArrayList;

class Validator {
    public static boolean minmax(int min, int max, int val){
        return !(val < min || val > max);
    }

    /**
     * Проверяет, что в строке только цифры от 1 до 9 и точки, а также длину строки
     * @param str
     * @throws WrongInitialStringException
     */
    public static void validateInputString(String str) throws WrongInitialStringException{
        validateInputStringForLength(str);
        validateInputStringForSymbols(str);
    }

    private static void validateInputStringForSymbols(String str) throws WrongInitialStringSymbolException {

        //Сначала валидируем по регулярке, а потом, если не совпадает - выявляем в каких позициях.

        if (validateInputStringByRegExp(str)) {
            return;
        }

        ArrayList<Integer> positions = new ArrayList<Integer>();

        String errorSymbols = "";

        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (!validateSymbolByRegExp(String.valueOf(symbol))) {
                positions.add(i+1);
                errorSymbols += symbol;
            }
        }

        throw new WrongInitialStringSymbolException(str, positions, errorSymbols);
    }

    private static boolean validateSymbolByRegExp(String symbol) {
        return Constants.ALLOWED_CHARS.contains(symbol);
    }

    private static boolean validateInputStringByRegExp(String str) {
        return str.matches("[1-9.]+");
    }

    private static void validateInputStringForLength(String str) throws WrongInitialStringLengthException{
        int length = str.length();

        if (length == 81){
            return;
        }
        else {
            throw new WrongInitialStringLengthException(length);
        }
    }

}