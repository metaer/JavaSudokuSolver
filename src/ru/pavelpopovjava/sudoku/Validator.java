package ru.pavelpopovjava.sudoku;

class Validator {
    public static boolean minmax(int min, int max, int val){
        return !(val < min || val > max);
    }

    /**
     * Проверяет, что в строке только цифры от 1 до 9 и точки, а также длину строки
     * @param str
     * @throws WrongInitialStringException
     */
    public static void validateInputString(String str) throws WrongInitialStringException{


    }

    /**
     * Проверяет размер массива, и то, что в массиве цифры от 0 до 9 включительно с обеих сторон
     * @param arr
     * @throws WrongInitialArrayException
     */
    public static void validateInputArrayAsInitialParameter(int[][] arr) throws WrongInitialArrayException{

    }


}