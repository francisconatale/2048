package ar.edu.unrc.game2048;

import org.junit.jupiter.api.Test;
import ar.edu.unrc.game2048.Board.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    public void positionEqualsForReferenceTest(){
        Position position = new Position(0,2);
        Position samePosition = position;
        assertEquals(position, samePosition);
    }

    @Test
    public void positionNotEqualsADifferentClass(){
        Position position = new Position(0,2);
        Board board = new Board();
        assertNotEquals(position, board);
    }

    @Test
    public void testEqualsPositionWithDifferentReferences(){
        Position position = new Position(0,2);
        Position otherPosition = new Position(0,2);
        assertEquals(position, otherPosition);
    }

    @Test
    public void testNotEqualsPositionWithDifferentReferences(){
        Position position = new Position(0,2);
        Position otherPosition = new Position(1,2);
        assertNotEquals(position, otherPosition);
    }

}
