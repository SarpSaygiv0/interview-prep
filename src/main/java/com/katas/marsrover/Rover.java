package com.katas.marsrover;

class Rover {
    private Position position;
    private Compass heading;

    public Rover(Position start, Compass heading) {
        this.position = start;
        this.heading = heading;
    }

    void turnLeft() {
        heading = heading.left();
    }

    void turnRight() {
        heading = heading.right();
    }

    boolean moveForward(Site site) {
        Position next = heading.moveFrom(position);
        if (site.blocks(next)) return false;
        position = next;
        return true;
    }

    Location getLocation() {
        return new Location(this.position, this.heading);
    }
}