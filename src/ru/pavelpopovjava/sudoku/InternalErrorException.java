package ru.pavelpopovjava.sudoku;


public final class InternalErrorException extends SudokuSolverException {

    private String initialString = SudokuSolver.getInstance().getInitialString();
    private String message;

    InternalErrorException(){
        this.message = getFirstPartMessage();
    }

    InternalErrorException(String inputMessage){
        this.message = getFirstPartMessage() + inputMessage + ". " + new BugReportMessage(initialString).getMessage();
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
        ru = "Внутренняя ошибка библиотеки ru.pavelpopovjava.sudoku: ";
        en = "Internal ru.pavelpopovjava.sudoku library error: ";
    }
}

class BugReportMessage extends Message {
    BugReportMessage(String initialString) {
        ru = "Сообщите, пожалуйста, на " + Constants.BUG_REPORT_ADDRESS + " , скопируя данное сообщение. Входная строка: \"" + initialString + "\"";
        en = "Send bug report via " + Constants.BUG_REPORT_ADDRESS + " with copy of this message, please. InitialString: \"" + initialString + "\"";
    }
}