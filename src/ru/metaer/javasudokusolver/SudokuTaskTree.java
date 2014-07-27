package ru.metaer.javasudokusolver;

import java.util.HashMap;

class SudokuTaskTree {
    private HashMap<String,SudokuField> sudokuFieldsHashMap = new HashMap<String, SudokuField>();
    private HashMap<String,CandidatesForElementInTree> candidatesHashMap;

    SudokuTaskTree(String id, SudokuField initialField) {
        sudokuFieldsHashMap.put(id, initialField);
    }

    /**
     * Возвращает элемент дерева по id элемента
     * @param id
     * @return
     */
    public SudokuField getSudokuFieldById(String id) {
        return sudokuFieldsHashMap.get(id);
    }

    public CandidatesForElementInTree getCandidateFieldById(String id) {
        return candidatesHashMap.get(id);
    }

    public void putCandidates(String id, CandidatesForElementInTree candidates) {
        candidatesHashMap.put(id, candidates);
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