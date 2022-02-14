package gomoku.component;

import gomoku.model.game.GameTable;
import gomoku.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface Move {

    void make(final GameTable gameTable, Sign sign);
}
