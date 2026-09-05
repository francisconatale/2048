package ar.edu.unrc.game2048;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Random;

import ar.edu.unrc.game2048.Board.Direction;
import ar.edu.unrc.game2048.Board.Position;
import ar.edu.unrc.game2048.utils.Seeder;
public class BoardTest {
    Seeder seeder = new Seeder();
    @Test
    public void invalidBoardTest() {
    assertThrows(IllegalArgumentException.class, () -> new Board(0, true));
    }

    @Test
    public void lostBoardTest() {
        Board board = new Board(4, true);
        seeder.seederLostBoard(board);
        assertTrue(board.isLosingBoard());
    }

     @Test
    public void copyABoardTest() {
        Board board = new Board(4, true);
        seeder.seederBoard(board, 5);
        Board copyOfBoard = new Board(board);
        assertEquals(board,copyOfBoard);
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
     Board actual_board = new Board(4, true);
     actual_board.setCell(0,0, new Cell(2));
     actual_board.setCell(1,0, new Cell(2));
     Board expected_board = new Board(4, true);
     expected_board.setCell(0,0,new Cell(4));
     expected_board.setScore(4); 
     actual_board.move(Direction.UP);
      assertEquals(actual_board, expected_board);
    }

    @Test
    public void testMoveLeftInGame(){
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,1, new Cell(2));
        actual_board.setCell(0,0, new Cell(2));
        Board expected_board = new Board(4, true);
        expected_board.setCell(0,0,new Cell(4));
        expected_board.setScore(4); 
        actual_board.move(Direction.LEFT);
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
    public void setCellNegativeRowTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(-1, 2, cell)
    );
    }
    @Test
    public void trySetCellNullAndGetThrows() {
    Board board = new Board(4, true);
    Cell cell = null;
    assertThrows(
        IllegalArgumentException.class,
        () -> board.setCell(2, 2, cell)
    );
    }
    @Test
    public void setCellRowOutOfBoundsTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(4, 2, cell)
    );
    }
    @Test
    public void setCellNegativeColumnTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(2, -1, cell)
    );
    }
    @Test
    public void setCellColumnOutOfBoundsTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(2, 4, cell)
    );
    }
    @Test
    public void setCellFirstValidPositionTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    board.setCell(0, 0, cell);
    }
    @Test
    public void setCellLastValidPositionTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    board.setCell(3, 3, cell);
    }
    @Test
    public void testBoardGetCell() {
        Board board = new Board();
        Cell cell = board.getCell(0, 0);
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
    public void toStringTest() {
    Board board = new Board(2, true);

    board.setCell(0, 0, new Cell(2));
    board.setCell(1, 1, new Cell(4));

    String expected =
            "Score: 0\n" +
            "+-----+-----+\n" +
            "|    2|     |\n" +
            "+-----+-----+\n" +
            "|     |    4|\n" +
            "+-----+-----+\n";

    assertEquals(expected, board.toString());
    }

    @Test
    public void notEqualsClass(){
    Board board = new Board(2, true);
    Cell cell = new Cell(2);
    assertEquals(board.equals(cell), false);
    }


    @Test
    public void testBoardGetEmptyPositions() {
        Board board = new Board();
        Set<Position> emptyPositions = board.getEmptyPositions();
        assertNotNull(emptyPositions);
    }

    @Test
    public void testBoardIsWinningBoard() {
        Board board = new Board(4, true);
        board.setCell(0,0, new Cell(2048));
        boolean isWinning = board.isWinningBoard();
        assertTrue(isWinning);
    }

    @Test
    public void testBoardIsNotWinningBoard() {
        Board board = new Board();
        boolean isWinning = board.isWinningBoard();
        assertFalse(isWinning);
    }

    @Test
    public void testBoardIsFull() {
        Board board = new Board(4, false);
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.setCell(i, j, new Cell(2));
            }
        }
        boolean isFull = board.isFull();
        assertTrue(isFull);
    }

    @Test
    public void testBoardIsNotFull() {
        Board board = new Board();
        boolean isFull = board.isFull();
        assertFalse(isFull);
    }

    @Test
    public void testBoardMoveDown() {
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,0, new Cell(2));
        actual_board.setCell(1,0, new Cell(2));
        Board expected_board = new Board(4, true);
        expected_board.setCell(3,0,new Cell(4));
        expected_board.setScore(4);
        actual_board.move(Direction.DOWN);
        assertEquals(actual_board, expected_board);
    }

    @Test
    public void testBoardMmoveRight() {
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,0, new Cell(2));
        actual_board.setCell(0,1, new Cell(2));
        Board expected_board = new Board(4, true);
        expected_board.setCell(0,3,new Cell(4));
        expected_board.setScore(4);
        actual_board.move(Direction.RIGHT);
        assertEquals(actual_board, expected_board);
    }

    @Test
    public void testBoardHashCode() {
        Board board = new Board(4, true);
        board.setCell(0,0, new Cell(2));
        board.setCell(0,1, new Cell(2));
        int hashCode = board.hashCode();
        assertNotNull(hashCode);
    }

    @Test
    public void testAddRandomTileEdgeCaseValue4() {
        Random mockRandom = Mockito.mock(Random.class);
        Mockito.when(mockRandom.nextDouble())
                .thenReturn(0.0)  // Index for first tile
                .thenReturn(0.1)  // Value for first tile (generates 2)
                .thenReturn(0.0)  // Index for second tile
                .thenReturn(0.95); // Value for second tile (generates 4)

        Board board = new Board(4, false, mockRandom);
        
        int countFour = 0;
        int countTwo = 0;
        
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).getValue() == 4) countFour++;
                if (board.getCell(i, j).getValue() == 2) countTwo++;
            }
        }
        
        assertEquals(1, countFour, "Debe haber exactamente un 4");
        assertEquals(1, countTwo, "Debe haber exactamente un 2");
    }

    @Test
    public void testAddRandomTileBoundary() {
        Random mockRandom = Mockito.mock(Random.class);
        Mockito.when(mockRandom.nextDouble())
                .thenReturn(Math.nextDown(1.0))
                .thenReturn(0.9)  // Boundary value -> should generate 4
                .thenReturn(0.0)  
                .thenReturn(0.9); // Boundary value -> should generate 4

        Board board = new Board(4, false, mockRandom);
        
        int countFour = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).getValue() == 4) countFour++;
            }
        }
        assertEquals(2, countFour, "El valor limite 0.9 debe generar 4");
    }

    @Test
    public void testAddRandomTileNegatedConditional() {
        Random mockRandom = Mockito.mock(Random.class);
        Mockito.when(mockRandom.nextDouble())
                .thenReturn(0.9) // empty.size() * 1
                .thenReturn(0.8)  // Should generate 2
                .thenReturn(0.0)
                .thenReturn(0.1); // Should generate 2

        Board board = new Board(4, false, mockRandom);
        
        int countTwo = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).getValue() == 2) countTwo++;
            }
        }
        assertEquals(2, countTwo, "Deberia generar solo 2s cuando los valores son menores a 0.9");
    }

}
