package entities;

import exceptions.*;
import logic.AfterMoveChecker;
import logic.BeforeMove.BeforeMoveChecker;

import java.util.Date;
import java.util.UUID;

public class Game {
    //FIELDS
    protected final String uuid;
    protected final Date beginTime;
    protected final Player player1;
    protected final Player player2;
    protected Board board;

    //CONSTRUCTORS
    public Game(Player player1, Player player2) {
        this.uuid = UUID.randomUUID().toString();
        this.beginTime = new Date();
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
    }

    //METHODS
    public String getUuid() {
        return this.uuid;
    }

    public Date getBeginTime() {
        return this.beginTime;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public void move(Move move) throws PositionAlreadyOccupiedException, IllegalMoveException, VictoryException, InvalidCoordinateException {
        //controlli sulla mossa...
        BeforeMoveChecker bmc = new BeforeMoveChecker(move, getBoard());
        bmc.checkIfMoveIsPossible();
        // se va a buon fine: mossa
        getBoard().doMove(move);
        //controlli-logica post mossa
        AfterMoveChecker amc = new AfterMoveChecker(getBoard(), move.getPlayer());
        board = amc.checkAndUpdateBoardAfterMove();
        //...
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            Game param = (Game) obj;
            return (this.getUuid().equals(param.getUuid()));
        } else {
            return false;
        }
    }

    /**
     * Checks if player has available moves
     *
     * @return boolean
     */
    public boolean getAvailableMoves(Board board, Player player) {

        for(int i = 0; i<board.DIMENSION-1; i++)
        {
            for(int j = 0; j<board.DIMENSION-1; j++) {

                if(board.getMatrix()[i][j].toString().equals("NONE"))
                {
                    try {
                        Move move = new Move(player, new BoardCoordinate(i, j));
                        BeforeMoveChecker bmc = new BeforeMoveChecker(move, board);
                        bmc.checkIfMoveIsPossible();

                        return true;
                    } catch (InvalidCoordinateException e) {
                        System.out.println("Invalid coordinate. Format should be: a literal from a to m, and right after a number from 0 to 12.Try again.");
                    } catch (PositionAlreadyOccupiedException e) {
                        System.out.println("Invalid coordinate. This position is already occupied by another piece");
                    } catch (IllegalMoveException e) {
                        System.out.println("Invalid coordinate. Please choose another position orthogonal to any your other piece.");
                    }
                }
            }
        }

        return false;
    }
}
