package ar.edu.unrc.game2048.strategy;

public class MoveUp extends Move {

    public boolean moveUp() {
        Board previous = new Board(this);

        // For each column, slide up
        for (int col = 0; col < size; col++) {
            // Create a list of cells from top to bottom
            List<Cell> column = new ArrayList<>();
            for (int row = 0; row < size; row++) {
                column.add(grid[row][col]);
            }

            // Remove empty cells (slide up)
            List<Cell> nonEmpty = new ArrayList<>();
            for (Cell cell : column) {
                if (!cell.isEmpty()) {
                    nonEmpty.add(cell);
                }
            }

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

        boolean moved = !this.equals(previous);
        if (moved && !determinist) {
            addRandomTile(); // Add new random tile after successful move
        }
        return moved;
    }


}
