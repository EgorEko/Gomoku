package academy.devonline.tictactoe.model;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class GameTable {

    private final char[][] table = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public boolean isEmpty(final Cell cell) {
        return table[cell.getCol()][cell.getRow()] == ' ';
    }

    public char getSign(final Cell cell) {
        return table[cell.getCol()][cell.getRow()];
    }

    public void setSign(final Cell cell, final char sign) {
        table[cell.getCol()][cell.getRow()] = sign;
    }
}
