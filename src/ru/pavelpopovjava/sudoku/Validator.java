package ru.pavelpopovjava.sudoku;

class Validator {
    public static boolean minmax(int min, int max, int val){
        return !(val < min || val > max);
    }

    /**
     * Проверяет, что в строке только цифры от 1 до 9 и точки.
     * @param str
     * @throws WrongInitialParameterException
     */
    public static void validateInputString(String str) throws WrongInitialParameterException{

    }

    /**
     * Проверяет размер массива, и то, что в массиве цифры от 0 до 9 включительно с обеих сторон
     * @param arr
     * @throws WrongInitialParameterException
     */
    public static void validateInputArrayAsInitialParameter(byte[][] arr) throws WrongInitialParameterException{

    }


}