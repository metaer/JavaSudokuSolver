package ru.pavelpopovjava.sudoku.exceptions.UserErrorExceptionChildren;

import ru.pavelpopovjava.sudoku.exceptions.UserErrorException;

/**
 * Выкидывается, когда начальный параметр не соответствует условиям задачи судоку (без повторений в строке, в столбце, в малом квадрате)
 */
public class WrongInitialConditionException extends UserErrorException {
}
