package ru.metaer.javasudokusolver;

class SudokuFieldConverter {

    /**
     * Если в качестве индексов используются переменные i,j - то их нумерация начинается с 0. Если x,y - с одного
     *
     * @param arr
     * @return
     */
    static String toString(int[][] arr){
        int i = 0; //Номер колонки
        int j = 0; //Номер ряда (ячейки в колонке)

        String s = "";

        for (j = 0; j < Constants.FIELD_SIZE; j++){
            for (i = 0; i < Constants.FIELD_SIZE; i++){
                s += arr[i][j];
            }
        }

        return s;
    }

    /**
     * К к моменту вызова этого метода, строка уже должна быть валидирована на соответствие формату входного параметра.
     * И также точки должны быть переведены в нули
     * Повторой валидации в этом методе не будет.
     * @param str
     * @return
     */
    static int[][] toArray(String str){

        assert (str.length() == 81);

        int[][] arr = new int[9][9];

        for (int j = 0; j < Constants.FIELD_SIZE; j++){
            for (int i = 0; i < Constants.FIELD_SIZE; i++){
                arr[i][j] = Integer.valueOf(String.valueOf(str.charAt(9 * j + i)));
            }
        }

        return arr;
    }

}