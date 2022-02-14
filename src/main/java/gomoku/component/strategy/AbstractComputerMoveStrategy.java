package gomoku.component.strategy;

import gomoku.component.ComputerMoveStrategy;
import gomoku.model.game.Cell;
import gomoku.model.game.GameTable;
import gomoku.model.game.Sign;

import java.util.Random;

import static gomoku.Constants.GAME_TABLE_SIZE;
import static gomoku.Constants.WIN_COMBINATION_SIZE;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public abstract class AbstractComputerMoveStrategy implements ComputerMoveStrategy {

    final int expectedCountEmptyCells;

    protected AbstractComputerMoveStrategy(int expectedCountEmptyCells) {
        this.expectedCountEmptyCells = expectedCountEmptyCells;
    }

    @Override
    public final boolean tryToMakeMove(final GameTable gameTable, final Sign moveSign) {
        final Sign findSign = getFindSign(moveSign);
        final BestCells bestCells = new BestCells();
        findBestCellsForMoveByRows(gameTable, findSign, bestCells);
        findBestCellsForMoveByCols(gameTable, findSign, bestCells);
        findBestCellsForMoveByMainDiagonal(gameTable, findSign, bestCells);
        findBestCellsForMoveBySecondaryDiagonal(gameTable, findSign, bestCells);
        if (bestCells.count > 0) {
            final Cell randomCell = bestCells.emptyCells[new Random().nextInt(bestCells.count)];
            gameTable.setSign(randomCell, moveSign);
            return true;
        } else {
            return false;
        }
    }

    private void findBestCellsForMoveByRows(final GameTable gameTable, final Sign findSign, final BestCells bestCells) {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            findBestCellsForMoveUsingLambdaConversion(gameTable, findSign, bestCells, i, (k, j) -> new Cell(k, j));
        }
    }

    private void findBestCellsForMoveByCols(final GameTable gameTable, final Sign findSign, final BestCells bestCells) {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            findBestCellsForMoveUsingLambdaConversion(gameTable, findSign, bestCells, i, (k, j) -> new Cell(j, k));
        }
    }

    private void findBestCellsForMoveByMainDiagonal(final GameTable gameTable, final Sign findSign, final BestCells bestCells) {
        findBestCellsForMoveUsingLambdaConversion(gameTable, findSign, bestCells, -1, (k, j) -> new Cell(j, j));
    }

    private void findBestCellsForMoveBySecondaryDiagonal(final GameTable gameTable, final Sign findSign, final BestCells bestCells) {
        findBestCellsForMoveUsingLambdaConversion(gameTable, findSign, bestCells, -1, (k, j) -> new Cell(j, 2 - j));
    }

    protected abstract Sign getFindSign(Sign moveSign);

    private void findBestCellsForMoveUsingLambdaConversion(final GameTable gameTable,
                                                           final Sign findSign,
                                                           final BestCells bestCells,
                                                           final int i,
                                                           final Lambda lambda) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        final Cell[] localEmptyCells = new Cell[WIN_COMBINATION_SIZE];
        int count = 0;
        for (int j = 0; j < WIN_COMBINATION_SIZE; j++) {
            final Cell cell = lambda.convert(i, j);
            if (gameTable.isEmpty(cell)) {
                localEmptyCells[count++] = cell;
                countEmptyCells++;
            } else if (gameTable.getSign(cell) == findSign) {
                countSignCells++;
            } else {
                break;
            }
        }

        if (countEmptyCells == expectedCountEmptyCells &&
                countSignCells == WIN_COMBINATION_SIZE - expectedCountEmptyCells) {
            for (int j = 0; j < count; j++) {
                bestCells.add(localEmptyCells[j]);
            }
        }
    }

    /**
     * @author devonline
     * @link http://devonline.academy/java
     */
    @FunctionalInterface
    private interface Lambda {

        Cell convert(int k, int j);
    }

    private static class BestCells {
        private final Cell[] emptyCells = new Cell[GAME_TABLE_SIZE * GAME_TABLE_SIZE];
        private int count;

        private void add(final Cell cell) {
            emptyCells[count++] = cell;
        }
    }
}
