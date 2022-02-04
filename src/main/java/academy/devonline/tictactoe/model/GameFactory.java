package academy.devonline.tictactoe.model;

import academy.devonline.tictactoe.component.*;
import academy.devonline.tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;

import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class GameFactory {

    private final PlayerType player1Type = PlayerType.USER;

    private final PlayerType player2Type = PlayerType.COMPUTER;

    public GameFactory(final String[] args) {
        //TODO

    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        return new Game(
                new DataPrinter(cellNumberConverter),
                // FIXME
                new Player(X, new UserMove(cellNumberConverter)),
                new Player(O, new UserMove(cellNumberConverter)),
                /*new Player(X, new ComputerMove()),
                new Player(O, new ComputerMove()),*/
                new WinnerVerifier(),
                new CellVerifier(),
                false
        );
    }
}
