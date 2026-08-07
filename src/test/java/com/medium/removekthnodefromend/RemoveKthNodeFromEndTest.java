package com.medium.removekthnodefromend;

import com.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveKthNodeFromEndTest {

    RemoveKthNodeFromEnd rmKthNodeFromEnd;

    @BeforeEach
    void setRmKthNodeFromEnd() {
        rmKthNodeFromEnd = new RemoveKthNodeFromEnd();
    }

    @Test
    void removeKthNodeFromEndTest() {
        LinkedList l1 = new LinkedList(0);
        l1.addMany(l1, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> expected = new ArrayList<>(List.of(0, 1, 2, 3, 5, 6));
        rmKthNodeFromEnd.removeKthNodeFromEnd(l1, 3);
        assertThat(l1.getNodesInArray(l1)).isEqualTo(expected);
    }

    @Test
    void removeHeadAsKthNodeFromEndTest() {
        LinkedList l1 = new LinkedList(0);
        l1.addMany(l1, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> expected = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        rmKthNodeFromEnd.removeKthNodeFromEnd(l1, 7);
        assertThat(l1.getNodesInArray(l1)).isEqualTo(expected);
    }
}
