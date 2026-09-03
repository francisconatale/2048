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

    // 
    // ------ Board.getCell(int row, int col) ------
    // Verifica que el metodo getCell() de la clase Board devuelva la celda correcta en la posicion especificada
    // 

    @Test
    public void testBoardGetCell() {
        // arrange
        Board board = new Board();
        // act
        Cell cell = board.getCell(0, 0);

        // assert
        assertNotNull(cell);
    }

    // 
    // ------ Board.IndexOutOfBoundsException() ------
    // Verifica que la excepcion IndexOutOfBoundsException() del metodo getCell() tire la excepcion
    // cuando se intenta acceder a una celda fuera de los limites del tablero
    //

    @Test
    public void testBoardIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Board board = new Board();
            board.getCell(-1, 0);
        });
    }

    // 
    // ------ Board.testBoardGetEmptyPositions() ------
    // Verifica que el metodo getEmptyPositions() de la clase Board devuelva un conjunto con las posiciones vacias del tablero
    // 

    @Test
    public void testBoardGetEmptyPositions() {
        // arrange
        Board board = new Board();

        // act
        Set<Position> emptyPositions = board.getEmptyPositions();

        // assert
        assertNotNull(emptyPositions);
    }

    // 
    // ------ Board.testBoardIsWinningBoard() ------
    // Verifica que el metodo isWinningBoard() de la clase Board devuelva true si el tablero es ganador
    // (contiene una celda con valor 2048)
    // 

    @Test
    public void testBoardIsWinningBoard() {
        // arrange
        Board board = new Board(4, true);
        board.setCell(0,0, new Cell(2048));

        // act
        boolean isWinning = board.isWinningBoard();

        // assert
        assertTrue(isWinning);
    }

    // 
    // ------ Board.testBoardIsNotWinningBoard() ------
    // Verifica que el metodo isWinningBoard() de la clase Board devuelva false si el tablero no es ganador
    // (no contiene ninguna celda con valor 2048)
    // 

    @Test
    public void testBoardIsNotWinningBoard() {
        // arrange
        Board board = new Board();

        // act
        boolean isWinning = board.isWinningBoard();

        // assert
        assertFalse(isWinning);
    }

    // 
    // ------ Board.testBoardIsFull() ------
    // Verifica que el metodo isFull() de la clase Board devuelva true si el tablero esta lleno
    // 

    @Test
    public void testBoardIsFull() {
        // arrange
        Board board = new Board(4, true);
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.setCell(i, j, new Cell(2));
            }
        }

        // act
        boolean isFull = board.isFull();

        // assert
        assertTrue(isFull);
    }

    // 
    // ------ Board.testBoardIsNotFull() ------
    // Verifica que el metodo isFull() de la clase Board devuelva false si el tablero no esta lleno
    // 

    @Test
    public void testBoardIsNotFull() {
        // arrange
        Board board = new Board();

        // act
        boolean isFull = board.isFull();

        // assert
        assertFalse(isFull);
    }

    // 
    // ------ Board.testBoardMoveDown() ------
    // Verifica que el metodo move() de la clase Board funcione correctamente al mover las celdas hacia abajo
    // unificando las celdas con el mismo valor y actualizando el puntaje del tablero
    // 

    @Test
    public void testBoardMoveDown() {
        // arrange
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,0, new Cell(2));
        actual_board.setCell(1,0, new Cell(2));

        Board expected_board = new Board(4, true);
        expected_board.setCell(3,0,new Cell(4));
        expected_board.setScore(4);

        // act
        actual_board.move(Direction.DOWN);

        // assert
        assertEquals(actual_board, expected_board);
    }

    // 
    // ------ Board.testBoardMmoveRight() ------
    // Verifica que el metodo move() de la clase Board funcione correctamente al mover las celdas hacia la derecha
    // unificando las celdas con el mismo valor y actualizando el puntaje del tablero
    // 

    @Test
    public void testBoardMmoveRight() {
        // arrange
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,0, new Cell(2));
        actual_board.setCell(0,1, new Cell(2));

        Board expected_board = new Board(4, true);
        expected_board.setCell(0,3,new Cell(4));
        expected_board.setScore(4);

        // act
        actual_board.move(Direction.RIGHT);

        // assert
        assertEquals(actual_board, expected_board);
    }

    // 
    // ------ Board.testBoardHashCode() ------
    // Verifica que el metodo hashCode() de la clase Board funcione correctamente
    // 

    @Test
    public void testBoardHashCode() {
        // arrange
        Board board = new Board(4, true);
        board.setCell(0,0, new Cell(2));
        board.setCell(0,1, new Cell(2));

        // act
        int hashCode = board.hashCode();

        // assert
        // No se necesita un assert especifico, solo se verifica que no tire ninguna excepcion
        assertNotNull(hashCode);
    }

}
