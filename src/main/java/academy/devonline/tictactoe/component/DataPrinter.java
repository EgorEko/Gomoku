package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface DataPrinter {

    void printIfoMessage(String message);

    void printErrorMessage(String message);

    void printMappingTable();

    void printGameTable(GameTable gameTable);
}
