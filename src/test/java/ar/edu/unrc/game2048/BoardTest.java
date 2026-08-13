package ar.edu.unrc.game2048;

import org.junit.jupiter.api.Test;

import ar.edu.unrc.game2048.Cell;

import ar.edu.unrc.game2048.Board.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    // 
    // ------ Board.getCell(int row, int col) ------
    // 

    @Test
    public void testBoardGetCell(){
        // arrange
        Board board = new Board();
        // act
        Cell cell = board.getCell(0, 0);

        // assert
        assertNotNull(cell);
    }

    @Test
    public void testBoardIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Board board = new Board();
            board.getCell(-1, 0);
        });
    }

    // 
    // ------ Board.getEmptyPositions() ------
    // 

    @Test
    public void testBoardGetEmptyPositions(){
        // arrange
        Board board = new Board();

        // act
        Set<Position> emptyPositions = board.getEmptyPositions();

        // assert
        assertNotNull(emptyPositions);
    }
}

// Board.isWinningBoard()

// Board.isFull()

// Board.moveDown()

// Board.moveRight()

// Board.hashCode()