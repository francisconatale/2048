package ar.edu.unrc.game2048.utils;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;

public class BoardParser {

    /**
     * Parses a string representation of a board into a Board object.
     * The input string should have rows separated by newlines and cell values
     * separated by whitespace.
     *
     * Example input:
     * "2 0 0 4\n" +
     * "0 8 0 0\n" +
     * "0 0 0 0\n" +
     * "2 0 0 0"
     *
     * @param boardString the string representation of the board
     * @return a new Board instance populated with the specified values
     * @throws IllegalArgumentException if the string format is invalid
     */
    public static Board parse(String boardString) {
        if (boardString == null || boardString.trim().isEmpty()) {
            throw new IllegalArgumentException("Board string cannot be null or empty");
        }

        String[] lines = boardString.trim().split("\\r?\\n");
        int size = lines.length;
        
        // We initialize the board in deterministic mode so it doesn't spawn random tiles
        Board board = new Board(size, true);

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
}
