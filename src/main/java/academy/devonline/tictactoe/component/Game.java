package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class Game {

    private final DataPrinter dataPrinter;

    private final ComputerMove computerMove;

    private final UserMove userMove;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    public Game(final DataPrinter dataPrinter,
                final ComputerMove computerMove,
                final UserMove userMove,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }


    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();
        final GameTable gameTable = new GameTable();
        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }
        final Move[] moves = {userMove, computerMove};
        while (true) {
            boolean gameOver = false;
            for (final Move move : moves) {
                move.make(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (move instanceof UserMove) {
                    if (winnerVerifier.isUserWin(gameTable)) {
                        System.out.println("YOU WIN!");
                        printGameOver();
                        return;
                    }
                } else {
                    if (winnerVerifier.isComputerWin(gameTable)) {
                        System.out.println("COMPUTER WIN!");
                        printGameOver();
                        return;
                    }
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    System.out.println("Sorry, DRAW!");
                    printGameOver();
                    return;
                }
            }
        }
    }

    private void printGameOver() {
        System.out.println("GAME OVER!");
    }
}
