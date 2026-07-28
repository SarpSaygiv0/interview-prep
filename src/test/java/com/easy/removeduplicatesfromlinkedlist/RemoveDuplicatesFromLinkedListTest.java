package com.easy.removeduplicatesfromlinkedlist;

import com.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveDuplicatesFromLinkedListTest {
    RemoveDuplicatesFromLinkedList rdfll;

    @BeforeEach
    void setRdfll(){
        rdfll = new RemoveDuplicatesFromLinkedList();
    }

    @Test
    public void TestCase1() {
        LinkedList input = new LinkedList(1);
        input.addMany(
                input, new ArrayList<>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6))
        );
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6));
        LinkedList output = rdfll.removeDuplicatesFromLinkedList(input);
        assertTrue(input.getNodesInArray(output).equals(expectedNodes));
    }
}
