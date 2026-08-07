package com.medium.sumoflinkedlists;

import com.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfLinkedListsTest {
    SumOfLinkedLists sumOfLls;

    @BeforeEach
    void setSumOfLls() {
        sumOfLls = new SumOfLinkedLists();
    }

    @Test
    void sumOfLinkedListsTest() {
        LinkedList l1 = new LinkedList(2);
        l1.addMany(l1, List.of(4, 7, 1));
        LinkedList l2 = new LinkedList(9);
        l2.addMany(l2, List.of(4, 5));

        LinkedList expected = new LinkedList(1);
        expected.addMany(expected, List.of(9, 2, 2));

        LinkedList actual = sumOfLls.sumOfLinkedLists(l1, l2);
        assertThat(l1.getNodesInArray(actual)).isEqualTo(l1.getNodesInArray(expected));
    }
}
