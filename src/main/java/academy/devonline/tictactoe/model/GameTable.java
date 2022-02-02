package academy.devonline.tictactoe.model;

import java.util.Arrays;

import static academy.devonline.tictactoe.model.Sign.EMPTY;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class GameTable {

    private final Sign[][] table = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    public boolean isEmpty(final Cell cell) {
        return table[cell.getCol()][cell.getRow()] == EMPTY;
    }

    public Sign getSign(final Cell cell) {
        return table[cell.getCol()][cell.getRow()];
    }

    public void setSign(final Cell cell, final Sign sign) {
        table[cell.getCol()][cell.getRow()] = sign;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameTable{");
        sb.append("table=");
        for (int i = 0; i < table.length; i++) {
            sb.append(Arrays.toString(table[i]));
            if (i < table.length - 1) {
                sb.append(";");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
