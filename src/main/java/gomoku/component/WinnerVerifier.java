package gomoku.component;

import gomoku.model.game.Cell;
import gomoku.model.game.GameTable;
import gomoku.model.game.Player;
import gomoku.model.game.Sign;

import static gomoku.Constants.WIN_COMBINATION_SIZE;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class WinnerVerifier {

    public boolean isWinner(final GameTable gameTable, final Player player) {
        return isWinnerByRows(gameTable, player.getSign()) ||
                isWinnerByCols(gameTable, player.getSign()) ||
                isWinnerByMainDiagonal(gameTable, player.getSign()) ||
                isWinnerBySecondaryDiagonal(gameTable, player.getSign());
    }

    private boolean isWinnerByRows(GameTable gameTable, Sign sign) {
        for (int i = 0; i < WIN_COMBINATION_SIZE; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByCols(GameTable gameTable, Sign sign) {
        for (int i = 0; i < WIN_COMBINATION_SIZE; i++) {
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
