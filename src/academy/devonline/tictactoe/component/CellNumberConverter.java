package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface CellNumberConverter {

    Cell toCell(char number);

    char toNumber(Cell cell);
}
