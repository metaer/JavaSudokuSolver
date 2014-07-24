package ru.metaer.javasudokusolver;

/**
 * Это исключение выкидывается при неверном формате строки, например длина не равна 81 символу, либо неверный формат. (символы кроме цифр и точки)
 * а также при неверном формате входного массива (числа меньше 0, либо больше 9)
 */
public class WrongInitialParameterException extends UserErrorException {
}