package ru.pavelpopovjava.sudoku;

class SudokuFieldConverter {
    public static String toString(SudokuField field){
        return field.toString();
    }

    /**
     * Если в качестве индексов используются переменные i,j - то их нумерация начинается с 0. Если x,y - с одного
     *
     * @param arr
     * @return
     */
    public static String toString(byte[][] arr){
        byte i = 0; //Номер колонки
        byte j = 0; //Номер ряда (ячейки в колонке)

        String s = "";

        for (j = 0; j < 9; j++){
            for (i = 0; i < 9; i++){
                s += arr[i][j];
            }
        }

        return s;
    }

    /**
     * к моменту вызова этого метода, строка уже должна быть валидирована на соответствие формату входного параметра.
     * Повторой валидации в этом методе не будет, т.к. класс закрытый, и используется только в пределах этого пакета.
     * @param str
     * @return
     */
    public static byte[][] toArray(String str){

    }

    public static byte[][] toArray(SudokuField field){
        return field.getField();
    }
}