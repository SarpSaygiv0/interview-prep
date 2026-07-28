package com.katas.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingTest {

    BowlingGame bg;

    @BeforeEach
    void setBowling() {
        bg = new BowlingGame();
    }

    @Test
    void gutter() {
        rollMany(20, 0);
        assertThat(bg.score()).isEqualTo(0);
    }

    @Test
    void allOnes() {
        rollMany(20, 1);
        assertThat(bg.score()).isEqualTo(20);
    }

    @Test
    void spare() {
        // spare
        bg.roll(5);
        bg.roll(5);
        // normal
        bg.roll(3);
        rollMany(17, 0);
        assertThat(bg.score()).isEqualTo(16);
    }

    void rollMany(int times, int pins) {
        for (int i = 0; i <times; i++) {
            bg.roll(pins);
        }
    }
}
