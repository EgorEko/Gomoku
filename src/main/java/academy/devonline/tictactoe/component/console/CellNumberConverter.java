package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.model.game.Cell;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface CellNumberConverter {

    Cell toCell(char number);

    char toNumber(Cell cell);
}
