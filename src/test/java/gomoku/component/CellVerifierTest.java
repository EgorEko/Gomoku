package gomoku.component;

import gomoku.model.game.Sign;
import gomoku.model.game.Cell;
import gomoku.model.game.GameTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
class CellVerifierTest {

    private final CellVerifier cellVerifier = new CellVerifier();

    @Test
    void Should_return_false_if_game_table_is_blank() {
        assertFalse(cellVerifier.allCellsFilled(new GameTable()));
    }

    @Test
    void Should_return_true_if_game_table_table_does_not_contain_any_empty_cells() {
        GameTable gameTable = new GameTable();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameTable.setSign(new Cell(i, j), Sign.X);
            }
        }

        assertTrue(cellVerifier.allCellsFilled(gameTable));
    }
}