package com.medium.taskassignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskAssignmentTest {

    TaskAssignment ta;

    @BeforeEach
    void setTa() {
        ta = new TaskAssignment();
    }

    @Test
    void taskAssignmentTest() {
        ArrayList<Integer> tasks = new ArrayList<>(List.of(1, 3, 5, 3, 1, 4));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> subList1 = new ArrayList<>(List.of(4, 2));
        ArrayList<Integer> subList2 = new ArrayList<>(List.of(0, 5));
        ArrayList<Integer> sublist3 = new ArrayList<>(List.of(3, 1));
        expected.add(subList1);
        expected.add(subList2);
        expected.add(sublist3);
        assertThat(ta.taskAssignment(2, tasks)).containsAll(expected);
    }

    @Test
    void taskAssignmentTestAlternative() {
        ArrayList<Integer> tasks = new ArrayList<>(List.of(1, 3, 5, 3, 1, 4));
        ArrayList<ArrayList<Integer>> expected = ta.taskAssignmentAlternative(2, new ArrayList<>(tasks));
        assertThat(expected)
                .extracting(pair -> tasks.get(pair.get(0)) + tasks.get(pair.get(1)))
                .containsExactlyInAnyOrder(5, 6, 6);
    }
}
