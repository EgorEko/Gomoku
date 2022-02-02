package academy.devonline.tictactoe.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static academy.devonline.tictactoe.model.Sign.X;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
class GameTableTest {

    private static final Cell CELL_1_1 = new Cell(1, 1);

    private final GameTable gameTable = new GameTable();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0, 1",
            "0, 2",
            "1, 0",
            "1, 1",
            "1, 2",
            "2, 0",
            "2, 1",
            "2, 2"
    })
    void isEmpty_should_return_true_for_the_provided_cell(final int row,
                                                          final int col) {
        assertTrue(gameTable.isEmpty(new Cell(row, col)));
    }

    @Test
    void getSign_should_return_x_for_cell_with_row_1_and_col_1() {
        gameTable.setSign(CELL_1_1, X);
        assertEquals(X, gameTable.getSign(CELL_1_1));
    }

    @Test
    void setSign_should_set_x_for_cell_with_row_1_and_col_1() {
        assertTrue(gameTable.isEmpty(CELL_1_1));

        gameTable.setSign(CELL_1_1, X);

        assertEquals(X, gameTable.getSign(CELL_1_1));
    }
}