package ru.metaer.javasudokusolver;

class SudokuTask {
    private String currentId = "1";
    private SudokuField initialField;
    private SudokuField outputField;
    private SudokuTaskTree tree;

    SudokuTask(SudokuField initialField) {
        this.initialField = initialField;
        tree = new SudokuTaskTree(currentId, initialField);
    }

    public SudokuField getSolution() throws NoSolutionException{
        solveSudoku();
        return outputField;
    }

    /**
     * Может устанавливать переменную outputField
     * @throws NoSolutionException
     */
    private void solveSudoku() throws NoSolutionException{

        //Пробуем сначала решить простым методом
        boolean result = simpleMethod();

        if (!result) {
            heavyMetalMethod();
            return;
        }

        return;
    }

    /**
     * Тяжелая артиллерия. Этот метод применяется, если не получилось решить простым методом.
     * Метод может устанавливать переменную outputField
     * Данный метод гарантированно находит решение, если оно существует
     * Важно! Этот метод может ходить туда-сюда по дереву (изменять currentId, добавлять элементы в дерево))
     * Использует алгоритм поиск в глубину
     * Может рекурсивно вызывать solveSudoku
     * @return
     */
    private void heavyMetalMethod() throws NoSolutionException {

    }


    /**
     * Метод возвращает true - если решение получено, false - если нет.
     * Также устанавливает переменную класса outputField в случае, если решение получено.
     * Важно! Этот метод не ходит туда-сюда по дереву (т.е. не изменяет currentId, работает в пределах одного элемента дерева)
     * @return
     */
    private boolean simpleMethod() {
        SudokuField currentField = getCurrentField();
        return true;
    }

    private SudokuField copyField(SudokuField field) {
        return new SudokuField(field.toArray());
    }

    private SudokuField getCurrentField() {
        return tree.getFieldById(currentId);
    }
}
