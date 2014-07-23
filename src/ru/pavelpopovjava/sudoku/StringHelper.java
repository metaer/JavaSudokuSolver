package ru.pavelpopovjava.sudoku;

class StringHelper {
    public static String removeLastChar(String str) {
        if (str.length() > 0) {
            return str.substring(0, str.length()-1);
        } else {
            return "";
        }
    }
}
