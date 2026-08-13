package ar.edu.unrc.game2048;
import ar.edu.unrc.game2048.Cell;

import ar.edu.unrc.game2048.Board.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    Map<Integer,Cell> listOfValueCells = listOfPossibleCells();

    @Test
    public void lostBoardTest() {
        Board board = new Board(4, true);
        seederLostBoard(board);
        assertTrue(board.isLosingBoard());
        }

    @Test
    public void hasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        board.setCell(0,0, listOfValueCells.get(2));
        assertTrue(board.hasEmptyCells());
    }

    @Test
    public void NotHasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        seederLostBoard(board);
        assertFalse(board.hasEmptyCells());
    }

    private void seederLostBoard(Board board) {
        int m = board.getSize();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                List<Integer> neighbor = valueOfNeighborCells(new Tuple(i,j), board);
                Integer unusedNeighborValue = unusedNeighborValue(listOfValueCells, neighbor);
                board.setCell(i,j, new Cell(unusedNeighborValue));
            }
        }

    }
    private List<Integer> valueOfNeighborCells(Tuple actual, Board board){
        List<Integer> result = new LinkedList<>();
        List<Tuple> vectors = new LinkedList<>(List.of(new Tuple(0, 1), new Tuple(1, 0), new Tuple(-1, 0), new Tuple(0, -1)));
        for(Tuple tuple: vectors){
            int first = tuple.first() + actual.first();
            int second = tuple.second() + actual.second();
            try {
                Cell neighbor = board.getCell(first,second);
                result.add(neighbor.getValue());
            } catch (Exception e){}
        }
      return result;
    }

    private Map<Integer,Cell> listOfPossibleCells() {
        Map<Integer, Cell> cells = new LinkedHashMap<>();
        for (int i = 2; i < 2048; i*=2) {
            cells.put(i, new Cell(i));
        }
        return cells;
    }

    Integer unusedNeighborValue(
            Map<Integer, Cell> cells,
            List<Integer> excluded
    ) {
        List<Integer> available = cells.keySet()
                .stream()
                .filter(position -> !excluded.contains(position))
                .toList();

        return available.get((int) (Math.random() * available.size()));
    }

    private record Tuple(int first, int second) {}

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
