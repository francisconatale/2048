package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;
import ar.edu.unrc.game2048.Score;

import java.util.ArrayList;
import java.util.List;

public class MoveRight extends Move {

    @Override
    public void execute(Board board, Cell[][] grid, Score score) {
            int size = board.getSize();
            for (int row = 0; row < size; row++) {
                List<Cell> rowList = getRow(row, grid).reversed();
                List<Cell> nonEmpty = removeEmptyCells(rowList);
                List<Cell> merged = mergeCells(nonEmpty, score);
                while (merged.size() < size) { merged.add(Cell.EMPTY); }
               fillRow(row, merged.reversed(), grid);
            }
        }
    }