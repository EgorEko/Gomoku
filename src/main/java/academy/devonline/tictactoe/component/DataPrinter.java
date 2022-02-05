package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public interface DataPrinter {

    void printIfoMassage(String massage);

    void printErrorMassage(String massage);

    void printMappingTable();

    void printGameTable(GameTable gameTable);
}
