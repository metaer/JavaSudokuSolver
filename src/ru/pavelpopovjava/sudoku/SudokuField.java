package ru.pavelpopovjava.sudoku;

class SudokuField implements SudokuFieldInterface {

    /**
     * Массив колонок (массив массивов ячеек)
     */
    private byte[][] field = new byte[9][9];

    public byte[][] getField() {
        return field;
    }

    public SudokuField(byte[][] arr){
        setField(arr);
    }

    private void setField(byte[][] arr){

        int x = 0; //Номер колонки (нумерация начинается с 1)
        int y; //Номер ряда (номер ячейки в колонке) (нумерация начинается с 1)

        for (byte[] col : arr){

            x++;
            y = 0;

            for (byte val : col){

                y++;

                if ( Validator.minmax(0,9,val)){
                    throw new RuntimeException("Ошибка библиотеки. Неверное значение ячейки внутри массива. Значения ячеек должны быть в пределах от 0 до 9");
                }

                arr[x-1][y-1] = val;

            }
        }
    }

    public void validateSudokuCondition() throws WrongSudokuConditionException{

    }

    public byte getCellValue(byte col, byte row){

        //TODO Сделать проверку на входные параметры

        return 1;
    }

    public byte setCellValue(byte col, byte row, byte val){

        //TODO Сделать проверку на входные параметры

        return 1;
    }

    public boolean completelyFilled(){

    }

    public String toString(){

    }
}