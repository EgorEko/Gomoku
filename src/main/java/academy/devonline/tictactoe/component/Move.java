package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface Move {

    void make(final GameTable gameTable, Sign sign);
}
