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

                assert Validator.minmax(0,9,val);

                arr[x-1][y-1] = val;

            }
        }
    }

    public void validateSudokuCondition() throws WrongSudokuConditionException{

    }

    public byte getCellValue(byte col, byte row){
        assert Validator.minmax(1,9,col);
        assert Validator.minmax(1,9,row);
    }

    public byte setCellValue(byte col, byte row, byte val){
        assert Validator.minmax(1,9,col);
        assert Validator.minmax(1,9,row);
        assert Validator.minmax(0,9,val);
    }

    public boolean completelyFilled(){

    }

    public String toString(){

    }
}