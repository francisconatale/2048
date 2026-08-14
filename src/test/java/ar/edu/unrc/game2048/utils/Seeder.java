package ar.edu.unrc.game2048.utils;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Board.Position;
import ar.edu.unrc.game2048.Cell;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Seeder {

    private static final List<Position> DIRECTIONS = List.of(
            new Position(0, 1),
            new Position(1, 0),
            new Position(-1, 0),
            new Position(0, -1)
    );

    private static final List<Integer> POSSIBLE_VALUES = List.of(
            2, 4, 8, 16, 32, 64, 128, 256, 512, 1024
    );

    private final Random random = new Random();

    public void seederLostBoard(Board board) {
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Position position = new Position(row, col);
                List<Integer> neighbors = valueOfNeighborCells(position, board);

                board.setCell(
                        row,
                        col,
                        new Cell(unusedNeighborValue(neighbors))
                );
            }
        }
    }

    private List<Integer> valueOfNeighborCells(Position position, Board board) {
        List<Integer> values = new LinkedList<>();

        for (Position direction : DIRECTIONS) {
            int row = position.row + direction.row;
            int col = position.col + direction.col;

            if (isValidPosition(row, col, board.getSize())) {
                values.add(board.getCell(row, col).getValue());
            }
        }

        return values;
    }

    private boolean isValidPosition(int row, int col, int size) {
        return row >= 0 && row < size
                && col >= 0 && col < size;
    }

    private int unusedNeighborValue(List<Integer> excluded) {
        List<Integer> available = new LinkedList<>(POSSIBLE_VALUES);

        for (Integer value : excluded) {
            available.remove(value);
        }

        return available.get(random.nextInt(available.size()));
    }
}