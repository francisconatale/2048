package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board;

public class MoveFactory {

    public Move create(Board.Direction direction) {
        if(direction == Board.Direction.UP) {
            return new MoveUp();
        } else if (direction == Board.Direction.DOWN) {
            return new MoveDown();
        } else if (direction == Board.Direction.LEFT) {
            return new MoveLeft();
        } else if (direction == Board.Direction.RIGHT) {
            return new MoveRight();
        }
        return null;
    }
}
