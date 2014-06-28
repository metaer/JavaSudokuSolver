package ru.pavelpopovjava.sudoku;

class SudokuField implements SudokuFieldInterface {

    /**
     * Массив колонок (массив массивов ячеек)
     */
    private int[][] field = new int[9][9];

    public SudokuField(int[][] arr){
        setField(arr);
    }

    private void setField(int[][] arr){

        int x = 0; //Номер колонки (нумерация начинается с 1)
        int y; //Номер ряда (номер ячейки в колонке) (нумерация начинается с 1)

        for (int[] col : arr){

            x++;
            y = 0;

            for (int val : col){

                y++;

                assert Validator.minmax(0,9,val);

                field[x-1][y-1] = val;

            }
        }
    }

    public void validateSudokuCondition() throws WrongSudokuConditionException{

    }

    public int getCellValue(int col, int row){
        assert Validator.minmax(1,9,col);
        assert Validator.minmax(1,9,row);

        return field[col-1][row-1];
    }

    public void setCellValue(int col, int row, int val){
        assert Validator.minmax(1,9,col);
        assert Validator.minmax(1,9,row);
        assert Validator.minmax(0,9,val);
        InternalErrorFinder.condChecker(Validator.minmax(0,9,val), "001");

        field[col-1][row-1] = val;

    }

    public boolean completelyFilled(){
        for (int[] col : field){
            for (int val : col){
                if (val == 0){
                    return false;
                }
            }
        }

        return true;
    }

/*    public String toString(){

    }*/
}