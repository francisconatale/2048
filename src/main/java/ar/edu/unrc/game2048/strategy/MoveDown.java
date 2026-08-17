package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;
import ar.edu.unrc.game2048.Score;

import java.util.LinkedList;
import java.util.List;

/**
 * Moves all tiles downward.
 * @return score after move
 */
 public class MoveDown extends Move {

  public void execute(Board board, Cell[][] grid, Score score){
   int size = board.getSize();
   for (int col = 0; col < size; col++) {
    List<Cell> column = getColumn(col, grid).reversed();
    List<Cell> nonEmpty = removeEmptyCells(column);
    List<Cell> merged = mergeCells(nonEmpty, score);
    while (merged.size() < size) { merged.add(Cell.EMPTY); }
    fillColumn(col, merged.reversed(), grid);
   }
  }
 }
