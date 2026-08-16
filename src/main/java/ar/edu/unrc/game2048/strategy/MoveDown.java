package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;

import java.util.LinkedList;
import java.util.List;

/**
 * Moves all tiles downward.
 * @return true if the board changed, false otherwise
 */
 public class MoveDown extends Move {

  public int execute(Board board, Cell[][] grid){
   int size = board.getSize();
   int score = 0;
   for (int col = 0; col < size; col++) {
    List<Cell> column = getColumn(col, grid);
    List<Cell> nonEmpty = removeEmptyCells(column);
    List<Cell> merged = new LinkedList<>();
    int i = 0;
    while (i < nonEmpty.size()) {
        if (i + 1 < nonEmpty.size() && nonEmpty.get(i).canMergeWith(nonEmpty.get(i + 1))) {
            Cell mergedCell = nonEmpty.get(i).mergeWith(nonEmpty.get(i + 1));
            merged.add(mergedCell);
            score += mergedCell.getValue();
            i += 2;
        } else {
            merged.add(nonEmpty.get(i));
            i++;
        }
    }

    while (merged.size() < size) { merged.add(Cell.EMPTY); }

    for (int row = size - 1; row >= 0; row--) {
        grid[row][col] = merged.get(size - 1 - row); }
   }
   return score;
  }
 }
