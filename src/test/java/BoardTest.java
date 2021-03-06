import entities.Board;
import entities.Pieces;
import gui.BoardShellPrinter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    //FIELDS
    protected static Board board;

    //METHODS
    @BeforeClass
    public static void initBoard() {
        board = new Board();
    }

    @Test
    public void is13x13() {
        assertEquals(board.getMatrix().length, 13);
        assertEquals(board.getMatrix()[0].length, 13);
        assertEquals(board.getMatrix()[6].length, 13);
        assertEquals(board.getMatrix()[12].length, 13);
    }

    @Test
    public void isInitialized() {
        for (Pieces[] row: board.getMatrix()) {
            for (Pieces p: row) {
                assertNotNull(p);
            }
        }
    }

    @Test
    public void printBoard() {
        BoardShellPrinter bp = board.getPrinter();
        bp.printOnStdOut(true);
    }
}
