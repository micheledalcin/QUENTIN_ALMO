package logic.BeforeMove.IllegalMoveLogic;

import entities.BoardCoordinate;
import exceptions.InvalidCoordinateException;


public class CardinalCoordinates {
    protected BoardCoordinate southWestCell;
    protected BoardCoordinate northWestCell;
    protected BoardCoordinate northEastCell;
    protected BoardCoordinate southEastCell;
    protected BoardCoordinate northCell;
    protected BoardCoordinate southCell;
    protected BoardCoordinate eastCell;
    protected BoardCoordinate westCell;

    /**
     * This constructor defines all the possible cardinal cells of a given coordinate on the board.
     *
     * @param coordinate
     * @param boardDimension
     * @throws InvalidCoordinateException
     */

    public CardinalCoordinates(BoardCoordinate coordinate, int boardDimension) throws InvalidCoordinateException {
        if(coordinate.getX() != 0){
            northCell = new BoardCoordinate(coordinate.getX()-1, coordinate.getY());
            if(coordinate.getY() != 0) {
                northWestCell = new BoardCoordinate(coordinate.getX() - 1, coordinate.getY() - 1);
                westCell = new BoardCoordinate(coordinate.getX(), coordinate.getY() - 1);
            }
            if(coordinate.getY() != boardDimension - 1) {
                northEastCell = new BoardCoordinate(coordinate.getX() - 1, coordinate.getY() + 1);
                eastCell = new BoardCoordinate(coordinate.getX(), coordinate.getY() + 1);
            }
        }
        if(coordinate.getX() != boardDimension - 1) {
            southCell = new BoardCoordinate(coordinate.getX() + 1, coordinate.getY());
            if (coordinate.getY() != 0) {
                southWestCell = new BoardCoordinate(coordinate.getX() + 1, coordinate.getY() - 1);
                if(westCell == null)
                    westCell = new BoardCoordinate(coordinate.getX(), coordinate.getY() - 1);
            }
            if (coordinate.getY() != boardDimension - 1) {
                southEastCell = new BoardCoordinate(coordinate.getX() + 1, coordinate.getY() + 1);
                if(eastCell == null)
                    eastCell = new BoardCoordinate(coordinate.getX(), coordinate.getY() + 1);
            }
        }
    }
}
