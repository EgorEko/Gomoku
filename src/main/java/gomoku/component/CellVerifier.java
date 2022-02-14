package gomoku.component;

import gomoku.model.game.Cell;
import gomoku.model.game.GameTable;

import static gomoku.Constants.GAME_TABLE_SIZE;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class CellVerifier {

    public boolean allCellsFilled(final GameTable gameTable) {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            for (int j = 0; j < GAME_TABLE_SIZE; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
