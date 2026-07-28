package com.easy.classphotos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.easy.classphotos.ClassPhotos.classPhotos;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassPhotosTest {

    ClassPhotos cp;

    @BeforeEach
    void setCp() {
        cp = new ClassPhotos();
    }

    @Test
    public void TestCase1() {
        ArrayList<Integer> redShirtHeights =
                new ArrayList<>(List.of(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights =
                new ArrayList<>(List.of(6, 9, 2, 4, 5));
        boolean expected = true;
        boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
        assertTrue(expected == actual);
    }
}
