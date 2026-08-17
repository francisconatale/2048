package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;

import javax.swing.*;
import java.util.*;

public abstract class Move {

public abstract int execute(Board board, Cell[][] grid, int score);

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
    public void fillRow(int rowIndex, List<Cell> cells, Cell[][] grid) {
        for (int columnIndex = 0; columnIndex < grid.length; columnIndex++) {
            grid[rowIndex][columnIndex] = cells.get(columnIndex);
        }
    }

    public void fillColumn(int columnIndex, List<Cell> cells, Cell[][] grid) {
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            grid[rowIndex][columnIndex] = cells.get(rowIndex);
        }
    }

    public List<Cell> mergeCells(List<Cell> cellsToMerge, int score) {
        List<Cell> merged = new LinkedList<>();
        int i = 0;
        while (i < cellsToMerge.size()) {
            if (i + 1 < cellsToMerge.size() && cellsToMerge.get(i).canMergeWith(cellsToMerge.get(i + 1))) {
                Cell mergedCell = cellsToMerge.get(i).mergeWith(cellsToMerge.get(i + 1));
                merged.add(mergedCell);
                score += mergedCell.getValue();
                i += 2;
            } else {
                merged.add(cellsToMerge.get(i));
                i++;
            }
        }
        return merged;
    }

public List<Cell> removeEmptyCells(List<Cell> cells){
    return cells.stream().filter(Cell::isEmpty).toList();
}

}
