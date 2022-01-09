package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class CellNumberConverter {

    private final char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

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

    public char toNumber(final Cell cell) {
        return mapping[cell.getCol()][cell.getRow()];
    }
}
