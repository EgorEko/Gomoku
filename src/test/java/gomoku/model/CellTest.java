package gomoku.model;

import gomoku.model.game.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
class CellTest {

    private final Cell cell = new Cell(1, 3);

    @Test
    void getRow_Should_return_1() {
        assertEquals(1, cell.getRow());
    }

    @Test
    void getCol_Should_return_3() {
        assertEquals(3, cell.getCol());
    }

    @Test
    void toString_should_return_stting_repr_of_the_cell_obj() {
        assertEquals("Cell{row=1, col=3}", cell.toString());
    }
}