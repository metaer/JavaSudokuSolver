package ru.metaer.javasudokusolver;

interface RenderableField extends Renderable {
    public abstract String getCellValueInStringPerformance(int col, int row);

    public abstract String getAdditionalSymbolsForRendering();

    void renderField();
}
