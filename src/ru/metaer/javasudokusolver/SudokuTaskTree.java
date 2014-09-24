package ru.metaer.javasudokusolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SudokuTaskTree {
    private Map<String,SudokuField> sudokuFieldsHashMap = new HashMap<String, SudokuField>();
    private HashMap<String, ArrayList<Integer>> candidatesHashMap = new HashMap<String, ArrayList<Integer>>();
    private Map<String, Integer> colMap = new HashMap<String, Integer>();
    private Map<String, Integer> rowMap = new HashMap<String, Integer>();
    private Map<String, Integer> numberOfConsideredCandidatesMap = new HashMap<String, Integer>();


    SudokuTaskTree(String id, SudokuField initialField) {
        sudokuFieldsHashMap.put(id, initialField);
    }

    public void setCandidates(String id, ArrayList<Integer> candidates) {
        candidatesHashMap.put(id, candidates);
    }

    public void setSudokuField(String id, SudokuField val) {
        sudokuFieldsHashMap.put(id, val);
    }

    public int getCandidate(String id, int n) {
        return candidatesHashMap.get(id).get(n);
    }

    public int getCol(String id) {
        return colMap.get(id);
    }

    public int getRow(String id) {
        return rowMap.get(id);
    }

    public void setCol(String id, int val) {
        colMap.put(id, val);
    }

    public void setRow(String id, int val) {
        rowMap.put(id, val);
    }

    /**
     * Возвращает элемент дерева по id элемента
     * @param id
     * @return
     */

    public SudokuField getSudokuFieldById(String id) {
        return sudokuFieldsHashMap.get(id);
    }

    public ArrayList<Integer> getCandidatesById(String id) {
        return candidatesHashMap.get(id);
    }

    public void putCandidates(String id, ArrayList<Integer> candidates) {
        candidatesHashMap.put(id, candidates);
    }

    /**
     * Уровень, на котором находится элемент в дереве по id элемента
     * @param id
     * @return
     */
    public int getLevelById(String id) {
        return id.length();
    }

    /**
     * Возвращает true, если все кандидаты на текущем уровне уже рассматривались. Иначе false
     * @param id
     * @return
     */
    public boolean allCandidateWereConsidered(String id) {
        return getNumberOfConsideredCandidates(id) == numberOfAllCandidates(id);
    }

    public boolean noOneCandidateWasConsidered(String id) {
        return getNumberOfConsideredCandidates(id) == 0;
    }

    public void incrementNumberOfConsideredCandidates(String id) {
        Integer number = numberOfConsideredCandidatesMap.get(id);
        if (number == null) {
            numberOfConsideredCandidatesMap.put(id, 1);
        } else {
            number++;
        }
    }

    public int getNumberOfConsideredCandidates(String id) {
        Integer number = numberOfConsideredCandidatesMap.get(id);
        if (number == null) {
            return 0;
        }
        return number;
    }

    private int numberOfAllCandidates(String id) {
        return candidatesHashMap.get(id).size();
    }
}