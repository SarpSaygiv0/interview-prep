package com.medium.moveelementtoend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveElementToEndTest {
    MoveElementToEnd me;

    @BeforeEach
    void setMe() {
        me = new MoveElementToEnd();
    }

    @Test
    void moveElementTest() {
        List<Integer> array =
                new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart =
                new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd =
                new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));
        List<Integer> output = me.moveElementToEndPointers(array, toMove);
        List<Integer> outputStart = output.subList(0, 3);
        outputStart.sort(Comparator.naturalOrder());
        List<Integer> outputEnd = output.subList(3, output.size());
        assertTrue(outputStart.equals(expectedStart));
        assertTrue(outputEnd.equals(expectedEnd));
    }
}
