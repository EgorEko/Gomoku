package gomoku.component;

import gomoku.model.game.GameTable;
import gomoku.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface ComputerMoveStrategy {

    boolean tryToMakeMove(GameTable gameTable, Sign sign);
}
