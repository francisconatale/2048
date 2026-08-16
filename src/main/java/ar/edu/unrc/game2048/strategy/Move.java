package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;

import java.util.*;

public abstract class Move {

public abstract int execute(Board board, Cell[][] grid);

public List<Cell> getColumn(int column, Cell[][] grid) {
    List<Cell> result = new ArrayList<>();
    int size = grid.length;
    for (int row = 0; row < size; row++) {
        result.add(grid[row][column]);
    }
    return result;
}

public List<Cell> getRow(int row, Cell[][] grid){
    List<Cell> result = new LinkedList<>();
    Collections.addAll(result, grid[row].clone());
    return result;
}

public List<Cell> removeEmptyCells(List<Cell> cells){
    return cells.stream().filter(Cell::isEmpty).toList();
}


}
