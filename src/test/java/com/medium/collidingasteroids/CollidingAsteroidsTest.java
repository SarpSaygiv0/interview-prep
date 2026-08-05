package com.medium.collidingasteroids;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollidingAsteroidsTest {

    CollidingAsteroids ca;

    @BeforeEach
    void setCa() {
        ca = new CollidingAsteroids();
    }

    @Test
    public void TestCase1() {
        int[] input = new int[]{-3, 5, -8, 6, 7, -4, -7};
        int[] expected = new int[]{-3, -8, 6};
        int[] actual = ca.collidingAsteroids(input);
        assertThat(actual).isEqualTo(expected);

    }
}
