package ru.metaer.javasudokusolver;


public final class InternalErrorException extends SudokuSolverLibException {

    private String initialString = SudokuSolver.getInstance().getInitialString();
    private String message;

    InternalErrorException(){
        this.message = getFirstPartMessage();
    }

    InternalErrorException(String inputMessage){
        this.message = getFirstPartMessage() + ". " + new BugReportMessage(initialString).getMessage() + "\n " + inputMessage;
    }

    @Override
    public String getMessage(){
        return message;
    }

    private String getFirstPartMessage(){
        return new InternalErrorFirstPartMessage().getMessage();
    }

}

class InternalErrorFirstPartMessage extends Message {
    InternalErrorFirstPartMessage() {
        ru = "Внутренняя ошибка библиотеки ru.metaer.sudoku: ";
        en = "Internal ru.metaer.sudoku library error: ";
    }
}

class BugReportMessage extends Message {
    BugReportMessage(String initialString) {
        ru = "Сообщите, пожалуйста, на " + Constants.BUG_REPORT_ADDRESS + " , скопируя данное сообщение. Входная строка: \"" + initialString + "\"";
        en = "Send bug report via " + Constants.BUG_REPORT_ADDRESS + " with copy of this message, please. InitialString: \"" + initialString + "\"";
    }
}