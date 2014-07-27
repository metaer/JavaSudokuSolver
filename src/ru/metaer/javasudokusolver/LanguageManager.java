package ru.metaer.javasudokusolver;

import java.util.Arrays;

public class LanguageManager implements LanguageManagerInterface, UserHelpInterface {
    private static LanguageManager ourInstance = new LanguageManager();

    public static LanguageManager getInstance() {
        return ourInstance;
    }

    private final static String DEFAULT_LOCALE = "en";

    private final static String[] AVAILABLE_LOCALES = {
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

    public String help() {
        String availableLocalesString = "";
        for (String locale : AVAILABLE_LOCALES) {
           availableLocalesString += locale + ", ";
        }
        StringHelper.removeLastChars(availableLocalesString, 2);
        return availableLocalesString;

    }

    private LanguageManager() {
    }
}
