package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;

import java.util.ArrayList;
import java.util.List;

public class MoveUp extends Move {

    @Override
    public int execute(Board board, Cell[][] grid) {
        int size = grid.length;
        // For each column, slide up
        int score = 0;

        for (int col = 0; col < size; col++) {
            // Create a list of cells from top to bottom
            List<Cell> column = getColumn(col, grid);

            List<Cell> nonEmpty = removeEmptyCells(column);


            // Merge adjacent equal cells
            List<Cell> merged = new ArrayList<>();
            int i = 0;
            while (i < nonEmpty.size()) {
                if (i + 1 < nonEmpty.size() &&
                        nonEmpty.get(i).canMergeWith(nonEmpty.get(i + 1))) {
                    Cell mergedCell = nonEmpty.get(i).mergeWith(nonEmpty.get(i + 1));
                    merged.add(mergedCell);
                    score += mergedCell.getValue();
                    i += 2;
                } else {
                    merged.add(nonEmpty.get(i));
                    i++;
                }
            }

            // Pad with empty cells
            while (merged.size() < size) {
                merged.add(Cell.EMPTY);
            }

            // Put back into the column
            for (int row = 0; row < size; row++) {
                grid[row][col] = merged.get(row);
            }
        }
        return score;
        }
    }
