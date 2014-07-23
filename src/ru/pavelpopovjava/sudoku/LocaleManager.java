package ru.pavelpopovjava.sudoku;

import java.util.Arrays;

public final class LocaleManager {

    private static final String DEFAULT_LOCALE = "en";

    private static final String[] AVAILABLE_LOCALES = {
            "en", //English
            "ru"  //Russian
    };

    private static String currentLocale = DEFAULT_LOCALE;

    public static String getCurrentLocale() {
        return currentLocale;
    }

    public static void setCurrentLocale(String currentLocale) {
        if (Arrays.asList(AVAILABLE_LOCALES).contains(currentLocale)){
            LocaleManager.currentLocale = currentLocale;
        } else {
            LocaleManager.currentLocale = DEFAULT_LOCALE;
        }
    }

}
