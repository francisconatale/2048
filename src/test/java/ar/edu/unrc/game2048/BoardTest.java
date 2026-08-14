package ar.edu.unrc.game2048;

import ar.edu.unrc.game2048.Board.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unrc.game2048.utils.Seeder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    Seeder seeder = new Seeder();
    @Test
    public void lostBoardTest() {
        Board board = new Board(4, true);
        seeder.seederLostBoard(board);
        assertTrue(board.isLosingBoard());
        }

    @Test
    public void hasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        board.setCell(0,0, new Cell(2));
        assertTrue(board.hasEmptyCells());
    }

    @Test
    public void notHasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        seeder.seederLostBoard(board);
        assertFalse(board.hasEmptyCells());
    }

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
