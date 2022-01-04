package logic.afterMove;

import entities.Board;
import entities.Player;
import exceptions.InvalidCoordinateException;
import exceptions.VictoryException;

import static logic.afterMove.territoryLogic.TerritoriesLogic.checkTerritories;
import static logic.afterMove.victoryCondition.VictoryCondition.checkVictoryCondition;

public class AfterMoveChecker {
    protected Board board;
    protected Player player;

    public AfterMoveChecker(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    /**
     * This method calls 2 other methods: one checks if new territories have been formed,
     * the other one if the victory condition has been satisfied.
     *
     * @return the updated board if a new territory has been found, the current board otherwise
     * @throws VictoryException
     * @throws InvalidCoordinateException
     */
    public Board checkAndUpdateBoardAfterMove() throws VictoryException, InvalidCoordinateException {
        Board boardChecked = board;
        //If there have been at least 3 moves it makes sense to check the territories
        if (board.getMovesHistory().size() > 2) {
            boardChecked = checkTerritories(board, player);
        }
        checkVictoryCondition(board, player);
        return boardChecked;
    }
}
