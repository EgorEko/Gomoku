package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.GameTable;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface DataPrinter {

    void printInstructions();

    void printIfoMessage(String message);

    void printErrorMessage(String message);

    void printGameTable(GameTable gameTable);
}
