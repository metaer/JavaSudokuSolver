package ru.metaer.javasudokusolver;

class Logger {
    static void printField(SudokuField sf) {
        sf.renderField();
    }

    static void printField(CandidatesField cf) {
        cf.renderField();
    }

    static void println (String str) {
        System.out.println(str);
    }
}
