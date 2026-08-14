package ar.edu.unrc.game2048;

import ar.edu.unrc.game2048.utils.BoardParser;
import org.junit.jupiter.api.Test;

public class RegressionGameTest {
    @Test
    public void regressionTestInMoveDownWithBoardNotTrivial(){
        String initialBoardToParse =
                        "16 8 0 0\n" +
                        "4 2 0 0\n" +
                        "8 2 0 0\n" +
                        "0 2 0 0";
        Board initialBoard = BoardParser.parse(initialBoardToParse);
        System.out.println(initialBoard);
    }
}
