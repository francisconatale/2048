package ar.edu.unrc.game2048;

import ar.edu.unrc.game2048.utils.BoardParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        initialBoard.moveDown();

        assertEquals(expectedBoard, initialBoard);
    }

    public void regressionTestInMoveUpWithBoardNotTrivial(){
        String initialBoardToParse =
                        "16 4 0 0\n" +
                        "4 0 0 0\n" +
                        "8 2 0 0\n" +
                        "0 2 0 0";
        Board initialBoard = BoardParser.parse(initialBoardToParse);
        String expectedBoardToParse =
                "16 4 0 0\n" +
                "4 4 0 0\n" +
                "8 0 0 0\n" +
                "0 0 0 0";
        Board expectedBoard = BoardParser.parse(expectedBoardToParse);
        expectedBoard.setScore(4);

        initialBoard.moveDown();

        assertEquals(expectedBoard, initialBoard);
    }
}
