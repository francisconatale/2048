package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;

import java.util.ArrayList;
import java.util.List;

public class MoveLeft extends Move {


    @Override
    public int execute(Board board, Cell[][] grid, int score) {
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            List<Cell> rowList = getRow(row, grid);
            List<Cell> nonEmpty = removeEmptyCells(rowList);
            List<Cell> merged = mergeCells(nonEmpty, score);
            while (merged.size() < size) { merged.add(Cell.EMPTY); }
            fillRow(row, merged, grid);
        }

        return score;
    }
}

