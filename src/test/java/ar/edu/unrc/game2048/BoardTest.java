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
        seeder.seederBoard(board, 1);
        System.out.println(board.toString());
        assertTrue(board.hasEmptyCells());
    }


    @Test
    public void testMoveUpInGame(){
      // arrange
     Board actual_board = new Board(4, true);
     actual_board.setCell(0,0, new Cell(2));
     actual_board.setCell(1,0, new Cell(2));
     Board expected_board = new Board(4, true);
     expected_board.setCell(0,0,new Cell(4));
     expected_board.setScore(4); // when two cells are merged, the score increases

     // act
     actual_board.move(Direction.UP);

     // assert
      assertEquals(actual_board, expected_board);
    }

    @Test
    public void testMoveLeftInGame(){
        // arrange
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,1, new Cell(2));
        actual_board.setCell(0,0, new Cell(2));
        Board expected_board = new Board(4, true);
        expected_board.setCell(0,0,new Cell(4));
        expected_board.setScore(4); // when two cells are merged, the score increases

        // act
        actual_board.move(Direction.LEFT);

        // assert
        assertEquals(actual_board, expected_board);
    }

    @Test
    public void maximumScoreOfBoardTest() {
        Board board = new Board(4,true);
        board.setCell(0,  0,new Cell(2));
        board.setCell(0,1, new Cell(2));
        board.move(Direction.LEFT);
        int scoreExpected = 4;
        assertEquals(scoreExpected, board.getScore());
    }

    @Test
    public void notHasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        int n = board.getSize();
        seeder.seederBoard(board, n * n);
        assertFalse(board.hasEmptyCells());
    }

    @Test
    public void testBoardGetCell() {
        // arrange
        Board board = new Board();
        // act
        Cell cell = board.getCell(0, 0);

        // assert
        assertNotNull(cell);
    }

    @Test
    public void testBoardIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Board board = new Board();
            board.getCell(-1, 0);
        });
    }

    @Test
    public void testBoardGetEmptyPositions() {
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
