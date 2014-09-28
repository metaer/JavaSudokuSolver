package ru.metaer.javasudokusolver;

public class Logger {

    private static boolean showSolutionLogToConsole = false;

    public static void setShowSolutionLogToConsole(boolean showSolutionLogToConsole) {
        Logger.showSolutionLogToConsole = showSolutionLogToConsole;
    }

    public static void setShowSolutionLogToConsole() {
        Logger.showSolutionLogToConsole = true;
    }

    public static boolean isShowSolutionLogToConsole() {
        return showSolutionLogToConsole;
    }

    static void printField(RenderableField f) {
        if (showSolutionLogToConsole) {
            f.renderField();
        }
    }

    static void println (String str) {
        if (showSolutionLogToConsole) {
            System.out.println(str);
        }
    }
}
