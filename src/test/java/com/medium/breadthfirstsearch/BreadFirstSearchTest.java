package com.medium.breadthfirstsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BreadFirstSearchTest {

    BreadFirstSearch bfs;

    @BeforeEach
    void setBfs() {
        bfs = new BreadFirstSearch();
    }

    @Test
    void breadFirstSearchTest() {
        BreadFirstSearch.Node graph = new BreadFirstSearch.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        List<String> expected = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
        List<String> inputArray = new ArrayList<>();
        assertThat(graph.breadthFirstSearch(inputArray)).isEqualTo(expected);
    }
}
