package entities;

import java.util.Date;
import java.util.UUID;

public class Game {
    //FIELDS
    protected final String uuid;
    protected final Date beginTime;
    protected final Player player1;
    protected final Player player2;
    protected final Board board;

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

    public void move(Move move) {
        //controlli sulla mossa...
        //...
        //se va a buon fine:
        getBoard().doMove(move);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            Game param = (Game) obj;
            return (this.getUuid().equals(param.getUuid()));
        }
        else {
            return false;
        }
    }
}