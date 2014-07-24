package ru.metaer.javasudokusolver;

/**
 * Выкидывается, когда начальный параметр не соответствует условиям задачи судоку (без повторений в строке, в столбце, в малом квадрате)
 */
public class WrongSudokuConditionException extends UserErrorException {
}