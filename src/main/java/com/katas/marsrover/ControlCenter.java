package com.katas.marsrover;

import java.util.HashSet;
import java.util.Set;


public class ControlCenter {

    private final Rover rover;
    private final Site site;

    public ControlCenter(Position start, Compass heading) {
        this.rover = new Rover(start, heading);
        this.site = new Site(new HashSet<>());
    }

    public ControlCenter(Position start, Compass heading, Set<Position> rocks) {
        this.rover = new Rover(start, heading);
        this.site = new Site(rocks);
    }

    public Location getLocation() {
        return rover.getLocation();
    }

    public RunReport run(String instructions) {
        for (int i = 0; i < instructions.length(); i++) {
            if (!apply(instructions.charAt(i))) {
                return new RunReport(rover.getLocation(), true, i);
            }
        }
        return new RunReport(rover.getLocation(), false, instructions.length());
    }

    private boolean apply(char instruction) {
        return switch (instruction) {
            case 'L' -> {
                rover.turnLeft();
                yield true;
            }
            case 'R' -> {
                rover.turnRight();
                yield true;
            }
            case 'M' -> rover.moveForward(site);
            default -> throw new IllegalArgumentException("unknown instruction: " + instruction);
        };
    }

}
