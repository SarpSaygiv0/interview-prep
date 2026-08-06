package com.katas.marsrover;

public enum Compass {

    NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

    private final int dx;
    private final int dy;

    Compass(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    Compass right() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    Compass left() {
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    Position moveFrom(Position position) {
        return new Position(position.x() + dx, position.y() + dy);
    }

}
