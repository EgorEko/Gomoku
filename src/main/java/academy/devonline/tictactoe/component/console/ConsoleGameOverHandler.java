package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.GameOverHandler;

import java.util.Scanner;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class ConsoleGameOverHandler implements GameOverHandler {

    private final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printIfoMessage("Game over");
        new Scanner(System.in).nextLine();
    }
}
