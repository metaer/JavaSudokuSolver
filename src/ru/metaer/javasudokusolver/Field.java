package ru.metaer.javasudokusolver;

import java.util.ArrayList;
import java.util.List;

abstract class Field<T> implements RenderableField {
    abstract T getCellContents(int col, int row);

    public abstract String getCellValueInStringPerformance(int col, int row);

    public abstract String getAdditionalSymbolsForRendering();

    protected List<T> getCellsList() {
        List list = new ArrayList<T>();
        for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
            for (int row = 1; row <= Constants.FIELD_SIZE; row++) {
                list.add(getCellContents(col, row));
            }
        }
        return list;
    }

    void renderField() {

        System.out.println("   ");

        for (int row = 0; row <= Constants.FIELD_SIZE; row++) {
            if (row != 0) {
                System.out.print(row + ". ");
            }
            for (int col = 1; col <= Constants.FIELD_SIZE; col++) {
                if (row == 0) {
                    System.out.print(((col == 1) ? "    " : "") + col + getAdditionalSymbolsForRendering() + " " + ( (col < Constants.FIELD_SIZE) ? "" : "\n" ));
                    continue;
                }
                System.out.print("|" + getCellValueInStringPerformance(col, row));
                if (col == Constants.FIELD_SIZE) {
                    System.out.println("|");
                }
            }
        }
        System.out.println("");
    }

}
