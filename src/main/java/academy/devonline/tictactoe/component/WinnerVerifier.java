package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;

import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class WinnerVerifier {

    public boolean isUserWin(final GameTable gameTable) {
        return isWinner(gameTable, X);
    }

    public boolean isComputerWin(final GameTable gameTable) {
        return isWinner(gameTable, O);
    }

    private boolean isWinner(GameTable gameTable, Sign sign) {
        return isWinnerByRows(gameTable, sign) ||
                isWinnerByCols(gameTable, sign) ||
                isWinnerByMainDiagonal(gameTable, sign) ||
                isWinnerBySecondaryDiagonal(gameTable, sign);
    }

    private boolean isWinnerByRows(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByCols(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                    gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(2, i)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByMainDiagonal(GameTable gameTable, Sign sign) {
        return gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isWinnerBySecondaryDiagonal(GameTable gameTable, Sign sign) {
        return gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 0)) &&
                gameTable.getSign(new Cell(2, 0)) == sign;
    }
}
