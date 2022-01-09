package academy.devonline.tictactoe;

import academy.devonline.tictactoe.component.*;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public final class Launcher {

    public static void main(final String[] args) {
        CellNumberConverter cellNumberConverter = new CellNumberConverter();
        final Game game = new Game(
                new DataPrinter(cellNumberConverter),
                new ComputerMove(),
                new UserMove(cellNumberConverter),
                new WinnerVerifier(),
                new CellVerifier()
        );
        game.play();
    }
}
