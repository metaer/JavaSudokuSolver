package ru.metaer.javasudokusolver;

class StringHelper {
    public static String removeLastChar(String str) {
        return removeLastChars(str, 1);
    }

    public static String removeLastChars(String str, int count) {
        if (str.length() > count) {
            return str.substring(0, str.length() - count);
        } else {
            return "";
        }
    }

    /**
     * Дополняет строку пробелами до n символов
     * @param n
     * @return
     */
    public static String fillWithSpaces(String s, int n) {
        int len = s.length();
        if (len >= n) {
            return s;
        }
        for (int i = 0; i < n - len; i++) {
            s += " ";
        }
        return s;
    }
}
