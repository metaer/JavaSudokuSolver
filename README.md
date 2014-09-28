JavaSudokuSolver
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