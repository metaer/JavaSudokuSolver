package ru.metaer.javasudokusolver;

import java.util.ArrayList;

public class CandidatesForElementInTree {
    private ArrayList<Integer> candidates = new ArrayList();
    private int col;
    private int row;

    public ArrayList<Integer> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Integer> candidates) {
        this.candidates = candidates;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
