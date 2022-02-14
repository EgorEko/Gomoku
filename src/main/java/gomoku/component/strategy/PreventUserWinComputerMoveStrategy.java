package gomoku.component.strategy;

import gomoku.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class PreventUserWinComputerMoveStrategy extends AbstractComputerMoveStrategy {

    public PreventUserWinComputerMoveStrategy() {
        super(1);
    }

    @Override
    protected Sign getFindSign(Sign moveSign) {
        return moveSign.oppositeSign();
    }
}
