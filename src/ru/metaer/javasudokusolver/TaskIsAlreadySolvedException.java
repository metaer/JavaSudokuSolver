package ru.metaer.javasudokusolver;

public class TaskIsAlreadySolvedException extends UserErrorException{
    @Override
    public String getMessage() {
        return new TaskIsAlreadySolvedMessage().getMessage();
    }

    private class TaskIsAlreadySolvedMessage extends Message {
        private TaskIsAlreadySolvedMessage() {
            ru = "Ошибка. На вход подали уже решенную задачу! Так неинтересно, подайте нормальную задачу...";
            en = "Error. There is already solved task on library input! It is not interesting, give normal task...";
        }
    }
}
