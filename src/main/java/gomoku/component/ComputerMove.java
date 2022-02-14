package gomoku.component;

import gomoku.model.game.GameTable;
import gomoku.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class ComputerMove implements Move {

    private final ComputerMoveStrategy[] strategies;

    public ComputerMove(final ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }

    @Override
    public void make(final GameTable gameTable, final Sign sign) {
        for (final ComputerMoveStrategy strategy : strategies) {
            if (strategy.tryToMakeMove(gameTable, sign)) {
                return;
            }
        }

        throw new IllegalArgumentException(
                "Game table does not contain empty cells or invalid configuration for the computer move strategies!"
        );
    }
}
