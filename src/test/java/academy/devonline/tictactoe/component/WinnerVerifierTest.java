package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
class WinnerVerifierTest {

    private final WinnerVerifier winnerVerifier = new WinnerVerifier();

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2"
    })
    void isUserWin_should_return_true_for_the_provided_row(int row) {
        GameTable gameTable = new GameTable();
        for (int i = 0; i < 3; i++) {
            gameTable.setSign(new Cell(row, i), X);
        }

        assertTrue(winnerVerifier.isUserWin(gameTable));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void isUserWin_should_return_true_for_the_provided_col(int col) {
        GameTable gameTable = new GameTable();
        for (int i = 0; i < 3; i++) {
            gameTable.setSign(new Cell(i, col), X);
        }

        assertTrue(winnerVerifier.isUserWin(gameTable));
    }

    @Test
    void isUserWin_should_return_user_win_for_dig_1() {
        GameTable gameTable = new GameTable();
        gameTable.setSign(new Cell(0, 0), X);
        gameTable.setSign(new Cell(1, 1), X);
        gameTable.setSign(new Cell(2, 2), X);

        assertTrue(winnerVerifier.isUserWin(gameTable));
    }

    @Test
    void isUserWin_should_return_user_win_for_dig_2() {
        GameTable gameTable = new GameTable();
        gameTable.setSign(new Cell(0, 2), X);
        gameTable.setSign(new Cell(1, 1), X);
        gameTable.setSign(new Cell(2, 0), X);

        assertTrue(winnerVerifier.isUserWin(gameTable));
    }


    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2"
    })
    void isComputerWin_should_return_true_for_the_provided_row(int row) {
        GameTable gameTable = new GameTable();
        for (int i = 0; i < 3; i++) {
            gameTable.setSign(new Cell(row, i), O);
        }

        assertTrue(winnerVerifier.isComputerWin(gameTable));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void isComputerWin_should_return_true_for_the_provided_col(int col) {
        GameTable gameTable = new GameTable();
        for (int i = 0; i < 3; i++) {
            gameTable.setSign(new Cell(i, col), O);
        }

        assertTrue(winnerVerifier.isComputerWin(gameTable));
    }

    @Test
    void isComputerWin_should_return_user_win_for_dig_1() {
        GameTable gameTable = new GameTable();
        gameTable.setSign(new Cell(0, 0), O);
        gameTable.setSign(new Cell(1, 1), O);
        gameTable.setSign(new Cell(2, 2), O);

        assertTrue(winnerVerifier.isComputerWin(gameTable));
    }

    @Test
    void isComputerWin_should_return_user_win_for_dig_2() {
        GameTable gameTable = new GameTable();
        gameTable.setSign(new Cell(0, 2), O);
        gameTable.setSign(new Cell(1, 1), O);
        gameTable.setSign(new Cell(2, 0), O);

        assertTrue(winnerVerifier.isComputerWin(gameTable));
    }
}