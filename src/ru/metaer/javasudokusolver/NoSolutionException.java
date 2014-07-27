package ru.metaer.javasudokusolver;

public final class NoSolutionException extends SudokuSolverLibException {
    public String getMessage() {
        return new NoSolutionMessage().getMessage();
    }

    private class NoSolutionMessage extends Message{
        private NoSolutionMessage() {
            ru = "Задача не имеет решения";
            en = "There is no solution";
        }
    }
}
