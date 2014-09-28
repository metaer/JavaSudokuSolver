Библиотека JavaSudokuSolver
================

Базовое использование:


``` java
import ru.metaer.javasudokusolver.SudokuSolver;
import ru.metaer.javasudokusolver.SudokuSolverLibException;

public class BasicUsage {
    public static void main(String[] args) {
        String inputString = "9....24...5...1.8......3.16..2......1.7.6........17.63..5.78.......24..17.......9";
        try{
            String result = SudokuSolver.getInstance().getSolutionString(inputString);
            System.out.println(result);
        }
        catch (SudokuSolverLibException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

В приведенном выше примере параметр inputString содержит следующее поле в строковом представлении: 
  
```
|9|_|_|_|_|2|4|_|_|  
|_|5|_|_|_|1|_|8|_|  
|_|_|_|_|_|3|_|1|6|  
|_|_|2|_|_|_|_|_|_|  
|1|_|7|_|6|_|_|_|_|  
|_|_|_|_|1|7|_|6|3|  
|_|_|5|_|7|8|_|_|_|  
|_|_|_|_|2|4|_|_|1|  
|7|_|_|_|_|_|_|_|9|  
```
  
Перевести поле в строку очень просто: пустые ячейки заменяются на точки и последовательно записываются в общую строку ряды поля сверху вниз:  
сначала первый (самый верхний ряд), затем второй и т.д.