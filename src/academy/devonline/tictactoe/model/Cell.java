package academy.devonline.tictactoe.model;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class Cell {

    private final int row;

    private final int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
