package com.medium.insertdeletegetrandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertDeleteGetRandomTest {

    RandomizedSet rs;

    @BeforeEach
    void setInDeGetRandom() {
        rs = new RandomizedSet();
    }

    @Test
    void anElementMovedIntoTheHoleIsStillReachable() {
        rs.insert(10);
        rs.insert(20);
        rs.insert(30);

        assertThat(rs.remove(10)).isTrue();
        assertThat(rs.remove(30)).isTrue();
        assertThat(rs.remove(20)).isTrue();
    }

    @Test
    void removingTheLastElementDoesNotResurrectIt() {
        rs.insert(10);
        rs.insert(20);

        assertThat(rs.remove(20)).isTrue();
        assertThat(rs.remove(20)).isFalse();
        assertThat(rs.getRandom()).isEqualTo(10);
    }
}
