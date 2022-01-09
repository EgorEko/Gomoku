package academy.devonline.tictactoe.component.keypad;

import academy.devonline.tictactoe.component.CellNumberConverter;
import academy.devonline.tictactoe.model.Cell;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    private final char[][] mapping = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    @Override
    public Cell toCell(final char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapping[i][j] == number) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    @Override
    public char toNumber(final Cell cell) {
        return mapping[cell.getRow()][cell.getCol()];
    }
}
