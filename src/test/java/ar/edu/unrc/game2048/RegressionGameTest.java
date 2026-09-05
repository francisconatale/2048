package ar.edu.unrc.game2048;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ar.edu.unrc.game2048.utils.BoardParser;
public class RegressionGameTest {
    @Test
    public void regressionTestInMoveDownWithBoardNotTrivial(){
        String initialBoardToParse =
                        "16 8 0 0\n" +
                        "4 2 0 0\n" +
                        "8 2 0 0\n" +
                        "0 2 0 0";
        Board initialBoard = BoardParser.parse(initialBoardToParse);
        String expectedBoardToParse =
                "0 0 0 0\n" +
                "16 8 0 0\n" +
                "4 2 0 0\n" +
                "8 4 0 0";
        Board expectedBoard = BoardParser.parse(expectedBoardToParse);
        expectedBoard.setScore(4);
        initialBoard.move(Board.Direction.DOWN);
        assertEquals(expectedBoard, initialBoard);
    }

    @Test
    public void regressionTestTwoInMoveDownWithBoardNotTrivial(){
        String initialBoardToParse =
                        "0 8 0 0\n" +
                        "4 2 0 0\n" +
                        "8 2 0 0\n" +
                        "0 2 0 0";
        Board initialBoard = BoardParser.parse(initialBoardToParse);
        String expectedBoardToParse =
                "0 0 0 0\n" +
                "0 8 0 0\n" +
                "4 2 0 0\n" +
                "8 4 0 0";
        Board expectedBoard = BoardParser.parse(expectedBoardToParse);
        expectedBoard.setScore(4);
        initialBoard.move(Board.Direction.DOWN);
        assertEquals(expectedBoard, initialBoard);
    }

    @Test
    public void EdgeCaseWithOneMerge(){
        String initialBoardToParse =
                        "2 8 4 2\n" +
                        "4 2 8 4\n" +
                        "8 4 2 4\n" +
                        "4 2 4 2";
        Board initialBoard = BoardParser.parse(initialBoardToParse);
        assertEquals(initialBoard.isLosingBoard(), false);
    }

@Test
public void EdgeCaseWithOneMergeInLimitCasesRow() {

    String initialBoardToParse =
            "2 8 4 2\n" +
            "4 2 8 4\n" +
            "8 4 2 4\n" +
            "4 2 4 4";

    Board initialBoard = BoardParser.parse(initialBoardToParse);

    assertEquals(initialBoard.isLosingBoard(),false);
}

@Test
public void EdgeCaseWithOneMergeInLimitCasesCol() {

    String initialBoardToParse =
            "2 8 2 2\n" +
            "4 2 8 4\n" +
            "8 4 2 4\n" +
            "4 2 8 4";

    Board initialBoard = BoardParser.parse(initialBoardToParse);

    assertEquals(initialBoard.isLosingBoard(),false);
}

    @Test
    public void testTryAddTwoRandomTileAndOnlySetOne(){
        String initialBoardToParse =
                "2 2" + "\n" + "8 2";
        Board board = BoardParser.parse(initialBoardToParse, false);
        board.move(Board.Direction.RIGHT);
        assertEquals(board.isFull(), true);
    }


    @Test
    public void testTryMoveUpAndNotMoveNumbers(){
        String initialBoardToParse =
                        "16 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0";
        Board initialBoard = BoardParser.parse(initialBoardToParse, false);
        Board expectedBoard = new Board(initialBoard);
        initialBoard.move(Board.Direction.UP);
        assertEquals(initialBoard,expectedBoard);
    }

}
