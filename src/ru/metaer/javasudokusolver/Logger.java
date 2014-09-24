package ru.metaer.javasudokusolver;

class Logger {
    static void printField(RenderableField f) {
        f.renderField();
    }

    static void println (String str) {
        System.out.println(str);
    }
}
