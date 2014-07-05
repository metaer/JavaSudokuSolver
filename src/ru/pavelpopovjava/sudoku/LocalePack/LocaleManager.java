package ru.pavelpopovjava.sudoku.LocalePack;

import java.util.Arrays;

public class LocaleManager {

    private static final String[] AVAILABLE_LOCALES = {
            "en", //English
            "ru"  //Russian
    };

    private static String currentLocale = "en";

    public static String getCurrentLocale() {
        return currentLocale;
    }

    public static void setCurrentLocale(String currentLocale) {
        if (Arrays.asList(AVAILABLE_LOCALES).contains(currentLocale)){
            LocaleManager.currentLocale = currentLocale;
        }
    }

}
