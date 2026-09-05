package ar.edu.unrc.game2048.utils;
import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;
public class BoardParser {
    public static Board parse(String boardString, boolean deterministic) {
        if (boardString == null || boardString.trim().isEmpty()) {
            throw new IllegalArgumentException("Board string cannot be null or empty");
        }
        String[] lines = boardString.trim().split("\\r?\\n");
        int size = lines.length;
        Board board = new Board(size, deterministic);
        for (int r = 0; r < size; r++) {
            String[] tokens = lines[r].trim().split("\\s+");
            if (tokens.length != size) {
                throw new IllegalArgumentException("Invalid board format. Expected " + size + " columns, but got " + tokens.length + " on row " + r);
            }
            for (int c = 0; c < size; c++) {
                int value = Integer.parseInt(tokens[c]);
                Cell cell = (value == 0) ? Cell.EMPTY : new Cell(value);
                board.setCell(r, c, cell);
            }
        }
        return board;
    }

    public static Board parse(String boardString) {
        return parse(boardString,true);
    }
}
