package com.katas.marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MarsRoverTest {

    private static final Position ORIGIN = new Position(0, 0);
    private static final Set<Position> ROCKS = Set.of(
            new Position(1, 3),
            new Position(2, 1),
            new Position(-1, 0),
            new Position(0, 4),
            new Position(3, 3)
    );

    @ParameterizedTest
    @CsvSource({"NORTH, WEST", "WEST, SOUTH", "SOUTH, EAST", "EAST, NORTH"})
    void turningLeftRotatesAnticlockwise(Compass start, Compass expected) {
        ControlCenter center = roverAt(start);
        center.run("L");
        assertThat(center.getLocation()).isEqualTo(new Location(ORIGIN, expected));
    }

    @ParameterizedTest
    @CsvSource({"NORTH, EAST", "EAST, SOUTH", "SOUTH, WEST", "WEST, NORTH"})
    void turningRightRotatesClockwise(Compass start, Compass expected) {
        ControlCenter center = roverAt(start);
        center.run("R");
        assertThat(center.getLocation()).isEqualTo(new Location(ORIGIN, expected));
    }

    @ParameterizedTest
    @CsvSource({"NORTH, 0, 1", "EAST, 1, 0", "SOUTH, 0, -1", "WEST, -1, 0"})
    void movingOneSquareGoesInTheDirectionItIsFacing(Compass heading, int x, int y) {
        ControlCenter center = roverAt(heading);
        center.run("M");
        assertThat(center.getLocation())
                .isEqualTo(new Location(new Position(x, y), heading));
    }

    @Test
    void aRunOfSeveralInstructionsIsExecutedInOrder() {
        ControlCenter center = roverAt(Compass.NORTH);
        RunReport report = center.run("LMMRMMM");
        assertThat(report).isEqualTo(new RunReport(
                new Location(new Position(-2, 3), Compass.NORTH), false, 7));
    }

    @Test
    void anEmptyRunLeavesTheRoverWhereItWas() {
        ControlCenter center = roverAt(Compass.NORTH);
        RunReport report = center.run("");
        assertThat(report).isEqualTo(new RunReport(
                new Location(ORIGIN, Compass.NORTH), false, 0));
    }

    @Test
    void theRoverStopsOnTheSquareBeforeARockAndReportsWhereItGotTo() {
        ControlCenter center = roverAt(Compass.NORTH, ROCKS);
        RunReport report = center.run("MMMMM");
        assertThat(report).isEqualTo(new RunReport(
                new Location(new Position(0, 3), Compass.NORTH), true, 3));
    }

    @Test
    void aRockOnTheVeryFirstSquareStopsTheRunBeforeItStarts() {
        ControlCenter center = roverAt(Compass.WEST, ROCKS);
        RunReport report = center.run("MMM");
        assertThat(report).isEqualTo(new RunReport(
                new Location(ORIGIN, Compass.WEST), true, 0));
    }

    @Test
    void aRunThatMissesEveryRockCompletes() {
        ControlCenter center = roverAt(Compass.NORTH, ROCKS);
        RunReport report = center.run("MM");
        assertThat(report).isEqualTo(new RunReport(
                new Location(new Position(0, 2), Compass.NORTH), false, 2));
    }

    @Test
    void rocksDoNotStopTheRoverFromTurning() {
        ControlCenter center = roverAt(Compass.WEST, ROCKS);
        RunReport report = center.run("LLLL");
        assertThat(report.blocked()).isFalse();
    }

    @Test
    void anUnknownInstructionIsRejected() {
        ControlCenter center = roverAt(Compass.NORTH);

        assertThatThrownBy(() -> center.run("MXM"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("X");
    }

    private static ControlCenter roverAt(Compass heading) {
        return new ControlCenter(MarsRoverTest.ORIGIN, heading);
    }

    private static ControlCenter roverAt(Compass heading, Set<Position> rocks) {
        return new ControlCenter(MarsRoverTest.ORIGIN, heading, rocks);
    }
}