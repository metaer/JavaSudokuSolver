package ru.pavelpopovjava.sudoku;

import java.util.Arrays;

public class LocalManager implements LocalManagerInterface {
    private static LocalManager ourInstance = new LocalManager();

    public static LocalManager getInstance() {
        return ourInstance;
    }

    private final String DEFAULT_LOCALE = "en";

    private final String[] AVAILABLE_LOCALES = {
            "en", //English
            "ru"  //Russian
    };

    private String currentLocale = DEFAULT_LOCALE;

    public String getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(String currentLocale) {
        if (Arrays.asList(AVAILABLE_LOCALES).contains(currentLocale)){
            this.currentLocale = currentLocale;
        } else {
            this.currentLocale = DEFAULT_LOCALE;
        }
    }


    private LocalManager() {
    }
}
