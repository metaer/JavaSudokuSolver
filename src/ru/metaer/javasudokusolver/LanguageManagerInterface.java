package ru.metaer.javasudokusolver;

interface LanguageManagerInterface extends SudokuLibraryInterface {
    public void setCurrentLocale(String currentLocale);
    public String getCurrentLocale();
}