package ar.edu.unrc.game2048.strategy;

import ar.edu.unrc.game2048.Board.Direction;
import java.util.EnumMap;
import java.util.Map;

public class MoveProvider {

    private static final Map<Direction, Move> providers = new EnumMap<>(Direction.class);

    static {
        providers.put(Direction.UP, new MoveUp());
        providers.put(Direction.DOWN, new MoveDown());
        providers.put(Direction.LEFT, new MoveLeft());
        providers.put(Direction.RIGHT, new MoveRight());
    }

    public Move provide(Direction direction) {
        return providers.get(direction);
    }
}
