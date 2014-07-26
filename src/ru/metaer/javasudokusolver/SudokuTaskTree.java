package ru.metaer.javasudokusolver;

import java.util.HashMap;

class SudokuTaskTree {
    private HashMap<String,SudokuField> data;

    SudokuTaskTree(String id, SudokuField initialField) {
        data.put(id, initialField);
    }

    /**
     * Возвращает элемент дерева по id элемента
     * @param id
     * @return
     */
    public SudokuField getFieldById(String id) {
        return data.get(id);
    }

    /**
     * Уровень, на котором находится элемент в дереве по id элемента
     * @param id
     * @return
     */
    public static int getLevelById(String id) {
        return id.length();
    }
}
