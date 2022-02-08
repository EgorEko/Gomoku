package academy.devonline.tictactoe.component.strategy;

import academy.devonline.tictactoe.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class WinNowComputerMoveStrategy extends AbstractComputerMoveStrategy {

    public WinNowComputerMoveStrategy() {
        super(1);
    }

    @Override
    protected Sign getFindSign(Sign moveSign) {
        return moveSign.oppositeSign();
    }
}
