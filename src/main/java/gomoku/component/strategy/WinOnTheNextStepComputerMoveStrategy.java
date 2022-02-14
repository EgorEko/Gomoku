package gomoku.component.strategy;

import gomoku.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class WinOnTheNextStepComputerMoveStrategy extends AbstractComputerMoveStrategy {

    public WinOnTheNextStepComputerMoveStrategy() {
        super(2);
    }

    @Override
    protected Sign getFindSign(Sign moveSign) {
        return moveSign.oppositeSign();
    }
}
