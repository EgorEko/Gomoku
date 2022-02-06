package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class ConsoleDataPrinter implements DataPrinter {

    private final CellNumberConverter cellNumberConverter;

    public ConsoleDataPrinter(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void printInstructions() {
        printIfoMessage("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    @Override
    public void printIfoMessage(String massage) {
        System.out.println(massage);
    }

    @Override
    public void printErrorMessage(String massage) {
        System.err.println(massage);
    }

    @Override
    public void printGameTable(GameTable gameTable) {
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
    }

    private void print(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    @FunctionalInterface
    private interface Lambda {

        String getValue(int i, int j);
    }
}
