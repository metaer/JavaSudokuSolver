package ru.pavelpopovjava.sudoku;

class SudokuFieldConverter {

    /**
     * Если в качестве индексов используются переменные i,j - то их нумерация начинается с 0. Если x,y - с одного
     *
     * @param arr
     * @return
     */
    public static String toString(int[][] arr){
        int i = 0; //Номер колонки
        int j = 0; //Номер ряда (ячейки в колонке)

        String s = "";

        for (j = 0; j < 9; j++){
            for (i = 0; i < 9; i++){
                s += arr[i][j];
            }
        }

        return s;
    }

    /**
     * К к моменту вызова этого метода, строка уже должна быть валидирована на соответствие формату входного параметра.
     * Повторой валидации в этом методе не будет.
     * @param str
     * @return
     */
    public static int[][] toArray(String str){

        str = str.replace(".","0");

        assert (str.length() == 81);

        int[][] arr = new int[9][9];

        for (int j = 0; j < 9; j++){
            for (int i = 0; i < 9; i++){
                arr[i][j] = Integer.valueOf(String.valueOf(str.charAt(9 * j + i)));
            }
        }

        return arr;
    }

/*    public static int[][] toArray(SudokuField field){
        return field.getField();
    }*/
}