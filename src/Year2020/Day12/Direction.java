package Year2020.Day12;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    EAST(0),
    SOUTH(90),
    WEST(180),
    NORTH(270);

    public final int degrees;

    private Direction(int degrees) {
        this.degrees = degrees;
    }

    private static final Map<Integer, Direction> BY_DEGREES = new HashMap<>();

    static {
        for (Direction d : values()) {
            BY_DEGREES.put(d.degrees, d);
        }
    }

    public Direction turnRight(int turnDegrees) {
        int newDegree = (this.degrees + turnDegrees) % 360;
        return BY_DEGREES.get(newDegree);
    }

    public Direction turnLeft(int turnDegrees) {
        turnDegrees = turnDegrees % 360;
        turnDegrees = 360 - turnDegrees;
        int newDegree = (this.degrees + turnDegrees) % 360;
        return BY_DEGREES.get(newDegree);
    }
}
