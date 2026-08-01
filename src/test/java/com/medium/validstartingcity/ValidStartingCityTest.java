package com.medium.validstartingcity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidStartingCityTest {

    ValidStartingCity vsc;

    @BeforeEach
    void setVsc() {
        vsc = new ValidStartingCity();
    }

    @Test
    void validStartingCityTest() {
        int[] distances = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;
        assertThat(vsc.validStartingCity(distances, fuel, mpg)).isEqualTo(4);
    }

    @Test
    void validStartingCityOptimalTest() {
        int[] distances = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;
        assertThat(vsc.validStartingCityOptimal(distances, fuel, mpg)).isEqualTo(4);
    }
}
