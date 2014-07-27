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
        if (SudokuSolver.getInstance().isShowSolutionLogToConsole()) {
            Logger.println("Начанаем решать. Начальное поле:");
            Logger.printField(initialField);
        }
        solveSudoku();
        return outputField;
    }

    /**
     * Может устанавливать переменную outputField
     * @throws NoSolutionException
     */
    private void solveSudoku() throws NoSolutionException{
        Logger.println("Сначала пробуем решить простым методом...");

        //Пробуем сначала решить простым методом
        boolean result = simpleMethod();

        if (!result) {
            //fixme Заглушка пока просто выводим, что, мол, простым методом не решить
            Logger.println("Простым методом задачу не решить");
            System.exit(0);
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
     * @throws NoSolutionException
     * @return
     */
    private void heavyMetalMethod() throws NoSolutionException {

    }


    /**
     * Решение судоку простым методом. Может не дать решения.
     * Метод возвращает true - если решение получено, false - если нет.
     * Также устанавливает переменную класса outputField в случае, если решение получено.
     * Важно! Этот метод не ходит туда-сюда по дереву (т.е. не изменяет currentId, работает в пределах одного элемента дерева)
     * @throws NoSolutionException
     * @return
     */
    private boolean simpleMethod() throws NoSolutionException{
        SudokuField sudokuField = getCurrentField();
        CandidateField candidatesField = new CandidateField();
        while (true) {
            //Составляем список кандидатов
            Logger.println("Составляем список кандидатов для каждой пустой ячейки...");
            candidatesField.makeCandidatesField(sudokuField);

            Logger.println("Вот они:");

            Logger.printField(candidatesField);

            //Если хотя бы для одной незаополненной ячейки нет кандидатов, выкидываем исключение, что нет решения
            //Передаем параметр, чтоб не учитывать заполненные поля
            if (candidatesField.hasNoCandidatesForAtListOneOfFilledCells(sudokuField)) {
                throw new NoSolutionException();
            }
            //Если есть свободные ячейки, для которых имеется ровно 1 кандидат - проставляем таких кандидатов в судоку-поле, продолжаем цикл сначала
            else if (putDownCellsWithExactlyOneCandidate(sudokuField, candidatesField)) {
                //Если задача решена, возвращаем true. Если нет - продолжаем цикл.
                if (sudokuField.completelyFilled()) {
                    return true;
                }
                continue;
            } else { //В остальных случаях (т.е. для каждой свободной ячейки имеется более 1 кандидата) - возвращаем false (задача простым методом не решается)
                return false;
            }
        }
    }

    /**
     * Если есть ячейки, для которых имеется ровно один кандидат, возвращает true и проставляет кандидатов в такие ячейки
     * @param sudokuField
     * @param candidatesField
     * @return
     */
    private boolean putDownCellsWithExactlyOneCandidate(SudokuField sudokuField, CandidateField candidatesField) {
        return false;
    }

    private SudokuField copyField(SudokuField field) {
        return new SudokuField(field.toArray());
    }

    private SudokuField getCurrentField() {
        return tree.getSudokuFieldById(currentId);
    }
}
