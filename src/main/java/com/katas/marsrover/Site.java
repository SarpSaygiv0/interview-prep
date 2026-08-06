package com.katas.marsrover;

import java.util.Set;

record Site(Set<Position> rocks) {
    boolean blocks(Position position) {
        return rocks.contains(position);
    }
}
