package gomoku.model.game;



import java.util.Arrays;

import static gomoku.Constants.GAME_TABLE_SIZE;
import static gomoku.model.game.Sign.EMPTY;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class GameTable {

    private final Sign[][] table;

    public GameTable(){
        table = new Sign[GAME_TABLE_SIZE][GAME_TABLE_SIZE];
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            for (int j = 0; j < GAME_TABLE_SIZE; j++) {
                table[i][j] = EMPTY;
            }
        }
    }

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
